package com.e.hamrobaazar.API;

import com.e.hamrobaazar.Response.ImageResponse;
import com.e.hamrobaazar.Response.UserResponse;
import com.e.hamrobaazar.models.User;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface UserAPI {
    @FormUrlEncoded
    @POST("signup")
    Call<Void> signUp(@Field("email")String email,@Field("fullName")String fullName,@Field("password")String password,@Field("mobileNo")String mobileNo,@Field("address")String address,@Field("profileImg")String profileImg );

   @FormUrlEncoded
    @POST("login")
    Call<UserResponse>login(@Field("email")String email, @Field("password") String password);

    @Multipart
    @POST("upload")
    Call<ImageResponse>uploadImage(@Part MultipartBody.Part img);



    @GET("profile/{email}")
    Call<User>getProfile(@Path("email")String email);
}
