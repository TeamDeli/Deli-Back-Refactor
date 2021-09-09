package com.deli.deliback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductSearchCondition {
    //  성별, 나이, 가격대를 조건으로
    private Integer gender;
    private Integer age;
    private List<Integer> price;
    private String keyword;
}