package com.mbti.jhta_3team_finalproject.controller;

import com.mbti.jhta_3team_finalproject.domain.User.User;
import com.mbti.jhta_3team_finalproject.service.chat.ChatSseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.security.Principal;

@RestController
public class ChatSseController {
    @Autowired
    private ChatSseService chatSseService;

    @RequestMapping("/chat/sse")
    public SseEmitter streamSse(Principal principal) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User loginuser = (User)authentication.getPrincipal();
        return chatSseService.createEmitter(loginuser.getUserId());
    }
}
