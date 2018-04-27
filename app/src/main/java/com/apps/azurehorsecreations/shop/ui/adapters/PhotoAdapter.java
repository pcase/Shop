package com.apps.azurehorsecreations.shop.ui.adapters;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.apps.azurehorsecreations.shop.R;
import com.apps.azurehorsecreations.shop.data.Photo;
import java.util.List;


/*
 * PhotoAdapter handles photo name and image information for the photo page
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {
    private static final String TAG = "PhotoAdapter";
    private List<Photo> mPhotoList;
    private Handler handler;
    private Context mContext;
    private final OnItemClickListener listener;

    public PhotoAdapter(Context context, List<Photo> photos, OnItemClickListener listener) {
        this.mContext = context;
        this.mPhotoList = photos;
        this.listener = listener;
    }

    public Photo getItem(int id) {
        return mPhotoList.get(id);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_row_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String name = mPhotoList.get(position).getTitle();
        holder.photoTextView.setText(name);
        holder.click(mPhotoList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return mPhotoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView photoTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            photoTextView = itemView.findViewById(R.id.photo_text);
        }

        public void click(final Photo photo, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(photo);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onClick(Photo item);
    }
}
