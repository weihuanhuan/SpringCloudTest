package controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by JasonFitch on 5/9/2019.
 */

@RestController
public class ConfigController {

    @Value("${foo}")
    String foo;

    @RequestMapping(value = "/foo")
    public String getFoo() {
        return foo;
    }
}
