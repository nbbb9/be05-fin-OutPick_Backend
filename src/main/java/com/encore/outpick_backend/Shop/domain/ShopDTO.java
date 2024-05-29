package com.encore.outpick_backend.Shop.domain;

import lombok.Data;

@Data
public class ShopDTO {

    private int shop_id;//매장 ID
    private int employee_id;//사원 ID
    private String address;//주소
    private String contact;//연락처
    private String content;//설명
    private String manager;//운영자
    private String scale;//규모
    private String email;//이메일

}