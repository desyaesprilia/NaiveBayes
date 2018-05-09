package com.example.coba.gejala.Article;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.coba.gejala.R;

import java.util.ArrayList;
import java.util.List;

public class Article extends AppCompatActivity {

    List<NyeriKepala> lstNyeriKepala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        lstNyeriKepala = new ArrayList<>();
        lstNyeriKepala.add(new NyeriKepala("Nyeri Kepala Migren", "Descripstion",R.drawable.migren));
        lstNyeriKepala.add(new NyeriKepala("Nyeri Kepala TTH", "Descripstion",R.drawable.tth));
        lstNyeriKepala.add(new NyeriKepala("Nyeri Kepala Klaster", "Descripstion",R.drawable.klaster));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, lstNyeriKepala);
        myrv.setLayoutManager(new GridLayoutManager(this,1 ));
        myrv.setAdapter(myAdapter);
    }
}
