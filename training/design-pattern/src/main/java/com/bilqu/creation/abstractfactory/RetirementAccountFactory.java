package com.bilqu.creation.abstractfactory;

import com.bilqu.bo.acct.Account;
import com.bilqu.bo.acct.IraAccount;
import com.bilqu.bo.acct.RothIraAccount;

public class RetirementAccountFactory implements AccountAbstractFactory {


	@Override
	public Account accountCreator(String acctType) {
		if("ROTH".equalsIgnoreCase(acctType))
			return new RothIraAccount();
		else if("IRA".equalsIgnoreCase(acctType))
			return new IraAccount();
		else
			return null;
	}

}
