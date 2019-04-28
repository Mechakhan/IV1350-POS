package se.kth.iv1350.pos.dto;

public class CustomerDTO {
	
	private String identifier;
	
	/**
	 * Creates new instance.
	 * @param identifier the customer ID.
	 */
	public CustomerDTO (String identifier){
		this.identifier = identifier;
	}
	
	/**
	 * Get method that retrieves the identifier of the customer.
	 * @return the customer ID.
	 */
	public String getIdentifier() {
		return identifier;
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof CustomerDTO))
			return false;
		CustomerDTO otherCustomer = (CustomerDTO)other;
		return identifier.equals(otherCustomer.getIdentifier());
	}
}
