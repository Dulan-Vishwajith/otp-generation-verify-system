package com.dulan.otp.model;

public class OtpData {
    private int otp;
    private long expiryTime;

    public OtpData(int otp,long expiryTime){
        this.otp = otp;
        this.expiryTime = expiryTime;
    }

    public int getOtp(){
        return otp;
    }

    public long getExpiryTime(){
        return expiryTime;
    }
}
