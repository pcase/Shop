package com.apps.azurehorsecreations.shop.ui;

import com.apps.azurehorsecreations.shop.data.Photo;
import com.apps.azurehorsecreations.shop.ui.navigation.PhotoNavigator;
import java.util.List;
import javax.inject.Inject;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.http.GET;

/**
 * Created by pattycase on 4/24/18.
 */

public class PhotoMainScreenPresenter implements PhotoMainScreenContract.Presenter {

    Retrofit retrofit;
    PhotoMainScreenContract.View mView;
    PhotoNavigator mNavigator;

    @Inject
    public PhotoMainScreenPresenter(Retrofit retrofit, PhotoMainScreenContract.View mView) {
        this.retrofit = retrofit;
        this.mView = mView;
    }

    @Override
    public void loadPhotos() {
        retrofit.create(PhotoService.class).getPhotoList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Photo>>() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onComplete() {
                        mView.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Photo> photos) {
                        mView.showPhotos(photos);
                    }
                });
    }

    public void setNavigator(PhotoNavigator navigator) {
        this.mNavigator = navigator;
    }

    public void navigateToNewScreen() {
        this.mNavigator.launchActivity();
    }

    public interface PhotoService {
        @GET("/photos")
        Observable<List<Photo>> getPhotoList();
    }
}
