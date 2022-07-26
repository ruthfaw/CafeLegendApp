package com.example.cafelegendapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usernameET;
    EditText passwordET;
    Button loginBtn;
    TextView errorTV;

    public void init(){
        usernameET = findViewById(R.id.usernameET);
        passwordET = findViewById(R.id.passwordET);
        loginBtn = findViewById(R.id.loginBtn);
        errorTV = findViewById(R.id.errorTV);
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

    void buttonEvent(){
        loginBtn.setOnClickListener(x->{
            String username = usernameET.getText().toString();
            String password = passwordET.getText().toString();

            if(username.equals("") || password.equals("")){
                showDialog("Registration Failed!");
                errorTV.setText("Fields cannot be empty");
                errorTV.setVisibility(View.VISIBLE);
            }else if((username.length() < 5 || username.length() > 20)){
                showDialog("Registration Failed!");
                errorTV.setText("Username's length must be between 5 and 20");
                errorTV.setVisibility(View.VISIBLE);
            }else if(!isAlphaNumeric(password)){
                showDialog("Registration Failed!");
                errorTV.setText("Password must contain both letter and number (alphanumeric)");
                errorTV.setVisibility(View.VISIBLE);
            }else{
                Toast.makeText(this, "Success Login", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, HomeActivity.class);
                intent.putExtra("username", usernameET.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }

    public static boolean isAlphaNumeric(String text){
        //contain number or letter
//        return text.matches("^[a-zA-Z0-9]+$");

        //must contain both number and letter, at least 1 number and 1 letter
        return text.matches("^(?=[a-zA-Z0-9]*[a-zA-Z])(?=[a-zA-Z0-9]*\\d)[a-zA-Z0-9]*$");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        buttonEvent();
    }
}