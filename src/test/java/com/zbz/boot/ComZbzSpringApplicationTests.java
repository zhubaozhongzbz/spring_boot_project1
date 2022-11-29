package com.zbz.boot;

import com.zbz.boot.bean.User;
import com.zbz.boot.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.sql.DataSource;
import java.util.Random;

@Slf4j
@SpringBootTest
class ComZbzSpringApplicationTests {
    @Autowired
    DataSource dataSource;
    @Autowired
    UserMapper  userMapper;
    @Test
    void contextLoads() {
    }
    @Test
    void testUserMapper(){
        User user = userMapper.selectById(1);
        log.info("用户信息：{} ",user);
        System.out.println(user);
    }
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Test
    void  testRedis(){
        ValueOperations<String, String> jredis = stringRedisTemplate.opsForValue();

        jredis.set("1","world");
        String hello = jredis.get("1");

        log.info("測試redis: {} ",hello);

        Random random = new Random();
        random.nextInt(10);

    }
}
