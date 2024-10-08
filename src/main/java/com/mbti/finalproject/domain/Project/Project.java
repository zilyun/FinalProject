package com.mbti.finalproject.domain.Project;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Project {

    private int projectNum;
    private String projectTitle;
    private String projectIntroduce;
    private int masterUserNum;
    private Date projectRegdate;
    private String projectStartPeriod;
    private String projectEndPeriod;

}
