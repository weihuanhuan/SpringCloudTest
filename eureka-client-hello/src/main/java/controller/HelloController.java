package controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by JasonFitch on 4/24/2019.
 */
@RestController
public class HelloController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String hello(@RequestParam(value = "name", defaultValue = "foo") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }
}
