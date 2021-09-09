package com.deli.deliback.controller;

import com.deli.deliback.dto.ProductListDto;
import com.deli.deliback.dto.ProductSearchCondition;
import com.deli.deliback.model.Product;
import com.deli.deliback.repository.ProductRepository;
import com.deli.deliback.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductService productService;

    @CrossOrigin(origins = "*")
    @GetMapping("/getProducts")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK); // 200
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/getProducts")
    public ResponseEntity<?> searchMember(@RequestBody ProductSearchCondition condition){
        List<ProductListDto> result = null;
        if(condition==null){
            return new ResponseEntity<>(productService.findAll(), HttpStatus.OK); // 200
        }
        else if(condition.getKeyword()!=null) {
            result = productService.searchPosts(condition.getKeyword());
        }
        else{
            result = productRepository.search(condition);
            System.out.println(result);
        }
        return new ResponseEntity<List<ProductListDto>>(result, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<?> productById(@PathVariable int id){
        Product p = productService.getProductById(id);
        System.out.println(p);
        return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/search")
    public ResponseEntity<?> searchKeywords(@RequestParam(value="keyword") String keyword) {
        List<ProductListDto> searchResult = productService.searchPosts(keyword);
        return new ResponseEntity<List<ProductListDto>>(searchResult, HttpStatus.OK);
    }

}
