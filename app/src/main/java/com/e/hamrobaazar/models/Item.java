package com.e.hamrobaazar.models;

public class Item {
    private String name;
    private int imgId;
    private  int price;
    private  String condition;

    public Item(String name, int imgId, int price, String condition) {
        this.name = name;
        this.imgId = imgId;
        this.price = price;
        this.condition = condition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
