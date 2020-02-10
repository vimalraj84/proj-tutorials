package com.bilqu.bo.acct;

public class Balance {

	private float balAmt;

	Balance(float amt){
		balAmt = amt;
	}

	public float getBalAmt() {
		return balAmt;
	}

	public void setBalAmt(float balAmt) {
		this.balAmt = balAmt;
	}
}
