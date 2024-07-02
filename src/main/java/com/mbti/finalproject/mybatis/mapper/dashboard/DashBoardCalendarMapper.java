package com.mbti.finalproject.mybatis.mapper.dashboard;

import com.mbti.finalproject.domain.calendar.Calendar;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DashBoardCalendarMapper {

   List<Calendar> select();
}
