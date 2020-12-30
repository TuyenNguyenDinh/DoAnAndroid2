package com.example.doanandroid02.activity;


import com.example.doanandroid02.repositories.CategoryRepository;
import com.example.doanandroid02.repositories.ProductRepository;

public class MainPresenter implements MainContract.Presenter {
    MainContract.View view;
    CategoryRepository categoryRepository;
    ProductRepository productRepository;


    public MainPresenter(MainContract.View view){
        this.view = view;
        categoryRepository = new CategoryRepository();
        productRepository = new ProductRepository();
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

}
