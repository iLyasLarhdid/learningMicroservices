package com.larhdid.fraud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FraudService {
    private final FraudRepository fraudRepository;

    public boolean isFraudster(Integer customerId){
        //todo check database to see if the customer if fraudster
        fraudRepository.save(
                Fraud.builder()
                        .createdAt(LocalDateTime.now())
                        .isFraudster(false)
                        .customerId(customerId)
                        .build()
        );
        return false;
    }
}
