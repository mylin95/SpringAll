### 学习略过列表
- 11.Spring-Boot-Shiro-Authentication
- 12.Spring-Boot-Shiro-RememberMe
- 13.Spring-Boot-Shiro-Authorization
- 14.Spring-Boot-Shiro-Redis
- 15.Spring-Boot-Shiro-Ehcache
- 16.Spring-Boot-Shiro-Thymeleaf-Tag
- 17.Spring-Boot-Shiro-Session

### 笔记
- 26.Spring-Boot-Filter-Interceptor执行顺序
    - filter -> interceptor -> controllerAdvice -> Aspect -> Controller
    - 图片![img](https://mrbird.cc/img/32361-20180530095349427-444141538.png)
- 44.Spring-Boot-AutoConfiguration自动注解
    - 方式一 模式注解：@Component | @Controller | @Service | @Repository
    - 方式二 @Enable模式驱动：
        - 注解驱动：@Configuration + @Bean + @Enable **HelloWorldConfiguration.java + EnableHelloWorld.java + TestEnableBootstap.java**
        - 接口编程：HelloWorldImportSelector.java + EnableHelloWorld.java + TestEnableBootstap.java
    - Spring Boot自动装配：
        - 注解：@Enable + @Import + @ConditionalOnProperty + @Configuration + @Bean + resources\META-INF\spring.factories配置扫描配置文件
        - 类文件：HelloWorldAutoConfiguration.java + EnableHelloWorld.java + HelloWorldConfiguration.java + resources\META-INF\spring.factories配置扫描配置文件
- 45.[Spring-Boot-Application](https://mrbird.cc/deepin-springboot-application.html):
    - 加载顺序：加载应用上下文初始器[initializer] -> 加载应用事件监听器[listener] -> 启动类[runner]
    - SpringApplicationRunListener： **可以监听Spring生命周期**
- 46.[Spring-Boot-Hibernate-Validator](https://mrbird.cc/Spring-Boot-Hibernate-Validator-Params-Check.html):
    - SpringBoot的Controller类中，对接口的参数校验【一般参数校验】、【实体类参数校验】、【全局异常处理】
- 49.[Spring-Boot-Async](https://mrbird.cc/Spring-Boot-Async.html)
    - 自定义异步线程池
        ```java
        @Configuration
        public class AsyncPoolConfig {
        
            @Bean
            public ThreadPoolTaskExecutor asyncThreadPoolTaskExecutor(){
                ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
                executor.setCorePoolSize(20);
                executor.setMaxPoolSize(200);
                executor.setQueueCapacity(25);
                executor.setKeepAliveSeconds(200);
                executor.setThreadNamePrefix("asyncThread");
                executor.setWaitForTasksToCompleteOnShutdown(true);
                executor.setAwaitTerminationSeconds(60);
        
                executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        
                executor.initialize();
                return executor;
            }
        }
        
        @Service
        public class TestService {
        
            @Async("asyncThreadPoolTaskExecutor")
            public void asyncMethod() {
               
            }
        
            @Async("asyncThreadPoolTaskExecutor")
            public Future<String> asyncMethod() {
                sleep();
                logger.info("异步方法内部线程名称：{}", Thread.currentThread().getName());
                return new AsyncResult<>("hello async");
            }
        
        }
        
        
        ```     
    - 通过返回结果我们可以看出Future的get方法为阻塞方法，只有当异步方法返回内容了，程序才会继续往下执行。
    
    
    