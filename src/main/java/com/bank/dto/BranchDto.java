package com.bank.dto;


public class BranchDto {
    private long branchId;
    private String branchName;
    private String bankName;
    private String address;
    private int pincode;


    public BranchDto(long branchId, String branchName, String bankName, String address, int pincode) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.bankName = bankName;
        this.address = address;
        this.pincode = pincode;

    }

    public BranchDto() {
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


}
