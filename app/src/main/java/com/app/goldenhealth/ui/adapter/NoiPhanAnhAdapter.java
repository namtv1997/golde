package com.app.goldenhealth.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.app.goldenhealth.R;
import com.app.goldenhealth.model.DiaDiemPhanAnh;
import com.app.goldenhealth.model.TimKiem;
import com.app.goldenhealth.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class NoiPhanAnhAdapter extends RecyclerView.Adapter<NoiPhanAnhAdapter.ViewHolder> implements Filterable {

    private Context context;
    private ArrayList<DiaDiemPhanAnh> arrayList;
    private ArrayList<DiaDiemPhanAnh> arrayListFilter;
    private OnItemClickListener onItemClickListener;

    public NoiPhanAnhAdapter(Context context, ArrayList<DiaDiemPhanAnh> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        this.arrayListFilter = new ArrayList<>(arrayList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_search, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(arrayListFilter.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onClick(arrayListFilter.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayListFilter.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_name)
        TextView txtName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(DiaDiemPhanAnh diaDiemPhanAnh) {
            txtName.setText(diaDiemPhanAnh.getName());
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(DiaDiemPhanAnh diaDiemPhanAnh);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    arrayListFilter = arrayList;
                } else {
                    ArrayList<DiaDiemPhanAnh> filteredList = new ArrayList<>();
                    for (DiaDiemPhanAnh diaDiemPhanAnh : arrayList) {
                        if (Util.removeAccent(diaDiemPhanAnh.getName()).toLowerCase().contains(Util.removeAccent(charString).toLowerCase())) {
                            filteredList.add(diaDiemPhanAnh);
                        }
                    }
                    arrayListFilter = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = arrayListFilter;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                arrayListFilter = (ArrayList<DiaDiemPhanAnh>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public void filter(String text) {
        arrayListFilter.clear();
        if(text.isEmpty()){
            arrayListFilter.addAll(arrayList);
        } else{
            text = text.toLowerCase();
            for(DiaDiemPhanAnh diaDiemPhanAnh : arrayList){
                if(diaDiemPhanAnh.getName().toLowerCase().contains(text)){
                    arrayListFilter.add(diaDiemPhanAnh);
                }
            }
        }


        notifyDataSetChanged();
    }
}

