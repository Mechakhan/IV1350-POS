package se.kth.iv1350.pos.dto;

/**
 * A DTO class containing information about the running total of the entire sale.
 * @author William
 *
 */
public class PriceDTO {
	
	double price;
	double vat;
	
	/**
	 * Creates new instance with default attributes.
	 */
	public PriceDTO() {
		price = 0;
		vat = 0;
	}
	
	/**
	 * Creates new instance.
	 * @param price represents an amount of money
	 * @param vat represents the VAT rate of the amount.
	 */
	public PriceDTO (double price, double vat) {
		if (price >= 0)
			this.price = price;
		else
			this.price = 0;
		if (vat >= 0)
			this.vat = vat;
		else
			this.vat = 0;
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
	 * Set method that updates the price attribute, which cannot be negative.
	 * @param quantity the new price.
	 */
	public void setPrice(double price) {
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
		return price + " | VAT: " + vat;
	}
}
