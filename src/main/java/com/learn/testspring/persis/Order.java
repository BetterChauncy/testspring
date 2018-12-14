package com.learn.testspring.persis;

/**
 * @author: liuxf
 * DateTime: 2018/12/13/013 11:13
 */

public class Order {

    int id;
    String state;

    public Order(int id, String state) {
        this.id = id;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", state=" + state + "]";
    }
}
