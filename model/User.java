package model;

import java.util.List;

public final class User {// we made class final so no other class can inherit it
    private final String name; // We made all fields final so once it is initialized we can't change the data.
    private final int age;
    private final List<Order> orders; // we have to make it Mutable collection

    public User(String name, int age, List<Order> orders) {
        this.name = name;
        this.age = age;
        this.orders = List.copyOf(orders); // Defensive copy
    }

    //we will provide only getters without setters inorder to avoid any changes
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Order> getOrders() {
        return orders; // Already unmodifiable
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + ", orders=" + orders + "}";
    }
}

