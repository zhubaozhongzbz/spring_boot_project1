package com.zbz.boot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@Slf4j
@SpringBootTest
public class LettuceTest {

    @Autowired
    RedisTemplate  redisTemplate;
    @Test
    void  test(){
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        connection.flushDb();
        ValueOperations valueOperations = redisTemplate.opsForValue();


    }
}
