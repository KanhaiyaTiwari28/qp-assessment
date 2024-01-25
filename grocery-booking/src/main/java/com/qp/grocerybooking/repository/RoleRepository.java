package com.qp.grocerybooking.repository;

import com.qp.grocerybooking.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    public Role getByRoleType(String roleType);
}
