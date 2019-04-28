package bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by JasonFitch on 4/28/2019.
 */
@SpringBootApplication
@EnableZuulProxy
public class RouterZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(RouterZuulApplication.class, args);
    }
}
