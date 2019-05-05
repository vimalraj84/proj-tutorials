package com.bilqu.creation.factory;

import com.bilqu.bo.acct.Account;

public class TestFactory {

	public static void main(String[] args) {
		Account checkAccount = AccountFactory.accountCreator("CHECKING");
		checkAccount.getBalance();
		
		Account saveAccount = AccountFactory.accountCreator("SAVINGS");
		saveAccount.getBalance();

	}

}
