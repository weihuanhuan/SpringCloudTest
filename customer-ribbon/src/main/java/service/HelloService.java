package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by JasonFitch on 4/24/2019.
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    public String sayHello(String name) {
        return restTemplate.getForObject("http://EUREKA-CLIENT-HELLO/hello?name=" + name, String.class);
    }
}
