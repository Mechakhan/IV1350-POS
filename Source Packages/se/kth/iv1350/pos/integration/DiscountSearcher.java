package se.kth.iv1350.pos.integration;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.pos.dto.CustomerDTO;
import se.kth.iv1350.pos.dto.DiscountConditionDTO;
import se.kth.iv1350.pos.dto.DiscountDTO;
import se.kth.iv1350.pos.dto.ItemDescriptionDTO;
import se.kth.iv1350.pos.dto.PriceDTO;
import se.kth.iv1350.pos.dto.SaleDTO;
import se.kth.iv1350.pos.dto.ItemGroupDTO;
import se.kth.iv1350.pos.enumerables.DiscountType;

public class DiscountSearcher {
	
	DiscountDTO[] discountDatabase;
	
	/**
	 * Creates new instance.
	 */
	public DiscountSearcher() {
		discountDatabase = new DiscountDTO[3];
		discountDatabase[0] = new DiscountDTO (DiscountType.TOTAL_PRICE_REDUCE, new DiscountConditionDTO
				(new CustomerDTO("1234"), new PriceDTO(200, 0), 5, new ItemGroupDTO("ABC123", 
						new PriceDTO(30.0, 0.25), 0, new ItemDescriptionDTO())), 20, 1);
		discountDatabase[1] = new DiscountDTO (DiscountType.TOTAL_PRICE_MODIFIER, new DiscountConditionDTO
				(new CustomerDTO("1234"), new PriceDTO(200, 0), 5, new ItemGroupDTO("ABC123", 
						new PriceDTO(30.0, 0.25), 0, new ItemDescriptionDTO())), 20, 1);
		discountDatabase[2] = new DiscountDTO (DiscountType.ITEM_PRICE_MODIFIER, new DiscountConditionDTO
				(new CustomerDTO("1234"), new PriceDTO(200, 0), 5, new ItemGroupDTO("DEF456", 
						new PriceDTO(49.0, 0.12), 0, new ItemDescriptionDTO())), 20, 1);
	}
	
	/**
	 * Calls the discount database with the specified identifier and retrieves an item if it exists.
	 * 
	 * @param customer the customer to possibly receive a discount
	 * @param sale the sale containing the items the customer has bought
	 * @return the array of applicable discounts to be applies to the total price
	 */
	public DiscountDTO[] getEligibleDiscounts(CustomerDTO customer, SaleDTO saleDTO) {
		List<DiscountDTO> eligibleDiscounts = new ArrayList<DiscountDTO>();
		for (DiscountDTO discount : discountDatabase) {
			if (eligibleDiscount(discount, customer, saleDTO))
				eligibleDiscounts.add(discount);
		}
		return eligibleDiscounts.toArray(new DiscountDTO[eligibleDiscounts.size()]);
	}

	private boolean eligibleDiscount(DiscountDTO discount, CustomerDTO customer, SaleDTO saleDTO) {
		return discount.getConditions().getCustomer().getIdentifier().equals(customer.getIdentifier()) && 
				discount.getConditions().getSalePrice().getPrice() <= saleDTO.getRunningTotal().getPrice() &&
				discount.getConditions().getNrOfItemsInSale() <= saleDTO.getSaleItems().size();
	}
}
