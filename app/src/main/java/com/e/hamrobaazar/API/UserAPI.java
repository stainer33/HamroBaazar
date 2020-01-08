package com.e.hamrobaazar.API;

import com.e.hamrobaazar.Response.ImageResponse;
import com.e.hamrobaazar.models.User;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UserAPI {
    @FormUrlEncoded
    @POST("signup")
    Call<Void> signUp(@Field("email")String email,@Field("fullName")String fullName,@Field("password")String password,@Field("mobileNo")String mobileNo,@Field("address")String address,@Field("profileImg")String profileImg );

   /* @FormUrlEncoded
    @POST("users/login")
    Call<UserResponse>login(@Field("username")String username,@Field("password") String password);*/

    @Multipart
    @POST("upload")
    Call<ImageResponse>uploadImage(@Part MultipartBody.Part img);
}
