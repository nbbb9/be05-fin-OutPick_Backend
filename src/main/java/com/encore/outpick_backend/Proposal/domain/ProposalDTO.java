package com.encore.outpick_backend.Proposal.domain;

import lombok.Data;
import java.util.Date;

@Data
public class ProposalDTO {
    private int proposal_id;
    private int shop_id;
    private String title;
    private String content;
    private Date date;
    private ProposalCategory category;
    private String completed;
    private String solution;
}
