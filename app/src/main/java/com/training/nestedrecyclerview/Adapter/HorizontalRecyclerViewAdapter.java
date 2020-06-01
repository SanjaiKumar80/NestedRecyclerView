package com.training.nestedrecyclerview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.training.nestedrecyclerview.Model.HorizontalModel;
import com.training.nestedrecyclerview.R;

import java.util.ArrayList;

public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.HorizontalRVViewHolder> {
    Context context;
    ArrayList<HorizontalModel> arrayList;

    public HorizontalRecyclerViewAdapter(Context context, ArrayList<HorizontalModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public HorizontalRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal, parent, false);

        return new HorizontalRVViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalRVViewHolder holder, int position) {
        final HorizontalModel horizontalModel = arrayList.get(position);
        holder.TextViewTitle.setText(horizontalModel.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, horizontalModel.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class HorizontalRVViewHolder extends RecyclerView.ViewHolder {
        ImageView ImageViewThumb;
        TextView TextViewTitle;


        public HorizontalRVViewHolder(@NonNull View itemView) {
            super(itemView);
            ImageViewThumb = itemView.findViewById(R.id.imageViews);
            TextViewTitle = itemView.findViewById(R.id.textTitleHorizontal);
        }
    }

}
