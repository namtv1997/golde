package com.app.goldenhealth.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.app.goldenhealth.R;
import com.app.goldenhealth.model.ChuDeKhaoSat;

import java.util.ArrayList;

public class ChuDeKhaoSatAdapter extends RecyclerView.Adapter<ChuDeKhaoSatAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ChuDeKhaoSat> arrayList;
    private OnItemClickListener onItemClickListener;

    public ChuDeKhaoSatAdapter(Context context, ArrayList<ChuDeKhaoSat> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_chu_de, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(arrayList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onClick(position, !arrayList.get(position).isSelected());
                if (arrayList.get(position).isSelected()){
                    arrayList.get(position).setSelected(false);
                }else {
                    arrayList.get(position).setSelected(true);
                    for (int i = 0; i< arrayList.size(); i++){
                        if (i != position){
                            arrayList.get(i).setSelected(false);
                        }
                    }
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
        @BindView(R.id.txt_name)
        TextView txtName;
        @BindView(R.id.background)
        LinearLayout background;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(ChuDeKhaoSat chuDeKhaoSat) {
            txtName.setText(chuDeKhaoSat.getTen());
            if (chuDeKhaoSat.isSelected()) {
                txtName.setTextColor(context.getResources().getColor(R.color.white));
                background.setBackground(context.getResources().getDrawable(R.drawable.bg_seleted));
            }else {
                txtName.setTextColor(context.getResources().getColor(R.color.colorPrimary));
                background.setBackground(context.getResources().getDrawable(R.drawable.bg_white));
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(int position, boolean isSeleted);
    }
}
