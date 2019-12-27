package com.app.goldenhealth.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.app.goldenhealth.R;
import com.app.goldenhealth.model.TienSuDiUng;

import java.util.ArrayList;

public class TienSuDiUngAdapter extends RecyclerView.Adapter<TienSuDiUngAdapter.ViewHolder> {

    private Context context;
    private ArrayList<TienSuDiUng> arrayList;
    private OnItemClickListener onItemClickListener;

    public TienSuDiUngAdapter(Context context, ArrayList<TienSuDiUng> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_tien_su_di_ung, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(arrayList.get(position));
        holder.txtStt.setText(position + 1 + "");
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

    public ArrayList<TienSuDiUng> getArrayList() {
        return arrayList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_stt)
        TextView txtStt;
        @BindView(R.id.txt_loai_du)
        TextView txtLoaiDu;
        @BindView(R.id.txt_nguoi_mac)
        TextView txtNguoiMac;
        @BindView(R.id.txt_mo_ta)
        TextView txtMoTa;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(TienSuDiUng tienSuDiUng) {
            txtLoaiDu.setText(tienSuDiUng.getLOAIDIUNG() == null ? "" : tienSuDiUng.getLOAIDIUNG());
            txtNguoiMac.setText(tienSuDiUng.getLOAIQH() == null ? "" : tienSuDiUng.getLOAIQH());
            txtMoTa.setText(tienSuDiUng.getMOTA() == null ? "" : tienSuDiUng.getMOTA());
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }
}
