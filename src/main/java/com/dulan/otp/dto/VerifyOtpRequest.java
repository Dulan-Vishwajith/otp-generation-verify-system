package com.dulan.otp.dto;

public class VerifyOtpRequest {
    private String phoneNumber;
    private int otp;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    //needs for BTS
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getOtp() {
        return otp;
    }

    //needs for BTS
    public void setOtp(int otp) {
        this.otp = otp;
    }
}
