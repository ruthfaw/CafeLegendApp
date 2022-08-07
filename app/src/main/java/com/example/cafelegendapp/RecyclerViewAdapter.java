package com.example.cafelegendapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Foodlist> mData;
    Bundle extras;

    public RecyclerViewAdapter(Context mContext, List<Foodlist> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.food_list,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);

        vHolder.foodlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Foodlist foodlist = mData.get(vHolder.getAdapterPosition());
                Intent intent = new Intent(mContext, MenuDetailsActivity.class);
                intent.putExtra("image_detail", foodlist.getFoodImage());
                intent.putExtra("name_detail", foodlist.getFoodName());
                intent.putExtra("price_detail", foodlist.getFoodPrice());
                intent.putExtra("desc_detail", foodlist.getFoodDesc());
//                intent.putExtra("username", extras.getString("username").toString());
                mContext.startActivity(intent);
            }
        });

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.foodnameTV.setText(mData.get(position).getFoodName());
        holder.foodratingTV.setText("Rating : " + mData.get(position).getFoodRating());
        holder.foodsoldTV.setText("Sold Amount : " + mData.get(position).getFoodSold());
        holder.foodpriceTV.setText(mData.get(position).getFoodPrice());
        holder.foodimageIV.setImageResource(mData.get(position).getFoodImage());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        LinearLayout foodlist;
        TextView foodnameTV;
        TextView foodratingTV;
        TextView foodsoldTV;
        TextView foodpriceTV;
        ImageView foodimageIV;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            foodlist = (LinearLayout) itemView.findViewById(R.id.food_list);
            foodnameTV = (TextView) itemView.findViewById(R.id.food_name);
            foodratingTV = (TextView) itemView.findViewById(R.id.food_rating);
            foodsoldTV = (TextView) itemView.findViewById(R.id.food_sold);
            foodpriceTV = (TextView) itemView.findViewById(R.id.food_price);
            foodimageIV = (ImageView) itemView.findViewById(R.id.food_image);
        }
    }
}
