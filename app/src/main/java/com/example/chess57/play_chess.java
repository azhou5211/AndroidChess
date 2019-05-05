package com.example.chess57;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import com.example.chess57.chesspieces.*;
import com.example.chess57.saveobject.*;

public class play_chess extends AppCompatActivity implements View.OnClickListener {


    public static Node[] board = new Node[64];
    public static ArrayList<String> moveHistory = new ArrayList<>();
    public static Piece whiteKing;
    public static Piece blackKing;
    private static boolean whiteChecked;
    private static boolean blackChecked;
    private static boolean whiteTurn;
    private static int initial_location;
    private static int final_location;
    private static String str_initial_location;
    private static String str_final_location;
    private static ArrayList<ImageView> images;
    private static ArrayList<saveObject> android_history;
    private static ArrayList<saveObject2> Saving_history;
    private static ImageView lastImage;
    private static TextView text;
    private static Button undo;
    private static Button ai;
    private static Button draw;
    private static Button resign;
    public static Context myContext;
    private static LayoutInflater inflater;
    //private static String save_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_chess);


        Node.initialize(board);
        whiteTurn = true;
        whiteKing = board[7*8+4].piece;
        blackKing = board[0*8+4].piece;
        whiteChecked = false;
        blackChecked = false;
        str_initial_location = "";
        str_final_location = "";
        initial_location = -1;
        final_location = -1;
        Node.print(board);
        myContext = play_chess.this;
        inflater = play_chess.this.getLayoutInflater();

        text = (TextView) findViewById(R.id.textView1);

        images = new ArrayList<ImageView>();
        android_history = new ArrayList<saveObject>();
        Saving_history = new ArrayList<>();

        undo = (Button) findViewById(R.id.undo);
        undo.setOnClickListener(this);
        ai = (Button) findViewById(R.id.ai);
        ai.setOnClickListener(this);
        draw = (Button) findViewById(R.id.draw);
        draw.setOnClickListener(this);
        resign = (Button) findViewById(R.id.resign);
        resign.setOnClickListener(this);
        Button new_game = (Button) findViewById(R.id.new_game);
        new_game.setOnClickListener(this);
        Button save_game = (Button) findViewById(R.id.save_game);
        save_game.setOnClickListener(this);

        ImageView imgView00 = (ImageView) findViewById(R.id.iv00);
        //imgView00.setBackgroundColor(Color.RED);
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
        ImageView imgView18 = (ImageView) findViewById(R.id.iv18);
        imgView18.setOnClickListener(this);
        ImageView imgView19 = (ImageView) findViewById(R.id.iv19);
        imgView19.setOnClickListener(this);
        ImageView imgView20 = (ImageView) findViewById(R.id.iv20);
        imgView20.setOnClickListener(this);
        ImageView imgView21 = (ImageView) findViewById(R.id.iv21);
        imgView21.setOnClickListener(this);
        ImageView imgView22 = (ImageView) findViewById(R.id.iv22);
        imgView22.setOnClickListener(this);
        ImageView imgView23 = (ImageView) findViewById(R.id.iv23);
        imgView23.setOnClickListener(this);

        ImageView imgView24 = (ImageView) findViewById(R.id.iv24);
        imgView24.setOnClickListener(this);
        ImageView imgView25 = (ImageView) findViewById(R.id.iv25);
        imgView25.setOnClickListener(this);
        ImageView imgView26 = (ImageView) findViewById(R.id.iv26);
        imgView26.setOnClickListener(this);
        ImageView imgView27 = (ImageView) findViewById(R.id.iv27);
        imgView27.setOnClickListener(this);
        ImageView imgView28 = (ImageView) findViewById(R.id.iv28);
        imgView28.setOnClickListener(this);
        ImageView imgView29 = (ImageView) findViewById(R.id.iv29);
        imgView29.setOnClickListener(this);
        ImageView imgView30 = (ImageView) findViewById(R.id.iv30);
        imgView30.setOnClickListener(this);
        ImageView imgView31 = (ImageView) findViewById(R.id.iv31);
        imgView31.setOnClickListener(this);

