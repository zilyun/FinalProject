package com.mbti.jhta_3team_finalproject.service.User;

import com.mbti.jhta_3team_finalproject.domain.User.User;

import java.util.List;

public interface AdminService {

    void updateUserInfo(int userNum,int departmentId,int positionId);

    List<User> getUsersFilter(int departmentId);

}
