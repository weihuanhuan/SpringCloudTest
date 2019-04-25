package feign;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Component;

/**
 * Created by JasonFitch on 4/24/2019.
 */
@Component
@EnableDiscoveryClient
//指定要扫描的feign client的包位置
@EnableFeignClients("service")
public class ClientFeign {
}
