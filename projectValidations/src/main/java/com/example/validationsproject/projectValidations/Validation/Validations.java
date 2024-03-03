package com.example.validationsproject.projectValidations.Validation;


import com.example.validationsproject.projectValidations.Model.AdminModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class Validations implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return AdminModel.class.equals(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {
        System.out.println("THis is the error page");

        AdminModel adminModel= (AdminModel) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"adminId","AdminId");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"adminPassword","AdminName");


    }
}
