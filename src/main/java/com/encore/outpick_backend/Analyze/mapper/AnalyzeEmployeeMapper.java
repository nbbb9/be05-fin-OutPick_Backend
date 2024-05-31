package com.encore.outpick_backend.Analyze.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.encore.outpick_backend.Analyze.domain.AERequestDTO;
import com.encore.outpick_backend.Analyze.domain.AEResponseDTO;

@Mapper
public interface AnalyzeEmployeeMapper {
    public List<AEResponseDTO> read_employee_analyze(AERequestDTO params);
}
