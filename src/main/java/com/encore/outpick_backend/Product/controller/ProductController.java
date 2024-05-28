package com.encore.outpick_backend.Product.controller;

import org.springframework.web.bind.annotation.RestController;

import com.encore.outpick_backend.Product.domain.ProductDTO;
import com.encore.outpick_backend.Product.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@Tag(name = "상품", description = "상품과 관련된 api 목록")
public class ProductController {
    @Autowired
    private ProductService productService;

    // 상품 리스트 조회
    @GetMapping("/product")
    @Operation(summary = "상품 리스트" , description = "상품 목록을 불러오는 api")
    public ResponseEntity<List<ProductDTO>> read_product_list() {
        System.out.println(">>>> debug ProductController GET: /product");
        List<ProductDTO> result = productService.read_product_list();
        return new ResponseEntity<List<ProductDTO>>(result,HttpStatus.OK);
    }

    // 상품 단일 조회
    @GetMapping("/product/{product_id}")
    @Operation(summary = "상품 조회" , description = "상품을 단일 조회하는 api")
    public ResponseEntity<List<ProductDTO>> read_product (@RequestParam Integer product_id) {
        System.out.println(">>>> debug ProductController GET: /product/{product_id}");
        List<ProductDTO> result = productService.read_product(product_id);
        return new ResponseEntity<List<ProductDTO>>(result,HttpStatus.OK);
    }
    
    // 상품 할인율 수정
    @PutMapping("/discount")
    @Operation(summary = "상품 할인율 수정" , description = "상품의 할인율을 수정하는 api")
    public void update_product_discount(@RequestBody ProductDTO product, Integer discount) {
        System.out.println(">>>> debug ProductController PUT: /discount");
        productService.update_product_discount(product.getProduct_id(), discount);
    }
}
