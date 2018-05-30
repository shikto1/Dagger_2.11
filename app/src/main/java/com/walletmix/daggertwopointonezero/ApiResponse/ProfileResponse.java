package com.walletmix.daggertwopointonezero.ApiResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ProfileResponse {

    @SerializedName("userId")
    @Expose
    Integer userId;

    @SerializedName("id")
    @Expose
    Integer id;

    @SerializedName("title")
    @Expose
    String title;
}
