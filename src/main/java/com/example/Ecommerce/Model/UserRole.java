package com.example.Ecommerce.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users_roles")
public class UserRole {
    @Id
    Long user_id;
    String role_id;

    public UserRole() {
    }

    public UserRole(Long user_id, String role_id) {
        this.user_id = user_id;
        this.role_id = role_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }
}
