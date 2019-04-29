package se.kth.iv1350.pos.dto;

import se.kth.iv1350.pos.enumerables.DiscountType;

/**
 * A class representing different types of discounts.
 * @author William
 *
 */
public class DiscountDTO {
	
	private DiscountType type;
	private DiscountConditionDTO conditions;
	private double reduceConstant;
	private double reduceModifier;
	
	/**
	 * Creates new instance.
	 * 
	 * @param type the type of discount that can be applied.
	 * @param applicableItem the item that the discount can be applied to.
	 * @param reduceConstant the constant that the price can be reduced by.
	 * @param reduceModifier the modifier that the price can be multiplied by.
	 */
	public DiscountDTO (DiscountType type, DiscountConditionDTO conditions, double reduceConstant, double reduceModifier) {
		this.type = type;
		this.conditions = new DiscountConditionDTO (conditions);
		if (reduceConstant < 0)
			reduceConstant = 0;
		this.reduceConstant = reduceConstant;
		if (reduceModifier <= 0 || reduceModifier > 1)
			reduceModifier = 1;
		this.reduceModifier = reduceModifier;	
	}

	/**
	 * Get method that retrieves the type enumerate of the discount.
	 * @return the type of discount.
	 */
	public DiscountType getType() {
		return type;
	}

	/**
	 * Get method that retrieves the conditions for the discount to be eligible.
	 * @return the discount conditions.
	 */
	public DiscountConditionDTO getConditions() {
		return new DiscountConditionDTO(conditions);
	}
	
	/**
	 * Get method that retrieves the price reduce constant of the discount.
	 * @return the price reduce constant.
	 */
	public double getReduceConstant() {
		return reduceConstant;
	}
	
	/**
	 * Get method that retrieves the price reduce modifier of the discount.
	 * @return the price reduce modifier.
	 */
	public double getReduceModifier() {
		return reduceModifier;
	}
}
