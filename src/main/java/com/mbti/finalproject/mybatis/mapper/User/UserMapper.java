package com.mbti.finalproject.mybatis.mapper.User;


import com.mbti.finalproject.domain.User.User;
import org.apache.ibatis.annotations.Mapper;

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

    //신규사원 요청 처리

    List<Map<String, Object>> getUsersFilter(); //신입사원 모든 요청

    void approveUserWithDepartmentAndPosition(int userNum,int departmentId,int positionId); //사용자 승인

    void rejectUser(int userNum); //사용자 거절

    int[] getUsersByDepartmentAndPosition(int departmentId, int positionId);

    List<User> getEmployeeListByDepartment(int departmentId);

    User getUserByUserNo(int userNo);

    void projectMemberUpdate(int userNum, String userProfilePicture, String userName);
}