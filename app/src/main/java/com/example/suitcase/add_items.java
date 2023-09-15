package com.example.suitcase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.suitcase.databinding.ActivityAddItemsBinding;

public class add_items extends AppCompatActivity {
    ActivityAddItemsBinding binding;
    Items_Dbhelper items_dbhelper;

    private Uri imageUri;

    public static Intent getIntent(Context context) {
        return new Intent(context, add_items.class);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);
        binding = ActivityAddItemsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        imageUri = Uri.EMPTY;
        binding.addImage.setOnClickListener(this::pickImage);
        binding.btnSave.setOnClickListener(this::saveItems);

    }

    private void saveItems(View view) {
        String name = binding.itemName.getText().toString().trim();
        if (name.isEmpty()) {
            binding.itemName.setError("name is empty");
            binding.itemName.requestFocus();

        }

        double price = 0;
        try {
            price = Double.parseDouble(binding.itemPrice.getText().toString().trim());

        } catch (NullPointerException e) {
            Toast.makeText(this, "something went wrong", Toast.LENGTH_SHORT).show();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "price should be a number", Toast.LENGTH_SHORT).show();
        }
        if (price <= 0) {
            binding.itemPrice.setError("price should be greater than 0");
            binding.itemPrice.requestFocus();

        }
        String description = binding.itemDescription.getText().toString().trim();
        if (description.isEmpty()) {
            binding.itemDescription.setError("Description is empty");
            binding.itemDescription.requestFocus();


        }
        if (items_dbhelper.insert(name, price, description, imageUri.toString(), false)) {
            Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show();
            finish();
        }

    }

    private void pickImage(View view) {
        ImagePickUtility.pickImage(view, add_items.this);
    }
}
