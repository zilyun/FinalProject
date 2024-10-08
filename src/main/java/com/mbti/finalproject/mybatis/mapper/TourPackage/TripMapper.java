package com.mbti.finalproject.mybatis.mapper.TourPackage;

import com.mbti.finalproject.domain.TourPackage.Trip;
import com.mbti.finalproject.domain.TourPackage.TripFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TripMapper {

    int getListCount();

    int getCategoryListCount(String category);

    int getKeywordListCount(String keyword);

    Trip getDetail(int num);

    TripFile getTripFileByNo(String fileNo);

    String getOptionIds(int num);

    List<Trip> getCategoryTripList(int startRow, int endRow, String category,String sort);

    List<Trip> getTripList(int startRow, int endRow, String sort);

    List<Trip> getTripListByKeyword(int startRow, int endRow, String keyword, String sort);

    List<Trip> getAllTrip();

    void insertTrip(String tripName, int tripPrice, int tripStock,int tripMaxStock, String tripDate,String regDate, String expireDate, String tripMainIMG, String tripCategory, String optionIds, String fileId);

    void insertTripFile(String fileId, String mainIMG, String introIMG, String routeIMG, String scheduleIMG, String detailIMG);

    void updateTripStatus(int tripNo, String status);

    List<Trip> getTripByStatus(String Status);

    void updateTravelLeader(int tripNo, int userNo);

    void updateTripStock(int tripNo, int stock);

    void updateTripProgress (int tripNo, int tripProgressNo);

    void updateTrip(Trip trip);

    void updateMainImg(String fileId, String imgUrl);
    void updateIntroImg(String fileId, String imgUrl);
    void updateRouteImg(String fileId, String imgUrl);
    void updateScheduleImg(String fileId, String imgUrl);
    void updateDetailImg(String fileId, String imgUrl);
}

