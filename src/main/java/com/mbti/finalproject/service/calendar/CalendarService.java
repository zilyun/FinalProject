package com.mbti.finalproject.service.calendar;

import com.mbti.finalproject.domain.calendar.Calendar;
import java.util.List;

public interface CalendarService {

    public List<Calendar> getlist();

    int insert(Calendar calendar);

    int update(Calendar calendar);

    int resize(Calendar calendar);

    int delete(int cal_id,String user_name);
}
