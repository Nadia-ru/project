package com.github.dao;

import com.github.model.CreditAgreement;
import com.github.model.CreditApplication;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class AgreementDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public AgreementDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<CreditAgreement> index(){
        Session session = sessionFactory.getCurrentSession();
        String sql ="SELECT ap.client_id,ap.position_of_work,ap.name_of_organization,ap.period_of_employment_start, ap.period_of_employment_end, ap.amoumt_of_credit, agr.signature_status, agr.date_of_signing FROM credit_agreement agr " +
                "INNER JOIN credit_application ap ON ap.id = agr.application_id " +
                " WHERE signature_status=true";
        List<CreditAgreement> agreements=session.createQuery(sql, CreditAgreement.class)
                .getResultList();
        return agreements;
    }
}
