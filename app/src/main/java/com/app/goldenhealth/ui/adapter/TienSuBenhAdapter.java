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
import com.app.goldenhealth.model.TienSuBenh;

import java.util.ArrayList;

public class TienSuBenhAdapter extends RecyclerView.Adapter<TienSuBenhAdapter.ViewHolder> {

    private Context context;
    private ArrayList<TienSuBenh> arrayList;
    private OnItemClickListener onItemClickListener;

    public TienSuBenhAdapter(Context context, ArrayList<TienSuBenh> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_tien_su_benh, parent, false);
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

    public ArrayList<TienSuBenh> getArrayList() {
        return arrayList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_stt)
        TextView txtStt;
        @BindView(R.id.txt_ten_benh)
        TextView txtTenBenh;
        @BindView(R.id.txt_nguoi_mac)
        TextView txtNguoiMac;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(TienSuBenh tienSuBenh) {
            txtTenBenh.setText(tienSuBenh.getLOAIBENH() == null ? "" : tienSuBenh.getLOAIBENH());
            txtNguoiMac.setText(tienSuBenh.getLOAIQH() == null ? "" : tienSuBenh.getLOAIQH());
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }
}
