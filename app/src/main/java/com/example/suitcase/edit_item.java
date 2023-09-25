package com.example.suitcase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class edit_item extends AppCompatActivity {
    public static Intent getIntent(Context context, ItemsModel item) {
        Intent intent = new Intent(context, edit_item.class);
//        intent.putExtra(id, item.getId());
//        intent.putExtra(NAME, item.getName());
//        intent.putExtra(PRICE, item.getPrice().toString());
//        intent.putExtra(DESCRIPTION, item.getDescription());
//        intent.putExtra(IMAGE, item.getImage().toString());
//        intent.putExtra(IS_PURCHASED, item.isPurchased());

        return intent;
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
    }
}