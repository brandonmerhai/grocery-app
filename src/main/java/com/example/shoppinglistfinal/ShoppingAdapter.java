package com.example.shoppinglistfinal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import androidx.recyclerview.widget.RecyclerView;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList item_id, item_name, item_desc, item_price;

    ShoppingAdapter(Activity activity, Context context, ArrayList item_id, ArrayList item_name, ArrayList item_desc,
                      ArrayList item_price){
            this.activity = activity;
            this.context = context;
            this.item_id = item_id;
            this.item_name = item_name;
            this.item_desc = item_desc;
            this.item_price = item_price;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.item_layout, parent, false);
            return new MyViewHolder(view);
        }
        @Override
        public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
            holder.item_id_value.setText(String.valueOf(item_id.get(position)));
            holder.item_name_value.setText(String.valueOf(item_name.get(position)));
            holder.item_desc_value.setText(String.valueOf(item_desc.get(position)));
            holder.item_price_value.setText(String.valueOf(item_price.get(position)));
        }

        @Override
        public int getItemCount() {
            return item_id.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView item_id_value, item_name_value, item_desc_value, item_price_value;
            LinearLayout mainLayout;

            MyViewHolder(@NonNull View itemView) {
                super(itemView);
                item_id_value = itemView.findViewById(R.id.item_id_value);
                item_name_value = itemView.findViewById(R.id.item_name_value_2);
                item_desc_value = itemView.findViewById(R.id.item_desc_value_2);
                item_price_value = itemView.findViewById(R.id.item_price_value_2);
                mainLayout = itemView.findViewById(R.id.mainLayout);
            }

        }

}
