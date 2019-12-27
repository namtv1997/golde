package com.app.goldenhealth.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.model.PhanAnh;
import com.app.goldenhealth.util.PrefUtil;

import java.util.ArrayList;

public class CauHoiAdapter extends RecyclerView.Adapter<CauHoiAdapter.ViewHolder> {

    private Context context;
    private ArrayList<PhanAnh> arrayList;
    private OnItemClickListener onItemClickListener;
    private int typeUer;

    public CauHoiAdapter(Context context, ArrayList<PhanAnh> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        typeUer = PrefUtil.getDataUser(context).getRoleId();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_cau_hoi, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(arrayList.get(position));
        holder.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noiDung = holder.edtNhanXet.getText().toString();
                if (!noiDung.isEmpty()){
                    onItemClickListener.sendAnswer(arrayList.get(position).getID(), noiDung);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_circle)
        ImageView imgCircle;
        @BindView(R.id.txt_cau_hoi)
        TextView txtCauHoi;
        @BindView(R.id.txt_cau_tra_loi)
        TextView txtCauTraLoi;
        @BindView(R.id.edt_nhan_xet)
        EditText edtNhanXet;
        @BindView(R.id.btn_send)
        ImageButton btnSend;
        @BindView(R.id.view_tra_loi)
        RelativeLayout viewTraLoi;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(PhanAnh phanAnh) {
            txtCauHoi.setText(phanAnh.getNGPHANANH() + ": " + phanAnh.getNOIDUNG());
            txtCauTraLoi.setText(context.getString(R.string.tra_loi) +" " + phanAnh.getTRALOI());
            if (phanAnh.getTRANGTHAI() == 0) {
                imgCircle.setImageResource(R.drawable.ic_checkbox_circle_false);
                txtCauTraLoi.setVisibility(View.GONE);
                if (typeUer == Key.USER){
                    viewTraLoi.setVisibility(View.GONE);
                }else {
                    viewTraLoi.setVisibility(View.VISIBLE);
                }
            } else {
                txtCauTraLoi.setVisibility(View.VISIBLE);
                imgCircle.setImageResource(R.drawable.ic_checkbox_circle_true);
                viewTraLoi.setVisibility(View.GONE);
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void sendAnswer(int id, String noiDung);
    }
}
