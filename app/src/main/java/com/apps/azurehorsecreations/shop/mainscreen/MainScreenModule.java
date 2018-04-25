package com.apps.azurehorsecreations.shop.mainscreen;

import com.apps.azurehorsecreations.shop.util.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pattycase on 4/24/18.
 */

@Module
public class MainScreenModule {
    private final MainScreenContract.View mView;


    public MainScreenModule(MainScreenContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @CustomScope
    MainScreenContract.View providesMainScreenContractView() {
        return mView;
    }
}
