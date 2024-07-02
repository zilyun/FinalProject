package com.mbti.finalproject.service.TourPackage;

import com.mbti.finalproject.domain.TourPackage.Cart;

public interface CartService {

    Cart getDetail(String memberId);

    int isId(String cartNo);

    void deleteCart(String cartNo);

    void insertCart(String memberId, String tripNo, int cartTotal, String optionIds);

    void updateCart(String memberId, String tripNoValue, String newOptionIds, int totalPrice);

    void deleteTripNo(String cartNo);

    void deleteOption(String updatedOptionIds, String cartNo, String updatedCartTotal);

    String getOptionIds(String cartNo);
}
