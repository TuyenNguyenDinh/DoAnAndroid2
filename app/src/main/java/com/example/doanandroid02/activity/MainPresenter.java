package com.example.doanandroid02.activity;


import com.example.doanandroid02.repositories.CategoryRepository;
import com.example.doanandroid02.repositories.ProductById;
import com.example.doanandroid02.repositories.ProductRepository;
import com.example.doanandroid02.repositories.UserRepository;

public class MainPresenter implements MainContract.Presenter {
    MainContract.View view;
    CategoryRepository categoryRepository;
    ProductRepository productRepository;
    ProductById productById;
    UserRepository userRepository;


    public MainPresenter(MainContract.View view) {
        this.view = view;
        categoryRepository = new CategoryRepository();
        productRepository = new ProductRepository();
        productById = new ProductById();
        userRepository = new UserRepository();
    }

    @Override
    public void loadCategories() {
        categoryRepository.loadAll(data -> view.updateListCategories(data));
    }

    @Override
    public void loadProducts() {
        productRepository.loadAll(data -> {
            view.updateListProduct(data);
        });
    }

    @Override
    public void findProducts() {
        productById.loadAll(data -> view.updateListProductById(data));
    }

    @Override
    public void login() {
        userRepository.login(dataUser -> view.login(dataUser));
    }

    @Override
    public void details() {
        userRepository.details(dataUser -> view.details(dataUser));
    }

    @Override
    public void logout() {
        userRepository.logout(dataUser -> view.logout(dataUser));
    }

    @Override
    public void register() {

    }

}
