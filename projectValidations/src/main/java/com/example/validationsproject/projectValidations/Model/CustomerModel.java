package com.example.validationsproject.projectValidations.Model;

import com.example.validationsproject.projectValidations.Entity.Item;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class CustomerModel {


    private int cid;
    private String cname;
    private String cphone;
    private String cmail;
    private String cpassword;
    private int cage;


    private List<Item> itemList=new ArrayList<>();
}
