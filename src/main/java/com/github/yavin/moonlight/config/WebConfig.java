/*
 * Author:  taoyang <yavintao@gmail.com>
 * Created: 2017-04-13
 */
package com.github.yavin.moonlight.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 1. 视图解析器 如果没配置，默认使用{@link org.springframework.web.servlet.view.BeanNameViewResolver}
 *      会查找ID与视图名称匹配的bean,并且查找到的bean要实现{@link org.springframework.web.servlet.View}接口
 * 2. 组件扫描
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.github.yavin.moonlight")
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 配置jsp视图解析器
     * 根据视图名称，加上前缀和后缀，eg. home -> /WEB-INF/views/home.jsp
     * @return ViewResolver
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/views/");
        resolver.setSuffix(".html");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    /**
     * 配置静态资源的处理
     * 将静态资源的请求转发到servlet容器中默认的Servlet上，而不是DispatcherServlet本身来处理
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
