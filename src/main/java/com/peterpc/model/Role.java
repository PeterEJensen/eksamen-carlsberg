package com.peterpc.model;

import javax.persistence.*;

import netscape.security.Privilege;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/*
Class for handling roleuser table in database
getters and setters for writing to the table
 */
@Entity
@Table(name = "roleuser")
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_role_id")
    private int roleid;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "role")
    public String role;




    public int getroleId() {
        return roleid;
    }

    public void setroleId(int roleid) {
        this.roleid = roleid;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}