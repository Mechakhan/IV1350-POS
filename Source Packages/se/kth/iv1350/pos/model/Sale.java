package se.kth.iv1350.pos.model;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.pos.dto.ItemGroupDTO;
import se.kth.iv1350.pos.dto.PriceDTO;
import se.kth.iv1350.pos.dto.SaleDTO;
import se.kth.iv1350.pos.integration.ItemSearcher;

/**
 * This class represents the current Sale and all related logic.
 * @author William
 *
 */
public class Sale {
	
	private SaleDTO saleLog;
	private Price price;
	
	/**
	 * Creates new instance.
	 */
	public Sale () {
		List<ItemGroupDTO> saleItems = new ArrayList<ItemGroupDTO>();
		PriceDTO runningTotal = new PriceDTO();
		saleLog = new SaleDTO(saleItems, runningTotal, 0);
		price = new Price(runningTotal);
	}
	
	/**
	 * Creates an ItemGroupDTO based on the identifier and quantity
	 * and adds it into the vector if it exists, or isn't null. 
	 * 
	 * @param identifier the identifier of the entered item(s).
	 * @param quantity the quantity of the entered item(s).
	 * @return A SaleDTO object based on information about the current Sale is returned.
	 * @throws InvalidItemException thrown when an item was not found.
	 */
	public String addItemGroup (String identifier, int quantity) throws InvalidItemException {
		if (!idInList(identifier, quantity)) {
			ItemGroupDTO foundItemGroup = new ItemSearcher().retrieveItemWithID(identifier, quantity);
			if (foundItemGroup != null) {
				saleLog.addToSaleItems(foundItemGroup);
				saleLog.setItemCount(calculateItemCount());
				updatePrice(foundItemGroup);
			}
			else
			{
				throw new InvalidItemException(identifier);
			}
		}
		return getSaleLog().toString();
	}
	
	private boolean idInList (String identifierLookedFor, int quantity) {
		List<ItemGroupDTO> saleItems = saleLog.getSaleItems();
		for (ItemGroupDTO itemGroup : saleItems) {
			if (itemGroup.getIdentifier().equals(identifierLookedFor)) {
				addExistingItemToSale(itemGroup, quantity);
				return true;
			}
		}
		return false;
	}
	
	private void addExistingItemToSale(ItemGroupDTO itemGroup, int quantityToAdd) {
		new ItemGroup(itemGroup).addToQuantity(quantityToAdd);
		saleLog.setItemCount(calculateItemCount());
		updatePrice(new ItemGroupDTO(itemGroup, quantityToAdd));
	}
	
	private int calculateItemCount() {
		int count = 0;
		for (ItemGroupDTO itemGroup : saleLog.getSaleItems())
			count += itemGroup.getQuantity();
		return count;
	}
	
	private void updatePrice(ItemGroupDTO itemGroup) {
		price.addToRunningTotal(itemGroup);
		price.addToVAT(itemGroup);
	}
	
	/**
	 * Get method that retrieves a sale log, or a deep copy the current sale.
	 * @return the log of the current sale.
	 */
	public SaleDTO getSaleLog() {
		return new SaleDTO(saleLog.getSaleItems(), saleLog.getRunningTotal(), saleLog.getItemCount());
	}

	/**
	 * Ends the current sale, meaning set running total to inactive, and returns the total price.
	 * @return the total price.
	 */
	public PriceDTO end() {
		price.setRunningTotalActive(false);
		return saleLog.getRunningTotal();
	}

	/**
	 * Set method that updates the running total attribute.
	 * @param runningTotal the new running total.
	 */
	public void setRunningTotal(PriceDTO runningTotal) {
		price.setRunningTotal(runningTotal);
	}
}
