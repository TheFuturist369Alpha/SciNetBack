package com.jalvis.SciNet.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="books")
public class Book {

    public Book(){}

    public Book( String name, String description, double price,
                 String image_url, boolean available, Date date_launched, Subject subject, User user) {

        this.name=name;
        this.description = description;
        this.price = price;
        this.image_url = image_url;
        this.available = available;
        this.date_launched = date_launched;
        this.subject = subject;
        this.user=user;
    }


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private double price;

    @Column(name="image_url")
    private String image_url;

    @Column(name="available")
    private boolean available;

    @Column(name="date_launched")
    private Date date_launched;

    @ManyToOne
    @JoinColumn(name="subject_id", nullable = false)
    private Subject subject;

    @ManyToOne
    @JoinColumn(name="owner_id", nullable=false)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Date getDate_launched() {
        return date_launched;
    }

    public void setDate_launched(Date date_launched) {
        this.date_launched = date_launched;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
