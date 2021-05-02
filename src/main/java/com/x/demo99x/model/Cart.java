/**
 * 
 */
package com.x.demo99x.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Table(name = "cart_vo")
public class Cart {

	@Id // its used to set primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String userId;

	private Long productId;

	private int cartons;

	private int units;

	private BigDecimal totalPrice = new BigDecimal("0.00");


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public int getCartons() {
		return cartons;
	}

	public void setCartons(int cartons) {
		this.cartons = cartons;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
}
