package com.example.doanandroid02.activity;
import com.example.doanandroid02.BasePresenter;
import com.example.doanandroid02.BaseView;
import com.example.doanandroid02.models.Bill;
import com.example.doanandroid02.models.BillDetail;
import com.example.doanandroid02.models.Category;
import com.example.doanandroid02.models.Customer;
import com.example.doanandroid02.models.Product;
import com.example.doanandroid02.models.Profile;

import com.example.doanandroid02.models.User;


import java.util.List;

public interface MainContract {

    interface View extends BaseView {
        void showProgressBar();
        void hideProgressBar();
        void updateListProduct(List<Product> products);
        void updateListCategories(List<Category> categories);
        void updateListProductId(List<Product> productList);
        void login(User userList);
        void details(Profile profileList);
        void logout(User userList);
        void register(Profile profileRegiser);
        void postCustomer(Customer customer);
        void postBill(Bill bill);
        void postBillDetail(BillDetail billDetail);

    }

    interface Presenter extends BasePresenter {
        void loadCategories();
        void loadProducts();
        void findProducts();
        void login();
        void details();
        void logout();
        void register();
        void postCustomer();
        void postBill();
        void postBillDetail();

    }
}
