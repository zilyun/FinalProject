package com.mbti.finalproject.controller;//package com.example.jhta_3team_finalproject.controller;

import com.mbti.finalproject.domain.chat.ChatMessage;
import com.mbti.finalproject.service.chat.RabbitMQService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@Controller
public class RabbitMQController {

    private final RabbitMQService rabbitMQService;

    @RequestMapping("/chat/emergency")
    public void sendMessage(ChatMessage chatMessage) throws Exception {
        this.rabbitMQService.sendMessage(chatMessage);
    }

}
