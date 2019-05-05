package com.bilqu.creation.abstractfactory;

public class AccountFactoryProducer {

	public static AccountAbstractFactory getAccountFactory(String acctType) {
		if("REGULAR".equalsIgnoreCase(acctType))
			return new RegularAccountFactory();
		else if("DEPOSIT".equalsIgnoreCase(acctType))
			return new DepositeAccountFactory();
		else if("IRA".equalsIgnoreCase(acctType))
			return new RetirementAccountFactory();
		else
			return null;

	}

}
