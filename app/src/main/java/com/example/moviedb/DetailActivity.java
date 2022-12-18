package com.example.moviedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class DetailActivity extends AppCompatActivity {
    private final String TAG = "DetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String title =getIntent().getStringExtra("intent_title");
        String image =getIntent().getStringExtra("intent_image");
        getSupportActionBar().setTitle(title);
        Picasso.get()
                .load(image)
                .into((ImageView) findViewById(R.id.imageView));
    }
}