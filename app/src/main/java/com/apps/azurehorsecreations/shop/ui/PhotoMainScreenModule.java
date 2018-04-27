package com.apps.azurehorsecreations.shop.ui;

import com.apps.azurehorsecreations.shop.di.scope.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pattycase on 4/24/18.
 */

@Module
public class PhotoMainScreenModule {
    private final PhotoMainScreenContract.View mView;


    public PhotoMainScreenModule(PhotoMainScreenContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @CustomScope
    PhotoMainScreenContract.View providesPhotoMainScreenContractView() {
        return mView;
    }
}
