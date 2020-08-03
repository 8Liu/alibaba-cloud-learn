package com.liudehuang.boot.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/3 17:40
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/3 17:40
 * @UpdateRemark:
 * @Version:
 */
@Slf4j
public class RedisTemplateUtil {


    /**
     * 字符串的set方法
     * 相当于set命令
     * @param redisTemplate redisTemplate
     * @param key redisKey
     * @param value 值
     * @return true 设置成功 false 设置失败
     */
    public static boolean set(RedisTemplate redisTemplate, String key, Object value){
        boolean result = false;
        try{
            redisTemplate.opsForValue().set(key, value);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 字符串的set方法
     * 相当于set命令
     * @param redisTemplate redisTemplate
     * @param key redis key
     * @param value 值
     * @param expireTime 过期时间（ttl）
     * @param timeUnit 单位
     * @return true 设置成功 false 设置失败
     */
    public static boolean set(RedisTemplate redisTemplate, String key,
                              Object value, Long expireTime, TimeUnit timeUnit){
        boolean result = false;
        try{
            redisTemplate.opsForValue().set(key, value, expireTime, timeUnit);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 判断当前是否存在Key值，存在则不做任何操作，不存在则set
     * 相当于 setNX命令
     * @param redisTemplate
     * @param key
     * @param value
     * @return
     */
    public static boolean setIfAbsent(RedisTemplate redisTemplate, String key, Object value){
        boolean flag = false;
        try{
            flag = redisTemplate.opsForValue().setIfAbsent(key, value);
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 判断当前是否存在Key值，存在则不做任何操作，不存在则set
     * 相当于 setNX命令
     * @param redisTemplate
     * @param key
     * @param value
     * @param expireTime
     * @param timeUnit
     * @return
     */
    public static boolean setIfAbsent(RedisTemplate redisTemplate, String key, Object value,
                                      Long expireTime, TimeUnit timeUnit){
        boolean flag = false;
        try{
            flag = redisTemplate.opsForValue().setIfAbsent(key, value, expireTime, timeUnit);
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /**
     *
     * @param redisTemplate
     * @param key
     * @param value
     * @return
     */
    public static boolean setIfPresent(RedisTemplate redisTemplate, String key, Object value){
        boolean flag = false;
        try{
            flag = redisTemplate.opsForValue().setIfPresent(key, value);
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
