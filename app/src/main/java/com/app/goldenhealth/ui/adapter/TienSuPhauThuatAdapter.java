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
import com.app.goldenhealth.model.TienSuPhauThuat;
import java.util.ArrayList;

public class TienSuPhauThuatAdapter extends RecyclerView.Adapter<TienSuPhauThuatAdapter.ViewHolder> {

    private Context context;
    private ArrayList<TienSuPhauThuat> arrayList;
    private OnItemClickListener onItemClickListener;

    public TienSuPhauThuatAdapter(Context context, ArrayList<TienSuPhauThuat> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_tien_su_phau_thuat, parent, false);
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

    public ArrayList<TienSuPhauThuat> getArrayList() {
        return arrayList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_bo_phan)
        TextView txtBoPhan;
        @BindView(R.id.txt_nam)
        TextView txtNam;
        @BindView(R.id.txt_noi_phau_thuat)
        TextView txtNoiPhauThuat;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(TienSuPhauThuat tienSuPhauThuat) {
            txtBoPhan.setText(tienSuPhauThuat.getBOPHANPHAUTHUAT() == null ? "" : tienSuPhauThuat.getBOPHANPHAUTHUAT());
            txtNam.setText(tienSuPhauThuat.getNAMTHUCHIEN().toString());
            txtNoiPhauThuat.setText(tienSuPhauThuat.getTENKCB());
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }
}
