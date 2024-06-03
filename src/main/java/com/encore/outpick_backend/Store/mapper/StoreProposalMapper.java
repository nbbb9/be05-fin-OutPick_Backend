package com.encore.outpick_backend.Store.mapper;

import com.encore.outpick_backend.Store.domain.StoreAddProposalDTO;
import com.encore.outpick_backend.Store.domain.StoreReadProposalDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface StoreProposalMapper {

    //건의사항 작성
    public void create_proposal(StoreAddProposalDTO storeAddProposalDTO);

    //건의사항 리스트
    public List<StoreReadProposalDTO>  read_proposals(int shopid);

}
