package com.walletmix.daggertwopointonezero.ApiService;

import com.walletmix.daggertwopointonezero.All_APIs;
import com.walletmix.daggertwopointonezero.ApiResponse.ProfileResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface UserProfileApiService {
    @GET(All_APIs.JSON_PLACEHOLDER_URL)
    Call<List<ProfileResponse>> getUser();
}
