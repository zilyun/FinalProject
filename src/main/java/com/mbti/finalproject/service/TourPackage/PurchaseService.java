package com.mbti.finalproject.service.TourPackage;

import com.mbti.finalproject.domain.TourPackage.Purchase;

import java.util.List;

public interface PurchaseService {
    void savePurchase(Purchase purchase);

    List<Purchase> getAllPurchaseInfo();

    List<Purchase> getAllPurchaseInfoByTripNo(Integer num);

    void updatePurchaseStatus(int id, String approved);

    void updateRejectReason(int purchaseId, String rejectReason);
}
