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
import com.app.goldenhealth.model.ICD;
import com.app.goldenhealth.model.LichSuKhamChuaBenh;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LichSuKhamChuaBenhAdapter extends RecyclerView.Adapter<LichSuKhamChuaBenhAdapter.ViewHolder> {

    private Context context;
    private ArrayList<LichSuKhamChuaBenh> arrayList;

    public LichSuKhamChuaBenhAdapter(Context context, ArrayList<LichSuKhamChuaBenh> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_lich_su_kham_chua_benh, parent, false);
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
        @BindView(R.id.txt_noi_kham)
        TextView txtNoiKham;
        @BindView(R.id.rcv)
        RecyclerView rcv;

        KetQuaKhamBenhAdapter adapter;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(LichSuKhamChuaBenh lichSuKhamChuaBenh) throws ParseException {
            SimpleDateFormat formatFrom = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatTo = new SimpleDateFormat("dd/MM");
            String time = formatTo.format(formatFrom.parse(lichSuKhamChuaBenh.getNGAYBATDAU()));
            txtTime.setText(time);
            txtNoiKham.setText(lichSuKhamChuaBenh.getCSKCB());
            adapter = new KetQuaKhamBenhAdapter(context, (ArrayList<ICD>) lichSuKhamChuaBenh.getICDs());
            rcv.setLayoutManager(new LinearLayoutManager(context));
            rcv.setAdapter(adapter);

        }
    }
}
