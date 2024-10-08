package com.mbti.finalproject.service.TourPackage;


import com.mbti.finalproject.domain.TourPackage.Trip;
import com.mbti.finalproject.domain.TourPackage.TripFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


public interface TripService {



    public Trip getDetail(int num);

    public TripFile getTripFileByNo(String fileNo);

    public String getOptionIds(int num);

    List<Trip> getAllTrip();

    void saveTrip(Trip trip,MultipartFile[] images) throws IOException;

    void updateTrip(Trip trip, MultipartFile[] images) throws IOException;

    List<Trip> getApprovedTrip();

    List<Trip> getPendingTrip();

    void updateTripStatus(int tripNo, String status);

    boolean updateTravelLeader(int tripNo, int userNo);

    boolean updateTripStock(int tripNo, int stock);

    Trip setTripForRegAndUpdate(String tripName, Integer tripPrice, Integer tripMaxStock, LocalDate tripDate, LocalDate expireDate, String category, String optionIds);

    int getListcount(String category, String keyword);

    List<Trip> getTriplist(String category, String keyword, int startRow, int endRow, String sort);
}
