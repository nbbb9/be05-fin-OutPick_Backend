package com.encore.outpick_backend.Store.domain;

import lombok.Data;

@Data
public class StoreReadProposalDTO {

    private int proposal_id;//건의문ID
    private int shop_id;//매장ID
    private String title;//제목
    private String content;//내용
    private String date;//작성일
    private String category;//카테고리
    private String completed;//해결여부
    private String solution;//해결방안

}