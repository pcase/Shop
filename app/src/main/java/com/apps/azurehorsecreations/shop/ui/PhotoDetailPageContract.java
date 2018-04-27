package com.apps.azurehorsecreations.shop.ui;

import com.apps.azurehorsecreations.shop.data.Photo;

/**
 * Created by pattycase on 4/25/18.
 */

public interface PhotoDetailPageContract {
    interface View {
        void showPostDetail(Photo photo);

        void showError(String message);

        void showComplete();
    }

    interface Presenter {
        void loadPhoto();
    }
}
