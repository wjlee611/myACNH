package com.gmail.com.wjlee611.acnh;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ScrollingActivity extends AppCompatActivity {

    int curIsland = 1;
    String[] islandNames = new String[3];

    TextView tvMIN, tvMIA, tvMIF, tvMIR, isN, isS, tvCurMonthCalender;
    TextView tvTmpResident;
    Button btnSh;// btnMoreEvent;

    RecyclerView mCalRecyclerView = null;
    CalRecyclerTextAdapter mCalAdapter = null;
    ArrayList<CalRecyclerItem> mCalList = new ArrayList<CalRecyclerItem>();

    int hemisphere = -1;  //0: N, 1: S
    int numResident = 0;
    int[] ResiArray = new int[10];

    RecyclerView mRecyclerViewMV = null;
    MainVillRecyclerImageTextAdapter mAdapterMV = null;
    ArrayList<MainRecyclerVillItem> mListMV = new ArrayList<MainRecyclerVillItem>();

    ImageView _iv;

    TextView tvSUN, tvMONAM, tvMONPM, tvTUEAM, tvTUEPM, tvWEDAM, tvWEDPM, tvTHUAM, tvTHUPM, tvFRIAM, tvFRIPM, tvSATAM, tvSATPM;
    Button btnTurnipDEL, btnTurnipSAVE, btnTurnip;
    int turnipValueUpdateChacker = 1;  // 0: update need, 1: updated
    int[] turnipValues = new int[13];


    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvMIN = (TextView) findViewById(R.id.tvMIN);
        tvMIA = (TextView) findViewById(R.id.tvMIA);
        tvMIF = (TextView) findViewById(R.id.tvMIF);
        tvMIR = (TextView) findViewById(R.id.tvMIR);
        isN = (TextView) findViewById(R.id.isN);
        isS = (TextView) findViewById(R.id.isS);
        tvTmpResident = (TextView) findViewById(R.id.tvTmpResident);

        btnSh = (Button) findViewById(R.id.btnInfoScreen);

        ImageView iv = (ImageView) findViewById(R.id.toolbarImageView);
        _iv = iv;

        tvSUN = (TextView) findViewById(R.id.tvturSUN);
        tvMONAM = (TextView) findViewById(R.id.tvturMONam);
        tvMONPM = (TextView) findViewById(R.id.tvturMONpm);
        tvTUEAM = (TextView) findViewById(R.id.tvturTUEam);
        tvTUEPM = (TextView) findViewById(R.id.tvturTUEpm);
        tvWEDAM = (TextView) findViewById(R.id.tvturWEDam);
        tvWEDPM = (TextView) findViewById(R.id.tvturWEDpm);
        tvTHUAM = (TextView) findViewById(R.id.tvturTHUam);
        tvTHUPM = (TextView) findViewById(R.id.tvturTHUpm);
        tvFRIAM = (TextView) findViewById(R.id.tvturFRIam);
        tvFRIPM = (TextView) findViewById(R.id.tvturFRIpm);
        tvSATAM = (TextView) findViewById(R.id.tvturSATam);
        tvSATPM = (TextView) findViewById(R.id.tvturSATpm);
        btnTurnipSAVE = (Button) findViewById(R.id.btnturnipSAVE);
        btnTurnipDEL = (Button) findViewById(R.id.btnturnipDEL);
        btnTurnip = (Button) findViewById(R.id.btnturnip);


        /*메인 주민 리사이클러 뷰 세팅*/
        mRecyclerViewMV = findViewById(R.id.rvMainResi);

        mAdapterMV = new MainVillRecyclerImageTextAdapter(mListMV);
        mRecyclerViewMV.setAdapter(mAdapterMV);

        mRecyclerViewMV.setLayoutManager(new LinearLayoutManager(this));


        /*데이터 불러오기 - 섬 선택*/
        try {
            BufferedReader br = new BufferedReader(new FileReader(getFilesDir() + "curIsland.txt"));
            String readStr = "";
            String str = null;
            while ((str = br.readLine()) != null) {
                readStr = str;
            }
            if (readStr != "") {
                String[] array = readStr.split("`");
                curIsland = Integer.parseInt(array[0]);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(getFilesDir() + "islandNames.txt"));
            String readStr = "";
            String str = null;
            while ((str = br.readLine()) != null) {
                readStr = str;
            }
            if (readStr != "") {
                String[] array = readStr.split("`");
                islandNames[0] = array[0];
                islandNames[1] = array[1];
                islandNames[2] = array[2];
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        /*데이터 불러오기*/
        try {
            BufferedReader br = new BufferedReader(new FileReader(getFilesDir() + "islandInfo" + curIsland + ".txt"));
            String readStr = "";
            String str = null;
            while ((str = br.readLine()) != null) {
                readStr = str;
            }
            if (readStr != "") {
                String[] array = readStr.split("`");
                tvMIN.setText(array[0]);
                tvMIA.setText(array[1]);
                tvMIF.setText(array[2]);
                tvMIR.setText(array[3]);
                hemisphere = Integer.parseInt(array[4]);
            }
            br.close();

            br = new BufferedReader(new FileReader(getFilesDir() + "residentInfo" + curIsland + ".txt"));
            readStr = "";;
            str = null;
            while ((str = br.readLine()) != null) {
                readStr = str;
            }
            if (readStr != "") {
                String[] array = readStr.split("`");
                for (int i=0; i<array.length; i++) {
                    ResiArray[i] = Integer.parseInt(array[i]);
                }
                numResident = array.length;
            }
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            if (Locale.getDefault().getLanguage().equals("ko")) {
                //한국어
                Snackbar.make(findViewById(android.R.id.content), "첫 방문을 환영합니다!", Snackbar.LENGTH_LONG)
                        .setAction("어떻게 써요?", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                AppInfoDialog dialog = new AppInfoDialog(ScrollingActivity.this);
                                dialog.show();
                            }
                        }).show();
            } else {
                //default 영어
                Snackbar.make(findViewById(android.R.id.content), "Welcome to first visit!", Snackbar.LENGTH_LONG)
                        .setAction("How To Use?", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                AppInfoDialog dialog = new AppInfoDialog(ScrollingActivity.this);
                                dialog.show();
                            }
                        }).show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        loadMV(numResident, ResiArray);

        if (hemisphere == 0) {
            isN.setVisibility(View.VISIBLE);
        } else if (hemisphere == 1) {
            isS.setVisibility(View.VISIBLE);
        }

        if (numResident > 0) {
            tvTmpResident.setVisibility(View.GONE);
        }

        try {
            Bitmap bm = BitmapFactory.decodeFile("data/data/com.gmail.com.wjlee611.acnh/files/canh_title" + curIsland + ".png");
            _iv.setImageBitmap(bm);
            bm = null;
        } catch (Exception e) {
            e.printStackTrace();
            Snackbar.make(findViewById(android.R.id.content), e.getMessage(), Snackbar.LENGTH_SHORT).show();
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(getFilesDir() + "turnipValues" + curIsland + ".txt"));
            String readStr = "";
            String str = null;

            while ((str = br.readLine()) != null) {
                readStr = str;
            }
            if (readStr != "") {
                String[] array = readStr.split("`");
                for (int i=0; i<array.length; i++) {
                    turnipValues[i] = Integer.parseInt(array[i]);
                }
                tvSUN.setText(Integer.toString(turnipValues[0]));
                tvMONAM.setText(Integer.toString(turnipValues[1]));
                tvMONPM.setText(Integer.toString(turnipValues[2]));
                tvTUEAM.setText(Integer.toString(turnipValues[3]));
                tvTUEPM.setText(Integer.toString(turnipValues[4]));
                tvWEDAM.setText(Integer.toString(turnipValues[5]));
                tvWEDPM.setText(Integer.toString(turnipValues[6]));
                tvTHUAM.setText(Integer.toString(turnipValues[7]));
                tvTHUPM.setText(Integer.toString(turnipValues[8]));
                tvFRIAM.setText(Integer.toString(turnipValues[9]));
                tvFRIPM.setText(Integer.toString(turnipValues[10]));
                tvSATAM.setText(Integer.toString(turnipValues[11]));
                tvSATPM.setText(Integer.toString(turnipValues[12]));

                turnipValues0Checker();
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        /*마을 설정 페이지로 넘어가기*/
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), VillSettingActivity.class);
                intent.putExtra("iName", tvMIN.getText().toString());
                intent.putExtra("iAddress", tvMIA.getText().toString());
                intent.putExtra("iFruit", tvMIF.getText().toString());
                intent.putExtra("iResident", tvMIR.getText().toString());
                intent.putExtra("hemisphere", hemisphere);
                intent.putExtra("numResident", numResident);
                intent.putExtra("ResidentList", ResiArray);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(intent, 0);
            }
        });


        /*타이틀 사진 변경*/
        fab.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intentPng = new Intent(Intent.ACTION_PICK);
                intentPng.setType(MediaStore.Images.Media.CONTENT_TYPE);
                if (Locale.getDefault().getLanguage().equals("ko")) {
                    //한국어
                    Toast.makeText(getApplicationContext(), "[주의사항]\n이미지 파일 크기가 클 수록 시간이 오래 걸려요.", Toast.LENGTH_LONG).show();
                } else {
                    //default 영어
                    Toast.makeText(getApplicationContext(), "[Caution]\nThe larger the size of the image file,\nthe longer the loading time.", Toast.LENGTH_LONG).show();
                }
                intentPng.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(intentPng, 2);
                return false;
            }
        });


        /*스크린 샷 페이지로 넘어가기*/
        btnSh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentsh = new Intent(getApplicationContext(), ShActivity.class);
                intentsh.putExtra("curIsland", curIsland);
                intentsh.putExtra("iName", tvMIN.getText().toString());
                intentsh.putExtra("iAddress", tvMIA.getText().toString());
                intentsh.putExtra("iFruit", tvMIF.getText().toString());
                intentsh.putExtra("iResident", tvMIR.getText().toString());
                intentsh.putExtra("hemisphere", hemisphere);
                intentsh.putExtra("numResident", numResident);
                intentsh.putExtra("ResidentList", ResiArray);

                intentsh.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intentsh);
            }
        });


        /*달력 세팅*/
        mCalRecyclerView = findViewById(R.id.cal_recycler);

        mCalAdapter = new CalRecyclerTextAdapter(mCalList);
        mCalRecyclerView.setAdapter(mCalAdapter);

        mCalRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        tvCurMonthCalender = (TextView) findViewById(R.id.tvCurMonthCalender);

        Date curTime = Calendar.getInstance().getTime();
        SimpleDateFormat monthForm = new SimpleDateFormat("MM", Locale.getDefault());
        String month = monthForm.format(curTime);

        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            switch (month) {
                case "01":
                    tvCurMonthCalender.setText("1월 메인 이벤트");
                    addItemCal("1일", "새해 맞이");
                    addItemCal("18일", "한정 낚시 대회");
                    addItemCal("25일", "설날");
                    break;
                case "02":
                    tvCurMonthCalender.setText("2월 메인 이벤트");
                    addItemCal("8일", "정월 대보름");
                    addItemCal("8일", "자유 낚시 대회");
                    addItemCal("23일", "카니발");
                    break;
                case "03":
                    tvCurMonthCalender.setText("3월 메인 이벤트");
                    addItemCal("2일", "잡초 뽑기의 날");
                    addItemCal("21일", "한정 낚시 대회");
                    break;
                case "04":
                    tvCurMonthCalender.setText("4월 메인 이벤트");
                    addItemCal("1일", "만우절");
                    addItemCal("1-12일", "부활절 (이스터)");
                    addItemCal("5일", "식목일");
                    addItemCal("11일", "자유 낚시 대회");
                    break;
                case "05":
                    tvCurMonthCalender.setText("5월 메인 이벤트");
                    addItemCal("8일", "어버이 날");
                    addItemCal("15일", "스승의 날");
                    addItemCal("16일", "한정 낚시 대회");
                    break;
                case "06":
                    tvCurMonthCalender.setText("6월 메인 이벤트");
                    addItemCal("20일", "곤충 채집 대회");
                    addItemCal("21일", "하지");
                    break;
                case "07":
                    tvCurMonthCalender.setText("7월 메인 이벤트");
                    addItemCal("18일", "곤충 채집 대회");
                    break;
                case "08":
                    tvCurMonthCalender.setText("8월 메인 이벤트");
                    addItemCal("2일", "불꽃 축제");
                    addItemCal("9일", "불꽃 축제");
                    addItemCal("15일", "곤충 채집 대회");
                    addItemCal("16일", "불꽃 축제");
                    addItemCal("23일", "불꽃 축제");
                    addItemCal("30일", "불꽃 축제");
                    break;
                case "09":
                    tvCurMonthCalender.setText("9월 메인 이벤트");
                    addItemCal("19일", "곤충 채집 대회");
                    break;
                case "10":
                    tvCurMonthCalender.setText("10월 메인 이벤트");
                    addItemCal("1일", "추석");
                    addItemCal("10일", "자유 낚시 대회");
                    addItemCal("31일", "할로윈");
                    break;
                case "11":
                    tvCurMonthCalender.setText("11월 메인 이벤트");
                    addItemCal("21일", "한정 낚시 대회");
                    break;
                case "12":
                    tvCurMonthCalender.setText("12월 메인 이벤트");
                    addItemCal("12일", "자유 낚시 대회");
                    addItemCal("21일", "동지");
                    addItemCal("24일", "크리스마스 이브");
                    addItemCal("31일", "새해 카운트다운");
                    break;
                default:
                    break;
            }
        } else {
            //default 영어
            switch (month) {
                case "01":
                    tvCurMonthCalender.setText("Events of January");
                    addItemCal("Day 1", "New Year's Day");
                    addItemCal("Day 18", "Fishing Tourney");
                    break;
                case "02":
                    tvCurMonthCalender.setText("Events of February");
                    addItemCal("Day 2", "Groundhog Day");
                    addItemCal("Day 8", "Fishing Tourney");
                    addItemCal("Day 14", "Valentine's Day");
                    addItemCal("Day 23", "Festivale");
                    addItemCal("Day 29", "Leaf Day");
                    break;
                case "03":
                    tvCurMonthCalender.setText("Events of March");
                    addItemCal("Day 6", "Weeding Day");
                    addItemCal("Day 17", "Shamrock Day");
                    addItemCal("Day 21", "Fishing Tourney");
                    break;
                case "04":
                    tvCurMonthCalender.setText("Events of April");
                    addItemCal("Day 1", "April Fool's Day");
                    addItemCal("Day 1-6", "Cherry Blossom Festival P.1");
                    addItemCal("Day 1-12", "Bunny Day");
                    addItemCal("Day 7-10", "Cherry Blossom Festival P.2");
                    addItemCal("Day 11", "Fishing Tourney");
                    addItemCal("Day 22", "Nature (Earth) Day");
                    break;
                case "05":
                    tvCurMonthCalender.setText("Events of In May");
                    addItemCal("Day 10", "Mother's Day");
                    addItemCal("Day 16", "Fishing Tourney");
                    break;
                case "06":
                    tvCurMonthCalender.setText("Events of June");
                    addItemCal("Day 20", "Bug Off");
                    addItemCal("Day 21", "Father's Day");
                    addItemCal("Day 21", "Summer Solstice");
                    break;
                case "07":
                    tvCurMonthCalender.setText("Events of In July");
                    addItemCal("Day 18", "Bug Off");
                    break;
                case "08":
                    tvCurMonthCalender.setText("Events of August");
                    addItemCal("Day 2", "Fireworks Show");
                    addItemCal("Day 9", "Fireworks Show");
                    addItemCal("Day 15", "Bug Off");
                    addItemCal("Day 16", "Fireworks Show");
                    addItemCal("Day 23", "Fireworks Show");
                    addItemCal("Day 30", "Fireworks Show");
                    break;
                case "09":
                    tvCurMonthCalender.setText("Events of September");
                    addItemCal("Day 7", "Labor Day");
                    addItemCal("Day 19", "Bug Off");
                    break;
                case "10":
                    tvCurMonthCalender.setText("Events of October");
                    addItemCal("Day 1", "Harvest Moon Festival");
                    addItemCal("Day 10", "Fishing Tourney");
                    addItemCal("Day 11", "Explorer's Day");
                    addItemCal("Day 31", "Halloween");
                    break;
                case "11":
                    tvCurMonthCalender.setText("Events of November");
                    addItemCal("Day 21", "Fishing Tourney");
                    addItemCal("Day 27", "Harvest Festival");
                    break;
                case "12":
                    tvCurMonthCalender.setText("Events of December");
                    addItemCal("Day 12", "Fishing Tourney");
                    addItemCal("Day 21", "Winter Solstice");
                    addItemCal("Day 24", "Toy Day");
                    addItemCal("Day 31", "New Year's Eve");
                    break;
                default:
                    break;
            }
        }
        mCalAdapter.notifyDataSetChanged();


        /*더 많은 이벤트 페이지로 넘어가기
        btnMoreEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Locale.getDefault().getLanguage().equals("ko")) {
                    //한국어
                    Snackbar.make(findViewById(android.R.id.content), "곤충, 물고기 등 맞춤 정보가 업데이트 예정입니다.", Snackbar.LENGTH_SHORT).show();
                } else {
                    //default 영어
                    Snackbar.make(findViewById(android.R.id.content), "The custom info page includes Insect, Fish, etc. will be updated.", Snackbar.LENGTH_SHORT).show();
                }
            }
        });*/


        /*무값 입력*/
        tvSUN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TurnipCustomDialog tcd = new TurnipCustomDialog(ScrollingActivity.this);
                tcd.callFunction(tvSUN);
                turnipValueUpdateChacker=0;
            }
        });

        tvMONAM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TurnipCustomDialog tcd = new TurnipCustomDialog(ScrollingActivity.this);
                tcd.callFunction(tvMONAM);
                turnipValueUpdateChacker=0;
            }
        });

        tvMONPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TurnipCustomDialog tcd = new TurnipCustomDialog(ScrollingActivity.this);
                tcd.callFunction(tvMONPM);
                turnipValueUpdateChacker=0;
            }
        });

        tvTUEAM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TurnipCustomDialog tcd = new TurnipCustomDialog(ScrollingActivity.this);
                tcd.callFunction(tvTUEAM);
                turnipValueUpdateChacker=0;
            }
        });

        tvTUEPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TurnipCustomDialog tcd = new TurnipCustomDialog(ScrollingActivity.this);
                tcd.callFunction(tvTUEPM);
                turnipValueUpdateChacker=0;
            }
        });

        tvWEDAM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TurnipCustomDialog tcd = new TurnipCustomDialog(ScrollingActivity.this);
                tcd.callFunction(tvWEDAM);
                turnipValueUpdateChacker=0;
            }
        });

        tvWEDPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TurnipCustomDialog tcd = new TurnipCustomDialog(ScrollingActivity.this);
                tcd.callFunction(tvWEDPM);
                turnipValueUpdateChacker=0;
            }
        });

        tvTHUAM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TurnipCustomDialog tcd = new TurnipCustomDialog(ScrollingActivity.this);
                tcd.callFunction(tvTHUAM);
                turnipValueUpdateChacker=0;
            }
        });

        tvTHUPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TurnipCustomDialog tcd = new TurnipCustomDialog(ScrollingActivity.this);
                tcd.callFunction(tvTHUPM);
                turnipValueUpdateChacker=0;
            }
        });

        tvFRIAM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TurnipCustomDialog tcd = new TurnipCustomDialog(ScrollingActivity.this);
                tcd.callFunction(tvFRIAM);
                turnipValueUpdateChacker=0;
            }
        });

        tvFRIPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TurnipCustomDialog tcd = new TurnipCustomDialog(ScrollingActivity.this);
                tcd.callFunction(tvFRIPM);
                turnipValueUpdateChacker=0;
            }
        });

        tvSATAM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TurnipCustomDialog tcd = new TurnipCustomDialog(ScrollingActivity.this);
                tcd.callFunction(tvSATAM);
                turnipValueUpdateChacker=0;
            }
        });

        tvSATPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TurnipCustomDialog tcd = new TurnipCustomDialog(ScrollingActivity.this);
                tcd.callFunction(tvSATPM);
                turnipValueUpdateChacker=0;
            }
        });

        btnTurnipSAVE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (turnipValueUpdateChacker==0) {
                    if (tvSUN.getText().toString().equals("")) {
                        turnipValues[0] = 0;
                    } else {
                        turnipValues[0] = Integer.parseInt(tvSUN.getText().toString());
                    }
                    if (tvMONAM.getText().toString().equals("")) {
                        turnipValues[1] = 0;
                    } else {
                        turnipValues[1] = Integer.parseInt(tvMONAM.getText().toString());
                    }
                    if (tvMONPM.getText().toString().equals("")) {
                        turnipValues[2] = 0;
                    } else {
                        turnipValues[2] = Integer.parseInt(tvMONPM.getText().toString());
                    }
                    if (tvTUEAM.getText().toString().equals("")) {
                        turnipValues[3] = 0;
                    } else {
                        turnipValues[3] = Integer.parseInt(tvTUEAM.getText().toString());
                    }
                    if (tvTUEPM.getText().toString().equals("")) {
                        turnipValues[4] = 0;
                    } else {
                        turnipValues[4] = Integer.parseInt(tvTUEPM.getText().toString());
                    }
                    if (tvWEDAM.getText().toString().equals("")) {
                        turnipValues[5] = 0;
                    } else {
                        turnipValues[5] = Integer.parseInt(tvWEDAM.getText().toString());
                    }
                    if (tvWEDPM.getText().toString().equals("")) {
                        turnipValues[6] = 0;
                    } else {
                        turnipValues[6] = Integer.parseInt(tvWEDPM.getText().toString());

                    }
                    if (tvTHUAM.getText().toString().equals("")) {
                        turnipValues[7] = 0;
                    } else {
                        turnipValues[7] = Integer.parseInt(tvTHUAM.getText().toString());
                    }
                    if (tvTHUPM.getText().toString().equals("")) {
                        turnipValues[8] = 0;
                    } else {
                        turnipValues[8] = Integer.parseInt(tvTHUPM.getText().toString());
                    }
                    if (tvFRIAM.getText().toString().equals("")) {
                        turnipValues[9] = 0;
                    } else {
                        turnipValues[9] = Integer.parseInt(tvFRIAM.getText().toString());

                    }
                    if (tvFRIPM.getText().toString().equals("")) {
                        turnipValues[10] = 0;
                    } else {
                        turnipValues[10] = Integer.parseInt(tvFRIPM.getText().toString());

                    }
                    if (tvSATAM.getText().toString().equals("")) {
                        turnipValues[11] = 0;
                    } else {
                        turnipValues[11] = Integer.parseInt(tvSATAM.getText().toString());
                    }
                    if (tvSATPM.getText().toString().equals("")) {
                        turnipValues[12] = 0;
                    } else {
                        turnipValues[12] = Integer.parseInt(tvSATPM.getText().toString());
                    }

                    saveTurnipValues();

                    turnipValueUpdateChacker=1;
                } else {
                    if (Locale.getDefault().getLanguage().equals("ko")) {
                        //한국어
                        Snackbar.make(findViewById(android.R.id.content), "이미 적용되었습니다.", Snackbar.LENGTH_SHORT).show();
                    } else {
                        //default 영어
                        Snackbar.make(findViewById(android.R.id.content), "Already applied.", Snackbar.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnTurnipDEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Locale.getDefault().getLanguage().equals("ko")) {
                    //한국어
                    Snackbar.make(findViewById(android.R.id.content), "무가격을 모두 지울까요?", Snackbar.LENGTH_LONG)
                            .setAction("초기화!", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    for(int i = 0; i < turnipValues.length; i++) {
                                        turnipValues[i] = 0;
                                    }
                                    turnipValues0Checker();

                                    turnipValueUpdateChacker=0;
                                }
                            }).setActionTextColor(Color.rgb(255,186,190))
                            .show();
                } else {
                    //default 영어
                    Snackbar.make(findViewById(android.R.id.content), "Reset all Turnip Values?", Snackbar.LENGTH_LONG)
                            .setAction("Reset!", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    for(int i = 0; i < turnipValues.length; i++) {
                                        turnipValues[i] = 0;
                                    }
                                    turnipValues0Checker();

                                    turnipValueUpdateChacker=0;
                                }
                            }).setActionTextColor(Color.rgb(255,186,190))
                            .show();
                }
            }
        });

        btnTurnip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Locale.getDefault().getLanguage().equals("ko")) {
                    //한국어
                    if (turnipValueUpdateChacker==0) {
                        Snackbar.make(findViewById(android.R.id.content), "적용 / 저장후 실행해주세요!", Snackbar.LENGTH_SHORT).show();
                    } else if (turnipValues[0]==0) {
                        Snackbar.make(findViewById(android.R.id.content), "최소한 매입가는 저장해야합니다.", Snackbar.LENGTH_SHORT).show();
                    } else{
                        Intent intentta = new Intent(getApplicationContext(), AnalysisActivity.class);
                        intentta.putExtra("values", turnipValues);

                        intentta.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intentta);
                    }
                } else {
                    //default 영어
                    if (turnipValueUpdateChacker==0) {
                        Snackbar.make(findViewById(android.R.id.content), "Please Apply n Save!", Snackbar.LENGTH_SHORT).show();
                    } else if (turnipValues[0]==0) {
                        Snackbar.make(findViewById(android.R.id.content), "Please set Origin. Price.", Snackbar.LENGTH_SHORT).show();
                    } else{
                        Intent intentta = new Intent(getApplicationContext(), AnalysisActivity.class);
                        intentta.putExtra("values", turnipValues);

                        intentta.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intentta);
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_info) {
            AppInfoDialog dialog = new AppInfoDialog(this);
            dialog.show();

            return true;
        }

        if (id == R.id.action_island) {
            Intent intentI = new Intent(this, ChangeIslandActivity.class);
            intentI.putExtra("curIsland", curIsland);

            intentI.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intentI);

            return true;
        }

        if (id == R.id.action_donate) {
            Intent intentD = new Intent(this, DonateActivity.class);
            intentD.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intentD);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private long time = 0;
    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - time >= 2000) {
            time = System.currentTimeMillis();
            if (Locale.getDefault().getLanguage().equals("ko")) {
                //한국어
                Snackbar.make(findViewById(android.R.id.content), "한번 더 누르시면 종료됩니다.", 2000).show();
            } else {
                //default 영어
                Snackbar.make(findViewById(android.R.id.content), "Pressing back again to exit.", 2000).show();
            }
        } else if (System.currentTimeMillis() - time < 2000) {

            finishAfterTransition();
            android.os.Process.killProcess(android.os.Process.myPid());
        }
        //super.onBackPressed();
    }


    public void addItemMV(Drawable icon, String name, String gender, String birth, String person, String coffee) {
        MainRecyclerVillItem item = new MainRecyclerVillItem();

        item.setIcon(icon);
        item.setName(name);
        item.setGender(gender);
        item.setBirth(birth);
        item.setPerson(person);
        item.setCoffee(coffee);

        mListMV.add(item);
    }

    public void addItemCal(String day, String event) {
        CalRecyclerItem item = new CalRecyclerItem();

        item.setDay(day);
        item.setEvent(event);

        mCalList.add(item);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        onResume();

        if (requestCode == 0 && resultCode == RESULT_OK) {
            tvMIN.setText(data.getStringExtra("iName"));
            tvMIA.setText(data.getStringExtra("iAddress"));
            tvMIF.setText(data.getStringExtra("iFruit"));
            tvMIR.setText(data.getStringExtra("iResident"));
            hemisphere = data.getIntExtra("hemisphere", -1);

            numResident = data.getIntExtra("numResident", 0);
            for (int i=0; i<numResident; i++) {
                ResiArray[i] = data.getIntExtra(Integer.toString(i), 0);
            }
            mListMV.clear();
            loadMV(numResident, ResiArray);

            isN.setVisibility(View.GONE);
            isS.setVisibility(View.GONE);
            if (hemisphere == 0) {
                isN.setVisibility(View.VISIBLE);
            } else if (hemisphere == 1) {
                isS.setVisibility(View.VISIBLE);
            }

            if (numResident > 0) {
                tvTmpResident.setVisibility(View.GONE);
            } else {
                tvTmpResident.setVisibility(View.VISIBLE);
            }

            islandNames[curIsland - 1] = data.getStringExtra("iName");


            /*저장하기*/
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(getFilesDir() + "islandInfo" + curIsland + ".txt"));
                String str = "";
                str = tvMIN.getText().toString() + "`" + tvMIA.getText().toString() + "`"
                        + tvMIF.getText().toString() + "`" + tvMIR.getText().toString() + "`"
                        + hemisphere + "`";
                bw.write(str);

                bw.close();

                bw = new BufferedWriter(new FileWriter(getFilesDir() + "residentInfo" + curIsland + ".txt"));
                str = "";
                for (int i=0; i<numResident; i++) {
                    str += ResiArray[i] + "`";
                }
                bw.write(str);

                bw.close();

                bw = new BufferedWriter(new FileWriter(getFilesDir() + "islandNames.txt"));
                str = islandNames[0] + "`" + islandNames[1] + "`" + islandNames[2] + "`";
                bw.write(str);

                bw.close();
                if (Locale.getDefault().getLanguage().equals("ko")) {
                    //한국어
                    Snackbar.make(findViewById(android.R.id.content), "저장되었습니다!", Snackbar.LENGTH_SHORT).setTextColor(Color.rgb(120,254,224)).show();
                } else {
                    //default 영어
                    Snackbar.make(findViewById(android.R.id.content), "Saved!", Snackbar.LENGTH_SHORT).setTextColor(Color.rgb(120,254,224)).show();
                }
            } catch (IOException e) {
                e.printStackTrace();
                Snackbar.make(findViewById(android.R.id.content), e.getMessage(), Snackbar.LENGTH_SHORT).show();
            }
        }

        if (requestCode == 2 && resultCode == RESULT_OK) {
            try {
                BitmapFactory.Options bo = new BitmapFactory.Options();
                bo.inSampleSize = 2;
                InputStream in = getContentResolver().openInputStream(data.getData());
                Bitmap img = BitmapFactory.decodeStream(in, null, bo);
                in.close();

                _iv.setImageBitmap(img);


                /*저장하기*/
                try {
                    File file = new File("canh_title" + curIsland + ".png");
                    FileOutputStream fos = openFileOutput("canh_title" + curIsland + ".png", 0);
                    img.compress(Bitmap.CompressFormat.PNG, 100, fos);
                    fos.flush();
                    fos.close();

                    if (Locale.getDefault().getLanguage().equals("ko")) {
                        //한국어
                        Snackbar.make(findViewById(android.R.id.content), "당신의 섬 인가요? 멋지네요!", Snackbar.LENGTH_SHORT).setTextColor(Color.rgb(120,254,224)).show();
                    } else {
                        //default 영어
                        Snackbar.make(findViewById(android.R.id.content), "Is this your island? That's COOL!", Snackbar.LENGTH_SHORT).setTextColor(Color.rgb(120,254,224)).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Snackbar.make(findViewById(android.R.id.content), e.getMessage(), Snackbar.LENGTH_SHORT).show();
                }

                img = null;
            } catch (Exception e) {
                e.printStackTrace();
                Snackbar.make(findViewById(android.R.id.content), e.getMessage(), Snackbar.LENGTH_SHORT).show();
            }
        }
    }


    public void saveTurnipValues() {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(getFilesDir() + "turnipValues" + curIsland + ".txt"));
            String str = "";
            for(int x : turnipValues) {
                str = str + x + "`";
            }
            bw.write(str);

            bw.close();

            turnipValues0Checker();
            if (Locale.getDefault().getLanguage().equals("ko")) {
                //한국어
                Snackbar.make(findViewById(android.R.id.content), "적용 / 저장되었습니다!", Snackbar.LENGTH_SHORT).setTextColor(Color.rgb(120,254,224)).show();
            } else {
                //default 영어
                Snackbar.make(findViewById(android.R.id.content), "Apply n Saved!", Snackbar.LENGTH_SHORT).setTextColor(Color.rgb(120,254,224)).show();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Snackbar.make(findViewById(android.R.id.content), e.getMessage(), Snackbar.LENGTH_SHORT).show();
        }
    }

    public void turnipValues0Checker() {
        if (turnipValues[0] == 0){
            tvSUN.setText("");
        }
        if (turnipValues[1] == 0){
            tvMONAM.setText("");
        }
        if (turnipValues[2] == 0){
            tvMONPM.setText("");
        }
        if (turnipValues[3] == 0){
            tvTUEAM.setText("");
        }
        if (turnipValues[4] == 0){
            tvTUEPM.setText("");
        }
        if (turnipValues[5] == 0){
            tvWEDAM.setText("");
        }
        if (turnipValues[6] == 0){
            tvWEDPM.setText("");
        }
        if (turnipValues[7] == 0){
            tvTHUAM.setText("");
        }
        if (turnipValues[8] == 0){
            tvTHUPM.setText("");
        }
        if (turnipValues[9] == 0){
            tvFRIAM.setText("");
        }
        if (turnipValues[10] == 0){
            tvFRIPM.setText("");
        }
        if (turnipValues[11] == 0){
            tvSATAM.setText("");
        }
        if (turnipValues[12] == 0){
            tvSATPM.setText("");
        }
    }


    /*주민정보 데이터베이스 겸 로드*/
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void loadMV(int numResident, int[] resiArray) {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            for (int i=0; i<numResident; i++) {
                switch (ResiArray[i]) {
                    case 1:
                        addItemMV(getDrawable(R.drawable.agent_s), "2호", "여성", "07/02 - 게자리", "아이돌", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 2:
                        addItemMV(getDrawable(R.drawable.agnes), "아그네스", "여성", "04/21 - 황소자리", "단순활발", "킬리만자로 / 우유 많이 / 설탕 3");
                        break;
                    case 3:
                        addItemMV(getDrawable(R.drawable.alfonso), "알베르트", "남성", "06/09 - 쌍둥이자리", "먹보", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 4:
                        addItemMV(getDrawable(R.drawable.alli), "크로코", "여성", "11/08 - 전갈자리", "성숙함", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 5:
                        addItemMV(getDrawable(R.drawable.amelia), "안데스", "여성", "11/19 - 전갈자리", "성숙함", "블루마운틴 / 우유 많이 / 설탕 3");
                        break;
                    case 6:
                        addItemMV(getDrawable(R.drawable.angus), "반데스", "남성", "04/30 - 황소자리", "무뚝뚝", "킬리만자로 / 우유 X / 설탕 X");
                        break;
                    case 7:
                        addItemMV(getDrawable(R.drawable.antonio), "퍼머거", "남성", "10/20 - 천칭자리", "운동광", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 8:
                        addItemMV(getDrawable(R.drawable.apollo), "아폴로", "남성", "07/04 - 게자리", "무뚝뚝", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 9:
                        addItemMV(getDrawable(R.drawable.apple), "애플", "여성", "09/24 - 천칭자리", "아이돌", "블랜드 / 우유 보통 / 설탕 2");
                        break;
                    case 10:
                        addItemMV(getDrawable(R.drawable.aurora), "오로라", "여성", "01/27 - 물병자리", "친절함", "킬리만자로 / 우유 보통 / 설탕 2");
                        break;
                    case 11:
                        addItemMV(getDrawable(R.drawable.avery), "쿠스케처", "남성", "02/22 - 물고기자리", "무뚝뚝", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 12:
                        addItemMV(getDrawable(R.drawable.baabara), "트로와", "여성", "03/28 - 양자리", "성숙함", "모카 / 우유 X / 설탕 X");
                        break;
                    case 13:
                        addItemMV(getDrawable(R.drawable.bangle), "루주", "여성", "08/27 - 처녀자리", "성숙함", "모카 / 우유 조금 / 설탕 1");
                        break;
                    case 14:
                        addItemMV(getDrawable(R.drawable.beau), "피터", "남성", "04/05 - 양자리", "먹보", "모카 / 우유 많이 / 설탕 3");
                        break;
                    case 15:
                        addItemMV(getDrawable(R.drawable.bella), "이자벨", "여성", "12/28 - 염소자리", "아이돌", "모카 / 우유 X / 설탕 X");
                        break;
                    case 16:
                        addItemMV(getDrawable(R.drawable.bertha), "베티", "여성", "04/25 - 황소자리", "친절함", "킬리만자로 / 우유 많이 / 설탕 3");
                        break;
                    case 17:
                        addItemMV(getDrawable(R.drawable.bettina), "마르카", "여성", "06/12 - 쌍둥이자리", "친절함", "킬리만자로 / 우유 많이 / 설탕 3");
                        break;
                    case 18:
                        addItemMV(getDrawable(R.drawable.bianca), "백희", "여성", "12/13 - 궁수자리", "아이돌", "킬리만자로 / 우유 X / 설탕 X");
                        break;
                    case 19:
                        addItemMV(getDrawable(R.drawable.bill), "코코아", "남성", "02/01 - 물병자리", "운동광", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 20:
                        addItemMV(getDrawable(R.drawable.blaire), "실루엣", "여성", "07/03 - 게자리", "성숙함", "블랜드 / 우유 X / 설탕 X");
                        break;
                    case 21:
                        addItemMV(getDrawable(R.drawable.blanche), "신옥", "여성", "12/21 - 궁수자리", "성숙함", "블루마운틴 / 우유 많이 / 설탕 3");
                        break;
                    case 22:
                        addItemMV(getDrawable(R.drawable.bob), "히죽", "남성", "01/01 - 염소자리", "먹보", "킬리만자로 / 우유 X / 설탕 X");
                        break;
                    case 23:
                        addItemMV(getDrawable(R.drawable.bonbon), "미미", "여성", "03/03 - 물고기자리", "아이돌", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 24:
                        addItemMV(getDrawable(R.drawable.bree), "사라", "여성", "07/07 - 게자리", "성숙함", "블랜드 / 우유 보통 / 설탕 2");
                        break;
                    case 25:
                        addItemMV(getDrawable(R.drawable.buck), "바야시코프", "남성", "04/04 - 양자리", "운동광", "모카 / 우유 조금 / 설탕 1");
                        break;
                    case 26:
                        addItemMV(getDrawable(R.drawable.bud), "선글", "남성", "08/08 - 사자자리", "운동광", "블루마운틴 / 우유 X / 설탕 X");
                        break;
                    case 27:
                        addItemMV(getDrawable(R.drawable.bunnie), "릴리안", "여성", "05/09 - 황소자리", "아이돌", "블루마운틴 / 우유 많이 / 설탕 3");
                        break;
                    case 28:
                        addItemMV(getDrawable(R.drawable.butch), "존", "남성", "11/01 - 전갈자리", "무뚝뚝", "블랜드 / 우유 X / 설탕 X");
                        break;
                    case 29:
                        addItemMV(getDrawable(R.drawable.buzz), "근엄", "남성", "12/07 - 궁수자리", "무뚝뚝", "블루마운틴 / 우유 많이 / 설탕 3");
                        break;
                    case 30:
                        addItemMV(getDrawable(R.drawable.cally), "파슬리", "여성", "09/04 - 처녀자리", "친절함", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 31:
                        addItemMV(getDrawable(R.drawable.canberra), "캔버라", "여성", "05/14 - 황소자리", "단순활발", "킬리만자로 / 우유 많이 / 설탕 3");
                        break;
                    case 32:
                        addItemMV(getDrawable(R.drawable.carmen), "초코", "여성", "01/06 - 염소자리", "아이돌", "블루마운틴 / 우유 많이 / 설탕 3");
                        break;
                    case 33:
                        addItemMV(getDrawable(R.drawable.caroline), "캐롤라인", "여성", "07/15 - 게자리", "친절함", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 34:
                        addItemMV(getDrawable(R.drawable.carrie), "마미", "여성", "12/05 - 궁수자리", "친절함", "모카 / 우유 X / 설탕 X");
                        break;
                    case 35:
                        addItemMV(getDrawable(R.drawable.cashmere), "캐시미어", "여성", "04/02 - 양자리", "성숙함", "블랜드 / 우유 보통 / 설탕 2");
                        break;
                    case 36:
                        addItemMV(getDrawable(R.drawable.celia), "티파니", "여성", "03/25 - 양자리", "친절함", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 37:
                        addItemMV(getDrawable(R.drawable.cesar), "앨런", "남성", "09/06 - 처녀자리", "무뚝뚝", "블랜드 / 우유 조금 / 설탕 1");
                        break;
                    case 38:
                        addItemMV(getDrawable(R.drawable.chadder), "치즈", "남성", "12/15 - 궁수자리", "느끼함", "킬리만자로 / 우유 많이 / 설탕 3");
                        break;
                    case 39:
                        addItemMV(getDrawable(R.drawable.charlise), "챠미", "여성", "04/17 - 양자리", "단순활발", "킬리만자로 / 우유 많이 / 설탕 3");
                        break;
                    case 40:
                        addItemMV(getDrawable(R.drawable.cherry), "한나", "여성", "05/11 - 황소자리", "단순활발", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 41:
                        addItemMV(getDrawable(R.drawable.chevre), "윤이", "여성", "03/06 - 물고기자리", "친절함", "블루마운틴 / 우유 X / 설탕 X");
                        break;
                    case 42:
                        addItemMV(getDrawable(R.drawable.chief), "대장", "남성", "12/19 - 궁수자리", "무뚝뚝", "블랜드 / 우유 많이 / 설탕 3");
                        break;
                    case 43:
                        addItemMV(getDrawable(R.drawable.chops), "돈후앙", "남성", "10/13 - 천칭자리", "느끼함", "모카 / 우유 X / 설탕 X");
                        break;
                    case 44:
                        addItemMV(getDrawable(R.drawable.chrissy), "크리스틴", "여성", "08/28 - 처녀자리", "아이돌", "블루마운틴 / 우유 많이 / 설탕 3");
                        break;
                    case 45:
                        addItemMV(getDrawable(R.drawable.claude), "비니거", "남성", "12/03 - 궁수자리", "먹보", "블랜드 / 우유 X / 설탕 X");
                        break;
                    case 46:
                        addItemMV(getDrawable(R.drawable.claudia), "신디", "여성", "11/22 - 전갈자리", "성숙함", "모카 / 우유 조금 / 설탕 1");
                        break;
                    case 47:
                        addItemMV(getDrawable(R.drawable.coco), "이요", "여성", "03/01 - 물고기자리", "친절함", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 48:
                        addItemMV(getDrawable(R.drawable.cole), "아마민", "남성", "08/10 - 사자자리", "먹보", "블랜드 / 우유 X / 설탕 X");
                        break;
                    case 49:
                        addItemMV(getDrawable(R.drawable.colton), "안소니", "남성", "05/22 - 쌍둥이자리", "느끼함", "킬리만자로 / 우유 X / 설탕 X");
                        break;
                    case 50:
                        addItemMV(getDrawable(R.drawable.cranston), "타키", "남성", "09/23 - 천칭자리", "먹보", "블랜드 / 우유 X / 설탕 X");
                        break;
                    case 51:
                        addItemMV(getDrawable(R.drawable.cube), "빙수", "남성", "01/29 - 물병자리", "먹보", "블랜드 / 우유 조금 / 설탕 1");
                        break;
                    case 52:
                        addItemMV(getDrawable(R.drawable.curlos), "카를로스", "남성", "05/08 - 황소자리", "느끼함", "킬리만자로 / 우유 많이 / 설탕 3");
                        break;
                    case 53:
                        addItemMV(getDrawable(R.drawable.curt), "뚝심", "남성", "07/01 - 게자리", "무뚝뚝", "모카 / 우유 X / 설탕 X");
                        break;
                    case 54:
                        addItemMV(getDrawable(R.drawable.deirdre), "나디아", "여성", "05/04 - 황소자리", "단순활발", "블루마운틴 / 우유 X / 설탕 X");
                        break;
                    case 55:
                        addItemMV(getDrawable(R.drawable.diana), "나탈리", "여성", "01/04 - 염소자리", "성숙함", "킬리만자로 / 우유 보통 / 설탕 2");
                        break;
                    case 56:
                        addItemMV(getDrawable(R.drawable.dizzy), "휴지", "남성", "07/14 - 게자리", "먹보", "블루마운틴 / 우유 많이 / 설탕 3");
                        break;
                    case 57:
                        addItemMV(getDrawable(R.drawable.dobie), "켄", "남성", "02/17 - 물병자리", "무뚝뚝", "모카 / 우유 조금 / 설탕 1");
                        break;
                    case 58:
                        addItemMV(getDrawable(R.drawable.doc), "토니", "남성", "03/16 - 물고기자리", "먹보", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 59:
                        addItemMV(getDrawable(R.drawable.dotty), "서머", "여성", "03/14 - 물고기자리", "아이돌", "블루마운틴 / 우유 많이 / 설탕 3");
                        break;
                    case 60:
                        addItemMV(getDrawable(R.drawable.drift), "덕", "남성", "10/09 - 천칭자리", "운동광", "블루마운틴 / 우유 보통 / 설탕 2");
                        break;
                    case 61:
                        addItemMV(getDrawable(R.drawable.egbert), "김희", "남성", "10/14 - 천칭자리", "먹보", "모카 / 우유 조금 / 설탕 1");
                        break;
                    case 62:
                        addItemMV(getDrawable(R.drawable.eloise), "엘레핀", "여성", "12/08 - 궁수자리", "성숙함", "블루마운틴 / 우유 많이 / 설탕 3");
                        break;
                    case 63:
                        addItemMV(getDrawable(R.drawable.erik), "자끄", "남성", "07/27 - 사자자리", "먹보", "모카 / 우유 많이 / 설탕 3");
                        break;
                    case 64:
                        addItemMV(getDrawable(R.drawable.eunice), "곱슬이", "여성", "04/03 - 양자리", "친절함", "블루마운틴 / 우유 조금 / 설탕 1");
                        break;
                    case 65:
                        addItemMV(getDrawable(R.drawable.fang), "시베리아", "남성", "12/18 - 궁수자리", "무뚝뚝", "블랜드 / 우유 많이 / 설탕 3");
                        break;
                    case 66:
                        addItemMV(getDrawable(R.drawable.fauna), "솔미", "여성", "03/26 - 양자리", "친절함", "모카 / 우유 많이 / 설탕 3");
                        break;
                    case 67:
                        addItemMV(getDrawable(R.drawable.filbert), "리키", "남성", "06/03 - 쌍둥이자리", "먹보", "블루마운틴 / 우유 많이 / 설탕 3");
                        break;
                    case 68:
                        addItemMV(getDrawable(R.drawable.flip), "원승", "남성", "11/21 - 전갈자리", "운동광", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 69:
                        addItemMV(getDrawable(R.drawable.flora), "플라라", "여성", "02/09 - 물병자리", "아이돌", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 70:
                        addItemMV(getDrawable(R.drawable.flurry), "뽀야미", "여성", "01/30 - 물병자리", "친절함", "모카 / 우유 X / 설탕 X");
                        break;
                    case 71:
                        addItemMV(getDrawable(R.drawable.francine), "프랑소와", "여성", "01/22 - 물병자리", "성숙함", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 72:
                        addItemMV(getDrawable(R.drawable.frank), "헐크", "남성", "07/30 - 사자자리", "무뚝뚝", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 73:
                        addItemMV(getDrawable(R.drawable.freya), "신드라", "여성", "12/14 - 궁수자리", "성숙함", "모카 / 우유 조금 / 설탕 1");
                        break;
                    case 74:
                        addItemMV(getDrawable(R.drawable.friga), "사브리나", "여성", "10/16 - 천칭자리", "성숙함", "블랜드 / 우유 조금 / 설탕 1");
                        break;
                    case 75:
                        addItemMV(getDrawable(R.drawable.frita), "웬디", "여성", "07/16 - 게자리", "단순활발", "모카 / 우유 X / 설탕 X");
                        break;
                    case 76:
                        addItemMV(getDrawable(R.drawable.fuchsia), "제시카", "여성", "09/19 - 처녀자리", "단순활발", "블루마운틴 / 우유 X / 설탕 X");
                        break;
                    case 77:
                        addItemMV(getDrawable(R.drawable.gabi), "패티카", "여성", "12/16 - 궁수자리", "아이돌", "블루마운틴 / 우유 많이 / 설탕 3");
                        break;
                    case 78:
                        addItemMV(getDrawable(R.drawable.gaston), "대길", "남성", "10/28 - 전갈자리", "무뚝뚝", "블루마운틴 / 우유 많이 / 설탕 3");
                        break;
                    case 79:
                        addItemMV(getDrawable(R.drawable.genji), "토시", "남성", "01/21 - 물병자리", "운동광", "블루마운틴 / 우유 많이 / 설탕 3");
                        break;
                    case 80:
                        addItemMV(getDrawable(R.drawable.gladys), "빅토리아", "여성", "01/15 - 물병자리", "친절함", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 81:
                        addItemMV(getDrawable(R.drawable.goldie), "카라멜", "여성", "12/27 - 염소자리", "친절함", "블루마운틴 / 우유 많이 / 설탕 3");
                        break;
                    case 82:
                        addItemMV(getDrawable(R.drawable.goose), "건태", "남성", "10/04 - 천칭자리", "운동광", "블랜드 / 우유 많이 / 설탕 3");
                        break;
                    case 83:
                        addItemMV(getDrawable(R.drawable.greta), "복자", "여성", "09/05 - 처녀자리", "성숙함", "모카 / 우유 X / 설탕 X");
                        break;
                    case 84:
                        addItemMV(getDrawable(R.drawable.hamlet), "햄스틴", "남성", "05/30 - 쌍둥이자리", "운동광", "블랜드 / 우유 보통 / 설탕 2");
                        break;
                    case 85:
                        addItemMV(getDrawable(R.drawable.hans), "스나일", "남성", "12/05 - 궁수자리", "느끼함", "블루마운틴 / 우유 X / 설탕 X");
                        break;
                    case 86:
                        addItemMV(getDrawable(R.drawable.hazel), "아이리스", "여성", "08/30 - 처녀자리", "단순활발", "블랜드 / 우유 X / 설탕 X");
                        break;
                    case 87:
                        addItemMV(getDrawable(R.drawable.hopkins), "홉킨스", "남성", "03/11 - 물고기자리", "먹보", "블랜드 / 우유 X / 설탕 X");
                        break;
                    case 88:
                        addItemMV(getDrawable(R.drawable.hopper), "달만이", "남성", "04/06 - 양자리", "무뚝뚝", "모카 / 우유 많이 / 설탕 3");
                        break;
                    case 89:
                        addItemMV(getDrawable(R.drawable.hornsby), "뿌람", "남성", "03/20 - 물고기자리", "먹보", "블랜드 / 우유 조금 / 설탕 1");
                        break;
                    case 90:
                        addItemMV(getDrawable(R.drawable.iggly), "김말이", "남성", "11/02 - 전갈자리", "운동광", "모카 / 우유 많이 / 설탕 3");
                        break;
                    case 91:
                        addItemMV(getDrawable(R.drawable.jay), "참돌이", "남성", "07/17 - 게자리", "운동광", "킬리만자로 / 우유 X / 설탕 X");
                        break;
                    case 92:
                        addItemMV(getDrawable(R.drawable.jitters), "딩요", "남성", "02/02 - 물병자리", "운동광", "킬리만자로 / 우유 X / 설탕 X");
                        break;
                    case 93:
                        addItemMV(getDrawable(R.drawable.julia), "줄리아", "여성", "07/31 - 사자자리", "성숙함", "블루마운틴 / 우유 많이 / 설탕 3");
                        break;
                    case 94:
                        addItemMV(getDrawable(R.drawable.julian), "유니오", "남성", "03/15 - 물고기자리", "느끼함", "킬리만자로 / 우유 X / 설탕 X");
                        break;
                    case 95:
                        addItemMV(getDrawable(R.drawable.katt), "쵸이", "여성", "04/27 - 황소자리", "단순활발", "킬리만자로 / 우유 X / 설탕 X");
                        break;
                    case 96:
                        addItemMV(getDrawable(R.drawable.keaton), "프랭크", "남성", "06/01 - 쌍둥이자리", "느끼함", "블랜드 / 우유 X / 설탕 X");
                        break;
                    case 97:
                        addItemMV(getDrawable(R.drawable.kevin), "멧지", "남성", "04/26 - 황소자리", "운동광", "모카 / 우유 X / 설탕 X");
                        break;
                    case 98:
                        addItemMV(getDrawable(R.drawable.kid_cat), "1호", "남성", "08/01 - 사자자리", "운동광", "블루마운틴 / 우유 보통 / 설탕 2");
                        break;
                    case 99:
                        addItemMV(getDrawable(R.drawable.kiki), "캐비어", "여성", "10/08 - 천칭자리", "친절함", "모카 / 우유 조금 / 설탕 1");
                        break;
                    case 100:
                        addItemMV(getDrawable(R.drawable.kitt), "애플리케", "여성", "10/11 - 천칭자리", "친절함", "블랜드 / 우유 보통 / 설탕 2");
                        break;
                    case 101:
                        addItemMV(getDrawable(R.drawable.klaus), "곰도로스", "남성", "03/31 - 양자리", "느끼함", "블루마운틴 / 우유 조금 / 설탕 1");
                        break;
                    case 102:
                        addItemMV(getDrawable(R.drawable.kyle), "리카르도", "남성", "12/06 - 궁수자리", "느끼함", "블루마운틴 / 우유 보통 / 설탕 2");
                        break;
                    case 103:
                        addItemMV(getDrawable(R.drawable.leonardo), "범호", "남성", "05/15 - 황소자리", "운동광", "모카 / 우유 조금 / 설탕 1");
                        break;
                    case 104:
                        addItemMV(getDrawable(R.drawable.lily), "레이니", "여성", "02/04 - 물병자리", "친절함", "모카 / 우유 조금 / 설탕 1");
                        break;
                    case 105:
                        addItemMV(getDrawable(R.drawable.lobo), "늑태", "남성", "11/05 - 전갈자리", "무뚝뚝", "블랜드 / 우유 많이 / 설탕 3");
                        break;
                    case 106:
                        addItemMV(getDrawable(R.drawable.lolly), "사이다", "여성", "03/27 - 양자리", "친절함", "모카 / 우유 조금 / 설탕 1");
                        break;
                    case 107:
                        addItemMV(getDrawable(R.drawable.lopez), "톰슨", "남성", "08/20 - 사자자리", "느끼함", "블랜드 / 우유 조금 / 설탕 1");
                        break;
                    case 108:
                        addItemMV(getDrawable(R.drawable.mallary), "스미모", "여성", "11/17 - 전갈자리", "성숙함", "블랜드 / 우유 X / 설탕 X");
                        break;
                    case 109:
                        addItemMV(getDrawable(R.drawable.margie), "샐리", "여성", "01/28 - 물병자리", "친절함", "블랜드 / 우유 X / 설탕 X");
                        break;
                    case 110:
                        addItemMV(getDrawable(R.drawable.marina), "문리나", "여성", "06/26 - 게자리", "친절함", "블루마운틴 / 우유 많이 / 설탕 3");
                        break;
                    case 111:
                        addItemMV(getDrawable(R.drawable.marshal), "쭈니", "남성", "09/29 - 천칭자리", "느끼함", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 112:
                        addItemMV(getDrawable(R.drawable.melba), "아델레이드", "여성", "04/12 - 양자리", "친절함", "모카 / 우유 X / 설탕 X");
                        break;
                    case 113:
                        addItemMV(getDrawable(R.drawable.merengue), "스트로베리", "여성", "03/19 - 물고기자리", "친절함", "블랜드 / 우유 조금 / 설탕 1");
                        break;
                    case 114:
                        addItemMV(getDrawable(R.drawable.merry), "유네찌", "여성", "06/29 - 게자리", "아이돌", "블루마운틴 / 우유 보통 / 설탕 2");
                        break;
                    case 115:
                        addItemMV(getDrawable(R.drawable.mint), "민트", "여성", "05/02 - 황소자리", "성숙함", "블랜드 / 우유 X / 설탕 X");
                        break;
                    case 116:
                        addItemMV(getDrawable(R.drawable.mira), "미랑", "여성", "07/06 - 게자리", "단순활발", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 117:
                        addItemMV(getDrawable(R.drawable.molly), "귀오미", "여성", "03/07 - 물고기자리", "친절함", "블루마운틴 / 우유 많이 / 설탕 3");
                        break;
                    case 118:
                        addItemMV(getDrawable(R.drawable.muffy), "프릴", "여성", "02/14 - 물병자리", "단순활발", "모카 / 우유 X / 설탕 X");
                        break;
                    case 119:
                        addItemMV(getDrawable(R.drawable.nibbles), "그리미", "여성", "07/19 - 게자리", "아이돌", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 120:
                        addItemMV(getDrawable(R.drawable.octavian), "문복", "남성", "09/20 - 처녀자리", "무뚝뚝", "블랜드 / 우유 X / 설탕 X");
                        break;
                    case 121:
                        addItemMV(getDrawable(R.drawable.o_hare), "산토스", "남성", "07/24 - 사자자리", "느끼함", "블랜드 / 우유 X / 설탕 X");
                        break;
                    case 122:
                        addItemMV(getDrawable(R.drawable.olivia), "올리비아", "여성", "02/03 - 물병자리", "성숙함", "킬리만자로 / 우유 X / 설탕 X");
                        break;
                    case 123:
                        addItemMV(getDrawable(R.drawable.ozzie), "동동이", "남성", "05/07 - 황소자리", "먹보", "킬리만자로 / 우유 많이 / 설탕 3");
                        break;
                    case 124:
                        addItemMV(getDrawable(R.drawable.pancetti), "브리트니", "여성", "11/14 - 전갈자리", "성숙함", "블루마운틴 / 우유 조금 / 설탕 1");
                        break;
                    case 125:
                        addItemMV(getDrawable(R.drawable.patty), "밀크", "여성", "05/10 - 황소자리", "아이돌", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 126:
                        addItemMV(getDrawable(R.drawable.peaches), "말자", "여성", "11/28 - 궁수자리", "친절함", "킬리만자로 / 우유 X / 설탕 X");
                        break;
                    case 127:
                        addItemMV(getDrawable(R.drawable.peanut), "핑키", "여성", "06/08 - 쌍둥이자리", "아이돌", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 128:
                        addItemMV(getDrawable(R.drawable.pecan), "레베카", "여성", "09/10 - 처녀자리", "성숙함", "블랜드 / 우유 X / 설탕 X");
                        break;
                    case 129:
                        addItemMV(getDrawable(R.drawable.peewee), "덤벨", "남성", "09/11 - 처녀자리", "무뚝뚝", "블랜드 / 우유 조금 / 설탕 1");
                        break;
                    case 130:
                        addItemMV(getDrawable(R.drawable.pekoe), "재스민", "여성", "05/18 - 황소자리", "친절함", "킬리만자로 / 우유 보통 / 설탕 2");
                        break;
                    case 131:
                        addItemMV(getDrawable(R.drawable.penelope), "찍순이", "여성", "02/05 - 물병자리", "아이돌", "킬리만자로 / 우유 많이 / 설탕 3");
                        break;
                    case 132:
                        addItemMV(getDrawable(R.drawable.phil), "케인", "남성", "11/27 - 궁수자리", "느끼함", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 133:
                        addItemMV(getDrawable(R.drawable.phoebe), "휘니", "여성", "04/22 - 황소자리", "단순활발", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 134:
                        addItemMV(getDrawable(R.drawable.pierce), "세바스찬", "남성", "01/08 - 염소자리", "운동광", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 135:
                        addItemMV(getDrawable(R.drawable.pietro), "피엘", "남성", "04/19 - 양자리", "느끼함", "블루마운틴 / 우유 조금 / 설탕 1");
                        break;
                    case 136:
                        addItemMV(getDrawable(R.drawable.pinky), "링링", "여성", "09/09 - 처녀자리", "아이돌", "블랜드 / 우유 보통 / 설탕 2");
                        break;
                    case 137:
                        addItemMV(getDrawable(R.drawable.piper), "파이프", "여성", "04/18 - 양자리", "아이돌", "블랜드 / 우유 많이 / 설탕 3");
                        break;
                    case 138:
                        addItemMV(getDrawable(R.drawable.pippy), "로타", "여성", "06/14 - 쌍둥이자리", "아이돌", "블루마운틴 / 우유 많이 / 설탕 3");
                        break;
                    case 139:
                        addItemMV(getDrawable(R.drawable.poncho), "봉추", "남성", "01/02 - 염소자리", "운동광", "모카 / 우유 많이 / 설탕 3");
                        break;
                    case 140:
                        addItemMV(getDrawable(R.drawable.poppy), "다람", "여성", "08/05 - 사자자리", "친절함", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 141:
                        addItemMV(getDrawable(R.drawable.punchy), "빙티", "남성", "04/11 - 양자리", "먹보", "킬리만자로 / 우유 X / 설탕 X");
                        break;
                    case 142:
                        addItemMV(getDrawable(R.drawable.purrl), "타마", "여성", "05/29 - 쌍둥이자리", "성숙함", "킬리만자로 / 우유 X/ 설탕 X");
                        break;
                    case 143:
                        addItemMV(getDrawable(R.drawable.queenie), "택주", "여성", "11/13 - 전갈자리", "성숙함", "킬리만자로 /우유 조금 / 설탕 1");
                        break;
                    case 144:
                        addItemMV(getDrawable(R.drawable.renee), "뿔님이", "여성", "05/28 - 쌍둥이자리", "단순활발", "킬리만자로 / 우유 보통 / 설탕 2");
                        break;
                    case 145:
                        addItemMV(getDrawable(R.drawable.rhonda), "론다", "여성", "01/24 - 물병자리", "친절함", "모카 / 우유 많이 / 설탕 3");
                        break;
                    case 146:
                        addItemMV(getDrawable(R.drawable.ricky), "갈가리", "남성", "09/14 - 처녀자리", "무뚝뚝", "킬리만자로 / 우유 보통 / 설탕 2");
                        break;
                    case 147:
                        addItemMV(getDrawable(R.drawable.roald), "펭수", "남성", "01/05 - 양자리", "운동광", "모카 / 우유 많이 / 설탕 3");
                        break;
                    case 148:
                        addItemMV(getDrawable(R.drawable.rocco), "곤잘레스", "남성", "08/18 - 사자자리", "무뚝뚝", "모카 / 우유 X/ 설탕 X");
                        break;
                    case 149:
                        addItemMV(getDrawable(R.drawable.rod), "쟝", "남성", "08/14 - 사자자리", "운동광", "모카 / 우유 X / 설탕 X");
                        break;
                    case 150:
                        addItemMV(getDrawable(R.drawable.rodney), "지미", "남성", "11/10 - 전갈자리", "느끼함", "블랜드 / 우유 보통 / 설탕 2");
                        break;
                    case 151:
                        addItemMV(getDrawable(R.drawable.rolf), "호랭이", "남성", "08/22 - 사자자리", "무뚝뚝", "모카 / 우유 조금 / 설탕 1");
                        break;
                    case 152:
                        addItemMV(getDrawable(R.drawable.roscoe), "슈베르트", "남성", "06/16 - 쌍둥이자리", "무뚝뚝", "모카 / 우유 조금 / 설탕 1");
                        break;
                    case 153:
                        addItemMV(getDrawable(R.drawable.rosie), "부케", "여성", "02/27 - 물고기자리", "아이돌", "모카 / 우유 조금 / 설탕 1");
                        break;
                    case 154:
                        addItemMV(getDrawable(R.drawable.rowan), "고메스", "남성", "08/26 - 처녀자리", "운동광", "모카 / 우유 조금 / 설탕 1");
                        break;
                    case 155:
                        addItemMV(getDrawable(R.drawable.ruby), "루나", "여성", "12/25 - 염소자리", "아이돌", "블루마운틴 / 우유 많이 / 설탕 3");
                        break;
                    case 156:
                        addItemMV(getDrawable(R.drawable.sally), "라라미", "여성", "06/19 - 쌍둥이자리", "친절함", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 157:
                        addItemMV(getDrawable(R.drawable.sandy), "샌디", "여성", "10/21 - 천칭자리", "친절함", "블랜드 / 우유 X / 설탕 X");
                        break;
                    case 158:
                        addItemMV(getDrawable(R.drawable.shari), "젤리", "여성", "04/10 - 양자리", "단순활발", "블랜드 / 우유 X / 설탕 X");
                        break;
                    case 159:
                        addItemMV(getDrawable(R.drawable.sheldon), "크리스", "남성", "02/26 - 물고기자리", "운동광", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 160:
                        addItemMV(getDrawable(R.drawable.skye), "릴리", "여성", "03/24 - 양자리", "친절함", "킬리만자로 / 우유 X / 설탕 X");
                        break;
                    case 161:
                        addItemMV(getDrawable(R.drawable.sly), "하이드", "남성", "11/15 - 전갈자리", "운동광", "블루마운틴 / 우유 많이 / 설탕 3");
                        break;
                    case 162:
                        addItemMV(getDrawable(R.drawable.snake), "닌토", "남성", "11/03 - 전갈자리", "운동광", "블루마운틴 / 우유 많이 / 설탕 3");
                        break;
                    case 163:
                        addItemMV(getDrawable(R.drawable.spike), "스쿼트", "남성", "06/17 - 쌍둥이자리", "무뚝뚝", "킬리만자로 / 우유 보통 / 설탕 2");
                        break;
                    case 164:
                        addItemMV(getDrawable(R.drawable.sprocket), "헤르츠", "남성", "12/01 - 궁수자리", "운동광", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 165:
                        addItemMV(getDrawable(R.drawable.static_), "스파크", "남성", "07/09 - 게자리", "무뚝뚝", "킬리만자로 / 우유 보통 / 설탕 2");
                        break;
                    case 166:
                        addItemMV(getDrawable(R.drawable.stella), "아크릴", "여성", "04/09 - 양자리", "친절함", "킬리만자로 / 우유 많이 / 설탕 3");
                        break;
                    case 167:
                        addItemMV(getDrawable(R.drawable.sterling), "은수리", "남성", "12/11 - 궁수자리", "운동광", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 168:
                        addItemMV(getDrawable(R.drawable.stitches), "패치", "남성", "02/10 - 물병자리", "먹보", "블랜드 / 우유 조금 / 설탕 1");
                        break;
                    case 169:
                        addItemMV(getDrawable(R.drawable.sylvana), "실바나", "여성", "10/22 - 천칭자리", "친절함", "블루마운틴 / 우유 많이 / 설탕 3");
                        break;
                    case 170:
                        addItemMV(getDrawable(R.drawable.tammy), "아네사", "여성", "06/23 - 게자리", "단순활발", "블랜드 / 우유 조금 / 설탕 1");
                        break;
                    case 171:
                        addItemMV(getDrawable(R.drawable.tank), "탱크", "남성", "05/06 - 황소자리", "운동광", "블루마운틴 / 우유 X / 설탕 X");
                        break;
                    case 172:
                        addItemMV(getDrawable(R.drawable.t_bone), "티본", "남성", "05/20 - 황소자리", "무뚝뚝", "킬리만자로 / 우유 X / 설탕 X");
                        break;
                    case 173:
                        addItemMV(getDrawable(R.drawable.tasha), "나타샤", "여성", "11/30 - 궁수자리", "성숙함", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 174:
                        addItemMV(getDrawable(R.drawable.teddy), "병태", "남성", "09/26 - 천칭자리", "운동광", "블랜드 / 우유 보통 / 설탕 2");
                        break;
                    case 175:
                        addItemMV(getDrawable(R.drawable.tiffany), "바슬레", "여성", "01/09 - 양자리", "성숙함", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 176:
                        addItemMV(getDrawable(R.drawable.timbra), "잔디", "여성", "10/21 - 천칭자리", "성숙함", "블랜드 / 우유 보통 / 설탕 2");
                        break;
                    case 177:
                        addItemMV(getDrawable(R.drawable.truffles), "탱고", "여성", "07/28 - 사자자리", "아이돌", "블루마운틴 / 우유 조금 / 설탕 1");
                        break;
                    case 178:
                        addItemMV(getDrawable(R.drawable.tutu), "연유", "여성", "09/15 - 처녀자리", "아이돌", "블랜드 / 우유 보통 / 설탕 2");
                        break;
                    case 179:
                        addItemMV(getDrawable(R.drawable.tybalt), "티볼트", "남성", "08/19 - 사자자리", "운동광", "킬리만자로 / 우유 X / 설탕 X");
                        break;
                    case 180:
                        addItemMV(getDrawable(R.drawable.vesta), "메리어스", "여성", "04/16 - 양자리", "친절함", "블루마운틴 / 우유 조금 / 설탕 1");
                        break;
                    case 181:
                        addItemMV(getDrawable(R.drawable.victoria), "센트엘로", "여성", "07/11 - 게자리", "아이돌", "모카 / 우유 조금 / 설탕 1");
                        break;
                    case 182:
                        addItemMV(getDrawable(R.drawable.violet), "줌마", "여성", "09/01 - 처녀자리", "성숙함", "모카 / 우유 많이 / 설탕 3");
                        break;
                    case 183:
                        addItemMV(getDrawable(R.drawable.vivian), "바네사", "여성", "01/26 - 물병자리", "성숙함", "블랜드 / 우유 많이 / 설탕 3");
                        break;
                    case 184:
                        addItemMV(getDrawable(R.drawable.vladimir), "곰비", "남성", "08/02 - 사자자리", "무뚝뚝", "모카 / 우유 많이 / 설탕 3");
                        break;
                    case 185:
                        addItemMV(getDrawable(R.drawable.wendy), "눈송이", "여성", "08/15 - 사자자리", "아이돌", "블랜드 / 우유 보통 / 설탕 2");
                        break;
                    case 186:
                        addItemMV(getDrawable(R.drawable.whitney), "비앙카", "여성", "09/17 - 처녀자리", "성숙함", "모카 / 우유 조금 / 설탕 1");
                        break;
                    case 187:
                        addItemMV(getDrawable(R.drawable.willow), "마리", "여성", "11/26 - 궁수자리", "성숙함", "모카 / 우유 X / 설탕 X");
                        break;
                    case 188:
                        addItemMV(getDrawable(R.drawable.wolfgang), "로보", "남성", "11/25 - 궁수자리", "무뚝뚝", "블랜드 / 우유 많이 / 설탕 3");
                        break;
                    case 189:
                        addItemMV(getDrawable(R.drawable.zucher), "탁호", "남성", "03/08 - 물고기자리", "먹보", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;

                    case 190:
                        addItemMV(getDrawable(R.drawable.admiral), "일섭", "남성", "01/27 - 물병자리", "무뚝뚝", "블루마운틴 / 우유 보통 / 설탕 2");
                        break;
                    case 191:
                        addItemMV(getDrawable(R.drawable.al), "우락", "남성", "10/18 - 천칭자리", "먹보", "모카 / 우유 많이 / 설탕 3");
                        break;
                    case 192:
                        addItemMV(getDrawable(R.drawable.alice), "멜버른", "여성", "08/19 - 사자자리", "친절함", "모카 / 우유 X / 설탕 X");
                        break;
                    case 193:
                        addItemMV(getDrawable(R.drawable.anabelle), "아롱이", "여성", "02/16 - 물병자리", "아이돌", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 194:
                        addItemMV(getDrawable(R.drawable.anchovy), "안쵸비", "남성", "03/04 - 물고기자리", "먹보", "블루마운틴 / 우유 보통 / 설탕 2");
                        break;
                    case 195:
                        addItemMV(getDrawable(R.drawable.anicotti), "리자냐", "여성", "02/24 - 물고기자리", "아이돌", "모카 / 우유 X / 설탕 X");
                        break;
                    case 196:
                        addItemMV(getDrawable(R.drawable.ankha), "클레오", "여성", "09/22 - 처녀자리", "성숙함", "킬리만자로 / 우유 X / 설탕 X");
                        break;
                    case 197:
                        addItemMV(getDrawable(R.drawable.annalisa), "설백", "여성", "02/06 - 물병자리", "친절함", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 198:
                        addItemMV(getDrawable(R.drawable.annalise), "실부플레", "여성", "12/02 - 궁수자리", "성숙함", "블랜드 / 우유 많이 / 설탕 3");
                        break;
                    case 199:
                        addItemMV(getDrawable(R.drawable.astrid), "펑키맘", "여성", "09/08 - 처녀자리", "성숙함", "블루마운틴 / 우유 조금 / 설탕 1");
                        break;
                    case 200:
                        addItemMV(getDrawable(R.drawable.audie), "모니카", "여성", "08/31 - 처녀자리", "아이돌", "(업데이트 예정!)");
                        break;
                    case 201:
                        addItemMV(getDrawable(R.drawable.ava), "에바", "여성", "04/28 - 황소자리", "친절함", "블루마운틴 / 우유 보통 / 설탕 2");
                        break;
                    case 202:
                        addItemMV(getDrawable(R.drawable.axel), "엑스엘리", "남성", "03/23 - 양자리", "운동광", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 203:
                        addItemMV(getDrawable(R.drawable.bam), "록키", "남성", "11/07 - 전갈자리", "운동광", "블랜드 / 우유 조금 / 설탕 1");
                        break;
                    case 204:
                        addItemMV(getDrawable(R.drawable.barold), "곰시", "남성", "03/02 - 물고기자리", "먹보", "블루마운틴 / 우유 X / 설탕 X");
                        break;
                    case 205:
                        addItemMV(getDrawable(R.drawable.bea), "베이글", "여성", "10/15 - 천칭자리", "친절함", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 206:
                        addItemMV(getDrawable(R.drawable.beardo), "베어드", "남성", "09/27 - 천칭자리", "느끼함", "블루마운틴 / 우유 조금 / 설탕 1");
                        break;
                    case 207:
                        addItemMV(getDrawable(R.drawable.becky), "아리아", "여성", "12/09 - 궁수자리", "성숙함", "모카 / 우유 조금 / 설탕 1");
                        break;
                    case 208:
                        addItemMV(getDrawable(R.drawable.benedict), "페니실린", "남성", "10/10 - 천칭자리", "먹보", "모키 / 우유 조금 / 설탕 1");
                        break;
                    case 209:
                        addItemMV(getDrawable(R.drawable.benjamin), "땡칠이", "남성", "08/03 - 사자자리", "먹보", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 210:
                        addItemMV(getDrawable(R.drawable.biff), "가브리엘", "남성", "03/29 - 양자리", "운동광", "모카 / 우유 X / 설탕 X");
                        break;
                    case 211:
                        addItemMV(getDrawable(R.drawable.big_top), "3호", "남성", "10/03 - 천칭자리", "먹보", "블루마운틴 / 우유 많이 / 설탕 3");
                        break;
                    case 212:
                        addItemMV(getDrawable(R.drawable.billy), "힘드러", "남성", "03/25 - 양자리", "운동광", "블루마운틴 / 우유 X / 설탕 X");
                        break;
                    case 213:
                        addItemMV(getDrawable(R.drawable.biskit), "로빈", "남성", "05/13 - 황소자리", "먹보", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 214:
                        addItemMV(getDrawable(R.drawable.bitty), "비티", "여성", "10/06 - 천칭자리", "성숙함", "모카 / 우유 X / 설탕 X");
                        break;
                    case 215:
                        addItemMV(getDrawable(R.drawable.bluebear), "글루민", "여성", "06/24 - 게자리", "아이돌", "모카 / 우유 많이 / 설탕 3");
                        break;
                    case 216:
                        addItemMV(getDrawable(R.drawable.bones), "토미", "남성", "08/04 - 사자자리", "먹보", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 217:
                        addItemMV(getDrawable(R.drawable.boomer), "팽기", "남성", "02/07 - 물병자리", "먹보", "블랜드 / 우유 조금 / 설탕 1");
                        break;
                    case 218:
                        addItemMV(getDrawable(R.drawable.boone), "만복이", "남성", "09/12 - 처녀자리", "운동광", "블랜드 / 우유 조금 / 설탕 1");
                        break;
                    case 219:
                        addItemMV(getDrawable(R.drawable.boots), "풍작", "남성", "08/07 - 사자자리", "운동광", "블루마운틴 / 우유 많이 / 설탕 3");
                        break;
                    case 220:
                        addItemMV(getDrawable(R.drawable.boris), "보리", "남성", "11/06 - 전갈자리", "무뚝뚝", "킬리만자로 / 우유 많이 / 설탕 3");
                        break;
                    case 221:
                        addItemMV(getDrawable(R.drawable.boyd), "보이드", "남성", "10/01 - 천칭자리", "무뚝뚝", "모카 / 우유 많이 / 설탕 3");
                        break;
                    case 222:
                        addItemMV(getDrawable(R.drawable.broccolo), "브로콜리", "남성", "06/30 - 게자리", "먹보", "블랜드 / 우유 보통 / 설탕 2");
                        break;
                    case 223:
                        addItemMV(getDrawable(R.drawable.broffina), "히킨", "여성", "10/24 - 전갈자리", "성숙함", "블랜드 / 우유 많이 / 설탕 3");
                        break;
                    case 224:
                        addItemMV(getDrawable(R.drawable.bruce), "브루스", "남성", "05/26 - 쌍둥이자리", "무뚝뚝", "블루마운틴 / 우유 X / 설탕 X");
                        break;
                    case 225:
                        addItemMV(getDrawable(R.drawable.bubbles), "차코", "여성", "09/18 - 처녀자리", "아이돌", "모카 / 우유 X / 설탕 X");
                        break;
                    case 226:
                        addItemMV(getDrawable(R.drawable.camofrog), "충성", "남성", "06/05 - 쌍둥이자리", "무뚝뚝", "블루마운틴 / 우유 보통 / 설탕 2");
                        break;
                    case 227:
                        addItemMV(getDrawable(R.drawable.candi), "사탕", "여성", "04/13 - 양자리", "아이돌", "킬리만자로 / 우유 많이 / 설탕 3");
                        break;
                    case 228:
                        addItemMV(getDrawable(R.drawable.chai), "피카", "여성", "03/06 - 물고기자리", "아이돌", "블랜드 / 우유 X / 설탕 X");
                        break;
                    case 229:
                        addItemMV(getDrawable(R.drawable.chelsea), "첼시", "여성", "01/18 - 염소자리", "친절함", "모카 / 우유 많이 / 설탕 3");
                        break;
                    case 230:
                        addItemMV(getDrawable(R.drawable.cheri), "아세로라", "여성", "03/17 - 물고기자리", "아이돌", "모카 / 우유 많이 / 설탕 3");
                        break;
                    case 231:
                        addItemMV(getDrawable(R.drawable.chester), "팬타", "남성", "08/06 - 사자자리", "먹보", "블랜드 / 우유 조금 / 설탕 1");
                        break;
                    case 232:
                        addItemMV(getDrawable(R.drawable.chow), "츄앙", "남성", "07/22 - 게자리", "무뚝뚝", "블랜드 / 우유 보통/ 설탕 2");
                        break;
                    case 233:
                        addItemMV(getDrawable(R.drawable.clay), "햄둥", "남성", "10/19 - 천칭자리", "먹보", "모카 / 우유 X / 설탕 X");
                        break;
                    case 234:
                        addItemMV(getDrawable(R.drawable.cleo), "아이소토프", "여성", "02/09 - 물병자리", "성숙함", "모카 / 우유 조금 / 설탕 1");
                        break;
                    case 235:
                        addItemMV(getDrawable(R.drawable.clyde), "마철이", "남성", "05/01 - 황소자리", "먹보", "블랜드 / 우유 많이 / 설탕3");
                        break;
                    case 236:
                        addItemMV(getDrawable(R.drawable.coach), "철소", "남성", "04/29 - 황소자리", "운동광", "블랜드 / 우유 많이 / 설탕 3");
                        break;
                    case 237:
                        addItemMV(getDrawable(R.drawable.cobb), "박사", "남성", "10/07 - 천칭자리", "운동광", "블루마운틴 / 우유 조금 / 설탕 1");
                        break;
                    case 238:
                        addItemMV(getDrawable(R.drawable.cookie), "베리", "여성", "06/18 - 쌍둥이자리", "아이돌", "블랜드 / 우유 X / 설탕 X");
                        break;
                    case 239:
                        addItemMV(getDrawable(R.drawable.cousteau), "왕서방", "남성", "12/17 - 궁수자리", "운동광", "블루마운틴 / 우유 보통 / 설탕 2");
                        break;
                    case 240:
                        addItemMV(getDrawable(R.drawable.croque), "투투", "남성", "07/18 - 게자리", "무뚝뚝", "킬리만자로 / 우유 X / 설탕 X");
                        break;
                    case 241:
                        addItemMV(getDrawable(R.drawable.curly), "햄까스", "남성", "07/26 - 사자자리", "운동광", "블루마운틴 / 우유 조금 / 설탕 1");
                        break;
                    case 242:
                        addItemMV(getDrawable(R.drawable.cyd), "펑크스", "남성", "06/09 - 쌍둥이자리", "무뚝뚝", "(업데이트 예정!)");
                        break;
                    case 243:
                        addItemMV(getDrawable(R.drawable.cyrano), "사지마", "남성", "03/09 - 물고기자리", "무뚝뚝", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 244:
                        addItemMV(getDrawable(R.drawable.daisy), "바닐라", "여성", "11/16 - 전갈자리", "친절함", "블루마운틴 / 우유 많이 / 설탕 3");
                        break;
                    case 245:
                        addItemMV(getDrawable(R.drawable.deena), "마리모", "여성", "06/27 - 게자리", "친절함", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 246:
                        addItemMV(getDrawable(R.drawable.del), "파도맨", "남성", "05/27 - 쌍둥이자리", "무뚝뚝", "블랜드 / 우유 X / 설탕 X");
                        break;
                    case 247:
                        addItemMV(getDrawable(R.drawable.deli), "델리", "남성", "05/24 - 쌍둥이자리", "먹보", "블루마운틴 / 우유 많이 / 설탕 3");
                        break;
                    case 248:
                        addItemMV(getDrawable(R.drawable.derwin), "봉", "남성", "05/25 - 쌍둥이자리", "먹보", "블랜드 / 우유 X / 설탕 X");
                        break;
                    case 249:
                        addItemMV(getDrawable(R.drawable.diva), "아이다", "여성", "10/02 - 천칭자리", "단순활발", "킬리만자로 / 우유 X / 설탕 X");
                        break;
                    case 250:
                        addItemMV(getDrawable(R.drawable.dom), "차둘", "남성", "03/18 - 물고기자리", "운동광", "(업데이트 예정!)");
                        break;
                    case 251:
                        addItemMV(getDrawable(R.drawable.dora), "티미", "여성", "02/18 - 물병자리", "친절함", "킬리만자로 / 우유 많이 / 설탕 3");
                        break;
                    case 252:
                        addItemMV(getDrawable(R.drawable.drago), "용남이", "남성", "02/12 - 물병자리", "먹보", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 253:
                        addItemMV(getDrawable(R.drawable.drake), "푸아그라", "남성", "06/25 - 게자리", "먹보", "블랜드 / 우유 X / 설탕 X");
                        break;
                    case 254:
                        addItemMV(getDrawable(R.drawable.ed), "꺼벙", "남성", "09/16 - 처녀자리", "느끼함", "블루마운틴 / 우유 보통 / 설탕 2");
                        break;
                    case 255:
                        addItemMV(getDrawable(R.drawable.elise), "몽자", "여성", "03/21 - 양자리", "성숙함", "블랜드 / 우유 X / 설탕 X");
                        break;
                    case 256:
                        addItemMV(getDrawable(R.drawable.ellie), "에끌레르", "여성", "05/12 - 황소자리", "친절함", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 257:
                        addItemMV(getDrawable(R.drawable.elmer), "샤브렌", "남성", "10/05 - 천칭자리", "먹보", "블랜드 / 우유 많이 / 설탕 3");
                        break;
                    case 258:
                        addItemMV(getDrawable(R.drawable.elvis), "킹", "남성", "07/23 - 사자자리", "무뚝뚝", "블루마운틴 / 우유 X / 설탕 X");
                        break;
                    case 259:
                        addItemMV(getDrawable(R.drawable.etoile), "에뜨와르", "여성", "12/25 - 염소자리", "친절함", "킬리만자로 / 우유 많이 / 설탕 3");
                        break;
                    case 260:
                        addItemMV(getDrawable(R.drawable.eugene), "코알", "남성", "10/26 - 전갈자리", "느끼함", "모카 / 우유 X / 설탕 X");
                        break;
                    case 261:
                        addItemMV(getDrawable(R.drawable.felicity), "예링", "여성", "03/30 - 양자리", "아이돌", "블루마운틴 / 우유 보통 / 설탕 2");
                        break;
                    case 262:
                        addItemMV(getDrawable(R.drawable.flo), "레이라", "여성", "09/02 - 처녀자리", "단순활발", "블랜드 / 우유 조금 / 설탕 1");
                        break;
                    case 263:
                        addItemMV(getDrawable(R.drawable.freckles), "다랑어", "여성", "02/19 - 물병자리", "아이돌", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 264:
                        addItemMV(getDrawable(R.drawable.frobert), "구리구리", "남성", "02/08 - 물병자리", "운동광", "블루마운틴 / 우유 보통 / 설탕 2");
                        break;
                    case 265:
                        addItemMV(getDrawable(R.drawable.gala), "꽃지", "여성", "03/05 - 물고기자리", "친절함", "모카 / 우유 X / 설탕 X");
                        break;
                    case 266:
                        addItemMV(getDrawable(R.drawable.gayle), "앨리", "여성", "05/17 - 황소자리", "친절함", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 267:
                        addItemMV(getDrawable(R.drawable.gigi), "린다", "여성", "08/11 - 사자자리", "성숙함", "킬리만자로 / 우유 X / 설탕 X");
                        break;
                    case 268:
                        addItemMV(getDrawable(R.drawable.gloria), "마릴린", "여성", "08/12 - 사자자리", "성숙함", "블랜드 / 우유 X / 설탕 X");
                        break;
                    case 269:
                        addItemMV(getDrawable(R.drawable.gonzo), "근성", "남성", "10/13 - 천칭자리", "무뚝뚝", "킬리만자로 / 우유 많이 / 설탕 3");
                        break;
                    case 270:
                        addItemMV(getDrawable(R.drawable.graham), "글라햄", "남성", "06/20 - 쌍둥이자리", "느끼함", "블랜드 / 우유 보통 / 설탕 2");
                        break;
                    case 271:
                        addItemMV(getDrawable(R.drawable.grizzly), "무뚝", "남성", "07/31 - 사자자리", "무뚝뚝", "블랜드 / 우유 보통 / 설탕 2");
                        break;
                    case 272:
                        addItemMV(getDrawable(R.drawable.groucho), "거무틱", "남성", "10/23 - 전갈자리", "무뚝뚝", "블랜드 / 우유 보통 / 설탕 2");
                        break;
                    case 273:
                        addItemMV(getDrawable(R.drawable.gruff), "빌리", "남성", "08/29 처녀자리", "무뚝뚝", "블랜드 / 우유 조금 / 설탕 1");
                        break;
                    case 274:
                        addItemMV(getDrawable(R.drawable.gwen), "폴라", "여성", "01/23 - 물병자리", "성숙함", "블랜드 / 우유 조금 / 설탕 1");
                        break;
                    case 275:
                        addItemMV(getDrawable(R.drawable.hamphrey), "햄쥐", "남성", "02/25 - 물고기자리", "무뚝뚝", "블루마운틴 / 우유 조금 / 설탕 1");
                        break;
                    case 276:
                        addItemMV(getDrawable(R.drawable.harry), "올리버", "남성", "01/07 - 염소자리", "무뚝뚝", "모카 / 우유 X / 설탕 X");
                        break;
                    case 277:
                        addItemMV(getDrawable(R.drawable.henry), "헨리", "남성", "09/21 - 처녀자리", "느끼함", "모카 / 우유 조금 / 설탕 1");
                        break;
                    case 278:
                        addItemMV(getDrawable(R.drawable.hippeux), "데이빗", "남성", "10/15 - 천칭자리", "느끼함", "킬리만자로 / 우유 많이 / 설탕 3");
                        break;
                    case 279:
                        addItemMV(getDrawable(R.drawable.huck), "스트로", "남성", "07/09 - 게자리", "느끼함", "모카 / 우유 조금 / 설탕 1");
                        break;
                    case 280:
                        addItemMV(getDrawable(R.drawable.hugh), "먹고파", "남성", "12/30 - 염소자리", "먹보", "킬리만자로 / 우유 많이 / 설탕 3");
                        break;
                    case 281:
                        addItemMV(getDrawable(R.drawable.ike), "대공", "남성", "05/16 - 황소자리", "무뚝뚝", "모카 / 우유 X / 설탕 X");
                        break;
                    case 282:
                        addItemMV(getDrawable(R.drawable.jacob), "야곱", "남성", "08/24 - 처녀자리", "먹보", "모카 / 우유 조금 / 설탕 1");
                        break;
                    case 283:
                        addItemMV(getDrawable(R.drawable.jacques), "쪼끼", "남성", "06/22 - 게자리", "느끼함", "블랜드 / 우유 많이 / 설탕 3");
                        break;
                    case 284:
                        addItemMV(getDrawable(R.drawable.jambette), "에스메랄다", "여성", "10/27 - 전갈자리", "친절함", "모카 / 우유 조금 / 설탕 1");
                        break;
                    case 285:
                        addItemMV(getDrawable(R.drawable.jeremiah), "드리미", "남성", "07/08 - 게자리", "먹보", "킬리만자로 / 우유 X / 설탕 X");
                        break;
                    case 286:
                        addItemMV(getDrawable(R.drawable.joey), "리처드", "남성", "01/03 - 염소자리", "먹보", "블랜드 / 우유 X / 설탕 X");
                        break;
                    case 287:
                        addItemMV(getDrawable(R.drawable.judy), "미애", "여성", "03/10 - 물고기자리", "성숙함", "(업데이트 예정!)");
                        break;
                    case 288:
                        addItemMV(getDrawable(R.drawable.june), "메이", "여성", "05/21 - 쌍둥이자리", "친절함", "블루마운틴 / 우유 X / 설탕 X");
                        break;
                    case 289:
                        addItemMV(getDrawable(R.drawable.kabuki), "가북희", "남성", "11/29 - 궁수자리", "무뚝뚝", "블루마운틴 / 우유 보통 / 설탕 2");
                        break;
                    case 290:
                        addItemMV(getDrawable(R.drawable.ken), "오골", "남성", "12/23 - 염소자리", "느끼함", "블루마운틴 / 우유 보통 / 설탕 2");
                        break;
                    case 291:
                        addItemMV(getDrawable(R.drawable.ketchup), "케첩", "여성", "07/27 - 사자자리", "아이돌", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 292:
                        addItemMV(getDrawable(R.drawable.kidd), "염두리", "남성", "06/28 - 게자리", "느끼함", "킬리만자로 / 우유 보통 / 설탕 2");
                        break;
                    case 293:
                        addItemMV(getDrawable(R.drawable.kitty), "쇼콜라", "여성", "02/15 - 물병자리", "성숙함", "킬리만자로 / 우유 X / 설탕 X");
                        break;
                    case 294:
                        addItemMV(getDrawable(R.drawable.knox), "금끼오", "남성", "11/23 - 궁수자리", "무뚝뚝", "블랜드 / 우유 많이 / 설탕 3");
                        break;
                    case 295:
                        addItemMV(getDrawable(R.drawable.kody), "아이다호", "남성", "09/28 - 천칭자리", "운동광", "모카 / 우유 많이 / 설탕 3");
                        break;
                    case 296:
                        addItemMV(getDrawable(R.drawable.limberg), "단무지", "남성", "10/17 - 천칭자리", "무뚝뚝", "모카 / 우유 X / 설탕 X");
                        break;
                    case 297:
                        addItemMV(getDrawable(R.drawable.lionel), "라이오넬", "남성", "07/29 - 사자자리", "느끼함", "모카 / 우유 많이 / 설탕 3");
                        break;
                    case 298:
                        addItemMV(getDrawable(R.drawable.louie), "머슬", "남성", "03/26 - 양자리", "운동광", "블루마운틴 / 우유 X / 설탕 X");
                        break;
                    case 299:
                        addItemMV(getDrawable(R.drawable.lucha), "마스카라스", "남성", "12/12 - 궁수자리", "느끼함", "블랜드 / 우유 많이 / 설탕 3");
                        break;
                    case 300:
                        addItemMV(getDrawable(R.drawable.lucky), "럭키", "남성", "11/04 - 전갈자리", "먹보", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 301:
                        addItemMV(getDrawable(R.drawable.lucy), "루시", "여성", "06/02 - 쌍둥이자리", "친절함", "모카 / 우유 X / 설탕 X");
                        break;
                    case 302:
                        addItemMV(getDrawable(R.drawable.lyman), "오즈먼드", "남성", "10/12 - 천칭자리", "운동광", "모카 / 우유 X / 설탕 X");
                        break;
                    case 303:
                        addItemMV(getDrawable(R.drawable.mac), "챔프", "남성", "11/11 - 전갈자리", "운동광", "블랜드 / 우유 X / 설탕 X");
                        break;
                    case 304:
                        addItemMV(getDrawable(R.drawable.maddie), "마롱", "여성", "01/11 - 염소자리", "아이돌", "블루마운틴 / 우유 많이 / 설탕 3");
                        break;
                    case 305:
                        addItemMV(getDrawable(R.drawable.maelle), "앤", "여성", "04/08 - 양자리", "성숙함", "블랜드 / 우유 X / 설탕 X");
                        break;
                    case 306:
                        addItemMV(getDrawable(R.drawable.maggie), "마가렛", "여성", "09/03 - 처녀자리", "친절함", "블랜드 / 우유 보통 / 설탕 2");
                        break;
                    case 307:
                        addItemMV(getDrawable(R.drawable.maple), "메이첼", "여성", "06/15 - 쌍둥이자리", "친절함", "킬리만자로 / 우유 보통 / 설탕 2");
                        break;
                    case 308:
                        addItemMV(getDrawable(R.drawable.marcel), "에드워드", "남성", "12/31 - 염소자리", "먹보", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 309:
                        addItemMV(getDrawable(R.drawable.marcie), "마리아", "여성", "05/31 - 쌍둥이자리", "친절함", "모카 / 우유 X / 설탕 X");
                        break;
                    case 310:
                        addItemMV(getDrawable(R.drawable.mathilda), "안젤라", "여성", "11/12 - 전갈자리", "성숙함", "블루마운틴 / 우유 조금 / 설탕 1");
                        break;
                    case 311:
                        addItemMV(getDrawable(R.drawable.megan), "캔디", "여성", "03/13 - 물고기자리", "친절함", "(업데이트 예정!)");
                        break;
                    case 312:
                        addItemMV(getDrawable(R.drawable.midge), "핑글이", "여성", "03/12 - 물고기자리", "친절함", "블랜드 / 우유 많이 / 설탕 3");
                        break;
                    case 313:
                        addItemMV(getDrawable(R.drawable.miranda), "미란다", "여성", "04/23 - 황소자리", "성숙함", "블랜드 / 우유 X / 설탕 X");
                        break;
                    case 314:
                        addItemMV(getDrawable(R.drawable.mitzi), "마르", "여성", "09/25 - 천칭자리", "친절함", "모카 / 우유 조금 / 설탕 1");
                        break;
                    case 315:
                        addItemMV(getDrawable(R.drawable.moe), "진상", "남성", "01/12 - 염소자리", "먹보", "킬리만자로 / 우유 X / 설탕 X");
                        break;
                    case 316:
                        addItemMV(getDrawable(R.drawable.monique), "제인", "여성", "09/30 - 천칭자리", "성숙함", "킬리만자로 / 우유 X / 설탕 X");
                        break;
                    case 317:
                        addItemMV(getDrawable(R.drawable.monty), "몽티", "남성", "12/07 - 궁수자리", "무뚝뚝", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 318:
                        addItemMV(getDrawable(R.drawable.moose), "핑", "남성", "09/13 - 처녀자리", "운동광", "모카 / 우유 X / 설탕 X");
                        break;
                    case 319:
                        addItemMV(getDrawable(R.drawable.mott), "릭", "남성", "07/10 - 게자리", "운동광", "블루마운틴 / 우유 X / 설탕 X");
                        break;
                    case 320:
                        addItemMV(getDrawable(R.drawable.murphy), "머피", "남성", "12/29 - 염소자리", "무뚝뚝", "블랜드 / 우유 조금 / 설탕 1");
                        break;
                    case 321:
                        addItemMV(getDrawable(R.drawable.nan), "순이", "여성", "08/24 - 처녀자리", "친절함", "블루마운틴 / 우유 X / 설탕 X");
                        break;
                    case 322:
                        addItemMV(getDrawable(R.drawable.nana), "키키", "여성", "08/23 - 처녀자리", "친절함", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 323:
                        addItemMV(getDrawable(R.drawable.naomi), "화자", "여성", "02/28 - 물고기자리", "성숙함", "킬리만자로 / 우유 보통 / 설탕 2");
                        break;
                    case 324:
                        addItemMV(getDrawable(R.drawable.nate), "박하스", "남성", "08/16 - 사자자리", "먹보", "모카 / 우유 X / 설탕 X");
                        break;
                    case 325:
                        addItemMV(getDrawable(R.drawable.norma), "미자", "여성", "09/20 - 처녀자리", "친절함", "모카 / 우유 많이 / 설탕 3");
                        break;
                    case 326:
                        addItemMV(getDrawable(R.drawable.olaf), "안토니오", "남성", "05/19 - 황소자리", "느끼함", "블랜드 / 우유 X / 설탕 X");
                        break;
                    case 327:
                        addItemMV(getDrawable(R.drawable.olive), "올리브", "여성", "07/12 - 게자리", "친절함", "블루마운틴 / 우유 X / 설탕 X");
                        break;
                    case 328:
                        addItemMV(getDrawable(R.drawable.opal), "오팔", "여성", "01/20 - 물병자리", "성숙함", "블루마운틴 / 우유 많이 / 설탕 3");
                        break;
                    case 329:
                        addItemMV(getDrawable(R.drawable.pango), "패트라", "여성", "11/09 - 전갈자리", "아이돌", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 330:
                        addItemMV(getDrawable(R.drawable.paolo), "파올로", "남성", "05/05 - 황소자리", "먹보", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 331:
                        addItemMV(getDrawable(R.drawable.papi), "마사마", "남성", "01/10 - 염소자리", "먹보", "블루마운틴 / 우유 보통 / 설탕 2");
                        break;
                    case 332:
                        addItemMV(getDrawable(R.drawable.pashmina), "바바라", "여성", "12/26 - 염소자리", "단순활발", "모카 / 우유 많이 / 설탕 3");
                        break;
                    case 333:
                        addItemMV(getDrawable(R.drawable.pate), "나키", "여성", "02/23 - 물고기자리", "아이돌", "모카 / 우유 보통/ 설탕 2");
                        break;
                    case 334:
                        addItemMV(getDrawable(R.drawable.paula), "레이첼", "여성", "03/22 - 양자리", "단순활발", "킬리만자로 / 우유 많이 / 설탕 3");
                        break;
                    case 335:
                        addItemMV(getDrawable(R.drawable.peck), "문대", "남성", "07/25 - 사자자리", "운동광", "블랜드 / 우유 많이 / 설탕 3");
                        break;
                    case 336:
                        addItemMV(getDrawable(R.drawable.peggy), "체리", "여성", "05/23 - 쌍둥이자리", "아이돌", "블루마운틴 / 우유 조금 / 설탕 1");
                        break;
                    case 337:
                        addItemMV(getDrawable(R.drawable.plucky), "파타야", "여성", "10/12 - 천칭자리", "단순활발", "모카 / 우유 조금 / 설탕 1");
                        break;
                    case 338:
                        addItemMV(getDrawable(R.drawable.pompom), "주디", "여성", "02/11 - 물병자리", "아이돌", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 339:
                        addItemMV(getDrawable(R.drawable.portia), "블랜더", "여성", "10/25 - 전갈자리", "성숙함", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 340:
                        addItemMV(getDrawable(R.drawable.prince), "카일", "남성", "07/21 - 게자리", "먹보", "킬리만자로 / 우유 X / 설탕 X");
                        break;
                    case 341:
                        addItemMV(getDrawable(R.drawable.puck), "하키", "남성", "02/21 - 물고기자리", "먹보", "블랜드 / 우유 조금 / 설탕 1");
                        break;
                    case 342:
                        addItemMV(getDrawable(R.drawable.puddles), "가위", "여성", "01/13 - 염소자리", "아이돌", "블루마운틴 / 우유 보통 / 설탕 2");
                        break;
                    case 343:
                        addItemMV(getDrawable(R.drawable.pudge), "우띠", "남성", "06/11 - 쌍둥이자리", "먹보", "블랜드 / 우유 조금 / 설탕 1");
                        break;
                    case 344:
                        addItemMV(getDrawable(R.drawable.quillson), "덕근", "남성", "12/22 - 염소자리", "느끼함", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 345:
                        addItemMV(getDrawable(R.drawable.raddle), "개군", "남성", "06/06 - 쌍둥이자리", "먹보", "블랜드 / 우유 많이 / 설탕 3");
                        break;
                    case 346:
                        addItemMV(getDrawable(R.drawable.rasher), "글레이", "남성", "04/07 - 양자리", "무뚝뚝", "블루마운틴 / 우유 조금 / 설탕 1");
                        break;
                    case 347:
                        addItemMV(getDrawable(R.drawable.raymond), "잭슨", "남성", "10/01 - 천칭자리", "느끼함", "(업데이트 예정!)");
                        break;
                    case 348:
                        addItemMV(getDrawable(R.drawable.reneigh), "리아나", "여성", "06/04 - 쌍둥이자리", "단순활발", "(업데이트 예정!)");
                        break;
                    case 349:
                        addItemMV(getDrawable(R.drawable.rex), "렉스", "남성", "07/24 - 사자자리", "먹보", "블랜드 / 우유 조금 / 설탕 1");
                        break;
                    case 350:
                        addItemMV(getDrawable(R.drawable.ribbot), "철컥", "남성", "02/12 - 물병자리", "운동광", "블루마운틴 / 우유 보통 / 설탕 2");
                        break;
                    case 351:
                        addItemMV(getDrawable(R.drawable.rilla), "릴라", "여성", "11/01 - 전갈자리", "아이돌", "블루마운틴 / 우유 X / 설탕 X");
                        break;
                    case 352:
                        addItemMV(getDrawable(R.drawable.rizzo), "조르직", "남성", "01/17 - 염소자리", "무뚝뚝", "모카 / 우유 X / 설탕 X");
                        break;
                    case 353:
                        addItemMV(getDrawable(R.drawable.robin), "파틱", "여성", "12/04 - 궁수자리", "성숙함", "블루마운틴 / 우유 보통 / 설탕 2");
                        break;
                    case 354:
                        addItemMV(getDrawable(R.drawable.rocket), "4호", "여성", "04/14 - 양자리", "단순활발", "킬리만자로 / 우유 보통 / 설탕 2");
                        break;
                    case 355:
                        addItemMV(getDrawable(R.drawable.rodeo), "로데오", "남성", "10/29 - 전갈자리", "먹보", "블루마운틴 / 우유 보통 / 설탕 2");
                        break;
                    case 356:
                        addItemMV(getDrawable(R.drawable.rooney), "마이크", "남성", "12/01 - 궁수자리", "무뚝뚝", "블루마운틴 / 우유 조금 / 설탕 1");
                        break;
                    case 357:
                        addItemMV(getDrawable(R.drawable.rory), "아더", "남성", "08/07 - 사자자리", "운동광", "모카 / 우유 많이 / 설탕 3");
                        break;
                    case 358:
                        addItemMV(getDrawable(R.drawable.rudy), "찰스", "남성", "12/20 - 궁수자리", "운동광", "모카 / 우유 조금 / 설탕 1");
                        break;
                    case 359:
                        addItemMV(getDrawable(R.drawable.samson), "피스", "남성", "07/05 - 게자리", "운동광", "모카 / 우유 X / 설탕 X");
                        break;
                    case 360:
                        addItemMV(getDrawable(R.drawable.savannah), "사반나", "여성", "01/25 - 물병자리", "친절함", "킬리만자로 / 우유 X / 설탕 X");
                        break;
                    case 361:
                        addItemMV(getDrawable(R.drawable.scoot), "지키미", "남성", "06/13 - 쌍둥이자리", "운동광", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 362:
                        addItemMV(getDrawable(R.drawable.shep), "밥", "남성", "11/24 - 궁수자리", "느끼함", "블루마운틴 / 우유 많이 / 설탕 3");
                        break;
                    case 363:
                        addItemMV(getDrawable(R.drawable.sherb), "래미", "남성", "01/18 - 염소자리", "먹보", "(업데이트 예정!)");
                        break;
                    case 364:
                        addItemMV(getDrawable(R.drawable.simon), "시몬", "남성", "01/19 - 염소자리", "먹보", "블랜드 / 우유 X / 설탕 X");
                        break;
                    case 365:
                        addItemMV(getDrawable(R.drawable.snooty), "스누티", "여성", "10/24 - 전갈자리", "성숙함", "킬리만자로 / 우유 조금 / 설탕 1");
                        break;
                    case 366:
                        addItemMV(getDrawable(R.drawable.soleil), "샨티", "여성", "08/09 - 사자자리", "성숙함", "킬리만자로 / 우유 많이 / 설탕 3");
                        break;
                    case 367:
                        addItemMV(getDrawable(R.drawable.sparro), "춘섭", "남성", "11/20 - 전갈자리", "운동광", "블랜드 / 우유 많이 / 설탕 3");
                        break;
                    case 368:
                        addItemMV(getDrawable(R.drawable.spork), "포크", "남성", "09/03 - 처녀자리", "먹보", "킬리만자로 / 우유 많이 / 설탕 3");
                        break;
                    case 369:
                        addItemMV(getDrawable(R.drawable.sprinkle), "크리미", "여성", "02/20 - 물고기자리", "아이돌", "킬리만자로 /우유 보통 / 설탕 2");
                        break;
                    case 370:
                        addItemMV(getDrawable(R.drawable.stinky), "땀띠", "남성", "08/17 - 사자자리", "운동광", "블루마운틴 / 우유 보통 / 설탕 2");
                        break;
                    case 371:
                        addItemMV(getDrawable(R.drawable.stu), "모리스", "남성", "04/20 - 황소자리", "먹보", "모카 / 우유 조금 / 설탕 1");
                        break;
                    case 372:
                        addItemMV(getDrawable(R.drawable.sydney), "시드니", "여성", "06/21 - 쌍둥이자리", "친절함", "모카 / 우유 X / 설탕 X");
                        break;
                    case 373:
                        addItemMV(getDrawable(R.drawable.sylvia), "실비아", "여성", "05/03 - 황소자리", "단순활발", "모카 / 우유 X / 설탕 X");
                        break;
                    case 374:
                        addItemMV(getDrawable(R.drawable.tabby), "호냥이", "여성", "08/13 - 사자자리", "아이돌", "블루마운틴 / 우유 보통 / 설탕 2");
                        break;
                    case 375:
                        addItemMV(getDrawable(R.drawable.tad), "텀보", "남성", "08/03 - 사자자리", "운동광", "모카 / 우유 조금 / 설탕 1");
                        break;
                    case 376:
                        addItemMV(getDrawable(R.drawable.tammi), "에이프릴", "여성", "04/02 - 양자리", "아이돌", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 377:
                        addItemMV(getDrawable(R.drawable.tangy), "백프로", "여성", "06/17 - 쌍둥이자리", "아이돌", "블루마운틴 / 우유 보통 / 설탕 2");
                        break;
                    case 378:
                        addItemMV(getDrawable(R.drawable.tex), "볼트", "남성", "10/06 - 천칭자리", "느끼함", "킬리만자로 / 우유 보통 / 설탕 2");
                        break;
                    case 379:
                        addItemMV(getDrawable(R.drawable.tia), "티나", "여성", "11/18 - 전갈자리", "친절함", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 380:
                        addItemMV(getDrawable(R.drawable.tipper), "마틸다", "여성", "08/25 - 처녀자리", "성숙함", "블루마운틴 / 우유 X / 설탕 X");
                        break;
                    case 381:
                        addItemMV(getDrawable(R.drawable.toby), "토비", "남성", "07/10 - 게자리", "느끼함", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 382:
                        addItemMV(getDrawable(R.drawable.tom), "밴덤", "남성", "12/10 - 궁수자리", "무뚝뚝", "블루마운틴 / 우유 보통 / 설탕 2");
                        break;
                    case 383:
                        addItemMV(getDrawable(R.drawable.tucker), "맘모", "남성", "09/07 - 처녀자리", "먹보", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 384:
                        addItemMV(getDrawable(R.drawable.twiggy), "핀틱", "여성", "07/13 - 게자리", "아이돌", "킬리만자로 / 우유 X / 설탕 X");
                        break;
                    case 385:
                        addItemMV(getDrawable(R.drawable.ursala), "네이아", "여성", "01/16 - 염소자리", "단순활발", "모카 / 우유 X / 설탕 X");
                        break;
                    case 386:
                        addItemMV(getDrawable(R.drawable.velma), "벨마", "여성", "01/14 - 염소자리", "성숙함", "모카 / 우유 많이 / 설탕 3");
                        break;
                    case 387:
                        addItemMV(getDrawable(R.drawable.vic), "노르망", "남성", "12/29 - 염소자리", "무뚝뚝", "블루마운틴 / 우유 보통 / 설탕 2");
                        break;
                    case 388:
                        addItemMV(getDrawable(R.drawable.wade), "호떡", "남성", "10/30 - 전갈자리", "먹보", "블루마운틴 / 우유 X / 설탕 X");
                        break;
                    case 389:
                        addItemMV(getDrawable(R.drawable.walker), "벤", "남성", "06/10 - 쌍둥이자리", "먹보", "모카 / 우유 보통 / 설탕 2");
                        break;
                    case 390:
                        addItemMV(getDrawable(R.drawable.walt), "관록", "남성", "04/24 - 황소자리", "무뚝뚝", "블루마운틴 / 우유 조금 / 설탕 2");
                        break;
                    case 391:
                        addItemMV(getDrawable(R.drawable.wart_jr), "샘", "남성", "08/21 - 사자자리", "무뚝뚝", "블루마운틴 / 우유 보통 / 설탕 2");
                        break;
                    case 392:
                        addItemMV(getDrawable(R.drawable.weber), "아잠만", "남성", "06/30 - 게자리", "먹보", "블루마운틴 / 우유 많이 / 설탕 3");
                        break;
                    case 393:
                        addItemMV(getDrawable(R.drawable.winnie), "카로틴", "여성", "01/31 - 물병자리", "아이돌", "모카 / 우유 조금 / 설탕 1");
                        break;
                    case 394:
                        addItemMV(getDrawable(R.drawable.yuka), "유카리", "여성", "07/20 - 게자리", "성숙함", "킬리만자로 / 우유 많이 / 설탕 3");
                        break;
                    case 395:
                        addItemMV(getDrawable(R.drawable.zell), "넬슨", "남성", "06/07 - 쌍둥이자리", "느끼함", "블랜드 / 우유 조금 / 설탕 1");
                        break;
                    default:
                        break;
                }
            }
        } else {
            //default 영어
            for (int i=0; i<numResident; i++) {
                switch (ResiArray[i]) {
                    case 1:
                        addItemMV(getDrawable(R.drawable.agent_s), "Agent S", "Female", "Jul 02 - Cancer", "Peppy", "Mocha / regular / 2T");
                        break;
                    case 2:
                        addItemMV(getDrawable(R.drawable.agnes), "Agnes", "Female", "Apr 21 - Taurus", "Uchi", "Kilimanjaro / lots / 3T");
                        break;
                    case 3:
                        addItemMV(getDrawable(R.drawable.alfonso), "Alfonso", "Male", "Jun 09 - Gemini", "Lazy", "Mocha / regular / 2T");
                        break;
                    case 4:
                        addItemMV(getDrawable(R.drawable.alli), "Alli", "Female", "Nov 08 - Scorpio", "Snooty", "Mocha / regular / 2T");
                        break;
                    case 5:
                        addItemMV(getDrawable(R.drawable.amelia), "Amelia", "Female", "Nov 19 - Scorpio", "Snooty", "Blue Mt. / lots / 3T");
                        break;
                    case 6:
                        addItemMV(getDrawable(R.drawable.angus), "Angus", "Male", "Apr 30 - Taurus", "Cranky", "Kilimanjaro / X / X");
                        break;
                    case 7:
                        addItemMV(getDrawable(R.drawable.antonio), "Antonio", "Male", "Oct 20 - Libra", "Jock", "Kilimanjaro / a bit / 1T");
                        break;
                    case 8:
                        addItemMV(getDrawable(R.drawable.apollo), "Apollo", "Male", "Jul 04 - Cancer", "Cranky", "Kilimanjaro / a bit / 1T");
                        break;
                    case 9:
                        addItemMV(getDrawable(R.drawable.apple), "Apple", "Female", "Sep 24 - Libra", "Peppy", "Blend / regular / 2T");
                        break;
                    case 10:
                        addItemMV(getDrawable(R.drawable.aurora), "Aurora", "Female", "Jan 27 - Aquarius", "Normal", "Kilimanjaro / regular / 2T");
                        break;
                    case 11:
                        addItemMV(getDrawable(R.drawable.avery), "Avery", "Male", "Feb 22 - Pisces", "Cranky", "Kilimanjaro / a bit / 1T");
                        break;
                    case 12:
                        addItemMV(getDrawable(R.drawable.baabara), "Baabara", "Female", "Mar 28 - Aries", "Snooty", "Mocha / X / X");
                        break;
                    case 13:
                        addItemMV(getDrawable(R.drawable.bangle), "Bangle", "Female", "Aug 27 - Virgo", "Snooty", "Mocha / a bit / 1T");
                        break;
                    case 14:
                        addItemMV(getDrawable(R.drawable.beau), "Beau", "Male", "Apr 05 - Aries", "Lazy", "Mocha / lots / 3T");
                        break;
                    case 15:
                        addItemMV(getDrawable(R.drawable.bella), "Bella", "Female", "Dec 28 - Capricorn", "Peppy", "Mocha / X / X");
                        break;
                    case 16:
                        addItemMV(getDrawable(R.drawable.bertha), "Bertha", "Female", "Apr 25 - Taurus", "Normal", "Kilimanjaro / lots / 3T");
                        break;
                    case 17:
                        addItemMV(getDrawable(R.drawable.bettina), "Bettina", "Female", "Jun 12 - Gemini", "Normal", "Kilimanjaro / lots / 3T");
                        break;
                    case 18:
                        addItemMV(getDrawable(R.drawable.bianca), "Bianca", "Female", "Dec 13 - Sagittarius", "Peppy", "Kilimanjaro / X / X");
                        break;
                    case 19:
                        addItemMV(getDrawable(R.drawable.bill), "Bill", "Male", "Feb 01 - Aquarius", "Jock", "Kilimanjaro / a bit / 1T");
                        break;
                    case 20:
                        addItemMV(getDrawable(R.drawable.blaire), "Blaire", "Female", "Jul 03 - Cancer", "Snooty", "Blend / X / X");
                        break;
                    case 21:
                        addItemMV(getDrawable(R.drawable.blanche), "Blanche", "Female", "Dec 21 - Sagittarius", "Snooty", "Blue Mt. / lots / 3T");
                        break;
                    case 22:
                        addItemMV(getDrawable(R.drawable.bob), "Bob", "Male", "Jan 01 - Capricorn", "Lazy", "Kilimanjaro / X / X");
                        break;
                    case 23:
                        addItemMV(getDrawable(R.drawable.bonbon), "Bonbon", "Female", "Mar 03 - Pisces", "Peppy", "Mocha / regular / 2T");
                        break;
                    case 24:
                        addItemMV(getDrawable(R.drawable.bree), "Bree", "Female", "Jul 07 - Cancer", "Snooty", "Blend / regular / 2T");
                        break;
                    case 25:
                        addItemMV(getDrawable(R.drawable.buck), "Buck", "Male", "Apr 04 - Aries", "Jock", "Mocha / a bit / 1T");
                        break;
                    case 26:
                        addItemMV(getDrawable(R.drawable.bud), "Bud", "Male", "Aug 08 - Leo", "Jock", "Blue Mt. / X / X");
                        break;
                    case 27:
                        addItemMV(getDrawable(R.drawable.bunnie), "Bunnie", "Female", "May 09 - Taurus", "Peppy", "Blue Mt. / lots / 3T");
                        break;
                    case 28:
                        addItemMV(getDrawable(R.drawable.butch), "Butch", "Male", "Nov 01 - Scorpio", "Cranky", "Blend / X / X");
                        break;
                    case 29:
                        addItemMV(getDrawable(R.drawable.buzz), "Buzz", "Male", "Dec 07 - Sagittarius", "Cranky", "Blue Mt. / lots / 3T");
                        break;
                    case 30:
                        addItemMV(getDrawable(R.drawable.cally), "Cally", "Female", "Sep 04 - Virgo", "Normal", "Kilimanjaro / a bit / 1T");
                        break;
                    case 31:
                        addItemMV(getDrawable(R.drawable.canberra), "Canberra", "Female", "May 14 - Taurus", "Uchi", "Kilimanjaro / lots / 3T");
                        break;
                    case 32:
                        addItemMV(getDrawable(R.drawable.carmen), "Carmen", "Female", "Jan 06 - Capricorn", "Peppy", "Blue Mt. / lots / 3T");
                        break;
                    case 33:
                        addItemMV(getDrawable(R.drawable.caroline), "Caroline", "Female", "Jul 15 - Cancer", "Normal", "Kilimanjaro / a bit / 1T");
                        break;
                    case 34:
                        addItemMV(getDrawable(R.drawable.carrie), "Carrie", "Female", "Dec 05 - Sagittarius", "Normal", "Mocha / X / X");
                        break;
                    case 35:
                        addItemMV(getDrawable(R.drawable.cashmere), "Cashmere", "Female", "Apr 02 - Aries", "Snooty", "Blend / regular / 2T");
                        break;
                    case 36:
                        addItemMV(getDrawable(R.drawable.celia), "Celia", "Female", "Mar 25 - Aries", "Normal", "Mocha / regular / 2T");
                        break;
                    case 37:
                        addItemMV(getDrawable(R.drawable.cesar), "Cesar", "Male", "Sep 06 - Virgo", "Cranky", "Blend / a bit / 1T");
                        break;
                    case 38:
                        addItemMV(getDrawable(R.drawable.chadder), "Chadder", "Male", "Dec 15 - Sagittarius", "Smug", "Kilimanjaro / lots / 3T");
                        break;
                    case 39:
                        addItemMV(getDrawable(R.drawable.charlise), "Charlise", "Female", "Apr 17 - Aries", "Uchi", "Kilimanjaro / lots / 3T");
                        break;
                    case 40:
                        addItemMV(getDrawable(R.drawable.cherry), "Cherry", "Female", "May 11 - Taurus", "Uchi", "Mocha / regular / 2T");
                        break;
                    case 41:
                        addItemMV(getDrawable(R.drawable.chevre), "Chevre", "Female", "Mar 06 - Pisces", "Normal", "Blue Mt. / X / X");
                        break;
                    case 42:
                        addItemMV(getDrawable(R.drawable.chief), "Chief", "Male", "Dec 19 - Sagittarius", "Cranky", "Blend / lots / 3T");
                        break;
                    case 43:
                        addItemMV(getDrawable(R.drawable.chops), "Chops", "Male", "Oct 13 - Libra", "Smug", "Mocha / X / X");
                        break;
                    case 44:
                        addItemMV(getDrawable(R.drawable.chrissy), "Chrissy", "Female", "Aug 28 - Virgo", "Peppy", "Blue Mt. / lots / 3T");
                        break;
                    case 45:
                        addItemMV(getDrawable(R.drawable.claude), "Claude", "Male", "Dec 03 - Sagittarius", "Lazy", "Blend / X / X");
                        break;
                    case 46:
                        addItemMV(getDrawable(R.drawable.claudia), "Claudia", "Female", "Nov 22 - Scorpio", "Snooty", "Mocha / a bit / 1T");
                        break;
                    case 47:
                        addItemMV(getDrawable(R.drawable.coco), "Coco", "Female", "Mar 01 - Pisces", "Normal", "Mocha / regular / 2T");
                        break;
                    case 48:
                        addItemMV(getDrawable(R.drawable.cole), "Cole", "Male", "Aug 10 - Leo", "Lazy", "Blend / X / X");
                        break;
                    case 49:
                        addItemMV(getDrawable(R.drawable.colton), "Colton", "Male", "May 22 - Gemini", "Smug", "Kilimanjaro / X / X");
                        break;
                    case 50:
                        addItemMV(getDrawable(R.drawable.cranston), "Cranston", "Male", "Sep 23 - Libra", "Lazy", "Blend / X / X");
                        break;
                    case 51:
                        addItemMV(getDrawable(R.drawable.cube), "Cube", "Male", "Jan 29 - Aquarius", "Lazy", "Blend / a bit / 1T");
                        break;
                    case 52:
                        addItemMV(getDrawable(R.drawable.curlos), "Curlos", "Male", "May 08 - Taurus", "Smug", "Kilimanjaro / lots / 3T");
                        break;
                    case 53:
                        addItemMV(getDrawable(R.drawable.curt), "Curt", "Male", "Jul 01 - Cancer", "Cranky", "Mocha / X / X");
                        break;
                    case 54:
                        addItemMV(getDrawable(R.drawable.deirdre), "Deirdre", "Female", "May 04 - Taurus", "Uchi", "Blue Mt. / X / X");
                        break;
                    case 55:
                        addItemMV(getDrawable(R.drawable.diana), "Diana", "Female", "Jan 04 - Capricorn", "Snooty", "Kilimanjaro / regular / 2T");
                        break;
                    case 56:
                        addItemMV(getDrawable(R.drawable.dizzy), "Dizzy", "Male", "Jul 14 - Cancer", "Lazy", "Blue Mt. / lots / 3T");
                        break;
                    case 57:
                        addItemMV(getDrawable(R.drawable.dobie), "Dobie", "Male", "Feb 17 - Aquarius", "Cranky", "Mocha / a bit / 1T");
                        break;
                    case 58:
                        addItemMV(getDrawable(R.drawable.doc), "Doc", "Male", "Mar 16 - Pisces", "Lazy", "Kilimanjaro / a bit / 1T");
                        break;
                    case 59:
                        addItemMV(getDrawable(R.drawable.dotty), "Dotty", "Female", "Mar 14 - Pisces", "Peppy", "Blue Mt. / lots / 3T");
                        break;
                    case 60:
                        addItemMV(getDrawable(R.drawable.drift), "Drift", "Male", "Oct 09 - Libra", "Jock", "Blue Mt. / regular / 2T");
                        break;
                    case 61:
                        addItemMV(getDrawable(R.drawable.egbert), "Egbert", "Male", "Oct 14 - Libra", "Lazy", "Mocha / a bit / 1T");
                        break;
                    case 62:
                        addItemMV(getDrawable(R.drawable.eloise), "Eloise", "Female", "Dec 08 - Sagittarius", "Snooty", "Blue Mt. / lots / 3T");
                        break;
                    case 63:
                        addItemMV(getDrawable(R.drawable.erik), "Erik", "Male", "Jul 27 - Leo", "Lazy", "Mocha / lots / 3T");
                        break;
                    case 64:
                        addItemMV(getDrawable(R.drawable.eunice), "Eunice", "Female", "Apr 03 - Aries", "Normal", "Blue Mt. / a bit / 1T");
                        break;
                    case 65:
                        addItemMV(getDrawable(R.drawable.fang), "Fang", "Male", "Dec 18 - Sagittarius", "Cranky", "Blend / lots / 3T");
                        break;
                    case 66:
                        addItemMV(getDrawable(R.drawable.fauna), "Fauna", "Female", "Mar 26 - Aries", "Normal", "Mocha / lots / 3T");
                        break;
                    case 67:
                        addItemMV(getDrawable(R.drawable.filbert), "Filbert", "Male", "Jun 03 - Gemini", "Lazy", "Blue Mt. / lots / 3T");
                        break;
                    case 68:
                        addItemMV(getDrawable(R.drawable.flip), "Flip", "Male", "Nov 21 - Scorpio", "Jock", "Kilimanjaro / a bit / 1T");
                        break;
                    case 69:
                        addItemMV(getDrawable(R.drawable.flora), "Flora", "Female", "Feb 09 - Aquarius", "Peppy", "Mocha / regular / 2T");
                        break;
                    case 70:
                        addItemMV(getDrawable(R.drawable.flurry), "Flurry", "Female", "Jan 30 - Aquarius", "Normal", "Mocha / X / X");
                        break;
                    case 71:
                        addItemMV(getDrawable(R.drawable.francine), "Francine", "Female", "Jan 22 - Aquarius", "Snooty", "Kilimanjaro / a bit / 1T");
                        break;
                    case 72:
                        addItemMV(getDrawable(R.drawable.frank), "Frank", "Male", "Jul 30 - Leo", "Cranky", "Kilimanjaro / a bit / 1T");
                        break;
                    case 73:
                        addItemMV(getDrawable(R.drawable.freya), "Freya", "Female", "Dec 14 - Sagittarius", "성수함", "Mocha / a bit / 1T");
                        break;
                    case 74:
                        addItemMV(getDrawable(R.drawable.friga), "Friga", "Female", "Oct 16 - Libra", "Snooty", "Blend / a bit / 1T");
                        break;
                    case 75:
                        addItemMV(getDrawable(R.drawable.frita), "Frita", "Female", "Jul 16 - Cancer", "Uchi", "Mocha / X / X");
                        break;
                    case 76:
                        addItemMV(getDrawable(R.drawable.fuchsia), "Fuchsia", "Female", "Sep 19 - Virgo", "Uchi", "Blue Mt. / X / X");
                        break;
                    case 77:
                        addItemMV(getDrawable(R.drawable.gabi), "Gabi", "Female", "Dec 16 - Sagittarius", "Peppy", "Blue Mt. / lots / 3T");
                        break;
                    case 78:
                        addItemMV(getDrawable(R.drawable.gaston), "Gaston", "Male", "Oct 28 - Scorpio", "Cranky", "Blue Mt. / lots / 3T");
                        break;
                    case 79:
                        addItemMV(getDrawable(R.drawable.genji), "Genji", "Male", "Jan 21 - Aquarius", "Jock", "Blue Mt. / lots / 3T");
                        break;
                    case 80:
                        addItemMV(getDrawable(R.drawable.gladys), "Gladys", "Female", "Jan 15 - Aquarius", "Normal", "Mocha / regular / 2T");
                        break;
                    case 81:
                        addItemMV(getDrawable(R.drawable.goldie), "Goldie", "Female", "Dec 27 - Capricorn", "Normal", "Blue Mt. / lots / 3T");
                        break;
                    case 82:
                        addItemMV(getDrawable(R.drawable.goose), "Goose", "Male", "Oct 04 - Libra", "Jock", "Blend / lots / 3T");
                        break;
                    case 83:
                        addItemMV(getDrawable(R.drawable.greta), "Greta", "Female", "Sep 05 - Virgo", "Snooty", "Mocha / X / X");
                        break;
                    case 84:
                        addItemMV(getDrawable(R.drawable.hamlet), "Hamlet", "Male", "May 30 - Gemini", "Jock", "Blend / regular / 2T");
                        break;
                    case 85:
                        addItemMV(getDrawable(R.drawable.hans), "Hans", "Male", "Dec 05 - Sagittarius", "Smug", "Blue Mt. / X / X");
                        break;
                    case 86:
                        addItemMV(getDrawable(R.drawable.hazel), "Hazel", "Female", "Aug 30 - Virgo", "Uchi", "Blend / X / X");
                        break;
                    case 87:
                        addItemMV(getDrawable(R.drawable.hopkins), "Hopkins", "Male", "Mar 11 - Pisces", "Lazy", "Blend / X / X");
                        break;
                    case 88:
                        addItemMV(getDrawable(R.drawable.hopper), "Hopper", "Male", "Apr 06 - Aries", "Cranky", "Mocha / lots / 3T");
                        break;
                    case 89:
                        addItemMV(getDrawable(R.drawable.hornsby), "Hornsby", "Male", "Mar 20 - Pisces", "Lazy", "Blend / a bit / 1T");
                        break;
                    case 90:
                        addItemMV(getDrawable(R.drawable.iggly), "Iggly", "Male", "Nov 02 - Scorpio", "Jock", "Mocha / lots / 3T");
                        break;
                    case 91:
                        addItemMV(getDrawable(R.drawable.jay), "Jay", "Male", "Jul 17 - Cancer", "Jock", "Kilimanjaro / X / X");
                        break;
                    case 92:
                        addItemMV(getDrawable(R.drawable.jitters), "Jitters", "Male", "Feb 02 - Aquarius", "Jock", "Kilimanjaro / X / X");
                        break;
                    case 93:
                        addItemMV(getDrawable(R.drawable.julia), "Julia", "Female", "Jul 31 - Leo", "Snooty", "Blue Mt. / lots / 3T");
                        break;
                    case 94:
                        addItemMV(getDrawable(R.drawable.julian), "Julian", "Male", "Mar 15 - Pisces", "Smug", "Kilimanjaro / X / X");
                        break;
                    case 95:
                        addItemMV(getDrawable(R.drawable.katt), "Katt", "Female", "Apr 27 - Taurus", "Uchi", "Kilimanjaro / X / X");
                        break;
                    case 96:
                        addItemMV(getDrawable(R.drawable.keaton), "Keaton", "Male", "Jun 01 - Gemini", "Smug", "Blend / X / X");
                        break;
                    case 97:
                        addItemMV(getDrawable(R.drawable.kevin), "Kevin", "Male", "Apr 26 - Taurus", "Jock", "Mocha / X / X");
                        break;
                    case 98:
                        addItemMV(getDrawable(R.drawable.kid_cat), "Kid Cat", "Male", "Aug 01 - Leo", "Jock", "Blue Mt. / regular / 2T");
                        break;
                    case 99:
                        addItemMV(getDrawable(R.drawable.kiki), "Kiki", "Female", "Oct 08 - Libra", "Normal", "Mocha / a bit / 1T");
                        break;
                    case 100:
                        addItemMV(getDrawable(R.drawable.kitt), "Kitt", "Female", "Oct 11 - Libra", "Normal", "Blend / regular / 2T");
                        break;
                    case 101:
                        addItemMV(getDrawable(R.drawable.klaus), "Klaus", "Male", "Mar 31 - Aries", "Smug", "Blue Mt. / a bit / 1T");
                        break;
                    case 102:
                        addItemMV(getDrawable(R.drawable.kyle), "Kyle", "Male", "Dec 06 - Sagittarius", "Smug", "Blue Mt. / regular / 2T");
                        break;
                    case 103:
                        addItemMV(getDrawable(R.drawable.leonardo), "Leonardo", "Male", "May 15 - Taurus", "Jock", "Mocha / a bit / 1T");
                        break;
                    case 104:
                        addItemMV(getDrawable(R.drawable.lily), "Lily", "Female", "Feb 04 - Aquarius", "Normal", "Mocha / a bit / 1T");
                        break;
                    case 105:
                        addItemMV(getDrawable(R.drawable.lobo), "Lobo", "Male", "Nov 05 - Scorpio", "Cranky", "Blend / lots / 3T");
                        break;
                    case 106:
                        addItemMV(getDrawable(R.drawable.lolly), "Lolly", "Female", "Mar 27 - Aries", "Normal", "Mocha / a bit / 1T");
                        break;
                    case 107:
                        addItemMV(getDrawable(R.drawable.lopez), "Lopez", "Male", "Aug 20 - Leo", "Smug", "Blend / a bit / 1T");
                        break;
                    case 108:
                        addItemMV(getDrawable(R.drawable.mallary), "Mallary", "Female", "Nov 17 - Scorpio", "Snooty", "Blend / X / X");
                        break;
                    case 109:
                        addItemMV(getDrawable(R.drawable.margie), "Margie", "Female", "Jan 28 - Aquarius", "Normal", "Blend / X / X");
                        break;
                    case 110:
                        addItemMV(getDrawable(R.drawable.marina), "Marina", "Female", "Jun 26 - Cancer", "Normal", "Blue Mt. / lots / 3T");
                        break;
                    case 111:
                        addItemMV(getDrawable(R.drawable.marshal), "Marshal", "Male", "Sep 29 - Libra", "Smug", "Kilimanjaro / a bit / 1T");
                        break;
                    case 112:
                        addItemMV(getDrawable(R.drawable.melba), "Melba", "Female", "Apr 12 - Aries", "Normal", "Mocha / X / X");
                        break;
                    case 113:
                        addItemMV(getDrawable(R.drawable.merengue), "Merengue", "Female", "Mar 19 - Pisces", "Normal", "Blend / a bit / 1T");
                        break;
                    case 114:
                        addItemMV(getDrawable(R.drawable.merry), "Merry", "Female", "Jun 29 - Cancer", "Peppy", "Blue Mt. / regular / 2T");
                        break;
                    case 115:
                        addItemMV(getDrawable(R.drawable.mint), "Mint", "Female", "May 02 - Taurus", "Snooty", "Blend / X / X");
                        break;
                    case 116:
                        addItemMV(getDrawable(R.drawable.mira), "Mira", "Female", "Jul 06 - Cancer", "Uchi", "Kilimanjaro / a bit / 1T");
                        break;
                    case 117:
                        addItemMV(getDrawable(R.drawable.molly), "Molly", "Female", "Mar 07 - Pisces", "Normal", "Blue Mt. / lots / 3T");
                        break;
                    case 118:
                        addItemMV(getDrawable(R.drawable.muffy), "Muffy", "Female", "Feb 14 - Aquarius", "Uchi", "Mocha / X / X");
                        break;
                    case 119:
                        addItemMV(getDrawable(R.drawable.nibbles), "Nibbles", "Female", "Jul 19 - Cancer", "Peppy", "Mocha / regular / 2T");
                        break;
                    case 120:
                        addItemMV(getDrawable(R.drawable.octavian), "Octavian", "Male", "Sep 20 - Virgo", "Cranky", "Blend / X / X");
                        break;
                    case 121:
                        addItemMV(getDrawable(R.drawable.o_hare), "O'Hare", "Male", "Jul 24 - Leo", "Smug", "Blend / X / X");
                        break;
                    case 122:
                        addItemMV(getDrawable(R.drawable.olivia), "Olivia", "Female", "Feb 03 - Aquarius", "Snooty", "Kilimanjaro / X / X");
                        break;
                    case 123:
                        addItemMV(getDrawable(R.drawable.ozzie), "Ozzie", "Male", "May 07 - Taurus", "Lazy", "Kilimanjaro / lots / 3T");
                        break;
                    case 124:
                        addItemMV(getDrawable(R.drawable.pancetti), "Pancetti", "Female", "Nov 14 - Scorpio", "Snooty", "Blue Mt. / a bit / 1T");
                        break;
                    case 125:
                        addItemMV(getDrawable(R.drawable.patty), "Patty", "Female", "May 10 - Taurus", "Peppy", "Kilimanjaro / a bit / 1T");
                        break;
                    case 126:
                        addItemMV(getDrawable(R.drawable.peaches), "Peaches", "Female", "Nov 28 - Sagittarius", "Normal", "Kilimanjaro / X / X");
                        break;
                    case 127:
                        addItemMV(getDrawable(R.drawable.peanut), "Peanut", "Female", "Jun 08 - Gemini", "Peppy", "Mocha / regular / 2T");
                        break;
                    case 128:
                        addItemMV(getDrawable(R.drawable.pecan), "Pecan", "Female", "Sep 10 - Virgo", "Snooty", "Blend / X / X");
                        break;
                    case 129:
                        addItemMV(getDrawable(R.drawable.peewee), "Peewee", "Male", "Sep 11 - Virgo", "Cranky", "Blend / a bit / 1T");
                        break;
                    case 130:
                        addItemMV(getDrawable(R.drawable.pekoe), "Pekoe", "Female", "May 18 - Taurus", "Normal", "Kilimanjaro / regular / 2T");
                        break;
                    case 131:
                        addItemMV(getDrawable(R.drawable.penelope), "Penelope", "Female", "Feb 05 - Aquarius", "Peppy", "Kilimanjaro / lots / 3T");
                        break;
                    case 132:
                        addItemMV(getDrawable(R.drawable.phil), "Phil", "Male", "Nov 27 - Sagittarius", "Smug", "Mocha / regular / 2T");
                        break;
                    case 133:
                        addItemMV(getDrawable(R.drawable.phoebe), "Phoebe", "Female", "Apr 22 - Taurus", "Uchi", "Kilimanjaro / a bit / 1T");
                        break;
                    case 134:
                        addItemMV(getDrawable(R.drawable.pierce), "Pierce", "Male", "Jan 08 - Capricorn", "Jock", "Kilimanjaro / a bit / 1T");
                        break;
                    case 135:
                        addItemMV(getDrawable(R.drawable.pietro), "Pietro", "Male", "Apr 19 - Aries", "Smug", "Blue Mt. / a bit / 1T");
                        break;
                    case 136:
                        addItemMV(getDrawable(R.drawable.pinky), "Pinky", "Female", "Sep 09 - Virgo", "Peppy", "Blend / regular / 2T");
                        break;
                    case 137:
                        addItemMV(getDrawable(R.drawable.piper), "Piper", "Female", "Apr 18 - Aries", "Peppy", "Blend / lots / 3T");
                        break;
                    case 138:
                        addItemMV(getDrawable(R.drawable.pippy), "Pippy", "Female", "Jun 14 - Gemini", "Peppy", "Blue Mt. / lots / 3T");
                        break;
                    case 139:
                        addItemMV(getDrawable(R.drawable.poncho), "Poncho", "Male", "Jan 02 - Capricorn", "Jock", "Mocha / lots / 3T");
                        break;
                    case 140:
                        addItemMV(getDrawable(R.drawable.poppy), "Poppy", "Female", "Aug 05 - Leo", "Normal", "Kilimanjaro / a bit / 1T");
                        break;
                    case 141:
                        addItemMV(getDrawable(R.drawable.punchy), "Punchy", "Male", "Apr 11 - Aries", "Lazy", "Kilimanjaro / X / X");
                        break;
                    case 142:
                        addItemMV(getDrawable(R.drawable.purrl), "Purrl", "Female", "May 29 - Gemini", "Snooty", "Kilimanjaro / X/ X");
                        break;
                    case 143:
                        addItemMV(getDrawable(R.drawable.queenie), "Queenie", "Female", "Nov 13 - Scorpio", "Snooty", "Kilimanjaro /a bit / 1T");
                        break;
                    case 144:
                        addItemMV(getDrawable(R.drawable.renee), "Renée", "Female", "May 28 - Gemini", "Uchi", "Kilimanjaro / regular / 2T");
                        break;
                    case 145:
                        addItemMV(getDrawable(R.drawable.rhonda), "Rhonda", "Female", "Jan 24 - Aquarius", "Normal", "Mocha / lots / 3T");
                        break;
                    case 146:
                        addItemMV(getDrawable(R.drawable.ricky), "Ricky", "Male", "Sep 14 - Virgo", "Cranky", "Kilimanjaro / regular / 2T");
                        break;
                    case 147:
                        addItemMV(getDrawable(R.drawable.roald), "Roald", "Male", "Jan 05 - Aries", "Jock", "Mocha / lots / 3T");
                        break;
                    case 148:
                        addItemMV(getDrawable(R.drawable.rocco), "Rocco", "Male", "Aug 18 - Leo", "Cranky", "Mocha / X/ X");
                        break;
                    case 149:
                        addItemMV(getDrawable(R.drawable.rod), "Rod", "Male", "Aug 14 - Leo", "Jock", "Mocha / X / X");
                        break;
                    case 150:
                        addItemMV(getDrawable(R.drawable.rodney), "Rodney", "Male", "Nov 10 - Scorpio", "Smug", "Blend / regular / 2T");
                        break;
                    case 151:
                        addItemMV(getDrawable(R.drawable.rolf), "Rolf", "Male", "Aug 22 - Leo", "Cranky", "Mocha / a bit / 1T");
                        break;
                    case 152:
                        addItemMV(getDrawable(R.drawable.roscoe), "Roscoe", "Male", "Jun 16 - Gemini", "Cranky", "Mocha / a bit / 1T");
                        break;
                    case 153:
                        addItemMV(getDrawable(R.drawable.rosie), "Rosie", "Female", "Feb 27 - Pisces", "Peppy", "Mocha / a bit / 1T");
                        break;
                    case 154:
                        addItemMV(getDrawable(R.drawable.rowan), "Rowan", "Male", "Aug 26 - Virgo", "Jock", "Mocha / a bit / 1T");
                        break;
                    case 155:
                        addItemMV(getDrawable(R.drawable.ruby), "Ruby", "Female", "Dec 25 - Capricorn", "Peppy", "Blue Mt. / lots / 3T");
                        break;
                    case 156:
                        addItemMV(getDrawable(R.drawable.sally), "Sally", "Female", "Jun 19 - Gemini", "Normal", "Kilimanjaro / a bit / 1T");
                        break;
                    case 157:
                        addItemMV(getDrawable(R.drawable.sandy), "Sandy", "Female", "Oct 21 - Libra", "Normal", "Blend / X / X");
                        break;
                    case 158:
                        addItemMV(getDrawable(R.drawable.shari), "Shari", "Female", "Apr 10 - Aries", "Uchi", "Blend / X / X");
                        break;
                    case 159:
                        addItemMV(getDrawable(R.drawable.sheldon), "Sheldon", "Male", "Feb 26 - Pisces", "Jock", "Kilimanjaro / a bit / 1T");
                        break;
                    case 160:
                        addItemMV(getDrawable(R.drawable.skye), "Skye", "Female", "Mar 24 - Aries", "Normal", "Kilimanjaro / X / X");
                        break;
                    case 161:
                        addItemMV(getDrawable(R.drawable.sly), "Sly", "Male", "Nov 15 - Scorpio", "Jock", "Blue Mt. / lots / 3T");
                        break;
                    case 162:
                        addItemMV(getDrawable(R.drawable.snake), "Snake", "Male", "Nov 03 - Scorpio", "Jock", "Blue Mt. / lots / 3T");
                        break;
                    case 163:
                        addItemMV(getDrawable(R.drawable.spike), "Spike", "Male", "Jun 17 - Gemini", "Cranky", "Kilimanjaro / regular / 2T");
                        break;
                    case 164:
                        addItemMV(getDrawable(R.drawable.sprocket), "Sprocket", "Male", "Dec 01 - Sagittarius", "Jock", "Mocha / regular / 2T");
                        break;
                    case 165:
                        addItemMV(getDrawable(R.drawable.static_), "Static", "Male", "Jul 09 - Cancer", "Cranky", "Kilimanjaro / regular / 2T");
                        break;
                    case 166:
                        addItemMV(getDrawable(R.drawable.stella), "Stella", "Female", "Apr 09 - Aries", "Normal", "Kilimanjaro / lots / 3T");
                        break;
                    case 167:
                        addItemMV(getDrawable(R.drawable.sterling), "Sterling", "Male", "Dec 11 - Sagittarius", "Jock", "Kilimanjaro / a bit / 1T");
                        break;
                    case 168:
                        addItemMV(getDrawable(R.drawable.stitches), "Stitches", "Male", "Feb 10 - Aquarius", "Lazy", "Blend / a bit / 1T");
                        break;
                    case 169:
                        addItemMV(getDrawable(R.drawable.sylvana), "Sylvana", "Female", "Oct 22 - Libra", "Normal", "Blue Mt. / lots / 3T");
                        break;
                    case 170:
                        addItemMV(getDrawable(R.drawable.tammy), "Tammy", "Female", "Jun 23 - Cancer", "Uchi", "Blend / a bit / 1T");
                        break;
                    case 171:
                        addItemMV(getDrawable(R.drawable.tank), "Tank", "Male", "May 06 - Taurus", "Jock", "Blue Mt. / X / X");
                        break;
                    case 172:
                        addItemMV(getDrawable(R.drawable.t_bone), "T-Bone", "Male", "May 20 - Taurus", "Cranky", "Kilimanjaro / X / X");
                        break;
                    case 173:
                        addItemMV(getDrawable(R.drawable.tasha), "Tasha", "Female", "Nov 30 - Sagittarius", "Snooty", "Mocha / regular / 2T");
                        break;
                    case 174:
                        addItemMV(getDrawable(R.drawable.teddy), "Teddy", "Male", "Sep 26 - Libra", "Jock", "Blend / regular / 2T");
                        break;
                    case 175:
                        addItemMV(getDrawable(R.drawable.tiffany), "Tiffany", "Female", "Jan 09 - Aries", "Snooty", "Kilimanjaro / a bit / 1T");
                        break;
                    case 176:
                        addItemMV(getDrawable(R.drawable.timbra), "Timbra", "Female", "Oct 21 - Libra", "Snooty", "Blend / regular / 2T");
                        break;
                    case 177:
                        addItemMV(getDrawable(R.drawable.truffles), "Truffles", "Female", "Jul 28 - Leo", "Peppy", "Blue Mt. / a bit / 1T");
                        break;
                    case 178:
                        addItemMV(getDrawable(R.drawable.tutu), "Tutu", "Female", "Sep 15 - Virgo", "Peppy", "Blend / regular / 2T");
                        break;
                    case 179:
                        addItemMV(getDrawable(R.drawable.tybalt), "Tybalt", "Male", "Aug 19 - Leo", "Jock", "Kilimanjaro / X / X");
                        break;
                    case 180:
                        addItemMV(getDrawable(R.drawable.vesta), "Vesta", "Female", "Apr 16 - Aries", "Normal", "Blue Mt. / a bit / 1T");
                        break;
                    case 181:
                        addItemMV(getDrawable(R.drawable.victoria), "Victoria", "Female", "Jul 11 - Cancer", "Peppy", "Mocha / a bit / 1T");
                        break;
                    case 182:
                        addItemMV(getDrawable(R.drawable.violet), "Violet", "Female", "Sep 01 - Virgo", "Snooty", "Mocha / lots / 3T");
                        break;
                    case 183:
                        addItemMV(getDrawable(R.drawable.vivian), "Vivian", "Female", "Jan 26 - Aquarius", "Snooty", "Blend / lots / 3T");
                        break;
                    case 184:
                        addItemMV(getDrawable(R.drawable.vladimir), "Vladimir", "Male", "Aug 02 - Leo", "Cranky", "Mocha / lots / 3T");
                        break;
                    case 185:
                        addItemMV(getDrawable(R.drawable.wendy), "Wendy", "Female", "Aug 15 - Leo", "Peppy", "Blend / regular / 2T");
                        break;
                    case 186:
                        addItemMV(getDrawable(R.drawable.whitney), "Whitney", "Female", "Sep 17 - Virgo", "Snooty", "Mocha / a bit / 1T");
                        break;
                    case 187:
                        addItemMV(getDrawable(R.drawable.willow), "Willow", "Female", "Nov 26 - Sagittarius", "Snooty", "Mocha / X / X");
                        break;
                    case 188:
                        addItemMV(getDrawable(R.drawable.wolfgang), "Wolfgang", "Male", "Nov 25 - Sagittarius", "Cranky", "Blend / lots / 3T");
                        break;
                    case 189:
                        addItemMV(getDrawable(R.drawable.zucher), "Zucher", "Male", "Mar 08 - Pisces", "Lazy", "Kilimanjaro / a bit / 1T");
                        break;

                    case 190:
                        addItemMV(getDrawable(R.drawable.admiral), "Admiral", "Male", "Jan 27 - Aquarius", "Cranky", "Blue Mt. / regular / 2T");
                        break;
                    case 191:
                        addItemMV(getDrawable(R.drawable.al), "Al", "Male", "Oct 18 - Libra", "Lazy", "Mocha / lots / 3T");
                        break;
                    case 192:
                        addItemMV(getDrawable(R.drawable.alice), "Alice", "Female", "Aug 19 - Leo", "Normal", "Mocha / X / X");
                        break;
                    case 193:
                        addItemMV(getDrawable(R.drawable.anabelle), "Anabelle", "Female", "Feb 16 - Aquarius", "Peppy", "Kilimanjaro / a bit / 1T");
                        break;
                    case 194:
                        addItemMV(getDrawable(R.drawable.anchovy), "Anchovy", "Male", "Mar 04 - Pisces", "Lazy", "Blue Mt. / regular / 2T");
                        break;
                    case 195:
                        addItemMV(getDrawable(R.drawable.anicotti), "Anicotti", "Female", "Feb 24 - Pisces", "Peppy", "Mocha / X / X");
                        break;
                    case 196:
                        addItemMV(getDrawable(R.drawable.ankha), "Ankha", "Female", "Sep 22 - Virgo", "Snooty", "Kilimanjaro / X / X");
                        break;
                    case 197:
                        addItemMV(getDrawable(R.drawable.annalisa), "Annalisa", "Female", "Feb 06 - Aquarius", "Normal", "Mocha / regular / 2T");
                        break;
                    case 198:
                        addItemMV(getDrawable(R.drawable.annalise), "Annalise", "Female", "Dec 02 - Sagittarius", "Snooty", "Blend / lots / 3T");
                        break;
                    case 199:
                        addItemMV(getDrawable(R.drawable.astrid), "Astrid", "Female", "Sep 08 - Virgo", "Snooty", "Blue Mt. / a bit / 1T");
                        break;
                    case 200:
                        addItemMV(getDrawable(R.drawable.audie), "Audie", "Female", "Aug 31 - Virgo", "Peppy", "(Update later!)");
                        break;
                    case 201:
                        addItemMV(getDrawable(R.drawable.ava), "Ava", "Female", "Apr 28 - Taurus", "Normal", "Blue Mt. / regular / 2T");
                        break;
                    case 202:
                        addItemMV(getDrawable(R.drawable.axel), "Axel", "Male", "Mar 23 - Aries", "Jock", "Kilimanjaro / a bit / 1T");
                        break;
                    case 203:
                        addItemMV(getDrawable(R.drawable.bam), "Bam", "Male", "Nov 07 - Scorpio", "Jock", "Blend / a bit / 1T");
                        break;
                    case 204:
                        addItemMV(getDrawable(R.drawable.barold), "Barold", "Male", "Mar 02 - Pisces", "Lazy", "Blue Mt. / X / X");
                        break;
                    case 205:
                        addItemMV(getDrawable(R.drawable.bea), "Bea", "Female", "Oct 15 - Libra", "Normal", "Kilimanjaro / a bit / 1T");
                        break;
                    case 206:
                        addItemMV(getDrawable(R.drawable.beardo), "Beardo", "Male", "Sep 27 - Libra", "Smug", "Blue Mt. / a bit / 1T");
                        break;
                    case 207:
                        addItemMV(getDrawable(R.drawable.becky), "Becky", "Female", "Dec 09 - Sagittarius", "Snooty", "Mocha / a bit / 1T");
                        break;
                    case 208:
                        addItemMV(getDrawable(R.drawable.benedict), "Benedict", "Male", "Oct 10 - Libra", "Lazy", "모키 / a bit / 1T");
                        break;
                    case 209:
                        addItemMV(getDrawable(R.drawable.benjamin), "Benjamin", "Male", "Aug 03 - Leo", "Lazy", "Kilimanjaro / a bit / 1T");
                        break;
                    case 210:
                        addItemMV(getDrawable(R.drawable.biff), "Biff", "Male", "Mar 29 - Aries", "Jock", "Mocha / X / X");
                        break;
                    case 211:
                        addItemMV(getDrawable(R.drawable.big_top), "Big Top", "Male", "Oct 03 - Libra", "Lazy", "Blue Mt. / lots / 3T");
                        break;
                    case 212:
                        addItemMV(getDrawable(R.drawable.billy), "Billy", "Male", "Mar 25 - Aries", "Jock", "Blue Mt. / X / X");
                        break;
                    case 213:
                        addItemMV(getDrawable(R.drawable.biskit), "Biskit", "Male", "May 13 - Taurus", "Lazy", "Mocha / regular / 2T");
                        break;
                    case 214:
                        addItemMV(getDrawable(R.drawable.bitty), "Bitty", "Female", "Oct 06 - Libra", "Snooty", "Mocha / X / X");
                        break;
                    case 215:
                        addItemMV(getDrawable(R.drawable.bluebear), "Bluebear", "Female", "Jun 24 - Cancer", "Peppy", "Mocha / lots / 3T");
                        break;
                    case 216:
                        addItemMV(getDrawable(R.drawable.bones), "Bones", "Male", "Aug 04 - Leo", "Lazy", "Mocha / regular / 2T");
                        break;
                    case 217:
                        addItemMV(getDrawable(R.drawable.boomer), "Boomer", "Male", "Feb 07 - Aquarius", "Lazy", "Blend / a bit / 1T");
                        break;
                    case 218:
                        addItemMV(getDrawable(R.drawable.boone), "Boone", "Male", "Sep 12 - Virgo", "Jock", "Blend / a bit / 1T");
                        break;
                    case 219:
                        addItemMV(getDrawable(R.drawable.boots), "Boots", "Male", "Aug 07 - Leo", "Jock", "Blue Mt. / lots / 3T");
                        break;
                    case 220:
                        addItemMV(getDrawable(R.drawable.boris), "Boris", "Male", "Nov 06 - Scorpio", "Cranky", "Kilimanjaro / lots / 3T");
                        break;
                    case 221:
                        addItemMV(getDrawable(R.drawable.boyd), "Boyd", "Male", "Oct 01 - Libra", "Cranky", "Mocha / lots / 3T");
                        break;
                    case 222:
                        addItemMV(getDrawable(R.drawable.broccolo), "Broccolo", "Male", "Jun 30 - Cancer", "Lazy", "Blend / regular / 2T");
                        break;
                    case 223:
                        addItemMV(getDrawable(R.drawable.broffina), "Broffina", "Female", "Oct 24 - Scorpio", "Snooty", "Blend / lots / 3T");
                        break;
                    case 224:
                        addItemMV(getDrawable(R.drawable.bruce), "Bruce", "Male", "May 26 - Gemini", "Cranky", "Blue Mt. / X / X");
                        break;
                    case 225:
                        addItemMV(getDrawable(R.drawable.bubbles), "Bubbles", "Female", "Sep 18 - Virgo", "Peppy", "Mocha / X / X");
                        break;
                    case 226:
                        addItemMV(getDrawable(R.drawable.camofrog), "Camofrog", "Male", "Jun 05 - Gemini", "Cranky", "Blue Mt. / regular / 2T");
                        break;
                    case 227:
                        addItemMV(getDrawable(R.drawable.candi), "Candi", "Female", "Apr 13 - Aries", "Peppy", "Kilimanjaro / lots / 3T");
                        break;
                    case 228:
                        addItemMV(getDrawable(R.drawable.chai), "Chai", "Female", "Mar 06 - Pisces", "Peppy", "Blend / X / X");
                        break;
                    case 229:
                        addItemMV(getDrawable(R.drawable.chelsea), "Chelsea", "Female", "Jan 18 - Capricorn", "Normal", "Mocha / lots / 3T");
                        break;
                    case 230:
                        addItemMV(getDrawable(R.drawable.cheri), "Cheri", "Female", "Mar 17 - Pisces", "Peppy", "Mocha / lots / 3T");
                        break;
                    case 231:
                        addItemMV(getDrawable(R.drawable.chester), "Chester", "Male", "Aug 06 - Leo", "Lazy", "Blend / a bit / 1T");
                        break;
                    case 232:
                        addItemMV(getDrawable(R.drawable.chow), "Chow", "Male", "Jul 22 - Cancer", "Cranky", "Blend / regular/ 2T");
                        break;
                    case 233:
                        addItemMV(getDrawable(R.drawable.clay), "Clay", "Male", "Oct 19 - Libra", "Lazy", "Mocha / X / X");
                        break;
                    case 234:
                        addItemMV(getDrawable(R.drawable.cleo), "Cleo", "Female", "Feb 09 - Aquarius", "Snooty", "Mocha / a bit / 1T");
                        break;
                    case 235:
                        addItemMV(getDrawable(R.drawable.clyde), "Clyde", "Male", "May 01 - Taurus", "Lazy", "Blend / lots / 설탕3");
                        break;
                    case 236:
                        addItemMV(getDrawable(R.drawable.coach), "Coach", "Male", "Apr 29 - Taurus", "Jock", "Blend / lots / 3T");
                        break;
                    case 237:
                        addItemMV(getDrawable(R.drawable.cobb), "Cobb", "Male", "Oct 07 - Libra", "Jock", "Blue Mt. / a bit / 1T");
                        break;
                    case 238:
                        addItemMV(getDrawable(R.drawable.cookie), "Cookie", "Female", "Jun 18 - Gemini", "Peppy", "Blend / X / X");
                        break;
                    case 239:
                        addItemMV(getDrawable(R.drawable.cousteau), "Cousteau", "Male", "Dec 17 - Sagittarius", "Jock", "Blue Mt. / regular / 2T");
                        break;
                    case 240:
                        addItemMV(getDrawable(R.drawable.croque), "Croque", "Male", "Jul 18 - Cancer", "Cranky", "Kilimanjaro / X / X");
                        break;
                    case 241:
                        addItemMV(getDrawable(R.drawable.curly), "Curly", "Male", "Jul 26 - Leo", "Jock", "Blue Mt. / a bit / 1T");
                        break;
                    case 242:
                        addItemMV(getDrawable(R.drawable.cyd), "Cyd", "Male", "Jun 09 - Gemini", "Cranky", "(Update later!)");
                        break;
                    case 243:
                        addItemMV(getDrawable(R.drawable.cyrano), "Cyrano", "Male", "Mar 09 - Pisces", "Cranky", "Kilimanjaro / a bit / 1T");
                        break;
                    case 244:
                        addItemMV(getDrawable(R.drawable.daisy), "Daisy", "Female", "Nov 16 - Scorpio", "Normal", "Blue Mt. / lots / 3T");
                        break;
                    case 245:
                        addItemMV(getDrawable(R.drawable.deena), "Deena", "Female", "Jun 27 - Cancer", "Normal", "Kilimanjaro / a bit / 1T");
                        break;
                    case 246:
                        addItemMV(getDrawable(R.drawable.del), "Del", "Male", "May 27 - Gemini", "Cranky", "Blend / X / X");
                        break;
                    case 247:
                        addItemMV(getDrawable(R.drawable.deli), "Deli", "Male", "May 24 - Gemini", "Lazy", "Blue Mt. / lots / 3T");
                        break;
                    case 248:
                        addItemMV(getDrawable(R.drawable.derwin), "Derwin", "Male", "May 25 - Gemini", "Lazy", "Blend / X / X");
                        break;
                    case 249:
                        addItemMV(getDrawable(R.drawable.diva), "Diva", "Female", "Oct 02 - Libra", "Uchi", "Kilimanjaro / X / X");
                        break;
                    case 250:
                        addItemMV(getDrawable(R.drawable.dom), "Dom", "Male", "Mar 18 - Pisces", "Jock", "(Update later!)");
                        break;
                    case 251:
                        addItemMV(getDrawable(R.drawable.dora), "Dora", "Female", "Feb 18 - Aquarius", "Normal", "Kilimanjaro / lots / 3T");
                        break;
                    case 252:
                        addItemMV(getDrawable(R.drawable.drago), "Drago", "Male", "Feb 12 - Aquarius", "Lazy", "Kilimanjaro / a bit / 1T");
                        break;
                    case 253:
                        addItemMV(getDrawable(R.drawable.drake), "Drake", "Male", "Jun 25 - Cancer", "Lazy", "Blend / X / X");
                        break;
                    case 254:
                        addItemMV(getDrawable(R.drawable.ed), "Ed", "Male", "Sep 16 - Virgo", "Smug", "Blue Mt. / regular / 2T");
                        break;
                    case 255:
                        addItemMV(getDrawable(R.drawable.elise), "Elise", "Female", "Mar 21 - Aries", "Snooty", "Blend / X / X");
                        break;
                    case 256:
                        addItemMV(getDrawable(R.drawable.ellie), "Ellie", "Female", "May 12 - Taurus", "Normal", "Mocha / regular / 2T");
                        break;
                    case 257:
                        addItemMV(getDrawable(R.drawable.elmer), "Elmer", "Male", "Oct 05 - Libra", "Lazy", "Blend / lots / 3T");
                        break;
                    case 258:
                        addItemMV(getDrawable(R.drawable.elvis), "Elvis", "Male", "Jul 23 - Leo", "Cranky", "Blue Mt. / X / X");
                        break;
                    case 259:
                        addItemMV(getDrawable(R.drawable.etoile), "Étoile", "Female", "Dec 25 - Capricorn", "Normal", "Kilimanjaro / lots / 3T");
                        break;
                    case 260:
                        addItemMV(getDrawable(R.drawable.eugene), "Eugene", "Male", "Oct 26 - Scorpio", "Smug", "Mocha / X / X");
                        break;
                    case 261:
                        addItemMV(getDrawable(R.drawable.felicity), "Felicity", "Female", "Mar 30 - Aries", "Peppy", "Blue Mt. / regular / 2T");
                        break;
                    case 262:
                        addItemMV(getDrawable(R.drawable.flo), "Flo", "Female", "Sep 02 - Virgo", "Uchi", "Blend / a bit / 1T");
                        break;
                    case 263:
                        addItemMV(getDrawable(R.drawable.freckles), "Freckles", "Female", "Feb 19 - Aquarius", "Peppy", "Mocha / regular / 2T");
                        break;
                    case 264:
                        addItemMV(getDrawable(R.drawable.frobert), "Frobert", "Male", "Feb 08 - Aquarius", "Jock", "Blue Mt. / regular / 2T");
                        break;
                    case 265:
                        addItemMV(getDrawable(R.drawable.gala), "Gala", "Female", "Mar 05 - Pisces", "Normal", "Mocha / X / X");
                        break;
                    case 266:
                        addItemMV(getDrawable(R.drawable.gayle), "Gayle", "Female", "May 17 - Taurus", "Normal", "Kilimanjaro / a bit / 1T");
                        break;
                    case 267:
                        addItemMV(getDrawable(R.drawable.gigi), "Gigi", "Female", "Aug 11 - Leo", "Snooty", "Kilimanjaro / X / X");
                        break;
                    case 268:
                        addItemMV(getDrawable(R.drawable.gloria), "Gloria", "Female", "Aug 12 - Leo", "Snooty", "Blend / X / X");
                        break;
                    case 269:
                        addItemMV(getDrawable(R.drawable.gonzo), "Gonzo", "Male", "Oct 13 - Libra", "Cranky", "Kilimanjaro / lots / 3T");
                        break;
                    case 270:
                        addItemMV(getDrawable(R.drawable.graham), "Graham", "Male", "Jun 20 - Gemini", "Smug", "Blend / regular / 2T");
                        break;
                    case 271:
                        addItemMV(getDrawable(R.drawable.grizzly), "Grizzly", "Male", "Jul 31 - Leo", "Cranky", "Blend / regular / 2T");
                        break;
                    case 272:
                        addItemMV(getDrawable(R.drawable.groucho), "Groucho", "Male", "Oct 23 - Scorpio", "Cranky", "Blend / regular / 2T");
                        break;
                    case 273:
                        addItemMV(getDrawable(R.drawable.gruff), "Gruff", "Male", "Aug 29 Virgo", "Cranky", "Blend / a bit / 1T");
                        break;
                    case 274:
                        addItemMV(getDrawable(R.drawable.gwen), "Gwen", "Female", "Jan 23 - Aquarius", "Snooty", "Blend / a bit / 1T");
                        break;
                    case 275:
                        addItemMV(getDrawable(R.drawable.hamphrey), "Hamphery", "Male", "Feb 25 - Pisces", "Cranky", "Blue Mt. / a bit / 1T");
                        break;
                    case 276:
                        addItemMV(getDrawable(R.drawable.harry), "Harry", "Male", "Jan 07 - Capricorn", "Cranky", "Mocha / X / X");
                        break;
                    case 277:
                        addItemMV(getDrawable(R.drawable.henry), "Henry", "Male", "Sep 21 - Virgo", "Smug", "Mocha / a bit / 1T");
                        break;
                    case 278:
                        addItemMV(getDrawable(R.drawable.hippeux), "Hippeux", "Male", "Oct 15 - Libra", "Smug", "Kilimanjaro / lots / 3T");
                        break;
                    case 279:
                        addItemMV(getDrawable(R.drawable.huck), "Huck", "Male", "Jul 09 - Cancer", "Smug", "Mocha / a bit / 1T");
                        break;
                    case 280:
                        addItemMV(getDrawable(R.drawable.hugh), "Hugh", "Male", "Dec 30 - Capricorn", "Lazy", "Kilimanjaro / lots / 3T");
                        break;
                    case 281:
                        addItemMV(getDrawable(R.drawable.ike), "Ike", "Male", "May 16 - Taurus", "Cranky", "Mocha / X / X");
                        break;
                    case 282:
                        addItemMV(getDrawable(R.drawable.jacob), "Jacob", "Male", "Aug 24 - Virgo", "Lazy", "Mocha / a bit / 1T");
                        break;
                    case 283:
                        addItemMV(getDrawable(R.drawable.jacques), "Jacques", "Male", "Jun 22 - Cancer", "Smug", "Blend / lots / 3T");
                        break;
                    case 284:
                        addItemMV(getDrawable(R.drawable.jambette), "Jambette", "Female", "Oct 27 - Scorpio", "Normal", "Mocha / a bit / 1T");
                        break;
                    case 285:
                        addItemMV(getDrawable(R.drawable.jeremiah), "Jeremiah", "Male", "Jul 08 - Cancer", "Lazy", "Kilimanjaro / X / X");
                        break;
                    case 286:
                        addItemMV(getDrawable(R.drawable.joey), "Joey", "Male", "Jan 03 - Capricorn", "Lazy", "Blend / X / X");
                        break;
                    case 287:
                        addItemMV(getDrawable(R.drawable.judy), "Judy", "Female", "Mar 10 - Pisces", "Snooty", "(Update later!)");
                        break;
                    case 288:
                        addItemMV(getDrawable(R.drawable.june), "June", "Female", "May 21 - Gemini", "Normal", "Blue Mt. / X / X");
                        break;
                    case 289:
                        addItemMV(getDrawable(R.drawable.kabuki), "Kabuki", "Male", "Nov 29 - Sagittarius", "Cranky", "Blue Mt. / regular / 2T");
                        break;
                    case 290:
                        addItemMV(getDrawable(R.drawable.ken), "Ken", "Male", "Dec 23 - Capricorn", "Smug", "Blue Mt. / regular / 2T");
                        break;
                    case 291:
                        addItemMV(getDrawable(R.drawable.ketchup), "Ketchup", "Female", "Jul 27 - Leo", "Peppy", "Kilimanjaro / a bit / 1T");
                        break;
                    case 292:
                        addItemMV(getDrawable(R.drawable.kidd), "Kidd", "Male", "Jun 28 - Cancer", "Smug", "Kilimanjaro / regular / 2T");
                        break;
                    case 293:
                        addItemMV(getDrawable(R.drawable.kitty), "Kitty", "Female", "Feb 15 - Aquarius", "Snooty", "Kilimanjaro / X / X");
                        break;
                    case 294:
                        addItemMV(getDrawable(R.drawable.knox), "Knox", "Male", "Nov 23 - Sagittarius", "Cranky", "Blend / lots / 3T");
                        break;
                    case 295:
                        addItemMV(getDrawable(R.drawable.kody), "Kody", "Male", "Sep 28 - Libra", "Jock", "Mocha / lots / 3T");
                        break;
                    case 296:
                        addItemMV(getDrawable(R.drawable.limberg), "Limberg", "Male", "Oct 17 - Libra", "Cranky", "Mocha / X / X");
                        break;
                    case 297:
                        addItemMV(getDrawable(R.drawable.lionel), "Lionel", "Male", "Jul 29 - Leo", "Smug", "Mocha / lots / 3T");
                        break;
                    case 298:
                        addItemMV(getDrawable(R.drawable.louie), "Louie", "Male", "Mar 26 - Aries", "Jock", "Blue Mt. / X / X");
                        break;
                    case 299:
                        addItemMV(getDrawable(R.drawable.lucha), "Lucha", "Male", "Dec 12 - Sagittarius", "Smug", "Blend / lots / 3T");
                        break;
                    case 300:
                        addItemMV(getDrawable(R.drawable.lucky), "Lucky", "Male", "Nov 04 - Scorpio", "Lazy", "Mocha / regular / 2T");
                        break;
                    case 301:
                        addItemMV(getDrawable(R.drawable.lucy), "Lucy", "Female", "Jun 02 - Gemini", "Normal", "Mocha / X / X");
                        break;
                    case 302:
                        addItemMV(getDrawable(R.drawable.lyman), "Lyman", "Male", "Oct 12 - Libra", "Jock", "Mocha / X / X");
                        break;
                    case 303:
                        addItemMV(getDrawable(R.drawable.mac), "Mac", "Male", "Nov 11 - Scorpio", "Jock", "Blend / X / X");
                        break;
                    case 304:
                        addItemMV(getDrawable(R.drawable.maddie), "Maddie", "Female", "Jan 11 - Capricorn", "Peppy", "Blue Mt. / lots / 3T");
                        break;
                    case 305:
                        addItemMV(getDrawable(R.drawable.maelle), "Maelle", "Female", "Apr 08 - Aries", "Snooty", "Blend / X / X");
                        break;
                    case 306:
                        addItemMV(getDrawable(R.drawable.maggie), "Maggie", "Female", "Sep 03 - Virgo", "Normal", "Blend / regular / 2T");
                        break;
                    case 307:
                        addItemMV(getDrawable(R.drawable.maple), "Maple", "Female", "Jun 15 - Gemini", "Normal", "Kilimanjaro / regular / 2T");
                        break;
                    case 308:
                        addItemMV(getDrawable(R.drawable.marcel), "Marcel", "Male", "Dec 31 - Capricorn", "Lazy", "Mocha / regular / 2T");
                        break;
                    case 309:
                        addItemMV(getDrawable(R.drawable.marcie), "Marcie", "Female", "May 31 - Gemini", "Normal", "Mocha / X / X");
                        break;
                    case 310:
                        addItemMV(getDrawable(R.drawable.mathilda), "Mathilda", "Female", "Nov 12 - Scorpio", "Snooty", "Blue Mt. / a bit / 1T");
                        break;
                    case 311:
                        addItemMV(getDrawable(R.drawable.megan), "Megan", "Female", "Mar 13 - Pisces", "Normal", "(Update later!)");
                        break;
                    case 312:
                        addItemMV(getDrawable(R.drawable.midge), "Midge", "Female", "Mar 12 - Pisces", "Normal", "Blend / lots / 3T");
                        break;
                    case 313:
                        addItemMV(getDrawable(R.drawable.miranda), "Miranda", "Female", "Apr 23 - Taurus", "Snooty", "Blend / X / X");
                        break;
                    case 314:
                        addItemMV(getDrawable(R.drawable.mitzi), "Mitzi", "Female", "Sep 25 - Libra", "Normal", "Mocha / a bit / 1T");
                        break;
                    case 315:
                        addItemMV(getDrawable(R.drawable.moe), "Moe", "Male", "Jan 12 - Capricorn", "Lazy", "Kilimanjaro / X / X");
                        break;
                    case 316:
                        addItemMV(getDrawable(R.drawable.monique), "Monique", "Female", "Sep 30 - Libra", "Snooty", "Kilimanjaro / X / X");
                        break;
                    case 317:
                        addItemMV(getDrawable(R.drawable.monty), "Monty", "Male", "Dec 07 - Sagittarius", "Cranky", "Mocha / regular / 2T");
                        break;
                    case 318:
                        addItemMV(getDrawable(R.drawable.moose), "Moose", "Male", "Sep 13 - Virgo", "Jock", "Mocha / X / X");
                        break;
                    case 319:
                        addItemMV(getDrawable(R.drawable.mott), "Mott", "Male", "Jul 10 - Cancer", "Jock", "Blue Mt. / X / X");
                        break;
                    case 320:
                        addItemMV(getDrawable(R.drawable.murphy), "Murphy", "Male", "Dec 29 - Capricorn", "Cranky", "Blend / a bit / 1T");
                        break;
                    case 321:
                        addItemMV(getDrawable(R.drawable.nan), "Nan", "Female", "Aug 24 - Virgo", "Normal", "Blue Mt. / X / X");
                        break;
                    case 322:
                        addItemMV(getDrawable(R.drawable.nana), "Nana", "Female", "Aug 23 - Virgo", "Normal", "Kilimanjaro / a bit / 1T");
                        break;
                    case 323:
                        addItemMV(getDrawable(R.drawable.naomi), "Naomi", "Female", "Feb 28 - Pisces", "Snooty", "Kilimanjaro / regular / 2T");
                        break;
                    case 324:
                        addItemMV(getDrawable(R.drawable.nate), "Nate", "Male", "Aug 16 - Leo", "Lazy", "Mocha / X / X");
                        break;
                    case 325:
                        addItemMV(getDrawable(R.drawable.norma), "Norma", "Female", "Sep 20 - Virgo", "Normal", "Mocha / lots / 3T");
                        break;
                    case 326:
                        addItemMV(getDrawable(R.drawable.olaf), "Olaf", "Male", "May 19 - Taurus", "Smug", "Blend / X / X");
                        break;
                    case 327:
                        addItemMV(getDrawable(R.drawable.olive), "Olive", "Female", "Jul 12 - Cancer", "Normal", "Blue Mt. / X / X");
                        break;
                    case 328:
                        addItemMV(getDrawable(R.drawable.opal), "Opal", "Female", "Jan 20 - Aquarius", "Snooty", "Blue Mt. / lots / 3T");
                        break;
                    case 329:
                        addItemMV(getDrawable(R.drawable.pango), "Pango", "Female", "Nov 09 - Scorpio", "Peppy", "Kilimanjaro / a bit / 1T");
                        break;
                    case 330:
                        addItemMV(getDrawable(R.drawable.paolo), "Paolo", "Male", "May 05 - Taurus", "Lazy", "Mocha / regular / 2T");
                        break;
                    case 331:
                        addItemMV(getDrawable(R.drawable.papi), "Papi", "Male", "Jan 10 - Capricorn", "Lazy", "Blue Mt. / regular / 2T");
                        break;
                    case 332:
                        addItemMV(getDrawable(R.drawable.pashmina), "pashmina", "Female", "Dec 26 - Capricorn", "Uchi", "Mocha / lots / 3T");
                        break;
                    case 333:
                        addItemMV(getDrawable(R.drawable.pate), "Pate", "Female", "Feb 23 - Pisces", "Peppy", "Mocha / regular/ 2T");
                        break;
                    case 334:
                        addItemMV(getDrawable(R.drawable.paula), "Paula", "Female", "Mar 22 - Aries", "Uchi", "Kilimanjaro / 우lots/ 3T");
                        break;
                    case 335:
                        addItemMV(getDrawable(R.drawable.peck), "Peck", "Male", "Jul 25 - Leo", "Jock", "Blend / lots / 3T");
                        break;
                    case 336:
                        addItemMV(getDrawable(R.drawable.peggy), "Peggy", "Female", "May 23 - Gemini", "Peppy", "Blue Mt. / a bit / 1T");
                        break;
                    case 337:
                        addItemMV(getDrawable(R.drawable.plucky), "Plucky", "Female", "Oct 12 - Libra", "Uchi", "Mocha / a bit / 1T");
                        break;
                    case 338:
                        addItemMV(getDrawable(R.drawable.pompom), "Pompom", "Female", "Feb 11 - Aquarius", "Peppy", "Mocha / regular / 2T");
                        break;
                    case 339:
                        addItemMV(getDrawable(R.drawable.portia), "Portia", "Female", "Oct 25 - Scorpio", "Snooty", "Mocha / regular / 2T");
                        break;
                    case 340:
                        addItemMV(getDrawable(R.drawable.prince), "Prince", "Male", "Jul 21 - Cancer", "Lazy", "Kilimanjaro / X / X");
                        break;
                    case 341:
                        addItemMV(getDrawable(R.drawable.puck), "Puck", "Male", "Feb 21 - Pisces", "Lazy", "Blend / a bit / 1T");
                        break;
                    case 342:
                        addItemMV(getDrawable(R.drawable.puddles), "Puddles", "Female", "Jan 13 - Capricorn", "Peppy", "Blue Mt. / regular / 2T");
                        break;
                    case 343:
                        addItemMV(getDrawable(R.drawable.pudge), "Pudge", "Male", "Jun 11 - Gemini", "Lazy", "Blend / a bit / 1T");
                        break;
                    case 344:
                        addItemMV(getDrawable(R.drawable.quillson), "Quillson", "Male", "Dec 22 - Capricorn", "Smug", "Kilimanjaro / a bit / 1T");
                        break;
                    case 345:
                        addItemMV(getDrawable(R.drawable.raddle), "Raddle", "Male", "Jun 06 - Gemini", "Lazy", "Blend / lots / 3T");
                        break;
                    case 346:
                        addItemMV(getDrawable(R.drawable.rasher), "Rasher", "Male", "Apr 07 - Aries", "Cranky", "Blue Mt. / a bit / 1T");
                        break;
                    case 347:
                        addItemMV(getDrawable(R.drawable.raymond), "Raymond", "Male", "Oct 01 - Libra", "Smug", "(Update later!)");
                        break;
                    case 348:
                        addItemMV(getDrawable(R.drawable.reneigh), "Reneigh", "Female", "Jun 04 - Gemini", "Uchi", "(Update later!)");
                        break;
                    case 349:
                        addItemMV(getDrawable(R.drawable.rex), "Rex", "Male", "Jul 24 - Leo", "Lazy", "Blend / a bit / 1T");
                        break;
                    case 350:
                        addItemMV(getDrawable(R.drawable.ribbot), "Ribbot", "Male", "Feb 12 - Aquarius", "Jock", "Blue Mt. / regular / 2T");
                        break;
                    case 351:
                        addItemMV(getDrawable(R.drawable.rilla), "Rilla", "Female", "Nov 01 - Scorpio", "Peppy", "Blue Mt. / X / X");
                        break;
                    case 352:
                        addItemMV(getDrawable(R.drawable.rizzo), "Rizzo", "Male", "Jan 17 - Capricorn", "Cranky", "Mocha / X / X");
                        break;
                    case 353:
                        addItemMV(getDrawable(R.drawable.robin), "Robin", "Female", "Dec 04 - Sagittarius", "Snooty", "Blue Mt. / regular / 2T");
                        break;
                    case 354:
                        addItemMV(getDrawable(R.drawable.rocket), "Rocket", "Female", "Apr 14 - Aries", "Uchi", "Kilimanjaro / regular / 2T");
                        break;
                    case 355:
                        addItemMV(getDrawable(R.drawable.rodeo), "Rodeo", "Male", "Oct 29 - Scorpio", "Lazy", "Blue Mt. / regular / 2T");
                        break;
                    case 356:
                        addItemMV(getDrawable(R.drawable.rooney), "Rooney", "Male", "Dec 01 - Sagittarius", "Cranky", "Blue Mt. / a bit / 1T");
                        break;
                    case 357:
                        addItemMV(getDrawable(R.drawable.rory), "Rory", "Male", "Aug 07 - Leo", "Jock", "Mocha / lots / 3T");
                        break;
                    case 358:
                        addItemMV(getDrawable(R.drawable.rudy), "Rudy", "Male", "Dec 20 - Sagittarius", "Jock", "Mocha / a bit / 1T");
                        break;
                    case 359:
                        addItemMV(getDrawable(R.drawable.samson), "Samson", "Male", "Jul 05 - Cancer", "Jock", "Mocha / X / X");
                        break;
                    case 360:
                        addItemMV(getDrawable(R.drawable.savannah), "Savannah", "Female", "Jan 25 - Aquarius", "Normal", "Kilimanjaro / X / X");
                        break;
                    case 361:
                        addItemMV(getDrawable(R.drawable.scoot), "Scoot", "Male", "Jun 13 - Gemini", "Jock", "Mocha / regular / 2T");
                        break;
                    case 362:
                        addItemMV(getDrawable(R.drawable.shep), "Shep", "Male", "Nov 24 - Sagittarius", "Smug", "Blue Mt. / lots / 3T");
                        break;
                    case 363:
                        addItemMV(getDrawable(R.drawable.sherb), "Sherb", "Male", "Jan 18 - Capricorn", "Lazy", "(Update later!)");
                        break;
                    case 364:
                        addItemMV(getDrawable(R.drawable.simon), "Simon", "Male", "Jan 19 - Capricorn", "Lazy", "Blend / X / X");
                        break;
                    case 365:
                        addItemMV(getDrawable(R.drawable.snooty), "Snooty", "Female", "Oct 24 - Scorpio", "Snooty", "Kilimanjaro / a bit / 1T");
                        break;
                    case 366:
                        addItemMV(getDrawable(R.drawable.soleil), "Soleil", "Female", "Aug 09 - Leo", "Snooty", "Kilimanjaro / lots / 3T");
                        break;
                    case 367:
                        addItemMV(getDrawable(R.drawable.sparro), "Sparro", "Male", "Nov 20 - Scorpio", "Jock", "Blend / lots / 3T");
                        break;
                    case 368:
                        addItemMV(getDrawable(R.drawable.spork), "Spork", "Male", "Sep 03 - Virgo", "Lazy", "Kilimanjaro / lots / 3T");
                        break;
                    case 369:
                        addItemMV(getDrawable(R.drawable.sprinkle), "Sprinkle", "Female", "Feb 20 - Pisces", "Peppy", "Kilimanjaro /regular / 2T");
                        break;
                    case 370:
                        addItemMV(getDrawable(R.drawable.stinky), "Stinky", "Male", "Aug 17 - Leo", "Jock", "Blue Mt. / regular / 2T");
                        break;
                    case 371:
                        addItemMV(getDrawable(R.drawable.stu), "Stu", "Male", "Apr 20 - Taurus", "Lazy", "Mocha / a bit / 1T");
                        break;
                    case 372:
                        addItemMV(getDrawable(R.drawable.sydney), "Sydney", "Female", "Jun 21 - Gemini", "Normal", "Mocha / X / X");
                        break;
                    case 373:
                        addItemMV(getDrawable(R.drawable.sylvia), "Sylvia", "Female", "May 03 - Taurus", "Uchi", "Mocha / X / X");
                        break;
                    case 374:
                        addItemMV(getDrawable(R.drawable.tabby), "Tabby", "Female", "Aug 13 - Leo", "Peppy", "Blue Mt. / regular / 2T");
                        break;
                    case 375:
                        addItemMV(getDrawable(R.drawable.tad), "Tad", "Male", "Aug 03 - Leo", "Jock", "Mocha / a bit / 1T");
                        break;
                    case 376:
                        addItemMV(getDrawable(R.drawable.tammi), "Tammi", "Female", "Apr 02 - Aries", "Peppy", "Mocha / regular / 2T");
                        break;
                    case 377:
                        addItemMV(getDrawable(R.drawable.tangy), "Tangy", "Female", "Jun 17 - Gemini", "Peppy", "Blue Mt. / regular / 2T");
                        break;
                    case 378:
                        addItemMV(getDrawable(R.drawable.tex), "Tex", "Male", "Oct 06 - Libra", "Smug", "Kilimanjaro / regular / 2T");
                        break;
                    case 379:
                        addItemMV(getDrawable(R.drawable.tia), "Tia", "Female", "Nov 18 - Scorpio", "Normal", "Mocha / regular / 2T");
                        break;
                    case 380:
                        addItemMV(getDrawable(R.drawable.tipper), "Tipper", "Female", "Aug 25 - Virgo", "Snooty", "Blue Mt. / X / X");
                        break;
                    case 381:
                        addItemMV(getDrawable(R.drawable.toby), "Toby", "Male", "Jul 10 - Cancer", "Smug", "Mocha / regular / 2T");
                        break;
                    case 382:
                        addItemMV(getDrawable(R.drawable.tom), "Tom", "Male", "Dec 10 - Sagittarius", "Cranky", "Blue Mt. / regular / 2T");
                        break;
                    case 383:
                        addItemMV(getDrawable(R.drawable.tucker), "Tucker", "Male", "Sep 07 - Virgo", "Lazy", "Mocha / regular / 2T");
                        break;
                    case 384:
                        addItemMV(getDrawable(R.drawable.twiggy), "Twiggy", "Female", "Jul 13 - Cancer", "Peppy", "Kilimanjaro / X / X");
                        break;
                    case 385:
                        addItemMV(getDrawable(R.drawable.ursala), "Ursala", "Female", "Jan 16 - Capricorn", "Uchi", "Mocha / X / X");
                        break;
                    case 386:
                        addItemMV(getDrawable(R.drawable.velma), "Velma", "Female", "Jan 14 - Capricorn", "Snooty", "Mocha / lots / 3T");
                        break;
                    case 387:
                        addItemMV(getDrawable(R.drawable.vic), "Vic", "Male", "Dec 29 - Capricorn", "Cranky", "Blue Mt. / regular / 2T");
                        break;
                    case 388:
                        addItemMV(getDrawable(R.drawable.wade), "Wade", "Male", "Oct 30 - Scorpio", "Lazy", "Blue Mt. / X / X");
                        break;
                    case 389:
                        addItemMV(getDrawable(R.drawable.walker), "Walker", "Male", "Jun 10 - Gemini", "Lazy", "Mocha / regular / 2T");
                        break;
                    case 390:
                        addItemMV(getDrawable(R.drawable.walt), "Walt", "Male", "Apr 24 - Taurus", "Cranky", "Blue Mt. / a bit / 2T");
                        break;
                    case 391:
                        addItemMV(getDrawable(R.drawable.wart_jr), "Wart Jr.", "Male", "Aug 21 - Leo", "Cranky", "Blue Mt. / regular / 2T");
                        break;
                    case 392:
                        addItemMV(getDrawable(R.drawable.weber), "Weber", "Male", "Jun 30 - Cancer", "Lazy", "Blue Mt. / lots / 3T");
                        break;
                    case 393:
                        addItemMV(getDrawable(R.drawable.winnie), "Winnie", "Female", "Jan 31 - Aquarius", "Peppy", "Mocha / a bit / 1T");
                        break;
                    case 394:
                        addItemMV(getDrawable(R.drawable.yuka), "Yuka", "Female", "Jul 20 - Cancer", "Snooty", "Kilimanjaro / lots / 3T");
                        break;
                    case 395:
                        addItemMV(getDrawable(R.drawable.zell), "Zell", "Male", "Jun 07 - Gemini", "Smug", "Blend / a bit / 1T");
                        break;
                    default:
                        break;
                }
            }
        }
        mAdapterMV.notifyDataSetChanged();
    }
}
