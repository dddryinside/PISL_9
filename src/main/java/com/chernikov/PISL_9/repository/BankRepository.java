package com.chernikov.PISL_9.repository;

import com.chernikov.PISL_9.entities.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
}
