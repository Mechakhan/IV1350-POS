package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.dto.StoreDTO;

/**
 * Class that retrieves information about
 * the store from a database.
 * @author William
 *
 */
public class StoreDataRetriever {

	StoreDTO storeData;
	
	public StoreDataRetriever() {
		storeData = new StoreDTO("StoreName", "Some Street");
	}
	
	public StoreDTO getStoreData() {
		return storeData;
	}
}
