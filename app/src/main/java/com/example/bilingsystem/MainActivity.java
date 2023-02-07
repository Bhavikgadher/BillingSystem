package com.example.bilingsystem;

import static com.example.bilingsystem.Constant.ADD_EDIT_ITEM;
import static com.example.bilingsystem.Constant.DELETE_ITEM;
import static com.example.bilingsystem.Constant.ROOT_VIEW;
import static com.example.bilingsystem.Util.stringToInt;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.bilingsystem.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ItemAdapter itemAdapter;
    private List<ItemModel> itemModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        binding = DataBindingUtil.setContentView( this, R.layout.activity_main );
        setSupportActionBar( binding.appBarMain.toolbar );
        getSupportActionBar().setDisplayShowTitleEnabled( false );

        Thread timeDate = new Thread() {
            @Override
            public void run() {
                try {
                    while (!interrupted()) {
                        Thread.sleep( 1000 );
                        runOnUiThread( new Runnable() {
                            @Override
                            public void run() {
                                long data = System.currentTimeMillis();
                                SimpleDateFormat date = new SimpleDateFormat( "dd MMM yyyy          -        hh-mm-ss a" );
                                String dataString = date.format( data );
                                binding.companyDetailsLayout.date.setText( dataString );
                            }
                        } );
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        timeDate.start();


        itemModelList = new ArrayList<>();
        itemAdapter = new ItemAdapter( itemModelList, (msg, position, itemModel) -> {
            switch (msg) {
                case ROOT_VIEW:
                    ItemAddEditDialog dialog = new ItemAddEditDialog( this, (message, pos, model) -> {
                        if (message == ADD_EDIT_ITEM) {
                            itemModelList.set( position, model );
                            itemAdapter.notifyDataSetChanged();
                            binding.productDetailsLayout.allItmeTotalAmount.setText( String.format( getString( R.string.suffix_rs), calculateTotal() ) );
                        }
                    }, itemModel );
                    dialog.showDialog();
                    break;
                case DELETE_ITEM:
                    itemModelList.remove( position );
                    itemAdapter.notifyDataSetChanged();
                    binding.productDetailsLayout.allItmeTotalAmount.setText( String.format( getString( R.string.suffix_rs), calculateTotal() ) );
                    break;
            }
        } );
        binding.productDetailsLayout.productRv.setAdapter( itemAdapter );
        binding.companyDetailsLayout.btnAddItem.setOnClickListener( v -> addItem() );
        binding.productDetailsLayout.allItmeTotalAmount.setText( String.format( getString( R.string.suffix_rs), calculateTotal() ) );

        binding.btnPrint.setOnClickListener( v -> Toast.makeText( MainActivity.this, "Billing Done", Toast.LENGTH_SHORT ).show() );

    }

    private void addItem() {
        ItemAddEditDialog dialog = new ItemAddEditDialog( this, (message, pos, model) -> {
            if (message == ADD_EDIT_ITEM) {
                itemModelList.add( model );
                itemAdapter.notifyDataSetChanged();
                binding.productDetailsLayout.allItmeTotalAmount.setText( String.format( getString( R.string.suffix_rs), calculateTotal() ) );
            }
        } );
        dialog.showDialog();
    }

    private int calculateTotal() {
        int allItemTotal = 0;
        for (int i = 0; i < itemModelList.size(); i++) {
            ItemModel itemModel = itemModelList.get( i );
            int productTotal = stringToInt(itemModel.getItemTotal());
            if (productTotal != -1) {
                allItemTotal +=productTotal;
            }
        }
        return allItemTotal;
    }
}