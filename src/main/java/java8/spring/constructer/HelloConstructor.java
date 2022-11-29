package java8.spring.constructer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloConstructor {
    @RequestMapping("/hello")
    public String hello(){
    return  "hello1";

    };
}
