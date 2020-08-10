package com.liudehuang.boot.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;

import java.util.Collection;
import java.util.List;
import java.util.Map;
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

    /*************************************************************redis执行lua脚本*********************************************************/

    public static Object execute(RedisTemplate redisTemplate, RedisScript redisScript, List<String> keys, Object... args){
        return redisTemplate.execute(redisScript, keys, args);
    }

    /*****************************************************字符串****************************************************************/
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

    /**
     *
     * @param redisTemplate
     * @param key
     * @param value
     * @param expireTime
     * @param timeUnit
     * @return
     */
    public static boolean setIfPresent(RedisTemplate redisTemplate, String key, Object value,
                                      Long expireTime, TimeUnit timeUnit){
        boolean flag = false;
        try{
            flag = redisTemplate.opsForValue().setIfPresent(key, value, expireTime, timeUnit);
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 批量存入缓存
     * @param redisTemplate
     * @param map
     * @return
     */
    public static boolean multiSet(RedisTemplate redisTemplate, Map<String, Object> map){
        boolean flag = false;
        try {
            redisTemplate.opsForValue().multiSet(map);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 批量存入redis如果key不存在就存入，否则不存入
     * @param redisTemplate
     * @param map
     * @return
     */
    public static boolean multiSetIfAbsent(RedisTemplate redisTemplate, Map<String, Object> map){
        boolean flag = false;
        try{
            flag = redisTemplate.opsForValue().multiSetIfAbsent(map);
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 获取key值对应的value
     * @param redisTemplate
     * @param key
     * @return
     */
    public static Object get(RedisTemplate redisTemplate, String key){
        Object result = null;
        result = redisTemplate.opsForValue().get(key);
        return result;
    }

    /**
     * 获取redis中的值，并把新值设置进去
     * @param redisTemplate
     * @param key
     * @param value
     * @return
     */
    public static Object getAndSet(RedisTemplate redisTemplate, String key, Object value){
        Object result = null;
        result = redisTemplate.opsForValue().getAndSet(key, value);
        return result;
    }

    /**
     * 批量获取redis中的值
     * @param redisTemplate
     * @param keys
     * @return
     */
    public static List<Object> multiGet(RedisTemplate redisTemplate, Collection<String> keys){
        return redisTemplate.opsForValue().multiGet(keys);
    }

    /**
     * 自增一
     * @param redisTemplate
     * @param key
     * @param expireTime
     * @return
     */
    public static Long incr(RedisTemplate redisTemplate, String key, Long expireTime){
        RedisAtomicLong entityIdCounter = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
        Long increment = entityIdCounter.getAndIncrement();
        entityIdCounter.getAndDecrement();
        if ((null == increment || increment == 0L) && expireTime > 0L) {
            entityIdCounter.expire(expireTime, TimeUnit.SECONDS);
        }
        log.info("自增加一:{}", increment);
        return increment;
    }

    /**
     * 自减一
     * @param redisTemplate
     * @param key
     * @param liveTime
     * @return
     */
    public Long decr(RedisTemplate redisTemplate, String key, long liveTime) {
        RedisAtomicLong entityIdCounter = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
        Long increment = entityIdCounter.getAndDecrement();
        if ((null == increment || increment == 0L) && liveTime > 0L) {
            entityIdCounter.expire(liveTime, TimeUnit.SECONDS);
        }

        log.info("减法:{}", increment);
        return increment;
    }
}
