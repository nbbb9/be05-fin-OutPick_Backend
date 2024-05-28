package com.encore.outpick_backend.Proposal.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ProposalDTO {
    private int proposal_id;
    private int shop_id;
    private String title;
    private String content;
    private Date date;
    private PropsalCategory category;
    private String completed;
    private String solution;
}
