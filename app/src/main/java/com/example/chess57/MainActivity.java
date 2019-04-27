package com.example.chess57;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.chess57.saveobject.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button play_Button;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play_Button = (Button) findViewById(R.id.play_button);
        play_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,play_chess.class));
            }
        });

        save = (Button) findViewById(R.id.viewSave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Replay.class));



                /*
                ArrayList<saveArray> all_save = null;
                FileInputStream fis = null;
                try {
                    fis = MainActivity.this.openFileInput("save.txt");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    ObjectInputStream is = new ObjectInputStream(fis);
                    try {
                        all_save = (ArrayList<saveArray>) is.readObject();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    is.close();
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //System.out.println(all_save.get(0));
                //ArrayList<saveObject2> asdf = all_save.get(0).getHistory();
                //System.out.println(all_save.size());
                int i;
                for(i=0;i<all_save.size();i++) {
                    System.out.println(all_save.get(i));
                }
                */
            }
        });

    }
}
