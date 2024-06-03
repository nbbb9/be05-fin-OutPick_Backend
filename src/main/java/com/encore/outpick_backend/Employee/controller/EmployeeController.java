package com.encore.outpick_backend.Employee.controller;

import org.springframework.web.bind.annotation.RestController;
import com.encore.outpick_backend.Employee.domain.EmployeeDTO;
import com.encore.outpick_backend.Employee.service.EmployeeService;
import com.encore.outpick_backend.Login.controller.LoginController;
import com.encore.outpick_backend.Login.domain.LoginDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Slf4j
@RestController
@RequestMapping("/employee")
@Tag(name = "사원", description = "사원과 관련된 API")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private LoginController lc;

    @GetMapping("/list")
    @Operation(summary = "사원 리스트 조회" , description = "사원 목록을 리스트로 조회")
    public ResponseEntity<List<EmployeeDTO>> read_employee_list (@RequestHeader("login_token") String token ) {
        log.info("debug : employee/list - read_employee_list");

        LoginDTO user = lc.getTokenInfo(token);

        if(user.getRole().equals("사원")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<List<EmployeeDTO>>( employeeService.read_employee_list(), HttpStatus.OK);
        }
    }//read_employee_list end

    @GetMapping("/{employeeid}")
    @Operation(summary = "사원 상세정보" , description = "특정 사원의 상세정보 조회")
    public ResponseEntity<EmployeeDTO> read_employee(@PathVariable("employeeid") int employee_id, @RequestHeader("login_token") String token) {
        log.info("debug : employee/list - read_employee");

        LoginDTO user = lc.getTokenInfo(token);

        if(user.getRole().equals("사원")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<EmployeeDTO>( employeeService.read_employee(employee_id) , HttpStatus.OK);
        }
    }//read_employee end

    @PutMapping("/update")
    @Operation(summary = "사원 정보 수정" , description = "사원의 기본정보, 담당 매장을 수정")
    public void update_employee(@RequestBody EmployeeDTO employee_info, @RequestHeader("login_token") String token) {

        log.info("debug : employee/update - update_employee");

        LoginDTO user = lc.getTokenInfo(token);

        if(!user.getRole().equals("사원")){
            employeeService.update_employee(employee_info);
        }
    }//update_employee end

    @GetMapping("/mypage")
    @Operation(summary = "사원 정보를 인포윈도우에서 확인", description = "로그인한 사원의 정보 조회")
    public ResponseEntity<List<EmployeeDTO>> read_employee_infowindow(@RequestHeader("login_token") String token){
        log.info("debug : 로그인한 사원의 정보를 인포윈도우에 출력" , "token : " , token);

        LoginDTO user = lc.getTokenInfo(token);

        return new ResponseEntity<List<EmployeeDTO>>(employeeService.read_employee_infowindow(user), HttpStatus.OK);
    }//read_employee_infowindow end

}