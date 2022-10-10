package com.github.model;

//import javax.persistence.*;
//import java.math.BigDecimal;
//import java.util.Date;
//
//@Entity
//@Table(name="credit_agreement")
//public class CreditAgreement {
//    @Id
//    @Column(name="id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @OneToOne
//    @JoinColumn(name="application_id",referencedColumnName = "id")
//    private CreditApplication application_final;
//    @Column(name="date_of_signing")
//    private Date date_of_signing;
//    @Column(name="signature_status")
//    private Boolean signature_status;
//
//    CreditAgreement() {}
//
//    public CreditAgreement(CreditApplication application_final, Date date_of_signing, Boolean signature_status) {
//        this.application_final = application_final;
//        this.date_of_signing = date_of_signing;
//        this.signature_status = signature_status;
//    }
//}
