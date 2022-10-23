package com.larhdid;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public Customer register(CustomerDto customerDto){
        Customer customer = Customer.builder().firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .email(customerDto.getEmail())
                .password(customerDto.getPassword()).build();

        customerRepository.saveAndFlush(customer);
        FraudResponse fraudResponse = restTemplate.getForObject("http://localhost:8082/api/v1/frauds/{customerId}",FraudResponse.class,customer.getId());
        //todo : check if email is valid and not taken
        if(fraudResponse.isFraudster()){
            throw new IllegalStateException();
        }
        return customer;
    }
}
