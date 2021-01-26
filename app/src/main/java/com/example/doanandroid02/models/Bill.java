package com.example.doanandroid02.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bill { @SerializedName("id")
@Expose
public int id;
    @SerializedName("customer_id")
    @Expose
    public int customer_id;
    @SerializedName("ngaylap_hd")
    @Expose
    public String ngaylap_hd;
    @SerializedName("noi_nhan_hang")
    @Expose
    public String noi_nhan_hang;
    @SerializedName("tong_tien")
    @Expose
    public Long tong_tien;
    @SerializedName("ghi_chu")
    @Expose
    public String ghi_chu;
    @SerializedName("user_id")
    @Expose
    public int user_id;

    public Bill(int id, int customer_id, String ngaylap_hd, String noi_nhan_hang, Long tong_tien, String ghi_chu, int user_id) {
        this.id = id;
        this.customer_id = customer_id;
        this.ngaylap_hd = ngaylap_hd;
        this.noi_nhan_hang = noi_nhan_hang;
        this.tong_tien = tong_tien;
        this.ghi_chu = ghi_chu;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getNgaylap_hd() {
        return ngaylap_hd;
    }

    public void setNgaylap_hd(String ngaylap_hd) {
        this.ngaylap_hd = ngaylap_hd;
    }

    public String getNoi_nhan_hang() {
        return noi_nhan_hang;
    }

    public void setNoi_nhan_hang(String noi_nhan_hang) {
        this.noi_nhan_hang = noi_nhan_hang;
    }

    public Long getTong_tien() {
        return tong_tien;
    }

    public void setTong_tien(Long tong_tien) {
        this.tong_tien = tong_tien;
    }

    public String getGhi_chu() {
        return ghi_chu;
    }

    public void setGhi_chu(String ghi_chu) {
        this.ghi_chu = ghi_chu;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", ngaylap_hd='" + ngaylap_hd + '\'' +
                ", noi_nhan_hang='" + noi_nhan_hang + '\'' +
                ", tong_tien=" + tong_tien +
                ", ghi_chu='" + ghi_chu + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}