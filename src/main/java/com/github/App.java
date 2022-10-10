package com.github;


import com.github.model.Client;
import com.github.model.CreditApplication;
import com.github.model.CreditDecision;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.context.request.SessionScope;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration =new Configuration().addAnnotatedClass(Client.class)
                .addAnnotatedClass(CreditApplication.class)
                .addAnnotatedClass(CreditDecision.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            Client client =session.get(Client.class,1);
            System.out.println(client);

            List<CreditApplication> appl=client.getApplications();
            System.out.println(appl);
            session.getTransaction().commit();
        }
        finally{
            sessionFactory.close();
        }
    }
}
