package com.encore.outpick_backend.StockRequest.mapper;

import com.encore.outpick_backend.Login.domain.LoginDTO;
import com.encore.outpick_backend.StockRequest.domain.StockRequestDTO;

import java.util.List;

public interface StockRequestMapper {
    public List<StockRequestDTO> read_sr_list();
    public List<StockRequestDTO> read_sr_empList(int employee_number);

    public StockRequestDTO read_sr_detail(int id);
    public StockRequestDTO read_sr_empDetail(int employee_number, int id);

    public void update_sr(int id);
    public void update_sr_emp(int employee_number, int id);
}
