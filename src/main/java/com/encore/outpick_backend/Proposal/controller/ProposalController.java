package com.encore.outpick_backend.Proposal.controller;

import com.encore.outpick_backend.Proposal.domain.ProposalDTO;
import com.encore.outpick_backend.Proposal.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proposal")
public class ProposalController {

    @Autowired
    private ProposalService proposalService;

    @GetMapping("/list")
    public List<ProposalDTO> proposalList(){
        proposalService.getList();
    }

    @GetMapping("/{proposal_id}")
    public ProposalDTO proposalById(@PathVariable("proposal_id") int proposal_id){
        proposalService.findProposalById(proposal_id);
    }

    @PostMapping("/solution")
    public void udpateSolution(@RequestBody ProposalDTO params){
        proposalService.updateSolution(params);
    }
}
