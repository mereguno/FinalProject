package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataHolder>{

    List<Data> list = Collections.emptyList();
    Context context;

    public DataAdapter(List<Data> list, Context context){
        this.list = list;
        this.context = context;
    }

    @Override
    public DataHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.expanded_data_page, parent, false);

        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(DataHolder holder, int position){
        holder.userId.setText(list.get(position).getUserId());
        holder.id.setText(list.get(position).getId());
        holder.title.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount(){
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void insert(int position, Data data){
        list.add(position, data);
        notifyItemInserted(position);
    }

    public void remove(Data data){
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }
}
