package com.example.myapplication0814;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private String[] from = {"title"};
    private int[] to = {R.id.item_title};
    private LinkedList<HashMap<String,String>> data = new LinkedList<>();
    private SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);
        initListView();
    }

    private void initListView(){


        HashMap<String,String> d0 = new HashMap<>();
        d0.put(from[0],"Test1");
        data.add(d0);

        adapter = new SimpleAdapter(this,data,R.layout.item,from,to);
        listView.setAdapter(adapter);
    }

    public void add(View view) {
        HashMap<String,String> d0 = new HashMap<>();
        d0.put(from[0],"Test1");
        data.add(d0);
        adapter.notifyDataSetChanged();
    }
    public void del(View view) {
        if (data.size()>0){
            data.remove(0);
        }
        adapter.notifyDataSetChanged();

    }
}
