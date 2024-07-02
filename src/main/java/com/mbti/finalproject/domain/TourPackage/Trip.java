package com.mbti.finalproject.domain.TourPackage;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Trip {
    private int tripNo;
    private String tripName;
    private int tripPrice;
    private int tripStock;
    private int tripMaxStock;
    private String regDate;
    private String expireDate;
    private String tripDate;
    private String fileId;
    private String tripMainImg;
    private String tripCategory;
    private String optionIds;
    private String status;
    private int travelleaderNo;
    private String travelleaderName;
    private int tripProgress;

}
