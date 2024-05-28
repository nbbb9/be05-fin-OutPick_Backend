package com.encore.outpick_backend.Product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.encore.outpick_backend.Product.domain.ProductDTO;

@Mapper
public interface ProductMapper {
    // 상품 리스트 조회
    public List<ProductDTO> read_product_list();
    
    // 상품 단일 조회
    public List<ProductDTO> read_product(Integer product_id);
}
