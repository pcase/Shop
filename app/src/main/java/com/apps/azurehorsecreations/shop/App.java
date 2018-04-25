package com.apps.azurehorsecreations.shop;

import android.app.Application;

import com.apps.azurehorsecreations.shop.data.component.DaggerNetComponent;
import com.apps.azurehorsecreations.shop.data.component.NetComponent;
import com.apps.azurehorsecreations.shop.data.module.AppModule;
import com.apps.azurehorsecreations.shop.data.module.NetModule;

/**
 * Created by pattycase on 4/24/18.
 */

public class App extends Application {
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
