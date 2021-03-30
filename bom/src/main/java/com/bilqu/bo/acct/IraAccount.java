package com.bilqu.bo.acct;

import java.util.List;

public class IraAccount implements Account {


	@Override
	public Balance getBalance() {
		System.out.println("IRA Account Balance");
		return new Balance(7656);
	}

	@Override
	public List<Transaction> getTransactions() {
		// TODO Auto-generated method stub
		return null;
	}


}
