package com.x.demo99x.service;

import com.x.demo99x.dto.CartRequest;
import com.x.demo99x.dto.CartResponse;
import com.x.demo99x.model.Cart;

import java.util.List;

public interface CartService {

    void addCart(CartRequest cartRequest, String userId);

    List<CartResponse> getCart(String userId);

    void deletCart(String userId, Long productId);
}
