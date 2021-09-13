package com.example.redisdemo.Sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class Config {
    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.getStandaloneConfiguration().setHostName("localhost");
        jedisConnectionFactory.getStandaloneConfiguration().setPort(16379);
        jedisConnectionFactory.getStandaloneConfiguration().setPassword("mypass");
        jedisConnectionFactory.getStandaloneConfiguration().setDatabase(0);
        jedisConnectionFactory.afterPropertiesSet();
        return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate redisTemplate() {
        RedisTemplate<String, User> redisTemplate = new RedisTemplate<String, User>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

}