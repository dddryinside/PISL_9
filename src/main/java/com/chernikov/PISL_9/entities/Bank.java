package com.chernikov.PISL_9.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String creditConditions;

    @OneToMany(mappedBy = "bank")
    private List<CreditAgreement> creditAgreementList =
            new ArrayList<>();

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

    public String getCreditConditions() {
        return creditConditions;
    }

    public void setCreditConditions(String creditConditions) {
        this.creditConditions = creditConditions;
    }

    public List<CreditAgreement> getCreditAgreementList() {
        return creditAgreementList;
    }

    public void setCreditAgreementList(List<CreditAgreement> creditAgreementList) {
        this.creditAgreementList = creditAgreementList;
    }
}
