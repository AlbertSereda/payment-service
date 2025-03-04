package com.market.payment.jpa.repository;

import com.market.payment.jpa.entity.PaymentStatusHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentStatusHistoryRepository extends JpaRepository<PaymentStatusHistoryEntity, Long> {

}
