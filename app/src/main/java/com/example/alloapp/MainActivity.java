package com.example.alloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FragmentA.FragmentAListener, FragmentB.FragmentBListener {
    private FragmentA fragmentA;
    private FragmentB fragmentB;
    ListView listView;
    ArrayList<String> arrayList  = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listView);
        fragmentA = new FragmentA();
        fragmentB = new FragmentB();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_a, fragmentA)
                .replace(R.id.container_b, fragmentB)
                .commit();
    }
    @Override
    public void onInputASent(CharSequence input) {
        fragmentB.updateEditText(input);
//        arrayList.add((String) input);
//        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
//        listView.setAdapter(arrayAdapter);
    }
    @Override
    public void onInputBSent(CharSequence input) {
        fragmentA.updateEditText(input);
//        arrayList.add((String) input);
//        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
//        listView.setAdapter(arrayAdapter);
    }
}