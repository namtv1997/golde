package com.app.goldenhealth.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.model.PhanAnh;
import com.app.goldenhealth.util.PrefUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PhanAnhAdapter extends RecyclerView.Adapter<PhanAnhAdapter.ViewHolder> {

    private Context context;
    private ArrayList<PhanAnh> arrayList;
    private OnItemClickListener onItemClickListener;
    private boolean isCaNhan;
    private int roleId;
    private final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy' 'HH:mm:ss");
    private final SimpleDateFormat formatTo = new SimpleDateFormat("dd' tháng 'MM' lúc 'HH:mm");

    public PhanAnhAdapter(Context context, ArrayList<PhanAnh> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        this.isCaNhan = isCaNhan;
        roleId = PrefUtil.getDataUser(context).getRoleId();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_phan_anh, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            holder.bind(arrayList.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onClick(arrayList.get(position).getID());
                }
            });
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.txt_content)
        TextView txtContent;
        @BindView(R.id.txt_time)
        TextView txtTime;
        @BindView(R.id.rating_bar)
        RatingBar ratingBar;
        @BindView(R.id.txt_number_rating)
        TextView txtNumberRating;
        @BindView(R.id.view_rating)
        LinearLayout viewRating;
        @BindView(R.id.txt_like)
        TextView txtLike;
        @BindView(R.id.txt_comment)
        TextView txtComment;
        @BindView(R.id.txt_share)
        TextView txtShare;
        @BindView(R.id.view_comment)
        LinearLayout viewComment;
        @BindView(R.id.txt_status)
        TextView txtStatus;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(PhanAnh phanAnh) throws ParseException {
            Glide.with(context).load(phanAnh.getAVATARNGPA()).apply(new RequestOptions().placeholder(R.drawable.ic_avatar)).into(image);
            txtTime.setText(formatTo.format(format.parse(phanAnh.getNGAYTAO())));
            txtContent.setText(phanAnh.getNOIDUNG());
            ratingBar.setRating(phanAnh.getdANHGIA());
            txtNumberRating.setText(phanAnh.getsLDANHGIA() + " "+ context.getString(R.string.danh_gia));
            if (phanAnh.getMUCDOCONGKHAIID() == Key.CA_NHAN){
                viewRating.setVisibility(View.INVISIBLE);
                viewComment.setVisibility(View.GONE);
                txtStatus.setVisibility(View.VISIBLE);
                if (phanAnh.getTRANGTHAI() == 1){
                    txtStatus.setText(phanAnh.getTENNGTL() + " " + context.getString(R.string.da_tra_loi));
                    itemView.setBackgroundColor(context.getResources().getColor(R.color.white));
                }else {
                    txtStatus.setText(R.string.dang_cho_phan_hoi);
                    itemView.setBackgroundColor(context.getResources().getColor(R.color.backgroundPhanAnh));
                }
            }else {
                viewRating.setVisibility(View.VISIBLE);
                viewComment.setVisibility(View.VISIBLE);
                txtStatus.setVisibility(View.GONE);
                txtLike.setText(phanAnh.getSLQUANTAM() + " " + context.getString(R.string.quan_tam));
                txtComment.setText(phanAnh.getSLBINHLUAN() + " " + context.getString(R.string.binh_luan));
                txtShare.setText(phanAnh.getSLCHIASE() + " " + context.getString(R.string.chia_se));
            }
        }
    }

    public void setIsCaNhan(boolean caNhan) {
        isCaNhan = caNhan;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(int id);
    }
}
