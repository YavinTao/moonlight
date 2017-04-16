/*
 * Author:  taoyang <yavintao@gmail.com>
 * Created: 2017-04-13
 */
package com.github.yavin.moonlight.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// 只能部署到Servlet 3.0 以上的规范容器中，否则只能用web.xml
public class BlogWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // ContextLoaderListener 其他bean, 如驱动后端的中间层，或者数据库层
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootConfig.class};
    }

    // DispatcherServlet 加载包含Web组件的bean，如控制器，视图解析器及多映射处理器
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }

    // 将DispatcherServlet 映射到"/"
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
