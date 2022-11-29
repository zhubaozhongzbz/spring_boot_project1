package java8.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainAplication {
    public static void main(String[] args) {

        ConfigurableApplicationContext run=SpringApplication.run(MainAplication.class,args);
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

    }
}
