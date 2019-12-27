package com.app.goldenhealth.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.app.goldenhealth.R;
import com.app.goldenhealth.model.KhaoSatDapAn;

import java.util.ArrayList;

public class CauHoiMotLuaChonAdapter extends RecyclerView.Adapter<CauHoiMotLuaChonAdapter.ViewHolder> {

    private Context context;
    private ArrayList<KhaoSatDapAn> arrayList;
    private OnItemClickListener onItemClickListener;

    public CauHoiMotLuaChonAdapter(Context context, ArrayList<KhaoSatDapAn> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_cau_hoi_mot_lua_chon, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.cbDapAn.setOnCheckedChangeListener(null);
        holder.bind(arrayList.get(position));
        holder.cbDapAn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                arrayList.get(position).setChecked(isChecked);
                if (isChecked){
                    holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.primaryLightColor));
                    for (int i=0; i< arrayList.size(); i++){
                        if (i != position){
                            arrayList.get(i).setChecked(false);
                        }
                    }
                    onItemClickListener.onClick(position);
                }else {
                    holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.white));
                    onItemClickListener.onUnClick(position);
                }

                notifyDataSetChanged();
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
            cbDapAn.setChecked(dapAn.isChecked());
            if (dapAn.isChecked()){
               itemView.setBackgroundColor(context.getResources().getColor(R.color.primaryLightColor));
            }else {
               itemView.setBackgroundColor(context.getResources().getColor(R.color.white));
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(int position);
        void onUnClick(int position);
    }
}
