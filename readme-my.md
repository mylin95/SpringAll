### 学习略过列表
- 11.Spring-Boot-Shiro-Authentication
- 12.Spring-Boot-Shiro-RememberMe
- 13.Spring-Boot-Shiro-Authorization
- 14.Spring-Boot-Shiro-Redis
- 15.Spring-Boot-Shiro-Ehcache
- 16.Spring-Boot-Shiro-Thymeleaf-Tag
- 17.Spring-Boot-Shiro-Session

### 笔记
- 18.Spring-Boot-Jackson
    - 此Jackson插件在项目中的用法：
    - 类似FastJson插件作用
    - 很多注解使用，可以结合spring映射字段
- 19.Spring-Boot-Testing
    - 两种test，一种是直接test
    - 另一种：模拟发送http请求（mvc）    
- 20.Spring-Boot-Swagger2
    - swagger-ui的配置类
- 21.Spring-Boot-Actuator
    - 各种应用监控数据，可以通过浏览器GET请求查看
        
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

- [Spring组件注册](https://mrbird.cc/Spring-Bean-Regist.html)
    - Bean名称: **默认为方法名**，我们也可以通过@Bean("myUser")方式来将组件名称指定为myUser
    - 扫描组件并注册: 
        - 使用@ComponentScan注解来扫描组件并注册;
        - 扫描对象：@Controller、@Service、@Repository和@Component注解
        - 我们不能将Spring Boot的入口类纳入扫描范围中，否则项目启动将出错。
    - 懒加载@Lazy
    - 组件作用域@Scope
        - singleton：**单实例（默认）**,在Spring IOC容器启动的时候会调用方法创建对象然后纳入到IOC容器中，以后每次获取都是直接从IOC容器中获取（map.get()）；
        - prototype：多实例，IOC容器启动的时候并不会去创建对象，而是在每次获取的时候才会去调用方法创建对象；
        - request：一个请求对应一个实例；
        - session：同一个session对应一个实例。
    - 条件注册组件: @Conditional注解
    - 导入组件： @Import我们可以快速地往IOC容器中添加组件，Id默认为全类名。
    - 使用FactoryBean注册组件
- [Spring Bean生命周期](https://mrbird.cc/Spring-Bean-Lifecycle.html)
    - @Bean注解方式：@Bean(initMethod = "init", destroyMethod = "destory")
    - 实现接口类InitializingBean & DisposableBean的抽象方法
    - **Bean的实体类内部**：注解方式实现初始化方法(@PostConstruct)、注销方法(@PreDestroy); 这两个注解并非Spring提供，而是JSR250规范提供。
    - Bean后置通知处理器：Bean实现BeanPostProcessor接口的抽象方法
        - postProcessBeforeInitialization在组件的初始化方法调用之前执行
        - postProcessAfterInitialization在组件的初始化方法调用之后执行
- [Spring声明式事务原理](https://mrbird.cc/Spring%E5%A3%B0%E6%98%8E%E5%BC%8F%E4%BA%8B%E5%8A%A1%E5%8E%9F%E7%90%86.html)
    - 启动声明式事务：入口类@EnableTransactionManagement + 事务方法前@Transactional
    - 声明式事务注解源码
    - 声明式事务不生效的两种场景：
        - Service方法抛出的异常不是RuntimeException或者Error类型，并且@Transactional注解上没有指定回滚异常类型。
        - 非事务方法直接通过this调用本类事务方法。
- [深入理解Spring事件发布与监听](https://mrbird.cc/%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3Spring%E4%BA%8B%E4%BB%B6%E5%8F%91%E5%B8%83%E4%B8%8E%E7%9B%91%E5%90%AC.html)
    - 事件发布监听例子-自定义事件: 自定义类继承ApplicationEvent类
    - 事件发布监听例子-事件发布器：自定义类 + @Component + 实现ApplicationEventPublisherAware, ApplicationContextAware接口
    - 事件发布监听例子-注解-监听：自定义类 + @Component + @EventListener
    - 事件发布监听例子-编程-监听：自定义类 + @Component + 实现ApplicationListener<MyEvent>接口（MyEvent是自定义事件类）
    
    
    
    