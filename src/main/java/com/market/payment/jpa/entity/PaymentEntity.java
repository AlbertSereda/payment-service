package com.market.payment.jpa.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "payment")
@Schema(description = "Payment information")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(description = "Unique identifier for the payment")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "payment_status_id", nullable = false)
    @Schema(description = "Identifier of the payment status")
    private PaymentStatusEntity paymentStatus;

    @Column(name = "creation_date", nullable = false, updatable = false)
    @CreationTimestamp
    @Schema(description = "Date of creation")
    private LocalDateTime creationDate = LocalDateTime.now();

    @Column(name = "update_date", nullable = false)
    @UpdateTimestamp
    @Schema(description = "Date of the last update")
    private LocalDateTime updateDate = LocalDateTime.now();
}
