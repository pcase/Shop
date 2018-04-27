package com.apps.azurehorsecreations.shop.ui;

import com.apps.azurehorsecreations.shop.data.Post;
import com.apps.azurehorsecreations.shop.ui.navigation.PostNavigator;

import java.util.List;
import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.Retrofit;
import retrofit2.http.GET;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by pattycase on 4/24/18.
 */

public class PostMainScreenPresenter implements PostMainScreenContract.Presenter {

    Retrofit retrofit;
    PostMainScreenContract.View mView;
    PostNavigator mNavigator;

    @Inject
    public PostMainScreenPresenter(Retrofit retrofit, PostMainScreenContract.View mView) {
        this.retrofit = retrofit;
        this.mView = mView;
    }

    @Override
    public void loadPosts() {
        retrofit.create(PostService.class).getPostList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Post>>() {
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
                    public void onNext(List<Post> posts) {
                        mView.showPosts(posts);
                    }
                });
    }

    public void setNavigator(PostNavigator navigator) {
        this.mNavigator = navigator;
    }

    public void navigateToNewScreen() {
        this.mNavigator.launchActivity();
    }

    public interface PostService {
        @GET("/posts")
        Observable<List<Post>> getPostList();
    }
}
