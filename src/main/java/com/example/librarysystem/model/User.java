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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @Column(unique = true)
    private String finCode;

    private String password;


    private String email;

    private String phoneNumber;


    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;


    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions = new ArrayList<>();


    //Constructors

    public User() {
    }





    // getter


    public Long getId() {
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
