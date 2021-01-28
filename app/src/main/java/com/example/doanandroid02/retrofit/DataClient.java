package com.example.doanandroid02.retrofit;


import com.example.doanandroid02.models.Bill;
import com.example.doanandroid02.models.BillDetail;
import com.example.doanandroid02.models.Category;
import com.example.doanandroid02.models.Customer;
import com.example.doanandroid02.models.Product;
import com.example.doanandroid02.models.Profile;

import com.example.doanandroid02.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DataClient {


    @GET("api/categories")
    Call<List<Category>> getCategory();

    @GET("api/products")
    Call<List<Product>> getProduct();

    @GET("api/products/{id}")
    Call<List<Product>> getProductId(@Path("id") String id);

    @GET("api/categories/products/{id}")
    Call<List<Product>> getProductById(@Path("id") String id);


    @POST("api/auth/login")
    @FormUrlEncoded
    Call<User> checkLogin(@Field("email") String email,
                          @Field("password") String password);


    @POST("api/auth/me")
    @FormUrlEncoded
    Call<Profile> getMe(@Field("token") String token);

    @POST("api/auth/logout")
    @FormUrlEncoded
    Call<User> checkLogout(@Field("token") String token);

    @POST("api/auth/register")
    @FormUrlEncoded
    Call<Profile> register(@Field("name") String name,
                          @Field("email") String email,
                          @Field("password") String password,
                          @Field("c_password") String c_password
    );

    @POST("api/customers/create")
    @FormUrlEncoded
    Call<Customer> postCustomer(@Field("name") String name,
                                @Field("sdt") String sdt,
                                @Field("dia_chi") String dia_chi,
                                @Field("mail") String mail);

    @GET("api/customers/{id}")
    Call<Customer> getCustomer(@Path("id") String id);

    @POST("api/orders/create")
    @FormUrlEncoded
    Call<Bill> postBill(@Field("customer_id") int customer_id,
                        @Field("ngaylap_hd") String ngaylap_hd,
                        @Field("noi_nhan_hang") String noi_nhan_hang,
                        @Field("tong_tien") Long tong_tien,
                        @Field("ghi_chu") String ghi_chu,
                        @Field("user_id") int user_id);

    @GET("api/bills/{id}")
    Call<Bill> getBill(@Path("id") String id);

    @POST("api/orderdetails/create")
    @FormUrlEncoded
    Call<BillDetail> postBillDetail(@Field("bill_id") int bill_id,
                                    @Field("product_id") int product_id,
                                    @Field("so_luong_mua") int so_luong_mua,
                                    @Field("don_gia") long don_gia);
    @GET("api/products/search")
    Call<List<Product>> searchProduct(@Query("q") String q);
}
