package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.dto.DiscountDTO;
import se.kth.iv1350.pos.dto.ItemGroupDTO;
import se.kth.iv1350.pos.dto.PriceDTO;

/**
 * A class performing logic related to the costs of sales.
 * @author William
 *
 */
public class Price {
	
	PriceDTO runningTotal;
	
	/**
	 * Creates new instance.
	 * 
	 * @param runningTotal the current running total of all items in the Sale, including vat.
	 */
	public Price(PriceDTO runningTotal) {
		this.runningTotal = runningTotal;
	}
	
	/**
	 * Adds the price of an item, including vat, to the running total.
	 * @param itemGroupToAdd the item group whose price is to be added to the running total.
	 */
	public void addToRunningTotal (ItemGroupDTO itemGroupToAdd) {
		int vatPercentage = 1;
		runningTotal.setPrice(runningTotal.getPrice() + calculateAmount(itemGroupToAdd, vatPercentage));
	}
	
	/**
	 * Adds the VAT of an item to the running total.
	 * @param itemGroupToAdd
	 */
	public void addToVAT (ItemGroupDTO itemGroupToAdd) {
		int vatPercentage = 0;
		runningTotal.setVAT(runningTotal.getVAT() + calculateAmount(itemGroupToAdd, vatPercentage));
	}
	
	private double calculateAmount (ItemGroupDTO itemGroup, int vatPercentage) {
		PriceDTO priceOfItem = itemGroup.getPrice();
		return priceOfItem.getPrice() * (vatPercentage + priceOfItem.getVAT()) * itemGroup.getQuantity();
	}
	
	public void reduceFinalPrice (DiscountDTO[] discounts) {
		// Gör något baserat på discount vektorn här...
	}
}
