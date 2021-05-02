package com.x.demo99x.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;


@Entity
public class Product{

	@Id // its used to set primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private  String name;

	private BigDecimal cartonPrice;

	private String description;


	/*** units per carton***/
	private int unitsPerCarton;

    
	/*** discount ***/
	private BigDecimal discount;
   
	/*** per carton ***/
	private int perCarton;
    
	/*** single unit rate ***/
	private BigDecimal singleUnitRate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getCartonPrice() {
		return cartonPrice;
	}

	public void setCartonPrice(BigDecimal cartonPrice) {
		this.cartonPrice = cartonPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUnitsPerCarton() {
		return unitsPerCarton;
	}

	public void setUnitsPerCarton(int unitsPerCarton) {
		this.unitsPerCarton = unitsPerCarton;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public int getPerCarton() {
		return perCarton;
	}

	public void setPerCarton(int perCarton) {
		this.perCarton = perCarton;
	}

	public BigDecimal getSingleUnitRate() {
		return singleUnitRate;
	}

	public void setSingleUnitRate(BigDecimal singleUnitRate) {
		this.singleUnitRate = singleUnitRate;
	}
}
