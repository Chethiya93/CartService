/**
 * 
 */
package com.x.demo99x.service;

import com.x.demo99x.dto.ProductPrice;
import com.x.demo99x.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PriceEngineServiceImpl implements PriceEngineService {

	private static final Logger log = LoggerFactory.getLogger(PriceEngineServiceImpl.class);


	
	@Override
	public ProductPrice generatePrices(Product product, int cartons, int units)  {
		try {
			if (product != null) {
				log.debug("Generating prices");
        		int newCarton = calulateCartonCount(units, product.getUnitsPerCarton());
				newCarton+=cartons;
				int newUnits = calulateUnitCount(units, product.getUnitsPerCarton());

        		
        		BigDecimal perUnitPrice = product.getCartonPrice().add(product.getCartonPrice()
        				.multiply(product.getSingleUnitRate()));
        		perUnitPrice=perUnitPrice.divide(BigDecimal.valueOf(product.getUnitsPerCarton()));
        				
        		BigDecimal totalUnitPrice = perUnitPrice
        				.multiply(BigDecimal.valueOf(newUnits));

        		BigDecimal totalCartonPrice = product.getCartonPrice()
        				.multiply(BigDecimal.valueOf(newCarton));
        		ProductPrice productPrice = new ProductPrice();
        		productPrice.setCartons(newCarton);
        		productPrice.setUnits(newUnits);
        		productPrice.setPrice(totalUnitPrice.add(totalCartonPrice));
				productPrice.setUnitPrice(totalUnitPrice);
				productPrice.setCartoonPrice(totalCartonPrice);

				return productPrice;

	        }
			else throw  new RuntimeException();
		}
		catch (Exception e) {
			throw new RuntimeException( "Exceptin throw while generating price");
		}
		
	}
	
	private int calulateUnitCount(int units, int unitsPerCarton) {
		if(units>=unitsPerCarton) {
			return (units%unitsPerCarton);
		}
		return units;
	}
	
	private int calulateCartonCount(int units, int unitsPerCarton) {
		return units/unitsPerCarton;
	}
}
