package com.example.cafelegendapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MenuDetailsActivity extends AppCompatActivity {

    ImageView foodImage;
    TextView foodName, foodPrice, foodDesc;
    Button buyBtn;
    Bundle extras;

    void init(){
        foodImage = findViewById(R.id.image_details);
        foodName = findViewById(R.id.name_details);
        foodPrice = findViewById(R.id.price_details);
        foodDesc = findViewById(R.id.desc_details);
        buyBtn = findViewById(R.id.buyBtn);

        extras = getIntent().getExtras();
        foodImage.setImageResource(extras.getInt("image_detail"));
        foodName.setText(extras.getString("name_detail"));
        foodPrice.setText(extras.getString("price_detail"));
        foodDesc.setText(extras.getString("desc_detail"));
    }

    public void showDialog(String msg){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder
                .setMessage(msg)
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(false)
                .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    void quantityValidation(){
        buyBtn.setOnClickListener(x-> {
            EditText quantity = findViewById(R.id.quantity);
            String quantityString = quantity.getText().toString();
            int quantityVar = Integer.parseInt(quantityString);

            if (quantityVar <= 0) {
                showDialog("Quantity must be greater than 0!");
            } else {
                Toast.makeText(this, "Success Buying", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_details);
        init();
        quantityValidation();
    }
}