        ImageView imgView32 = (ImageView) findViewById(R.id.iv32);
        imgView32.setOnClickListener(this);
        ImageView imgView33 = (ImageView) findViewById(R.id.iv33);
        imgView33.setOnClickListener(this);
        ImageView imgView34 = (ImageView) findViewById(R.id.iv34);
        imgView34.setOnClickListener(this);
        ImageView imgView35 = (ImageView) findViewById(R.id.iv35);
        imgView35.setOnClickListener(this);
        ImageView imgView36 = (ImageView) findViewById(R.id.iv36);
        imgView36.setOnClickListener(this);
        ImageView imgView37 = (ImageView) findViewById(R.id.iv37);
        imgView37.setOnClickListener(this);
        ImageView imgView38 = (ImageView) findViewById(R.id.iv38);
        imgView38.setOnClickListener(this);
        ImageView imgView39 = (ImageView) findViewById(R.id.iv39);
        imgView39.setOnClickListener(this);

        ImageView imgView40 = (ImageView) findViewById(R.id.iv40);
        imgView40.setOnClickListener(this);
        ImageView imgView41 = (ImageView) findViewById(R.id.iv41);
        imgView41.setOnClickListener(this);
        ImageView imgView42 = (ImageView) findViewById(R.id.iv42);
        imgView42.setOnClickListener(this);
        ImageView imgView43 = (ImageView) findViewById(R.id.iv43);
        imgView43.setOnClickListener(this);
        ImageView imgView44 = (ImageView) findViewById(R.id.iv44);
        imgView44.setOnClickListener(this);
        ImageView imgView45 = (ImageView) findViewById(R.id.iv45);
        imgView45.setOnClickListener(this);
        ImageView imgView46 = (ImageView) findViewById(R.id.iv46);
        imgView46.setOnClickListener(this);
        ImageView imgView47 = (ImageView) findViewById(R.id.iv47);
        imgView47.setOnClickListener(this);

        ImageView imgView48 = (ImageView) findViewById(R.id.iv48);
        imgView48.setOnClickListener(this);
        ImageView imgView49 = (ImageView) findViewById(R.id.iv49);
        imgView49.setOnClickListener(this);
        ImageView imgView50 = (ImageView) findViewById(R.id.iv50);
        imgView50.setOnClickListener(this);
        ImageView imgView51 = (ImageView) findViewById(R.id.iv51);
        imgView51.setOnClickListener(this);
        ImageView imgView52 = (ImageView) findViewById(R.id.iv52);
        imgView52.setOnClickListener(this);
        ImageView imgView53 = (ImageView) findViewById(R.id.iv53);
        imgView53.setOnClickListener(this);
        ImageView imgView54 = (ImageView) findViewById(R.id.iv54);
        imgView54.setOnClickListener(this);
        ImageView imgView55 = (ImageView) findViewById(R.id.iv55);
        imgView55.setOnClickListener(this);

