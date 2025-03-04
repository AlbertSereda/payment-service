package com.market.payment.jpa.repository;

import com.market.payment.jpa.entity.PaymentStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentStatusRepository extends JpaRepository<PaymentStatusEntity, Integer> {

}
