package bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by JasonFitch on 4/24/2019.
 */

@SpringBootApplication
// 实际上 EnableEurekaServer 注解import了 EurekaServerMarkerConfiguration 配置类，并创建了server Marker
// org.springframework.cloud.netflix.eureka.server.EurekaServerMarkerConfiguration.Marker
// 而这个Marker便是 EurekaServerAutoConfiguration 工作的条件，条件如下：
//    @Import(EurekaServerInitializerConfiguration.class)
//    @ConditionalOnBean(EurekaServerMarkerConfiguration.Marker.class)
// 最后这里，这里import的 EurekaServerInitializerConfiguration 类启动了 Eureka Server.

// 自动配置类由文件 spring-cloud-netflix-eureka-server-2.0.0.RELEASE.jar!/META-INF/spring.factories 指定
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
