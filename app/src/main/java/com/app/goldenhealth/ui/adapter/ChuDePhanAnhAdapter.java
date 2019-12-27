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
import com.app.goldenhealth.model.ChuDePhanAnh;

import java.util.ArrayList;

public class ChuDePhanAnhAdapter extends RecyclerView.Adapter<ChuDePhanAnhAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ChuDePhanAnh> arrayList;
    private OnItemClickListener onItemClickListener;

    public ChuDePhanAnhAdapter(Context context, ArrayList<ChuDePhanAnh> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_chu_de_phan_anh, parent, false);
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
        @BindView(R.id.txt_type)
        TextView txtType;
        @BindView(R.id.txt_name)
        TextView txtName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(ChuDePhanAnh chuDePhanAnh) {
            txtType.setText(chuDePhanAnh.getType());
            txtName.setText(chuDePhanAnh.getNoiDung());
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }
}
