package com.qp.grocerybooking.repository;

import com.qp.grocerybooking.entity.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroceryRepositroy extends JpaRepository<Grocery, Long> {

    @Query("SELECT grocery FROM Grocery grocery GROUP BY grocery.groceryId, grocery.groceryName HAVING grocery.quantity < 10")
    public List<Grocery> checkInventory();

    @Query("SELECT grocery FROM Grocery grocery where grocery.quantity > 0")
    public List<Grocery> availableItems();

    List<Grocery> findAllByGroceryIdIn(List<Long> itemIds);
}
