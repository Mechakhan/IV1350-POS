package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.dto.CustomerDTO;
import se.kth.iv1350.pos.dto.DiscountDTO;
import se.kth.iv1350.pos.dto.SaleDTO;

public class DiscountSearcher {
	
	public DiscountSearcher() {
		
	}
	
	public DiscountDTO[] getEligibleDiscounts(CustomerDTO customer, SaleDTO saleDTO) {
		// Anropa databasen och hitta tillgängliga discounts för kunden.
		return null;
	}
}
