package feign;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Component;

/**
 * Created by JasonFitch on 4/24/2019.
 */
@Component
@EnableFeignClients("service")
public class ClientFeigns {
}
