package com.deli.deliback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class SimilarProduct {
    @Id
    @GeneratedValue
    @Column(name = "SimilarProduct_ID")
    private int id;

    @ManyToOne
    @JoinColumn(name="Product_ID")
    @JsonIgnore
    private Product product;

    public void setProduct(Product product) {
        this.product=product;

        if(!product.getSimilarProducts().contains(this)) {
            product.getSimilarProducts().add(this);
        }
    }
}
