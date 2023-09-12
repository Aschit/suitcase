package com.example.suitcase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.suitcase.Adapter.ItemsAdapter;
import com.example.suitcase.Adapter.RecyclerViewItemClickListener;
import com.example.suitcase.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FloatingActionButton fab;
    private ArrayList<ItemModel>itemModels;
    private DataBaseHelper dataBaseHelper;
    private RecyclerView itemRecyclerview;
    private ItemsAdapter itemsAdapter;
    private NavigationView navigationView;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // Top Navigation View
        binding.nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id= item.getItemId();
                if(id==R.id.item_home){
                    Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Click to Home item", Toast.LENGTH_SHORT).show();
                }
                if (id==R.id.item_about){
                    Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);

                    Toast.makeText(MainActivity.this, "Click to About item", Toast.LENGTH_SHORT).show();
                }

                if(id==R.id.item_contact){
                    Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Click to Home item", Toast.LENGTH_SHORT).show();
                }
                if(id==R.id.item_profile){
                    Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Click to Home item", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
        final DrawerLayout drawerLayout=findViewById(R.id.drawer);
        findViewById(R.id.navmenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        // initialize the data
        itemModels= new ArrayList<>();
        dataBaseHelper= new DataBaseHelper(this);


        // item touch helper setup
        setupItemTouchHelper();

        // initialize
        fab= findViewById(R.id.fab);




        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), add_items.class);
                startActivity(intent);
            }
        });


    }

    private void setupItemTouchHelper() {

    }
}