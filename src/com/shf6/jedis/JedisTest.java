package com.shf6.jedis;

import com.shf6.utils.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisTest {
    @Test
    public void test1(){
//        1.获取连接
        Jedis jedis = new Jedis("localhost", 6379);
//        2.操作
        jedis.set("username","zhangsan");
//        3.关闭连接
        jedis.close();
    }

    @Test
    public void test2(){
//        1.获取连接
        Jedis jedis = new Jedis();
//        2.操作
        String username = jedis.set("username", "zhangsan");
        System.out.println(username);

//        20秒后自动过期并删除
        jedis.setex("activecode",20,"hehe");
//        3.关闭连接
        jedis.close();
    }

    @Test
    public void test3(){
//        1.获取连接
        Jedis jedis = new Jedis();
//        2.操作
//        存储hash
        jedis.hset("user","name","lisi");
        jedis.hset("user","age","23");
        jedis.hset("user","gender","male");

//        获取hash
        String name = jedis.hget("user", "name");
        System.out.println(name);

        Map<String, String> user = jedis.hgetAll("user");
        Set<String> keySet = user.keySet();
        for (String s : keySet) {
            String s1 = user.get(s);
            System.out.println(s1);
        }

//        3.关闭连接
        jedis.close();
    }

    @Test
    public void test4(){
//        1.获取连接
        Jedis jedis = new Jedis();
//        2.操作
        jedis.lpush("mylist","a","b","c");
        jedis.rpush("mylist","a","b","c");

//        list获取
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        String element1 = jedis.lpop("mylist");
        System.out.println(mylist);

//        3.关闭连接
        jedis.close();
    }

    @Test
    public void test5(){
//        1.获取连接
        Jedis jedis = new Jedis();
//        2.操作
        jedis.sadd("myset","java","php");
//        set获取
        for (String myset : jedis.smembers("myset")) {
            System.out.println(myset);
        }
//        3.关闭连接
        jedis.close();
    }

    @Test
    public void test6(){
//        1.获取连接
        Jedis jedis = new Jedis();
//        2.操作
        jedis.zadd("mysortdset",3,"亚瑟");
        jedis.zadd("mysortdset",30,"后裔");
        jedis.zadd("mysortdset",25,"孙悟空");
        for (String s : jedis.zrange("mysortdset", 0, -1)) {
            System.out.println(s);
        }

//        3.关闭连接
        jedis.close();
    }

    @Test
    public void test7(){
//        0.创建一个配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(50);
        jedisPoolConfig.setMaxIdle(10);

//        1.创建jedis连接池对象
        JedisPool jedisPool = new JedisPool();
//        2.获取连接
        Jedis jedis = jedisPool.getResource();
//        3.使用
        jedis.set("hehe","haha");
//        4.关闭 归还到连接池中
        jedis.close();
    }

    @Test
    public void test8(){
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.set("hello", "hello");
//        4.关闭 归还到连接池中
        jedis.close();
    }
}
