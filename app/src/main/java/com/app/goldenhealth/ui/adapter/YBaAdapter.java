package com.app.goldenhealth.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.app.goldenhealth.R;
import com.app.goldenhealth.model.BenhNhan;

import java.util.ArrayList;

public class YBaAdapter extends RecyclerView.Adapter<YBaAdapter.ViewHolder> {

    private Context context;
    private ArrayList<BenhNhan> arrayList;
    private OnItemClickListener onItemClickListener;

    public YBaAdapter(Context context, ArrayList<BenhNhan> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_y_ba, parent, false);
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
        @BindView(R.id.txt_ma_y_te)
        TextView txtMaYTe;
        @BindView(R.id.txt_ho_ten)
        TextView txtHoTen;
        @BindView(R.id.btn_delete)
        ImageView btnDelete;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(BenhNhan benhNhan) {
            txtHoTen.setText(benhNhan.getUserName());
            txtMaYTe.setText(benhNhan.getUserMaYTeCaNhan());
            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onClick(benhNhan.getId());
                }
            });
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(int id);
    }
}
