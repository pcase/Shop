package com.apps.azurehorsecreations.shop.ui;

import com.apps.azurehorsecreations.shop.di.scope.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pattycase on 4/24/18.
 */

@Module
public class PostMainScreenModule {
    private final PostMainScreenContract.View mView;


    public PostMainScreenModule(PostMainScreenContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @CustomScope
    PostMainScreenContract.View providesPostMainScreenContractView() {
        return mView;
    }
}
