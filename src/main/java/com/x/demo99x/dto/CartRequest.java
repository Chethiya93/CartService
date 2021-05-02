package com.x.demo99x.dto;

public class CartRequest {
    private Long productId;

    private int cartons;

    private int units;

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
}
