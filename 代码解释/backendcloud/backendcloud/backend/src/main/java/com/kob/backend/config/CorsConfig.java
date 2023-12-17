/**
 * CorsConfig是一个配置类,用于配置CORS(跨域资源共享)
 *
 * CorsConfig实现了Filter接口,重写了doFilter方法,该方法在每次请求到来时被调用,用于处理跨域请求
 *
 * doFilter方法中首先获取请求头中的Origin,如果存在Origin,则设置响应头中的Access-Control-Allow-Origin
 * 接着获取请求头中的Access-Control-Request-Headers,如果存在Access-Control-Request-Headers,则设置响应头中的Access-Control-Allow-Headers和Access-Control-Expose-Headers
 * 最后设置响应头中的Access-Control-Allow-Methods、Access-Control-Max-Age、Access-Control-Allow-Credentials,并执行过滤器链
 *
 * init和destroy方法为空实现,因为CORS不需要在实例化时进行初始化,也不需要在销毁时进行清理
 * @auther 张恒嘉
 * @date 2023/11/10
 */
package com.kob.backend.config;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class CorsConfig implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;

        // 获取请求头中的Origin
        String origin = request.getHeader("Origin");
        // 如果存在Origin，则设置响应头中的Access-Control-Allow-Origin
        if(origin!=null) {
            response.setHeader("Access-Control-Allow-Origin", origin);
        }

        // 获取请求头中的Access-Control-Request-Headers
        String headers = request.getHeader("Access-Control-Request-Headers");
        // 如果存在Access-Control-Request-Headers，则设置响应头中的Access-Control-Allow-Headers和Access-Control-Expose-Headers
        if(headers!=null) {
            response.setHeader("Access-Control-Allow-Headers", headers);
            response.setHeader("Access-Control-Expose-Headers", headers);
        }

        // 设置响应头中的Access-Control-Allow-Methods、Access-Control-Max-Age、Access-Control-Allow-Credentials
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        // 执行过滤器链
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void destroy() {
    }
}