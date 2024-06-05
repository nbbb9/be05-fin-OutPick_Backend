package com.encore.outpick_backend.Employee.mapper;

import java.util.List;

import com.encore.outpick_backend.Login.domain.LoginDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.encore.outpick_backend.Employee.domain.EmployeeDTO;

@Mapper
public interface EmployeeMapper {

    // 사원 리스트 조회
    public List<EmployeeDTO> read_employee_list();

    // 특정 사원 상세정보 조회
    public EmployeeDTO read_employee(int employee_id);

    // 특정 사원이 담당하고 있는 매장 조회
    public List<Integer> read_employee_shop(int employee_id);

    // 특정 사원의 기본정보, 담당 매장 수정
    public void update_employee_default(EmployeeDTO employee_info);
    public void update_employee_add(@Param("employee_id") int employee_id, @Param("addShopList") List<Integer> addShopList);
    public void update_employee_delete(@Param("employee_id") int employee_id, @Param("deleteShopList") List<Integer> deleteShopList);

    //로그인한 사원의 정보를 인포윈도우에 출력
    public List<EmployeeDTO> read_employee_infowindow(LoginDTO loginDTO);
}
