package com.bilqu.bo.acct;

public class Transaction {

	private  float amt;
	private TransactionType type;
	
	public Transaction(float amt, TransactionType type) {
		this.amt = amt;
		this.type = type;
	}
	
	public float getAmt() {
		return amt;
	}
	public TransactionType getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Transaction{" +
				"amt=" + amt +
				", type=" + type +
				'}';
	}
}
