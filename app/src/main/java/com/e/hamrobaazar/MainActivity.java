package com.e.hamrobaazar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.e.hamrobaazar.API.ItemAPI;
import com.e.hamrobaazar.Adapter.ImageSliderAdapter;
import com.e.hamrobaazar.Adapter.ItemAdapter;
import com.e.hamrobaazar.models.Item;
import com.e.hamrobaazar.url.URL;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Url;

public class MainActivity extends AppCompatActivity {
    private RecyclerView itemsRecyclerView,itemsRecyclerViewTrend;

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private Timer timer;
    private  int currentPosition=0;
    private  int [] imageFiles={R.drawable.mm,R.drawable.bike,R.drawable.car};
    public static String token="";//to check logged in or not
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawerLayout);
        toolbar=findViewById(R.id.toolbar);
        itemsRecyclerView=findViewById(R.id.itemsRecyclerView);
        itemsRecyclerViewTrend=findViewById(R.id.itemsRecyclerViewTrend);
        viewPager=findViewById(R.id.viewPager);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.start,R.string.end);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //Image slider

        ImageSliderAdapter imageSliderAdapter=new ImageSliderAdapter(imageFiles,this);
        viewPager.setAdapter(imageSliderAdapter);
        createSlide();

        //Recycler View

        Retrofit retrofit=URL.retrofit;
        ItemAPI itemAPI=URL.itemAPI;
        Call<List<Item>>listCall=itemAPI.getAllRecentItems();
        listCall.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                List<Item>items=response.body();

                ItemAdapter itemAdapter=new ItemAdapter(MainActivity.this,items);
                itemsRecyclerView.setAdapter(itemAdapter);
                itemsRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));

            }


            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "failed:"+t, Toast.LENGTH_SHORT).show();
            }
        });


        Call<List<Item>>call=itemAPI.getAllTrendingItems();
        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                List<Item>items=response.body();

                ItemAdapter itemAdapter=new ItemAdapter(MainActivity.this,items);
                itemsRecyclerViewTrend.setAdapter(itemAdapter);
                itemsRecyclerViewTrend.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "failed:"+t, Toast.LENGTH_SHORT).show();

            }
        });


    }
    //for slide show
    private void createSlide()
    {
        final Handler handler=new Handler();
        final Runnable runnable=new Runnable()
        {
            @Override
            public void run()
            {
                if(currentPosition==imageFiles.length)
                {
                    currentPosition=0;
                    viewPager.setCurrentItem(currentPosition++,true);
                }
            }
        };

        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        },25,25);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.user:
                if(token.equals(""))
                {
                    Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
                    startActivity(intent);
                }

        }
        return super.onOptionsItemSelected(item);
    }
}
