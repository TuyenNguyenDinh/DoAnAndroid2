package com.example.doanandroid02.repositories;

import android.util.Log;

import com.example.doanandroid02.activity.LoginActivity;
import com.example.doanandroid02.activity.RegisterActivity;
import com.example.doanandroid02.models.Profle;
import com.example.doanandroid02.models.User;
import com.example.doanandroid02.retrofit.APIService;
import com.example.doanandroid02.retrofit.DataClient;
import com.example.doanandroid02.ui.user.UserFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import static com.example.doanandroid02.activity.LoginActivity.sharedPreferences;
import static com.example.doanandroid02.activity.LoginActivity.editEmail;
import static com.example.doanandroid02.activity.LoginActivity.editPassword;
import static com.example.doanandroid02.activity.RegisterActivity.editTextName;
import static com.example.doanandroid02.activity.RegisterActivity.editTextEmail;
import static com.example.doanandroid02.activity.RegisterActivity.editTextPass;
import static com.example.doanandroid02.activity.RegisterActivity.editTextConfPass;


public class UserRepository {
    DataClient api = APIService.getService();

    public void login(DataUserCallBack<User> dataUserCallBack) {
        api.checkLogin(LoginActivity.username = editEmail.getText().toString(),
                LoginActivity.password = editPassword.getText().toString())
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful()) {
                            User user = response.body();
                            Log.d("TAG", "onResponse: " + user);
                            dataUserCallBack.user(user);
                            return;
                        } else {
                            Log.d("TAG", "fail: ");
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.d("TAG", "onFailure: ");
                    }
                });
    }

    public void details(DataUserCallBack<Profle> profleDataUserCallBack) {
        String token = sharedPreferences.getString("token", "");
        api.getMe(token).enqueue(new Callback<Profle>() {
            @Override
            public void onResponse(Call<Profle> call, Response<Profle> response) {
                if (response.isSuccessful()) {
                    Profle profle = response.body();
                    String name = response.body().name;
                    Log.d("TAG", "onResponse: " + name);
                    profleDataUserCallBack.user(profle);
                    return;
                } else {

                }

            }

            @Override
            public void onFailure(Call<Profle> call, Throwable t) {

            }
        });
    }

    public void logout(DataUserCallBack<User> userDataCallBack) {
        String token = UserFragment.sharedPreferences.getString("token", "");
        api.checkLogout(token).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                userDataCallBack.user(user);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("TAG", "onFailure: ");
            }
        });
    }

    public void register(DataUserCallBack<Profle> registerDataCallBack){
        api.register(RegisterActivity.name = editTextName.getText().toString(),
                RegisterActivity.email = editTextEmail.getText().toString(),
                RegisterActivity.password = editTextPass.getText().toString(),
                RegisterActivity.c_password = editTextConfPass.getText().toString())
                .enqueue(new Callback<Profle>() {
                    @Override
                    public void onResponse(Call<Profle> call, Response<Profle> response) {
                        if (response.isSuccessful()){
                            Profle user = response.body();
                            registerDataCallBack.user(user);
                        }else {
                            Log.d("TAG", "fail: " );
                        }
                    }

                    @Override
                    public void onFailure(Call<Profle> call, Throwable t) {
                        Log.d("TAG", "onFailure: ");
                    }
                });
    }
}
