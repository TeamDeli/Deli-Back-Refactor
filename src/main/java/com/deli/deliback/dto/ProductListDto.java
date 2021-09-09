package com.deli.deliback.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class ProductListDto {
    private int id;
    private int gender;
    private int age;
    private int price;
    private String productname;
    private String imageUrl;

    @QueryProjection
    public ProductListDto(int id, int gender, int age, String productname, int price, String imageUrl) {
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.productname = productname;
        this.price = price;
        this.imageUrl = imageUrl;
    }
}

