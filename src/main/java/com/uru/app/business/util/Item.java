package com.uru.app.business.util;

import java.util.List;

public class Item {
	
	private String itemName;
	private List<ItemSize> itemSize;
	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * @return the itemSize
	 */
	public List<ItemSize> getItemSize() {
		return itemSize;
	}
	/**
	 * @param itemSize the itemSize to set
	 */
	public void setItemSize(List<ItemSize> itemSize) {
		this.itemSize = itemSize;
	}
	
	

}
