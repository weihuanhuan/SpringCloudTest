package service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by JasonFitch on 4/24/2019.
 */
//Spring Ioc不会扫描接口的内部类作为Bean注入Ioc
//@Component
@FeignClient(value = "eureka-client-hello", fallback = HelloFeign.HelloFeignHystric.class)
public interface HelloFeign {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String sayHello(@RequestParam(value = "name") String name);

    // HelloFeignHystric 需要实现 HelloFeign 接口，并注入到Ioc容器中才能作为 fallback 的目标类去使用, 否则有如下异常产生。
//    Caused by: java.lang.IllegalStateException: No fallback instance of type class service.HelloFeign$HelloFeignHystric found for feign client eureka-client-hello
//          at org.springframework.cloud.openfeign.HystrixTargeter.getFromContext(HystrixTargeter.java:93) ~[spring-cloud-openfeign-core-2.0.0.RELEASE.jar:2.0.0.RELEASE]
//          at org.springframework.cloud.openfeign.HystrixTargeter.targetWithFallback(HystrixTargeter.java:85) ~[spring-cloud-openfeign-core-2.0.0.RELEASE.jar:2.0.0.RELEASE]
//          at org.springframework.cloud.openfeign.HystrixTargeter.target(HystrixTargeter.java:49) ~[spring-cloud-openfeign-core-2.0.0.RELEASE.jar:2.0.0.RELEASE]
//          at org.springframework.cloud.openfeign.FeignClientFactoryBean.loadBalance(FeignClientFactoryBean.java:223) ~[spring-cloud-openfeign-core-2.0.0.RELEASE.jar:2.0.0.RELEASE]
//          at org.springframework.cloud.openfeign.FeignClientFactoryBean.getObject(FeignClientFactoryBean.java:244) ~[spring-cloud-openfeign-core-2.0.0.RELEASE.jar:2.0.0.RELEASE]
    @Component
    class HelloFeignHystric implements HelloFeign {
        @Override
        public String sayHello(String name) {
            return "hello, "+name+", sorry, i'm from feign hystrix!";
        }
    }
}
