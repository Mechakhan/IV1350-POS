package se.kth.iv1350.pos.model;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.pos.dto.DiscountDTO;
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
		saleLog = new SaleDTO(saleItems, runningTotal);
		price = new Price(runningTotal);
	}
	
	/**
	 * Creates an ItemGroupDTO based on the identifier and quantity
	 * and adds it into the vector if it exists, or isn't null. 
	 * 
	 * @param identifier the identifier of the entered item(s).
	 * @param quantity the quantity of the entered item(s).
	 * @return A SaleDTO object based on information about the current Sale is returned.
	 */
	public SaleDTO addItemGroup (String identifier, int quantity) {
		if (!idInList(identifier, quantity)) {
			ItemGroupDTO foundItemGroup = new ItemSearcher().retrieveItemWithID(identifier, quantity);
			if (foundItemGroup != null) {
				saleLog.addToSaleItems(foundItemGroup); // Är detta logik?
				updatePrice(foundItemGroup);
			}
		}
		return getSaleLog();
	}
	
	private boolean idInList (String identifierLookedFor, int quantity) {
		boolean idWasFound = false;
		List<ItemGroupDTO> saleItems = saleLog.getSaleItems();
		for (ItemGroupDTO itemGroup : saleItems) {
			if (itemGroup.getIdentifier() == identifierLookedFor) {
				addExistingItemToSale(itemGroup, quantity);
				idWasFound = true;
			}
		}
		return idWasFound;
	}
	
	private void addExistingItemToSale(ItemGroupDTO itemGroup, int quantityToAdd) {
		new ItemGroup(itemGroup).addToQuantity(quantityToAdd);
		updatePrice(new ItemGroupDTO(itemGroup, quantityToAdd));
	}
	
	private void updatePrice(ItemGroupDTO itemGroup) {
		price.addToRunningTotal(itemGroup);
		price.addToVAT(itemGroup);
	}
	
	/**
	 * Get method that retrieves a sale log, or a deep copy the current sale.
	 * @return
	 */
	public SaleDTO getSaleLog() {
		return new SaleDTO(saleLog.getSaleItems(), saleLog.getRunningTotal());
	}
	
	public void reduceFinalPrice(DiscountDTO[] discounts) {
		price.reduceFinalPrice (discounts);
	}
	
	/*public double getFinalPrice() {
		return price.getRunningTotal();
	}*/
}
