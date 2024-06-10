package com.encore.outpick_backend.Proposal.domain;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ProposalDTO {
    private int proposal_id;
    private int shop_id;
    private String shop_name;
    private String title;
    private String content;
    private String manager;
    private LocalDateTime date;
    private ProposalCategory category;
    private String completed;
    private String solution;
    private String employee_name;
}
