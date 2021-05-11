package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order {
	@Column(name = "id")
    private final int id;
	
	@Column(name = "customerId")
    private final int customerId;
	
	@Column(name = "name")
    private final String name;

    public Order(final int id, final int customerId, final String name) {
        this.id = id;
        this.customerId = customerId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }
}