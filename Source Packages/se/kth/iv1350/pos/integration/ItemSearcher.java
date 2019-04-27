package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.dto.ItemDescriptionDTO;
import se.kth.iv1350.pos.dto.ItemGroupDTO;
import se.kth.iv1350.pos.dto.PriceDTO;

public class ItemSearcher {
	
	ItemGroupDTO[] itemDatabase;
	
	public ItemSearcher(){
		itemDatabase = new ItemGroupDTO[3];
		itemDatabase[0] = new ItemGroupDTO("ABC123", new PriceDTO(30.0, 0.25), 0, new ItemDescriptionDTO());
		itemDatabase[1] = new ItemGroupDTO("DEF456", new PriceDTO(49.0, 0.12), 0, new ItemDescriptionDTO());
		itemDatabase[2] = new ItemGroupDTO("GHI789", new PriceDTO(12.0, 0.06), 0, new ItemDescriptionDTO());
	}
	
	/**
	 * Calls the item database with the specified identifier and retrieves an item if it exists.
	 * @param identifier the identifier to look for
	 * @param quantity the quantity to of the item group to return if it was found.
	 * @return the item found in the item database <code>null</code> if no items were found.
	 */
	public ItemGroupDTO retrieveItemWithID (String identifierLookedFor, int quantity) {
		for (ItemGroupDTO databaseItem : itemDatabase) {
			if (databaseItem.getIdentifier().equals(identifierLookedFor))
				return new ItemGroupDTO(databaseItem, quantity);
		}
		return null;
	}
}