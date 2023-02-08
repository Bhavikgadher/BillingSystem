package com.example.bilingsystem;

import static com.example.bilingsystem.Constant.DELETE_ITEM;
import static com.example.bilingsystem.Constant.ROOT_VIEW;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bilingsystem.databinding.ItemLayoutBinding;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private List<ItemModel> productItemList;
    private OnClickListener<ItemModel> listener;

    public ItemAdapter(List<ItemModel> productItemList, OnClickListener<ItemModel> listener) {
        this.productItemList = productItemList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLayoutBinding itemLayoutBinding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ItemViewHolder(itemLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return productItemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        ItemLayoutBinding itemLayoutBinding;

        public ItemViewHolder(@NonNull ItemLayoutBinding itemLayoutBinding) {
            super(itemLayoutBinding.getRoot());
            this.itemLayoutBinding = itemLayoutBinding;
        }

        void bind(int position) {
            Context ctx = itemLayoutBinding.getRoot().getContext();
            ItemModel model = productItemList.get(position);
            itemLayoutBinding.tvNumber.setText(String.valueOf(getAdapterPosition() + 1));
            itemLayoutBinding.tvProductName.setText(model.getName());
            itemLayoutBinding.tvQuantity.setText(model.getQuantity()+" "+model.getWeight());
            itemLayoutBinding.tvPrice.setText( model.getPrice() );
            itemLayoutBinding.tvProductTotal.setText( model.getTotal() );
//            itemLayoutBinding.tvPrice.setText(String.format(ctx.getString( R.string.suffix_rs_dash), model.getItemPrice()));
//            itemLayoutBinding.tvProductTotal.setText(String.format(ctx.getString( R.string.suffix_rs_dash), model.getItemTotal()));
            itemLayoutBinding.btnRemove.setOnClickListener(v -> listener.onClick(DELETE_ITEM, position, model));
            itemLayoutBinding.getRoot().setOnClickListener(view -> listener.onClick(ROOT_VIEW, position, model));
        }
    }
}
