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
import com.app.goldenhealth.model.ThongBao;
import com.app.goldenhealth.util.Toolbox;
import com.bumptech.glide.Glide;
import de.hdodenhof.circleimageview.CircleImageView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ThongBao> arrayList;
    private OnItemClickListener onItemClickListener;

    public NotificationAdapter(Context context, ArrayList<ThongBao> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_notification, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(arrayList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.get(position).setIsRead(1);
                holder.background.setBackgroundColor(context.getResources().getColor(R.color.white));
                onItemClickListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_avatar)
        CircleImageView imgAvatar;
        @BindView(R.id.txt_content)
        TextView txtContent;
        @BindView(R.id.txt_time)
        TextView txtTime;
        @BindView(R.id.background)
        LinearLayout background;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(ThongBao thongBao) {
            Glide.with(context).load(thongBao.getImage()).into(imgAvatar);
            txtContent.setText(thongBao.getContent());
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy' 'HH:mm:ss");
            try {
                Date date = format.parse(thongBao.getDateCreate());
                txtTime.setText(Toolbox.convertToTimeAgo(date.getTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (thongBao.getIsRead() == 0){
                background.setBackgroundColor(context.getResources().getColor(R.color.primaryLightColor));
            }else {
                background.setBackgroundColor(context.getResources().getColor(R.color.white));
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }
}
