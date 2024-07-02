package com.mbti.finalproject.domain.User;

import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
public class AttendanceReqeust {
    private String action;

    public void setAction(String action) {
        this.action = action;
    }
}
