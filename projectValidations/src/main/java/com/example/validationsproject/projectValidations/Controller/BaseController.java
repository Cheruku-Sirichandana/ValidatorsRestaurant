package com.example.validationsproject.projectValidations.Controller;


import com.example.validationsproject.projectValidations.Model.AdminModel;
import com.example.validationsproject.projectValidations.Model.CustomerModel;
import com.example.validationsproject.projectValidations.Model.ItemModel;
import com.example.validationsproject.projectValidations.Services.AdminServices;
import com.example.validationsproject.projectValidations.Services.CustomerServices;
import com.example.validationsproject.projectValidations.Services.ItemServices;
import com.example.validationsproject.projectValidations.Validation.CustomerValidations;
import com.example.validationsproject.projectValidations.Validation.ItemValidations;
import com.example.validationsproject.projectValidations.Validation.Validations;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BaseController {
    public int customerId=0;

    public int adminId1=0;
    @Autowired
    private AdminServices adminServices;
    @Autowired
    private CustomerServices customerServices;
    @Autowired
    private ItemServices itemServices;
    @Autowired
    Validations valid;
    @Autowired
    CustomerValidations cusvalid;
    @Autowired
    ItemValidations itemvalid;



    @RequestMapping("/home")
    public String home() {
        System.out.println("...................");
        return "home";
    }

    @RequestMapping("/adminlogin")
    public String adminlogin(ModelMap model) {
        AdminModel adminModel=new AdminModel();
        model.addAttribute(adminModel);

        return "adminlogin";
    }

    //  @RequestMapping("/registerEmployee")
    //    public  String registerEmployee(@Valid @ModelAttribute("adminModel") AdminModel adminModel, BindingResult bindingResult, ModelMap mp){
    //        valid.validate(adminModel,bindingResult);
    //       // System.out.println(bindingResult.getAllErrors());
    //        if(bindingResult.hasErrors()){
    //           System.out.println(bindingResult.getAllErrors());
    //            return "RegisterAnAdmin";
    //        }
    //        AdminModel admin=adminServices.registerAdmin(adminModel);
    //        id= adminModel.getId();
    //        mp.addAttribute("id",adminModel.getId());
    //        mp.addAttribute("adminModel",adminModel);
    //        return "setUserPass";
    //    }

    @RequestMapping("/adminchecking")
    public String adminchecking(@Valid @ModelAttribute("adminModel") AdminModel adminModel,BindingResult bindingResult,@RequestParam("adminId") int adminId, @RequestParam("adminPassword") String adminPassword, ModelMap model) {
        String result = adminServices.adminCheck(adminId, adminPassword);
        valid.validate(adminModel,bindingResult);
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors());
            return "adminlogin";
        }
        if (result.equals("Login Successful")) {
            model.addAttribute("message", result);
            model.addAttribute("adminId",adminId);
            adminId1=adminId;

            return "admincheck";

        }
        return "adminlogin";


    }

    @RequestMapping("/admincheck")
    public String admincheck(Model model) {
        model.addAttribute("adminId",adminId1);
        return "admincheck";
    }

    @RequestMapping("/addAdmin")
    public String addAdmin(ModelMap model) {
        AdminModel adminModel=new AdminModel();
        model.addAttribute(adminModel);
        return "addAdmin";
    }

    @RequestMapping("/addedAdmin")
    public String adminsave(@Valid @ModelAttribute("adminModel") AdminModel adminModel, BindingResult bindingResult, ModelMap model) {
        String result = adminServices.adminSave(adminModel.getAdminId(), adminModel.getAdminPassword());

        valid.validate(adminModel,bindingResult);
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors());
            return "addAdmin";
        }
        adminId1=adminModel.getAdminId();
        model.addAttribute("adminId",adminModel.getAdminId());
        model.addAttribute("adminModel",new AdminModel());
        return "display";
    }




    @RequestMapping("/uploadItems")
    public String uploadItems(@RequestParam("adminId") int adminId,Model model) {
        model.addAttribute("admindId",adminId);
        System.out.println("admindId"+adminId);
        return "uploadItems";
    }

    @RequestMapping("/uploaded")
    public String uploaded(@RequestParam("adminId") int adminId, ItemModel item, ModelMap model) {

        AdminModel a=adminServices.searchAdmin(adminId);
        ItemModel i = itemServices.saveItem(a,item);
        model.addAttribute("adminId", adminId);
        //adminId1=adminId;
        //model.addAttribute("adminId1",adminId1);
        model.addAttribute("item", i);
        System.out.println(i);

        return "redirect:/viewItems";
    }

    @RequestMapping("/viewAdmins")
    public String viewAdmins(ModelMap model) {
        List<AdminModel> AdminsList = adminServices.getAllAdmins();
        model.addAttribute("AdminsList", AdminsList);
        System.out.println(".>>>>>>>>>>>>>>>>>");
        return "viewAdmins";

    }

    @RequestMapping("/viewItems")
    public String viewItems(ModelMap model) {
        List<ItemModel> ItemsList = itemServices.getAllItems();
        System.out.println(",,,,,,,,,,,,,,,,,,,,,,,");
        model.addAttribute("ItemsList", ItemsList);
        //  model.addAttribute("adminId",adminId1);

        //System.out.println(adminId1);
        System.out.println("gggggggggggggggg");
        return "viewItems";
    }

    @RequestMapping("/deleteItems")
    public String deleteItems(ModelMap model) {
        ItemModel itemModel=new ItemModel();
        model.addAttribute("itemModel",itemModel);
        return "deleteItems";
    }

    @RequestMapping("/deletedItems")
    public String deleteItem(@Valid @ModelAttribute("itemModel") ItemModel itemModel,BindingResult bindingResult,ModelMap model) {
        System.out.println("Error Finded");
        itemvalid.validate(itemModel, bindingResult);

        if (bindingResult.hasErrors()) {
            System.out.println("Error Detected");
            System.out.println(bindingResult.getAllErrors());
            System.out.println("Task Completed");
            return "deleteItems";
        }
        String str = itemServices.deleteItem(itemModel.getIid());
        System.out.println(str);
        return "redirect:/viewItems";
    }

    @RequestMapping("/updateItems")
    public String updateItems(ModelMap model) {
        ItemModel itemModel=new ItemModel();
        model.addAttribute("itemModel",itemModel);
        System.out.println("fjfgf");
        return "updateItem";
    }

    @RequestMapping("/updatingItems")
    public String updatingItems(@Valid @ModelAttribute("itemModel") ItemModel itemModel,BindingResult bindingResult, ModelMap model) {
        System.out.println();
        itemvalid.validate1(itemModel, bindingResult);
        if (bindingResult.hasErrors()) {
            System.out.println("UPDATING/...............................");
            System.out.println(bindingResult.getAllErrors());
            return "updateItem";
        }

       // model.addAttribute("iid", iid);
        return "updatingItems";

    }

    @RequestMapping("/updatedItem")
    public String updateItem(@Valid @ModelAttribute("itemModel") ItemModel itemModel,BindingResult bindingResult,ModelMap model) {
        itemvalid.validate(itemModel,bindingResult);
        if(bindingResult.hasErrors()){
            //System.out.println(bindingResult.getAllErrors());
            return "updatingItem";
        }

        itemServices.updateItem(itemModel);
        return "redirect:viewItems";
    }


    //customer


    // @RequestMapping("/registerEmployee")
    //    public  String registerEmployee(@Valid @ModelAttribute("adminModel") AdminModel adminModel, BindingResult bindingResult, ModelMap mp){
    //        valid.validate(adminModel,bindingResult);
    //        //System.out.println(bindingResult.getAllErrors());
    //        if(bindingResult.hasErrors()){
    //            System.out.println(bindingResult.getAllErrors());
    //            return "RegisterAnAdmin";
    //        }
    //       // AdminModel admin=adminServices.registerAdmin(adminModel);
    //        id= adminModel.getId();
    //        mp.addAttribute("id",adminModel.getId());
    //        mp.addAttribute("adminModel",new AdminModel());
    //        return "setUserPass";
    //    }

    @RequestMapping("/addCustomer")
    public String addCustomer(ModelMap model){
        CustomerModel customerModel=new CustomerModel();
        model.addAttribute("customerModel",customerModel);
        return "addCustomer";
    }
