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
import com.apps.azurehorsecreations.shop.data.Post;
import com.apps.azurehorsecreations.shop.ui.adapters.PostAdapter;
import com.apps.azurehorsecreations.shop.ui.navigation.PostNavigator;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements PostMainScreenContract.View, PostAdapter.OnItemClickListener {
    private static final int NUMBER_OF_COLUMNS = 1;
    ListView listView;
    ArrayList<String> list;
    RecyclerView mRecyclerView;
    ArrayAdapter<String> adapter;
    PostAdapter mPostAdapter;

    @Inject
    PostMainScreenPresenter mainPresenter;

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

        DaggerPostMainScreenComponent.builder()
                .netComponent(((MvpApp) getApplicationContext()).getNetComponent())
                .postMainScreenModule(new PostMainScreenModule(this))
                .build().inject(this);

        //Call the method in MainPresenter to make Network Request
        mainPresenter.loadPosts();
    }

    @Override
    public void showPosts(List<Post> posts) {
        //Loop through the posts and get the title of the post and add it to our list object
        for (int i = 0; i < posts.size(); i++) {
            list.add(posts.get(i).getTitle());
        }
        //Create the array adapter and set it to list view
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        mPostAdapter = new PostAdapter(this, posts, this);
        mRecyclerView.setAdapter(mPostAdapter);
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
    public void onClick(Post photo) {
        Toast.makeText(getApplicationContext(), "Clicked on " + photo.getTitle(), Toast.LENGTH_SHORT).show();
        mainPresenter.setNavigator(new PostNavigator(this, PostDetailPagerActivity.class, photo));
        mainPresenter.navigateToNewScreen();
    }
}
