package com.example.chess57;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import com.example.chess57.saveobject.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Replay extends AppCompatActivity implements View.OnClickListener {

    public static saveArray loadedSave;
    private Button sortName;
    private Button sortDate;
    private static ListView list;
    private static ArrayList<saveArray> all_save;
    private static ArrayAdapter<saveArray> obs_list;
    private static boolean sortedByName;
    //private final ArrayAdapter<saveArray> obs_list = new ArrayAdapter<saveArray>(this,android.R.layout.select_dialog_multichoice);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replay);

        sortedByName = true;
        sortName = (Button) findViewById(R.id.sort_name);
        sortName.setOnClickListener(this);
        sortDate = (Button) findViewById(R.id.sort_date);
        sortDate.setOnClickListener(this);

        all_save = null;
        FileInputStream fis = null;
        try {
            fis = Replay.this.openFileInput("save.txt");
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


        list = (ListView) findViewById(R.id.list_view);
        Collections.sort(all_save);
        //final ArrayAdapter<saveArray> obs_list = new ArrayAdapter<saveArray>(this,android.R.layout.select_dialog_multichoice);
        obs_list = new ArrayAdapter<saveArray>(this,android.R.layout.select_dialog_multichoice);
        for(saveArray t:all_save) {
            obs_list.add(t);
        }
        list.setAdapter(obs_list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //System.out.println(obs_list.getItem(position));
                loadedSave = obs_list.getItem(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(Replay.this);
                builder.setCancelable(false);
                builder.setTitle("Options");
                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        all_save.remove(loadedSave);
                        obs_list.remove(loadedSave);

                        FileOutputStream fos = null;
                        try{
                            fos = Replay.this.openFileOutput("save.txt", Context.MODE_PRIVATE);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        ObjectOutputStream os;
                        try {
                            os = new ObjectOutputStream(fos);
                            os.writeObject(all_save);
                            os.close();
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(Replay.this, replay_chess.class));
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                /*
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setCancelable(true);
                builder.setTitle("Draw");
                builder.setMessage("Does the opponent accept the draw?");
                builder.setPositiveButton("Confirm",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // draw confirmed
                                text.setText("Draw");
                                end_game();
                            }
                        });
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // continue the game as usual
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
                break;
                 */
                //startActivity(new Intent(Replay.this, replay_chess.class));
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sort_name:
                Collections.sort(all_save);
                obs_list.clear();
                for(saveArray t:all_save) {
                    obs_list.add(t);
                }
                list.setAdapter(obs_list);
                sortedByName = true;
                break;

            case R.id.sort_date:
                Collections.sort(all_save, new Comparator<saveArray>() {
                    @Override
                    public int compare(saveArray o1, saveArray o2) {
                        return o1.getDate().compareTo(o2.getDate());
                    }
                });
                obs_list.clear();
                for(saveArray t:all_save) {
                    obs_list.add(t);
                }
                list.setAdapter(obs_list);
                sortedByName = false;
                break;
        }
    }

}
