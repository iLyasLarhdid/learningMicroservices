package com.larhdid;

import com.larhdid.clients.fraud.Fraud;
import com.larhdid.clients.fraud.FraudResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final Fraud fraud;

    public Customer register(CustomerDto customerDto){
        Customer customer = Customer.builder().firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .email(customerDto.getEmail())
                .password(customerDto.getPassword()).build();

        customerRepository.saveAndFlush(customer);
        FraudResponse fraudResponse = fraud.isFraudster(customer.getId());
        //todo : check if email is valid and not taken
        if(fraudResponse.isFraudster()){
            throw new IllegalStateException();
        }
        return customer;
    }
}
