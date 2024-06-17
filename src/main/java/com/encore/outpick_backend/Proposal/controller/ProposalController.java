package com.encore.outpick_backend.Proposal.controller;

import com.encore.outpick_backend.Login.domain.LoginDTO;
import com.encore.outpick_backend.Login.controller.LoginController;
import com.encore.outpick_backend.Proposal.domain.ProposalDTO;
import com.encore.outpick_backend.Proposal.service.ProposalService;
import com.encore.outpick_backend.StockRequest.domain.StockRequestDTO;
import com.encore.outpick_backend.sse.SseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/proposal")
@Tag(name = "건의문", description = "건의문과 관련된 API")
public class ProposalController {

    @Autowired
    private ProposalService proposalService;

    @Autowired
    private LoginController loginController;

    @Autowired
    private SseController sseController;

    // 건의문 List 반환
    @Operation(summary = "건의문 리스트" , description = "건의문 목록을 불러오는 API")
    @GetMapping("/list")
    public ResponseEntity<List<ProposalDTO>> get_proposal(@RequestHeader("login_token") String token) {
        LoginDTO user = loginController.getTokenInfo(token);
        if(user.getRole().equals("사원")){
            List<ProposalDTO> proposals = proposalService.get_proposal(user.getEmployee_number());
            log.info("debug >> ProposalController: get_proposal");
            return ResponseEntity.ok(proposals);
        }else{
            List<ProposalDTO> proposals = proposalService.get_proposal_admin();
            log.info("debug >> ProposalController: get_proposal");
            return ResponseEntity.ok(proposals);
        }

    }

    // 건의문 상세보기 반환
    @Operation(summary = "건의문 상세보기" , description = "건의문 상세보기를 불러오는 API")
    @GetMapping("/{proposal_id}")
    public ResponseEntity<?> read_proposal(@PathVariable("proposal_id") int proposal_id, @RequestHeader("login_token") String token) {
        LoginDTO user = loginController.getTokenInfo(token);
        ProposalDTO proposalDTO = proposalService.read_proposal(proposal_id, user.getEmployee_number());
        if (proposalDTO == null) {
            return ResponseEntity.status(403).body("관리하는 매장의 건의문이 아닙니다.");
        }
        log.info("debug >> ProposalController: read_proposal");
        return ResponseEntity.ok(proposalDTO);
    }

    // 건의문 해결방안 작성/수정
    @Operation(summary = "건의문 해결방안 작성" , description = "해결방안 작성을 불러오는 api")
    @PutMapping("/solution_write")
    public ResponseEntity<?> put_proposal_solution(@RequestBody ProposalDTO proposalDTO, @RequestHeader("login_token") String token) {
        LoginDTO user = loginController.getTokenInfo(token);
        ProposalDTO existingProposal = proposalService.read_proposal(proposalDTO.getProposal_id(), user.getEmployee_number());
        // 사원이 관리하는 매장의 건의문이 아닌경우 접근 제한
        if (existingProposal == null) {
            return ResponseEntity.status(403).body("관리하는 매장의 건의문이 아닙니다.");
        }
        proposalService.put_proposal_solution(proposalDTO);
        log.info("debug >> ProposalController: put_proposal_solution");
        sseController.proposal_solution(proposalDTO.getShop_id(), proposalDTO.getProposal_id());
        return ResponseEntity.ok().build();
    }

    // 건의문 해결완료 체크
    @Operation(summary = "건의문 해결완료" , description = "해결완료 변경을 불러오는 api")
    @PutMapping("/checkComplete")
    public ResponseEntity<?> put_proposal_completed (@RequestBody ProposalDTO proposalDTO, @RequestHeader("login_token") String token) {
        LoginDTO user = loginController.getTokenInfo(token);
        ProposalDTO existingProposal = proposalService.read_proposal(proposalDTO.getProposal_id(), user.getEmployee_number());
        // 사원이 관리하는 매장의 건의문이 아닌경우 접근 제한
        if (existingProposal == null) {
            return ResponseEntity.status(403).body("관리하는 매장의 건의문이 아닙니다.");
        }
        proposalService.put_proposal_completed(proposalDTO);
        log.info("debug >> ProposalController: put_proposal_completed");
        return ResponseEntity.ok().build();
    }

    // 매장별 건의문 리스트
    @Operation(summary = "매장별 건의문 리스트" , description = "매장별 건의문 리스트를 불러오는 api")
    @GetMapping("/shop/{shop_id}")
    public ResponseEntity<List<ProposalDTO>> read_proposal_byshop (@PathVariable("shop_id") int shop_id){
        List<ProposalDTO> proposals = proposalService.read_proposal_byshop(shop_id);
        log.info("debug >> ProposalController: read_proposal_byshop");
        return ResponseEntity.ok(proposals);
    }
}