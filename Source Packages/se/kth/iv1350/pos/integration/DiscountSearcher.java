package se.kth.iv1350.pos.integration;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.pos.dto.CustomerDTO;
import se.kth.iv1350.pos.dto.DiscountConditionDTO;
import se.kth.iv1350.pos.dto.PriceDTO;
import se.kth.iv1350.pos.dto.SaleDTO;
import se.kth.iv1350.pos.model.ModifierDiscount;
import se.kth.iv1350.pos.model.SubtractDiscount;

/**
 * Class that finds eligible discounts from
 * a discount database.
 * @author William
 *
 */
public class DiscountSearcher {
	
	private Discount[] discountDatabase = new Discount[3];
	
	/**
	 * Creates new instance.
	 */
	public DiscountSearcher() {
		discountDatabase[0] = new SubtractDiscount(new DiscountConditionDTO(new CustomerDTO("1234"), 
				new PriceDTO(200, 0, false), 5), 20);
		discountDatabase[1] = new ModifierDiscount(new DiscountConditionDTO(new CustomerDTO("1234"), 
				new PriceDTO(300, 0, false), 6), 0.9);
		discountDatabase[2] = new ModifierDiscount(new DiscountConditionDTO(new CustomerDTO("1234"), 
				new PriceDTO(150, 0, false), 10), 0.8);
	}
	
	/**
	 * Calls the discount database with the specified identifier and retrieves an item if it exists.
	 * 
	 * @param customer the customer to possibly receive a discount
	 * @param sale the sale containing the items the customer has bought
	 * @return the array of applicable discounts to be applies to the total price
	 */
	public Discount[] getEligibleDiscounts(CustomerDTO customer, SaleDTO saleDTO) {
		if (customer.getIdentifier().equals("dbfailure"))
			throw new DatabaseFailureException("There was a database failure.");
		List<Discount> eligibleDiscounts = new ArrayList<Discount>();
		for (Discount discount : discountDatabase) {
			if (eligibleDiscount(discount, customer, saleDTO))
				eligibleDiscounts.add(discount);
		}
		return eligibleDiscounts.toArray(new Discount[eligibleDiscounts.size()]);
	}

	private boolean eligibleDiscount(Discount discount, CustomerDTO customer, SaleDTO saleDTO) {
		return discount.getConditions().getCustomer().equals(customer) && 
				discount.getConditions().getSalePrice().getPrice() <= saleDTO.getRunningTotal().getPrice() &&
				discount.getConditions().getNrOfItemsInSale() <= saleDTO.getItemCount();
	}
}
