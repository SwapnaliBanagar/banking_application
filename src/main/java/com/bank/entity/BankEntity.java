package com.bank.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Bank_Details")
public class BankEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bankId;
    private String bankName;

    @OneToMany(mappedBy = "bank",cascade = CascadeType.ALL)
        private List<BranchEntity> branches;


    public BankEntity() {
    }

    public BankEntity(int bankId, String bankName) {
        this.bankId = bankId;
        this.bankName = bankName;

    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }


}


