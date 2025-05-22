package com.bank.dto;


import com.bank.entity.BranchEntity;

import java.util.List;

public class BankDto {
    private int bankId;
    private String bankName;


    public BankDto(int bankId, String bankName, List<BranchEntity> branches) {
        this.bankId = bankId;
        this.bankName = bankName;

    }

    public BankDto() {
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
