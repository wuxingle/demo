package com.test.securitycenter.service;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class RedisClientDetailService extends JdbcClientDetailsService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final String CACHE_CLIENT_KEY = "client_details";

    public RedisClientDetailService(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws InvalidClientException {
        ClientDetails clientDetails = null;
        String value = (String) stringRedisTemplate.boundHashOps(CACHE_CLIENT_KEY).get(clientId);
        if (StringUtils.isBlank(value)) {
            clientDetails = cacheAndGetClient(clientId);
        } else {
            clientDetails = JSON.parseObject(value,BaseClientDetails.class);
        }
        return clientDetails;
    }

    private ClientDetails cacheAndGetClient(String clientId) {
        ClientDetails clientDetails = super.loadClientByClientId(clientId);
        if (clientDetails != null) {
            stringRedisTemplate.boundHashOps(CACHE_CLIENT_KEY).put(clientId, JSON.toJSONString(clientDetails));
        }
        return clientDetails;
    }

    public void loadAllClientToCache() {
        if (BooleanUtils.isTrue(stringRedisTemplate.hasKey(CACHE_CLIENT_KEY))) {
            return;
        }
        List<ClientDetails> list = super.listClientDetails();
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        list.parallelStream().forEach(client -> {
            stringRedisTemplate.boundHashOps(CACHE_CLIENT_KEY).put(client.getClientId(), JSON.toJSONString(client));
        });
    }
}
