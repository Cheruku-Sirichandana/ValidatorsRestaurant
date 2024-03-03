package com.example.validationsproject.projectValidations.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Customer {
    @Id
    private int cid;
    private String cname;
    private String cphone;
    private String cmail;
    private String cpassword;
    private int cage;

    @ManyToMany(mappedBy = "customerList" ,cascade= CascadeType.ALL)
    private List<Item> itemList=new ArrayList<>();


}
