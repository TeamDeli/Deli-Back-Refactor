package com.deli.deliback.repository;

import com.deli.deliback.dto.ProductListDto;
import com.deli.deliback.dto.ProductSearchCondition;
import com.deli.deliback.dto.QProductListDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import static com.deli.deliback.model.QProduct.product;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public ProductRepositoryImpl(EntityManager em){
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public List<ProductListDto> search(ProductSearchCondition condition){
        return queryFactory
                .select(new QProductListDto(
                        product.id.as("id"),
                        product.gender,
                        product.age,
                        product.productname.as("productname"),
                        product.price,
                        product.imageUrl.as("imageUrl")
                ))
                .from(product)
                .where(genderEq(condition.getGender()),
                        ageEq(condition.getAge()),
                        product.price.between(condition.getPrice().get(0),condition.getPrice().get(1)))
                .fetch();
    }
    private BooleanExpression genderEq(Integer gender) {
        return gender!= null ? product.gender.eq(gender) : null;
    }

    private BooleanExpression ageEq(Integer age) {
        return age != null ? product.age.eq(age): null;
    }

    private BooleanExpression priceGoe(Integer priceGoe) {
        return priceGoe != null ? product.price.goe(priceGoe) : null;
    }

    private BooleanExpression priceLoe(Integer priceLoe) {
        return priceLoe != null ? product.price.loe(priceLoe) : null;
    }

    private BooleanExpression priceBetween(Integer priceLoe, Integer priceGoe) {
        return priceLoe(priceLoe).and(priceGoe(priceGoe));
    }

}
