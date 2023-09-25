package com.example.suitcase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.suitcase.databinding.ActivityResetPasswordBinding;

public class Reset_Password extends AppCompatActivity {
    ActivityResetPasswordBinding binding;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityResetPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        databaseHelper=new DatabaseHelper(this);

        Intent intent=getIntent();
        String email = intent.getStringExtra("email");
        binding.email.setText(intent.getStringExtra("email"));
        binding.confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String email=binding.email.getText().toString();
                String password=binding.newPassword.getText().toString().trim();
                String rePassword=binding.rePassword.getText().toString().trim();

                if (password.equals(rePassword)){
                    Boolean checkPasswordUpdate=databaseHelper.updatePassword(email, password);
                    if (checkPasswordUpdate==true){
                        Intent updatePasswordIntent=new Intent(getApplicationContext(),login_page.class);
                        startActivity(updatePasswordIntent);
                        Toast.makeText(Reset_Password.this, "Password Updated", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(Reset_Password.this, "Password not update ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
