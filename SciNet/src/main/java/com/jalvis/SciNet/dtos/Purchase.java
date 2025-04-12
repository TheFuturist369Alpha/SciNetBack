package com.jalvis.SciNet.dtos;

import com.jalvis.SciNet.entities.Order;
import com.jalvis.SciNet.entities.OrderItem;
import com.jalvis.SciNet.entities.User;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Purchase {
    private User user;
    private Order order;
    private Set<OrderItem> items=new HashSet<>();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public void setItems(Set<OrderItem> items) {
        this.items = items;
    }
}
