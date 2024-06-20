package com.encore.outpick_backend.Product.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.encore.outpick_backend.Product.domain.ProductDTO;

@Mapper
public interface ProductMapper {
    // 상품 리스트 조회
    public List<ProductDTO> read_product_list();
    // 상품 단일 조회
    public List<ProductDTO> read_product(Integer product_id);
    // 상품 할인율 수정
    public void update_product_discount(@Param("shop_id") Integer shop_id, @Param("product_id") Integer product_id, @Param("discount") Integer discount);
}