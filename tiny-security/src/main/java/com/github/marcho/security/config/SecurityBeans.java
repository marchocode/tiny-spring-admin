package com.github.marcho.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class SecurityBeans {

    @Bean
    public CorsFilter corsFilter() {
        return null;
    }

    @Bean
    public TokenFilter tokenFilter() {
        return null;
    }




}
