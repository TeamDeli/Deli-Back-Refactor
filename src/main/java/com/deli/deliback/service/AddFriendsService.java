package com.deli.deliback.service;

import com.deli.deliback.model.User;
import com.deli.deliback.model.WishList;
import com.deli.deliback.repository.UserRepository;
import com.deli.deliback.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddFriendsService {

    private final UserRepository userRepository;
    private final WishListRepository wishListRepository;

    //모든 사용자 프로필정보 정보 불러오기
    @Transactional
    public List<User> getAllUserInfo() {
        List<User> AllUserProfiles = userRepository.findAll();
        return AllUserProfiles;
    }

    //위시리스트 가져오기
    public List<WishList> getWishList(int id) {
        List<WishList> wishList = wishListRepository.findByUserId(id);
        return wishList;
    }
}
