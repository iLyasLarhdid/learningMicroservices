package com.larhdid;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public Customer register(@RequestBody CustomerDto customerDto){
        log.info("register new customer : {}",customerDto);
        return customerService.register(customerDto);
    }
}
