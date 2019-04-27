package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.dto.CustomerDTO;
import se.kth.iv1350.pos.dto.DiscountDTO;
import se.kth.iv1350.pos.dto.SaleDTO;
import se.kth.iv1350.pos.integration.DiscountSearcher;

public class DiscountHandler {
	
	public DiscountHandler () {}
	
	/*public double findDiscount (CustomerDTO customer, Sale sale) {
		SaleDTO saleDTO = sale.createSaleDTO();
		DiscountDTO[] discounts = new DiscountSearcher().getEligibleDiscounts(customer, saleDTO);
		sale.reduceFinalPrice(discounts);
		return sale.getFinalPrice();
		
	}*/
}
