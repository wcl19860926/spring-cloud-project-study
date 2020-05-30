package com.study.common.core.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component("redisCacheService")
public class RedisCacheService {

    @Autowired
    @Qualifier("redisTemplate1")
    private RedisTemplate<String, Object> redisTemplate;
    private static RedisCacheService redisCache;

    @PostConstruct
    public void init() {
        redisCache = this;
    }

    public static Object get(String key) {
        if (StringUtils.isEmpty(key)) {
            throw new IllegalArgumentException("key cannot be empty.");
        }
        return redisCache.redisTemplate.opsForValue().get(key);
    }

    public static void set(String key, Object value) {
        if (StringUtils.isEmpty(key)) {
            throw new IllegalArgumentException("key cannot be empty.");
        }
        redisCache.redisTemplate.opsForValue().set(key, value);
    }

    public static void set(String key, Object value, long timeout) {
        if (StringUtils.isEmpty(key)) {
            throw new IllegalArgumentException("key cannot be empty.");
        }
        if (timeout < 0) {
            throw new IllegalArgumentException("timeout cannot be less than zero.");
        }
        redisCache.redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    public static void setHash(String key, String value_key, Object value) {
        if (StringUtils.isEmpty(key)) {
            throw new IllegalArgumentException("key cannot be empty.");
        }
        if (StringUtils.isEmpty(value_key)) {
            throw new IllegalArgumentException("value_key cannot be empty.");
        }
        redisCache.redisTemplate.opsForHash().put(key, value_key, value);
    }

    public static Object getHash(String key, String value_key) {
        if (StringUtils.isEmpty(key)) {
            throw new IllegalArgumentException("key cannot be empty.");
        }
        return redisCache.redisTemplate.opsForHash().get(key, value_key);
    }

    public static List<Object> getHashValues(String key) {
        if (StringUtils.isEmpty(key)) {
            throw new IllegalArgumentException("key cannot be empty.");
        }
        return redisCache.redisTemplate.opsForHash().values(key);
    }

    public static Set<Object> getHashKeys(String key) {
        if (StringUtils.isEmpty(key)) {
            throw new IllegalArgumentException("key cannot be empty.");
        }
        return redisCache.redisTemplate.opsForHash().keys(key);
    }

    public static Map<Object, Object> getHashAll(String key) {
        if (StringUtils.isEmpty(key)) {
            throw new IllegalArgumentException("key cannot be empty.");
        }
        return redisCache.redisTemplate.opsForHash().entries(key);
    }

    public static Long deleteHash(String key, String... value_keys) {
        if (StringUtils.isEmpty(key)) {
            throw new IllegalArgumentException("key cannot be empty.");
        }
        if (value_keys != null && value_keys.length > 0) {
            return redisCache.redisTemplate.opsForHash().delete(key, value_keys);
        }
        return 0L;
    }

    public static Boolean containKey(String key) {
        if (StringUtils.isEmpty(key)) {
            throw new IllegalArgumentException("key cannot be empty.");
        }
        return redisCache.redisTemplate.hasKey(key);
    }

    public static void delete(String key) {
        if (StringUtils.isEmpty(key)) {
            throw new IllegalArgumentException("key cannot be empty.");
        }
        redisCache.redisTemplate.delete(key);
    }

    public static void delete(List<String> keys) {
        if (!CollectionUtils.isEmpty(keys)) {
            redisCache.redisTemplate.delete(keys);
        }
    }

    public static Set<String> keys(String key) {
        return redisCache.redisTemplate.keys(key);
    }

    public static Long getExpireTime(String key) {
        return redisCache.redisTemplate.getExpire(key);
    }


}
