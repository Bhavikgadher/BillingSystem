package com.example.bilingsystem;

import static com.example.bilingsystem.Constant.*;
import static com.example.bilingsystem.Util.stringToInt;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;

import com.example.bilingsystem.databinding.AddEditItemDialogBinding;

public class ItemAddEditDialog {
    private Context context;
    private Dialog dialog;
    private ItemModel model;
    private OnClickListener<ItemModel> listener;

    public ItemAddEditDialog(Context context, OnClickListener<ItemModel> listener) {
        this.context = context;
        this.listener = listener;
        prepDialog();
    }

    public ItemAddEditDialog(Context context, OnClickListener<ItemModel> listener, ItemModel model) {
        this.context = context;
        this.listener = listener;
        this.model = model;
        prepDialog();
    }

    private void prepDialog() {
        AddEditItemDialogBinding binding = AddEditItemDialogBinding.inflate( LayoutInflater.from( context ), null, false );
        dialog = new Dialog( context );
        dialog.setCancelable( false );
        dialog.setCanceledOnTouchOutside( false );
        dialog.requestWindowFeature( Window.FEATURE_NO_TITLE );
        dialog.setCancelable( false );
        dialog.setCanceledOnTouchOutside( false );
        dialog.getWindow().setBackgroundDrawableResource( android.R.color.transparent );
        dialog.setContentView( binding.getRoot() );

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom( dialog.getWindow().getAttributes() );
        lp.width = (int) (context.getResources().getDisplayMetrics().widthPixels * 0.90);
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes( lp );

        if (model != null) {
            binding.tieProductName.setText( model.getItemName() );
            binding.tiePrice.setText( model.getItemPrice() );
            binding.tieQty.setText( model.getItemQuantity() );
        }

        binding.btnCancel.setOnClickListener( view -> {
            closeDialog();
        } );
        binding.btnOkay.setOnClickListener( view -> {
            String name = binding.tieProductName.getText().toString();
            String price = binding.tiePrice.getText().toString();
            String qty = binding.tieQty.getText().toString();
            int qtyNum = stringToInt( qty );
            int priceNum = stringToInt( price );
            if (name.isEmpty()) {
                binding.tieProductName.setError( "Please enter product name" );
            } else if (price.isEmpty()) {
                binding.tiePrice.setError( "Please enter price" );
            } else if (priceNum == -1) {
                binding.tiePrice.setError( "Please enter valid price" );
            } else if (qty.isEmpty()) {
                binding.tieQty.setError( "Please enter quantity" );
            } else if (qtyNum == -1) {
                binding.tieQty.setError( "Please enter valid quantity" );
            } else {
                if (model == null) {
                    int total = priceNum * qtyNum;
                    model = new ItemModel( name, qty, price, String.valueOf( total ) );
                } else {
                    int total = priceNum * qtyNum;
                    model.setItemName( name );
                    model.setItemPrice( price );
                    model.setItemName( qty );
                    model.setItemTotal( String.valueOf( total ) );
                }
                listener.onClick( ADD_EDIT_ITEM, -1, model );
                closeDialog();
            }
        } );
    }

    public void showDialog() {
        if (dialog != null) {
            dialog.show();
        }
    }

    public void closeDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
