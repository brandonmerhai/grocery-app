package com.example.shoppinglistfinal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateItem extends AppCompatActivity {

    EditText item_name, item_desc, item_price;
    Button update, delete;

    String id, name, desc, price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        item_name = findViewById(R.id.item_name_value_2);
        item_desc = findViewById(R.id.item_desc_value_2);
        item_price = findViewById(R.id.item_price_value_2);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
                DBHelper myDB = new DBHelper(UpdateItem.this);
                name = item_name.getText().toString().trim();
                desc = item_desc.getText().toString().trim();
                price = item_price.getText().toString().trim();
                myDB.updateData(id, name, desc, price);
            }
        });
    }
}
