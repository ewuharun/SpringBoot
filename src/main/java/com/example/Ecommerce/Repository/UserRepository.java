package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User,Long> {
    @Query(value = "select id,name,user_name,email,password from users where user_name = :userName",nativeQuery = true)
    User findByUserName(String userName);
}
