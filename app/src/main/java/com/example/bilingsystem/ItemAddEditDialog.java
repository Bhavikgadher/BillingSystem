package com.example.bilingsystem;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.bilingsystem.databinding.QunantityDialogBinding;

public class ItemAddEditDialog {
    private Context context;

    public ItemAddEditDialog(Context context) {
        this.context = context;
    }

    QunantityDialogBinding binding = QunantityDialogBinding.inflate( LayoutInflater.from( context ), null, false );
    Dialog dialog = new Dialog( context );
//            dialog.setCancelable(isCancelable);
//            dialog.setCanceledOnTouchOutside(isCancelable);
//            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//            dialog.setCancelable(isCancelable);
//            dialog.setCanceledOnTouchOutside(isCancelable);
//    dialog.window?.
//
//    setBackgroundDrawableResource(android.R.color.transparent);
//        dialog.setContentView(binding.root);
//                quantityDialog.setContentView(R.layout.qunantity_dialog );
//                quantityDialog.getWindow().
//
//    setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//                quantityDialog.setCancelable(false);
//    EditText productName = quantityDialog.findViewById( R.id.product_name );
//    EditText quantityNo = quantityDialog.findViewById( R.id.quantity_no );
//    Button cancelBtn = quantityDialog.findViewById( R.id.quantity_cancel_btn );
//    Button okBtn = quantityDialog.findViewById( R.id.quantity_ok_btn );
//                cancelBtn.setOnClickListener(new View.OnClickListener()
//
//    {
//        @Override
//        public void onClick (View view){
//        quantityDialog.dismiss();
//    }
//    } );
//                okBtn.setOnClickListener(new View.OnClickListener()
//
//    {
//        @Override
//        public void onClick (View view){
//        itemName.setText( productName.getText() );
//        itemQuantity.setText( quantityNo.getText() );
//        quantityDialog.dismiss();
//    }
//    } );
//                quantityDialog.show();
}
