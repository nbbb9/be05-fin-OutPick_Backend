package com.encore.outpick_backend.ProductionRequest.controller;


import com.encore.outpick_backend.Login.controller.LoginController;
import com.encore.outpick_backend.Login.domain.LoginDTO;
import com.encore.outpick_backend.ProductionRequest.domain.ProductionRequestDTO;
import com.encore.outpick_backend.ProductionRequest.domain.ProductionUpdateDTO;
import com.encore.outpick_backend.ProductionRequest.domain.ProductionWriteDTO;
import com.encore.outpick_backend.ProductionRequest.service.ProductionRequestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/productionrequest")
@Tag(name = "생산요청서", description = "생산요청서와 관련된 API")
public class ProductionRequestController {

    private final ProductionRequestService productionRequestService;
    private final LoginController loginController;

    // 관리자 or사원 입장에서 생산요청서 리스트 조회
    @Operation(summary = "생산요청서 리스트 조회", description = "관리자 : 모든 생산요청서 리스트 전체 조회 / 사원 : 자신이 작성한 것들만")
    @GetMapping("/list")
    public ResponseEntity<List<ProductionRequestDTO>> read_pr_list(@RequestHeader("login_token") String token){
        LoginDTO user = loginController.getTokenInfo(token);
        log.info("사번 : " + user.getEmployee_number());
        if(user.getRole().equals("사원")){ // 일반 사원
            return new ResponseEntity<List<ProductionRequestDTO>>(productionRequestService.read_pr_empList(user.getEmployee_number()), HttpStatus.OK);
        }else { // 관리자
            return new ResponseEntity<List<ProductionRequestDTO>>(productionRequestService.read_pr_list(), HttpStatus.OK);
        }
    }

    // 관리자 or  사원 입장에서 생산요청서 상세정보(단일) 조회
    @Operation(summary = "생산요청서 단일 조회", description = "관리자 : 모든 생산요청서 단일 조회 / 사원 : 자신이 작성한 것만")
    @GetMapping("/{formId}")
    public ResponseEntity<ProductionRequestDTO> read_pr_detail(@RequestHeader("login_token") String token, @PathVariable("formId") int id){
        LoginDTO user = loginController.getTokenInfo(token);
        log.info("사번 : " + user.getEmployee_number());
        if(user.getRole().equals("사원")){ // 일반 사원
            return new ResponseEntity<ProductionRequestDTO>(productionRequestService.read_pr_empDetail(user.getEmployee_number(), id), HttpStatus.OK);
        }else { // 관리자
            return new ResponseEntity<ProductionRequestDTO>(productionRequestService.read_pr_detail(id), HttpStatus.OK);
        }
    }

    // 관리자는 영업사원이 작성한 생상요청서에 대해서 승인을 할 수 있다.
    @Operation(summary = "생산요청서 승인", description = "관리자만 승인할 수 있다.")
    @PutMapping("/confirm/{formId}")
    public ResponseEntity<Void> confirm_pr(@RequestHeader("login_token") String token, @PathVariable("formId") int id){
        LoginDTO user = loginController.getTokenInfo(token);

        if (user.getRole().equals("사원")) { // 일반 사원
            // 일반 사원일 경우, 아무것도 일어나지 않는다.
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else { // 관리자
            productionRequestService.confirm_pr(user.getEmployee_number(), id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    // 영업사원은 자신이 작성한 생산요청서의 내용을 수정할 수 있다.
    @Operation(summary = "생산요청서 수정", description = "사원만 자기 자신이 작성한 생산요청서를 수정할 수 있다.")
    @PutMapping("/update")
    public ResponseEntity<Void> update_pr(@RequestHeader("login_token") String token, @RequestBody ProductionUpdateDTO productionUpdateDTO){
        LoginDTO user = loginController.getTokenInfo(token);
        productionUpdateDTO.setEmployee_number(user.getEmployee_number());

        if (user.getRole().equals("사원")) { // 일반 사원일 경우에만 가능.
            productionRequestService.update_pr(productionUpdateDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } else { // 관리자
            // 관리자는 영업사원이 작성한 생산요청서를 수정할 수 없다.
            // code : 204
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    // 사원은 자신이 작성한 생산요청서를 삭제할 수 있다.
    @Operation(summary = "생산요청서 삭제", description = "사원만 자기 자신이 작성한 생산요청서를 삭제할 수 있다.")
    @DeleteMapping("/delete/{formId}")
    public ResponseEntity<Void> delete_pr(@RequestHeader("login_token") String token, @PathVariable("formId") int id){
        LoginDTO user = loginController.getTokenInfo(token);

        if (user.getRole().equals("사원")) { // 일반 사원
            productionRequestService.delete_pr(user.getEmployee_number(), id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else { // 관리자
            // 관리자일 경우, 아무것도 일어나지 않는다.
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    // 사원만 생산요청서를 작성할 수 있다.
    @Operation(summary = "생산요청서 작성", description = "사원만 생산요청서를 작성할 수 있다.")
    @PostMapping("/write")
    public ResponseEntity<Void> write_pr(@RequestHeader("login_token") String token, @RequestBody ProductionWriteDTO productionWriteDTO){
        LoginDTO user = loginController.getTokenInfo(token);
        productionWriteDTO.setEmployee_id(user.getId());

        if (user.getRole().equals("사원")) { // 일반 사원
            // 일반 사원만 작성 가능.
            productionWriteDTO.setEmployee_id(user.getId());
            productionRequestService.write_pr(productionWriteDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } else { // 관리자
            // 아무일도 일어나지 않는다.
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


}