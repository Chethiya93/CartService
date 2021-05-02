package com.x.demo99x.repo;

import com.x.demo99x.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {

    List<Cart> findByUserId(String userId);

    @Transactional
    void deleteByUserIdAndProductId(String userId, Long productId);

    Cart findByUserIdAndProductId(String userId, Long productId);
}
