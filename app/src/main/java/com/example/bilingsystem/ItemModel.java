package com.example.bilingsystem;

import static com.example.bilingsystem.ItemAdapter.productItemList;
import static com.example.bilingsystem.MainActivity.itemModelList;

import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemModel {
    private String itemNo;
    private String itemName;
    private String itemQuantity;
    private String itemPrice;
    private String itemTotal;
//    private String allItemTotal;

    public ItemModel(String itemNo, String itemName, String itemQuantity, String itemPrice, String itemTotal /* String allItemTotal*/) {
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        this.itemTotal = itemTotal;
//        this.allItemTotal = allItemTotal;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
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

//    public String getAllItemTotal() {
//        return allItemTotal;
//    }
//
//    public void setAllItemTotal(String allItemTotal) {
//        this.allItemTotal = allItemTotal;
//    }
}
