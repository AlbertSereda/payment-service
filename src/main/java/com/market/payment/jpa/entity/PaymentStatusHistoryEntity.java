package com.market.payment.jpa.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "payment_status_history")
@Schema(description = "Payment status change history")
public class PaymentStatusHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(description = "Unique identifier for the payment status change record")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "payment_id", nullable = false)
    @Schema(description = "Identifier of the payment")
    private PaymentEntity payment;

    @ManyToOne
    @JoinColumn(name = "old_status_id", nullable = false)
    @Schema(description = "Previous status of the payment")
    private PaymentStatusEntity oldStatus;

    @Column(name = "change_date", nullable = false)
    @CreationTimestamp
    @Schema(description = "Date of the status change")
    private LocalDateTime changeDate = LocalDateTime.now();
}