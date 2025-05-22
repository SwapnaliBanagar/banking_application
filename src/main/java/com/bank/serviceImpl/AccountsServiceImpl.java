package com.bank.serviceImpl;

import com.bank.dto.AccountsDto;
import com.bank.dto.BalanceDto;
import com.bank.dto.TransferDto;
import com.bank.entity.AccountsEntity;
import com.bank.entity.BankEntity;
import com.bank.entity.BranchEntity;
import com.bank.repository.AccountsRepository;
import com.bank.repository.BankRepository;
import com.bank.repository.BranchRepository;
import com.bank.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountsServiceImpl implements AccountsService {
    @Autowired
    AccountsRepository accountsRepository;
    @Autowired
    BankRepository bankRepository;
    @Autowired
    BranchRepository branchRepository;


    private long generateUniqueAccountNumber() {
        return System.currentTimeMillis();
    }


    @Override
    public ResponseEntity<String> createAccount(AccountsDto accountsDto) {

        Optional<BankEntity> byBankName = bankRepository.findByBankName(accountsDto.getBankName());
        if (byBankName.isPresent()) {
            List<BranchEntity> byBranchName = branchRepository.findByBranchName(accountsDto.getBranch());

            if (byBranchName.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("branch_Name:" + accountsDto.getBranch() + " is not available");
            }
            AccountsEntity accountEntity = new AccountsEntity();
            accountEntity.setAccountNumber(generateUniqueAccountNumber());
            accountEntity.setBankName(accountsDto.getBankName());
            accountEntity.setBranch(accountsDto.getBranch());
            accountEntity.setFirstName(accountsDto.getFirstName());
            accountEntity.setMiddleName(accountsDto.getMiddleName());
            accountEntity.setLastName(accountsDto.getLastName());
            accountEntity.setAge(accountsDto.getAge());
            accountEntity.setDateOfBirth(accountsDto.getDateOfBirth());
            accountEntity.setGender(accountsDto.getGender());
            accountEntity.setPhoneNumber(accountsDto.getPhoneNumber());
            accountEntity.setAddress(accountsDto.getAddress());
            accountEntity.setPincode(accountsDto.getPincode());
            accountEntity.setBalance(accountsDto.getBalance());
            accountsRepository.save(accountEntity);

            return ResponseEntity.ok().body("Your bank account create successfully.. \nbankName:" + accountsDto.getBankName() + "\nAccountNumber:" + accountEntity.getAccountNumber());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("bank_Name:" + accountsDto.getBankName() + " is not available");
    }


    @Override
    public ResponseEntity<AccountsEntity> getAccountDetails(long accountNumber) {
        Optional<AccountsEntity> byAccountNumber = accountsRepository.findByAccountNumber(accountNumber);
        if (byAccountNumber.isPresent()) {
            return ResponseEntity.ok().body(byAccountNumber.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    public ResponseEntity<AccountsEntity> getAccountDetailsByAccountId(long account_Id) {
        Optional<AccountsEntity> byId = accountsRepository.findById(account_Id);
        return byId.map(accountsEntity -> ResponseEntity.ok().body(accountsEntity)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Override
    public ResponseEntity<List<AccountsEntity>> getAccountsByBankName(String bankName) {
        List<AccountsEntity> byBankName = accountsRepository.findByBankName(bankName);
        if (byBankName.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok().body(byBankName);
    }

    @Override
    public ResponseEntity<String> updateByAccountId(AccountsDto accountsDto, long account_Id) {
        Optional<BankEntity> byBankName = bankRepository.findByBankName(accountsDto.getBankName());
        if (byBankName.isPresent()) {
            List<BranchEntity> byBranchName = branchRepository.findByBranchName(accountsDto.getBranch());
            {
                if (byBranchName.isEmpty()) {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("branch_name:" + accountsDto.getBranch() + " is not available.");
                }

                Optional<AccountsEntity> byId = accountsRepository.findById(account_Id);
                if (byId.isPresent()) {
                    AccountsEntity updateEntity = new AccountsEntity();
                    updateEntity.setAccount_Id(account_Id);
                    updateEntity.setAccountNumber(byId.get().getAccountNumber());
                    updateEntity.setBankName(accountsDto.getBankName());
                    updateEntity.setBranch(accountsDto.getBranch());
                    updateEntity.setFirstName(accountsDto.getFirstName());
                    updateEntity.setMiddleName(accountsDto.getMiddleName());
                    updateEntity.setLastName(accountsDto.getLastName());
                    updateEntity.setAge(accountsDto.getAge());
                    updateEntity.setDateOfBirth(accountsDto.getDateOfBirth());
                    updateEntity.setGender(accountsDto.getGender());
                    updateEntity.setPhoneNumber(accountsDto.getPhoneNumber());
                    updateEntity.setAddress(accountsDto.getAddress());
                    updateEntity.setPincode(accountsDto.getPincode());
                    updateEntity.setBalance(accountsDto.getBalance());
                    accountsRepository.save(updateEntity);
                    return ResponseEntity.ok().body("account details updated successfully.." + "\naccount_Id:" + updateEntity.getAccount_Id());
                }
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid account_Id:" + account_Id);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("bank_name:" + accountsDto.getBankName() + " is not available.");
    }


    @Override
    public ResponseEntity<String> updateByAccountNumber(AccountsDto accountsDto, long accountNumber) {
        Optional<BankEntity> byBankName = bankRepository.findByBankName(accountsDto.getBankName());
        if (byBankName.isPresent()) {
            List<BranchEntity> byBranchName = branchRepository.findByBranchName(accountsDto.getBranch());

            if (byBranchName.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("branch_Name:" + accountsDto.getBranch() + " is not available");
            }
            Optional<AccountsEntity> byAccountNumber = accountsRepository.findByAccountNumber(accountNumber);
            if (byAccountNumber.isPresent()) {
                AccountsEntity updateEntityByAccountNumber = new AccountsEntity();
                updateEntityByAccountNumber.setAccount_Id(byAccountNumber.get().getAccount_Id());
                updateEntityByAccountNumber.setAccountNumber(accountNumber);
                updateEntityByAccountNumber.setBankName(accountsDto.getBankName());
                updateEntityByAccountNumber.setBranch(accountsDto.getBranch());
                updateEntityByAccountNumber.setFirstName(accountsDto.getFirstName());
                updateEntityByAccountNumber.setMiddleName(accountsDto.getMiddleName());
                updateEntityByAccountNumber.setLastName(accountsDto.getLastName());
                updateEntityByAccountNumber.setAge(accountsDto.getAge());
                updateEntityByAccountNumber.setDateOfBirth(accountsDto.getDateOfBirth());
                updateEntityByAccountNumber.setGender(accountsDto.getGender());
                updateEntityByAccountNumber.setPhoneNumber(accountsDto.getPhoneNumber());
                updateEntityByAccountNumber.setAddress(accountsDto.getAddress());
                updateEntityByAccountNumber.setPincode(accountsDto.getPincode());
                updateEntityByAccountNumber.setBalance(accountsDto.getBalance());
                accountsRepository.save(updateEntityByAccountNumber);

                return ResponseEntity.ok().body("account details updated successfully.." + "\nAccount_Id:" + updateEntityByAccountNumber.getAccount_Id() + "\nAccount_Number:" + updateEntityByAccountNumber.getAccountNumber());

            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Account_Number:" + accountNumber);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("bank_Name:" + accountsDto.getBankName() + " is not available");
    }

    @Override
    public ResponseEntity<String> deleteAccountByAccountNumber(long accountNumber) {
        Optional<AccountsEntity> byAccountNumber = accountsRepository.findByAccountNumber(accountNumber);
        if (byAccountNumber.isPresent()) {
            accountsRepository.deleteById(byAccountNumber.get().getAccount_Id());
            return ResponseEntity.ok().body("bank_account_number:" + accountNumber + " deleted successfully..");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("account_number:" + accountNumber + " not found");
    }


    // --------------------------------------------------------------  Balance -----------------------------------------------------------------------------------------------------------


    @Override
    public ResponseEntity<String> checkBalanceByAccountNumber(long accountNumber) {
        Optional<AccountsEntity> byAccountNumber = accountsRepository.findByAccountNumber(accountNumber);
        /*if(byAccountNumber.isPresent())
        {
            return ResponseEntity.ok().body("Your Current balance is: "+byAccountNumber.get().getBalance());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Account Number.Please try again");*/
        // using java8
        return byAccountNumber.map(accountEntity -> ResponseEntity.ok().body(byAccountNumber.get().getFirstName() + " " + byAccountNumber.get().getLastName() + " your Current balance is:" + byAccountNumber.get().getBalance())).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Account Number.Please try again"));
    }

    @Override
    public ResponseEntity<String> addBalance(BalanceDto balanceDto, long accountNumber) {
        Optional<AccountsEntity> byAccountNumber = accountsRepository.findByAccountNumber(accountNumber);
        if (byAccountNumber.isPresent()) {
            if (byAccountNumber.get().getAccountNumber() == balanceDto.getAccountNumber()) {
                double oldBalance = byAccountNumber.get().getBalance();
                double newBalance = balanceDto.getAmount();
                double totalBalance = oldBalance + newBalance;
                AccountsEntity accountsEntity = new AccountsEntity();
                accountsEntity.setBalance(totalBalance);
                accountsRepository.save(accountsEntity);
                return ResponseEntity.ok().body(byAccountNumber.get().getFirstName() + " " + byAccountNumber.get().getLastName() + ", ₹" + balanceDto.getAmount() + " has been credited successfully.Your updated balance is: ₹" + accountsEntity.getBalance());
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please check account number.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid account number");
    }

    @Override
    public ResponseEntity<String> withdrawAmount(BalanceDto balanceDto, long accountNumber) {
        Optional<AccountsEntity> byAccountNumber = accountsRepository.findByAccountNumber(accountNumber);
        if (byAccountNumber.isPresent()) {
            // check passed account number and searched account number is same
            if (balanceDto.getAccountNumber() == byAccountNumber.get().getAccountNumber()) {
                double totalAmount = byAccountNumber.get().getBalance();
                double withdrawAmount = balanceDto.getAmount();

                if ((totalAmount - withdrawAmount) >= 100) {
                    double updatedBalance = (totalAmount - withdrawAmount);
                    AccountsEntity account = byAccountNumber.get();
                    account.setBalance(updatedBalance);
                    accountsRepository.save(account);
                    return ResponseEntity.ok().body("Dear " + byAccountNumber.get().getFirstName() + " " + byAccountNumber.get().getLastName() + ", ₹" + withdrawAmount + " has been withdrawn successfully. Your updated balance is: ₹" + account.getBalance());
                }
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("sorry..your balance is not sufficient to debit ₹" + balanceDto.getAmount() + ". Minimum balance of ₹100 must be maintained.");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please check account number.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid account number! Please enter a valid account number and try again");
    }


    //----------------------------------------------------------------  Transfer Amount --------------------------------------------------------


    @Override
    public ResponseEntity<String> transferAmount(TransferDto transferDto) {
        Optional<AccountsEntity> senderAccountNumber = accountsRepository.findByAccountNumber(transferDto.getSenderAccountNumber());

        if (senderAccountNumber.isPresent()) {
            if ((senderAccountNumber.get().getBalance() - transferDto.getAmount()) >= 100) {
                Optional<AccountsEntity> receiverAccountNumber = accountsRepository.findByAccountNumber(transferDto.getReceiverAccountNumber());
                if (receiverAccountNumber.isPresent()) {
                    AccountsEntity receiver = receiverAccountNumber.get();
                    double oldAmount = receiver.getBalance();
                    double newAmount = transferDto.getAmount();
                    receiver.setBalance((oldAmount + newAmount));
                    accountsRepository.save(receiver);

                    //update sender balance
                    AccountsEntity sender = senderAccountNumber.get();
                    double updateBalance = (sender.getBalance() - transferDto.getAmount());
                    sender.setBalance((updateBalance));
                    accountsRepository.save(sender);

                    return ResponseEntity.ok().body("₹" + transferDto.getAmount() + " transferred successfully from " +
                            sender.getFirstName()+" "+sender.getLastName() + " to " + receiver.getFirstName()+" "+receiver.getLastName()+".");
                }
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Receiver account number not found.");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("sorry..your balance is not sufficient to transfer ₹" + transferDto.getAmount() + ". Minimum balance of ₹100 must be maintained.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid sender account number! Please check.");
    }


}


