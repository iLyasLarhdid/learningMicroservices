package com.larhdid.fraud;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/frauds")
@RequiredArgsConstructor
@Slf4j
public class FraudController {
    private final FraudService fraudService;

    @GetMapping("{customerId}")
    public FraudResponse isFraudster(@PathVariable("customerId") Integer customerId){
        boolean isFraudster = fraudService.isFraudster(customerId);
        log.info("fraud check request for customer {}",customerId);
        return new FraudResponse(isFraudster);
    }
}
