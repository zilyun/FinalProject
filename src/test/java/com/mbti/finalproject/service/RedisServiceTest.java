package com.mbti.finalproject.service;//package com.example.jhta_3team_finalproject.service;

import com.mbti.finalproject.cache.RedisChatUtils;
import com.mbti.finalproject.domain.chat.ChatMessage;
import com.mbti.finalproject.mybatis.mapper.chat.ChatMapper;
import com.mbti.finalproject.service.chat.RedisService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;

@SpringBootTest
class RedisServiceTest {

    private final static Logger log = LoggerFactory.getLogger(RedisServiceTest.class);


    @Autowired
    private ChatMapper chatMapper;
    @Autowired
    RedisService redisService;
    @Autowired
    RedisTemplate<String, ChatMessage> redisTemplate;
    @Autowired
    RedisChatUtils redisChatUtils;

    @Test
    void 레디스_테스트() {

        /**
         * given - 1주일 전 데이터, 5번 채팅방 세팅, LocalDate로 변경
         */
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now().minusDays(7);
        LocalTime localTime = LocalTime.of(0, 0, 0);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        Date oneWeekAgoDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        String oneWeekAgoDateStr = simpleDateFormat.format(oneWeekAgoDate);
        log.info("{}", oneWeekAgoDate);
        log.info("1주일 전은 {} 입니다.", oneWeekAgoDateStr);
        List<ChatMessage> chatMessageList = redisService.getRedisChatMessage(new ChatMessage());
        log.info("getChatMessage");

        /**
         * when - RDB -> Redis 로 삽입
         */
        chatMessageList.forEach(chatMessage -> {
            //log.info("chatMessage: {}", chatMessage);
            String roomKey = String.valueOf(chatMessage.getChatRoomNum());
            ChatMessage value = chatMessage;
            String dateKey = simpleDateFormat.format(chatMessage.getSendTime());
            String key = roomKey + ":" + dateKey; // 방번호:날짜
            Long expiredTime = 1L; // 만료 시간 1주일 부여
            redisChatUtils.setAddList(key, value);
            redisChatUtils.setExpired(key, expiredTime);
        });

        /**
         * then - 1주일 전까지를 키로 검색하여 가져오기
         * String key = "5:2024-06-04"; // 방번호:날짜
         */
        String key = "5:2024-06-04";
        List<ChatMessage> chatList = redisChatUtils.getList(key);
        chatList.forEach(chatMessage -> {
            log.info("{}", chatMessage);
        });
    }
}