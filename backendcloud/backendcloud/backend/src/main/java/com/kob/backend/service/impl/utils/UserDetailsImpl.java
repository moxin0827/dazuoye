package com.kob.backend.service.impl.utils;

import com.kob.backend.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
/**
 * 用户详情实现类。
 * 实现了Spring Security的UserDetails接口，用于提供用户认证所需的信息。
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private User user;
    /**
     * 获取用户的权限集合。
     * 在这个实现中，权限集合返回null。
     *
     * @return Collection<? extends GrantedAuthority> 用户的权限集合
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
    /**
     * 获取用户的密码。
     *
     * @return String 用户的密码
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }
    /**
     * 获取用户的用户名。
     *
     * @return String 用户的用户名
     */
    @Override
    public String getUsername() {
        return user.getUsername();
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
        return true;
    }
}
