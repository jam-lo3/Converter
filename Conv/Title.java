package com.example.jamie.converter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.Button;

public class Title extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_title);
    }

    public void onButtonClickN(View v)
    {
        Intent i = new Intent(Title.this, numBitContent.class);
        startActivity(i);

    }

    public void onButtonClickM(View v)
    {
        Intent i = new Intent(Title.this, measureContent.class);
        startActivity(i);
    }

}
