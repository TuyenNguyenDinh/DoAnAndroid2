package com.example.doanandroid02.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanandroid02.R;
import com.example.doanandroid02.activity.MainContract;
import com.example.doanandroid02.activity.MainPresenter;
import com.example.doanandroid02.adapter.NewProductAdapter;
import com.example.doanandroid02.models.Category;
import com.example.doanandroid02.models.Product;
import com.example.doanandroid02.models.Profle;
import com.example.doanandroid02.models.User;

import java.util.List;

public class HomeFragment extends Fragment implements MainContract.View {

    RecyclerView recyclerView;
    NewProductAdapter newProductAdapter;
    MainContract.Presenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }



    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        getActivity().getMenuInflater().inflate(R.menu.menu_main, menu);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recyclerviewHome);
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
        newProductAdapter = new NewProductAdapter(products, getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(newProductAdapter);
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