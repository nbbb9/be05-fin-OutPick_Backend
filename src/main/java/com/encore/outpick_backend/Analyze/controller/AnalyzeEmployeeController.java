package com.encore.outpick_backend.Analyze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.encore.outpick_backend.Analyze.domain.AERequestDTO;
import com.encore.outpick_backend.Analyze.domain.AEResultDTO;
import com.encore.outpick_backend.Analyze.service.AnalyzeEmployeeService;
import com.encore.outpick_backend.Login.controller.LoginController;
import com.encore.outpick_backend.Login.domain.LoginDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@RestController
@Tag(name = "통계/분석", description = "관리자의 각 사원별 담당매장 월별분석")
public class AnalyzeEmployeeController {
    @Autowired
    AnalyzeEmployeeService analyzeEmployeeService;

    @Autowired
    LoginController loginController;

    @Operation(summary = "담당매장 월별분석", description = "사원이 담당한 매장의 월별 판매량을 분석.")
    @GetMapping("/employee_analyze")
    public ResponseEntity<AEResultDTO> read_employee_analyze(@RequestHeader("login_token") String token, @RequestParam int employee_id, @RequestParam int month, @RequestParam int year) {
        log.info(">>> debug AnalyzeEmployeeController GET: /employee_analyze/{employee_id}");

        LoginDTO user = loginController.getTokenInfo(token);
        if (user.getRole().equals("사원")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {

            AERequestDTO params = new AERequestDTO();
            params.setEmployee_id(employee_id);
            params.setMonth(month);
            params.setYear(year);           
            return new ResponseEntity<AEResultDTO>(analyzeEmployeeService.read_employee_analyze(params),HttpStatus.OK);
        }
    }//read_employee_analyze end

}