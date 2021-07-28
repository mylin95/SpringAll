package com.example.demo.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author MrBird
 * @description 加载应用上下文初始器
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HelloApplicationContextInitializer
        implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("ConfigurableApplicationContext.id - " + applicationContext.getId());
    }
}
