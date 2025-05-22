package com.bank.repository;

import com.bank.entity.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BranchRepository extends JpaRepository<BranchEntity,Long> {
   List<BranchEntity> findByBranchName(String branchName);
   List<BranchEntity>findByBankName(String bankName);
}
