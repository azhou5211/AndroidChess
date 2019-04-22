package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class play_chess extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_chess);

        ImageView imgView00 = (ImageView) findViewById(R.id.iv00);
        imgView00.setOnClickListener(this);
        ImageView imgView01 = (ImageView) findViewById(R.id.iv01);
        imgView01.setOnClickListener(this);
        ImageView imgView02 = (ImageView) findViewById(R.id.iv02);
        imgView02.setOnClickListener(this);
        ImageView imgView03 = (ImageView) findViewById(R.id.iv03);
        imgView03.setOnClickListener(this);
        ImageView imgView04 = (ImageView) findViewById(R.id.iv04);
        imgView04.setOnClickListener(this);
        ImageView imgView05 = (ImageView) findViewById(R.id.iv05);
        imgView05.setOnClickListener(this);
        ImageView imgView06 = (ImageView) findViewById(R.id.iv06);
        imgView06.setOnClickListener(this);
        ImageView imgView07 = (ImageView) findViewById(R.id.iv07);
        imgView07.setOnClickListener(this);
        ImageView imgView08 = (ImageView) findViewById(R.id.iv08);
        imgView08.setOnClickListener(this);

        ImageView imgView09 = (ImageView) findViewById(R.id.iv09);
        imgView09.setOnClickListener(this);
        ImageView imgView10 = (ImageView) findViewById(R.id.iv10);
        imgView10.setOnClickListener(this);
        ImageView imgView11 = (ImageView) findViewById(R.id.iv11);
        imgView11.setOnClickListener(this);
        ImageView imgView12 = (ImageView) findViewById(R.id.iv12);
        imgView12.setOnClickListener(this);
        ImageView imgView13 = (ImageView) findViewById(R.id.iv13);
        imgView13.setOnClickListener(this);
        ImageView imgView14 = (ImageView) findViewById(R.id.iv14);
        imgView14.setOnClickListener(this);
        ImageView imgView15 = (ImageView) findViewById(R.id.iv15);
        imgView15.setOnClickListener(this);
        ImageView imgView16 = (ImageView) findViewById(R.id.iv16);
        imgView16.setOnClickListener(this);

        ImageView imgView17 = (ImageView) findViewById(R.id.iv17);
        imgView17.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv00:
                System.out.println("test");
                break;

            case R.id.iv01:
                System.out.println("01 was clicked");
                break;

            case R.id.iv02:
                break;

            case R.id.iv03:
                break;

            case R.id.iv04:
                break;

            case R.id.iv05:
                break;

            case R.id.iv06:
                break;

            case R.id.iv07:
                break;

            case R.id.iv08:
                break;

            case R.id.iv09:
                break;

            case R.id.iv10:
                break;

            case R.id.iv11:
                break;

            case R.id.iv12:
                break;

            case R.id.iv13:
                break;

            case R.id.iv14:
                break;

            case R.id.iv15:
                break;

            case R.id.iv16:
                break;

            case R.id.iv17:
                break;
        }
    }
}
