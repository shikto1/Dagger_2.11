package com.walletmix.daggertwopointonezero.DI;

import com.walletmix.daggertwopointonezero.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
abstract public class ActivityBuilder {

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();
}
