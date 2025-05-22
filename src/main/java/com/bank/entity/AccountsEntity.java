package com.bank.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Bank_Accounts")
public class AccountsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long account_Id;


    private long accountNumber;
    private String bankName;
    private String branch;
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;
    private LocalDate dateOfBirth;
    private  String gender;
    private long phoneNumber;
    private String address;
    private int pincode;
    private double balance;

    public AccountsEntity() {
    }

    public AccountsEntity(long account_Id, long accountNumber, String bankName, String branch, String firstName, String middleName, String lastName, int age, LocalDate dateOfBirth, String gender, long phoneNumber, String address, int pincode,double balance) {
        this.account_Id = account_Id;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.branch = branch;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.pincode = pincode;
        this.balance=balance;
    }

    public long getAccount_Id() {
        return account_Id;
    }

    public void setAccount_Id(long account_Id) {
        this.account_Id = account_Id;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
