package com.mbti.finalproject.mybatis.mapper.TourPackage;

import com.mbti.finalproject.domain.TourPackage.Purchase;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PurchaseMapper {
    void insertPurchase(Purchase purchase);

    List<Purchase> getAllPurchaseInfo();

    List<Purchase> getAllPurchaseInfoByTripNo(Integer num);

    void updatePurchaseStatus(int id, String status);

    void updateRejectReason(int purchaseId, String rejectReason);
}