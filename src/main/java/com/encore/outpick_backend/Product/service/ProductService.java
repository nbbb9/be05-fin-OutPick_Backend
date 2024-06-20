package com.encore.outpick_backend.Product.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.encore.outpick_backend.Product.domain.ProductDTO;
import com.encore.outpick_backend.Product.mapper.ProductMapper;

@Slf4j
@Service
public class ProductService {
    
    @Autowired
    private ProductMapper productMapper;
    
    // 상품 리스트 조회
    public List<ProductDTO> read_product_list() {
        log.info("read_product_list Service");
        return productMapper.read_product_list();
    }//read_product_list end

    // 상품 단일 조회
    public List<ProductDTO> read_product(Integer product_id) {
        log.info("read_product Service");
        return productMapper.read_product(product_id);
    }//read_product end

    // 상품 할인율 수정
    public void update_product_discount(Integer shop_id, Integer product_id, Integer discount) {
        log.info("update_product_discount Service");
        productMapper.update_product_discount(shop_id, product_id, discount);
    }//update_product_discount end

}