package com.example.doanandroid02.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.doanandroid02.R;
import com.example.doanandroid02.adapter.NewProductAdapter;
import com.example.doanandroid02.adapter.ProductAdapter;
import com.example.doanandroid02.adapter.ProductByIdAdapter;
import com.example.doanandroid02.adapter.SearchAdapter;
import com.example.doanandroid02.models.Bill;
import com.example.doanandroid02.models.BillDetail;
import com.example.doanandroid02.models.Category;
import com.example.doanandroid02.models.Customer;
import com.example.doanandroid02.models.Product;
import com.example.doanandroid02.models.Profile;
import com.example.doanandroid02.models.User;
import com.example.doanandroid02.repositories.ProductById;

import java.util.List;

public class SearchResult extends AppCompatActivity implements MainContract.View{
    RecyclerView recyclerView;
    SearchAdapter productAdapter;
    MainContract.Presenter mPresenter;
    public static String titleSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        mPresenter = new MainPresenter(this);
        recyclerView = findViewById(R.id.rvSearch);
        getSearchKey();
        mPresenter.searchProduct();

    }

    public void getSearchKey(){
        Intent intent = getIntent();
        titleSearch = intent.getStringExtra("searchKey");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(titleSearch);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
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
    public void updateListProductId(List<Product> productList) {

    }

    @Override
    public void login(User userList) {

    }

    @Override
    public void details(Profile profileList) {

    }

    @Override
    public void logout(User userList) {

    }

    @Override
    public void register(Profile profileRegiser) {

    }

    @Override
    public void postCustomer(Customer customer) {

    }

    @Override
    public void postBill(Bill bill) {

    }

    @Override
    public void postBillDetail(BillDetail billDetail) {

    }

    @Override
    public void searchProduct(List<Product> products) {
        productAdapter = new SearchAdapter(products, getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        recyclerView.setAdapter(productAdapter);
    }
}