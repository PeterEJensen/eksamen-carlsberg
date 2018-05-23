package com.peterpc.model;
//Created by Peter
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/*
Class for handling customermodel table in database
getters and setters for writing to the table
 */
@Indexed
@Entity
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Field
    private String name;

    @Field
    private String address;

    @Field
    private int kundenr;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getKundenr() {
        return kundenr;
    }

    public void setKundenr(int kundenr) {
        this.kundenr = kundenr;
    }
}