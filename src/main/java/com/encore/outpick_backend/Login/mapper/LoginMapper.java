package com.encore.outpick_backend.Login.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.encore.outpick_backend.Login.domain.LoginDTO;

@Mapper
public interface LoginMapper {

    public LoginDTO login (LoginDTO user_info);

}