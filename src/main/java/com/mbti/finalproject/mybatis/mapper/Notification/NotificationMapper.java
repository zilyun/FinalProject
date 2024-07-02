package com.mbti.finalproject.mybatis.mapper.Notification;

import com.mbti.finalproject.domain.Notification.Notification;

import java.util.List;

public interface NotificationMapper {
    List<Notification> getList(int userNum);

    void insert(Notification alarm);

    int readAction(int notifiNum);

    void deleteNotificationUrl(String s);

    int readAll(int userNum);

    int deleteAll(int userNum);
}
