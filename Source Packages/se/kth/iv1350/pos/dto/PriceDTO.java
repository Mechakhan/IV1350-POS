package se.kth.iv1350.pos.dto;

/**
 * A DTO class containing information about the costs of item groups or the entire sale.
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
	 * @param price
	 * @param vat
	 */
	public PriceDTO(double price, double vat) {
		if (price >= 0)
			this.price = price;
		else
			this.price = 0;
		if (vat >= 0)
			this.vat = vat;
		else
			this.vat = 0;
	}
	
	public double getPrice() {
		return price;
	}
	
	public double getVAT() {
		return vat;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setVAT(double vat) {
		this.vat = vat;
	}
	
	/**
	 * Returns the instance represented as a <code>String</code>.
	 */
	@Override
	public String toString() {
		return price + " | VAT: " + vat;
	}
}
