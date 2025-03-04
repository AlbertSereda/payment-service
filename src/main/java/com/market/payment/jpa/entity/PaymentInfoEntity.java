package com.market.payment.jpa.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "payment_info")
@Schema(description = "Detailed payment information")
public class PaymentInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(description = "Unique identifier for the payment info")
    private Long id;

    @Column(name = "user_id", nullable = false)
    @Schema(description = "Identifier of the user making the payment")
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "payment_id", nullable = false)
    @Schema(description = "Identifier of the payment")
    private PaymentEntity payment;

    @Column(name = "order_id", nullable = false)
    @Schema(description = "Identifier of the associated order")
    private Long orderId;

    @Column(name = "total_price", nullable = false)
    @Schema(description = "Total amount paid")
    private BigDecimal totalPrice;

    @Column(name = "payment_system", nullable = false, length = 100)
    @Schema(description = "Payment system used")
    private String paymentSystem;

    @Column(name = "currency", nullable = false, length = 100)
    @Schema(description = "Currency of the payment")
    private String currency;
}