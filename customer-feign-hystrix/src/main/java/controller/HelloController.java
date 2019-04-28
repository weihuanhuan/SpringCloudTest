package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.HelloFeign;

/**
 * Created by JasonFitch on 4/24/2019.
 */
@RestController
public class HelloController {

    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    HelloFeign helloFeign;

    @GetMapping(value = "/hello")
    public String doHello(@RequestParam String name) {
        return helloFeign.sayHello(name);
    }
}
