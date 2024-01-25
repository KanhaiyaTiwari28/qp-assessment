package com.qp.grocerybooking.controller;

import com.qp.grocerybooking.config.VerifictionSevice;
import com.qp.grocerybooking.dto.GroceryDto;
import com.qp.grocerybooking.entity.Grocery;
import com.qp.grocerybooking.exception.AccessDeniedException;
import com.qp.grocerybooking.exception.InvalidUserException;
import com.qp.grocerybooking.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController( value = "/grocery")
public class GroceryController {

    @Autowired
    GroceryService groceryService;

    @Autowired
    VerifictionSevice verifictionSevice;


    @RequestMapping(value = "/addGrocery/{userName}/{password}", method = RequestMethod.POST)
    public Grocery addGrocery(@RequestBody GroceryDto groceryDto, @PathVariable String userName, @PathVariable String password){

        String role = verifictionSevice.verifyRole(userName, password);

        if(!role.equalsIgnoreCase("Admin"))
            throw new AccessDeniedException("Access Denied");



        return groceryService.addGrocery(groceryDto);
    }
    @RequestMapping(value = "/viewAll/{userName}/{password}", method = RequestMethod.GET)
    public List<Grocery> viewAllItems(@PathVariable String userName, @PathVariable String password){
        String role = verifictionSevice.verifyRole(userName, password);
        if(!role.equalsIgnoreCase("Admin"))
            throw new AccessDeniedException("Access Denied");

        return groceryService.viewGrocery();
    }

    @RequestMapping(value = "/remove/item/{id}/{userName}/{password}", method = RequestMethod.DELETE)
    public String removeItemById(@PathVariable Long id, @PathVariable String userName, @PathVariable String password){
        String role = verifictionSevice.verifyRole(userName, password);
        if(!role.equalsIgnoreCase("Admin"))
            throw new AccessDeniedException("Access Denied");

        groceryService.removeItem(id);
        return "Removed Item Successfully";
    }

    @RequestMapping(value = "/update/{userName}/{password}", method = RequestMethod.PUT)
    public Grocery updateItemDetails(@RequestBody Grocery grocery, @PathVariable String userName, @PathVariable String password){
        String role = verifictionSevice.verifyRole(userName, password);
        if(!role.equalsIgnoreCase("Admin"))
            throw new AccessDeniedException("Access Denied");

        return groceryService.updateItemDetails(grocery);
    }
    @RequestMapping(value = "/check/inventory/{userName}/{password}", method = RequestMethod.GET)
    public List<Grocery> manageInventoryLevel(@PathVariable String userName, @PathVariable String password){
        String role = verifictionSevice.verifyRole(userName, password);
        if(!role.equalsIgnoreCase("Admin"))
            throw new AccessDeniedException("Access Denied");

        return groceryService.manageInventoryLevel();
    }

    @RequestMapping(value = "/available/{userName}/{password}", method = RequestMethod.GET)
    public List<Grocery> availableItems(@PathVariable String userName, @PathVariable String password){
        String role = verifictionSevice.verifyRole(userName, password);
        if(role.equalsIgnoreCase("Admin"))
            throw new AccessDeniedException("Access Denied");

        return groceryService.availableItems();
    }

    @RequestMapping(value = "/order/{groceryIds}/{userName}/{password}", method = RequestMethod.GET)
    public Map<String , List<String>> orderGrocery(@PathVariable List<Long> groceryIds, @PathVariable String userName, @PathVariable String password){
        String role = verifictionSevice.verifyRole(userName, password);
        if(role.equalsIgnoreCase("Admin"))
            throw new AccessDeniedException("Access Denied");

        List<Grocery> groceries = groceryService.findGroceriesByID(groceryIds);
        return Collections.singletonMap("Order Placed Succesfully For Item List ", groceries.stream().map(Grocery::getGroceryName).collect(Collectors.toList()));
    }

}
