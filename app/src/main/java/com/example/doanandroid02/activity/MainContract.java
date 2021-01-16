package com.example.doanandroid02.activity;
import com.example.doanandroid02.BasePresenter;
import com.example.doanandroid02.BaseView;
import com.example.doanandroid02.models.Category;
import com.example.doanandroid02.models.Product;
import com.example.doanandroid02.models.Profle;
import com.example.doanandroid02.models.User;


import java.util.List;

public interface MainContract {

    interface View extends BaseView {
        void showProgressBar();
        void hideProgressBar();
        void updateListProduct(List<Product> products);
        void updateListCategories(List<Category> categories);
        void updateListProductById(List<Product> productList);
        void login(User userList);
        void details(Profle profleList);
        void logout(User userList);
        void register(Profle profleRegiser);
    }

    interface Presenter extends BasePresenter {
        void loadCategories();
        void loadProducts();
        void findProducts();
        void login();
        void details();
        void logout();
        void register();
    }
}
