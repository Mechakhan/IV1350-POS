package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.dto.ItemGroupDTO;

/**
 * A class performing logic related to item groups.
 * @author William
 *
 */
public class ItemGroup {

	private ItemGroupDTO itemGroup;
	
	/**
	 * Creates new instance.
	 * @param itemGroup the item group object
	 */
	public ItemGroup(ItemGroupDTO itemGroup) {
		this.itemGroup = itemGroup;
	}
	
	/**
	 * Adds the quantity of the item(s) by a specified amount.
	 * @param amount the amount to be added to the quantity.
	 */
	public void addToQuantity (int amount) {
		if (amount < 0)
			amount = 0; // Throw Exception instead probably...
		int newQuantity = itemGroup.getQuantity() + amount;
		if (newQuantity < 0)
			newQuantity = Integer.MAX_VALUE; // Throw Exception instead probably...
		itemGroup.setQuantity(newQuantity);
	}
}
