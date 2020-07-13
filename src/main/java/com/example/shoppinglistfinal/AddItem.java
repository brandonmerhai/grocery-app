package com.example.shoppinglistfinal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddItem extends AppCompatActivity
{
    EditText item_input, desc_input, price_input;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        item_input = findViewById(R.id.item_name_value_2);
        desc_input = findViewById(R.id.item_desc_value_2);
        price_input = findViewById(R.id.item_price_value_2);
        save = findViewById(R.id.update);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper myDB = new DBHelper(AddItem.this);
                myDB.addItem(item_input.getText().toString().trim(),
                        desc_input.getText().toString().trim(),
                        Integer.valueOf(price_input.getText().toString().trim()));
            }
        });
    }
}
