package com.example.bilingsystem;

public class ItemModel {
    private String itemName;
    private String itemQuantity;
    private String itemPrice;
    private String itemTotal;
    private String itemUOM;

    public ItemModel(String itemName, String itemQuantity, String itemPrice, String itemTotal, String itemUom) {
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        this.itemTotal = itemTotal;
        this.itemUOM = itemUom;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(String itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(String itemTotal) {
        this.itemTotal = itemTotal;
    }

    public String getItemUOM() {
        return itemUOM;
    }

    public void setItemUOM(String itemUOM) {
        this.itemUOM = itemUOM;
    }
}

