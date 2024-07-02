package com.mbti.jhta_3team_finalproject.service.User;

import com.mbti.jhta_3team_finalproject.domain.User.User;
import com.mbti.jhta_3team_finalproject.mybatis.mapper.User.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminMapper adminMapper;

    @Autowired
    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public void updateUserInfo(int userNum,int departmentId,int positionId) {
        adminMapper.updateUserInfo(userNum,departmentId,positionId);
    }

    @Override
    public List<User> getUsersFilter(int department_id) {
        return adminMapper.getUsersFilter(department_id);
    }
}

