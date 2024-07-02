package com.mbti.finalproject.domain.Project;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProjectMember {

    private int projectNum;
    private int projectMemberNum;
    private String projectMemberName;
    private String projectMemberProfile;
    private String projectMemberDepartment;
    private String projectMemberPosition;

}