        ImageView imgView56 = (ImageView) findViewById(R.id.iv56);
        imgView56.setOnClickListener(this);
        ImageView imgView57 = (ImageView) findViewById(R.id.iv57);
        imgView57.setOnClickListener(this);
        ImageView imgView58 = (ImageView) findViewById(R.id.iv58);
        imgView58.setOnClickListener(this);
        ImageView imgView59 = (ImageView) findViewById(R.id.iv59);
        imgView59.setOnClickListener(this);
        ImageView imgView60 = (ImageView) findViewById(R.id.iv60);
        imgView60.setOnClickListener(this);
        ImageView imgView61 = (ImageView) findViewById(R.id.iv61);
        imgView61.setOnClickListener(this);
        ImageView imgView62 = (ImageView) findViewById(R.id.iv62);
        imgView62.setOnClickListener(this);
        ImageView imgView63 = (ImageView) findViewById(R.id.iv63);
        imgView63.setOnClickListener(this);

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
        int index;
        String fileRank;
        switch (v.getId()) {
            case R.id.iv00:
                index = 0;
                fileRank = "a8";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv01:
                index = 1;
                fileRank = "b8";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv02:
                index = 2;
                fileRank = "c8";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv03:
                index = 3;
                fileRank = "d8";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv04:
                index = 4;
                fileRank = "e8";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv05:
                index = 5;
                fileRank = "f8";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv06:
                index = 6;
                fileRank = "g8";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv07:
                index = 7;
                fileRank = "h8";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv08:
                index = 8;
                fileRank = "a7";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv09:
                index = 9;
                fileRank = "b7";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv10:
                index = 10;
                fileRank = "c7";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv11:
                index = 11;
                fileRank = "d7";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv12:
                index = 12;
                fileRank = "e7";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv13:
                index = 13;
                fileRank = "f7";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv14:
                index = 14;
                fileRank = "g7";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv15:
                index = 15;
                fileRank = "h7";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv16:
                index = 16;
                fileRank = "a6";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv17:
                index = 17;
                fileRank = "b6";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv18:
                index = 18;
                fileRank = "c6";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv19:
                index = 19;
                fileRank = "d6";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv20:
                index = 20;
                fileRank = "e6";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv21:
                index = 21;
                fileRank = "f6";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv22:
                index = 22;
                fileRank = "g6";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv23:
                index = 23;
                fileRank = "h6";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv24:
                index = 24;
                fileRank = "a5";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv25:
                index = 25;
                fileRank = "b5";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv26:
                index = 26;
                fileRank = "c5";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv27:
                index = 27;
                fileRank = "d5";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv28:
                index = 28;
                fileRank = "e5";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv29:
                index = 29;
                fileRank = "f5";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv30:
                index = 30;
                fileRank = "g5";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv31:
                index = 31;
                fileRank = "h5";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv32:
                index = 32;
                fileRank = "a4";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv33:
                index = 33;
                fileRank = "b4";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv34:
                index = 34;
                fileRank = "c4";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv35:
                index = 35;
                fileRank = "d4";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv36:
                index = 36;
                fileRank = "e4";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv37:
                index = 37;
                fileRank = "f4";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv38:
                index = 38;
                fileRank = "g4";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv39:
                index = 39;
                fileRank = "h4";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv40:
                index = 40;
                fileRank = "a3";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv41:
                index = 41;
                fileRank = "b3";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv42:
                index = 42;
                fileRank = "c3";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv43:
                index = 43;
                fileRank = "d3";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv44:
                index = 44;
                fileRank = "e3";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv45:
                index = 45;
                fileRank = "f3";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv46:
                index = 46;
                fileRank = "g3";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv47:
                index = 47;
                fileRank = "h3";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv48:
                index = 48;
                fileRank = "a2";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv49:
                index = 49;
                fileRank = "b2";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv50:
                index = 50;
                fileRank = "c2";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv51:
                index = 51;
                fileRank = "d2";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv52:
                index = 52;
                fileRank = "e2";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv53:
                index = 53;
                fileRank = "f2";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv54:
                index = 54;
                fileRank = "g2";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv55:
                index = 55;
                fileRank = "h2";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv56:
                index = 56;
                fileRank = "a1";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv57:
                index = 57;
                fileRank = "b1";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv58:
                index = 58;
                fileRank = "c1";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv59:
                index = 59;
                fileRank = "d1";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv60:
                index = 60;
                fileRank = "e1";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv61:
                index = 61;
                fileRank = "f1";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv62:
                index = 62;
                fileRank = "g1";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.iv63:
                index = 63;
                fileRank = "h1";
                if(str_initial_location.length()==0) {
                    initial_location = index;
                    str_initial_location = fileRank;
                    lastImage = images.get(index);
                    lastImage.setBackgroundColor(Color.RED);
                } else if(str_initial_location.equals(fileRank)) {
                    initial_location = -1;
                    str_initial_location = "";
                    lastImage.setBackgroundColor(00000000);
                } else {
                    final_location = index;
                    str_final_location = fileRank;
                    if(whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }
                break;

            case R.id.undo:
                int size = android_history.size();
                if(size==0) {
                    break;
                }
                saveObject s = android_history.get(size-1);
                android_history.remove(size-1);
                saveObject2 s2 = Saving_history.get(size-1);
                Saving_history.remove(size-1);
                undo_move(s);
                undo.setEnabled(false);
                break;

            case R.id.ai:
                String player;
                if(whiteTurn) {
                    player = "w";
                } else {
                    player = "b";
                }
                boolean existing_moves = false;
                ArrayList<saveObject> all_moves = new ArrayList<>();
                for(int i=0;i<64;i++) {
                    if(!board[i].gridEmpty) {
                        if(board[i].piece.player.equals(player)) {
                            ArrayList<Integer> moveList = board[i].piece.getMoveList(board[i].piece.startIndex, player, board);
                            for(int move: moveList) {
                                if(!Piece.executeMoveKingChecked(board, board[i].piece.startIndex, move, player)) {
                                    existing_moves = true;
                                    //System.out.println("initial location " + convert_to_string(i));
                                    //System.out.println("ending location " + convert_to_string(move));
                                    saveObject temp_move = new saveObject(convert_to_string(i),convert_to_string(move),i,move);
                                    all_moves.add(temp_move);
                                }
                            }
                        }
                    }
                }

                if(existing_moves) {
                    Random rand = new Random();
                    int random_number = rand.nextInt(all_moves.size());
                    //System.out.println("random number: " + random_number);
                    saveObject get_move = all_moves.get(random_number);
                    if(!str_initial_location.equals("")) {
                        lastImage = images.get(initial_location);
                    } else {
                        lastImage = images.get(0);
                    }
                    str_initial_location = get_move.str_initial_location;
                    str_final_location = get_move.str_final_location;
                    initial_location = get_move.initial_location;
                    final_location = get_move.final_location;
                    //System.out.println(get_move.str_final_location);
                    //System.out.println(str_final_location);
                    if (whiteTurn) {
                        whiteMove();
                    } else {
                        blackMove();
                    }
                }

                break;

            case R.id.draw:
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

            case R.id.resign:
                if(whiteTurn) {
                    text.setText("Black Wins!");
                } else {
                    text.setText("White Wins");
                }
                end_game();
                break;

            case R.id.new_game:
                Intent intent = getIntent();
                finish();
                startActivity(intent);
                break;

            case R.id.save_game:
                save_game();
                break;
        }
    }

