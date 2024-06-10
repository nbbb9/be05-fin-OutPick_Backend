package com.encore.outpick_backend.StockRequest.controller;

import com.encore.outpick_backend.Login.controller.LoginController;
import com.encore.outpick_backend.Login.domain.LoginDTO;
import com.encore.outpick_backend.StockRequest.domain.StockRequestDTO;
import com.encore.outpick_backend.StockRequest.service.StockRequestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/stockrequest")
@Tag(name = "재고요청서", description = "재고요청서와 관련된 API")
public class StockRequestController {

    private final StockRequestService stockRequestService;
    private final LoginController loginController;

    @Operation(summary = "재고요청서 전체 조회", description = "관리자 : 모든 재고요청서 리스트 전체 조회 / 사원 : 담당 매장의 재고요청서들 조회")
    @GetMapping("/list")
    public ResponseEntity<List<StockRequestDTO>> read_sr_list(@RequestHeader("login_token") String token){

        LoginDTO user = loginController.getTokenInfo(token);
        log.info("사번 : " + user.getEmployee_number());
        if(user.getRole().equals("사원")){ // 일반 사원
            return new ResponseEntity<List<StockRequestDTO>>(stockRequestService.read_sr_empList(user.getEmployee_number()), HttpStatus.OK);
        }else { // 관리자
            return new ResponseEntity<List<StockRequestDTO>>(stockRequestService.read_sr_list(), HttpStatus.OK);
        }
    }

    @Operation(summary = "재고요청서 단일 조회", description = "관리자 : 모든 재고요청서 단일 조회 / 사원 : 담당 매장의 재고요청서만 단일 조회 가능.")
    @GetMapping("/{formId}")
    public ResponseEntity<StockRequestDTO> read_sr_detail(@RequestHeader("login_token") String token, @PathVariable("formId") int id){

        LoginDTO user = loginController.getTokenInfo(token);

        if(user.getRole().equals("사원")){ // 일반 사원
            return new ResponseEntity<StockRequestDTO>(stockRequestService.read_sr_empDetail(user.getEmployee_number(), id), HttpStatus.OK);
        }else { // 관리자
            return new ResponseEntity<StockRequestDTO>(stockRequestService.read_sr_detail(id), HttpStatus.OK);
        }
    }

    // 재고요청서를 승인한다.
    @Operation(summary = "재고요청서 승인", description = "관리자 : 모든 재고요청서 승인 가능. / 사원 : 담당 매장의 재고요청서에 대해서만 승인 가능.")
    @PutMapping("/confirm/{formId}")
    public ResponseEntity<Void> update_sr(@RequestHeader("login_token") String token, @PathVariable("formId") int id){

        LoginDTO user = loginController.getTokenInfo(token);

        if (user.getRole().equals("사원")) { // 일반 사원
            stockRequestService.update_sr_emp(user.getEmployee_number(), id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else { // 관리자
            stockRequestService.update_sr(user.getEmployee_number(), id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    // 하나의 매장에 대한 재고요청서들의 리스트를 조회할 수 있다.
    @Operation(summary = "하나의 매장에 대한 재고요청서 리스트 조회", description = "로그인 필요 없음.")
    @GetMapping("/list/{shopId}")
    public ResponseEntity<List<StockRequestDTO>> read_sr_list(@PathVariable("shopId") int id){
        return new ResponseEntity<List<StockRequestDTO>>(stockRequestService.read_shop_sr_list(id), HttpStatus.OK);
    }

}