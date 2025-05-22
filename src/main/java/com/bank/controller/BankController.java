package com.bank.controller;

import com.bank.dto.BankDto;
import com.bank.entity.BankEntity;
import com.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank")
public class BankController {
    @Autowired
    BankService bankService;


    @PostMapping("/add_bank")
    public ResponseEntity<String> addBank(@RequestBody BankDto bankDto) {
        return bankService.addBank(bankDto);
    }


    @GetMapping("/allBanksDetails")
    public ResponseEntity<List<BankEntity>> getAllBankDetails() {
        return bankService.getAllBankDetails();
    }


    @GetMapping("/getBankDetails/{bankName}")
    public ResponseEntity<BankEntity> getBankDetailsByName(@PathVariable String bankName) {
        return bankService.getBankDetailsByName(bankName);
    }


    @PutMapping("/updateBankDetails/{bankId}")
    public ResponseEntity<String> updateBankDetails(@RequestBody BankDto bankDto, @PathVariable int bankId) {
        return bankService.updateBankDetails(bankDto, bankId);
    }

    @DeleteMapping("/deleteBankById/{bankId}")
    public ResponseEntity<String> deleteBankById(@PathVariable int bankId) {
        return bankService.deleteBankById(bankId);
    }


    @DeleteMapping("/deleteBankByName/{bank_name}")
    public ResponseEntity<String> deleteBankByName(@PathVariable("bank_name") String bankName) {
        return bankService.deleteBankByName(bankName);
    }

}
