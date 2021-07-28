package com.example.demo.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author MrBird
 * @description 加载应用事件监听器
 * 这里我们以ContextClosedEvent为例子来编写自定义的应用事件监听器，监听Spring上下文关闭事件
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("ContextClosedEvent: " + event.getApplicationContext().getId());
    }
}
