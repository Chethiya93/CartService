package com.x.demo99x.service;

import com.x.demo99x.dto.CartRequest;
import com.x.demo99x.dto.CartResponse;
import com.x.demo99x.dto.ProductPrice;
import com.x.demo99x.model.Cart;
import com.x.demo99x.model.Product;
import com.x.demo99x.repo.CartRepo;
import com.x.demo99x.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private  PriceEngineService priceEngineService;

    @Override
    public void addCart(CartRequest cartRequest, String userId){
        Optional<Product> optionalProduct = productRepo.findById(cartRequest.getProductId());
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            Cart cart = cartRepo.findByUserIdAndProductId(userId, product.getId());
            if(cart == null){
                cart = new Cart();
                cart.setUserId(userId);
                cart.setProductId(product.getId());
            }

            cartRequest.setCartons(cartRequest.getCartons() + cart.getCartons());
            cartRequest.setUnits(cartRequest.getUnits() + cart.getUnits());

            ProductPrice productPrice = priceEngineService.generatePrices(product, cartRequest.getCartons(), cartRequest.getUnits());

            cart.setCartons(productPrice.getCartons());
            cart.setUnits(productPrice.getUnits());
            cart.setTotalPrice(productPrice.getPrice());

            cartRepo.save(cart);
        }
        else{
            throw new RuntimeException();
        }

    }

    @Override
    public List<CartResponse> getCart(String userId){
        List<Cart> cartList = cartRepo.findByUserId(userId);
        List<CartResponse> cartResponseList = new ArrayList<>();
        if (cartList != null) {
            for (Cart cart : cartList) {
                Optional<Product> optionalProduct = productRepo.findById(cart.getProductId());
                if (optionalProduct.isPresent()) {
                    Product product = optionalProduct.get();
                    CartResponse cartResponse = new CartResponse();
                    cartResponse.setUserId(userId);
                    cartResponse.setProductId(cart.getProductId());
                    cartResponse.setCartons(cart.getCartons());
                    cartResponse.setUnits(cart.getUnits());;

                    ProductPrice productPrice = priceEngineService.generatePrices(product, cart.getCartons(), cart.getUnits());

                    cartResponse.setCartonPrice(productPrice.getCartoonPrice());
                    cartResponse.setUnitPrice(productPrice.getUnitPrice());
                    cartResponse.setTotalPrice(productPrice.getPrice());

                    cartResponseList.add(cartResponse);
                }
                else{
                    throw new RuntimeException();
                }
            }
        }
        return cartResponseList;
    }

    @Override
    public void deletCart(String userId, Long productId){
        cartRepo.deleteByUserIdAndProductId(userId, productId);
    }
}
