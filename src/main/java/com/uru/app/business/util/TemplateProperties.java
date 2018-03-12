package com.uru.app.business.util;

import java.util.List;

public class TemplateProperties {
	
	private String calculationFunction;
	private String type;
	private List<Item> items;

	/**
	 * @return the calculationFunction
	 */
	public String getCalculationFunction() {
		return calculationFunction;
	}

	/**
	 * @param calculationFunction the calculationFunction to set
	 */
	public void setCalculationFunction(String calculationFunction) {
		this.calculationFunction = calculationFunction;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the items
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	

}
