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

public class MainCourse extends Fragment {

    View v;
    RecyclerView myrecyclerview;
    List<Foodlist> listFood;

    public MainCourse() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_main_course, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.maincourseRV);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(), listFood);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listFood = new ArrayList<>();
        listFood.add(new Foodlist("Burger & Fries Package", "4.0", "42 sold", "Rp. 35.000", R.drawable.mc_1,"Fun and Exciting Taste"));
        listFood.add(new Foodlist("Fresh Vegetarian Pasta", "4.6", "48 sold", "Rp. 27.000", R.drawable.mc_2,"Natural and Healthy Food"));
        listFood.add(new Foodlist("Parmesan Spaghetti", "4.5", "35 sold", "Rp. 42.000", R.drawable.mc_3, "Creamy and Dreamy Taste"));
        listFood.add(new Foodlist("Honey Butter Chicken", "5.0", "72 sold", "Rp. 75.000", R.drawable.mc_4, "Crispy, Sweet, and Savory"));
        listFood.add(new Foodlist("Steak & Potato Skillet", "4.7", "52 sold", "Rp. 124.000", R.drawable.mc_5, "Meaty and Enjoyable Taste"));
        listFood.add(new Foodlist("Tacos", "4.5", "30 sold", "Rp. 68.000", R.drawable.mc_6, "Delicious Classic Tacos"));
        listFood.add(new Foodlist("Sandwich", "4.3", "22 sold", "Rp. 35.000", R.drawable.mc_7,"Crazy Delicious Sandwich"));
        listFood.add(new Foodlist("Pan Seared Salmon", "4.4", "37 sold", "Rp. 125.000", R.drawable.mc_8, "Fine and Delicate Taste"));
        listFood.add(new Foodlist("Tortellini Casserole", "5.0", "53 sold", "Rp. 78.000", R.drawable.mc_9, "Simple but Elegant Western Cuisine"));
        listFood.add(new Foodlist("Mac and Cheese", "4.0", "29 sold", "Rp. 32.000", R.drawable.mc_10,"Cheesy and Creamy Dish"));
    }
}