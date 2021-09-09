package com.deli.deliback.repository;

import com.deli.deliback.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishListRepository extends JpaRepository<WishList, Integer> {
    List<WishList> findByUserId(int user_id);
}

