package com.encore.outpick_backend.Employee.service;

import java.util.List;
import com.encore.outpick_backend.Login.domain.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.encore.outpick_backend.Employee.domain.EmployeeDTO;
import com.encore.outpick_backend.Employee.mapper.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    // 사원 리스트 조회
    public List<EmployeeDTO> read_employee_list() {

        log.info("debug : service - read_employee_list");
       
        return employeeMapper.read_employee_list();
    }

    // 특정 사원 상세정보 조회
    public EmployeeDTO read_employee(int employee_id) {
       log.info("debug : service - read_employee");

       EmployeeDTO emp = employeeMapper.read_employee(employee_id);
       emp.setShop(employeeMapper.read_employee_shop(employee_id));

       return emp;
    }

    // 특정 사원의 기본정보, 담당 매장 수정
    public void update_employee(EmployeeDTO employee_info) {
        log.info("debug : service - update_employee");

        employeeMapper.update_employee_default(employee_info);
        if(employee_info.getAdd_shop().size() > 0){
            employeeMapper.update_employee_add(employee_info.getEmployee_id(), employee_info.getAdd_shop());
        }
        if(employee_info.getDelete_shop().size() > 0){
            employeeMapper.update_employee_delete(employee_info.getEmployee_id(), employee_info.getDelete_shop());
        }  
    }

    //로그인한 사원의 정보를 인포윈도우에 출력
    public List<EmployeeDTO> read_employee_infowindow(LoginDTO loginDTO){
        log.info("debug : service - read_employee_infowindow");

        return employeeMapper.read_employee_infowindow(loginDTO);
    }//read_employee_infowindow end
    
}