package com.example.librarysystem.model;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID" , strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String name;

    private String surname;

    @Column(unique = true)
    private String finCode;

    private String password;


    private String email;

    private String phoneNumber;


    @ManyToMany
    private List<Role> roles;


    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions = new ArrayList<>();


    //Constructors

    public User() {
    }

    public User(String id, String name, String surname, String finCode,
                String password, String email, String phoneNumber, List<Role> roles) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.finCode = finCode;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.roles = roles;
    }

    public User( String name, String surname, String finCode,
                String password, String email, String phoneNumber, List<Role> roles) {
        this.id = "";
        this.name = name;
        this.surname = surname;
        this.finCode = finCode;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.roles = roles;
    }



    // getter


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFinCode() {
        return finCode;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }




}
