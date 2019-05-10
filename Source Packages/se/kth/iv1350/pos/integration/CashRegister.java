package se.kth.iv1350.pos.integration;

import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.pos.dto.MoneyDTO;

/**
 * Class containing the current balance of the register.
 * @author William
 *
 */
@SuppressWarnings("unused")
public class CashRegister {

	private double balance;
	
	/**
	 * Creates instance and initializes the balance to to the amount of cash in the register.
	 */
	public CashRegister() {
		balance = 1000;
	}
	
	/**
	 * Adds payment to the balance.
	 * @param payment the payment to add
	 */
	public void addToBalance (MoneyDTO payment) {
			balance += payment.getAmount();
	}
}
