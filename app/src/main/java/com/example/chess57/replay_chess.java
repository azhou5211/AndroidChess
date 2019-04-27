package com.example.chess57;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import com.example.chess57.saveobject.*;

public class replay_chess extends AppCompatActivity implements View.OnClickListener {


    private Button back;
    private Button forward;
    private static int increment;
    private static ArrayList<saveObject2> history;
    private static ArrayList<saveObject> temp_history;
    private static ArrayList<ImageView> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replay_chess);

        back = (Button) findViewById(R.id.back_play);
        back.setOnClickListener(replay_chess.this);
        forward = (Button) findViewById(R.id.forward_play);
        forward.setOnClickListener(this);
        increment = 0;
        temp_history = new ArrayList<>();
        images = new ArrayList<>();

        saveArray save = Replay.loadedSave;
        history = save.getHistory();

        ImageView imgView00 = (ImageView) findViewById(R.id.iv00);
        ImageView imgView01 = (ImageView) findViewById(R.id.iv01);
        ImageView imgView02 = (ImageView) findViewById(R.id.iv02);
        ImageView imgView03 = (ImageView) findViewById(R.id.iv03);
        ImageView imgView04 = (ImageView) findViewById(R.id.iv04);
        ImageView imgView05 = (ImageView) findViewById(R.id.iv05);
        ImageView imgView06 = (ImageView) findViewById(R.id.iv06);
        ImageView imgView07 = (ImageView) findViewById(R.id.iv07);

        ImageView imgView08 = (ImageView) findViewById(R.id.iv08);
        ImageView imgView09 = (ImageView) findViewById(R.id.iv09);
        ImageView imgView10 = (ImageView) findViewById(R.id.iv10);
        ImageView imgView11 = (ImageView) findViewById(R.id.iv11);
        ImageView imgView12 = (ImageView) findViewById(R.id.iv12);
        ImageView imgView13 = (ImageView) findViewById(R.id.iv13);
        ImageView imgView14 = (ImageView) findViewById(R.id.iv14);
        ImageView imgView15 = (ImageView) findViewById(R.id.iv15);

        ImageView imgView16 = (ImageView) findViewById(R.id.iv16);
        ImageView imgView17 = (ImageView) findViewById(R.id.iv17);
        ImageView imgView18 = (ImageView) findViewById(R.id.iv18);
        ImageView imgView19 = (ImageView) findViewById(R.id.iv19);
        ImageView imgView20 = (ImageView) findViewById(R.id.iv20);
        ImageView imgView21 = (ImageView) findViewById(R.id.iv21);
        ImageView imgView22 = (ImageView) findViewById(R.id.iv22);
        ImageView imgView23 = (ImageView) findViewById(R.id.iv23);

        ImageView imgView24 = (ImageView) findViewById(R.id.iv24);
        ImageView imgView25 = (ImageView) findViewById(R.id.iv25);
        ImageView imgView26 = (ImageView) findViewById(R.id.iv26);
        ImageView imgView27 = (ImageView) findViewById(R.id.iv27);
        ImageView imgView28 = (ImageView) findViewById(R.id.iv28);
        ImageView imgView29 = (ImageView) findViewById(R.id.iv29);
        ImageView imgView30 = (ImageView) findViewById(R.id.iv30);
        ImageView imgView31 = (ImageView) findViewById(R.id.iv31);

        ImageView imgView32 = (ImageView) findViewById(R.id.iv32);
        ImageView imgView33 = (ImageView) findViewById(R.id.iv33);
        ImageView imgView34 = (ImageView) findViewById(R.id.iv34);
        ImageView imgView35 = (ImageView) findViewById(R.id.iv35);
        ImageView imgView36 = (ImageView) findViewById(R.id.iv36);
        ImageView imgView37 = (ImageView) findViewById(R.id.iv37);
        ImageView imgView38 = (ImageView) findViewById(R.id.iv38);
        ImageView imgView39 = (ImageView) findViewById(R.id.iv39);

        ImageView imgView40 = (ImageView) findViewById(R.id.iv40);
        ImageView imgView41 = (ImageView) findViewById(R.id.iv41);
        ImageView imgView42 = (ImageView) findViewById(R.id.iv42);
        ImageView imgView43 = (ImageView) findViewById(R.id.iv43);
        ImageView imgView44 = (ImageView) findViewById(R.id.iv44);
        ImageView imgView45 = (ImageView) findViewById(R.id.iv45);
        ImageView imgView46 = (ImageView) findViewById(R.id.iv46);
        ImageView imgView47 = (ImageView) findViewById(R.id.iv47);

        ImageView imgView48 = (ImageView) findViewById(R.id.iv48);
        ImageView imgView49 = (ImageView) findViewById(R.id.iv49);
        ImageView imgView50 = (ImageView) findViewById(R.id.iv50);
        ImageView imgView51 = (ImageView) findViewById(R.id.iv51);
        ImageView imgView52 = (ImageView) findViewById(R.id.iv52);
        ImageView imgView53 = (ImageView) findViewById(R.id.iv53);
        ImageView imgView54 = (ImageView) findViewById(R.id.iv54);
        ImageView imgView55 = (ImageView) findViewById(R.id.iv55);

        ImageView imgView56 = (ImageView) findViewById(R.id.iv56);
        ImageView imgView57 = (ImageView) findViewById(R.id.iv57);
        ImageView imgView58 = (ImageView) findViewById(R.id.iv58);
        ImageView imgView59 = (ImageView) findViewById(R.id.iv59);
        ImageView imgView60 = (ImageView) findViewById(R.id.iv60);
        ImageView imgView61 = (ImageView) findViewById(R.id.iv61);
        ImageView imgView62 = (ImageView) findViewById(R.id.iv62);
        ImageView imgView63 = (ImageView) findViewById(R.id.iv63);

        images.add(imgView00);
        images.add(imgView01);
        images.add(imgView02);
        images.add(imgView03);
        images.add(imgView04);
        images.add(imgView05);
        images.add(imgView06);
        images.add(imgView07);
        images.add(imgView08);
        images.add(imgView09);
        images.add(imgView10);
        images.add(imgView11);
        images.add(imgView12);
        images.add(imgView13);
        images.add(imgView14);
        images.add(imgView15);
        images.add(imgView16);
        images.add(imgView17);
        images.add(imgView18);
        images.add(imgView19);
        images.add(imgView20);
        images.add(imgView21);
        images.add(imgView22);
        images.add(imgView23);
        images.add(imgView24);
        images.add(imgView25);
        images.add(imgView26);
        images.add(imgView27);
        images.add(imgView28);
        images.add(imgView29);
        images.add(imgView30);
        images.add(imgView31);
        images.add(imgView32);
        images.add(imgView33);
        images.add(imgView34);
        images.add(imgView35);
        images.add(imgView36);
        images.add(imgView37);
        images.add(imgView38);
        images.add(imgView39);
        images.add(imgView40);
        images.add(imgView41);
        images.add(imgView42);
        images.add(imgView43);
        images.add(imgView44);
        images.add(imgView45);
        images.add(imgView46);
        images.add(imgView47);
        images.add(imgView48);
        images.add(imgView49);
        images.add(imgView50);
        images.add(imgView51);
        images.add(imgView52);
        images.add(imgView53);
        images.add(imgView54);
        images.add(imgView55);
        images.add(imgView56);
        images.add(imgView57);
        images.add(imgView58);
        images.add(imgView59);
        images.add(imgView60);
        images.add(imgView61);
        images.add(imgView62);
        images.add(imgView63);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_play:
                if(increment-1>=0) {
                    increment--;
                    saveObject2 t = history.get(increment);
                    saveObject draws = temp_history.get(increment);
                    temp_history.remove(increment);
                    ImageView temporary_image1 = images.get(t.initial_location);
                    ImageView temporary_image2 = images.get(t.final_location);
                    temporary_image1.setImageDrawable(draws.initial_draw);
                    temporary_image2.setImageDrawable(draws.final_draw);

                }
                break;

            case R.id.forward_play:
                if(increment<history.size()) {
                    saveObject2 t = history.get(increment);
                    ImageView temporary_image1 = images.get(t.initial_location);
                    ImageView temporary_image2 = images.get(t.final_location);
                    temp_history.add(new saveObject(temporary_image1.getDrawable(),temporary_image2.getDrawable()));
                    temporary_image2.setImageDrawable(temporary_image1.getDrawable());
                    temporary_image1.setImageResource(R.drawable.transparent);
                    increment++;
                }
                break;
        }
    }
}
