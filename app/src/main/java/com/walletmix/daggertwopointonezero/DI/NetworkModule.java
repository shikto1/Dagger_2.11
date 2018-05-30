package com.walletmix.daggertwopointonezero.DI;

import com.walletmix.daggertwopointonezero.All_APIs;
import com.walletmix.daggertwopointonezero.ApiService.UserProfileApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class NetworkModule {

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(All_APIs.BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    UserProfileApiService provideUserProfileAPIService(Retrofit retrofit){
        return retrofit.create(UserProfileApiService.class);
    }
}
