package com.bank.repository;

import com.bank.entity.AccountsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<AccountsEntity, Long> {

    Optional<AccountsEntity> findByAccountNumber(long accountNumber);

    List<AccountsEntity> findByBankName(String bankName);
}
