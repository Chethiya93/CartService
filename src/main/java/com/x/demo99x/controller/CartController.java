package com.x.demo99x.controller;

import com.x.demo99x.dto.CartRequest;
import com.x.demo99x.dto.ResponseVO;

import com.x.demo99x.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value ="/cart")
public class CartController {


    @Autowired
    CartService cartService;
    /**
     *
     * @param userId
     * @return
     */
    @PostMapping(value = "/{userId}", produces = "application/json")
    public ResponseEntity<Void> addCart(
            @RequestBody CartRequest cartRequest,
            @PathVariable("userId") String userId) throws Exception {
        cartService.addCart(cartRequest, userId);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    /**
     *
     * @param userId
     * @return
     */
    @GetMapping(value = "/{userId}", produces = "application/json")
    public ResponseEntity<ResponseVO> getCart(
            @PathVariable("userId") String userId) {
        return new ResponseEntity<ResponseVO>(
                new ResponseVO()
                        .success(cartService.getCart(userId)),HttpStatus.OK);
    }

    @DeleteMapping(value = "/{userId}/product/{productId}", produces = "application/json")
    public ResponseEntity<Void> removeProduct(
            @PathVariable("userId") String userId,
            @PathVariable("productId") Long productId) {
        cartService.deletCart(userId, productId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
