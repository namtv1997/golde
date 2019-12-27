package com.app.goldenhealth.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.app.goldenhealth.R;
import com.app.goldenhealth.model.GroupPhanAnh;

import java.util.ArrayList;

public class PhanHoiAdapter extends RecyclerView.Adapter<PhanHoiAdapter.ViewHolder> {

    private Context context;
    private ArrayList<GroupPhanAnh> arrayList;
    private OnItemClickListener onItemClickListener;

    public PhanHoiAdapter(Context context, ArrayList<GroupPhanAnh> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_phan_hoi, parent, false);
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
        @BindView(R.id.txt_thoi_gian)
        TextView txtThoiGian;
        @BindView(R.id.rcv)
        RecyclerView rcv;
        private CauHoiAdapter adapter;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(GroupPhanAnh groupPhanAnh) {
            txtThoiGian.setText(groupPhanAnh.getDate());
            adapter = new CauHoiAdapter(context, groupPhanAnh.getListPhanAnh());
            adapter.setOnItemClickListener(new CauHoiAdapter.OnItemClickListener() {
                @Override
                public void sendAnswer(int id, String noiDung) {
                    onItemClickListener.sendAnswer(id, noiDung);
                }
            });
            rcv.setAdapter(adapter);
            rcv.setLayoutManager(new LinearLayoutManager(context));
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void sendAnswer(int id, String noiDung);
    }
}
