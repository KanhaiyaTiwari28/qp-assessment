package com.qp.grocerybooking.service;

import com.qp.grocerybooking.dto.GroceryDto;
import com.qp.grocerybooking.entity.Grocery;
import com.qp.grocerybooking.repository.GroceryRepositroy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryService {

    @Autowired
    GroceryRepositroy groceryRepositroy;

    @Autowired
    ModelMapper modelMapper;

    public Grocery addGrocery(GroceryDto groceryDto) {
        Grocery grocery = modelMapper.map(groceryDto, Grocery.class);
        return groceryRepositroy.save(grocery);
    }

    public List<Grocery> viewGrocery(){
        return groceryRepositroy.findAll();
    }

    public void removeItem(Long groceryId){
         groceryRepositroy.deleteById(groceryId);
    }

    public Grocery updateItemDetails(Grocery grocery){

        return groceryRepositroy.save(grocery);
    }

    public List<Grocery> manageInventoryLevel(){
        return  groceryRepositroy.checkInventory();

    }

    public List<Grocery> availableItems(){
        return  groceryRepositroy.availableItems();

    }

    public List<Grocery> findGroceriesByID(List<Long> ids){
        return  groceryRepositroy.findAllByGroceryIdIn(ids);

    }


}
