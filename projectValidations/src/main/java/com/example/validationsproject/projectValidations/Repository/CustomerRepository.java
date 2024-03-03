package com.example.validationsproject.projectValidations.Repository;


import com.example.validationsproject.projectValidations.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
