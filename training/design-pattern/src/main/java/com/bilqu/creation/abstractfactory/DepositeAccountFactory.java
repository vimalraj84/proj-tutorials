package com.bilqu.creation.abstractfactory;

import com.bilqu.bo.acct.Account;
import com.bilqu.bo.acct.CdAccount;

public class DepositeAccountFactory implements AccountAbstractFactory {

	@Override
	public Account accountCreator(String acctType) {
		if("CD".equalsIgnoreCase(acctType)) {
			return new CdAccount();
		}
		return null;
	}


}
