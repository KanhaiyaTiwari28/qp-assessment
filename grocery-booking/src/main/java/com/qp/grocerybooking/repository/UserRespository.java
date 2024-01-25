package com.qp.grocerybooking.repository;

import com.qp.grocerybooking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends JpaRepository<User,Long> {

     User findUserByUserNameAndPassword(String userName,String password);
}
