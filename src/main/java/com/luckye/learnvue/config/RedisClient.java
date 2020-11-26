package com.luckye.learnvue.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.concurrent.TimeUnit;

@Component
public class RedisClient {

    public static final long TOKEN_EXPIRES_SECOND = 1800;
    @Autowired
    private StringRedisTemplate redisTpl;

    /**
     * 向redis中设置值
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key,String value){
        boolean result =false;
        try {
            redisTpl.opsForValue().set(key,value);
            result=true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return  result;
    }

    /**
     * 设置记时
     * @param key
     * @param value
     * @param time
     * @return
     */
    public boolean set(String key ,String value ,long time){
        boolean result=false;
        try {
            redisTpl.opsForValue().set(key,value);
            expire(key,time);
            result=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return  result;
    }

    /**
     * 设置过期时间
     * @param key
     * @param time
      */
    private boolean expire(String key, long time) {
        boolean result=false;
        try {
            if(time>0){
                redisTpl.expire(key,time, TimeUnit.SECONDS);
                result=true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public  String get(String key){

        String value = redisTpl.opsForValue().get(key);
        return value;
    }

    /**
     * 移除key
     * @return
     */
    public boolean remove (String key){
        boolean result =false;

        try {
            redisTpl.delete(key);
            result=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


}
