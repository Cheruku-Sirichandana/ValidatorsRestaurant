package com.example.validationsproject.projectValidations.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Admin {
    @Id
    private int adminId;
    private String adminPassword;
    @OneToMany(mappedBy="admin",cascade = CascadeType.ALL)
    private List<Item> ItemsList=new ArrayList<>();
}
