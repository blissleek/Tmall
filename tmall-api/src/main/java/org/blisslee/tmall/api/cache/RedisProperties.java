package org.blisslee.tmall.api.cache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author TL
 * @version 1.0.0
 * @since 2020/5/9 16:46
 */
@Component
public class RedisProperties {
    @Value("${redis.host}")
    private String redisHost;

    @Value("${redis.port}")
    private int redisPort;

    @Value("${redis.timeout}")
    private int RedisTimeout;

    @Value("${redis.password}")
    private String redisPassword;

    @Value("${redis.poolMaxTotal}")
    private int redisMaxTotal;

    @Value("${redis.poolMaxIdle}")
    private int redisMaxIdle;

    @Value("${redis.poolMaxWait}")
    private int redisMaxWaitMillis;

    public String getRedisHost() {
        return redisHost;
    }

    public void setRedisHost(String redisHost) {
        this.redisHost = redisHost;
    }

    public int getRedisPort() {
        return redisPort;
    }

    public void setRedisPort(int redisPort) {
        this.redisPort = redisPort;
    }

    public int getRedisTimeout() {
        return RedisTimeout;
    }

    public void setRedisTimeout(int redisTimeout) {
        RedisTimeout = redisTimeout;
    }

    public String getRedisPassword() {
        return redisPassword;
    }

    public void setRedisPassword(String redisPassword) {
        this.redisPassword = redisPassword;
    }

    public int getRedisMaxTotal() {
        return redisMaxTotal;
    }

    public void setRedisMaxTotal(int redisMaxTotal) {
        this.redisMaxTotal = redisMaxTotal;
    }

    public int getRedisMaxIdle() {
        return redisMaxIdle;
    }

    public void setRedisMaxIdle(int redisMaxIdle) {
        this.redisMaxIdle = redisMaxIdle;
    }

    public int getRedisMaxWaitMillis() {
        return redisMaxWaitMillis;
    }

    public void setRedisMaxWaitMillis(int redisMaxWaitMillis) {
        this.redisMaxWaitMillis = redisMaxWaitMillis;
    }
}
