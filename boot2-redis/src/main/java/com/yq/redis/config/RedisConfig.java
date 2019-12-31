package com.yq.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * <p> redis配置</p>
 * @author youq  2019/12/31 11:04
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate ssoRedisTemplate(RedisTemplate redisTemplate) {
        return redisTemplate;
    }

    @Bean
    public RedisTemplate ssoStringRedisTemplate(StringRedisTemplate template) {
        return template;
    }

}
