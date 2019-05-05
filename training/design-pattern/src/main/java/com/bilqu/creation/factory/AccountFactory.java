package com.bilqu.creation.factory;

import com.bilqu.bo.acct.Account;
import com.bilqu.bo.acct.AccountType;
import com.bilqu.bo.acct.CdAccount;
import com.bilqu.bo.acct.CheckingAccount;
import com.bilqu.bo.acct.IraAccount;
import com.bilqu.bo.acct.Name;
import com.bilqu.bo.acct.SavingsAccount;

public class AccountFactory {

	public static Account accountCreator(String acctType) {
		
		switch(acctType) {
		case "IRA":
			return new IraAccount();
		case "SAVINGS":
			return new SavingsAccount(); 
		case "CHECKING":
			return CheckingAccount.get(AccountType.CHECKING).forOwner(new Name("Aira", "Piper")).atBranch("New York").withOverDraftProtection(true).withPaperless(false).create();
		case "CD":
			return new CdAccount();
		default:
			System.out.println("Please mention the Account Type");
			return null;
		}
		
	}
}
