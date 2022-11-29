package com.zbz.boot;

import com.zbz.boot.bean.Pet;
import com.zbz.boot.bean.User;
import com.zbz.boot.config.BeanCongfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

//@SpringBootApplication(scanBasePackages = "com.zbz")
@MapperScan("com.zbz.boot.mapper")//mybatis  扫描包
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.zbz")//springboot  扫描注入
public class SpringApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
        Arrays.stream(run.getBeanDefinitionNames()).sorted().forEach(System.out::println);

        Pet tom = run.getBean("tom", Pet.class);
        Pet tom1 = (Pet) run.getBean("tom");
        System.out.println(tom==tom1);
        BeanCongfig congfig = run.getBean(BeanCongfig.class);
        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有。
        //保持组件单实例
        User user1 = congfig.user01();
        User user2 = congfig.user01();
        System.out.println(user1==user2);

        Pet pet = user1.getPet();
        Pet pet1 = congfig.tomCat();
        System.out.println(pet==pet1);
        System.out.println(".............................................");
        //测试@ConfigurationProperties(prefix = "person")，发现第二种pet没有加载到容器中；
       boolean b= run.containsBean("person");
        System.out.println("b = " + b);
        //Object person = run.getBean("person");
       // System.out.println(person);
        boolean c= run.containsBean("pet");
        System.out.println("c = " + c);
     //  System.out.println(run.getBean("pet"));

    }

}
