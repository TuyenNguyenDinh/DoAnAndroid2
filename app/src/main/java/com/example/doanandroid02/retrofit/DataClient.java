package com.example.doanandroid02.retrofit;


import com.example.myapplicationbottmi.models.Category;
import com.example.myapplicationbottmi.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DataClient {

    @GET("api/categories")
    Call<List<Category>> getCategory();

    @GET("api/products")
    Call<List<Product>> getProduct();

    @GET("api/categories/products/{id}")
    Call<List<Product>> getProductById(@Path("id") String id);

    

//    @GET("api/customers")
//    Call<List<Customer>> getCustomer();

//    @POST("login.php")
//    @FormUrlEncoded
//    Call<User> checkLogin(@Field("email") String email,
//                          @Field("password") String password);


//    @POST("register.php")
//    @FormUrlEncoded
//    Call<User> registerUser(@Field("name") String name,
//                            @Field("email") String email,
//                            @Field("password") String password
//    );

}
