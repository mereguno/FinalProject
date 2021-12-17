package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Data> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadData();
    }

    protected void loadData() {
        if (InternetConnection.checkConnection(getApplicationContext())) {
            final ProgressDialog dialog;
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setTitle("Getting data...");
            dialog.show();

            ApiService api = RetroClient.getApiService();

            Call<DataList> call = api.getData();

            call.enqueue(new Callback<DataList>() {
                @Override
                public void onResponse(Call<DataList> call, Response<DataList> response) {
                    dialog.dismiss();
                    if (response.isSuccessful()) {

                        dataList = response.body().getData();

                        RecyclerView recyclerData = (RecyclerView) findViewById(R.id.listHolder);
                        DataAdapter adapter = new DataAdapter(dataList, MainActivity.this);
                        recyclerData.setAdapter(adapter);
                        recyclerData.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    } else {
                        Snackbar.make(findViewById(R.id.main_page), "Not working", Snackbar.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<DataList> call, Throwable t) {
                    Snackbar.make(findViewById(R.id.main_page), "failure", Snackbar.LENGTH_LONG).show();
                    dialog.dismiss();
                }
            });
        }
    }
    public void expandDetails(View view){
        Intent intent = new Intent(this, BodyText.class);
        intent.putExtra("key", dataList.toString());
        startActivity(intent);
    }
}

