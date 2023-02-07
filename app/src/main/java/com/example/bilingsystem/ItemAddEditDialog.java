package com.example.bilingsystem;

import static com.example.bilingsystem.Constant.ADD_EDIT_ITEM;
import static com.example.bilingsystem.Util.stringToInt;

import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.bilingsystem.databinding.AddEditItemDialogBinding;

import java.util.Objects;

public class ItemAddEditDialog {
    private Context context;
    private AddEditItemDialogBinding binding;
    private Dialog dialog;
    private ItemModel model;
    private OnClickListener<ItemModel> listener;
    private String itemUom = null;
    private double multiplier = 1;
    private int pricePerUnit = 0;
    private int qty = 0;

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
        binding = AddEditItemDialogBinding.inflate( LayoutInflater.from( context ), null, false );
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

        String[] weight = context.getResources().getStringArray( R.array.weight );
        ArrayAdapter arrayAdapter = new ArrayAdapter( context, R.layout.drop_down, weight );
        binding.actvUom.setAdapter( arrayAdapter );

        binding.actvUom.setOnItemClickListener( (parent, view, position, id) -> {
            itemUom = String.valueOf( parent.getAdapter().getItem( position ) );
            if (Objects.equals( itemUom, "Kg" )) {
                multiplier = 1;
            } else if (Objects.equals( itemUom, "Gram" )) {
                multiplier = 1d/ 1000;
            }
            calculateTotal(pricePerUnit,qty, multiplier );
        } );

        if (model != null) {
            binding.tieProductName.setText( model.getItemName() );
            binding.tiePrice.setText( model.getItemPrice() );
            binding.tieQty.setText( model.getItemQuantity() );
        }

        binding.tieUnitPrice.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int temp = stringToInt( s.toString() );
                if (temp != -1) {
                    pricePerUnit = temp;
                    calculateTotal(pricePerUnit,qty, multiplier );
                } else {
                    Toast.makeText( context, "please enter valid unit price", Toast.LENGTH_SHORT ).show();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        } );
        binding.tieQty.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int temp = stringToInt( s.toString() );
                if (temp != -1) {
                    qty = temp;
                    calculateTotal(pricePerUnit,qty, multiplier );
                } else {
                    Toast.makeText( context, "please enter valid quantity", Toast.LENGTH_SHORT ).show();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        } );

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
            } /*else if (price.isEmpty()) {
                binding.tiePrice.setError( "Please enter price" );
            } else if (priceNum == -1) {
                binding.tiePrice.setError( "Please enter valid price" );
            } */else if (qty.isEmpty()) {
                binding.tieQty.setError( "Please enter quantity" );
            } else if (qtyNum == -1) {
                binding.tieQty.setError( "Please enter valid quantity" );
            } else if (itemUom == null) {
                binding.actvUom.setError( "Please select weight" );
            } else {
                if (model == null) {
                    int total = priceNum * qtyNum;
                    model = new ItemModel( name, qty, price, String.valueOf( total ), itemUom );
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

    private void calculateTotal(int priceInKg, int qtyInKg, double multiplier) {
        //price per kg 1000, qty 5, selection is kg
        // 1000*5*1 = 5000
        //price per kg 1000, qty 5, selection is gram
        // 1000*5*0.001 = 5
        Log.e("LOG_LOG"," : "+priceInKg+" : "+qtyInKg+" : "+multiplier+" : ");
        binding.tiePrice.setText( String.valueOf( priceInKg * qtyInKg * multiplier ) );
    }
//
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
