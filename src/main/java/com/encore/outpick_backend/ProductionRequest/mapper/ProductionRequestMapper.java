package com.encore.outpick_backend.ProductionRequest.mapper;

import com.encore.outpick_backend.ProductionRequest.domain.ProductionRequestDTO;
import com.encore.outpick_backend.ProductionRequest.domain.ProductionUpdateDTO;
import com.encore.outpick_backend.ProductionRequest.domain.ProductionWriteDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.http.ResponseEntity;
import java.util.List;

@Mapper
public interface ProductionRequestMapper {
    public List<ProductionRequestDTO> read_pr_list();
    public List<ProductionRequestDTO> read_pr_empList(int employee_number);

    public ProductionRequestDTO read_pr_detail(int id);

    public ProductionRequestDTO read_pr_empDetail(int employee_number, int id);

    public void confirm_pr(int employee_number, int id);

    public void update_pr(ProductionUpdateDTO productionUpdateDTO);

    public void delete_pr(int employee_number, int id);

    public void write_pr(ProductionWriteDTO productionWriteDTO);
}
