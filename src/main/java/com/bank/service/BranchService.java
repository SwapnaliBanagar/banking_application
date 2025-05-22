package com.bank.service;

import com.bank.dto.BranchDto;
import com.bank.entity.BranchEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BranchService {
    public ResponseEntity<String> addBranch(BranchDto branchDto);

    public ResponseEntity<BranchEntity>getBranchDetailsById( int branchId);

    public ResponseEntity<List<BranchEntity>> getAllBranches();

    public ResponseEntity<List<BranchEntity>>getBranchByName(String branchName);

    public ResponseEntity<List<BranchEntity>> getBranchesByBankName(String bankName);

    public ResponseEntity<String> updateBranchDetailsById(BranchDto branchDto,int branchId);

    public ResponseEntity<String>deleteBranchById( int branchId);
}
