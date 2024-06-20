package com.encore.outpick_backend.Product.controller;

import com.encore.outpick_backend.sse.SseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import com.encore.outpick_backend.Product.domain.ProductDTO;
import com.encore.outpick_backend.Product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Slf4j
@RestController
@RequestMapping("/product")
@Tag(name = "상품", description = "상품과 관련된 API")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SseController sseController;

    // 상품 리스트 조회
    @GetMapping("/list")
    @Operation(summary = "상품 리스트 조회" , description = "상품 목록을 조회")
    public ResponseEntity<List<ProductDTO>> read_product_list() {
        log.info("read_product_list Controller");
        List<ProductDTO> result = productService.read_product_list();
        return new ResponseEntity<List<ProductDTO>>(result,HttpStatus.OK);
    }//read_product_list end

    // 상품 단일 조회
    @GetMapping("/{product_id}")
    @Operation(summary = "상품 상세 조회" , description = "상품 단일 조회")
    public ResponseEntity<List<ProductDTO>> read_product (@PathVariable("product_id") Integer product_id) {
        log.info("read_product Controller");
        List<ProductDTO> result = productService.read_product(product_id);
        return new ResponseEntity<List<ProductDTO>>(result,HttpStatus.OK);
    }//read_product end
    
    // 상품 할인율 수정
    @PutMapping("/discount")
    @Operation(summary = "상품 할인율 수정" , description = "상품의 할인율을 수정하는 api")
    public void update_product_discount(@RequestBody ProductDTO product, Integer discount) {
        log.info("update_product_discount Controller");
        sseController.product_discount(product.getShop_id(), product.getProduct_id());
        productService.update_product_discount(product.getShop_id(),product.getProduct_id(), discount);
    }//update_product_discount end

}