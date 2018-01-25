package com.kakarot.plcenter;

import redis.clients.jedis.Jedis;

/**
 * @author jinzj
 * @since v4.0.0
 */
public class RedisTest {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.23.172",6379);
        jedis.auth("jin123");
        System.out.println("服务正在运行: "+jedis.ping());
    }
}
