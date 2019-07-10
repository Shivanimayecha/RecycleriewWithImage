package com.example.recycleriewwithimage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    ImageView imageView ;
    TextView textView;
    private Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView = (ImageView)findViewById(R.id.imgPlace);
        textView = (TextView)findViewById(R.id.txt_place);


       // Toast.makeText(this, "hiiii", Toast.LENGTH_SHORT).show();

        Intent intent = getIntent();
        String name = intent.getStringExtra("Place");
        textView.setText(name);

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null) {
            int image = bundle.getInt("Image");
            imageView.setImageResource(image);


        }


    }
}
