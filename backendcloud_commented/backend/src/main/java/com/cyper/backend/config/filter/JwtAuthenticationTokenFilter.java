/**
 * JwtAuthenticationTokenFilter是一个过滤器,用于处理基于JWT的认证请求
 *
 * 过滤器在每次请求到来时都会被调用一次,其主要目的是从请求头中获取JWT令牌,然后解析该令牌以获取用户ID,
 * 最后根据用户ID查询数据库中的用户信息,并将用户信息封装成UsernamePasswordAuthenticationToken对象,
 * 放入Spring Security上下文中,以便后续认证操作使用。
 *
 * 该过滤器首先检查请求头中是否存在"Authorization"头,并且以"Bearer "开头,如果不存在或不是以"Bearer "开头,则直接放行。
 * 然后从"Authorization"头中获取JWT令牌,并解析该令牌以获取用户ID。
 * 接着根据用户ID查询数据库中的用户信息,如果查询不到用户,则抛出异常。
 * 最后创建一个UsernamePasswordAuthenticationToken对象,将用户信息封装到其中,并放入Spring Security上下文中,
 * 从而实现基于JWT的认证功能。
 *
 * @auther 张恒嘉
 * @date 2023/11/10
 */
package com.cyper.backend.config.filter;

import com.cyper.backend.mapper.UserMapper;
import com.cyper.backend.pojo.User;
import com.cyper.backend.service.impl.utils.UserDetailsImpl;
import com.cyper.backend.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private UserMapper userMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) throws ServletException, IOException {
        // 从请求头中获取token
        String token = request.getHeader("Authorization");

        // 如果token不存在或者不是以Bearer开头，则直接放行
        if (!StringUtils.hasText(token) || !token.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // 从token中获取用户id
        token = token.substring(7);

        String userid;
        try {
            // 解析token
            Claims claims = JwtUtil.parseJWT(token);
            userid = claims.getSubject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 根据用户id查询用户
        User user = userMapper.selectById(Integer.parseInt(userid));

        // 如果查询不到用户，则抛出异常
        if (user == null) {
            throw new RuntimeException("用户名未登录");
        }

        // 创建用户详情对象
        UserDetailsImpl loginUser = new UserDetailsImpl(user);
        // 创建认证令牌
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginUser, null, null);

        // 将认证令牌放入安全上下文
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        // 放行
        filterChain.doFilter(request, response);
    }
}