    public static void whiteMove() {
        Piece initial_piece = board[initial_location].piece.duplicate();
        Piece final_piece = board[final_location].piece.duplicate();
        if(board[initial_location].piece.move(str_final_location, "w", board,moveHistory)==false) {
            // Invalid move
            //validMove = false;
            //text.setText("Illegal Move, try again! White's Turn");
            getNewMove("w");
        } else {

            // valid move
            undo.setEnabled(true);
            // add into the android movehistory
            lastImage.setBackgroundColor(0);
            ImageView temporary_image1 = images.get(initial_location);
            ImageView temporary_image2 = images.get(final_location);

            saveObject s = new saveObject(str_initial_location, str_final_location, initial_location, final_location, temporary_image1.getDrawable(), temporary_image2.getDrawable(), initial_piece, final_piece);
            android_history.add(s);
            Saving_history.add(new saveObject2(str_initial_location,str_final_location,initial_location,final_location,initial_piece,final_piece));

            temporary_image2.setImageDrawable(temporary_image1.getDrawable());
            temporary_image1.setImageResource(R.drawable.transparent);

            initial_location = -1;
            str_initial_location = "";
            invert_player();

            check_pawn_promotion();

            blackChecked = false;
            boolean game_over = false;
            if (King.isPositionChecked(board, blackKing.startIndex, "b")) {
                if (isCheckmate("b")) {
                    text.setText("Checkmate. White Wins");
                    game_over = true;
                    end_game();
                } else {
                    blackChecked = true;
                }
            } else {
                if (isCheckmate("b")) {
                    text.setText("Stalemate. Draw");
                    game_over = true;
                    end_game();
                }
            }
            if(game_over==false) {
                if (blackChecked) {
                    text.setText("Checked. Black's Turn");
                } else {
                    text.setText("Black's Turn");
                }
            }
            Node.print(board);

        }
    }

    public static void blackMove() {
        Piece initial_piece = board[initial_location].piece.duplicate();
        Piece final_piece = board[final_location].piece.duplicate();
        if(board[initial_location].piece.move(str_final_location, "b", board,moveHistory)==false) {
            //invalid move
            //validMove = false;
            //text.setText("Illegal Move, try again! Black's Turn");
            getNewMove("b");
        } else {
            undo.setEnabled(true);

            lastImage.setBackgroundColor(0);
            ImageView temporary_image1 = images.get(initial_location);
            ImageView temporary_image2 = images.get(final_location);

            saveObject s = new saveObject(str_initial_location, str_final_location, initial_location, final_location, temporary_image1.getDrawable(), temporary_image2.getDrawable(), initial_piece, final_piece);
            android_history.add(s);
            Saving_history.add(new saveObject2(str_initial_location,str_final_location,initial_location,final_location,initial_piece,final_piece));

            temporary_image2.setImageDrawable(temporary_image1.getDrawable());
            temporary_image1.setImageResource(R.drawable.transparent);
            //Drawable d1 = temporary_image1.getDrawable();
            //temporary_image1.setImageDrawable(temporary_image2.getDrawable());
            //temporary_image2.setImageDrawable(d1);
            initial_location = -1;
            str_initial_location = "";
            invert_player();

            check_pawn_promotion();

            whiteChecked = false;
            boolean game_over = false;
            if (King.isPositionChecked(board, whiteKing.startIndex, "w")) {
                // Check for checkmate
                if (isCheckmate("w")) {
                    text.setText("Checkmate. White Wins");
                    game_over = true;
                    end_game();
                } else {
                    whiteChecked = true;
                }
            } else {
                // check for stalemate
                if (isCheckmate("w")) {
                    end_game();
                    game_over = true;
                    text.setText("Stalemate. Draw");
                }
            }
            if(game_over==false) {
                if (whiteChecked) {
                    text.setText("Checked. White's Turn");
                } else {
                    text.setText("White's Turn");
                }
            }
            Node.print(board);
        }
    }

