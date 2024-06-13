package com.encore.outpick_backend.ProductionRequest.service;

import com.encore.outpick_backend.ProductionRequest.domain.ProductionRequestDTO;
import com.encore.outpick_backend.ProductionRequest.domain.ProductionUpdateDTO;
import com.encore.outpick_backend.ProductionRequest.domain.ProductionWriteDTO;
import com.encore.outpick_backend.ProductionRequest.mapper.ProductionRequestMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductionRequestService {

    private final ProductionRequestMapper productionRequestMapper;

    // 관리자가 생산요청서 전체 리스트를 조회한다.
    public List<ProductionRequestDTO> read_pr_list(){
        return productionRequestMapper.read_pr_list();
    }

    // 사원이 자신이 작성한 생산요청서 리스트를 조회한다.
    public List<ProductionRequestDTO> read_pr_empList(int employee_number){
        return productionRequestMapper.read_pr_empList(employee_number);
    }

    // 관리자는 모든 생산요청서의 상세정보(단일 정보)를 조회한다.
    public ProductionRequestDTO read_pr_detail(int id){
        return productionRequestMapper.read_pr_detail(id);
    }

    // 사원이 자기가 작성한 생산요청서의 상세정보(단일 정보)를 조회한다.
    public ProductionRequestDTO read_pr_empDetail(int employee_number, int id){
        return productionRequestMapper.read_pr_empDetail(employee_number, id);
    }

    // 관리자만 생산요청서에 대해서 승인할 수 있다.
    public void confirm_pr(int employee_number, int id){
        productionRequestMapper.confirm_pr(employee_number, id);
    }

    // 영업사원은 자신이 작성한 생산요청서만을 수정할 수 있다.
    public void update_pr(ProductionUpdateDTO productionUpdateDTO){
        productionRequestMapper.update_pr(productionUpdateDTO);
    }

    public void delete_pr(int employee_number, int id){
        productionRequestMapper.delete_pr(employee_number, id);
    }

    public void write_pr(ProductionWriteDTO productionWriteDTO){
        productionRequestMapper.write_pr(productionWriteDTO);
    }
}
