package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.dto.MoneyDTO;

public class CashRegister {

	double cashRegister;
	
	/**
	 * Creates instance and initializes the register to to the amount of cash in the register.
	 */
	public CashRegister() {
		cashRegister = 1000;
	}
	
	/**
	 * Adds payment to the cash register.
	 * @param payment the payment to add
	 */
	public void addToCashRegister(MoneyDTO payment) {
		cashRegister += payment.getAmount();
	}
}
