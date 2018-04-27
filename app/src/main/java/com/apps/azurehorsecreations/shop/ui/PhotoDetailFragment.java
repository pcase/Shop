package com.apps.azurehorsecreations.shop.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.apps.azurehorsecreations.shop.R;
import com.apps.azurehorsecreations.shop.data.Photo;

/*
 * PostDetailFragment is a fragment for the product detail page
 */

/*
    private final Integer userId;
    private final Integer id;
    private final String title;
    private final String body;

 */
public class PhotoDetailFragment extends Fragment {
    private static final String TAG = "PhotoDetFrag";
    private Photo photo;
    TextView albumId;
    TextView id;
    TextView title;
    TextView url;
    TextView thumbnailUrl;
    ProgressBar progressBar;

    public static PhotoDetailFragment newInstance(Photo photo) {
        PhotoDetailFragment fragmentFirst = new PhotoDetailFragment();
        Bundle args = new Bundle();
        args.putInt("albumId", photo.getAlbumId());
        args.putInt("id", photo.getId());
        args.putString("title", photo.getTitle());
        args.putString("url", photo.getUrl());
        args.putString("thumbnailUrl", photo.getThumbnailUrl());
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        photo = new Photo();
        photo.setAlbumId(getArguments().getInt("albumId"));
        photo.setId(getArguments().getInt("id"));
        photo.setTitle(getArguments().getString("title"));
        photo.setUrl(getArguments().getString("url"));
        photo.setThumbnailUrl(getArguments().getString("thumbnailUrl"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_photo_detail, container, false);
        albumId = view.findViewById(R.id.album_Id);
        id = view.findViewById(R.id.id);
        title = view.findViewById(R.id.title);
        url = view.findViewById(R.id.url);
        thumbnailUrl = view.findViewById(R.id.thumbnail_url);

        if (photo.getAlbumId() != null) {
            albumId.setText((Html.fromHtml(photo.getAlbumId().toString())));
        }

        if (photo.getId() != null) {
            id.setText((Html.fromHtml(photo.getId().toString())));
        }

        if (photo.getTitle() != null) {
            title.setText(Html.fromHtml(photo.getTitle()));
        }

        if (photo.getUrl() != null) {
            url.setText(Html.fromHtml(photo.getUrl()));
        }

        if (photo.getThumbnailUrl() != null) {
            thumbnailUrl.setText(Html.fromHtml(photo.getThumbnailUrl()));
        }

//        loadImage(productImage, product.getProductImage());
        return view;
    }

    private void loadImage(final ImageView bmImage, String url) {
//        Handler handler = new Handler() {
//            @Override
//            public void handleMessage(Message msg) {
//                Bitmap bitmap = (Bitmap) msg.obj;
//                bmImage.setImageBitmap(bitmap);
//            }
//        };
//
//        ImageDownloader imageDownloader = new ImageDownloader();
//        imageDownloader.loadImage(url, handler);
    }
}
