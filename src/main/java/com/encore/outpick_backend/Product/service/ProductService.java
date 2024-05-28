package com.encore.outpick_backend.Product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.encore.outpick_backend.Product.domain.ProductDTO;
import com.encore.outpick_backend.Product.mapper.ProductMapper;

@Service
public class ProductService {
    
    @Autowired
    private ProductMapper productMapper;
    
    // 상품 리스트 조회
    public List<ProductDTO> read_product_list() {
        System.out.println(">>> debug Product Service read_product_list");
        return productMapper.read_product_list();
    }

    // 상품 단일 조회
    public List<ProductDTO> read_product(Integer product_id) {
        System.out.println(">>> debug Product Service read_product");
        return productMapper.read_product(product_id);
    }
}
