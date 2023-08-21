package com.example.suitcase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.suitcase.databinding.ActivitySignupPageBinding;

public class signup_page extends AppCompatActivity {
    ActivitySignupPageBinding binding;
    DataBaseHelper dataBaseHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
        binding=ActivitySignupPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dataBaseHelper= new DataBaseHelper(this);
//        getSupportActionBar().hide();

        // click for signup button
        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get text method
                String email= binding.signupEmail.getText().toString().trim();
                String password= binding.signupPassword.getText().toString().trim();
                String cpassword= binding.signupCpassword.getText().toString().trim();

                // form validation

                if(email.equals("")|| password.equals("")|| cpassword.equals("")){
                    Toast.makeText(signup_page.this, "All fields are mandatory ", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(password.equals(cpassword)){
                        boolean checkemail= dataBaseHelper.CheckEmail(email);
                        if (checkemail==false){
                            boolean insert= dataBaseHelper.insertUsers(email,password);
                            if (insert==true){
                                Toast.makeText(signup_page.this, "Signup complete", Toast.LENGTH_SHORT).show();
                                Intent intent= new Intent(getApplicationContext(), login_page.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(signup_page.this, "Signup fail", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else{
                            Toast.makeText(signup_page.this, "user already exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(signup_page.this, "Invalid password", Toast.LENGTH_SHORT).show();
                    }
                }

                // signup method
            }
        });
        // click to move login page

        binding.txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), login_page.class);
                startActivity(intent);
            }
        });


    }
}