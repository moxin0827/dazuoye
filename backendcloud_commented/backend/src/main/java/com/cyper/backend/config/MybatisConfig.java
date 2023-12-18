/**
 * MybatisConfig是一个配置类,用于配置Mybatis-Plus
 *
 * MybatisConfig使用了@Configuration注解,表示这是一个配置类
 *
 * MybatisConfig中定义了一个@Bean注解的mybatisPlusInterceptor()方法,该方法返回一个MybatisPlusInterceptor对象
 * MybatisPlusInterceptor是一个Mybatis-Plus的拦截器类,用于拦截Mybatis-Plus的执行过程
 *
 * mybatisPlusInterceptor()方法中添加了一个PaginationInnerInterceptor对象,该对象是Mybatis-Plus的分页插件
 * PaginationInnerInterceptor是Mybatis-Plus的分页插件,用于实现Mybatis-Plus的分页功能
 *
 * 因此,在MybatisConfig中使用@Bean注解的mybatisPlusInterceptor()方法,可以配置Mybatis-Plus的拦截器和分页插件,从而实现分页功能
 */

package com.cyper.backend.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
