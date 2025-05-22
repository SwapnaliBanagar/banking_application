package com.bank.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Bank_Branches")
public class BranchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long branchId;


    private String branchName;
    private String bankName;
    private String address;
    private int pincode;

    @ManyToOne
    @JoinColumn(name = "bankId")
    private BankEntity bank;

    public BranchEntity(long branchId, String branchName, String bankName, String address, int pincode) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.bankName = bankName;
        this.address = address;
        this.pincode = pincode;
    }

    public BranchEntity() {
    }


    public long getBranchId() {
        return branchId;
    }

    public void setBranchId(long branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public BankEntity getBank() {
        return bank;
    }

}
