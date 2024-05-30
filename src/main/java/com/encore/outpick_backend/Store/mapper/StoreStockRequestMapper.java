package com.encore.outpick_backend.Store.mapper;

import com.encore.outpick_backend.Product.domain.ProductDTO;
import com.encore.outpick_backend.Store.domain.StoreAddStockRequestDTO;
import com.encore.outpick_backend.Store.domain.StoreFeedbackDTO;
import com.encore.outpick_backend.Store.domain.StoreStockRequestDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreStockRequestMapper {

    //재고 요청서 작성
    public void create_stockRequest(StoreAddStockRequestDTO storeAddStockRequestDTO);

    //재고 요청서 작성 페이지 이동시 상품 정보 불러옴
    public List<ProductDTO> read_stockRequest_product();

    //재고 요청서 리스트
    public List<StoreStockRequestDTO> read_stockRequest_list(int shopid);

    //피드백 단일조회
    public StoreFeedbackDTO read_feedback(int formid);

}