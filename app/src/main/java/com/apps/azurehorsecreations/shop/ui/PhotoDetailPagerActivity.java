package com.apps.azurehorsecreations.shop.ui;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.apps.azurehorsecreations.shop.R;
import com.apps.azurehorsecreations.shop.data.Photo;
import com.apps.azurehorsecreations.shop.ui.adapters.DetailPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/*
 * PostDetailPagerActivity displays the product details in a swipeable viewer
 */

public class PhotoDetailPagerActivity extends AppCompatActivity {
    private static final String PRODUCT = "PRODUCT";
    private Photo phpto;
    private Photo[] photoArray;
    FragmentPagerAdapter adapterViewPager;
    List<Fragment> fragments;
    ViewPager vpPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager);
        vpPager = findViewById(R.id.vpPager);
        Parcelable parcelableProduct = getIntent().getParcelableExtra("PHOTO");
        photoArray = new Photo[1];
        photoArray[0] = (Photo)parcelableProduct;
        fragments = new ArrayList<>();
        fragments.add(PhotoDetailFragment.newInstance(photoArray[0]));
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
