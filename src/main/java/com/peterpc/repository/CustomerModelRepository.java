package com.peterpc.repository;

import com.peterpc.model.CustomerModel;
import org.springframework.data.repository.CrudRepository;

//CRUD repository provides CRUD (Create, read, update, delete)
// We are using this as we do not need JpaRepository for this, as we have no need for the all the extends JPA provides

//Class is an interface and therefore only be implemented by other classes
public interface CustomerModelRepository extends CrudRepository<CustomerModel, Long> {
}