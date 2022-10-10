package com.github.model;


import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import java.util.List;


@Entity
@Table(name ="client")
public class Client {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="first_name")
    private String first_name;
    @Column(name="last_name")
    private String last_name;
    @Column(name="middle_name")
    private String middle_name;
    @Column(name="family_status")
    private String family_status;
    @Column(name="phone")
    private long phone;
    @Column(name="password_number")
    private int password_number;
    @Column(name="password_series")
    private int password_series;
    @OneToMany(mappedBy = "client")
    private List<CreditApplication> applications;
    public Client() {}

    public Client( String first_name, String last_name, String middle_name, String family_status, long phone, int password_number, int password_series) {

        this.first_name = first_name;
        this.last_name = last_name;
        this.middle_name = middle_name;
        this.family_status = family_status;
        this.phone = phone;
        this.password_number = password_number;
        this.password_series = password_series;
    }

    public int getId() {
        return id;
    }


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getFamily_status() {
        return family_status;
    }

    public void setFamily_status(String family_status) {
        this.family_status = family_status;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public int getPassword_number() {
        return password_number;
    }

    public void setPassword_number(int password_number) {
        this.password_number = password_number;
    }

    public int getPassword_series() {
        return password_series;
    }

    public void setPassword_series(int password_series) {
        this.password_series = password_series;
    }

    public List<CreditApplication> getApplications() {
        return applications;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", family_status='" + family_status + '\'' +
                ", phone=" + phone +
                ", password_number=" + password_number +
                ", password_series=" + password_series +
                '}';
    }
}
