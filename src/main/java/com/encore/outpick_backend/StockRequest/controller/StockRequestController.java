package com.encore.outpick_backend.StockRequest.controller;

import com.encore.outpick_backend.Login.controller.LoginController;
import com.encore.outpick_backend.Login.domain.LoginDTO;
import com.encore.outpick_backend.StockRequest.domain.StockRequestDTO;
import com.encore.outpick_backend.StockRequest.service.StockRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stockrequest")
public class StockRequestController {

    private final StockRequestService stockRequestService;
    private final LoginController loginController;

    @GetMapping("/list")
    public ResponseEntity<List<StockRequestDTO>> read_sr_list(@RequestHeader("login_token") String token){

        LoginDTO user = loginController.getTokenInfo(token);

        if(user.getRole().equals("사원")){ // 일반 사원
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else { // 관리자
            return new ResponseEntity<List<StockRequestDTO>>(stockRequestService.read_sr_list(), HttpStatus.OK);
        }

    }

    @GetMapping("/{formId}")
    public ResponseEntity<StockRequestDTO> read_sr_detail(@RequestHeader("login_token") String token, @PathVariable("formId") int id){

        LoginDTO user = loginController.getTokenInfo(token);

        if(user.getRole().equals("사원")){ // 일반 사원
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else { // 관리자
            return new ResponseEntity<StockRequestDTO>(stockRequestService.read_sr_detail(id), HttpStatus.OK);
        }

    }

    // 재고요청서를 승인한다.
    @PutMapping("/confirm/{formId}")
    public ResponseEntity<Void> update_sr(@RequestHeader("login_token") String token, @PathVariable("formId") int id){

        LoginDTO user = loginController.getTokenInfo(token);

        if (user.getRole().equals("사원")) { // 일반 사원
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else { // 관리자
            stockRequestService.update_sr(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }




}
