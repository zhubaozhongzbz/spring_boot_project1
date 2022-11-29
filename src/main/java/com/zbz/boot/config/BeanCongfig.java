package com.zbz.boot.config;

import com.zbz.boot.bean.Person;
import com.zbz.boot.bean.Pet;
import com.zbz.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Configuration //这是一个配置类

//@ConditionalOnBean(name ="user")
@EnableConfigurationProperties(Pet.class)
public class BeanCongfig {
    @Bean
    public User user01(){
        return  new User("zhangsan",18,tomCat());
    }
    @Bean("tom")
    public Pet  tomCat(){
        return  new Pet("tomcat");
    }


}
