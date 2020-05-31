package org.blisslee.tmall.api.cache;

import org.blisslee.tmall.common.Message;
import org.blisslee.tmall.common.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/9 17:00
 */
@Component
public class RedisService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final JedisPoolWrapper jedisPoolWrapper;

    @Autowired
    public RedisService(JedisPoolWrapper jedisPoolWrapper) {
        this.jedisPoolWrapper = jedisPoolWrapper;
    }


    /**
     * 缓存永久key
     */
    public void cache(String key, String value) throws BusinessException {
        try {
            JedisPool pool = jedisPoolWrapper.getJedisPool();
            if (pool != null) {
                try (Jedis Jedis = pool.getResource()) {
                    Jedis.select(0);
                    Jedis.set(key, value);
                }
            }
        } catch (Exception e) {
            logger.error("Tmall--redis存值失败", e);
            throw new BusinessException(new Message("CM.REDIS_ERROR"));
        }
    }

    /**
     * 获取缓存key
     */
    public String getCacheValue(String key) throws BusinessException {
        String value = null;
        try {
            JedisPool pool = jedisPoolWrapper.getJedisPool();
            if (pool != null) {
                try (Jedis Jedis = pool.getResource()) {
                    Jedis.select(0);
                    value = Jedis.get(key);
                }
            }
        } catch (Exception e) {
            logger.error("Tmall--redis取值失败", e);
            throw new BusinessException(new Message("CM.REDIS_ERROR"));
        }
        return value;
    }

    /**
     * 过期key
     */
    public long cacheNxExpire(String key, String value, int expire) throws BusinessException {
        long result = 0;
        try {
            JedisPool pool = jedisPoolWrapper.getJedisPool();
            if (pool != null) {
                try (Jedis jedis = pool.getResource()) {
                    jedis.select(0);
                    result = jedis.setnx(key, value);
                    jedis.expire(key, expire);
                }
            }
        } catch (Exception e) {
            logger.error("Tmall--redis设值和设置缓存时间失败", e);
            throw new BusinessException(new Message("CM.REDIS_ERROR"));
        }

        return result;
    }

    /**
     * 删除缓存key
     */
    public void deleteKey(String key) throws BusinessException {
        JedisPool pool = jedisPoolWrapper.getJedisPool();
        if (pool != null) {
            try (Jedis jedis = pool.getResource()) {
                jedis.select(0);
                try {
                    jedis.del(key);
                } catch (Exception e) {
                    logger.error("Tmall--redis删除失败", e);
                    throw new BusinessException(new Message("CM.REDIS_ERROR"));
                }
            }
        }
    }

}
