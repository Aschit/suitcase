package com.example.suitcase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.example.suitcase.databinding.ActivityItemsDetailsBinding;


public class items_details extends AppCompatActivity {
    ActivityItemsDetailsBinding binding;
    //Define variable
    public static final String ID="id";
    public static final String NAME="name";
    public static final String PRICE="price";
    public static final String DESCRIPTION="description";
    public static final String IMAGE="image";
    public static final String IS_PURCHASED="purchased";
    public static final int EDIT_ITEM_REQUEST=10001;

    // get Intent

    public static Intent getIntent(Context context,int id){
        Intent intent=new Intent(context,items_details.class);
        intent.putExtra(ID,id);
        return intent;
    }
    ItemsModel item;
    Items_Dbhelper itemsDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityItemsDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        item=new ItemsModel();
        itemsDbHelper=new Items_Dbhelper(this);

        Bundle bundle=getIntent().getExtras();
        int id=bundle.getInt(items_details.ID);
        Log.d("items_Details",id+"");

        item=retrieveData(id);
        binding.imageViewItem.setImageURI(item.getImage());
        binding.textviewname.setText(item.getName());
        binding.textviewprice.setText(item.getPrice().toString());
        binding.textviewdescription.setText(item.getDescription());

        //click Method of Edit Button

        binding.btnEditItem.setOnClickListener(v -> startEditItems(v ,item));

        //click Method of Share Button
        binding.btnShareItem.setOnClickListener(this::startShareItemActivity);
    }
    public void startEditItems(View v  , ItemsModel item){
        startActivity(edit_item.getIntent(getApplicationContext(),item));
    }
    private ItemsModel retrieveData(int id) {
        Cursor cursor=itemsDbHelper.getElementById(id);
        cursor.moveToNext();
        ItemsModel itemsModel=new ItemsModel();
        itemsModel.setId(cursor.getInt(0));
        itemsModel.setName(cursor.getString(1));
        itemsModel.setPrice(cursor.getDouble(2));
        itemsModel.setDescription(cursor.getString(3));
        itemsModel.setImage(Uri.EMPTY);
        try {
            Uri imageUri=Uri.parse(cursor.getString(4));
            itemsModel.setImage(imageUri);
        }catch (NullPointerException e){
            Toast.makeText
                            (this, "Error occurred is identifying image resource  ",
                                    Toast.LENGTH_SHORT)
                    .show();
        }
        itemsModel.setPurchased(cursor.getInt(5)==1);
        Log.d("items_detail",itemsModel.toString());
        return itemsModel;
    }
    public void startShareItemActivity(View view){
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT,"");
        intent.putExtra(Intent.EXTRA_TEXT,"Check Your Cool Application ");
        startActivity(Intent.createChooser(intent,"Share via"));
    }
}
