package com.peterpc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peterpc.repository.CustomerModelRepository;

@Service
public class CustomerModelServiceImpl implements CustomerModelService {

    @Autowired
    CustomerModelRepository customerrepository;

    public void addCustomers() {

        System.out.println("customers have been added : " + customerrepository.findAll());

    }
}