package com.mbti.finalproject.mybatis.mapper.Table;

import com.mbti.finalproject.domain.Board.AnnounceBoard;
import com.mbti.finalproject.domain.User.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AnnounceBoardMapper {
    
    int getListCount(Map<String, String> map);

    List<AnnounceBoard> getBoardList(HashMap<String, Object> map);

    void insertBoard(AnnounceBoard board);

    int setReadCountUpdate(int num);

    AnnounceBoard getDetail(int num);

    int boardDelete(AnnounceBoard announceBoard);

    List<User> getUserData(int annboardNum);

    List<String> getDepartment();

    String targetDepartment(int annboardNum);

    int getMaxCheck(String targetDepartment);

    int checkedUserByDepartment(String targetDepartment, int annboardNum);

    int downImportance(int annboardNum);

    int doTopFix(int annboardNum);

    int topFixClear(int annboardNum);

    int[] searchFixAuth();

    int fixRequest(int annboardNum);

    int requestRefuse(int annboardNum);

    int[] getAllUserData(int userNum, int departmentId);

    String getWriter(int userNum);
}
