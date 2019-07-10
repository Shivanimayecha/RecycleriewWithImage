package com.example.recycleriewwithimage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    EditText editText;


   /* ArrayList name = new ArrayList<>(Arrays.asList("name 1", "name 2", "name 3", "name 4", "name 5", "name 6", "name7"));
    //ArrayList image = new ArrayList<>(Arrays.asList(R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher));
*/
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayList<Integer> imageList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.rv);
        editText = (EditText)findViewById(R.id.edt_SearchName);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                filter(editable.toString());

            }
        });



        arrayList.add("Jaisalmer fort");
        arrayList.add("Jaipur Pink City");
        arrayList.add("Lake Place");
        arrayList.add("Louts Temple");
        arrayList.add("Pangong Lake");
        arrayList.add("Sun Temple");
        arrayList.add("Golden Temple");
        arrayList.add("Red Fort");
        arrayList.add("Taj Mahal");
        arrayList.add("Valley Of Flower");

        imageList.add(R.drawable.jaisalmer_fort_jaisalmer);
        imageList.add(R.drawable.lake_palace_udaipur_1);
        imageList.add(R.drawable.pangong_lake_ladakh);
        imageList.add(R.drawable.sun_temple_konark);
        imageList.add(R.drawable.the_golden_temple_amritsar);
        imageList.add(R.drawable.the_red_fort_delhi);
        imageList.add(R.drawable.the_taj_mahal_agra);
        imageList.add(R.drawable.valley_of_flowers_nainital);





        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        customAdapter = new CustomAdapter(MainActivity.this, arrayList,imageList);
        recyclerView.setAdapter(customAdapter);


    }

    private void filter(String text) {

        ArrayList<String> filterNames =new ArrayList<>();
        for (String s : arrayList)
        {
            if(s.toLowerCase().contains(text.toLowerCase()))
            filterNames.add(s);
        }

        customAdapter.filterList(filterNames);

    }



}
