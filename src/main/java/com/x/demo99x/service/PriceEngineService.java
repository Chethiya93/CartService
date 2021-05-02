/**
 * 
 */
package com.x.demo99x.service;


import com.x.demo99x.dto.ProductPrice;
import com.x.demo99x.model.Product;

public interface PriceEngineService {


	ProductPrice generatePrices(Product product, int cartons, int units);

}
