package com.example.validationsproject.projectValidations.Model;


import com.example.validationsproject.projectValidations.Entity.Admin;
import com.example.validationsproject.projectValidations.Entity.Customer;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemModel {

    private Integer iid;
    private String iname;
    private long iprice;
    private Admin admin;
    private List<Customer> customerList=new ArrayList<>();
}
