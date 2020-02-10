package com.bilqu.bo.acct;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SavingsAccount implements Account {


	@Override
	public Balance getBalance() {
		System.out.println("Savings Account Balance");
		return new Balance(1675);
	}

	@Override
	public List<Transaction> getTransactions() {
		final List<Transaction> trxn = new ArrayList<>();
		IntStream.range(1,5).forEach(i -> trxn.add(new Transaction(100,TransactionType.CREDIT)));
		return trxn;
	}



}
