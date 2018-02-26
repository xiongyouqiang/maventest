package com.xyq.maventest.redis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisJava {

	private static Jedis jedis;

	public static void main(String[] args) {
        jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务器正在运行: "+jedis.ping());
        
        //设置name = xiongyouqiang
        String key = "name";
        jedis.set(key, "xiongyouqiang");
        
        //get name
        System.out.println("*************key value存储方式.*************");
        System.out.println("redis 存储的字符串为:"+jedis.get(key));;
        
        //存储数据到列表中
        jedis.lpush("db-list", "Redis");
        jedis.lpush("db-list", "Mongodb");
        jedis.lpush("db-list", "Mysql");
        
        // 获取存储的数据并输出
        System.out.println("**********list存储方式.*************");
        List<String> list = jedis.lrange("db-list", 0 ,2);
        for(int i=0; i<list.size(); i++) {        
          System.out.println("列表项为: "+list.get(i));      
        }  
        
        
        //获取数据并输出
        Set<String> keys= jedis.keys("*");
        System.out.println("*************打印所有的key*************");
        Iterator<String> it=keys.iterator();
        while(it.hasNext()) {   
          String keyStr=it.next();     
          System.out.println(keyStr);     
        }    
        
    }
}
