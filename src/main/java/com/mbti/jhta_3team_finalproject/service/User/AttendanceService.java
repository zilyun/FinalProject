package com.mbti.jhta_3team_finalproject.service.User;


import java.util.List;
import java.util.Map;

public interface AttendanceService {

    //전체 직원의 출퇴근 기록을 가져옴
    List<Map<String, Object>> getMonthlyAttendancesForAll(String startDateStr, String endDateStr, int department_id);


}




