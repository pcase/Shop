package com.apps.azurehorsecreations.shop.ui;

import com.apps.azurehorsecreations.shop.data.Photo;
import java.util.List;

/**
 * Created by pattycase on 4/24/18.
 */

public interface PhotoMainScreenContract {
    interface View {
        void showPhotos(List<Photo> photos);

        void showError(String message);

        void showComplete();
    }

    interface Presenter {
        void loadPhotos();
    }
}
