package com.walletmix.daggertwopointonezero.DI;

import com.walletmix.daggertwopointonezero.MyApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        NetworkModule.class,
        DatabaseModule.class,
        ActivityBuilder.class}
)
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(MyApplication application);

        AppComponent build();
    }

    void inject(MyApplication app);
}