package com.peterpc.repository;

import com.peterpc.model.CustomerModel;
import org.springframework.data.repository.CrudRepository;


public interface CustomerModelRepository extends CrudRepository<CustomerModel,Long> {
}