package com.bank.serviceImpl;

import com.bank.dto.BranchDto;
import com.bank.entity.BankEntity;
import com.bank.entity.BranchEntity;
import com.bank.repository.BankRepository;
import com.bank.repository.BranchRepository;
import com.bank.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchServiceImpl implements BranchService {
    @Autowired
    BranchRepository branchRepository;
    @Autowired
    BankRepository bankRepository;

    @Override
    public ResponseEntity<String> addBranch(BranchDto branchDto) {

        if(branchDto.getBranchName().isEmpty())
        {
            return ResponseEntity.ok("Please enter branch name.");
        }


        Optional<BankEntity> findBankName = bankRepository.findByBankName(branchDto.getBankName());



        if (findBankName.isPresent()) {
            BranchEntity branchEntity = new BranchEntity();
            branchEntity.setBranchName(branchDto.getBranchName());
            branchEntity.setBankName(branchDto.getBankName());
            branchEntity.setAddress(branchDto.getAddress());
            branchEntity.setPincode(branchDto.getPincode());
            branchRepository.save(branchEntity);

            return ResponseEntity.ok().body("Branch Details Added Successfully...");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(branchDto.getBankName() + " bank not available");
    }


    @Override
    public ResponseEntity<List<BranchEntity>> getAllBranches() {
        List<BranchEntity> allBranches = branchRepository.findAll();
        if (allBranches.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().body(allBranches);
    }


    @Override
    public ResponseEntity<BranchEntity> getBranchDetailsById(int branchId) {
        Optional<BranchEntity> byId = branchRepository.findById((long) branchId);
        if (byId.isPresent()) {
            return ResponseEntity.ok().body(byId.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @Override
    public ResponseEntity<List<BranchEntity>> getBranchByName(String branchName) {
        List<BranchEntity> byBranchName = branchRepository.findByBranchName(branchName);
        if (byBranchName.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().body(byBranchName);
    }

    @Override
    public ResponseEntity<List<BranchEntity>> getBranchesByBankName(String bankName) {
        List<BranchEntity> byBankName = branchRepository.findByBankName(bankName);
        if (byBankName.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().body(byBankName);
    }

    @Override
    public ResponseEntity<String> updateBranchDetailsById(BranchDto branchDto, int branchId) {
        Optional<BranchEntity> byId = branchRepository.findById((long) branchId);
        if (byId.isPresent()) {
            BranchEntity updateBranch = new BranchEntity();
            updateBranch.setBranchId(branchId);
            updateBranch.setBranchName(branchDto.getBranchName());
            updateBranch.setBankName(branchDto.getBankName());
            updateBranch.setAddress(branchDto.getAddress());
            updateBranch.setPincode(branchDto.getPincode());
            branchRepository.save(updateBranch);
            return ResponseEntity.ok().body("Branch_Id:" + branchId + " details updated successfully");

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Branch_Id:" + branchId + " not found");
    }

    @Override
    public ResponseEntity<String> deleteBranchById(int branchId) {
        Optional<BranchEntity> byId = branchRepository.findById((long) branchId);
        if (byId.isPresent()) {
            branchRepository.deleteById((long) branchId);
            return ResponseEntity.ok().body("BranchId:" + branchId + " details deleted successfully..");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("BranchId:" + branchId + " not found");
    }
}
