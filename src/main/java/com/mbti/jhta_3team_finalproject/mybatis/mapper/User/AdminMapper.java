package com.mbti.jhta_3team_finalproject.mybatis.mapper.User;

import com.mbti.jhta_3team_finalproject.domain.User.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {

    void updateUserInfo(int userNum,int departmentId,int positionId);

    List<User> getUsersFilter(int department_id);
}
