package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.dto.CustomerDTO;
import se.kth.iv1350.pos.dto.DiscountDTO;
import se.kth.iv1350.pos.dto.ItemGroupDTO;
import se.kth.iv1350.pos.dto.PriceDTO;
import se.kth.iv1350.pos.dto.SaleDTO;
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
	public PriceDTO findDiscount (CustomerDTO customer, SaleDTO sale) {
		DiscountDTO[] eligibleDiscounts = new DiscountSearcher().getEligibleDiscounts(customer, sale);
		PriceDTO runningTotal = sale.getRunningTotal();
		for (DiscountDTO discount : eligibleDiscounts) {
			switch (discount.getType()) {
			case TOTAL_PRICE_REDUCE:
				runningTotal.setPrice(runningTotal.getPrice() - discount.getReduceConstant());
				break;
			case ITEM_PRICE_REDUCE:
				for (int i = discountableItemQuantity(sale, discount); i > 0; i--)
					runningTotal.setPrice(runningTotal.getPrice() - discount.getReduceConstant());
				break;
			case TOTAL_PRICE_MODIFIER:
				runningTotal.setPrice(runningTotal.getPrice() * discount.getReduceModifier());
				break;
			case ITEM_PRICE_MODIFIER:
				for (int i = discountableItemQuantity(sale, discount); i > 0; i--)
					runningTotal.setPrice(runningTotal.getPrice() * discount.getReduceModifier());
				break;
			default:
				break;
			}
		}
		sale.setRunningTotal(runningTotal);
		return runningTotal;
		
	}

	private int discountableItemQuantity (SaleDTO sale, DiscountDTO discount) {
		for (ItemGroupDTO itemGroup : sale.getSaleItems()) {
			if (itemGroup.equals(discount.getConditions().getItem()))
				return itemGroup.getQuantity();
		}
		return 0;
	}
}
