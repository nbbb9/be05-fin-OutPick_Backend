package com.encore.outpick_backend.Analyze.mapper;

import com.encore.outpick_backend.Analyze.domain.AnalyzeEntireVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnalyzeMapper {
    List<AnalyzeEntireVO> get_analyze_entire(int year);
}
