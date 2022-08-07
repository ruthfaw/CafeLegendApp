package com.example.cafelegendapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Beverage extends Fragment {

    View v;
    RecyclerView myrecyclerview;
    List<Foodlist> listFood;

    public Beverage() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_beverage, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.beverageRV);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(), listFood);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listFood = new ArrayList<>();
        listFood.add(new Foodlist("Midnight Mojito", "4.2", "43 sold", "Rp. 27.000", R.drawable.slider_5,"Fresh and Refreshing Drink"));
        listFood.add(new Foodlist("Mezcal Paloma", "4.5", "46 sold", "Rp. 20.000", R.drawable.bvg_2, "Sour and Enjoyable Drink"));
        listFood.add(new Foodlist("Berry Cocktail", "4.7", "48 sold", "Rp. 35.000", R.drawable.bvg_3, "A Very Satisfying Fruit Cocktails"));
        listFood.add(new Foodlist("Mint Julep", "5.0", "67 sold", "Rp. 42.000", R.drawable.bvg_4, "Minty and Fresh"));
        listFood.add(new Foodlist("Pineapple Cherry Juice", "4.1", "18 sold", "Rp. 17.000", R.drawable.bvg_5, "Sweet and Sour Taste"));
        listFood.add(new Foodlist("Salted Caramel Milkshake", "4.8", "57 sold", "Rp. 38.000", R.drawable.bvg_6, "Enjoyable Anytime Anywhere"));
        listFood.add(new Foodlist("Strawberry Cheesecake Milkshake", "4.8", "58 sold", "Rp. 42.000", R.drawable.bvg_7, "Sweet, Sour, and Cheesy Taste"));
        listFood.add(new Foodlist("Grasshopper Pie Milkshakes", "4.2", "27 sold", "Rp. 35.000", R.drawable.bvg_8,"Delightful Drink with Minty Taste"));
        listFood.add(new Foodlist("Mixed Berry & Banana Smoothie", "4.7", "45 sold", "Rp. 40.000", R.drawable.bvg_9,"Healty and Nutritious Drink"));
        listFood.add(new Foodlist("Berry Lemon Squash", "4.8", "39 sold", "Rp. 22.000", R.drawable.bvg_10,"Sour and Refreshing Taste"));
    }

}