//    @RequestMapping("/addedCustomer")
//    public String addCustomer(@Valid @ModelAttribute("customerModel") CustomerModel customerModel,BindingResult bindingResult,ModelMap model) {
//        cusvalid.validate(customerModel,bindingResult);
//        if(bindingResult.hasErrors()){
//            System.out.println(bindingResult.getAllErrors());
//            return "addCustomer";
//        }
//
//        return "display";
//    }

    @RequestMapping("/addedcustomer")

    public String customersave(@Valid @ModelAttribute("customerModel")CustomerModel customerModel,BindingResult bindingResult,@RequestParam("cid") int cid, @RequestParam("cname") String cname, @RequestParam("cphone") String cphone, ModelMap model) {
        cusvalid.validate(customerModel,bindingResult);
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors());
            return "addCustomer";
        }
        String result = customerServices.customerSave(cid, cname, cphone);
        System.out.println("/////////////////");
        return "display";
    }
//    @RequestMapping("/addedAdmin")
//    public String adminsave(@Valid @ModelAttribute("adminModel") AdminModel adminModel, BindingResult bindingResult, ModelMap model) {
//        String result = adminServices.adminSave(adminModel.getAdminId(), adminModel.getAdminPassword());
//
//        valid.validate(adminModel,bindingResult);
//        if(bindingResult.hasErrors()){
//            System.out.println(bindingResult.getAllErrors());
//            return "addAdmin";
//        }
//        adminId1=adminModel.getAdminId();
//        model.addAttribute("adminId",adminModel.getAdminId());
//        model.addAttribute("adminModel",new AdminModel());
//        return "display";
//    }


   //for registration
   @RequestMapping("customerlogin")
   public String customerlogin(ModelMap mp) {
        CustomerModel customerModel=new CustomerModel();
      mp.addAttribute(customerModel);

       return "customerlogin";
   }

    @RequestMapping("/customerchecking")
    public String customerchecking(@Valid @ModelAttribute("customerModel") CustomerModel customerModel,BindingResult bindingResult,@RequestParam("cid") int cid, @RequestParam("cname") String cname, @RequestParam("cphone") String cphone, ModelMap model) {
        String result = customerServices.customerCheck(cid, cname, cphone);
        cusvalid.validate(customerModel,bindingResult);
        customerId=cid;
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors());
            return "customerlogin";
        }
        if (result.equals("Login Successful")) {
            model.addAttribute("message", result);
            return "customercheck";
        }

        return "customerlogin";


    }

    @RequestMapping("/customercheck")
    public String customercheck() {
        return "customercheck";
    }



    //@RequestMapping("customerlogin")
    //    public String customerlogin(@Valid @ModelAttribute("customerModel") CustomerModel customerModel,BindingResult bindingResult,ModelMap mp) {
    //        cusvalid.validate(customerModel,bindingResult);
    //                if(bindingResult.hasErrors()){
    //                    System.out.println(bindingResult.getAllErrors());
    //                    return "customerlogin";
    //                }
    //        return "customerlogin";
    //    }


    @RequestMapping("/viewCustomers")
    public String viewCustomers(ModelMap model) {
        List<CustomerModel> CustomersList = customerServices.getAllCustomers();
        model.addAttribute("CustomersList", CustomersList);
        System.out.println(".>>>>>>>>>>>>>>>>>");
        return "viewCustomers";

    }

    @RequestMapping("/addCustomerItem")
    public String addCustomerItem(Model model) {
        model.addAttribute("cid",customerId);
        return "addCustomerItem";
    }


    @RequestMapping("/addingCustomerItem")
    public String addCustomerItem(@RequestParam("cid") int cid,@RequestParam("iid") int iid, ModelMap mp) {

        CustomerModel customer = customerServices.searchCustomer(cid);
        System.out.println("customer2");
        System.out.println("customer");
        ItemModel item = itemServices.searchItem(iid);
        mp.addAttribute("iid", iid);
        System.out.println("item"+item);
        if (customer != null) {
            System.out.println(cid+"cid");
            String str = customerServices.addItem(cid,item);
            System.out.println("////////////////////////////////////////");
        }
        return "redirect:/viewItemsOfCustomer";


    }
    @RequestMapping("/viewItemsOfCustomer")
    public String viewItemsOfCustomer(Model model){
        System.out.println(customerId);
        model.addAttribute("cid",customerId);
        return "viewItemsOfCustomer";
    }
    @RequestMapping("/viewedItemsOfCustomer")
    public String viewItemsOfCustomer(@RequestParam("cid") int cid,ItemModel item, ModelMap model) {
        List<ItemModel> ItemList2 = customerServices.getItemsById(cid,item);
        System.out.println(ItemList2);
        model.addAttribute("ItemList2", ItemList2);
        System.out.println("gggggggggggggggg");
        return "viewedItemsOfCustomer";
    }
    @RequestMapping("/deleteCustomerItems")
    public String deleteCustomerItems(Model model){
        System.out.println(customerId);
        model.addAttribute("cid",customerId);
        return "deleteCustomerItems";
    }
    @RequestMapping("/deletedCustomerItems")
    public String deleteCustomerItems(@RequestParam("cid") int cid,@RequestParam("iid") int iid){
        customerServices.deleteItemsOfCustomer(cid,iid);
        return "redirect:/viewItemsOfCustomer";

    }

    //Admin
    @RequestMapping("/deleteAdmin")
    public String deleteAdmin(){
        return "deleteAdmin";
    }

    @RequestMapping("/deletedAdmin")
    public String deletedAdmin(@RequestParam("adminId") int adminId){
        String str=adminServices.deleteAdmin(adminId);
        System.out.println(str);
        return "redirect:/viewAdmins";
        //   public String deleteItem(@RequestParam("iid") int iid) {
        //        String str = itemServices.deleteItem(iid);
        //        System.out.println(str);
        //        return "redirect:/viewItems";
        //    }

//        @RequestMapping("/updatingItems")
//        public String updatingItems(@RequestParam("iid") int iid, ModelMap model) {
//            model.addAttribute("iid", iid);
//            return "updatingItems";
//        }

    }

//    @RequestMapping("/updateItemsOfCustomer")
//    public String updateItemsOfCustomer(){
//        return "updateItemsOfCustomer";
//    }
//
//    @RequestMapping("/updateItemOfCustomer")
//    public  String updateItem(@RequestParam("cid") long cid, ModelMap model){
//        model.addAttribute("cid",cid);
//        return "updatedItemOfCustomer";
//    }
//    @RequestMapping("/updateItemOfCustomer")
//    public String updateItemOfCustomer(ItemModel itemModel){
//        itemServices.updateItem(itemModel);
//        return "redirect:/viewItemsOfCustomer";
//
//    }

}



//    @RequestMapping("/other")
//    public String other(){
//
//        return "other";
//    }
//    @RequestMapping("/uploadItems")
//    public String uploadItems(){
//
//        return "uploadItems";
//    }
//    @RequestMapping("/uploaded")
//    public String uploaded(){
//
//    }


