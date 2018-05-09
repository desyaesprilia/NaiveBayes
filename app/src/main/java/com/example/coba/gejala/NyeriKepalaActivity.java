package com.example.coba.gejala;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NyeriKepalaActivity extends AppCompatActivity {

    private TextView tvtitle, tvdescription;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nyeri_kepala);

        tvtitle = (TextView) findViewById(R.id.txtjudul);
        tvdescription = (TextView) findViewById(R.id.txtdescription);
        img = (ImageView) findViewById(R.id.thumbnail_id);


        //Recieve Data
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("JudulNyeriKepala");
        String Description = intent.getExtras().getString("Description");
        int  image = intent.getExtras().getInt("Thumbnail");

        //Setting Value
        tvtitle.setText(Title);
        tvdescription.setText(Description);
        img.setImageResource(image);
    }
}
