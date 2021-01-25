package com.example.doanandroid02.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BillDetail {@SerializedName("id")
@Expose
public int id;
    @SerializedName("bill_id")
    @Expose
    public int bill_id;
    @SerializedName("product_id")
    @Expose
    public int product_id;
    @SerializedName("so_luong_mua")
    @Expose
    public int so_luong_mua;
    @SerializedName("don_gia")
    @Expose
    public Double don_gia;

    public BillDetail(int id, int bill_id, int product_id, int so_luong_mua, Double don_gia) {
        this.id = id;
        this.bill_id = bill_id;
        this.product_id = product_id;
        this.so_luong_mua = so_luong_mua;
        this.don_gia = don_gia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getSo_luong_mua() {
        return so_luong_mua;
    }

    public void setSo_luong_mua(int so_luong_mua) {
        this.so_luong_mua = so_luong_mua;
    }

    public Double getDon_gia() {
        return don_gia;
    }

    public void setDon_gia(Double don_gia) {
        this.don_gia = don_gia;
    }
}
