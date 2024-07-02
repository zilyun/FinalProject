package com.mbti.finalproject.service.dashboard;

import com.mbti.finalproject.domain.TourPackage.Purchase;

import java.util.List;

public interface DashPurchaseService {
    void savePurchase(Purchase purchase);

    List<Purchase> getAllPurchaseInfo();

    List<Purchase> getAllPurchaseInfoByTripNo(Integer num);

    void updatePurchaseStatus(int id, String approved);
}
