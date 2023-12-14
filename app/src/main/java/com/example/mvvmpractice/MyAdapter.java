package com.example.mvvmpractice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<WidgetItem> itemList;

    public MyAdapter(List<WidgetItem> itemList) {
        this.itemList = itemList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageViews);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;


        if (viewType == 0) {
            // Inflating layout for text items
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.text_layout, parent, false);
        } else {
            // Inflating layout for image items
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.image_item_layout, parent, false);
        }
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        WidgetItem item = itemList.get(position);
        System.out.println(item.getWidgetType());
    if(item != null && item.getWidgetType()!= null) {
        if (item.getWidgetType().equals("text")) {
            holder.textView.setText(item.getWidgetTitle());

        } else  {
            holder.imageView.setImageResource(R.drawable.ic_launcher_background); // Set a placeholder image


        }
    }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public int getItemViewType(int position) {

        WidgetItem widgetItem = itemList.get(position);

        if (widgetItem != null && widgetItem.getWidgetType() != null) {
            return widgetItem.getWidgetType().equals("text") ? 0 : 1;
        } else {
            // Handle the case where widgetItem or its type is null
            return 0;  // or return a default type if appropriate
        }
    }

}
