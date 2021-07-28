package com.example.demo.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.core.Ordered;

/**
 * @author MrBird
 * @description 加载应用事件监听器
 * 这里我们以ContextClosedEvent为例子来编写自定义的应用事件监听器，监听Spring上下文关闭事件
 */
public class AfterContextClosedEventListener implements ApplicationListener<ContextClosedEvent>, Ordered {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("AfterContextClosedEvent: " + event.getApplicationContext().getId());
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 1;
    }
}
