package com.larhdid.notification;

import com.larhdid.clients.notification.NotificationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public NotificationResponse sendNotification(NotificationResponse notificationResponse){
        Notification notification = Notification.builder().customerId(notificationResponse.getCustomerId()).createdAt(LocalDateTime.now()).message(notificationResponse.getMessage()).build();
        notificationRepository.save(notification);
        return new NotificationResponse(true,notification.getCustomerId(),notification.getMessage());
    }

}
