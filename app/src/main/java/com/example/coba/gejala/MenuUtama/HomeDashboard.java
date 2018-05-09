package com.example.coba.gejala.MenuUtama;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import com.example.coba.gejala.Article.Article;
import com.example.coba.gejala.Detection.Deteksi;
import com.example.coba.gejala.Information.Info;
import com.example.coba.gejala.MapsActivity;
import com.example.coba.gejala.R;

public class HomeDashboard extends AppCompatActivity implements View.OnClickListener {
    private CardView articleCard, detectionCard, mapsCard, infoCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_dashboard);
        //defining cards
        articleCard = (CardView) findViewById(R.id.article_card);
        detectionCard = (CardView) findViewById(R.id.detection_card);
        mapsCard = (CardView) findViewById(R.id.maps_card);
        infoCard = (CardView) findViewById(R.id.info_card);
        //add onclicklistener to the cards
        articleCard.setOnClickListener(this);
        detectionCard.setOnClickListener(this);
        mapsCard.setOnClickListener(this);
        infoCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()) {
            case R.id.article_card : i = new Intent(this, Article.class);
//                int converted_durasi = _convert_durasi(durasi);
//                if (converted_durasi == -1) {
                    // kasi pesan error
//                    Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
//                }
//                else
                    startActivity(i);
            break;

            case R.id.detection_card : i = new Intent(this, Deteksi.class);
            startActivity(i);
            break;

            case R.id.maps_card : i = new Intent(this, MapsActivity.class);
            startActivity(i);
            break;

            case R.id.info_card : i = new Intent(this, Info.class);
            startActivity(i);
            break;

            default:break;

        }

    }
}
