package com.encore.outpick_backend.Proposal.service;

import com.encore.outpick_backend.Proposal.domain.ProposalDTO;
import com.encore.outpick_backend.Proposal.mapper.ProposalMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProposalService {

    @Autowired
    private ProposalMapper proposalMapper;

    // 건의문 List 반환
    public List<ProposalDTO> get_proposal(int employee_number) {
        log.info("debug >> ProposalService: get_proposal");
        return proposalMapper.get_proposal(employee_number);
    }

    public List<ProposalDTO> get_proposal_admin(){
        log.info("debug >> ProposalService: get_proposal");
        return proposalMapper.get_proposal_admin();
    }

    // 건의문 상세보기 반환
    public ProposalDTO read_proposal(int proposal_id, int employee_number) {
        log.info("debug >> ProposalService: read_proposal");
        return proposalMapper.read_proposal(proposal_id, employee_number);
    }

    // 건의문 해결방안 작성/수정
    public void put_proposal_solution(ProposalDTO proposalDTO) {
        log.info("debug >> ProposalService: put_proposal_solution");
        proposalMapper.put_proposal_solution(proposalDTO);
    }

    // 건의문 해결안료 체크
    public void put_proposal_completed(ProposalDTO proposalDTO) {
        log.info("debug >> ProposalService: put_proposal_completed");
        proposalMapper.put_proposal_completed(proposalDTO);
    }

    public List<ProposalDTO> read_proposal_byshop(int shop_id){
        log.info("debug >> ProposalService: read_proposal_byshop");
        return proposalMapper.read_proposal_byshop(shop_id);
    }
}
