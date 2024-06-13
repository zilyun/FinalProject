package com.example.jhta_3team_finalproject.mybatis.mapper.User;


import com.example.jhta_3team_finalproject.domain.User.Attendence;
import com.example.jhta_3team_finalproject.domain.User.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    public User getUserDetails(String userId);

    public User getUserId(String id);

    User departmentPositionInfo(int department_id, int position_id);

    public int join(User user);

    public User user_info(int num);

    public int userupdate(User user);

    public int insert(User user);

    public int getListCount();

    public User getEmployee(int userNum);



}