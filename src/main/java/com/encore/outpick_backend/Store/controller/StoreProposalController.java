package com.encore.outpick_backend.Store.controller;

import com.encore.outpick_backend.Store.domain.StoreAddProposalDTO;
import com.encore.outpick_backend.Store.domain.StoreReadProposalDTO;
import com.encore.outpick_backend.Store.service.StoreProposalService;
import com.encore.outpick_backend.sse.SSEOfficeEmitters;
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
@Tag(name = "건의사항_매장프로그램", description = "건의사항과 관련된 API")
@RequestMapping("/store/proposal")
public class StoreProposalController {

    @Autowired
    private StoreProposalService storeProposalService;

    @Autowired
    private SSEOfficeEmitters sseOfficeEmitters;

    @Operation(summary = "건의사항 작성")
    @PostMapping("/add")
    public void create_proposal (@RequestBody StoreAddProposalDTO storeAddProposalDTO){
        log.info("건의사항 작성 Controller");

        int shopID = storeAddProposalDTO.getShop_id();

        int employeeID = storeProposalService.find_employee_id(shopID);

        sseOfficeEmitters.add_proposal(shopID, employeeID);

        storeProposalService.create_proposal(storeAddProposalDTO);
    }//create_proposal end

    @Operation(summary = "건의사항 리스트 조회")
    @GetMapping("/list/{shopid}")
    public ResponseEntity<List<StoreReadProposalDTO>> read_proposals (@PathVariable("shopid") int shopid){
        log.info("건의사항 리스트 Controller");

        return new ResponseEntity<>(storeProposalService.read_proposals(shopid), HttpStatus.OK);
    }//read_proposals end

}