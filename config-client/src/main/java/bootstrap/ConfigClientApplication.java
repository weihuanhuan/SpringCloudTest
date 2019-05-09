package bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by JasonFitch on 5/5/2019.
 */
@SpringBootApplication
@ComponentScan("controller")
public class ConfigClientApplication {

    public static void main(String[] args) {

        SpringApplication.run(ConfigClientApplication.class, args);
    }
}
