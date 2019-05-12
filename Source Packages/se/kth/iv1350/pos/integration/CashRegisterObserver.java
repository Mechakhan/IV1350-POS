package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.dto.MoneyDTO;

/**
 * An interface recieving the total revenue of all
 * sales. Classes implementing this interface has
 * a need to know this information.
 * @author William
 *
 */
public interface CashRegisterObserver {
	/**
	 * Invoked when a payment has been added to the cash register.
	 * @param payment the payment that was added to the balance.
	 */
	public void addToTotalRevenue(MoneyDTO payment);
}
