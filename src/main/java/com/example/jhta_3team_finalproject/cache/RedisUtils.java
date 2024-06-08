package com.example.jhta_3team_finalproject.cache;

import com.example.jhta_3team_finalproject.domain.chat.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Service
public class RedisUtils {

    private final RedisTemplate<String, ChatMessage> redisTemplate;

    public void setExpired(String key, Long expiredTime) {
        redisTemplate.expire(key, expiredTime, TimeUnit.DAYS);
    }

    public void setAddSets(String key, ChatMessage value) {
        redisTemplate.opsForSet().add(key, value);
    }

    public Set<ChatMessage> getSets(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    public boolean isKeyExists(String key) {
        return redisTemplate.hasKey(key);
    }

    public void setUpdateSets(String key, ChatMessage oldValue, ChatMessage newValue) {
        redisTemplate.opsForSet().remove(key, oldValue);
        redisTemplate.opsForSet().add(key, newValue);
    }

    public void setData(String key, ChatMessage value, Long expiredTime){
        redisTemplate.opsForValue().set(key, value, expiredTime, TimeUnit.DAYS);
    }

    public ChatMessage getData(String key){
        return (ChatMessage) redisTemplate.opsForValue().get(key);
    }

    public void deleteData(String key){
        redisTemplate.delete(key);
    }
}
