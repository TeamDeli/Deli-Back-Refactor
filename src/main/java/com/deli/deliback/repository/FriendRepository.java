package com.deli.deliback.repository;

import com.deli.deliback.model.Friends;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friends, Integer> {
    List<Friends> findByUserId(int user_id);
}
