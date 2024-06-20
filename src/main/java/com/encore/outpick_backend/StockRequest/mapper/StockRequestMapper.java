package com.encore.outpick_backend.StockRequest.mapper;

import com.encore.outpick_backend.StockRequest.domain.FeedbackDTO;
import com.encore.outpick_backend.StockRequest.domain.StockRequestDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StockRequestMapper {
    public List<StockRequestDTO> read_sr_list();
    public List<StockRequestDTO> read_sr_empList(int employee_number);

    public StockRequestDTO read_sr_detail(int id);
    public StockRequestDTO read_sr_empDetail(int employee_number, int id);

    public void update_sr(int employee_number, int id);
    public void update_sr_emp(int employee_number, int id);

    public void refuse_sr(int employee_number, int id);

    public void add_feedback(FeedbackDTO feedbackDTO);

    public List<StockRequestDTO> read_shop_sr_list(int id);

}
