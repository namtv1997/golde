package com.app.goldenhealth.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.model.Comment;
import com.app.goldenhealth.model.FILE;
import com.app.goldenhealth.util.Toolbox;
import com.app.goldenhealth.widget.SlideImage;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import de.hdodenhof.circleimageview.CircleImageView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class BinhLuanAdapter extends RecyclerView.Adapter<BinhLuanAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Comment> arrayList;
    private OnItemClickListener onItemClickListener;
    private final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy' 'HH:mm:ss");

    public BinhLuanAdapter(Context context, ArrayList<Comment> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_binh_luan, parent, false);
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
        @BindView(R.id.img_avatar)
        CircleImageView imgAvatar;
        @BindView(R.id.txt_name)
        TextView txtName;
        @BindView(R.id.txt_content)
        TextView txtContent;
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.txt_number_image)
        TextView txtNumberImage;
        @BindView(R.id.view_image)
        RelativeLayout viewImage;
        @BindView(R.id.txt_time)
        TextView txtTime;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(Comment comment) throws ParseException {
            Glide.with(context).load(comment.getAVATAR()).apply(new RequestOptions().placeholder(R.drawable.ic_avatar)).into(imgAvatar);
            txtContent.setText(comment.getNOIDUNG());
            txtName.setText(comment.getHOTEN());
            txtTime.setText(Toolbox.convertToTimeAgo(format.parse(comment.getNGAYTAO()).getTime()));
            if (comment.getFILES().size() > 0){
                viewImage.setVisibility(View.VISIBLE);
                Glide.with(context).load(comment.getFILES().get(0).getFILE()).into(image);
                if (comment.getFILES().size() > 1){
                    txtNumberImage.setVisibility(View.VISIBLE);
                    txtNumberImage.setText((comment.getFILES().size() -1)  + "+");
                }else {
                    txtNumberImage.setVisibility(View.GONE);
                }
                ArrayList<String> images = new ArrayList<>();
                for (FILE file : comment.getFILES()) {
                    images.add(file.getFILE());
                }
                image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = SlideImage.getCallingIntent(context);
                        intent.putExtra(Key.ARRIMG, images);
                        intent.putExtra(Key.POSITION, 0);
                        context.startActivity(intent);
                    }
                });
            }else {
                viewImage.setVisibility(View.GONE);
            }

        }
    }

    public void setArrayList(ArrayList<Comment> arrayList) {
        this.arrayList = arrayList;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(int id);
    }
}
