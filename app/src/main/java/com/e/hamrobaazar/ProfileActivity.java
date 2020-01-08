package com.e.hamrobaazar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity {
ImageView test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        test=findViewById(R.id.test);
        String img ="imageFile-1578378456828.jpeg";
        Picasso.with(this)
                .load("http://10.0.2.2:3003/image/"+img)

                .into(test);
       //test.setImageResource(R.drawable.cat);
    }
}
