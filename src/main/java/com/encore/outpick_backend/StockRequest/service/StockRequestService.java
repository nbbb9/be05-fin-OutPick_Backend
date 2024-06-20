package com.encore.outpick_backend.StockRequest.service;


import com.encore.outpick_backend.StockRequest.domain.FeedbackDTO;
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
    // 사원
    public List<StockRequestDTO> read_sr_empList(int employee_number){
        return stockRequestMapper.read_sr_empList(employee_number);
    }

    // 관리자
    public List<StockRequestDTO> read_sr_list(){
        return stockRequestMapper.read_sr_list();
    }


    // 재고요성처 단일 조회(상세조회)
    // 관리자
    public StockRequestDTO read_sr_detail(int id){
        return stockRequestMapper.read_sr_detail(id);
    }

    // 사원
    public StockRequestDTO read_sr_empDetail(int employee_number, int id){
        return stockRequestMapper.read_sr_empDetail(employee_number, id);
    }

    // 관리자 :  재고요청서를 승인
    public void update_sr(int employee_number, int id){
        stockRequestMapper.update_sr(employee_number, id);
    }
    // 사원 : 재고요청서를 승인
    public void update_sr_emp(int employee_number, int id){
        stockRequestMapper.update_sr_emp(employee_number, id);
    }

    //재고요청서 반려
    public void refuse_sr(int employee_number, int id){
        stockRequestMapper.refuse_sr(employee_number, id);
    }

    //피드백 내용 저장
    public void add_feedback(FeedbackDTO feedbackDTO){
        stockRequestMapper.add_feedback(feedbackDTO);
    }

    // 하나의 매장에 대한 재고요청서들의 리스트를 조회할 수 있다.
    public List<StockRequestDTO> read_shop_sr_list(int id){
        return stockRequestMapper.read_shop_sr_list(id);
    }

}
