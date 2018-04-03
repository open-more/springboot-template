package org.openmore.coursemore.configuration;

import org.openmore.common.interceptors.CORSInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by michaeltang on 2018/3/23.
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    //对来自/u/** 这个链接来的请求进行拦截
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CORSInterceptor()).addPathPatterns("/**");
    }
}
