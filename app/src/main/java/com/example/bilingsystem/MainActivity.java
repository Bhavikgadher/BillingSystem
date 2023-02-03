package com.example.bilingsystem;

import static com.example.bilingsystem.ItemAdapter.productItemList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bilingsystem.databinding.ActivityMainBinding;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ItemAdapter itemAdapter;
    public static List<ItemModel> itemModelList;

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
        itemModelList.add( new ItemModel( "1", "Ghughara", "5", "44", "451" ) );
        itemModelList.add( new ItemModel( "2", "PaniPuri", "", "", "" ) );
        itemModelList.add( new ItemModel( "3", "BhelPuri", "", "", "" ) );
        itemModelList.add( new ItemModel( "4", "Ragado", "", "", "" ) );

        itemAdapter = new ItemAdapter( itemModelList );
        binding.productDetailsLayout.productRv.setAdapter( itemAdapter );
        itemAdapter.notifyDataSetChanged();

        binding.companyDetailsLayout.imageButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        } );

        binding.printBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( MainActivity.this, "Billing Done", Toast.LENGTH_SHORT ).show();
            }
        } );

    }

    private void addItem() {
        itemModelList.add( new ItemModel( "1", "bha", "2", "36", "72" ) );

    }

}