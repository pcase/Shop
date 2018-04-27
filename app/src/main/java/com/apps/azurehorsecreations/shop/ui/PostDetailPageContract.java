package com.apps.azurehorsecreations.shop.ui;

import com.apps.azurehorsecreations.shop.data.Post;

import java.util.List;

/**
 * Created by pattycase on 4/25/18.
 */

public interface PostDetailPageContract {
    interface View {
        void showPostDetail(Post posts);

        void showError(String message);

        void showComplete();
    }

    interface Presenter {
        void loadPost();
    }
}
