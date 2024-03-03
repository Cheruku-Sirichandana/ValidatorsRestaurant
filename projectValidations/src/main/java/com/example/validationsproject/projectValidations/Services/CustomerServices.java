package com.example.validationsproject.projectValidations.Services;


import com.example.validationsproject.projectValidations.Entity.Customer;
import com.example.validationsproject.projectValidations.Entity.Item;
import com.example.validationsproject.projectValidations.Model.CustomerModel;
import com.example.validationsproject.projectValidations.Model.ItemModel;
import com.example.validationsproject.projectValidations.Repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServices {
    @Autowired
    private CustomerRepository customerRepository;
    public String customerCheck(int cid, String cname, String cphone) {
        if (customerRepository == null) {
            return "Customer repository is not available";
        }

        Optional<Customer> customer = customerRepository.findById(cid);

        if (!customer.isPresent()) {
            return "Customer Not Available";
        }

        Customer foundCustomer = customer.get();
        if (foundCustomer.getCname().equals(cname) && foundCustomer.getCphone().equals(cphone)) {
            return "Login Successful";
        } else {
            return "Invalid Customer";
        }
    }

    public String customerSave(int cid,String cname,String cphone) {

        Customer customer=new Customer();
        customer.setCid(cid);
        customer.setCname(cname);
        customer.setCphone(cphone);

        // Save the Admin object using adminRepository
        customerRepository.save(customer);
        return "customeradded";
    }

    public List<CustomerModel> getAllCustomers() {
        List<Customer> customers=customerRepository.findAll();
        List<CustomerModel> CustomerList=new ArrayList<>();
        customers.forEach(sq->{
            CustomerModel customerModel=new CustomerModel();
            BeanUtils.copyProperties(sq,customerModel);
            CustomerList.add(customerModel);
            System.out.println("add to list");
        });
        return CustomerList;
    }


//    public String addCustomer(int cid, CustomerModel customer) {
//        Customer s=customerRepository.findById(cid).orElse(null);
//        if(s==null){
//            return "customer Id is not Registerd";
//        }
//        List<Item> itemList=s.getItemsList();
//       Item i=new Item();
//        BeanUtils.copyProperties(customer,i);
//        itemList.add(i);
//        customerRepository.save(s);
//        return "Added Successfully";
//    }


    public String addItem(int cid, ItemModel item) {
        Customer c=customerRepository.findById(cid).orElse(null);
        if(c==null){
            return "customerId is not Registered";
        }
        List<Item> itemList=c.getItemList();
        Item c1=new Item();
        BeanUtils.copyProperties(item,c1);
        itemList.add(c1);
        customerRepository.save(c);
        return "Added Successfully";
    }

    public List<ItemModel> getItemsById(int cid, ItemModel item) {
        Customer c=customerRepository.findById(cid).orElse(null);
        if(c==null){
            return null;
        }

        List<Item> itemList=c.getItemList();
        List<ItemModel>itemModelList=new ArrayList<>();
        itemList.stream().forEach((e)->{
            ItemModel it=new ItemModel();
            BeanUtils.copyProperties(e,it);
            itemModelList.add(it);
        });

        System.out.println(itemModelList);

        return itemModelList;
    }



    public CustomerModel searchCustomer(int cid) {
        Customer c1=customerRepository.findById(cid).orElse(null);
        CustomerModel s=new CustomerModel();
        BeanUtils.copyProperties(c1,s);
        return s;
    }


//    public deleteItemsOfCustomer

    public void deleteItemsOfCustomer(int cid, int iid) {

        Customer customer=customerRepository.findById(cid).orElse(null);
        if(customer.getItemList()!=null){
            customer.getItemList().removeIf(item -> item.getIid()==(iid));
            customerRepository.save(customer);
            System.out.println("item Deleted");
        }
        System.out.println("item not deleted");
    }
}
