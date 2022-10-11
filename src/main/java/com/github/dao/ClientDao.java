package com.github.dao;

import com.github.model.Client;
import com.github.model.CreditApplication;
import com.github.model.CreditDecision;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Component
public class ClientDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public ClientDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Client> index(){
        Session session = sessionFactory.getCurrentSession();
        String sql ="SELECT * FROM client";
        List<Client> clients =session.createQuery(sql, Client.class)
                .getResultList();
        return clients;
    }

    @Transactional(readOnly = true)
    public List<Client> searchByFIO(String FIO){
        Session session = sessionFactory.getCurrentSession();
        String sql ="SELECT * FROM client WHERE first_name LIKE \'%" + FIO + "%\' OR middle_name LIKE \'%"+FIO+"%\' OR last_name LIKE \'%"+FIO+"%\'";
        List<Client> clients =session.createQuery(sql, Client.class)
                .getResultList();
        return clients;
    }

    @Transactional(readOnly = true)
    public List<Client> searchByPhone(String phone){
        Session session = sessionFactory.getCurrentSession();
        String sql ="SELECT * FROM client WHERE phone LIKE \'%" + phone + "%\'";
        List<Client> clients =session.createQuery(sql, Client.class)
                .getResultList();
        return clients;
    }

    @Transactional(readOnly = true)
    public List<Client> searchByPassword(String password){
        Session session = sessionFactory.getCurrentSession();
        String sql ="SELECT * FROM client WHERE password_number LIKE \'%" + password + "%\' OR password_series LIKE \'%"+password+"\'%";
        List<Client> clients =session.createQuery(sql, Client.class)
                .getResultList();
        return clients;
    }

    @Transactional
    public void save(Client client, CreditApplication application){
        Session session = sessionFactory.getCurrentSession();
        session.save(client);
        session.save(application);
        Random random = new Random();
        boolean status = random.nextBoolean();
        int credit_term = random.nextInt();
        CreditDecision creditDecision = new CreditDecision(application,status,credit_term,application.getAmount_of_credit());
        session.save(creditDecision);
    }
}
