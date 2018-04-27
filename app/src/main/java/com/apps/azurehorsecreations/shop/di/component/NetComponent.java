package com.apps.azurehorsecreations.shop.di.component;

import com.apps.azurehorsecreations.shop.di.module.AppModule;
import com.apps.azurehorsecreations.shop.di.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by pattycase on 4/24/18.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    // downstream components need these exposed with the return type
    // method name does not really matter
    Retrofit retrofit();
}
