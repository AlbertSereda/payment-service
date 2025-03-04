package com.market.payment.jpa.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "payment_status")
@Schema(description = "Payment statuses")
public class PaymentStatusEntity {

    @Id
    @Column(name = "id")
    @Schema(description = "Unique identifier for the payment status")
    private Integer id;

    @Column(name = "name", nullable = false, length = 20)
    @Schema(description = "Name of the payment status")
    private String name;
}