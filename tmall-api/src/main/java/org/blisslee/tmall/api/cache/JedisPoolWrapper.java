package org.blisslee.tmall.api.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.PostConstruct;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/9 16:45
 */
@Component
public class JedisPoolWrapper {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RedisProperties redisProperties;

    private JedisPool jedisPool = null;

    @PostConstruct
    public void init(){
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(redisProperties.getRedisMaxTotal());
            config.setMaxIdle(redisProperties.getRedisMaxIdle());
            config.setMaxWaitMillis(redisProperties.getRedisMaxWaitMillis());
            jedisPool = new JedisPool(config, redisProperties.getRedisHost(), redisProperties.getRedisPort(),redisProperties.getRedisTimeout(),redisProperties.getRedisPassword());
            logger.info("Tmall--The redis connection pool was successfully initialized");
        }catch (Exception e){
            logger.error("Tmall--Failed to initialize redis connection pool",e);
        }
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }
}
