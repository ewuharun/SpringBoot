package com.example.Ecommerce.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String order_id;
    @OneToMany(targetEntity = OrderDetails.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id",referencedColumnName = "order_id")
    List<OrderDetails> all_items;

    public Orders(String order_id, List<OrderDetails> all_items) {
        this.order_id = order_id;
        this.all_items = all_items;
    }

    public Orders() {
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public List<OrderDetails> getAll_items() {
        return all_items;
    }

    public void setAll_items(List<OrderDetails> all_items) {
        this.all_items = all_items;
    }
}
