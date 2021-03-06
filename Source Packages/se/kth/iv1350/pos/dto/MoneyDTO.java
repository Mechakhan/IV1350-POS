package se.kth.iv1350.pos.dto;

/**
 * A class representing an amount of money.
 * @author William
 *
 */
public class MoneyDTO {

	private double amount;
	
	/**
	 * Creates new instance.
	 * @param change the change to be returned to the customer.
	 */
	public MoneyDTO(double amount) {
		if (amount < 0)
			throw new IllegalArgumentException("The money amount can not be negative.");
		this.amount = amount;
	}
	
	/**
	 * Creates new instance based on existing instance.
	 * @param change the change to be returned to the customer.
	 */
	public MoneyDTO(MoneyDTO money) {
		this.amount = money.getAmount();
	}
	
	/**
	 * Get method that retrieves the change to be returned to the customer.
	 * @return the change to be returned to the customer.
	 */
	public double getAmount() {
		return amount;
	}
	
	@Override
	public String toString() {
		return "" + amount;
	}
}
