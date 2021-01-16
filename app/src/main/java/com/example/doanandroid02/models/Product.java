package com.example.doanandroid02.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("category_id")
    @Expose
    private int category_id;
    @SerializedName("ten")
    @Expose
    private String ten;
    @SerializedName("anh")
    @Expose
    public String anh;
    @SerializedName("gia_sp")
    @Expose
    public double gia_sp;
    @SerializedName("so_luong")
    @Expose
    public int so_luong;
    @SerializedName("thong_tin_cu_the")
    @Expose
    public String thong_tin_cu_the;

    public Product(int id, int category_id, String ten, String anh, double gia_sp, int so_luong, String thong_tin_cu_the) {
        this.id = id;
        this.category_id = category_id;
        this.ten = ten;
        this.anh = anh;
        this.gia_sp = gia_sp;
        this.so_luong = so_luong;
        this.thong_tin_cu_the = thong_tin_cu_the;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public double getGia_sp() {
        return gia_sp;
    }

    public void setGia_sp(double gia_sp) {
        this.gia_sp = gia_sp;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public String getThong_tin_cu_the() {
        return thong_tin_cu_the;
    }

    public void setThong_tin_cu_the(String thong_tin_cu_the) {
        this.thong_tin_cu_the = thong_tin_cu_the;
    }

    @Override
    public String toString() {
        return "Product{" +
                "category_id=" + category_id +
                ", ten='" + ten + '\'' +
                ", anh='" + anh + '\'' +
                ", gia_sp=" + gia_sp +
                ", so_luong=" + so_luong +
                ", thong_tin_cu_the='" + thong_tin_cu_the + '\'' +
                '}';
    }
}
