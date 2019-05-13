package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.dto.MoneyDTO;
import se.kth.iv1350.pos.integration.CashRegisterObserver;

/**
 * Class representing a display which shows the
 * total revenue of all sales.
 * @author William
 *
 */
public class TotalRevenueView implements CashRegisterObserver {
	
	MoneyDTO totalRevenue = new MoneyDTO(0);

	/**
	 * Updates the total revenue of all sales and displays it.
	 */
	@Override
	public void addToTotalRevenue(MoneyDTO payment) {
		totalRevenue = new MoneyDTO(totalRevenue.getAmount() + payment.getAmount());
		System.out.println("--Total revenue view--\n" + totalRevenue + "\n");
	}
}
