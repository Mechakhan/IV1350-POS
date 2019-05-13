package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.dto.DiscountConditionDTO;
import se.kth.iv1350.pos.dto.PriceDTO;
import se.kth.iv1350.pos.integration.Discount;

public class SubtractDiscount implements Discount {

	DiscountConditionDTO conditions;
	double reduceConstant;
	
	public SubtractDiscount(DiscountConditionDTO conditions, double reduceConstant) {
		this.conditions = conditions;
		this.reduceConstant = reduceConstant;
	}
	
	public PriceDTO apply(PriceDTO price) {
		return new PriceDTO(price.getPrice() - reduceConstant, price.getVAT(), false);
	}

	public DiscountConditionDTO getConditions() {
		return conditions;
	}

}
