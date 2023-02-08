package com.example.bilingsystem;

public class ItemModel {

    private String name;
    private String quantity;
    private String price;
    private String total;
    private String weight;

    public ItemModel(String name, String quantity, String price, String total, String weight) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
//    private String itemName;
//    private String itemQuantity;
//    private String itemPrice;
//    private String itemTotal;
//
//    private String itemUOM;
//
//    public ItemModel(String itemName, String itemQuantity, String itemPrice, String itemTotal, String itemUom) {
//        this.itemName = itemName;
//        this.itemQuantity = itemQuantity;
//        this.itemPrice = itemPrice;
//        this.itemTotal = itemTotal;
//        this.itemUOM = itemUom;
//    }
//
//    public String getItemName() {
//        return itemName;
//    }
//
//    public void setItemName(String itemName) {
//        this.itemName = itemName;
//    }
//
//    public String getItemQuantity() {
//        return itemQuantity;
//    }
//
//    public void setItemQuantity(String itemQuantity) {
//        this.itemQuantity = itemQuantity;
//    }
//
//    public String getItemPrice() {
//        return itemPrice;
//    }
//
//    public void setItemPrice(String itemPrice) {
//        this.itemPrice = itemPrice;
//    }
//
//    public String getItemTotal() {
//        return itemTotal;
//    }
//
//    public void setItemTotal(String itemTotal) {
//        this.itemTotal = itemTotal;
//    }
//
//    public String getItemUOM() {
//        return itemUOM;
//    }
//
//    public void setItemUOM(String itemUOM) {
//        this.itemUOM = itemUOM;
//    }
}
