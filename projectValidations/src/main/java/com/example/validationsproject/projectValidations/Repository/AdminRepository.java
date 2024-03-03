package com.example.validationsproject.projectValidations.Repository;


import com.example.validationsproject.projectValidations.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
}
