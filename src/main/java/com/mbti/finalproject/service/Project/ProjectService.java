package com.mbti.finalproject.service.Project;

import com.mbti.finalproject.domain.Board.BoardUpfiles;
import com.mbti.finalproject.domain.Project.Project;
import com.mbti.finalproject.domain.Project.ProjectComment;
import com.mbti.finalproject.domain.Project.ProjectMember;
import com.mbti.finalproject.domain.Project.ProjectPeed;
import com.mbti.finalproject.domain.User.User;

import java.util.List;

public interface ProjectService {
    List<String> getAllDepartment();

    List<User> getAllUser(int userNum);

    void createProject(Project project);

    String getUserName(int userNum);

    String getUserProfile(int userNum);

    String getUserDepartment(int userNum);

    String getUserPosition(int userNum);

    void insertMember(List<ProjectMember> members);

    List<Project> getMyProject(int loginNum);

    Project getProject(int projectNum);

    List<ProjectMember> getProjectMember(int projectNum);

    List<String> getProjectDepartment(int projectNum, int userNum);

    List<ProjectMember> searchProjectMember(int projectNum, String searchWord);

    ProjectMember MasterMember(int loginNum);

    void insertPeed(ProjectPeed projectPeed);

    void insertFile(int projectNum, int projectPeedNum, List<BoardUpfiles> files);

    List<ProjectPeed> getProjectPeed(int projectNum);

    int commentsInsert(ProjectComment projectComment);

    List<ProjectComment> getPeedComment(int projectPeedNum, int projectNum);

    int changeType(int type, int peedNum, int projectNum);

    ProjectPeed getOneProjectPeed(int peedNum, int projectNum);

    int[] optionComment(String comment, int loginNum, int peedNum, int projectNum);

    ProjectComment getInsertComment(int commentNum);

    int addCheck(int loginNum, int peedNum, int projectNum);

    int getCheckedPeed(int userNum, int projectPeedNum);

    int deleteCheck(int loginNum, int peedNum, int projectNum);
}
