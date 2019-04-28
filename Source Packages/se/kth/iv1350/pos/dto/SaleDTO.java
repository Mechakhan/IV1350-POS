package se.kth.iv1350.pos.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * A DTO class containing information about the current Sale.
 * @author William
 *
 */
public class SaleDTO {
	
	private List<ItemGroupDTO> saleItems;
	private PriceDTO runningTotal;
	private int itemCount;
	
	/**
	 * Creates new instance.
	 * 
	 * @param itemGroups the items that have been added to the Sale.
	 * @param runningTotal the current running total of all items in the Sale, including vat.
	 */
	public SaleDTO(List<ItemGroupDTO> saleItems, PriceDTO runningTotal) {
		this.saleItems = saleItems;
		this.runningTotal = runningTotal;
		itemCount = 0;
		for (ItemGroupDTO itemGroup : saleItems)
			itemCount += itemGroup.getQuantity();
	}
	
	/**
	 * Get method that retrieves a deep copy of the sale items.
	 * @return a deep copy of the list of sale items.
	 */
	public List<ItemGroupDTO> getSaleItems(){
		List<ItemGroupDTO> saleItemsCopy = new ArrayList<ItemGroupDTO>();
		for (ItemGroupDTO itemGroup : saleItems)
			saleItemsCopy.add(itemGroup);
		return saleItemsCopy;
	}
	
	/**
	 * Get method that retrieves a deep copy of the running total, including vat.
	 * @return a deep copy of the running total, including vat.
	 */
	public PriceDTO getRunningTotal(){
		return new PriceDTO(runningTotal.getPrice(), runningTotal.getVAT());
	}
	
	/**
	 * Get method that retrieves the amount of items in the sale.
	 * @return the amount of items in the sale.
	 */
	public int getItemCount() {
		return itemCount;
	}
	
	/**
	 * Method that adds an item group into the list of sale items.
	 * @param itemGroupToAdd
	 */
	public void addToSaleItems(ItemGroupDTO itemGroupToAdd) {
		saleItems.add(itemGroupToAdd);
		itemCount += itemGroupToAdd.getQuantity();
	}
	
	/**
	 * Set method that updates the running total to a deep copy of the new running total object.
	 * @param runningTotal the new running total
	 */
	public void setRunningTotal(PriceDTO runningTotal){
		this.runningTotal = new PriceDTO(runningTotal.getPrice(), runningTotal.getVAT());
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("-----\nItems:\n");
		for (ItemGroupDTO itemGroup : saleItems)
			builder.append(itemGroup.toString() + "\n");
		builder.append("-----\n\nRunning total: " + runningTotal.toString() + "\n");
		return builder.toString();
	}
}
