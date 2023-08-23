package com.example.suitcase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.suitcase.databinding.ActivityForgetPasswordBinding;

public class forget_password extends AppCompatActivity {

    ActivityForgetPasswordBinding binding;
    DataBaseHelper dataBaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        binding=ActivityForgetPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dataBaseHelper= new DataBaseHelper(this);

        binding.EmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email= binding.forgetEmail.getText().toString().trim();
                Boolean checkUsers= dataBaseHelper.checkEmail(email);
                if(checkUsers==true){
                    Intent intent= new Intent(getApplicationContext(), Reset_Password.class);
                    intent.putExtra("email",email);
                    startActivity(intent);



                }else{
                    Toast.makeText(forget_password.this, "Email doesnot Exist", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}