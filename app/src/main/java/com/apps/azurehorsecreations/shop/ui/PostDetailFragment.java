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
import com.apps.azurehorsecreations.shop.data.Post;
import com.apps.azurehorsecreations.shop.R;

/*
 * PostDetailFragment is a fragment for the product detail page
 */

/*
    private final Integer userId;
    private final Integer id;
    private final String title;
    private final String body;

 */
public class PostDetailFragment extends Fragment {
    private static final String TAG = "PostDetFrag";
    private Post post;
    TextView userId;
    TextView id;
    TextView title;
    TextView body;
    ProgressBar progressBar;

    public static PostDetailFragment newInstance(Post product) {
        PostDetailFragment fragmentFirst = new PostDetailFragment();
        Bundle args = new Bundle();
        args.putInt("userId", product.getUserId());
        args.putInt("id", product.getId());
        args.putString("title", product.getTitle());
        args.putString("body", product.getBody());
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        post = new Post();
        post.setUserId(getArguments().getInt("userId"));
        post.setId(getArguments().getInt("id"));
        post.setTitle(getArguments().getString("title"));
        post.setBody(getArguments().getString("body"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_post_detail, container, false);
        userId = view.findViewById(R.id.user_Id);
        id = view.findViewById(R.id.id);
        title = view.findViewById(R.id.title);
        body = view.findViewById(R.id.body);

        if (post.getUserId() != null) {
            userId.setText((Html.fromHtml(post.getUserId().toString())));
        }

        if (post.getId() != null) {
            id.setText((Html.fromHtml(post.getId().toString())));
        }

        if (post.getTitle() != null) {
            title.setText(Html.fromHtml(post.getTitle()));
        }

        if (post.getBody() != null) {
            body.setText(Html.fromHtml(post.getBody()));
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
