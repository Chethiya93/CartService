/**
 * 
 */
package com.x.demo99x.controller;

import com.x.demo99x.dto.ResponseVO;
import com.x.demo99x.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/products")
public class ProductServiceController {

@Autowired
ProductService productService;


	/**
	 *
	 * @return
	 */
	@GetMapping(value = "", produces = "application/json")
	public ResponseEntity<ResponseVO> getProducts(){
		return new ResponseEntity<ResponseVO>(new ResponseVO().success(productService.getProducts()), HttpStatus.OK);
	}

	/**
	 *
	 * @param productId
	 * @param limit
	 * @return
	 */
	@GetMapping(value = "/{productId}", produces = "application/json")
	public ResponseEntity<ResponseVO> getPriceList(
			@PathVariable("productId") Long productId,
			@RequestParam("limit") int limit) {
		return new ResponseEntity<ResponseVO>(new ResponseVO().success(productService.getPriceList(productId,limit)), HttpStatus.OK);
	}


}
