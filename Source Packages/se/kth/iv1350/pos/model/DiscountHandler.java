package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.dto.CustomerDTO;
import se.kth.iv1350.pos.dto.DiscountDTO;
import se.kth.iv1350.pos.dto.PriceDTO;
import se.kth.iv1350.pos.integration.DiscountSearcher;

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
		DiscountDTO[] eligibleDiscounts = new DiscountSearcher().getEligibleDiscounts(customer, sale.getSaleLog());
		PriceDTO runningTotal = sale.getSaleLog().getRunningTotal();
		for (DiscountDTO discount : eligibleDiscounts) {
			switch (discount.getType()) {
			case TOTAL_PRICE_REDUCE:
				runningTotal.setPrice(runningTotal.getPrice() - discount.getReduceConstant());
				break;
			case TOTAL_PRICE_MODIFIER:
				runningTotal.setPrice(runningTotal.getPrice() * discount.getReduceModifier());
				break;
			default:
				break;
			}
		}
		sale.setRunningTotal(runningTotal);
		return runningTotal;		
	}
}
