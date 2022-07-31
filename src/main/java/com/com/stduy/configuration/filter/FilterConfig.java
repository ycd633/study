package com.com.stduy.configuration.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<CryptFilter> CryptFilter()
    {
        FilterRegistrationBean<CryptFilter> cyptFilter = new FilterRegistrationBean<>();
        cyptFilter.setFilter(new CryptFilter());
        cyptFilter.addUrlPatterns("/v1/reg");
        cyptFilter.setOrder(1);
        cyptFilter.setName("crypt");
        return cyptFilter;
    }
}
