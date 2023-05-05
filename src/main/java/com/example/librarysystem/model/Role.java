package com.example.librarysystem.model;


import com.example.librarysystem.enums.RoleName;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;


@Entity
@Table(name = "roles")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleName roleName;


    // constructors
    public Role() {
    }

    public Role(Long id, RoleName roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Role(RoleName roleName) {
        this.roleName = roleName;
    }


    // getter



    public RoleName getRoleName() {
        return roleName;
    }



}
