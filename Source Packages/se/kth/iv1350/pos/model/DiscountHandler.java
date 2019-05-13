package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.dto.CustomerDTO;
import se.kth.iv1350.pos.integration.Discount;
import se.kth.iv1350.pos.dto.PriceDTO;
import se.kth.iv1350.pos.integration.DiscountSearcher;

/**
 * Class that handles all calculations related to discounts.
 * @author William
 *
 */
public class DiscountHandler {
	
	/**
	 * Create new instance.
	 */
	public DiscountHandler () {}
	
	/**
	 * Finds eligible discounts based on the customer and the items they've bought
	 * 
	 * @param customer the customer to possibly receive a discount
	 * @param sale the sale containing the items the customer has bought
	 * @return the new running total after discounts have been applied.
	 */
	public PriceDTO findDiscount (CustomerDTO customer, Sale sale) {
		Discount[] eligibleDiscounts = new DiscountSearcher().getEligibleDiscounts(customer, sale.getSaleLog());
		PriceDTO runningTotal = sale.getSaleLog().getRunningTotal();
		
		for (Discount discount : eligibleDiscounts)
			runningTotal = discount.apply(runningTotal);
		
		sale.setRunningTotal(runningTotal);
		return runningTotal;		
	}
}
