package com.apps.azurehorsecreations.shop.ui;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.apps.azurehorsecreations.shop.data.Post;
import com.apps.azurehorsecreations.shop.R;
import com.apps.azurehorsecreations.shop.ui.adapters.DetailPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/*
 * PostDetailPagerActivity displays the product details in a swipeable viewer
 */

public class PostDetailPagerActivity extends AppCompatActivity {
    private static final String POST = "POST";
    private Post product;
    private Post[] postArray;
    FragmentPagerAdapter adapterViewPager;
    List<Fragment> fragments;
    ViewPager vpPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager);
//        ButterKnife.bind(this);
        vpPager = findViewById(R.id.vpPager);
        Parcelable parcelableProduct = getIntent().getParcelableExtra(POST);
        postArray = new Post[1];
        postArray[0] = (Post)parcelableProduct;
        fragments = new ArrayList<>();
        fragments.add(PostDetailFragment.newInstance(postArray[0]));
        adapterViewPager = new DetailPagerAdapter(getSupportFragmentManager(), fragments);
        vpPager.setAdapter(adapterViewPager);

//        Parcelable[] parcelableProductArray = getIntent().getParcelableArrayExtra(PRODUCT);
//        productArray = new Product[parcelableProductArray.length];
//        for (int i=0; i<parcelableProductArray.length; ++i) {
//            productArray[i] = (Product) parcelableProductArray[i];
//        }
//        fragments = new ArrayList<>();
//        for (int i=0; i<productArray.length; ++i) {
//            fragments.add(PostDetailFragment.newInstance(productArray[i]));
//        }
//        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
//        adapterViewPager = new DetailPagerAdapter(getSupportFragmentManager(), fragments);
//        vpPager.setAdapter(adapterViewPager);
    }
}
