package com.springboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Package: com.springboot.bean
 * @Description:
 * @Author: linmy
 * @Date: 2021/7/12
 */
@Configuration
public class ConfigurationFile {

    @Bean
    @ConfigurationProperties(prefix = "mrbird.blog")
    public ConfigBean configBean2() {
        return new ConfigBean();
    }

}
