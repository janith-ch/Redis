package com.example.redisdemo.Sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserRepository {

    final Logger logger = LoggerFactory.getLogger(UserRepository.class);

    private HashOperations hashOperations;

    public UserRepository(RedisTemplate redisTemplate) {

        this.hashOperations = redisTemplate.opsForHash();
    }

    public void create(User user) {

        hashOperations.put("USER", user.getUserId(), user);

        logger.info(String.format("User with ID %s saved", user.getUserId()));
    }

    public Object get(int userId) {


        return  hashOperations.get("USER", userId);
    }

    public Map<String, User> getAll(){

        return hashOperations.entries("USER");
    }

    public String update(User user) {

        hashOperations.put("USER", user.getUserId(), user);

        logger.info(String.format("User with ID %s updated", user.getUserId()));

        return "User updated with ID "+user.getUserId();
    }

    public String delete(int userId) {

        hashOperations.delete("USER", userId);

        logger.info(String.format("User with ID %s deleted", userId));

        return "User deleted with ID "+userId;
    }
}
