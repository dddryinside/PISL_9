package com.chernikov.PISL_9.repository;

import com.chernikov.PISL_9.entities.CreditAgreement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<CreditAgreement, Long> {
}
