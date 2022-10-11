package com.github.dao;

import com.github.model.Client;
import com.github.model.CreditApplication;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ApplicationDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public ApplicationDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<CreditApplication> index(){
        Session session = sessionFactory.getCurrentSession();
        String sql ="SELECT ap.id,cl.first_name,cl.last_name,cl.middle_name,cl.family_status,cl.password_number,cl.password_series," +
                "ap.position_of_work,ap.name_of_organization,ap.period_of_employment_start, ap.period_of_employment_end, ap.amoumt_of_credit FROM credit_application ap " +
                "INNER JOIN client cl ON cl.id = ap.client_id " +
                " WHERE cl.id IN (SELECT application_id FROM credit_decision WHERE status=true)";
        List<CreditApplication> applications =session.createQuery(sql, CreditApplication.class)
                .getResultList();
        return applications;
    }

}
