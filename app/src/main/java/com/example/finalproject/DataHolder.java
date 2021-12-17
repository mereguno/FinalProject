package com.example.finalproject;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class DataHolder extends RecyclerView.ViewHolder {
    public TextView id;
    public TextView title;
    public TextView userId;
    public TextView body;

    public DataHolder(View itemView){
        super(itemView);
        userId = (TextView)itemView.findViewById(R.id.userId_box);
        id = (TextView) itemView.findViewById(R.id.id_box);
        title = (TextView) itemView.findViewById(R.id.title_box);
    }
}
