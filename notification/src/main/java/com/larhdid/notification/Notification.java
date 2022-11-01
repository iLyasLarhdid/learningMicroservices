package com.larhdid.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id
    @SequenceGenerator(name = "notification_sequence",sequenceName = "notification_sequence")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "notification_sequence")
    private Integer id;
    private Integer customerId;
    private String message;
    private LocalDateTime createdAt;
}
