package com.jalvis.SciNet.dtos;

import com.jalvis.SciNet.entities.Order;
import com.jalvis.SciNet.entities.User;
import lombok.Data;

@Data
public class Purchase {
    private User user;
    private Order order;

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
}
