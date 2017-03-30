# sframe demo
## spring boot 源代码分析
1 判断是否是 web 环境
2 加载所有 classpath 下面的 MATA-INF/spring.factories ApplicationContextIntializer
3 加载所有 classpath 下面的 MATA-INF/spring.factories ApplicationListener
4 推断 main 方法的类
5 开始执行 run 方法
6 设置 java.awt.headless
......


## spring boot war 形式部署：
1 pom中将<packaging>jar</packaging> ==> <packaging>war</packaging>
2 pom中添加tomcat依赖，显示声明scope为provided，这样打包时就不会将tomcat的jar包打到war中
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-tomcat</artifactId>
		<scope>provided</scope>
	</dependency>
3 继承 SpringBootServletInitializer，重写 configure 方法


## spring boot中使用servlet的API
参看 demo.servlet 包
方法一：（servlet3可以使用这种方法）  参考 annotation 包中实现
1：编写servlet，然后加上相应的注解
2：需要启用@ServletComponentScan注解
方法二：（servlet2.5及以下版本可以使用这种方法）   参考 configuration 包中实现
1：编写servlet
2：装配相应的bean到spring容器中
servlet->ServletRegistrationBean
filter ->FilterRegistrationBean
listener -> ServletListenerRegistrationBean

## 事件监听：
参考 demo.event 包
1 自定义事件，一般继承 ApplicationEvent 抽象类
2 定义事件监听器，一般是实现 ApplicationListener 接口
3 启动的时候，需要把监听器加入到 spring 容器中
4 发布事件，使用 ApplicationContext.publishEvent 发布事件

### 配置监听器 3种方法：
1 SpringApplication.addListeners 添加
2 把监听器纳入到 spring 容器中管理，MyApplicationListener 添加注释 @Component
3 使用 context.listener.classes 配置项配置（详细实现参考 DelegatingApplicationListener）
4 使用 @EventListener 注解，在方法上加入 @EventListener 注解，且该类需要纳入到 spring 容器中管理


## 拦截器的使用步骤
参考 demo.interceptor 包
1：写一个拦截器，实现HandlerInterceptor接口
2：写一个类，继承 WebMvcConfigurerAdapter抽象类，然后重写addInterceptors方法，并调用registry.addInterceptor把上一步的拦截器加进去
HandlerInterceptor
preHandle：controller执行之前调用
postHandle：controller执行之后，且页面渲染之前调用
afterCompletion：页面渲染之后调用，一般用于资源清理操作


## AOP开发流程
参考 demo.aop 包
1 spring-boot-starter-aop，加入依赖，默认就开启了AOP的支持
2 写一个Aspect，封装横切关注点（日志，监控等等），需要配置通知（前置通知、后置通知等等）和 切入点（哪些包的哪些类的哪些方法等等）
3 这个Aspect需要纳入到spring容器管理，并且需要加入@Aspect

spring.aop.auto配置项决定是否启用AOP，默认启用
默认是使用基于JDK的动态代理来实现AOP
spring.aop.proxy-target-class=false 或者不配置，表示使用JDK的动态代理
=true表示使用cglib
如果配置了false，而类没有接口，则依然使用cglib


## spring boot 监控
参考 demo.health 包
加载 spring-boot-starter-actuator
http://localhost:8080/beans 查看 spring bean
http://localhost:8080/env   查看目前环境
http://localhost:8080/health    查看环境健康状况，可以自定义监控状态
...


