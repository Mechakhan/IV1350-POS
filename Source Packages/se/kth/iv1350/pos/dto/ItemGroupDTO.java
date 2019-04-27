package se.kth.iv1350.pos.dto;

/**
 * A DTO class containing information about an
 * item group bought by the customer.
 * @author William
 *
 */
public class ItemGroupDTO {
	
	String identifier;
	PriceDTO price;
	int quantity;
	ItemDescriptionDTO description;
	
	/**
	 * Creates new instance.
	 * 
	 * @param identifier the identifier of the item(s).
	 * @param price the individual cost of the item(s).
	 * @param vat the individual vat of the item(s).
	 * @param quantity the quantity of the item(s).
	 * @param description the description of the item(s).
	 */
	public ItemGroupDTO (String identifier, PriceDTO price, int quantity, ItemDescriptionDTO description) {
		this.identifier = identifier;
		this.price = price;
		if (quantity >= 0)
			this.quantity = quantity;
		else
			this.quantity = 0;
		this.description = description;
	}
	
	/**
	 * Creates new instance based on an existing item group, but with a new quantity.
	 * 
	 * @param itemGroup the item group whose attributes to copy.
	 * @param quantity the quantity of the item(s).
	 */
	public ItemGroupDTO (ItemGroupDTO itemGroup, int quantity) {
		this.identifier = itemGroup.getIdentifier();
		this.price = itemGroup.getPrice();
		if (quantity >= 0)
			this.quantity = quantity;
		else
			this.quantity = 0;
		this.description = itemGroup.getDescription();
	}
	
	/**
	 * Creates new instance based on an existing item group.	 * 
	 * @param itemGroup itemGroup the item group whose attributes to copy.
	 */
	public ItemGroupDTO (ItemGroupDTO itemGroup) {
		this.identifier = itemGroup.getIdentifier();
		this.price = itemGroup.getPrice();
		this.quantity = itemGroup.getQuantity();
		this.description = itemGroup.getDescription();
	}
	
	/**
	 * Get method that retrieves the identifier of the item(s).
	 * @return the identifier of the item(s).
	 */
	public String getIdentifier() {
		return identifier;
	}
	
	/**
	 * Get method that retrieves a deep copy of the item price.
	 * @return the item price and vat.
	 */
	public PriceDTO getPrice() {
		return new PriceDTO(price.getPrice(), price.getVAT());
	}
	
	/**
	 * Get method that retrieves the item quantity.
	 * @return the quantity of the item(s).
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Get method that retrieves the description of the item.
	 * @return the description of the item.
	 */
	public ItemDescriptionDTO getDescription() {
		return new ItemDescriptionDTO(description);
	}
	
	/**
	 * Set method that updates the quantity of the item(s).
	 * @param quantity the new quantity of the item(s).
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Returns the instance represented as a <code>String</code>.
	 */
	@Override
	public String toString() {
		return "ID: " + identifier + " | cost: " + price.toString() + " | x " + quantity;
	}
}
