package com.encore.outpick_backend.Login.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.encore.outpick_backend.Login.domain.LoginDTO;

@Mapper
public interface LoginMapper {

    public LoginDTO login_employee (LoginDTO user_info);
    public LoginDTO login_admin (LoginDTO user_info);

}