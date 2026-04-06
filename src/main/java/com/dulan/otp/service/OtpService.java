package com.dulan.otp.service;

import com.dulan.otp.entity.OtpEntity;
import com.dulan.otp.model.OtpData;
import com.dulan.otp.repository.OtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Service
public class OtpService {
    //store OTPs (temporary)
    private Map<String, OtpData> otpStorage = new HashMap<>();


    @Autowired
    private OtpRepository otpRepository;

    //otp generate method
    public String generateOtp(String phoneNumber){

        //generate 6 digit OTP
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);

        //expiry after 2minutes
        long expiryTime = System.currentTimeMillis() + (2*60*1000);

        //store OTP
        //otpStorage.put(phoneNumber,new OtpData(otp,expiryTime));

        OtpEntity entity =new OtpEntity();
        entity.setPhoneNumber(phoneNumber);
        entity.setOtp(otp);
        entity.setExpiryTime(expiryTime);

        otpRepository.save(entity);

        //send SMS
        sendOtpSms(phoneNumber,otp);

        //For now just return it (later we store + send SMS)
        return "OTP for "+ phoneNumber+" is "+otp;

    }






    public String verifyOtp(String phoneNumber , int otp){


        //check if the phone exists
        /*
        if(!otpStorage.containsKey(phoneNumber)){
            return "No OTP found this number...!";
        }

        //read hashmap and assign value
        OtpData data = otpStorage.get(phoneNumber);

        */

        Optional<OtpEntity> optional = otpRepository.findByPhoneNumber(phoneNumber);

        //
        if(optional.isEmpty()){
            return "No OTP found this number...!";
        }

        OtpEntity entity = optional.get();


        //check expiry
        if(System.currentTimeMillis()>entity.getExpiryTime()){
            otpStorage.remove(phoneNumber);
            return "OTP expired";
        }


        //compare
        if(entity.getOtp() == otp){
            otpStorage.remove(phoneNumber);//remove after success
            return "OTP verified...!";
        }
        else{
            return "Invalid OTP...!";
        }
    }



    private void sendOtpSms(String phoneNumber,int otp){
        String apiUrl = "https://app.text.lk/api/http/sms/send";

        String message = "Your OTP is " + otp;

        //token
        String apiToken = "My Token";

        String url = apiUrl +
                "?recipient="+ phoneNumber+
                "&sender_id=UniHome"+
                "&message="+message+
                "&api_token=" + apiToken;


        RestTemplate restTemplate = new RestTemplate();

        try{
            String response = restTemplate.getForObject(url,String.class);
            System.out.println("\nSMS Response: "+ response+"\n");
        }catch (Exception e){
            System.out.println("\nError sending SMS: "+e.getMessage()+"\n");
        }
    }

}
