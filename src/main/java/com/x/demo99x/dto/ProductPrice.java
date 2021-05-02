/**
 * 
 */
package com.x.demo99x.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProductPrice {

	private int id;
	
	private String name;
	
	private int cartons;
	
	private int units;
	
	private BigDecimal price;

	private BigDecimal cartoonPrice;

	private BigDecimal unitPrice;

	public BigDecimal getCartoonPrice() {
		return cartoonPrice;
	}

	public void setCartoonPrice(BigDecimal cartoonPrice) {
		this.cartoonPrice = cartoonPrice;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public ProductPrice() {
		
	}

//	public ProductPrice(Product product, int id) {
//		this.id = id;
//		this.name = product.getName();
//		this.cartons = product.getCartons();
//		this.units = product.getUnits();
//		this.price = product.getTotalPrice().setScale(2, RoundingMode.HALF_UP);
//
//	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the cartons
	 */
	public int getCartons() {
		return cartons;
	}

	/**
	 * @param cartons the cartons to set
	 */
	public void setCartons(int cartons) {
		this.cartons = cartons;
	}

	/**
	 * @return the units
	 */
	public int getUnits() {
		return units;
	}

	/**
	 * @param units the units to set
	 */
	public void setUnits(int units) {
		this.units = units;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price.setScale(2, RoundingMode.HALF_UP);
	}
	
	
	
}
