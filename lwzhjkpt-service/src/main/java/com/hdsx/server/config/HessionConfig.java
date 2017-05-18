package com.hdsx.server.config;


import com.hdsx.hession.servlet.HessianHttpRequestHandlerServlet;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Created by zhaod on 2017/5/17.
 */
@Configuration
@ImportResource(locations={"classpath:hessian-simple.xml"})
public class HessionConfig {
    @Bean
    public DispatcherServlet getDis(WebApplicationContext webApplicationContext){
        return new DispatcherServlet(webApplicationContext);
    }
    @Bean
    public ServletRegistrationBean regHttpRequestHandlerServlet(){
        ServletRegistrationBean registration = new ServletRegistrationBean(new HessianHttpRequestHandlerServlet());
        registration.setName("remote");
        registration.setEnabled(true);
        registration.addUrlMappings("/*");
        return registration;
    }

}
