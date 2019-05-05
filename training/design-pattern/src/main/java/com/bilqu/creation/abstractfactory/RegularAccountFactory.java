package com.bilqu.creation.abstractfactory;

import com.bilqu.bo.acct.Account;
import com.bilqu.bo.acct.AccountType;
import com.bilqu.bo.acct.CheckingAccount;
import com.bilqu.bo.acct.Name;
import com.bilqu.bo.acct.SavingsAccount;

public class RegularAccountFactory implements AccountAbstractFactory {

	@Override
	public Account accountCreator(String acctType) {
		if("SAVINGS".equalsIgnoreCase(acctType)) 
			return new SavingsAccount();
		else if ("CHECKING".equalsIgnoreCase(acctType)) {
			Account checkingAccount = CheckingAccount.get(AccountType.CHECKING).atBranch("Concord").forOwner(new Name("Alexis","Sky")).withOverDraftProtection(true).withPaperless(true).create();
			return checkingAccount;
		}
		else return null;
	}

}
