package com.apps.azurehorsecreations.shop.ui.adapters;

import com.apps.azurehorsecreations.shop.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.azurehorsecreations.shop.data.Post;
import java.util.List;


/*
 * PostAdapter handles product name and image information for the product page
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private static final String TAG = "PostAdapter";
    private List<Post> mPostList;
    private Handler handler;
    private Context mContext;
    private final OnItemClickListener listener;

    public PostAdapter(Context context, List<Post> posts, OnItemClickListener listener) {
        this.mContext = context;
        this.mPostList = posts;
        this.listener = listener;
    }

    public Post getItem(int id) {
        return mPostList.get(id);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_row_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String name = mPostList.get(position).getTitle();
        holder.postTextView.setText(name);
        holder.click(mPostList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return mPostList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView postTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            postTextView = itemView.findViewById(R.id.post_text);
        }

        public void click(final Post product, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(product);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onClick(Post item);
    }
}
