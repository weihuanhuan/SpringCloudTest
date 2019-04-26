package feign;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Component;

/**
 * Created by JasonFitch on 4/24/2019.
 */
//指定为Spring组件来标识为Spring需要扫描的类，否则即使指定了这个包为扫描路径也不会扫描这个类
@Component
//指定要扫描的feign client的包位置
@EnableFeignClients("service")
//该注解会依据指定的包位置并通过引入 FeignClientsRegistrar 查找标记了 @FeignClient注解的接口，并将其定义为一个 FeignClient 的 FeignClientFactoryBean
//最终Spring 使用 FeignClientFactoryBean 类来生成真正的 FeignClient 供调用方使用，这是一个代理对象, 产生于feign.ReflectiveFeign.newInstance()

// 自动配置类 FeignRibbonClientAutoConfiguration 存在如下注解条件：
//    @ConditionalOnClass({ ILoadBalancer.class, Feign.class })
//    @AutoConfigureBefore(FeignAutoConfiguration.class)
//    @Import({ HttpClientFeignLoadBalancedConfiguration.class,
//            OkHttpFeignLoadBalancedConfiguration.class,
//            DefaultFeignLoadBalancedConfiguration.class })

// 注意这里 FeignRibbonClientAutoConfiguration(是否使用Ribbon作为负载均衡) 在 FeignAutoConfiguration(提供FeignContext) 之前，
// 同时最后import DefaultFeignLoadBalancedConfiguration(创建LoadBalancerFeignClient)

//文件 spring-cloud-openfeign-core-2.0.0.RELEASE.jar!/META-INF/spring.factories 指定Feign的自动配置实现类

public class ClientFeigns {
}
