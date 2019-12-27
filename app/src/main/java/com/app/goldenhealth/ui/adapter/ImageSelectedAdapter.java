package com.app.goldenhealth.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.app.goldenhealth.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ImageSelectedAdapter extends RecyclerView.Adapter<ImageSelectedAdapter.ImageHolder> {

    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;
    private LayoutInflater inflater;
    private ArrayList<String> listUri;
    private Context context;


    public ImageSelectedAdapter(ArrayList<String> listUri, Context context) {
        this.listUri = listUri;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageHolder(inflater.inflate(R.layout.item_image_picked, parent, false));
    }

    @Override
    public void onBindViewHolder(final ImageHolder holder, final int position) {
        Glide.with(holder.itemView.getContext()).load(listUri.get(position)).into(holder.image);
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position < 0) {
                    return;
                }
                int pos = holder.getAdapterPosition();
                listUri.remove(pos);

                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listUri.size();
    }

    public ArrayList<String> getListUri() {
        return listUri;
    }

    public void removeList() {
        listUri.clear();
    }

    public class ImageHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.btn_delete)
        ImageView btnDelete;

        public ImageHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }
}
