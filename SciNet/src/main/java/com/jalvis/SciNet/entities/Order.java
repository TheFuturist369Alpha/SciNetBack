package com.jalvis.SciNet.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="orders")

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="order_tracking_number")
    private String tracking_code;
    @Column(name="total_price")
    private float total_price;
    @Column(name="total_quantity")
    private int total_quantity;
    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private User user;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="shipping_address_id", nullable=false)
    private Address address;
    @Column(name="status")
    private String status;
    @Column(name="date_created")
    @CreationTimestamp
    private Date date_created;
    @Column(name="last_updated")
    @UpdateTimestamp
    private Date last_updated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private Set<OrderItem> items= new HashSet<>();

    public void addItem(OrderItem item){
        if(item!=null){
            if(items==null){
                items=new HashSet<>();
            }
            item.setOrder(this);
            items.add(item);

        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTracking_code() {
        return tracking_code;
    }

    public void setTracking_code(String tracking_code) {
        this.tracking_code = tracking_code;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {this.total_price = total_price;}

    public int getTotal_quantity() {
        return total_quantity;
    }

    public void setTotal_quantity(int total_quantity) {
        this.total_quantity = total_quantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Date getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(Date last_updated) {
        this.last_updated = last_updated;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public void setItems(Set<OrderItem> items) {
        this.items = items;
    }
}
