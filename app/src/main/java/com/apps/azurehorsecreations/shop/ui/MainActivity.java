package com.apps.azurehorsecreations.shop.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.apps.azurehorsecreations.shop.MvpApp;
import com.apps.azurehorsecreations.shop.R;
import com.apps.azurehorsecreations.shop.data.Photo;
import com.apps.azurehorsecreations.shop.ui.adapters.PhotoAdapter;
import com.apps.azurehorsecreations.shop.ui.navigation.PhotoNavigator;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements PhotoMainScreenContract.View, PhotoAdapter.OnItemClickListener {
    private static final int NUMBER_OF_COLUMNS = 1;
    ListView listView;
    ArrayList<String> list;
    RecyclerView mRecyclerView;
    ArrayAdapter<String> adapter;
    PhotoAdapter mPhotoAdapter;

    @Inject
    PhotoMainScreenPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.my_list);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        list = new ArrayList<>();

        mRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, NUMBER_OF_COLUMNS);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        DaggerPhotoMainScreenComponent.builder()
                .netComponent(((MvpApp) getApplicationContext()).getNetComponent())
                .photoMainScreenModule(new PhotoMainScreenModule(this))
                .build().inject(this);

        //Call the method in MainPresenter to make Network Request
        mainPresenter.loadPhotos();
    }

    @Override
    public void showPhotos(List<Photo> photos) {
        //Loop through the posts and get the title of the post and add it to our list object
        for (int i = 0; i < photos.size(); i++) {
            list.add(photos.get(i).getTitle());
        }
        //Create the array adapter and set it to list view
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        mPhotoAdapter = new PhotoAdapter(this, photos, this);
        mRecyclerView.setAdapter(mPhotoAdapter);
    }

    @Override
    public void showError(String message) {
        //Show error message Toast
        Toast.makeText(getApplicationContext(), "Error" + message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showComplete() {
        //Show completed message Toast
        Toast.makeText(getApplicationContext(), "Complete", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(Photo photo) {
        Toast.makeText(getApplicationContext(), "Clicked on " + photo.getTitle(), Toast.LENGTH_SHORT).show();
        mainPresenter.setNavigator(new PhotoNavigator(this, PhotoDetailPagerActivity.class, photo));
        mainPresenter.navigateToNewScreen();
    }
}
