package com.chernikov.PISL_9.controller;

import com.chernikov.PISL_9.entities.Bank;
import com.chernikov.PISL_9.entities.CreditAgreement;
import com.chernikov.PISL_9.repository.BankRepository;
import com.chernikov.PISL_9.repository.CreditRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class BankController {
    private final BankRepository bankRepository;
    private final CreditRepository creditRepository;

    public BankController(BankRepository bankRepository, CreditRepository creditRepository) {
        this.bankRepository = bankRepository;
        this.creditRepository = creditRepository;
    }

    @GetMapping("/api/get-bank")
    public Bank getBank(@RequestParam Long id) {
        Optional<Bank> bankOptional = bankRepository.findById(id);
        if (bankOptional.isPresent()) {
            return bankOptional.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bank not found");
        }
    }

    @PostMapping("/api/create-credit")
    public void createCredit(@RequestAttribute Long id,
                             @RequestAttribute String creditName) {
        Optional<Bank> bankOptional = bankRepository.findById(id);
        if (bankOptional.isPresent()) {
            Bank bank = bankOptional.get();

            CreditAgreement creditAgreement = new CreditAgreement();
            creditAgreement.setBank(bank);
            creditAgreement.setName(creditName);

            creditRepository.save(creditAgreement);
            bank.getCreditAgreementList().add(creditAgreement);
            bankRepository.save(bank);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bank not found");
        }
    }
}
