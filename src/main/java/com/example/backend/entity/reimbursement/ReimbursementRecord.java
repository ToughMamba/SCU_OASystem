package com.example.backend.entity.reimbursement;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter

public class ReimbursementRecord {
    private int reimbursement_id;
    private int user_id;
    private BigDecimal  amount;
    private String description;
    private String status;
    private String submitted_at;

    public ReimbursementRecord(int reimbursement_id, int user_id, BigDecimal amount, String description, String status, String submitted_at) {
        this.reimbursement_id = reimbursement_id;
        this.user_id = user_id;
        this.amount = amount;
        this.description = description;
        this.status = status;
        this.submitted_at = submitted_at;
    }
}
