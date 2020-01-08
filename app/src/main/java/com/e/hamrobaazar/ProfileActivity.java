package com.e.hamrobaazar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.e.hamrobaazar.API.UserAPI;
import com.e.hamrobaazar.Response.UserResponse;
import com.e.hamrobaazar.models.User;
import com.e.hamrobaazar.url.URL;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Url;

public class ProfileActivity extends AppCompatActivity {
CircleImageView profile;
TextView txtName, txtAddress, txtPhone, txtEmail;
public  static String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profile=findViewById(R.id.test);
        txtName=findViewById(R.id.txtName);
        txtAddress=findViewById(R.id.txtAddress);
        txtPhone=findViewById(R.id.txtPhone);
        txtEmail=findViewById(R.id.txtEmail);




       //test.setImageResource(R.drawable.cat);
        Retrofit retrofit= URL.retrofit;
        UserAPI userAPI=URL.userAPI;
        Call<User> call=userAPI.getProfile(email);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                txtName.setText("Name : "+response.body().getFullName());
                txtAddress.setText("Address : "+response.body().getAddress());
                txtPhone.setText("Mobile no : "+response.body().getMobileNo());
                txtEmail.setText("Email : "+response.body().getEmail());
                String img =response.body().getProfileImg();

                Picasso.with(ProfileActivity.this)
                        .load("http://10.0.2.2:3003/image/"+img)

                        .into(profile);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

    }
}
