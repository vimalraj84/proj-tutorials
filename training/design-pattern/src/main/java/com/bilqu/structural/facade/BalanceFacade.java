package com.bilqu.structural.facade;

import com.bilqu.bo.acct.Account;
import com.bilqu.bo.acct.AccountType;
import com.bilqu.bo.acct.Balance;
import com.bilqu.bo.acct.CheckingAccount;
import com.bilqu.bo.acct.IraAccount;
import com.bilqu.bo.acct.RothIraAccount;
import com.bilqu.bo.acct.SavingsAccount;

public class BalanceFacade {

	private Account savingAccount = null;
	private Account rothAccount = null;
	private Account iraAccount = null;
	private Account checkAccount = null;
	
	public BalanceFacade() {
		savingAccount = new SavingsAccount();
		rothAccount = new RothIraAccount();
		iraAccount = new IraAccount();
		checkAccount = CheckingAccount.get(AccountType.CHECKING).create();
	}
	
	
	public Balance getSavingsBalance() {
		return savingAccount.getBalance();
	}
	
	public Balance getCheckingBalance() {
		return checkAccount.getBalance();
	}
	
	public Balance getRothBalance() {
		return rothAccount.getBalance();
	}
	
	public Balance getIraBalance() {
		return iraAccount.getBalance();
	}
}
