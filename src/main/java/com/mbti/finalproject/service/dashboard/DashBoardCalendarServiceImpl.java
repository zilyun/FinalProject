package com.mbti.finalproject.service.dashboard;

import com.mbti.finalproject.domain.calendar.Calendar;
import com.mbti.finalproject.mybatis.mapper.dashboard.DashBoardCalendarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DashBoardCalendarServiceImpl implements DashBoardCalendarService {

    private DashBoardCalendarMapper dao;

    @Autowired
    public DashBoardCalendarServiceImpl(DashBoardCalendarMapper dao){
        this.dao= dao;
    }

    @Override
    public List<Calendar> select() {
      return dao.select();
    }
}
