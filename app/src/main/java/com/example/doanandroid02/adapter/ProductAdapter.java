package com.example.doanandroid02.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanandroid02.R;
import com.example.myapplicationbottmi.models.Product;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ItemHolder> {

    List<Product> products;
    Context context;

    public ProductAdapter(List<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    public class ItemHolder extends RecyclerView.ViewHolder {

        public ImageView imgSanPham;
        public TextView textTenSp;
        public TextView textGiaSp;
        public CardView cardView;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            imgSanPham = itemView.findViewById(R.id.imgSanPham);
            textTenSp = itemView.findViewById(R.id.textTenSp);
            textGiaSp = itemView.findViewById(R.id.textGiaSp);
            cardView = itemView.findViewById(R.id.cardView);
        }

    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_product, null);
        ItemHolder itemHolder = new ItemHolder(view);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Product product = products.get(position);
        holder.textTenSp.setText(product.getTen());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.textGiaSp.setText(decimalFormat.format(product.gia_sp) + "VND");
        Picasso.with(context).load("http://192.168.102.2/doan-laravel/public/upload/" + product.getAnh())
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background)
                .resize(1000, 1000)
                .centerCrop()
                .into(holder.imgSanPham);

    }


    @Override
    public int getItemCount() {
        return products.size();
    }


}
