package com.zbz.boot;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

@Slf4j
@SpringBootTest
public class Jredis {
    public static void main(String[] args) throws JSONException {
        Jedis jedis = new Jedis("192.168.208.128", 6379);
        log.info("测试链接是否成功{}",jedis.ping());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","朱宝忠");
        jsonObject.put("age",19);
        String result=jsonObject.toString();
        jedis.set("name","朱宝忠");
        jedis.set("age","19");
        System.out.println(result);
        Transaction multi = jedis.multi();
        try {
            multi.set("person",result);
            multi.incr("age");
            multi.exec();
        } catch (Exception e) {
            multi.discard();//取消事务
            throw new RuntimeException(e);
        } finally {
            multi.close();
        }
        System.out.println("multi = " + jedis.get("person"));
        System.out.println("multi = " + jedis.get("age"));
    }
}
