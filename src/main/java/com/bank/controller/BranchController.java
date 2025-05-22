package com.bank.controller;

import com.bank.dto.BranchDto;
import com.bank.entity.BranchEntity;
import com.bank.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branch")
public class BranchController {
    @Autowired
    BranchService branchService;

    @PostMapping("/addBranch")
    public ResponseEntity<String> addBranch(@RequestBody BranchDto branchDto) {
        return branchService.addBranch(branchDto);
    }


    @GetMapping("allBranches")
    public ResponseEntity<List<BranchEntity>> getAllBranches() {
        return branchService.getAllBranches();
    }

    @GetMapping("getBranchById/{branchId}")
    public ResponseEntity<BranchEntity>getBranchDetailsById(@PathVariable int branchId)
    {
        return branchService.getBranchDetailsById(branchId);
    }

    @GetMapping("/{branchName}")
    public ResponseEntity<List<BranchEntity>> getBranchByName(@PathVariable String branchName)
    {
         return branchService.getBranchByName(branchName);
    }

    @GetMapping("branches/{bankName}")
    public ResponseEntity<List<BranchEntity>> getBranchesByBankName(@PathVariable String bankName)
    {
        return branchService.getBranchesByBankName(bankName);
    }


    @PutMapping("updateBranchDetails/{branchId}")
    public ResponseEntity<String> updateBranchDetailsById(@RequestBody BranchDto branchDto,@PathVariable int branchId)
    {
        return branchService.updateBranchDetailsById(branchDto,branchId);
    }

    @DeleteMapping("deleteBranch/{branchId}")
    public ResponseEntity<String>deleteBranchById(@PathVariable int branchId)
    {
        return branchService.deleteBranchById(branchId);
    }
}
