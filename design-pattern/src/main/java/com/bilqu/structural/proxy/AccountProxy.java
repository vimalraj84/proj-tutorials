package com.bilqu.structural.proxy;

import com.bilqu.bo.acct.Account;
import com.bilqu.bo.acct.Balance;
import com.bilqu.bo.acct.SavingsAccount;
import com.bilqu.bo.acct.Transaction;
import com.bilqu.creation.factory.AccountFactory;

import java.util.List;

public class AccountProxy implements Account {

    private Account account ;

    AccountProxy(){
        account = new SavingsAccount();
    }

    @Override
    public Balance getBalance() {
        return account.getBalance();
    }

    @Override
    public List<Transaction> getTransactions() {
        return account.getTransactions();
    }
}
