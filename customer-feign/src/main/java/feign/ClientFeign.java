package feign;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Component;

/**
 * Created by JasonFitch on 4/24/2019.
 */
@Component
@EnableDiscoveryClient
@EnableFeignClients("service")
public class ClientFeign {
}
