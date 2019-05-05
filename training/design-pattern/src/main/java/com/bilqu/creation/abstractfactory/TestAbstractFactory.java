package com.bilqu.creation.abstractfactory;

import com.bilqu.bo.acct.Account;

public class TestAbstractFactory {

	public static void main(String[] args) {
		AccountAbstractFactory factory = AccountFactoryProducer.getAccountFactory("REGULAR");
		Account checkingAcct = factory.accountCreator("CHECKING");
		checkingAcct.getBalance();
		
		AccountAbstractFactory irafactory = AccountFactoryProducer.getAccountFactory("IRA");
		Account rothAcct = irafactory.accountCreator("ROTH");
		rothAcct.getBalance();
	}
}
