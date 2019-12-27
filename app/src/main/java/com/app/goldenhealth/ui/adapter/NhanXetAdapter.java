package com.app.goldenhealth.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.app.goldenhealth.R;
import com.app.goldenhealth.model.BVNHANXET;
import com.bumptech.glide.Glide;
import de.hdodenhof.circleimageview.CircleImageView;

import java.util.ArrayList;

public class NhanXetAdapter extends RecyclerView.Adapter<NhanXetAdapter.ViewHolder> {

    private Context context;
    private ArrayList<BVNHANXET> arrayList;
    private OnItemClickListener onItemClickListener;

    public NhanXetAdapter(Context context, ArrayList<BVNHANXET> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_nhan_xet, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(arrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_avatar)
        CircleImageView imgAvatar;
        @BindView(R.id.txt_ten)
        TextView txtTen;
        @BindView(R.id.btn_menu)
        ImageView btnMenu;
        @BindView(R.id.rating_bar)
        RatingBar ratingBar;
        @BindView(R.id.txt_time)
        TextView txtTime;
        @BindView(R.id.txt_nhan_xet)
        TextView txtNhanXet;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(BVNHANXET bvnhanxet) {
            txtTen.setText(bvnhanxet.getHOTENNNX());
            ratingBar.setRating(bvnhanxet.getDANHGIA());
            txtTime.setText(bvnhanxet.getNGAYTAO());
            txtNhanXet.setText(bvnhanxet.getNHANXET());
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }
}