    private static void getNewMove(String player) {
        if(player.equals("w")) {
            text.setText("Illegal Move, try again! White's Turn");
            //if(board[initial_location].piece.move(str_final_location, "w", board,moveHistory)==false) {
                //getNewMove("w");
            //}
        } else {
            text.setText("Illegal Move, try again! Black's Turn");
            //if(board[initial_location].piece.move(str_final_location, "b", board,moveHistory)==false) {
                //getNewMove("b");
            //}
        }
    }

    private static boolean isCheckmate(String player) {
        for(int i=0;i<64;i++) {
            if(!board[i].gridEmpty) {
                if(board[i].piece.player.equals(player)) {
                    ArrayList<Integer> moveList = board[i].piece.getMoveList(board[i].piece.startIndex, player, board);
                    for(int move: moveList) {
                        if(!Piece.executeMoveKingChecked(board, board[i].piece.startIndex, move, player)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private static void invert_player() {
        if(whiteTurn==true) {
            whiteTurn = false;
        } else {
            whiteTurn = true;
        }
    }

    private static void end_game() {
        for(ImageView i: images) {
            i.setEnabled(false);
        }
        undo.setEnabled(false);
        ai.setEnabled(false);
        draw.setEnabled(false);
        resign.setEnabled(false);
        save_game();
    }

    private static void undo_move(saveObject s) {
        ImageView temporary_image1 = images.get(s.initial_location);
        ImageView temporary_image2 = images.get(s.final_location);
        temporary_image1.setImageDrawable(s.initial_draw);
        temporary_image2.setImageDrawable(s.final_draw);

        board[s.initial_location].gridEmpty = false;
        if(s.final_piece instanceof Default) {
            board[s.final_location].gridEmpty = true;
        } else {
            board[s.final_location].gridEmpty = false;
        }

        //board[s.final_location].piece.startIndex = s.initial_location;
        board[s.initial_location].piece = s.initial_piece;
        board[s.initial_location].piece.startIndex = s.initial_location;
        board[s.final_location].piece = s.final_piece;
        board[s.final_location].piece.startIndex = s.final_location;

        /*
        board[s.final_location].piece.startIndex = s.initial_location;
        board[s.initial_location].piece = board[s.final_location].piece;
        board[s.final_location].piece = s.final_piece;
        board[s.final_location].piece.startIndex = s.final_location;
        */

        if(whiteTurn) {
            text.setText("Black's Turn");
        } else {
            text.setText("White's Turn");
        }
        invert_player();
        Node.print(board);
    }

    private static void check_pawn_promotion() {
        int i;
        for(i=0;i<8;i++) {
            if(board[i].piece instanceof Pawn) {
                if(board[i].piece.player.equals("w")) {
                    // Need dialog for pawn promotion
                    //System.out.println("White Pawn Promotion Needed");
                    //play_chess.pawn_promotion();
                    pawn_promotion();
                    if(pawnPromotion.equals("") || pawnPromotion.equals("Queen")) {
                        board[i].piece = new Queen("w", i);
                        images.get(i).setImageResource(R.drawable.white_queen);
                    } else if(pawnPromotion.equals("Rook")) {
                        board[i].piece = new Rook("w", i);
                        images.get(i).setImageResource(R.drawable.white_rook);
                    } else if(pawnPromotion.equals("Bishop")) {
                        board[i].piece = new Bishop("w", i);
                        images.get(i).setImageResource(R.drawable.white_bishop);
                    } else if(pawnPromotion.equals("Knight")) {
                        board[i].piece = new Knight("w", i);
                        images.get(i).setImageResource(R.drawable.white_knight);
                    }
                }
            }
        }
        for(i=56;i<64;i++) {
            if(board[i].piece instanceof Pawn) {
                if(board[i].piece.player.equals("b")) {
                    // Need dialog for pawn promotion
                    //System.out.println("Black Pawn Promotion Needed");
                    pawn_promotion();
                    if(pawnPromotion.equals("") || pawnPromotion.equals("Queen")) {
                        board[i].piece = new Queen("b", i);
                        images.get(i).setImageResource(R.drawable.black_queen);
                    } else if(pawnPromotion.equals("Rook")) {
                        board[i].piece = new Rook("b", i);
                        images.get(i).setImageResource(R.drawable.black_rook);
                    } else if(pawnPromotion.equals("Bishop")) {
                        board[i].piece = new Bishop("b", i);
                        images.get(i).setImageResource(R.drawable.black_bishop);
                    } else if(pawnPromotion.equals("Knight")) {
                        board[i].piece = new Knight("b", i);
                        images.get(i).setImageResource(R.drawable.black_knight);
                    }
                }
            }
        }
        pawnPromotion = "";
    }

    private static String pawnPromotion = "";

    private static void pawn_promotion() {
        AlertDialog.Builder builder = new AlertDialog.Builder(myContext);
        builder.setCancelable(false);
        builder.setTitle("Pawn Promotion");
        //builder.

        /*
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(myContext, android.R.layout.select_dialog_singlechoice);
        arrayAdapter.add("Queen");
        arrayAdapter.add("Rook");
        arrayAdapter.add("Bishop");
        arrayAdapter.add("Knight");
        */

        final String[] arrayAdapter = {"Queen", "Rook", "Bishop", "Knight"};

        builder.setItems(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //System.out.println(which);
                pawnPromotion = arrayAdapter[which];
                //pawnPromotion = arrayAdapter.getItem(which);
                //System.out.println(pawnPromotion);
            }
        });

        builder.show();
    }

    private static void save_game() {

        AlertDialog.Builder builder = new AlertDialog.Builder(myContext);
        builder.setCancelable(false);
        builder.setTitle("Save");
        builder.setMessage("Save File Name:");
        View view = inflater.inflate(R.layout.save_dialog,null);
        final EditText save_name2 = (EditText) view.findViewById(R.id.save_name);
        builder.setView(view).setPositiveButton("Confirm",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        ArrayList<saveArray> all_save = null;
                        FileInputStream fis = null;
                        try {
                            fis = myContext.openFileInput("save.txt");
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


                        //ArrayList<saveArray> all_save = new ArrayList<>();
                        String save_name = save_name2.getText().toString();
                        saveArray new_save = new saveArray(Saving_history, save_name);

                        all_save.add(new_save);
                        //Collections.sort(all_save);
                        FileOutputStream fos = null;
                        try{
                            //myContext.openFileOutput("",Context.)
                            fos = myContext.openFileOutput("save.txt",Context.MODE_PRIVATE);
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


                        /*
                        FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
                        ObjectOutputStream os = new ObjectOutputStream(fos);
                        os.writeObject(this);
                        os.close();
                        fos.close();
                         */


                        //com.example.chess57.chesspieces.*
                        //FileInputStream fos = new FileInputStream("com.example.chess57.saveFiles.save.txt");
                        //ObjectInputStream oos = new ObjectInputStream(fos);
                        //listOfUsers = (ArrayList<User>) oos.readObject();
                        //oos.close();


                        //System.out.println(save_name);
                        //System.out.println(save_name2.getText());
                        //save_name = save_name2.getText();
                    }
                }
        ).setNegativeButton("cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }
        );


        builder.show();
    }

    private static String convert_to_string(int location) {
        int row = (int) Math.floor(location/8);
        int col = location%8;
        String temp = "";
        if(col==0) {
            temp = "a";
        } else if(col==1) {
            temp = "b";
        } else if(col==2) {
            temp = "c";
        } else if(col==3) {
            temp = "d";
        } else if(col==4) {
            temp = "e";
        } else if(col==5) {
            temp = "f";
        } else if(col==6) {
            temp = "g";
        } else if(col==7) {
            temp = "h";
        }
        return temp.concat(Integer.toString(8-row));
        //temp.concat(Integer.toString(row));
    }
}
