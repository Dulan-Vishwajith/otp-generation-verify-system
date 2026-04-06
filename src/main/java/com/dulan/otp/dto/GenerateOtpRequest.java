package com.dulan.otp.dto;

public class GenerateOtpRequest {

    private String phoneNumber;

    public String getPhoneNumber(){
        return phoneNumber;
    }

    //needs for BTS
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
}
