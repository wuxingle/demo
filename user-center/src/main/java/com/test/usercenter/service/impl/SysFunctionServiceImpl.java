package com.test.usercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.usercenter.entity.SysFunction;
import com.test.usercenter.mapper.SysFunctionMapper;
import com.test.usercenter.service.SysFunctionService;
import org.springframework.stereotype.Service;

@Service
public class SysFunctionServiceImpl extends ServiceImpl<SysFunctionMapper, SysFunction> implements SysFunctionService {
}
