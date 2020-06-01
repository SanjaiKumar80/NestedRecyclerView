package com.training.nestedrecyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.training.nestedrecyclerview.Adapter.VerticalRecyclerViewAdapter;
import com.training.nestedrecyclerview.Model.HorizontalModel;
import com.training.nestedrecyclerview.Model.VerticalModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView verticalRecyclerView;
    VerticalRecyclerViewAdapter adapter;

    ArrayList<VerticalModel> arrayListVertical = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verticalRecyclerView = findViewById(R.id.recyclerView);
        verticalRecyclerView.setHasFixedSize(true);
        verticalRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        adapter = new VerticalRecyclerViewAdapter(this, arrayListVertical);
        verticalRecyclerView.setAdapter(adapter);
        setData();
    }

    private void setData() {

        for (int i = 0; i < 5; i++) {

            VerticalModel mverticalModels = new VerticalModel();
            mverticalModels.setTitle("Title:" + i);
            ArrayList<HorizontalModel> arrayListHorizontal = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                HorizontalModel horizontalModel = new HorizontalModel();
                horizontalModel.setDescription("Description" + j);
                horizontalModel.setName("Name" + j);
                arrayListHorizontal.add(horizontalModel);

            }

            mverticalModels.setArraylist(arrayListHorizontal);
            arrayListVertical.add(mverticalModels);
        }
        adapter.notifyDataSetChanged();

    }
}
