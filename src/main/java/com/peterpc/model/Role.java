package com.peterpc.model;

import javax.persistence.*;


/*
Class for handling roleuser table in database
getters and setters for writing to the table
 */
@Entity
@Table(name = "roleuser")
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int id;

   /* @Column(name = "email", nullable = false, unique = true)
    private String email;
    */

    @Column(name = "role")
    public String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



/*
    public int getroleId() {
        return id;
    }

    public void setroleId(int roleid) {
        this.id = roleid;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

  / public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

*/
}