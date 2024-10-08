package com.mbti.finalproject.controller;

import com.mbti.finalproject.domain.chat.ChatMessage;
import com.mbti.finalproject.service.chat.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RedisController {

    private final RedisTemplate<String, String> redisTemplate;
    private final RedisService redisService;

    @RequestMapping("/redisTest/chatMessage")
    public ResponseEntity<?> getRedisChatMessage(ChatMessage chatMessage) {
        List<ChatMessage> list = redisService.getRedisChatMessage(chatMessage);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
