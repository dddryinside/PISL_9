package com.chernikov.PISL_9.entities;

import jakarta.persistence.*;

@Entity
public class CreditAgreement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
