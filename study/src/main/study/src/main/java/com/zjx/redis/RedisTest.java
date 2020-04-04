package com.zjx.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @author zhaojiaxing
 * @date 2020-03-27 21:19
 */
public class RedisTest {
    @Test
    public void jedis(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.set("a","张三王五");
        jedis.close();
    }

    @Test
    public void get(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        String s = jedis.get("a");
        jedis.close();
        System.out.println(s);
    }

    @Test
    public void myJedis() throws Exception{
        MyJedis jedis = new MyJedis();
        jedis.set("b","张三王五");
    }

    @Test
    public void myGet() throws Exception{
        MyJedis jedis = new MyJedis();
        String s = jedis.get("b");
        System.out.println(s);
    }
}
