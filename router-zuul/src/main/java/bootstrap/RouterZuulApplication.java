package bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by JasonFitch on 4/28/2019.
 */
@SpringBootApplication
@EnableZuulProxy
@ComponentScan("filter")
public class RouterZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(RouterZuulApplication.class, args);
    }
}
