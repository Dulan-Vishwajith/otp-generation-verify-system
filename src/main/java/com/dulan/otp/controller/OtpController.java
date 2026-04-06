package com.dulan.otp.controller;

import com.dulan.otp.dto.GenerateOtpRequest;
import com.dulan.otp.dto.VerifyOtpRequest;
import com.dulan.otp.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/otp")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @PostMapping("/generate")
    public String generateOtp(@RequestBody GenerateOtpRequest request){
        return otpService.generateOtp(request.getPhoneNumber());
    }

    @PostMapping("/verify")
    public String verifyOtp(@RequestBody VerifyOtpRequest request){
        return otpService.verifyOtp(request.getPhoneNumber(), request.getOtp());
    }



}
