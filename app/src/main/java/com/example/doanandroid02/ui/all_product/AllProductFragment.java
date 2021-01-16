package com.example.doanandroid02.ui.all_product;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanandroid02.R;
import com.example.doanandroid02.activity.MainContract;
import com.example.doanandroid02.activity.MainPresenter;
import com.example.doanandroid02.adapter.ProductAdapter;
import com.example.doanandroid02.models.Category;
import com.example.doanandroid02.models.Product;
import com.example.doanandroid02.models.Profle;
import com.example.doanandroid02.models.User;

import java.util.List;

public class AllProductFragment extends Fragment implements MainContract.View {

    RecyclerView recyclerView;
    ProductAdapter productAdapter;
    MainContract.Presenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        getActivity().getMenuInflater().inflate(R.menu.menu, menu);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_product, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        mPresenter = new MainPresenter(this);
        mPresenter.loadProducts();
        return view;
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void updateListProduct(List<Product> products) {
        productAdapter = new ProductAdapter(products, getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setAdapter(productAdapter);
    }

    @Override
    public void updateListCategories(List<Category> categories) {

    }

    @Override
    public void updateListProductById(List<Product> productList) {

    }

    @Override
    public void login(User userList) {

    }

    @Override
    public void details(Profle profleList) {

    }

    @Override
    public void logout(User userList) {

    }

    @Override
    public void register(Profle profleRegiser) {

    }

}