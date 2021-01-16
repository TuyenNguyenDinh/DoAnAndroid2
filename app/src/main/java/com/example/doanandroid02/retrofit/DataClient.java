package com.example.doanandroid02.retrofit;


import com.example.doanandroid02.models.Category;
import com.example.doanandroid02.models.Product;
import com.example.doanandroid02.models.Profle;
import com.example.doanandroid02.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface DataClient {

    @GET("api/categories")
    Call<List<Category>> getCategory();

    @GET("api/products")
    Call<List<Product>> getProduct();

    @GET("api/categories/products/{id}")
    Call<List<Product>> getProductById(@Path("id") String id);


    @POST("api/auth/login")
    @FormUrlEncoded
    Call<User> checkLogin(@Field("email") String email,
                          @Field("password") String password);


    @POST("api/auth/me")
    @FormUrlEncoded
    Call<Profle> getMe(@Field("token") String token);

    @POST("api/auth/logout")
    @FormUrlEncoded
    Call<User> checkLogout(@Field("token") String token);

    @POST("api/auth/register")
    @FormUrlEncoded
    Call<Profle> register(@Field("name") String name,
                          @Field("email") String email,
                          @Field("password") String password,
                          @Field("c_password") String c_password
    );

}
