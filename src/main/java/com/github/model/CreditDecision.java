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
}
