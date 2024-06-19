package com.encore.outpick_backend.Store.service;

import com.encore.outpick_backend.Store.domain.StoreAddProposalDTO;
import com.encore.outpick_backend.Store.domain.StoreReadProposalDTO;
import com.encore.outpick_backend.Store.mapper.StoreProposalMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class StoreProposalService {

    @Autowired
    private StoreProposalMapper storeProposalMapper;

    public void create_proposal(StoreAddProposalDTO storeAddProposalDTO){
        log.info("건의사항 작성 Service");

        storeProposalMapper.create_proposal(storeAddProposalDTO);
    }//create_proposal end

    public int find_employee_id(int shop_id){
        log.info("작성한 건의사항의 담당 직원 Service");
        return storeProposalMapper.find_employee_id(shop_id);
    }//find_employee_id

    public List<StoreReadProposalDTO> read_proposals(int shopid){
        log.info("건의사항 리스트 Service");

        return storeProposalMapper.read_proposals(shopid);
    }//read_proposals end

}
