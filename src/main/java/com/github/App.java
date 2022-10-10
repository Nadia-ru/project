package com.github;

import com.github.model.Client;
import com.github.model.CreditApplication;
import com.github.model.CreditDecision;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) {
        Configuration configuration =new Configuration().addAnnotatedClass(Client.class)
                .addAnnotatedClass(CreditApplication.class)
                .addAnnotatedClass(CreditDecision.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            Client client2 =session.get(Client.class,5);
            System.out.println(client2);

            Client client = new Client("Анастасия","Иванова","Ивановна","замужем",89349343535l,333333,2345);

           CreditApplication creditApplication = new CreditApplication(client,
                   Duration.between(
                           LocalDate
                                   .of(2020, Month.NOVEMBER, 2)
                                   .atStartOfDay(),
                           LocalDate
                                   .of(2022, Month.AUGUST, 25)
                                   .atStartOfDay()
                   ),"маркетолог","пятерочка",new BigDecimal("23000.00"));
            client.setApplications(new ArrayList<>(Collections.singletonList(creditApplication)));
            session.save(client);
            session.save(creditApplication);
            session.getTransaction().commit();
        }
        finally{
            sessionFactory.close();
        }
    }
}
