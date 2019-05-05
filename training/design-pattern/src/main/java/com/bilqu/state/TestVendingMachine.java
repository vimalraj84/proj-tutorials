package com.bilqu.state;

public class TestVendingMachine {
	
	public static void main(String[] a) {
		VendingMachine state = VendingMachine.INITIALIZE;
		TestVendingMachine machine = new TestVendingMachine();
		machine.process(state);
	}
	
	private void process(VendingMachine state) {
		if(state.hasNext()) {
			process(state.nextState());
		}
	}

}
