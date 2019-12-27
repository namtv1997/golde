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
import com.app.goldenhealth.model.GroupLichSuKhamChuaBenh;
import com.app.goldenhealth.model.ICD;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class GroupLichSuKhamChuaBenhAdapter extends RecyclerView.Adapter<GroupLichSuKhamChuaBenhAdapter.ViewHolder> {

    private Context context;
    private ArrayList<GroupLichSuKhamChuaBenh> arrayList;

    public GroupLichSuKhamChuaBenhAdapter(Context context, ArrayList<GroupLichSuKhamChuaBenh> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_timeline, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            holder.bind(arrayList.get(position));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_time)
        TextView txtTime;
        @BindView(R.id.rcv)
        RecyclerView rcv;

        LichSuKhamChuaBenhAdapter adapter;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(GroupLichSuKhamChuaBenh groupLichSuKhamChuaBenh) throws ParseException {
            txtTime.setText(groupLichSuKhamChuaBenh.getYear());
            adapter = new LichSuKhamChuaBenhAdapter(context, groupLichSuKhamChuaBenh.getListLSKCB());
            rcv.setLayoutManager(new LinearLayoutManager(context));
            rcv.setAdapter(adapter);
        }
    }
}
