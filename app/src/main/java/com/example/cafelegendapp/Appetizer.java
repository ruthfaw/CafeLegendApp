package com.example.cafelegendapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class Appetizer extends Fragment {

    View v;
    RecyclerView myrecyclerview;
    List<Foodlist> listFood;

    public Appetizer() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_appetizer, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.appetizerRV);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(), listFood);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listFood = new ArrayList<>();
        listFood.add(new Foodlist("Macarons", "4.3", "50 sold", "Rp. 25.000", R.drawable.slider_1, "Sweet and Tasty Macarons"));
        listFood.add(new Foodlist("Croissants", "4.5", "45 sold", "Rp. 17.000", R.drawable.slider_2, "Warm Croissants with Alluring Smell"));
        listFood.add(new Foodlist("Sausage Roll", "4.0", "25 sold", "Rp. 34.000", R.drawable.appetz_3, "Meaty and Tasty"));
        listFood.add(new Foodlist("Vegan Bruschetta", "4.7", "55 sold", "Rp. 46.000", R.drawable.appetz_4, "Healty and Fresh Bruschetta"));
        listFood.add(new Foodlist("Corn Dog", "4.7", "12 sold", "Rp. 27.000", R.drawable.appetz_5, "Crispy and Hot"));
        listFood.add(new Foodlist("Mozarella Sticks", "4.5", "24 sold", "Rp. 30.000", R.drawable.appetz_6,"Delicious with Strong Chesse Taste"));
        listFood.add(new Foodlist("Crab Rangoon", "4.2", "29 sold", "Rp. 23.000", R.drawable.appetz_7,"Crispy and Savory"));

    }

}