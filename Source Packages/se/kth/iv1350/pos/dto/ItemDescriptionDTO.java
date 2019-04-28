package se.kth.iv1350.pos.dto;

public class ItemDescriptionDTO {
	
	private String name;
	
	/**
	 * Creates new instance.
	 * @param name the name of the item(s).
	 */
	public ItemDescriptionDTO(String name) {
		this.name = name;
	}
	
	/**
	 * Create a copy of an existing item description.
	 * @param description the description to make a copy of
	 */
	public ItemDescriptionDTO(ItemDescriptionDTO description) {
		this.name = new String(description.getName());
	}

	/**
	 * Get method that retrieves the item name.
	 * @return the name of the item(s).
	 */
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Name: " + name;
	}
}
