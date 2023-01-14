package com.example.SubmissionForms_db;

import org.springframework.data.repository.CrudRepository;

public interface CustomersRepo extends CrudRepository<Customers, Integer> {                //customers is the class and Integer is the type of primary key id
}
