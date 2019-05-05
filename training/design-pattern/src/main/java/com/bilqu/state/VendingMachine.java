package com.bilqu.state;

public enum VendingMachine {
	INITIALIZE {
		@Override
		public VendingMachine nextState() {
			System.out.println("Welcome");
			return INSERT_PAYMENT;
		}

		@Override
		public boolean hasNext() {
			return true;
		}
	},
	INSERT_PAYMENT {
		@Override
		public VendingMachine nextState() {
			System.out.println("Please Insert Payment:");
			return SELECT_ITEM;
		}

		@Override
		public boolean hasNext() {
			return true;
		}
	},
	SELECT_ITEM {
		@Override
		public VendingMachine nextState() {
			System.out.println("Please Select an Item:");
			return CALCULATE_CHANGE;
		}

		@Override
		public boolean hasNext() {
			return true;
		}
	},
	CALCULATE_CHANGE {
		@Override
		public VendingMachine nextState() {
			System.out.println("Calulating Balance,");
			return RELEASE_ITEM;
		}
		@Override
		public boolean hasNext() {
			return true;
		}
	},
	RELEASE_ITEM {
		@Override
		public VendingMachine nextState() {
			System.out.println("Please collect your Item from the Bin.");
			return THANSKS;
		}

		@Override
		public boolean hasNext() {
			return true;
		}
	},
	THANSKS {
		@Override
		public VendingMachine nextState() {
			System.out.println("Enjoy your drink. Thankyou.");
			return SLEEP;
		}
		@Override
		public boolean hasNext() {
			return true;
		}
	},
	SLEEP {
		@Override
		public VendingMachine nextState() {
			return null;
		}

		@Override
		public boolean hasNext() {
			return false;
		}
	};

	private static boolean isReadyForNext;

	public abstract VendingMachine nextState();
	public abstract boolean hasNext();
}
