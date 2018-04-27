package com.apps.azurehorsecreations.shop.ui.navigation;

import android.content.Context;
import android.content.Intent;

import com.apps.azurehorsecreations.shop.data.Post;

/**
 * Created by pattycase on 4/25/18.
 */

public class PostNavigator {
    private final Context mActivityContext;
    private final Class<?> mClassToNavigateTo;
    private Post mPost;

    public PostNavigator(Context activityContext, Class<?> cls, Post post) {
        this.mActivityContext = activityContext;
        this.mClassToNavigateTo = cls;
        this.mPost = post;
    }

    public void launchActivity() {
        Intent intent = new Intent(mActivityContext, mClassToNavigateTo);
        intent.putExtra("POST", mPost);
        mActivityContext.startActivity(intent);
    }
}
