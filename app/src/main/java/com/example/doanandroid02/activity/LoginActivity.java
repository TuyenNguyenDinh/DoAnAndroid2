package com.example.doanandroid02.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.doanandroid02.R;
import com.example.doanandroid02.models.Category;
import com.example.doanandroid02.models.Product;
import com.example.doanandroid02.models.Profle;
import com.example.doanandroid02.models.User;

import java.util.List;

public class LoginActivity extends AppCompatActivity implements MainContract.View {

    public static EditText editEmail, editPassword;
    TextView textSignup;
    Button btLogin;
    MainContract.Presenter mPresenter;
    public static String username;
    public static String password;
    public static SharedPreferences sharedPreferences;
    ImageView imageViewBackLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = findViewById(R.id.editEmailLogin);
        editPassword = findViewById(R.id.editPasswordLogin);
        textSignup = findViewById(R.id.tv_sign_up);
        btLogin = findViewById(R.id.btLogin);
        imageViewBackLogin = findViewById(R.id.imageViewBackLogin);
        mPresenter = new MainPresenter(this);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editEmail.getText().toString().length() == 0 || editPassword.getText().toString().length() == 0) {
                    editEmail.setError("Email is required!");
                    editPassword.setError("Password is required");
                } else {
                    mPresenter.login();
                }
            }
        });

        textSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        imageViewBackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void updateListProduct(List<Product> products) {

    }

    @Override
    public void updateListCategories(List<Category> categories) {

    }

    @Override
    public void updateListProductById(List<Product> productList) {

    }

    @Override
    public void login(User userList) {
        rememberUser(editEmail.getText().toString(), editPassword.getText().toString(), btLogin.isClickable(), userList.access_token);
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        mPresenter.details();
    }

    @Override
    public void details(Profle profleList) {
        String name = profleList.getName();
        rememberName(name);
    }

    @Override
    public void logout(User userList) {

    }

    @Override
    public void register(Profle profleRegiser) {

    }

    public void rememberName(String username) {
        sharedPreferences = getSharedPreferences("USER_FILE.txt", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.commit();
    }


    public void rememberUser(String email, String password, boolean status, String token) {
        sharedPreferences = getSharedPreferences("USER_FILE.txt", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email", email);
        editor.putString("password", password);
        editor.putBoolean("status", status == true);
        editor.putString("token", token);
        editor.commit();
    }
}