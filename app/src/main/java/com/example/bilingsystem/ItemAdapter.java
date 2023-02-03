package com.example.bilingsystem;

import static com.example.bilingsystem.MainActivity.itemModelList;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bilingsystem.databinding.ItemLayoutBinding;


import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    public static List<ItemModel> productItemList;

    public ItemAdapter(List<ItemModel> productItemList) {
        this.productItemList = productItemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLayoutBinding itemLayoutBinding= ItemLayoutBinding.inflate( LayoutInflater.from( parent.getContext() ),parent,false );
        return new ItemViewHolder( itemLayoutBinding );
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return productItemList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        ItemLayoutBinding itemLayoutBinding;
        public ItemViewHolder(@NonNull ItemLayoutBinding itemLayoutBinding) {
            super( itemLayoutBinding.getRoot() );
            this.itemLayoutBinding = itemLayoutBinding;
        }

        void bind(int position){
            ItemModel model = itemModelList.get( position );
            itemLayoutBinding.itemNum.setText( model.getItemNo() );
            itemLayoutBinding.itemPrice.setText( "Rs." + model.getItemPrice() + "/-" );
            itemLayoutBinding.productTotal.setText( "Rs." + model.getItemTotal() + "/-" );
            itemLayoutBinding.itemName.setOnClickListener( v -> {
                Dialog quantityDialog = new Dialog( itemView.getContext() );
                quantityDialog.setContentView( R.layout.qunantity_dialog );
                quantityDialog.getWindow().setLayout( ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT );
                quantityDialog.setCancelable( false );
                EditText productName = quantityDialog.findViewById( R.id.product_name );
                EditText quantityNo = quantityDialog.findViewById( R.id.quantity_no );
                Button cancelBtn = quantityDialog.findViewById( R.id.quantity_cancel_btn );
                Button okBtn = quantityDialog.findViewById( R.id.quantity_ok_btn );
                cancelBtn.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        quantityDialog.dismiss();
                    }
                } );
                okBtn.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       itemLayoutBinding.itemName.setText( productName.getText() );
                        itemLayoutBinding.productQuantity.setText( quantityNo.getText() );
                        quantityDialog.dismiss();
                    }
                } );
                quantityDialog.show();
            } );
            itemLayoutBinding.productQuantity.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Dialog quantityDialog = new Dialog( itemView.getContext() );
                    quantityDialog.setContentView( R.layout.qunantity_dialog );
                    quantityDialog.getWindow().setLayout( ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT );
                    quantityDialog.setCancelable( false );
                    EditText productName = quantityDialog.findViewById( R.id.product_name );
                    EditText quantityNo = quantityDialog.findViewById( R.id.quantity_no );
                    Button cancelBtn = quantityDialog.findViewById( R.id.quantity_cancel_btn );
                    Button okBtn = quantityDialog.findViewById( R.id.quantity_ok_btn );
                    cancelBtn.setOnClickListener( new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            quantityDialog.dismiss();
                        }
                    } );
                    okBtn.setOnClickListener( new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            itemLayoutBinding.itemName.setText( productName.getText() );
                            itemLayoutBinding.productQuantity.setText( quantityNo.getText() );
                            quantityDialog.dismiss();
                        }
                    } );
                    quantityDialog.show();
                }
            } );
//            allItemTotalPrice.setText( "Rs." + allItemPrice + "/-" );
            itemLayoutBinding.removeBtn.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemModelList.clear();
                }
            } );
        }
    }
}
