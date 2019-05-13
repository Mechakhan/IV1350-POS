package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.dto.DiscountConditionDTO;
import se.kth.iv1350.pos.dto.PriceDTO;
import se.kth.iv1350.pos.integration.Discount;

public class ModifierDiscount implements Discount {

	DiscountConditionDTO conditions;
	double reduceModifier;
	
	public ModifierDiscount(DiscountConditionDTO conditions, double reduceModifier) {
		this.conditions = conditions;
		this.reduceModifier = reduceModifier;
	}
	
	public PriceDTO apply(PriceDTO price) {
		return new PriceDTO(price.getPrice() * reduceModifier, price.getVAT(), false);
	}

	public DiscountConditionDTO getConditions() {
		return conditions;
	}

}
