package bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by JasonFitch on 4/24/2019.
 */

@SpringBootApplication
@ComponentScan("controller")

//@EnableEurekaClient
// 这里不注解 EnableEurekaClient 也可以，
// 实际上是自动配置 EurekaDiscoveryClientConfiguration 产生了效果,创建了如下client Marker
// org.springframework.cloud.netflix.eureka.EurekaDiscoveryClientConfiguration.Marker
// 创建条件是：
//    @ConditionalOnClass(EurekaClientConfig.class)
//    @ConditionalOnProperty(value = "eureka.client.enabled", matchIfMissing = true)

// 最终创建 eureka client 的自动配置是 EurekaClientAutoConfiguration 完成的，其启动条件是：
//    @ConditionalOnClass(EurekaClientConfig.class)
//    @ConditionalOnBean(EurekaDiscoveryClientConfiguration.Marker.class)
//    @ConditionalOnProperty(value = "eureka.client.enabled", matchIfMissing = true)
//    @AutoConfigureBefore({ NoopDiscoveryClientAutoConfiguration.class,
//        CommonsClientAutoConfiguration.class, ServiceRegistryAutoConfiguration.class })
//    @AutoConfigureAfter(name = {"org.springframework.cloud.autoconfigure.RefreshAutoConfiguration",
//        "org.springframework.cloud.netflix.eureka.EurekaDiscoveryClientConfiguration",
//        "org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationAutoConfiguration"})

//注意：这里 EurekaClientAutoConfiguration(真正创建客户端) 在 EurekaDiscoveryClientConfiguration(注册事件和健康处理) 之后完成.
// 文件 spring-cloud-netflix-eureka-client-2.0.0.RELEASE.jar!/META-INF/spring.factories 指定了自动配置的实现类

public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

}
