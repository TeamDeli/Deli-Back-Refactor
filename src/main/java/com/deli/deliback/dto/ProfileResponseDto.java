package com.deli.deliback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileResponseDto {
    HttpStatus status;
    private String userImage;
    private String username;
    private String comment;
    private int age;
    private String gender;
    private String birth;
    private List friends; //username 배열에 담기
    private List wishList;
}
