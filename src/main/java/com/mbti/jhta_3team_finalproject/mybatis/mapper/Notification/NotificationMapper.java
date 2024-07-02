package com.mbti.jhta_3team_finalproject.mybatis.mapper.Notification;

import com.mbti.jhta_3team_finalproject.domain.Notification.Notification;

import java.util.List;

public interface NotificationMapper {
    List<Notification> getList(int userNum);

    void insert(Notification alarm);

    int readAction(int notifiNum);

    void deleteNotificationUrl(String s);

    int readAll(int userNum);

    int deleteAll(int userNum);
}
