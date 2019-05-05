package com.bilqu.creation.abstractfactory;

import com.bilqu.bo.acct.Account;

public interface AccountAbstractFactory {

	Account accountCreator(String acctType);
}
