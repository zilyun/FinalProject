package com.mbti.finalproject.service.User;

import com.mbti.finalproject.domain.User.User;

import java.util.List;

public interface AdminService {

    void updateUserInfo(int userNum,int departmentId,int positionId);

    List<User> getUsersFilter(int departmentId);

}
