package com.example.validationsproject.projectValidations.Repository;


import com.example.validationsproject.projectValidations.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {
}
