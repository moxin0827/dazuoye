/**
 * SecurityConfig是一个配置类,用于配置Spring Security
 *
 * SecurityConfig使用了@Configuration和@EnableWebSecurity注解,表示这是一个配置类并且启用了Web Security
 *
 * SecurityConfig中定义了一个@Autowired注解的JwtAuthenticationTokenFilter对象,该对象用于处理JWT认证请求
 *
 * SecurityConfig中定义了一个@Bean注解的passwordEncoder()方法,该方法返回一个PasswordEncoder对象,用于对密码进行加密
 *
 * SecurityConfig中定义了一个@Bean注解的authenticationManagerBean()方法,该方法返回一个AuthenticationManager对象,用于管理用户认证
 *
 * SecurityConfig中定义了一个@Override注解的configure(HttpSecurity http)方法,该方法用于配置HTTP安全配置
 *
 * configure(HttpSecurity http)方法中定义了允许所有用户访问注册和获取令牌的URL,允许来自127.0.0.1的请求访问pk/start/game和pk/receive/bot/move,允许所有OPTIONS请求,其余请求需要认证
 *
 * configure(HttpSecurity http)方法中定义了在UsernamePasswordAuthenticationFilter之前添加JWT过滤器
 *
 * SecurityConfig中定义了一个@Override注解的configure(WebSecurity web)方法,该方法用于配置Web Security配置
 *
 * configure(WebSecurity web)方法中定义了忽略websocket请求
 *
 * 因此,SecurityConfig用于配置Spring Security的相关功能,如JWT认证、密码加密、用户认证等
 */

package com.cyper.backend.config;

import com.cyper.backend.config.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 允许所有用户访问注册和获取令牌的URL
                .antMatchers("/api/user/account/token/", "/api/user/account/register/").permitAll()
                // 允许来自127.0.0.1的请求访问pk/start/game和pk/receive/bot/move
                .antMatchers("/pk/start/game/", "/pk/receive/bot/move/").hasIpAddress("127.0.0.1")
                // 允许所有OPTIONS请求
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                // 其余请求需要认证
                .anyRequest().authenticated();

        // 在UsernamePasswordAuthenticationFilter之前添加JWT过滤器
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 忽略websocket请求
        web.ignoring().antMatchers("/websocket/**");
    }
}
