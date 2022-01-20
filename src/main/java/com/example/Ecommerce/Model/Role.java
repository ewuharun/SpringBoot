package com.example.Ecommerce.Model;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String role_code;

    public Role() {
    }

    public Role(Long id, String role_code) {
        Id = id;
        this.role_code = role_code;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getRole_code() {
        return role_code;
    }

    public void setRole_code(String role_code) {
        this.role_code = role_code;
    }
}
