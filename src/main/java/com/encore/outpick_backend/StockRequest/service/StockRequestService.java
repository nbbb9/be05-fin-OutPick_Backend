package com.encore.outpick_backend.StockRequest.service;


import com.encore.outpick_backend.StockRequest.domain.StockRequestDTO;
import com.encore.outpick_backend.StockRequest.mapper.StockRequestMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockRequestService {

    private final StockRequestMapper stockRequestMapper;

    // 모든 재고요청서 리스트 조회
    public List<StockRequestDTO> read_sr_list(){
        return stockRequestMapper.read_sr_list();
    }

    // 재고요성처 단일 조회(상세조회)
    public StockRequestDTO read_sr_detail(int id){
        return stockRequestMapper.read_sr_detail(id);
    }

    // 재고요청서를 승인
    public void update_sr(int id){
        stockRequestMapper.update_sr(id);
    }


}
