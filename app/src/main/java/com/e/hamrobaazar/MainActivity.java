package com.e.hamrobaazar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView itemsRecyclerView;

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawerLayout);
        toolbar=findViewById(R.id.toolbar);
        itemsRecyclerView=findViewById(R.id.itemsRecyclerView);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.start,R.string.end);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        /*

        List<Item>items=new ArrayList<>();
        items.add(new Item("pulsar",R.drawable.cat,1000,"Used"));
        items.add(new Item("Bajaj",R.drawable.cat,1000,"Used"));
        items.add(new Item("Crossfire",R.drawable.dd,14000,"New"));
        items.add(new Item("Shine",R.drawable.dog,14000,"New"));

        ItemAdapter itemAdapter=new ItemAdapter(this,items);
        itemsRecyclerView.setAdapter(itemAdapter);
        itemsRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));*/

    }
}
