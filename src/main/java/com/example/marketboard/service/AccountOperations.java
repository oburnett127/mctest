package com.example.marketboard.service;

import com.example.marketboard.model.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountOperations {
    List<Account> listAll();
    void createAccount(Account account);
    Account getAccount(int id);
    Account withdraw(int id, BigDecimal amount);
    Account deposit(int id, BigDecimal amount);
    Account depositCheck(int id, String fullName, String signature, BigDecimal amount);
    public Account transfer(int idSender, int idReceiver, BigDecimal amount);
}
////Hello world