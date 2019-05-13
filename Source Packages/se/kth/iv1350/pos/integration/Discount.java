package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.dto.DiscountConditionDTO;
import se.kth.iv1350.pos.dto.PriceDTO;

/**
 * Interface implemented by various types
 * of discounts.
 * @author William
 *
 */
public interface Discount {
	
	/**
	 * Applies the discount on the total price and returns the reduced price.
	 * @param price the total price.
	 * @return the discounted price.
	 */
	public PriceDTO apply(PriceDTO price);
	
	/**
	 * @return the conditions that need to be met for the discount to
	 * be eligible.
	 */
	public DiscountConditionDTO getConditions();
}
