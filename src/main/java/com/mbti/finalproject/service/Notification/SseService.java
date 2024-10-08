package com.mbti.finalproject.service.Notification;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public interface SseService {

    public SseEmitter createEmitter(int userNum) ;

    //특정 사용자에게 알림을 보내는 메서드입니다.
    public void sendNotification(int toUserNum, int fromUserNum, String fromUserName, String url, String message) ;

    public int update(String name) ;

    int notificationRead(int notifiNum);

    void deleteNotificationUrl(String s);

    int readAll(int userNum);

    int deleteAll(int userNum);

    //특정 부서와 직급을 받은 사람에게 알림을 보내는 메서드
    void sendByDepartmentAndPosition(int departmentNo, int positionNo, String message, String url);
}
