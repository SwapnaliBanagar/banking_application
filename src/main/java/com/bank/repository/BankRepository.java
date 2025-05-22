package com.bank.repository;

import com.bank.entity.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankRepository extends JpaRepository<BankEntity,Long> {

    Optional <BankEntity> findByBankName(String bankName);
    void deleteByBankName(String bankName);
}
