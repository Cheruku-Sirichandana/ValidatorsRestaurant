package com.example.validationsproject.projectValidations.Validation;


import com.example.validationsproject.projectValidations.Model.ItemModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ItemValidations implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return ItemModel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {


        ItemModel itemModel = (ItemModel) target;

        System.out.println("valid item");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "iid", "ItemId");
        System.out.println("validTED ITEMS");




        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "iname", "ItemName");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors,"iprice","ItemPrice");


//        if (String.valueOf(itemModel.getIprice()).isBlank()) {
//            {
//                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Iprice", "ItemPrice");
//            }


        }

    public void validate1(Object target, Errors errors) {


        ItemModel itemModel = (ItemModel) target;

        System.out.println("valid item");
//        if(itemModel.getIid().toString().isBlank()) {
//            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "iid", "ItemId","ItemId");
//}
        System.out.println("validTED ITEMS");
        if(itemModel.getIid()==null)
        {
            System.out.println("Bhanpasdkjfds");
            errors.rejectValue("iid","Item","PLEASE ENTER");
        }

    }
    }
