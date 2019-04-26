package restful;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by JasonFitch on 4/24/2019.
 */
//配置组件注解下的@bean才会被实例化
@Component
public class RestfulTemplate {

    @Bean
    @LoadBalanced
    // 自动配置类 RibbonAutoConfiguration 完成restful的负载均衡功能，通过向restful添加 LoadBalancerInterceptor 来达到目的，
    // 这个拦截器中持有 LoadBalancerClient 这里这里客户端就是 RibbonLoadBalancerClient, 由此来使用 Ribbon 的负载均衡功能
    // 该配置类的条件如下所示：
    //     @ConditionalOnClass({ IClient.class, RestTemplate.class, AsyncRestTemplate.class, Ribbon.class})
    //     @RibbonClients
    //     @AutoConfigureAfter(name = "org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration"
    //     @AutoConfigureBefore({LoadBalancerAutoConfiguration.class, AsyncLoadBalancerAutoConfiguration.class})

    // 同时该类中还有域LoadBalancerAutoConfiguration.restTemplates，其通过如下注解确定自动装配时需要处理的 restTemplate 目标
    //    @LoadBalanced                   --->   自动装配中的真实需求目标的标记
    //    @Autowired(required = false)    --->   启用自动装配的域
    // 其中 @LoadBalanced 被 @Qualifier 所注解，这个 @Qualifier 才是 Spring 中真正用来标记特定装配 Bean 的注解。

    // 注意 RibbonAutoConfiguration(创建ribbon客户端)
    //         在 LoadBalancerAutoConfiguration(添加restful的LoadBalancerInterceptor) 之前进行，
    //         在 EurekaClientAutoConfiguration(创建Eureka客户端) 之后进行
    // 自动配置指定文件 spring-cloud-netflix-ribbon-2.0.0.RELEASE.jar!/META-INF/spring.factories
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
