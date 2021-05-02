package com.x.demo99x.service;

import com.x.demo99x.dto.ProductPrice;
import com.x.demo99x.model.Cart;
import com.x.demo99x.model.Product;
import com.x.demo99x.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private  PriceEngineService priceEngineService;

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> getProducts() {

        return productRepo.findAll();
    }

    @Override
    public List<ProductPrice> getPriceList(Long productId, int limit)  {
        Optional<Product> optionalProduct = productRepo.findById(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            List<ProductPrice> productPriceList = new ArrayList<>();
            for (int i = 0; i <limit ; i++) {
                ProductPrice productPrice = priceEngineService.generatePrices(product,0,i);
                productPrice.setId(i);
                productPrice.setName(product.getName());
                productPriceList.add(productPrice);

            }
            return productPriceList;

        }
        else  throw new RuntimeException();


    }

    private Product getCartonPrice(Long productId) throws Exception {
        Optional<Product> product = productRepo.findById(productId);
        if (product.isPresent())
            return product.get();
        else
            throw  new Exception();

    }

}
