package se.kth.iv1350.pos.dto;

/**
 * A DTO class containing information about the running total of the entire sale.
 * @author William
 *
 */
public class PriceDTO {
	
	private double price;
	private double vat;
	private boolean active;
	
	/**
	 * Creates new instance with default attributes.
	 */
	public PriceDTO() {
		price = 0;
		vat = 0;
		active = true;
	}
	
	/**
	 * Creates new instance.
	 * @param price represents an amount of money
	 * @param vat represents the VAT rate of the amount.
	 */
	public PriceDTO (double price, double vat, boolean active) {
		if (price < 0 || vat < 0)
			throw new IllegalArgumentException("The price or VAT can not be negative.");
		this.price = price;
		this.vat = vat;
		this.active = active;
	}

	/**
	 * Get method that retrieves the price of the sale, including VAT.
	 * @return the price attribute.
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Get method that retrieves the how much of the price consists of VAT.
	 * @return the VAT attribute.
	 */
	public double getVAT() {
		return vat;
	}
	
	/**
	 * Set method that updates the price attribute, which cannot be negative or lower than the current VAT.
	 * @param quantity the new price.
	 */
	public void setPrice(double price) {
		if (price < vat)
			price = vat;
		if (price < 0)
			price = 0;
		this.price = price;
	}
	
	/**
	 * Set method that updates the VAT attribute, which cannot be negative.
	 * @param quantity the new VAT.
	 */
	public void setVAT(double vat) {
		if (vat < 0)
			vat = 0;
		this.vat = vat;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("-----\n\n");
		if (active)
			builder.append("Running total: ");
		else
			builder.append("Total price: ");
		builder.append(price + " | VAT: " + vat);
		return builder.toString();
	}

	/**
	 * Set method that changes whether the running total is active.
	 * @param active indicates the state of the running total.
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean getActive() {
		return active;
	}
}
