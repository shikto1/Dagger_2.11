package com.walletmix.daggertwopointonezero;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.walletmix.daggertwopointonezero.ApiResponse.ProfileResponse;
import com.walletmix.daggertwopointonezero.ApiService.UserProfileApiService;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    UserProfileApiService userProfileApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        setContentView(R.layout.activity_main);
        sharedPreferences.edit().putString("value", "10").apply();

        userProfileApiService.getUser().enqueue(new Callback<List<ProfileResponse>>() {
            @Override
            public void onResponse(Call<List<ProfileResponse>> call, Response<List<ProfileResponse>> response) {
                if (response.isSuccessful()) {
                    List<ProfileResponse> profileList = response.body();
                    ((TextView) findViewById(R.id.textTv)).setText("Size: " + profileList.size());
                }
            }

            @Override
            public void onFailure(Call<List<ProfileResponse>> call, Throwable t) {

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        String value = sharedPreferences.getString("value", "0");
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
        ((TextView) findViewById(R.id.textTv)).setText(value);
    }


    // For Adding Dagger 2 in Fragment....

    // 1. implements HasSupportFragmentInjector from Activity
    // 2.  @Inject
   // DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

//    @Override
//    public AndroidInjector<Fragment> supportFragmentInjector() {
//        return fragmentDispatchingAndroidInjector;
//    }

    // Add AndroidInjector.inject(this);

    // Note: Dont forget to add fragment in ActivityBuilder like

//    @ContributesAndroidInjector
//    abstract MyFragment bindMyFragment();

}
