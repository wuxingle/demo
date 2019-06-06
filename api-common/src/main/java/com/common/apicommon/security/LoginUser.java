package com.common.apicommon.security;

import com.common.apicommon.Constants;
import com.common.apicommon.model.UserInfoDetail;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.HashSet;

/**
* 登录用户
*
* **/
@Setter
@Getter
public class LoginUser extends UserInfoDetail implements UserDetails {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new HashSet<>();
        if (!CollectionUtils.isEmpty(roles)) {
            roles.forEach(role -> {
                if (role.startsWith("ROLE_")) {
                    collection.add(new SimpleGrantedAuthority(role));
                } else {
                    collection.add(new SimpleGrantedAuthority("ROLE_" + role));
                }
            });
        }
        if (!CollectionUtils.isEmpty(permissions)) {
            permissions.forEach(permission -> {
                collection.add(new SimpleGrantedAuthority(permission));
            });
        }
        return collection;
    }

    @Override
    public String getUsername() {
        return getName() + "|" + getUserType();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return Constants.NO.equalsIgnoreCase(getStatus());
    }
}
