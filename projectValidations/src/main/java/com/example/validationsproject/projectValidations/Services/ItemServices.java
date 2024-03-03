package com.example.validationsproject.projectValidations.Services;


import com.example.validationsproject.projectValidations.Entity.Admin;
import com.example.validationsproject.projectValidations.Entity.Item;
import com.example.validationsproject.projectValidations.Model.AdminModel;
import com.example.validationsproject.projectValidations.Model.ItemModel;
import com.example.validationsproject.projectValidations.Repository.ItemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServices {
    @Autowired
    private ItemRepository itemRepository;
    public ItemModel saveItem(AdminModel adminModel, ItemModel itemModel) {
        Item i=itemRepository.findById(itemModel.getIid()).orElse(null);

        if(i!=null){
            return null;
        }
        Item item=new Item();
        Admin admin=new Admin();
        BeanUtils.copyProperties(adminModel,admin);

        BeanUtils.copyProperties(itemModel,item);
        item.setAdmin(admin);
        itemRepository.save(item);
        return itemModel;
    }

    public List<ItemModel> getAllItems() {
        List<Item> items=itemRepository.findAll();
        List<ItemModel> ItemList=new ArrayList<>();
        items.forEach(s->{
            ItemModel itemModel=new ItemModel();
            BeanUtils.copyProperties(s,itemModel);
            ItemList.add(itemModel);
            //System.out.println("add to list");
        });
        return ItemList;
    }


    public String deleteItem(int iid) {
        itemRepository.deleteById(iid);
        return "deleted";
    }

    public void updateItem(ItemModel item) {
        Optional<Item> i=itemRepository.findById(item.getIid());
        // BeanUtils.copyProperties(i,item);
        if(i.isPresent()) {

            Item e = i.get();
            e.setIname(item.getIname());
            e.setIprice(item.getIprice());
            itemRepository.save(e);
        }
        else{
            System.out.println("Please enter valid ID");
        }

    }

    public ItemModel searchItem(int iid) {
        Item i1=itemRepository.findById(iid).orElse(null);
        ItemModel im=new ItemModel();
        BeanUtils.copyProperties(i1,im);
        return im;
    }
    public void updateItemsOfCustomer(ItemModel item) {
        Item it=itemRepository.findById(item.getIid()).orElse(null);
        it.setIid(item.getIid());
        it.setIname(item.getIname());
        it.setIprice(item.getIprice());
        itemRepository.save(it);
    }
}
