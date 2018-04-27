package com.apps.azurehorsecreations.shop;

import android.app.Application;

import com.apps.azurehorsecreations.shop.di.component.DaggerNetComponent;
import com.apps.azurehorsecreations.shop.di.component.NetComponent;
import com.apps.azurehorsecreations.shop.di.module.AppModule;
import com.apps.azurehorsecreations.shop.di.module.NetModule;

/**
 * Created by pattycase on 4/24/18.
 */

public class MvpApp extends Application {
    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://jsonplaceholder.typicode.com/"))
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }

}
