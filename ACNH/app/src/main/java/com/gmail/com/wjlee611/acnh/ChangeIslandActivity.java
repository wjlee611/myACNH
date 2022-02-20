package com.gmail.com.wjlee611.acnh;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class ChangeIslandActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_island);

        Button btnisland1 = (Button) findViewById(R.id.btnisland1);
        Button btnisland2 = (Button) findViewById(R.id.btnisland2);
        Button btnisland3 = (Button) findViewById(R.id.btnisland3);
        Button back = (Button) findViewById(R.id.btnIslandClose);

        switch (getIntent().getIntExtra("curIsland", 1)) {
            case 1:
                btnisland1.setEnabled(false);
                break;
            case 2:
                btnisland2.setEnabled(false);
                break;
            case 3:
                btnisland3.setEnabled(false);
                break;
            default:
                break;
        }
        final String[] islandNames = new String[3];

        /*데이터 불러오기*/
        try {
            BufferedReader br = new BufferedReader(new FileReader(getFilesDir() + "islandNames.txt"));
            String readStr = "";
            String str = null;
            while ((str = br.readLine()) != null) {
                readStr = str;
            }
            if (readStr != "") {
                String[] array = readStr.split("`");
                if (Locale.getDefault().getLanguage().equals("ko")) {
                    //한국어
                    btnisland1.setText("섬 1로 바꾸기! - " + array[0]);
                    btnisland2.setText("섬 2로 바꾸기! - " + array[1]);
                    btnisland3.setText("섬 3으로 바꾸기! - " + array[2]);
                } else {
                    //default 영어
                    btnisland1.setText("To Island 1 - " + array[0]);
                    btnisland2.setText("To Island 2 - " + array[1]);
                    btnisland3.setText("To Island 3 - " + array[2]);
                }
                for (int i=0; i<3; i++) {
                    islandNames[i] = array[i];
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            if (btnisland1.getText().toString().contains("null")) {
                btnisland1.setText("섬 1 새로 만들기");
            }
            if (btnisland2.getText().toString().contains("null")) {
                btnisland2.setText("섬 2 새로 만들기");
            }
            if (btnisland3.getText().toString().contains("null")) {
                btnisland3.setText("섬 3 새로 만들기");
            }
        } else {
            //default 영어
            if (btnisland1.getText().toString().contains("null")) {
                btnisland1.setText("Create new island 1");
            }
            if (btnisland2.getText().toString().contains("null")) {
                btnisland2.setText("Create new island 2");
            }
            if (btnisland3.getText().toString().contains("null")) {
                btnisland3.setText("Create new island 3");
            }
        }


        btnisland1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Locale.getDefault().getLanguage().equals("ko")) {
                    //한국어
                    Snackbar.make(findViewById(android.R.id.content), islandNames[0] + "(으)로 변경합니다.", Snackbar.LENGTH_LONG)
                            .setAction("적용 후 종료하기", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    save(1);
                                }
                            }).show();
                } else {
                    //default 영어
                    Snackbar.make(findViewById(android.R.id.content), "Change island to " + islandNames[0] + ".", Snackbar.LENGTH_LONG)
                            .setAction("Apply and Quit", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    save(1);
                                }
                            }).show();
                }
            }
        });

        btnisland2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Locale.getDefault().getLanguage().equals("ko")) {
                    //한국어
                    Snackbar.make(findViewById(android.R.id.content), islandNames[1] + "(으)로 변경합니다.", Snackbar.LENGTH_LONG)
                            .setAction("적용 후 종료하기", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    save(2);
                                }
                            }).show();
                } else {
                    //default 영어
                    Snackbar.make(findViewById(android.R.id.content), "Change island to " + islandNames[1] + ".", Snackbar.LENGTH_LONG)
                            .setAction("Apply and Quit", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    save(2);
                                }
                            }).show();
                }
            }
        });

        btnisland3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Locale.getDefault().getLanguage().equals("ko")) {
                    //한국어
                    Snackbar.make(findViewById(android.R.id.content), islandNames[2] + "(으)로 변경합니다.", Snackbar.LENGTH_LONG)
                            .setAction("적용 후 종료하기", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    save(3);
                                }
                            }).show();
                } else {
                    //default 영어
                    Snackbar.make(findViewById(android.R.id.content), "Change island to " + islandNames[2] + ".", Snackbar.LENGTH_LONG)
                            .setAction("Apply and Quit", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    save(3);
                                }
                            }).show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                ChangeIslandActivity.super.onDestroy();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onDestroy();
        //super.onBackPressed();
    }

    public void save(int curIsland) {
        /*저장하기*/
        try {
            BufferedWriter bw1 = new BufferedWriter(new FileWriter(getFilesDir() + "curIsland.txt"));
            String ci = Integer.toString(curIsland);
            bw1.write(ci);

            bw1.close();
        } catch (IOException e) {
            e.printStackTrace();
            Snackbar.make(findViewById(android.R.id.content), e.getMessage(), Snackbar.LENGTH_SHORT).show();
        }

        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            Toast.makeText(this, "적용되었습니다. 다시 실행해주세요!", Toast.LENGTH_SHORT).show();
        } else {
            //default 영어
            Toast.makeText(this, "Applied. Please restart application!", Toast.LENGTH_SHORT).show();
        }

        finishAffinity();
    }
}
