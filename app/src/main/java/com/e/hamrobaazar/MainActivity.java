package com.e.hamrobaazar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;

import com.e.hamrobaazar.Adapter.ImageSliderAdapter;
import com.e.hamrobaazar.Adapter.ItemAdapter;
import com.e.hamrobaazar.models.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private RecyclerView itemsRecyclerView;

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private Timer timer;
    private  int currentPosition=0;
    private  int [] imageFiles={R.drawable.mm,R.drawable.bike,R.drawable.car};
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

        List<Item>items=new ArrayList<>();
        items.add(new Item("pulsar",R.drawable.cat,1000,"Used"));
        items.add(new Item("Bajaj",R.drawable.cat,1000,"Used"));
        items.add(new Item("Crossfire",R.drawable.dd,14000,"New"));
        items.add(new Item("Shine",R.drawable.dog,14000,"New"));

        ItemAdapter itemAdapter=new ItemAdapter(this,items);
        itemsRecyclerView.setAdapter(itemAdapter);
        itemsRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

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
}
