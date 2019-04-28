package se.kth.iv1350.pos.dto;

public class StoreDTO {

	private String name;
	private String address;
	
	/**
	 * Creates new instance.
	 * 
	 * @param name the name of the store.
	 * @param address the store's address.
	 */
	public StoreDTO(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return name + " | " + address;
	}
}
