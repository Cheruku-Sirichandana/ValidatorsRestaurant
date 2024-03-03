package com.example.validationsproject.projectValidations.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Item {
    @Id
    private int iid;
    private String iname;
    private long iprice;
    @ManyToOne
    private Admin admin=new Admin();
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Customer> customerList=new ArrayList<>();
}
