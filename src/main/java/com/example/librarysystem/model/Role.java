package com.example.librarysystem.model;


import com.example.librarysystem.enums.RoleName;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;


@Entity
@Table(name = "roles")
public class Role implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID" , strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Enumerated(EnumType.STRING)
    private RoleName roleName;


    // constructors
    public Role() {
    }

    public Role(String id, RoleName roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Role(RoleName roleName) {
        this.roleName = roleName;
    }


    // getter


    public String getId() {
        return id;
    }

    public RoleName getRoleName() {
        return roleName;
    }



}
