package com.example.shoppinglistfinal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;
    //ImageView empty_imageview;
    //TextView no_data;

    DBHelper myDB;
    ArrayList<String> item_id, item_name, item_desc, item_price;
    ShoppingAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);
        //empty_imageview = findViewById(R.id.empty_imageview);
       // no_data = findViewById(R.id.no_data);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddItem.class);
                startActivity(intent);
            }
        });

        myDB = new DBHelper(MainActivity.this);
        item_id = new ArrayList<>();
        item_name = new ArrayList<>();
        item_desc = new ArrayList<>();
        item_price = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new ShoppingAdapter(MainActivity.this,this, item_id, item_name, item_desc,
                item_price);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }
    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
            while (cursor.moveToNext()){
                item_id.add(cursor.getString(0));
                item_name.add(cursor.getString(1));
                item_desc.add(cursor.getString(2));
                item_price.add(cursor.getString(3));
            }
        }
}
