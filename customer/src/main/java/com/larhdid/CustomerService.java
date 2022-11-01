package com.larhdid;

import com.larhdid.clients.fraud.Fraud;
import com.larhdid.clients.fraud.FraudResponse;
import com.larhdid.clients.notification.Notification;
import com.larhdid.clients.notification.NotificationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final Fraud fraud;
    private final Notification notification;

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
        NotificationResponse notificationResponse = notification
                .sendNotification(
                        NotificationResponse
                                .builder()
                                .customerId(customer.getId())
                                .message(
                                        String.format(
                                                "hi %s %s welcome to our microservices",
                                                customer.getLastName(),
                                                customer.getFirstName()))
                                .build());
        log.info("notification has been sent {}",notificationResponse);
        return customer;
    }
}
