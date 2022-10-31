package com.larhdid.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "fraud",path = "api/v1/frauds")
public interface Fraud {
    @GetMapping("{customerId}")
    public FraudResponse isFraudster(@PathVariable("customerId") Integer customerId);
}
