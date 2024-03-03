package com.example.validationsproject.projectValidations.Validation;


import com.example.validationsproject.projectValidations.Model.AdminModel;
import com.example.validationsproject.projectValidations.Model.CustomerModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CustomerValidations implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return AdminModel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        CustomerModel customerModel= (CustomerModel)  target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"cid","CustomerId");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"cname","CustomerName");
       // ValidationUtils.rejectIfEmptyOrWhitespace(errors,"Cname","CustomerName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"cmail","CustomerEmail","email error msg");
        if(customerModel.getCmail()==null){
            errors.rejectValue("cmail","CustomerEmail","email error msg");
        }
        if (customerModel.getCmail() != null&& !customerModel.getCmail().endsWith("@gmail.com")){
            errors.rejectValue("cmail","Email");
        }

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cmail", "CustomerEmail");


        if(customerModel.getCage()<=18 ) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cage", "CustomerAge");


        }

        String cpassword = customerModel.getCpassword();
        if (cpassword != null && cpassword.length() < 4) {
            // If password is not null and its length is less than 4 characters, reject it
            errors.rejectValue("cpassword", "CustomerPassword");
        }
        String cphone=customerModel.getCphone();
        if(cphone!=null && cphone.length() !=10){
            ValidationUtils.rejectIfEmptyOrWhitespace(errors,"cphone","CustomerPhone");
        }


    }
}
