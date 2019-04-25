package service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by JasonFitch on 4/24/2019.
 */
@FeignClient("eureka-client-hello")
public interface HelloService {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String sayHello(@RequestParam(value = "name") String name);
}
