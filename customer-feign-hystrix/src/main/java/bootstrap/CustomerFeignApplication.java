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
@ComponentScan({"feign","service", "controller"})
public class CustomerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerFeignApplication.class, args);
    }
}
