package com.example.foad.shortstories;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MoonActivity extends AppCompatActivity {

    ImageView moonImageView1;
    ImageView moonImageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moon);

        moonImageView1 = findViewById(R.id.moonImg1);
        moonImageView2 = findViewById(R.id.moonImg2);

        Glide
                .with(MoonActivity.this)
                .load(R.drawable.moon1)
                .into(moonImageView1);
        Glide
                .with(MoonActivity.this)
                .load(R.drawable.moon2)
                .into(moonImageView2);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
