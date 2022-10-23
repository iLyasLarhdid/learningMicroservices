package com.larhdid.fraud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Fraud {
    @Id
    @SequenceGenerator(name = "fraud_sequence",sequenceName = "fraud_sequence")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "fraud_sequence")
    private Integer id;
    private Integer customerId;
    private Boolean isFraudster;
    private LocalDateTime createdAt;
}
