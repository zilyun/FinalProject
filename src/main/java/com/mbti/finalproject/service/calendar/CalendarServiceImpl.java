package com.mbti.finalproject.service.calendar;


import com.mbti.finalproject.domain.calendar.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mbti.finalproject.mybatis.mapper.calendar.CalendarMapper;
import java.util.List;

@Service
public class CalendarServiceImpl implements CalendarService{

    private CalendarMapper dao;

    @Autowired
    public CalendarServiceImpl(CalendarMapper dao){
        this.dao = dao;
    }


    @Override
    public List<Calendar> getlist() {

        return dao.getlist();
    }


    @Override
    public int insert(Calendar calendar) {
        return dao.insert(calendar);

    }

    @Override
    public int update(Calendar calendar) {
        return dao.update(calendar);
    }

    @Override
    public int resize(Calendar calendar) {
        return dao.resize(calendar);
    }

    @Override
    public int delete(int cal_id, String user_name) {
        return dao.delete(cal_id,user_name);
    }
}
