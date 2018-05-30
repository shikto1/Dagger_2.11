package com.walletmix.daggertwopointonezero.DI;

import android.content.Context;

import com.walletmix.daggertwopointonezero.MyApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    @Provides
    Context provideContext(MyApplication application) {
        return application.getApplicationContext();
    }
}
