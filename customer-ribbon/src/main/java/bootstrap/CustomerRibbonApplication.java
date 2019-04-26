package bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by JasonFitch on 4/24/2019.
 */
@SpringBootApplication
@ComponentScan({"restful","service","controller"})
// 不需要显示使用这个注解，由自动配置完成, 这是 Spring Cloud Edgware 版本的新特性
// EnableEurekaClient 是 EnableDiscoveryClient 的特例，针对Eureka
//@EnableEurekaClient
//@EnableDiscoveryClient
public class CustomerRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerRibbonApplication.class, args);
    }


}
