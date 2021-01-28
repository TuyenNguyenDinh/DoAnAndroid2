package com.example.doanandroid02.repositories;

import android.util.Log;

import com.example.doanandroid02.activity.MainActivity;
import com.example.doanandroid02.activity.PayActivity;
import com.example.doanandroid02.models.Bill;
import com.example.doanandroid02.models.BillDetail;
import com.example.doanandroid02.models.Customer;
import com.example.doanandroid02.retrofit.APIService;
import com.example.doanandroid02.retrofit.DataClient;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CartRepository extends PayActivity {
    DataClient api;
    public CartRepository(){
        api = APIService.getService();
    }

    public void postCustomer(DataUserCallBack<Customer> dataCallBack){
        api.postCustomer(fullname,phonenumber,address,email)
                .enqueue(new Callback<Customer>() {
                    @Override
                    public void onResponse(Call<Customer> call, Response<Customer> response) {
                        Customer customer = response.body();
                        dataCallBack.user(customer);
                    }

                    @Override
                    public void onFailure(Call<Customer> call, Throwable t) {
                        Log.d("TAG", "FailurePostCus: ");
                    }
                });
    }


    public void postBill(DataUserCallBack<Bill> dataUserCallBack){
        int id = sharedPreferences.getInt("id_customer",0);
        int user_id = sharedPreferences.getInt("user_id",0);
        String address = sharedPreferences.getString("address","");
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        Long total = sharedPreferences.getLong("total",0);
        api.postBill(id,date,address,total,notes = editMessages.getText().toString(),user_id)
                .enqueue(new Callback<Bill>() {
                    @Override
                    public void onResponse(Call<Bill> call, Response<Bill> response) {
                        Bill bill = response.body();
                        dataUserCallBack.user(bill);
                        Log.d("TAG", "onResponse: " + bill);
                    }

                    @Override
                    public void onFailure(Call<Bill> call, Throwable t) {
                        Log.d("TAG", "onFailureBill: ");
                    }
                });
    }

    public void getBill(DataUserCallBack<Bill> dataUserCallBack){

    }

    public void postBillDetail(DataUserCallBack<BillDetail> dataUserCallBack){
        int bill_id = sharedPreferences.getInt("id_bill",0);
        int id_product;
        int sl;
        long dongia;
        for (int i=0; i < MainActivity.cartArrayList.size(); i++){
            id_product = MainActivity.cartArrayList.get(i).idsp;
            sl = MainActivity.cartArrayList.get(i).soluongsp;
            dongia = MainActivity.cartArrayList.get(i).giasp;

            Log.d("TAG", "postBillDetailId: " + id_product);

            api.postBillDetail(bill_id,id_product,sl,dongia)
                    .enqueue(new Callback<BillDetail>() {
                        @Override
                        public void onResponse(Call<BillDetail> call, Response<BillDetail> response) {
                            BillDetail billDetail = response.body();
                            dataUserCallBack.user(billDetail);
                        }

                        @Override
                        public void onFailure(Call<BillDetail> call, Throwable t) {
                            Log.d("TAG", "onFailureDetail: ");
                        }
                    });
        }

    }
}