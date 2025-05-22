package com.bank.service;

import com.bank.dto.BankDto;
import com.bank.entity.BankEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface BankService {
    public ResponseEntity<String> addBank( BankDto bankDto);

    public ResponseEntity<List<BankEntity>> getAllBankDetails();

    public ResponseEntity<BankEntity>getBankDetailsByName( String bankName);

    public ResponseEntity<String> updateBankDetails(BankDto bankDto, int bankId);

    public ResponseEntity<String> deleteBankById( int bankId);

    public ResponseEntity<String> deleteBankByName( String bankName);
}
