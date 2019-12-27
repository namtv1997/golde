package com.app.goldenhealth.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.app.goldenhealth.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Truong KL on 2/6/2018.
 */

public class ImageViewPagerAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<String> images;
    private LayoutInflater inflater;
    private OnItemClickListener onItemClickListener;

    public ImageViewPagerAdapter(Context context, ArrayList<String> images) {
        this.context = context;
        this.images = images;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = inflater.inflate(R.layout.item_image_pager, container, false);

        ImageView img = (ImageView) itemView.findViewById(R.id.img_room);
        Glide.with(context).load(images.get(position)).into(img);
        container.addView(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onClick(position);
            }
        });
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return object.equals(view);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onClick(int position);
    }
}
