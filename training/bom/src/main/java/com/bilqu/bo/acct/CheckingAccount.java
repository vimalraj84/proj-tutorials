package com.bilqu.bo.acct;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;

public class CheckingAccount implements Account {
	
	private AccountType acctTyp;
	private Name owner;
	private String branch;
	private long acctNum;
	private long routingNum;
	private boolean isOverDraft;
	private boolean isPapperless;
	
	//Declare private constructor, so that we can use only the builder to create this object.	
	private CheckingAccount() {
		
	}
	
	public AccountType getAcctTyp() {
		return acctTyp;
	}

	public Name getOwner() {
		return owner;
	}

	public String getBranch() {
		return branch;
	}

	public long getAcctNum() {
		return acctNum;
	}

	public long getRoutingNum() {
		return routingNum;
	}

	public boolean isOverDraft() {
		return isOverDraft;
	}

	public boolean isPapperless() {
		return isPapperless;
	}

	//This can be a outside class as well so that will be used by all the accounts.
	public static AccountBuilder get(AccountType acctTyp) {
		return new AccountBuilder(acctTyp);
		
	}
	
	public static class AccountBuilder {
		
		private AccountType acctTyp;
		private Name owner;
		private String branch;
		private long routingNum;
		private boolean isOverDraft;
		private boolean isPapperless;
		
		private AccountBuilder(AccountType acctTyp) {
			this.acctTyp = acctTyp;
		}
		
		public AccountBuilder forOwner(Name owner) {
			this. owner  = owner;
			return this;
		}
		
		public AccountBuilder atBranch(String branch) {
			this.branch = branch;
			return this;
		}
		
		public AccountBuilder withOverDraftProtection(boolean overDraft) {
			this. isOverDraft  = overDraft;
			return this;
		}
		
		public AccountBuilder withPaperless(boolean papperless) {
			this. isPapperless  = papperless;
			return this;
		}
		
		public CheckingAccount create() {
			CheckingAccount account = new CheckingAccount();
			account.acctTyp = this.acctTyp;
			account.owner = this.owner;
			account.branch = this.branch;
			try {
				account.acctNum = SecureRandom.getInstanceStrong().nextLong();
			} catch (NoSuchAlgorithmException e) {
				System.out.println("Exception while generating Account Number. Please Try again.");
				return null;
			}
			account.routingNum = this.routingNum;
			account.isOverDraft = this.isOverDraft;
			account.isPapperless = this.isPapperless;
			return account;
		}
		
	}

	@Override
	public Balance getBalance() {
		System.out.println("Checking Account Balance");
		return new Balance();
	}

	@Override
	public List<Transaction> getTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

}
