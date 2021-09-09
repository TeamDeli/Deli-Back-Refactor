package com.deli.deliback.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Anniversary {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false, length = 30)
    private String start;

    @Column(nullable = true, length = 30)
    private String end;

    @Column(nullable = true, length = 30)
    private String color;

}

