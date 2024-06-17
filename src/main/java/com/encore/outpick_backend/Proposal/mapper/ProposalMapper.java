package com.encore.outpick_backend.Proposal.mapper;

import com.encore.outpick_backend.Proposal.domain.ProposalDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProposalMapper {

    // 건의문 List 반환
    List<ProposalDTO> get_proposal(@Param("employee_number") int employee_number);

    List<ProposalDTO> get_proposal_admin();

    // 건의문 상세보기 반환
    ProposalDTO read_proposal(@Param("proposal_id") int proposal_id, @Param("employee_number") int employee_number);

    // 건의문 해결방안 작성/수정
    void put_proposal_solution(ProposalDTO proposalDTO);

    // 건의문 해결완료 체크
    void put_proposal_completed(ProposalDTO proposalDTO);

    // 매장별 건의문 리스트
    List<ProposalDTO> read_proposal_byshop(int shop_id);
}
