package com.dulan.otp.repository;

import com.dulan.otp.entity.OtpEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OtpRepository extends JpaRepository<OtpEntity, Long> {

    Optional<OtpEntity> findByPhoneNumber(String phoneNumber);
}
