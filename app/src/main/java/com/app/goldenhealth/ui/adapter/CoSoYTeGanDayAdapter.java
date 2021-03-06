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
import com.app.goldenhealth.model.BenhVien;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CoSoYTeGanDayAdapter extends RecyclerView.Adapter<CoSoYTeGanDayAdapter.ViewHolder> {

    private Context context;
    private ArrayList<BenhVien> arrayList;
    private OnItemClickListener onItemClickListener;

    public CoSoYTeGanDayAdapter(Context context, ArrayList<BenhVien> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_co_so_y_te_gan_day, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(arrayList.get(position));
        holder.txtName.setText((position+1) + "." + arrayList.get(position).getTEN());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_name)
        TextView txtName;
        @BindView(R.id.rating_bar)
        RatingBar ratingBar;
        @BindView(R.id.txt_number_rating)
        TextView txtNumberRating;
        @BindView(R.id.txt_address)
        TextView txtAddress;
        @BindView(R.id.img_avatar)
        ImageView imgAvatar;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(BenhVien benhVien) {
            ratingBar.setRating(benhVien.getCSDANHGIA());
            txtNumberRating.setText(String.valueOf(benhVien.getSLDANHGIA()));
            txtAddress.setText(benhVien.getDIACHI());
            Glide.with(context).load(benhVien.getHINHANH())
                    .apply(new RequestOptions().placeholder(R.drawable.image_logo)).into(imgAvatar);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }
}
