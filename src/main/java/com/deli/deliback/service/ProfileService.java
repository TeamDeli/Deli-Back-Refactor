package com.deli.deliback.service;

import com.deli.deliback.model.Friends;
import com.deli.deliback.model.User;
import com.deli.deliback.model.WishList;
import com.deli.deliback.repository.FriendRepository;
import com.deli.deliback.repository.UserRepository;
import com.deli.deliback.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final UserRepository userRepository;
    private final WishListRepository wishListRepository;
    private final FriendRepository friendRepository;

    //프로필에 띄울 사용자 가져오기
    @Transactional
    public User getUserInfo(int id) {
        User user = userRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("해당 사용자는 없습니다.");
        });
        return user;
    }

    //친구리스트 가져오기
    public List getFriendList(int id) {
        List<Friends> friendList = (List<Friends>) friendRepository.findByUserId(id);
        return friendList;
    }

    //위시리스트 가져오기
    public List getWishList(int id) {
        List<WishList> wishList = (List<WishList>) wishListRepository.findByUserId(id);
        return wishList;
    }
}
