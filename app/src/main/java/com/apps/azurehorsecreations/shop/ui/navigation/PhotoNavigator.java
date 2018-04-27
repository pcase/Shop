package com.apps.azurehorsecreations.shop.ui.navigation;

import android.content.Context;
import android.content.Intent;
import com.apps.azurehorsecreations.shop.data.Photo;

/**
 * Created by pattycase on 4/25/18.
 */

public class PhotoNavigator {
    private final Context mActivityContext;
    private final Class<?> mClassToNavigateTo;
    private Photo mPhoto;

    public PhotoNavigator(Context activityContext, Class<?> cls, Photo photo) {
        this.mActivityContext = activityContext;
        this.mClassToNavigateTo = cls;
        this.mPhoto = photo;
    }

    public void launchActivity() {
        Intent intent = new Intent(mActivityContext, mClassToNavigateTo);
        intent.putExtra("PHOTO", mPhoto);
        mActivityContext.startActivity(intent);
    }
}
