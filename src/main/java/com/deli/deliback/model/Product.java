package com.deli.deliback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicInsert
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Product_ID")
    private int id;

    @Column(nullable = false, length = 30)
    private String productname;

    @Column(nullable = true)
    private int star;

    @Column(nullable = false)
    private int gender;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false, length = 30)
    private String hash1;

    @Column(nullable = true, length = 30)
    private String hash2;

    @Column(nullable = true, length = 30)
    private String hash3;

    @Column(nullable = false, length = 200)
    private String info;

    @Column(nullable = true)
    private int price;

    @Column(nullable = false)
    private String imageUrl;

    @OneToMany(mappedBy="product")
    @JsonIgnore
    private List<SimilarProduct> similarProducts;

    public void addSimilarProduct(SimilarProduct similarProduct) {
        this.similarProducts.add(similarProduct);

        if(similarProduct.getProduct()!=this) {
            similarProduct.setProduct(this);
        }
    }
}

