package com.e.hamrobaazar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.e.hamrobaazar.API.UserAPI;
import com.e.hamrobaazar.models.User;
import com.e.hamrobaazar.url.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RegisterActivity extends AppCompatActivity {
    EditText etFullName, etEmail, etPassword, etMobileNo, etAddress;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etFullName =findViewById(R.id.etName);
        etEmail=findViewById(R.id.etEmail);
        etAddress=findViewById(R.id.etAddress);
        etPassword=findViewById(R.id.etPassword);
        etMobileNo=findViewById(R.id.etMobileNo);
        btnSignUp=findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName= etFullName.getText().toString();
                String email=etEmail.getText().toString();
                String address=etAddress.getText().toString();
                String password=etPassword.getText().toString();
                String mobileNo=etMobileNo.getText().toString();



               Retrofit retrofit= URL.retrofit;
                UserAPI userAPI=URL.userAPI;
                Call<Void>voidCall=userAPI.signUp(email,fullName,password,mobileNo,address);

                voidCall.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast.makeText(RegisterActivity.this, "Register Successful", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this, "Registered Failed"+ t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
