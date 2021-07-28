package com.example.demo.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author MrBird
 *
    方法名称	                                        对应生命周期	                                    Spring Boot起始版本
    starting()	                                    Spring 应用刚启动	                                    1.0
    environmentPrepared(ConfigurableEnvironment)	ConfigurableEnvironment 准备完毕，允许将其调整	        1.0
    contextPrepared(ConfigurableApplicationContext)	ConfigurableApplicationContext 准备完毕，允许将其调整	1.0
    contextLoaded(ConfigurableApplicationContext)	ConfigurableApplicationContext 已装载，但仍未启动	    1.0
    started(ConfigurableApplicationContext)	        ConfigurableApplicationContext 已启动，此时 Spring Bean 已初始化完成	2.0
    running(ConfigurableApplicationContext)	        Spring 应用正在运行	                                2.0
    failed(ConfigurableApplicationContext,Throwable) Spring 应用运行失败	                                2.0
 */
public class HelloApplicationRunListener implements SpringApplicationRunListener {


    public HelloApplicationRunListener(SpringApplication application, String[] args) {
    }


    @Override
    public void starting() {
        System.out.println("HelloApplicationRunListener starting......");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {

    }

    @Override
    public void started(ConfigurableApplicationContext context) {

    }

    @Override
    public void running(ConfigurableApplicationContext context) {

    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {

    }
}
