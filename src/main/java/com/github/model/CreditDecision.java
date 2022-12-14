package com.github.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="credit_decision")
public class CreditDecision {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name="application_id",referencedColumnName = "id")
    private CreditApplication application;
    @Column(name="status")
    private Boolean status;
    @Column(name="credit_term")
    private int credit_term;
    @Column(name="approved_credit_amount")
    private BigDecimal approved_credit_amount;

    public CreditDecision() {}

    public CreditDecision( CreditApplication application, Boolean status, int credit_term, BigDecimal approved_credit_amount) {

        this.application = application;
        this.status = status;
        this.credit_term = credit_term;
        this.approved_credit_amount = approved_credit_amount;
    }

    public int getId() {
        return id;
    }


    public CreditApplication getApplication() {
        return application;
    }

    public void setApplication(CreditApplication application) {
        this.application = application;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getCredit_term() {
        return credit_term;
    }

    public void setCredit_term(int credit_term) {
        this.credit_term = credit_term;
    }

    public BigDecimal getApproved_credit_amount() {
        return approved_credit_amount;
    }

    public void setApproved_credit_amount(BigDecimal approved_credit_amount) {
        this.approved_credit_amount = approved_credit_amount;
    }
}
