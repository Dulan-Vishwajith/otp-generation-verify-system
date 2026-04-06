package com.dulan.otp.controller;

import com.dulan.otp.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/otp")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @PostMapping("/generate")
    public String generateOtp(@RequestParam String phoneNumber){
        return otpService.generateOtp(phoneNumber);
    }

    @PostMapping("/verify")
    public String verifyOtp(@RequestParam String phoneNumber , @RequestParam int otp){
        return otpService.verifyOtp(phoneNumber, otp);
    }



}
