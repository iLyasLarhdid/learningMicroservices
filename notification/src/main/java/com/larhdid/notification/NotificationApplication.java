package com.larhdid.notification;

import com.larhdid.amqp.RabbitMqMessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {
        "com.larhdid.notification",
        "com.larhdid.amqp",
})
@EnableEurekaClient
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class,args);
    }

    /*@Bean
    CommandLineRunner commandLineRunner(RabbitMqMessageProducer producer, NotificationConfig notificationConfig){
        return args -> {
            producer.publish("test-ilyas",
                    notificationConfig.getInternalExchange(),
                    notificationConfig.getInternalNotificationRoutingKey());
        };
    }*/


}
