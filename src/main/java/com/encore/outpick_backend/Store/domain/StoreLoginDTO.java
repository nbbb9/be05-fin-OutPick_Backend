package com.encore.outpick_backend.Store.domain;

import lombok.Data;

@Data
public class StoreLoginDTO {

    private String name;//매장명
    private String email;//운영자 이메일
    private String manager;//운영자 이름
    private int shop_id;//매장 ID

}