package com.market.payment.jpa.repository;

import com.market.payment.jpa.entity.PaymentInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfoEntity, Long> {

}
