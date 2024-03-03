package com.example.validationsproject.projectValidations.Model;


import com.example.validationsproject.projectValidations.Entity.Item;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AdminModel {

    private int adminId;
    private String adminPassword;

    private List<Item> ItemsList=new ArrayList<>();
}
