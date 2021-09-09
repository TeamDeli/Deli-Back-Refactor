package com.deli.deliback.repository;

import com.deli.deliback.dto.ProductListDto;
import com.deli.deliback.dto.ProductSearchCondition;

import java.util.List;

public interface ProductRepositoryCustom {
    List<ProductListDto> search(ProductSearchCondition condition);
}
