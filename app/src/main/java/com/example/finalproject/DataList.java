package com.example.finalproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class DataList {
    @SerializedName("posts")
    @Expose
    private ArrayList<Data> data = null;
    public ArrayList<Data> getData() { return data; }
    public void setData(ArrayList<Data> data){ this.data = data; }
}
