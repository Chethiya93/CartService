package com.x.demo99x.service;

import com.x.demo99x.dto.CartRequest;
import com.x.demo99x.dto.ProductPrice;
import com.x.demo99x.model.Cart;
import com.x.demo99x.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getProducts();
    List<ProductPrice> getPriceList(Long productId, int limit);


}
