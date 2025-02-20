package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author MrBird
 */
@RestController
public class TestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TestService testService;

    /**
     * 异步方法，没有返回值
     * @throws Exception
     */
    @GetMapping("asyncVoid")
    public void testVoidAsync() throws Exception {
        long start = System.currentTimeMillis();

        testService.asyncVoidMethod();

        long end = System.currentTimeMillis();
        logger.info("总耗时：{} ms", end - start);
    }

    /**
     * 异步方法，存在返回值；取返回值的方法属于同步方法
     * @return
     * @throws Exception
     */
    @GetMapping("async")
    public String testAsync() throws Exception {
        long start = System.currentTimeMillis();
        logger.info("异步方法开始");

        Future<String> stringFuture = testService.asyncMethod();
        // stringFuture.get()是同步方法（阻塞）
        String result = stringFuture.get(60, TimeUnit.SECONDS);
        logger.info("异步方法返回值：{}", result);

        logger.info("异步方法结束");

        long end = System.currentTimeMillis();
        logger.info("总耗时：{} ms", end - start);
        return stringFuture.get();
    }

    @GetMapping("sync")
    public void testSync() {
        long start = System.currentTimeMillis();
        logger.info("同步方法开始");

        testService.syncMethod();

        logger.info("同步方法结束");
        long end = System.currentTimeMillis();
        logger.info("总耗时：{} ms", end - start);
    }

}
