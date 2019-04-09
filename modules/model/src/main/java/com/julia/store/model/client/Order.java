package com.julia.store.model.client;


public class Order {

    private String user;
    private String date;
    private String count;
    private String price;

    public Order(String user, String date, String count, String price) {
        this.user = user;
        this.date = date;
        this.count = count;
        this.price = price;
    }

    public Order() {

    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
