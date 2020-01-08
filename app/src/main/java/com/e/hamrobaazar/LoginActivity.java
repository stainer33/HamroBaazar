package com.e.hamrobaazar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.e.hamrobaazar.API.UserAPI;
import com.e.hamrobaazar.Response.UserResponse;
import com.e.hamrobaazar.url.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {
    EditText etEmail, etPassword;
    Button btnLogin, btnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail=findViewById(R.id.editText);
        etPassword=findViewById(R.id.editText2);
        btnLogin=findViewById(R.id.btnLogin);


       btnLogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               final String email =etEmail.getText().toString();
               String password =etPassword.getText().toString();
               Retrofit retrofit= URL.retrofit;
               UserAPI userAPI=URL.userAPI;
               Call<UserResponse> call=userAPI.login(email,password);
               call.enqueue(new Callback<UserResponse>() {
                   @Override
                   public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {


                       if(response.body().getStatus().equals("201")){

                           MainActivity.token=response.body().getToken();
                           ProfileActivity.email=email;
                           Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                       Intent intent=new Intent(LoginActivity.this, MainActivity.class);
                       startActivity(intent);finish();}
                       else
                       {
                           Toast.makeText(LoginActivity.this, "Login Unsuccessful", Toast.LENGTH_SHORT).show();
                       }
                   }

                   @Override
                   public void onFailure(Call<UserResponse> call, Throwable t) {
                       Toast.makeText(LoginActivity.this, "Error: " +t, Toast.LENGTH_SHORT).show();
                   }
               });
           }
       });
    }
}
