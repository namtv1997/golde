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
import com.app.goldenhealth.model.DanhBa;
import com.bumptech.glide.Glide;
import de.hdodenhof.circleimageview.CircleImageView;

import java.util.ArrayList;

public class DanhBaAdapter extends RecyclerView.Adapter<DanhBaAdapter.ViewHolder> {
    public final static int TYPE_BAC_SI = 1;
    public final static int TYPE_BENH_VIEN = 2;

    private Context context;
    private ArrayList<DanhBa> arrayList;
    private OnItemClickListener onItemClickListener;

    public DanhBaAdapter(Context context, ArrayList<DanhBa> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_danh_ba, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(arrayList.get(position));
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
        @BindView(R.id.img_avatar)
        CircleImageView imgAvatar;
        @BindView(R.id.txt_name)
        TextView txtName;
        @BindView(R.id.txt_dia_chi)
        TextView txtDiaChi;
        @BindView(R.id.txt_rating)
        TextView txtRating;
        @BindView(R.id.rating_bar)
        RatingBar ratingBar;
        @BindView(R.id.txt_number_rating)
        TextView txtNumberRating;
        @BindView(R.id.txt_type)
        TextView txtType;
        @BindView(R.id.btn_favorite)
        ImageView btnFavorite;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(DanhBa danhBa) {
            Glide.with(context).load(danhBa.getAVATAR()).into(imgAvatar);
            if (danhBa.getTYPE() == TYPE_BAC_SI){
                txtName.setText(danhBa.getBVBACSI());
                txtDiaChi.setText(danhBa.getBVBACSI());
                txtDiaChi.setVisibility(View.VISIBLE);
                txtType.setText(R.string.bac_si);
            }else {
                txtName.setText(danhBa.getBENHVIEN());
                txtDiaChi.setVisibility(View.GONE);
                txtType.setText(R.string.benh_vien);
            }
            txtRating.setText(danhBa.getCSDANHGIA() == null ? "0.0" : (danhBa.getCSDANHGIA().toString().equals("NaN") ? "0.0" : danhBa.getCSDANHGIA().toString()));
            ratingBar.setRating(danhBa.getCSDANHGIA());
            txtNumberRating.setText(danhBa.getSLDANHGIA() + " " + context.getString(R.string.danh_gia));
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }
}
