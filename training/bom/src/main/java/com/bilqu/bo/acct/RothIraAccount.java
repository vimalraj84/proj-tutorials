package com.bilqu.bo.acct;

import java.util.List;

public class RothIraAccount implements Account {

	@Override
	public Balance getBalance() {
		System.out.println("ROTH Account Balance");
		return new Balance();
	}

	@Override
	public List<Transaction> getTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

}
