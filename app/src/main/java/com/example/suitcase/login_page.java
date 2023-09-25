package com.example.suitcase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.suitcase.databinding.ActivityLoginPageBinding;

public class login_page extends AppCompatActivity {
    ActivityLoginPageBinding binding;
    DatabaseHelper dataBaseHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        binding=ActivityLoginPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getSupportActionBar()!=null){
            getSupportActionBar().hide();


        }



        dataBaseHelper= new DatabaseHelper(this);
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=binding.loginEmail.getText().toString().trim();
                String password= binding.loginPassword.getText().toString().trim();

                if(email.equals("") || password.equals("")){
                    Toast.makeText(login_page.this, "All fields are MAndatory", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkCredentials= dataBaseHelper.checkEmailPassword(email,password);
                    if (checkCredentials==true){
                        Toast.makeText(login_page.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);

                    }else {
                        Toast.makeText(login_page.this, "Invalid Data", Toast.LENGTH_SHORT).show();
                    }
                }



            }
        });
        binding.forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), forget_password.class);
                startActivity(intent);

            }
        });
        binding.txtSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), signup_page.class);
                startActivity(intent);


            }
        });
        binding.forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),forget_password.class);
                startActivity(intent);

            }
        });


    }
}