package com.github.model;



import com.vladmihalcea.hibernate.type.interval.PostgreSQLIntervalType;
import org.hibernate.annotations.TypeDef;

import java.math.BigDecimal;

import javax.persistence.*;
import java.time.Duration;
import java.util.List;


@Entity
@Table(name = "credit_application")
@TypeDef(
        typeClass = PostgreSQLIntervalType.class,
        defaultForType = Duration.class
)
public class CreditApplication {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="client_id",referencedColumnName = "id")
    private Client client;
    @Column(name="period_of_employment", columnDefinition = "interval")
    private Duration period_of_employment;
    @Column(name="position_at_work")
    private String position_at_work;
    @Column(name="name_of_organization")
    private String  name_of_organization;
    @Column(name="amount_of_credit")
    private BigDecimal amount_of_credit;

    @OneToOne(mappedBy = "application")
    private CreditDecision decisions;

    public CreditApplication() {}

    public CreditApplication(Client client, Duration period_of_employment, String position_at_work, String name_of_organization, BigDecimal amount_of_credit) {

        this.client = client;
        this.period_of_employment = period_of_employment;
        this.position_at_work = position_at_work;
        this.name_of_organization = name_of_organization;
        this.amount_of_credit = amount_of_credit;
    }
}
