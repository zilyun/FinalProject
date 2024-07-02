package com.mbti.finalproject.service.TourPackage;

import com.mbti.finalproject.domain.TourPackage.Customer;
import jakarta.servlet.http.HttpSession;

public interface CustomerService {
    int join(Customer customer);

    int isCustomerId(String id);

    void update(Customer customer);

    Customer findByCustomerX(String key, String value);

    Customer getcustomerBySession(HttpSession session);
}
