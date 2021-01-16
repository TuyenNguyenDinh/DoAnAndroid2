package com.example.doanandroid02.repositories;


import com.example.doanandroid02.retrofit.APIService;
import com.example.doanandroid02.retrofit.DataClient;
import com.example.doanandroid02.retrofit.RetrofitClientInstance;
import com.example.doanandroid02.models.Product;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProductRepository {
    DataClient api = APIService.getService();
    public static List<Product> products;

    public void loadAll(DataCallBack<Product> dataCallBack) {
        api.getProduct().enqueue(new Callback<List<Product>>() {

            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                products = response.body();
                String item[] = new String[products.size()];
                for (int i = 0; i < products.size(); i++) {
                    item[i] = products.get(i).getAnh();
                    item[i] = products.get(i).getTen();
                    item[i] = String.valueOf(products.get(i).getGia_sp());
                }
                dataCallBack.response(products);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });
    }


    void find(int id) {

    }
}
