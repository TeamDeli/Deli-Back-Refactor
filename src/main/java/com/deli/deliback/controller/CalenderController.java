package com.deli.deliback.controller;

import com.deli.deliback.model.Anniversary;
import com.deli.deliback.repository.AnniversaryRepository2;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/calendar")
public class CalenderController {

    @Autowired
    private AnniversaryRepository2 anniversaryrepository;

    @CrossOrigin
    @GetMapping(value="/get") //친구 캘린더(user_id)는 다시 공부 후 구현
    public List<Anniversary> getAllEvents() {
        return anniversaryrepository.findAll();
    }

    @CrossOrigin
    @PostMapping(value="/post")
    public Anniversary save(@RequestBody Anniversary anniversary) {
        return anniversaryrepository.save(anniversary);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        try {
            anniversaryrepository.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            return "삭제실패했습니다.";
        }
        return "삭제";
    }
}
