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
    public List<Client> index(){
        Session session = sessionFactory.getCurrentSession();
        String sql ="SELECT id, FROM credit_application ap";
        List<Client> clients =session.createQuery(sql, Client.class)
                .getResultList();
        return clients;
    }

    @Transactional
    public void save(CreditApplication application){
        Session session = sessionFactory.getCurrentSession();
        session.save(application);
    }

}
