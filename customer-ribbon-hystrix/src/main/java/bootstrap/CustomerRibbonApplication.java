package bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by JasonFitch on 4/24/2019.
 */
@SpringBootApplication
@ComponentScan({"restful","service","controller"})
@EnableHystrix
public class CustomerRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerRibbonApplication.class, args);
    }


}
