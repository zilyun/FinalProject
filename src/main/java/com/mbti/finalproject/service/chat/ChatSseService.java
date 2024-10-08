package com.mbti.finalproject.service.chat;

import com.mbti.finalproject.domain.User.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Transactional
@Slf4j
@RequiredArgsConstructor
@Service
public class ChatSseService {

    private final Map<String, SseEmitter> emitters = new ConcurrentHashMap<>();

    /*
      SseEmitter를 사용하여 Server-Sent Events (SSE)를 생성하는 메서드입니다.
      SSE는 서버에서 클라이언트로 데이터를 스트리밍하는 데 사용됩니다.
     */
    public SseEmitter createEmitter(String userId) {
        //userId에 해당하는 SSEEmitter를 생성합니다.
        //SseEmitter emitter = new SseEmitter();
        SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);

        //생성된 emitter를 this.emitters 맵에 저장합니다. 맵은 userId를 키로 사용하고, 생성된 emitter를 값으로 갖습니다.
        this.emitters.put(userId, emitter);

        // emitter의 완료 이벤트와 타임아웃 이벤트가 발생할 때마다 해당 userId에 해당하는 emitter를 맵에서 제거하는 작업을 수행합니다.
        emitter.onCompletion(() -> {
            this.emitters.remove(userId);
            log.info("onCompletion()");
        });
        emitter.onTimeout(() -> {
            this.emitters.remove(userId);
            log.info("onTimeout()");
        });

        //503에러를 방지하기 위한 더미 이벤트 전송
        try {
            //알림은 emitter.send() 메서드를 사용하여 전송됩니다.
            //SseEmitter.event().name("notification").data(message)를 사용하여 이름이 "notification"이고
            //데이터가 message인 이벤트를 생성하고 전송합니다.

            emitter.send(SseEmitter.event().name("notification").data(""));

        } catch (IOException e) {
            //전송 중 예외가 발생하면(IOException), 해당 emitter를 에러 상태로 완료합니다.
            emitter.completeWithError(e);
        }
        return emitter;
    }

    /**
     * 2024-06-14, 채팅 메시지가 전송되는 경우, 채팅방 리스트가 갱신되도록 구현
     */
    public void chatRoomListRefresh(User user, String message) {
        //userId를 사용하여 this.emitters 맵에서 해당 사용자에 대한 SseEmitter를 가져옵니다.
        SseEmitter emitter = this.emitters.get(user.getUserId());

        //가져온 emitter가 null이 아닌 경우, 즉 해당 사용자에게 SseEmitter가 존재하는 경우에만 알림을 전송합니다.
        if (emitter != null) {
            try {
                //알림은 emitter.send() 메서드를 사용하여 전송됩니다.
                //SseEmitter.event().name("notification").data(message)를 사용하여 이름이 "notification"이고
                //데이터가 message인 이벤트를 생성하고 전송합니다.
                emitter.send(SseEmitter.event().name("chatListRoomRefresh").data(message));

            } catch (IOException e) {
                //전송 중 예외가 발생하면(IOException), 해당 emitter를 에러 상태로 완료합니다.
                emitter.completeWithError(e);
            }
        }
    }
}
