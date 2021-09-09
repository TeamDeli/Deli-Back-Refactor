package com.deli.deliback.service;

import com.deli.deliback.dto.ProductListDto;
import com.deli.deliback.model.Product;
import com.deli.deliback.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Product getProductById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Product id를 확인해주세요."));
    }

    @Transactional
    public List<ProductListDto> searchPosts(String keyword) {
        return productRepository.findByProductnameContaining(keyword);
    }
}
