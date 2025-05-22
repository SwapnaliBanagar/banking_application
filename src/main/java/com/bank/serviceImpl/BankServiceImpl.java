package com.bank.serviceImpl;

import com.bank.dto.BankDto;
import com.bank.entity.BankEntity;
import com.bank.repository.BankRepository;
import com.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankServiceImpl implements BankService {
    @Autowired
    BankRepository bankRepository;

    @Override
    public ResponseEntity<String> addBank(BankDto bankDto) {
        Optional<BankEntity> byBankName = bankRepository.findByBankName(bankDto.getBankName());
        if(byBankName.isPresent())
        {
            return ResponseEntity.ok().body("This bank details already present");
        }

        BankEntity bankEntity = new BankEntity();
        bankEntity.setBankName(bankDto.getBankName());

        bankRepository.save(bankEntity);
        return ResponseEntity.ok().body("Bank details added successfully....");
    }

    @Override
    public ResponseEntity<List<BankEntity>> getAllBankDetails() {
        List<BankEntity> allBanks = bankRepository.findAll();
        if (allBanks.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().body(allBanks);
    }

    @Override
    public ResponseEntity<BankEntity> getBankDetailsByName(String bankName) {
        Optional<BankEntity> findBankName = bankRepository.findByBankName(bankName);
        return findBankName.map(bankEntity -> ResponseEntity.ok().body(bankEntity)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Override
    public ResponseEntity<String> updateBankDetails(BankDto bankDto, int bankId) {
        Optional<BankEntity> findBankById = bankRepository.findById((long) bankId);
        if (findBankById.isPresent()) {
            BankEntity updateBankEntity = new BankEntity();
            updateBankEntity.setBankId(bankId);
            updateBankEntity.setBankName(bankDto.getBankName());
            bankRepository.save(updateBankEntity);
            return ResponseEntity.ok().body("Bank Details update successfully....");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("bank_id:" + bankId + " details not found.");
    }

    @Override
    public ResponseEntity<String> deleteBankById(int bankId) {
        Optional<BankEntity> byId = bankRepository.findById((long) bankId);
        if (byId.isPresent()) {
            bankRepository.deleteById((long) bankId);
            return ResponseEntity.ok().body("Bank_Id:" + bankId + " bankName:" + byId.get().getBankName() + " is deleted successfully..");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bank_Id:" + bankId + " is not found");
    }

    @Override
    public ResponseEntity<String> deleteBankByName(String bankName) {
        Optional<BankEntity> byBankName = bankRepository.findByBankName(bankName);
        if (byBankName.isPresent()) {
            bankRepository.delete(byBankName.get());
            return ResponseEntity.ok().body("Bank_Id:" + byBankName.get().getBankId() + " bankName:" + bankName + " is deleted successfully..");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bankName + " bank  not found");
    }
}

