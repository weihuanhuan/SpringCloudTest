package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.HelloService;

/**
 * Created by JasonFitch on 4/24/2019.
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping(value = "/hello")
    public String doHello(@RequestParam String name) {
        return helloService.sayHello(name);
    }
}
