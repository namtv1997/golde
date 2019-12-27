package com.app.goldenhealth.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.app.goldenhealth.R;
import com.app.goldenhealth.model.KhaoSatDapAn;

import java.util.ArrayList;

public class CauHoiNhieuLuaChonAdapter extends RecyclerView.Adapter<CauHoiNhieuLuaChonAdapter.ViewHolder> {

    private Context context;
    private ArrayList<KhaoSatDapAn> arrayList;
    private OnItemClickListener onItemClickListener;

    public CauHoiNhieuLuaChonAdapter(Context context, ArrayList<KhaoSatDapAn> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_cau_hoi_nhieu_lua_chon, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(arrayList.get(position));
        holder.cbDapAn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.primaryLightColor));
                }else {
                    holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.white));
                }
                onItemClickListener.onClick(position, isChecked);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cb_dap_an)
        CheckBox cbDapAn;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(KhaoSatDapAn dapAn) {
            cbDapAn.setText(dapAn.getDapAn());
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(int position, boolean isCheck);
    }
}
