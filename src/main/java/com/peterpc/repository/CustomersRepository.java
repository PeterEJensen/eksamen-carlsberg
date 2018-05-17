package com.peterpc.repository;

import org.springframework.data.repository.CrudRepository;

import com.peterpc.model.Customers;

public interface CustomersRepository extends CrudRepository<Customers, Long> {
}