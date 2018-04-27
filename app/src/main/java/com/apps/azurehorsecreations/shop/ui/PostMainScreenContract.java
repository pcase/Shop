package com.apps.azurehorsecreations.shop.ui;

import com.apps.azurehorsecreations.shop.data.Post;

import java.util.List;

/**
 * Created by pattycase on 4/24/18.
 */

public interface PostMainScreenContract {
    interface View {
        void showPosts(List<Post> posts);

        void showError(String message);

        void showComplete();
    }

    interface Presenter {
        void loadPosts();
    }
}
