package com.gmail.com.wjlee611.acnh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Locale;

public class AnalysisActivity extends Activity {

    int[] turnipValues = new int[13];

    RecyclerView mRecyclerViewTa = null;
    AnalysisRecyclerAdapter mAdapterTa = null;
    ArrayList<AnalysisRecyclerItem> mListTa = new ArrayList<AnalysisRecyclerItem>();

    /*분석 상수*/
    double fluct_d1_1 = 0.6, fluct_d1_2 = 0.8, fluct_d2_1 = 0.5, fluct_d2_2 = 0.76,
            fluct_d3_1 = 0.4, fluct_d3_2 = 0.72, fluct_u_1 = 0.9, fluct_u_2 = 1.4;
    double decre_1_1 =0.85, decre_1_2 = 0.9, decre_2_1 =0.79, decre_2_2 = 0.88,
            decre_3_1 =0.73, decre_3_2 = 0.86, decre_4_1 =0.67, decre_4_2 = 0.84,
            decre_5_1 =0.61, decre_5_2 = 0.82, decre_6_1 =0.55, decre_6_2 = 0.8,
            decre_7_1 =0.49, decre_7_2 = 0.78, decre_8_1 =0.43, decre_8_2 = 0.76,
            decre_9_1 =0.37, decre_9_2 = 0.74, decre_10_1 =0.31, decre_10_2 = 0.72,
            decre_11_1 =0.25, decre_11_2 = 0.7, decre_12_1 =0.19, decre_12_2 = 0.68;
    double lSpik_u1_1 = 0.9, lSpik_u1_2 = 1.4, lSpik_u2_1 = 1.4, lSpik_u2_2 = 2,
            lSpik_u3_1 = 2, lSpik_u3_2 = 6, lSpik_dc_1 = 0.4, lSpic_dc_2 = 0.9,
            lSpik_d1_1 = 0.85, lSpik_d1_2 = 0.9, lSpik_d2_1 = 0.79, lSpik_d2_2 = 0.88,
            lSpik_d3_1 = 0.73, lSpik_d3_2 = 0.86, lSpik_d4_1 = 0.67, lSpik_d4_2 = 0.84,
            lSpik_d5_1 = 0.61, lSpik_d5_2 = 0.82, lSpik_d6_1 = 0.55, lSpik_d6_2 = 0.8,
            lSpik_d7_1 = 0.49, lSpik_d7_2 = 0.78;
    double sSpik_u12_1 = 0.9, sSpik_u12_2 = 1.4, sSpik_u3_1 = 1.4, sSpik_u3_2 = 1.9,
            sSpik_u4_1 = 1.4, sSpik_u4_2 = 2, sSpik_d1_1 = 0.4, sSpik_d1_2 = 0.9,
            sSpik_d2_1 = 0.34, sSpik_d2_2 = 0.88, sSpik_d3_1 = 0.28, sSpik_d3_2 = 0.86,
            sSpik_d4_1 = 0.22, sSpik_d4_2 = 0.84, sSpik_d5_1 = 0.16, sSpik_d5_2 = 0.82,
            sSpik_d6_1 = 0.1, sSpik_d6_2 = 0.8, sSpik_d7_1 = 0.04, sSpik_d7_2 = 0.78;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.turnip_analysis);

        TextView analysisSUN = (TextView) findViewById(R.id.analysisSUN);
        TextView analysisMONAM = (TextView) findViewById(R.id.analysisMONAM);
        TextView analysisMONPM = (TextView) findViewById(R.id.analysisMONPM);
        TextView analysisTUEAM = (TextView) findViewById(R.id.analysisTUEAM);
        TextView analysisTUEPM = (TextView) findViewById(R.id.analysisTUEPM);
        TextView analysisWEDAM = (TextView) findViewById(R.id.analysisWEDAM);
        TextView analysisWEDPM = (TextView) findViewById(R.id.analysisWEDPM);
        TextView analysisTHUAM = (TextView) findViewById(R.id.analysisTHUAM);
        TextView analysisTHUPM = (TextView) findViewById(R.id.analysisTHUPM);
        TextView analysisFRIAM = (TextView) findViewById(R.id.analysisFRIAM);
        TextView analysisFRIPM = (TextView) findViewById(R.id.analysisFRIPM);
        TextView analysisSATAM = (TextView) findViewById(R.id.analysisSATAM);
        TextView analysisSATPM = (TextView) findViewById(R.id.analysisSATPM);

        Intent intent = getIntent();
        turnipValues = intent.getIntArrayExtra("values");

        if (turnipValues[0]==0) {
            analysisSUN.setText("-");
        } else {
            analysisSUN.setText(Integer.toString(turnipValues[0]));
        }
        if (turnipValues[1]==0) {
            analysisMONAM.setText("-");
        } else {
            analysisMONAM.setText(Integer.toString(turnipValues[1]));
        }
        if (turnipValues[2]==0) {
            analysisMONPM.setText("-");
        } else {
            analysisMONPM.setText(Integer.toString(turnipValues[2]));
        }
        if (turnipValues[3]==0) {
            analysisTUEAM.setText("-");
        } else {
            analysisTUEAM.setText(Integer.toString(turnipValues[3]));
        }
        if (turnipValues[4]==0) {
            analysisTUEPM.setText("-");
        } else {
            analysisTUEPM.setText(Integer.toString(turnipValues[4]));
        }
        if (turnipValues[5]==0) {
            analysisWEDAM.setText("-");
        } else {
            analysisWEDAM.setText(Integer.toString(turnipValues[5]));
        }
        if (turnipValues[6]==0) {
            analysisWEDPM.setText("-");
        } else {
            analysisWEDPM.setText(Integer.toString(turnipValues[6]));
        }
        if (turnipValues[7]==0) {
            analysisTHUAM.setText("-");
        } else {
            analysisTHUAM.setText(Integer.toString(turnipValues[7]));
        }
        if (turnipValues[8]==0) {
            analysisTHUPM.setText("-");
        } else {
            analysisTHUPM.setText(Integer.toString(turnipValues[8]));
        }
        if (turnipValues[9]==0) {
            analysisFRIAM.setText("-");
        } else {
            analysisFRIAM.setText(Integer.toString(turnipValues[9]));
        }
        if (turnipValues[10]==0) {
            analysisFRIPM.setText("-");
        } else {
            analysisFRIPM.setText(Integer.toString(turnipValues[10]));
        }
        if (turnipValues[11]==0) {
            analysisSATAM.setText("-");
        } else {
            analysisSATAM.setText(Integer.toString(turnipValues[11]));
        }
        if (turnipValues[12]==0) {
            analysisSATPM.setText("-");
        } else {
            analysisSATPM.setText(Integer.toString(turnipValues[12]));
        }


        mRecyclerViewTa = findViewById(R.id.analysisRecyclerView);

        mAdapterTa = new AnalysisRecyclerAdapter(mListTa);
        mRecyclerViewTa.setAdapter(mAdapterTa);

        mRecyclerViewTa.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        /*분석 상수 수정
        //u (고점)은 turnipValues[0]*기존 상수
        //d1 (하락 시작)은 turnipValues[0]*기존 상수
        //d2~ (하락 지속)은 직전 판매가 + turnipValues[0]*변동 범위 (-0.1~-0.04 등등 새로운 개념)
        fluct_d1_1 = 0.6;
        fluct_d1_2 = 0.8;
        fluct_d2_1 = 0.5;
        fluct_d2_2 = 0.76;
        fluct_d3_1 = 0.4;
        fluct_d3_2 = 0.72;
        fluct_u_1 = 0.9;
        fluct_u_2 = 1.4;

        decre_1_1 =0.85; decre_1_2 = 0.9; decre_2_1 =0.79; decre_2_2 = 0.88;
        decre_3_1 =0.73; decre_3_2 = 0.86; decre_4_1 =0.67; decre_4_2 = 0.84;
        decre_5_1 =0.61; decre_5_2 = 0.82; decre_6_1 =0.55; decre_6_2 = 0.8;
        decre_7_1 =0.49; decre_7_2 = 0.78; decre_8_1 =0.43; decre_8_2 = 0.76;
        decre_9_1 =0.37; decre_9_2 = 0.74; decre_10_1 =0.31; decre_10_2 = 0.72;
        decre_11_1 =0.25; decre_11_2 = 0.7; decre_12_1 =0.19; decre_12_2 = 0.68;

        lSpik_u1_1 = 0.9; lSpik_u1_2 = 1.4; lSpik_u2_1 = 1.4; lSpik_u2_2 = 2;
        lSpik_u3_1 = 2; lSpik_u3_2 = 6; lSpik_dc_1 = 0.4; lSpic_dc_2 = 0.9;
        lSpik_d1_1 = 0.85; lSpik_d1_2 = 0.9; lSpik_d2_1 = 0.79; lSpik_d2_2 = 0.88;
        lSpik_d3_1 = 0.73; lSpik_d3_2 = 0.86; lSpik_d4_1 = 0.67; lSpik_d4_2 = 0.84;
        lSpik_d5_1 = 0.61; lSpik_d5_2 = 0.82; lSpik_d6_1 = 0.55; lSpik_d6_2 = 0.8;
        lSpik_d7_1 = 0.49; lSpik_d7_2 = 0.78;

        sSpik_u12_1 = 0.9; sSpik_u12_2 = 1.4; sSpik_u3_1 = 1.4; sSpik_u3_2 = 1.9;
        sSpik_u4_1 = 1.4; sSpik_u4_2 = 2; sSpik_d1_1 = 0.4; sSpik_d1_2 = 0.9;
        sSpik_d2_1 = 0.34; sSpik_d2_2 = 0.88; sSpik_d3_1 = 0.28; sSpik_d3_2 = 0.86;
        sSpik_d4_1 = 0.22; sSpik_d4_2 = 0.84; sSpik_d5_1 = 0.16; sSpik_d5_2 = 0.82;
        sSpik_d6_1 = 0.1; sSpik_d6_2 = 0.8; sSpik_d7_1 = 0.04; sSpik_d7_2 = 0.78;*/


        /*분석값 추가*/
        analysis();

        mAdapterTa.notifyDataSetChanged();
    }


    @Override
    public void onBackPressed() {
        mListTa.clear();

        mRecyclerViewTa = null;
        mAdapterTa = null;
        mListTa = null;

        finish();
        super.onDestroy();
        //super.onBackPressed();
    }


    public void analysis() {
        //0~55: Fluctuating (웨이브)
        //56: Decreasing (지속하락)
        //57~63: Large Spike (3기)
        //64~71: Small Spike (4기)
        double[][] valueCases = {
                //Fluctuating A~G Case Set: 2d-3d, ㄱ~ㅅ Case Set: 3d-2d
                //A set
                {fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2},
                {fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2},
                {fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2},
                {fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2},
                {fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2},
                {fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2},
                {fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2},
                //B set
                {fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2},
                {fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2},
                {fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2},
                {fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2},
                {fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2},
                {fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2},
                //C set
                {fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2},
                {fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2},
                {fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2},
                {fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2},
                {fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2},
                //D set
                {fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_u_1, fluct_u_2, fluct_d2_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2},
                {fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d2_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2},
                {fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d2_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2},
                {fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d2_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2},
                //E set
                {fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2},
                {fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2},
                {fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2},
                //F set
                {fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2},
                {fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2},
                //G set
                {fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2},
                //ㄱ set
                {fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2},
                {fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2},
                {fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2},
                {fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2},
                {fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2},
                {fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2},
                {fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2},
                //ㄴ set
                {fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2},
                {fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2},
                {fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2},
                {fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2},
                {fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2},
                {fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2},
                //ㄷ set
                {fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2},
                {fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2},
                {fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2},
                {fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2},
                {fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2},
                //ㄹ set
                {fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2},
                {fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2},
                {fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2},
                {fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2},
                //ㅁ set
                {fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2},
                {fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2},
                {fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2},
                //ㅂ set
                {fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_u_1, fluct_u_2},
                {fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2},
                //ㅅ set
                {fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2, fluct_d3_1, fluct_d3_2, fluct_u_1, fluct_u_2, fluct_d1_1, fluct_d1_2, fluct_d2_1, fluct_d2_2},
                //Decreasing
                {decre_1_1, decre_1_2, decre_2_1, decre_2_2, decre_3_1, decre_3_2, decre_4_1, decre_4_2, decre_5_1, decre_5_2, decre_6_1, decre_6_2, decre_7_1, decre_7_2, decre_8_1, decre_8_2, decre_9_1, decre_9_2, decre_10_1, decre_10_2, decre_11_1, decre_11_2, decre_12_1, decre_12_2},
                //Large Spike
                {lSpik_d1_1, lSpik_d1_2, lSpik_u1_1, lSpik_u1_2, lSpik_u2_1, lSpik_u2_2, lSpik_u3_1, lSpik_u3_2, lSpik_u2_1, lSpik_u2_2, lSpik_u1_1, lSpik_u1_2, lSpik_dc_1, lSpic_dc_2, lSpik_dc_1, lSpic_dc_2, lSpik_dc_1, lSpic_dc_2, lSpik_dc_1, lSpic_dc_2, lSpik_dc_1, lSpic_dc_2, lSpik_dc_1, lSpic_dc_2},
                {lSpik_d1_1, lSpik_d1_2, lSpik_d2_1, lSpik_d2_2, lSpik_u1_1, lSpik_u1_2, lSpik_u2_1, lSpik_u2_2, lSpik_u3_1, lSpik_u3_2, lSpik_u2_1, lSpik_u2_2, lSpik_u1_1, lSpik_u1_2, lSpik_dc_1, lSpic_dc_2, lSpik_dc_1, lSpic_dc_2, lSpik_dc_1, lSpic_dc_2, lSpik_dc_1, lSpic_dc_2, lSpik_dc_1, lSpic_dc_2},
                {lSpik_d1_1, lSpik_d1_2, lSpik_d2_1, lSpik_d2_2, lSpik_d3_1, lSpik_d3_2, lSpik_u1_1, lSpik_u1_2, lSpik_u2_1, lSpik_u2_2, lSpik_u3_1, lSpik_u3_2, lSpik_u2_1, lSpik_u2_2, lSpik_u1_1, lSpik_u1_2, lSpik_dc_1, lSpic_dc_2, lSpik_dc_1, lSpic_dc_2, lSpik_dc_1, lSpic_dc_2, lSpik_dc_1, lSpic_dc_2},
                {lSpik_d1_1, lSpik_d1_2, lSpik_d2_1, lSpik_d2_2, lSpik_d3_1, lSpik_d3_2, lSpik_d4_1, lSpik_d4_2, lSpik_u1_1, lSpik_u1_2, lSpik_u2_1, lSpik_u2_2, lSpik_u3_1, lSpik_u3_2, lSpik_u2_1, lSpik_u2_2, lSpik_u1_1, lSpik_u1_2, lSpik_dc_1, lSpic_dc_2, lSpik_dc_1, lSpic_dc_2, lSpik_dc_1, lSpic_dc_2},
                {lSpik_d1_1, lSpik_d1_2, lSpik_d2_1, lSpik_d2_2, lSpik_d3_1, lSpik_d3_2, lSpik_d4_1, lSpik_d4_2, lSpik_d5_1, lSpik_d5_2, lSpik_u1_1, lSpik_u1_2, lSpik_u2_1, lSpik_u2_2, lSpik_u3_1, lSpik_u3_2, lSpik_u2_1, lSpik_u2_2, lSpik_u1_1, lSpik_u1_2, lSpik_dc_1, lSpic_dc_2, lSpik_dc_1, lSpic_dc_2},
                {lSpik_d1_1, lSpik_d1_2, lSpik_d2_1, lSpik_d2_2, lSpik_d3_1, lSpik_d3_2, lSpik_d4_1, lSpik_d4_2, lSpik_d5_1, lSpik_d5_2, lSpik_d6_1, lSpik_d6_2, lSpik_u1_1, lSpik_u1_2, lSpik_u2_1, lSpik_u2_2, lSpik_u3_1, lSpik_u3_2, lSpik_u2_1, lSpik_u2_2, lSpik_u1_1, lSpik_u1_2, lSpik_dc_1, lSpic_dc_2},
                {lSpik_d1_1, lSpik_d1_2, lSpik_d2_1, lSpik_d2_2, lSpik_d3_1, lSpik_d3_2, lSpik_d4_1, lSpik_d4_2, lSpik_d5_1, lSpik_d5_2, lSpik_d6_1, lSpik_d6_2, lSpik_d7_1, lSpik_d7_2, lSpik_u1_1, lSpik_u1_2, lSpik_u2_1, lSpik_u2_2, lSpik_u3_1, lSpik_u3_2, lSpik_u2_1, lSpik_u2_2, lSpik_u1_1, lSpik_u1_2},
                //Small Spike
                {sSpik_u12_1, sSpik_u12_2, sSpik_u12_1, sSpik_u12_2, sSpik_u3_1, sSpik_u3_2, sSpik_u4_1, sSpik_u4_2, sSpik_u3_1, sSpik_u3_2, sSpik_d1_1, sSpik_d1_2, sSpik_d2_1, sSpik_d2_2, sSpik_d3_1, sSpik_d3_2, sSpik_d4_1, sSpik_d4_2, sSpik_d5_1, sSpik_d5_2, sSpik_d6_1, sSpik_d6_2, sSpik_d7_1, sSpik_d7_2},
                {sSpik_d1_1, sSpik_d1_2, sSpik_u12_1, sSpik_u12_2, sSpik_u12_1, sSpik_u12_2, sSpik_u3_1, sSpik_u3_2, sSpik_u4_1, sSpik_u4_2, sSpik_u3_1, sSpik_u3_2, sSpik_d1_1, sSpik_d1_2, sSpik_d2_1, sSpik_d2_2, sSpik_d3_1, sSpik_d3_2, sSpik_d4_1, sSpik_d4_2, sSpik_d5_1, sSpik_d5_2, sSpik_d6_1, sSpik_d6_2},
                {sSpik_d1_1, sSpik_d1_2, sSpik_d2_1, sSpik_d2_2, sSpik_u12_1, sSpik_u12_2, sSpik_u12_1, sSpik_u12_2, sSpik_u3_1, sSpik_u3_2, sSpik_u4_1, sSpik_u4_2, sSpik_u3_1, sSpik_u3_2, sSpik_d1_1, sSpik_d1_2, sSpik_d2_1, sSpik_d2_2, sSpik_d3_1, sSpik_d3_2, sSpik_d4_1, sSpik_d4_2, sSpik_d5_1, sSpik_d5_2},
                {sSpik_d1_1, sSpik_d1_2, sSpik_d2_1, sSpik_d2_2, sSpik_d3_1, sSpik_d3_2, sSpik_u12_1, sSpik_u12_2, sSpik_u12_1, sSpik_u12_2, sSpik_u3_1, sSpik_u3_2, sSpik_u4_1, sSpik_u4_2, sSpik_u3_1, sSpik_u3_2, sSpik_d1_1, sSpik_d1_2, sSpik_d2_1, sSpik_d2_2, sSpik_d3_1, sSpik_d3_2, sSpik_d4_1, sSpik_d4_2},
                {sSpik_d1_1, sSpik_d1_2, sSpik_d2_1, sSpik_d2_2, sSpik_d3_1, sSpik_d3_2, sSpik_d4_1, sSpik_d4_2, sSpik_u12_1, sSpik_u12_2, sSpik_u12_1, sSpik_u12_2, sSpik_u3_1, sSpik_u3_2, sSpik_u4_1, sSpik_u4_2, sSpik_u3_1, sSpik_u3_2, sSpik_d1_1, sSpik_d1_2, sSpik_d2_1, sSpik_d2_2, sSpik_d3_1, sSpik_d3_2},
                {sSpik_d1_1, sSpik_d1_2, sSpik_d2_1, sSpik_d2_2, sSpik_d3_1, sSpik_d3_2, sSpik_d4_1, sSpik_d4_2, sSpik_d5_1, sSpik_d5_2, sSpik_u12_1, sSpik_u12_2, sSpik_u12_1, sSpik_u12_2, sSpik_u3_1, sSpik_u3_2, sSpik_u4_1, sSpik_u4_2, sSpik_u3_1, sSpik_u3_2, sSpik_d1_1, sSpik_d1_2, sSpik_d2_1, sSpik_d2_2},
                {sSpik_d1_1, sSpik_d1_2, sSpik_d2_1, sSpik_d2_2, sSpik_d3_1, sSpik_d3_2, sSpik_d4_1, sSpik_d4_2, sSpik_d5_1, sSpik_d5_2, sSpik_d6_1, sSpik_d6_2, sSpik_u12_1, sSpik_u12_2, sSpik_u12_1, sSpik_u12_2, sSpik_u3_1, sSpik_u3_2, sSpik_u4_1, sSpik_u4_2, sSpik_u3_1, sSpik_u3_2, sSpik_d1_1, sSpik_d1_2},
                {sSpik_d1_1, sSpik_d1_2, sSpik_d2_1, sSpik_d2_2, sSpik_d3_1, sSpik_d3_2, sSpik_d4_1, sSpik_d4_2, sSpik_d5_1, sSpik_d5_2, sSpik_d6_1, sSpik_d6_2, sSpik_d7_1, sSpik_d7_2, sSpik_u12_1, sSpik_u12_2, sSpik_u12_1, sSpik_u12_2, sSpik_u3_1, sSpik_u3_2, sSpik_u4_1, sSpik_u4_2, sSpik_u3_1, sSpik_u3_2}
        };  //72 Cases (56, 1, 7, 8), 24 Slots


        String[] expectedTurnipValue = new String[12];

        for(int i=0; i<72; i++) {
            for(int j=0; j<12; j++) {
                if (turnipValues[j+1]==0) {
                    expectedTurnipValue[j] = "0";
                } else {
                    if (turnipValues[0]*valueCases[i][j*2]<turnipValues[j+1] && turnipValues[j+1]<turnipValues[0]*valueCases[i][j*2+1]) {
                        expectedTurnipValue[j] = Integer.toString(turnipValues[j+1]);
                    } else break;
                }

                if (j==11) {
                    for (int k=0; k<12; k++) {
                        if (expectedTurnipValue[k].equals("0")) {
                            expectedTurnipValue[k] = (int)(turnipValues[0]*valueCases[i][k*2]) + "\n~" + (int)(turnipValues[0]*valueCases[i][k*2+1]);
                        }
                    }

                    if (Locale.getDefault().getLanguage().equals("ko")) {
                        //한국어
                        if (i<=55) {
                            addItem("웨이브", Integer.toString(turnipValues[0]), expectedTurnipValue[0], expectedTurnipValue[1]
                                    , expectedTurnipValue[2], expectedTurnipValue[3], expectedTurnipValue[4], expectedTurnipValue[5]
                                    , expectedTurnipValue[6], expectedTurnipValue[7], expectedTurnipValue[8], expectedTurnipValue[9]
                                    , expectedTurnipValue[10], expectedTurnipValue[11]);
                        } else if (i==56) {
                            addItem("지속하락", Integer.toString(turnipValues[0]), expectedTurnipValue[0], expectedTurnipValue[1]
                                    , expectedTurnipValue[2], expectedTurnipValue[3], expectedTurnipValue[4], expectedTurnipValue[5]
                                    , expectedTurnipValue[6], expectedTurnipValue[7], expectedTurnipValue[8], expectedTurnipValue[9]
                                    , expectedTurnipValue[10], expectedTurnipValue[11]);
                        } else if (i<=63) {
                            addItem("3기", Integer.toString(turnipValues[0]), expectedTurnipValue[0], expectedTurnipValue[1]
                                    , expectedTurnipValue[2], expectedTurnipValue[3], expectedTurnipValue[4], expectedTurnipValue[5]
                                    , expectedTurnipValue[6], expectedTurnipValue[7], expectedTurnipValue[8], expectedTurnipValue[9]
                                    , expectedTurnipValue[10], expectedTurnipValue[11]);
                        } else {
                            addItem("4기", Integer.toString(turnipValues[0]), expectedTurnipValue[0], expectedTurnipValue[1]
                                    , expectedTurnipValue[2], expectedTurnipValue[3], expectedTurnipValue[4], expectedTurnipValue[5]
                                    , expectedTurnipValue[6], expectedTurnipValue[7], expectedTurnipValue[8], expectedTurnipValue[9]
                                    , expectedTurnipValue[10], expectedTurnipValue[11]);
                        }
                    } else {
                        //default 영어
                        if (i<=55) {
                            addItem("Fluct.", Integer.toString(turnipValues[0]), expectedTurnipValue[0], expectedTurnipValue[1]
                                    , expectedTurnipValue[2], expectedTurnipValue[3], expectedTurnipValue[4], expectedTurnipValue[5]
                                    , expectedTurnipValue[6], expectedTurnipValue[7], expectedTurnipValue[8], expectedTurnipValue[9]
                                    , expectedTurnipValue[10], expectedTurnipValue[11]);
                        } else if (i==56) {
                            addItem("Decre.", Integer.toString(turnipValues[0]), expectedTurnipValue[0], expectedTurnipValue[1]
                                    , expectedTurnipValue[2], expectedTurnipValue[3], expectedTurnipValue[4], expectedTurnipValue[5]
                                    , expectedTurnipValue[6], expectedTurnipValue[7], expectedTurnipValue[8], expectedTurnipValue[9]
                                    , expectedTurnipValue[10], expectedTurnipValue[11]);
                        } else if (i<=63) {
                            addItem("Large\nSpike", Integer.toString(turnipValues[0]), expectedTurnipValue[0], expectedTurnipValue[1]
                                    , expectedTurnipValue[2], expectedTurnipValue[3], expectedTurnipValue[4], expectedTurnipValue[5]
                                    , expectedTurnipValue[6], expectedTurnipValue[7], expectedTurnipValue[8], expectedTurnipValue[9]
                                    , expectedTurnipValue[10], expectedTurnipValue[11]);
                        } else {
                            addItem("Small\nSpike", Integer.toString(turnipValues[0]), expectedTurnipValue[0], expectedTurnipValue[1]
                                    , expectedTurnipValue[2], expectedTurnipValue[3], expectedTurnipValue[4], expectedTurnipValue[5]
                                    , expectedTurnipValue[6], expectedTurnipValue[7], expectedTurnipValue[8], expectedTurnipValue[9]
                                    , expectedTurnipValue[10], expectedTurnipValue[11]);
                        }
                    }
                }
            }
        }


        if (mAdapterTa.getItemCount() == 0) {
            Snackbar.make(findViewById(android.R.id.content), "특이 케이스 발견. 오차 ±5 적용 계산식을 출력합니다.", Snackbar.LENGTH_LONG).show();

            for(int i=0; i<72; i++) {
                for(int j=0; j<12; j++) {
                    if (turnipValues[j+1]==0) {
                        expectedTurnipValue[j] = "0";
                    } else {
                        if (turnipValues[0]*valueCases[i][j*2]-5<turnipValues[j+1] && turnipValues[j+1]<turnipValues[0]*valueCases[i][j*2+1]+5) {
                            expectedTurnipValue[j] = Integer.toString(turnipValues[j+1]);
                        } else break;
                    }

                    if (j==11) {
                        for (int k=0; k<12; k++) {
                            if (expectedTurnipValue[k].equals("0")) {
                                expectedTurnipValue[k] = (int)(turnipValues[0]*valueCases[i][k*2]-5) + "\n~" + (int)(turnipValues[0]*valueCases[i][k*2+1]+5);
                            }
                        }

                        if (Locale.getDefault().getLanguage().equals("ko")) {
                            //한국어
                            if (i<=55) {
                                addItem("웨이브", Integer.toString(turnipValues[0]), expectedTurnipValue[0], expectedTurnipValue[1]
                                        , expectedTurnipValue[2], expectedTurnipValue[3], expectedTurnipValue[4], expectedTurnipValue[5]
                                        , expectedTurnipValue[6], expectedTurnipValue[7], expectedTurnipValue[8], expectedTurnipValue[9]
                                        , expectedTurnipValue[10], expectedTurnipValue[11]);
                            } else if (i==56) {
                                addItem("지속하락", Integer.toString(turnipValues[0]), expectedTurnipValue[0], expectedTurnipValue[1]
                                        , expectedTurnipValue[2], expectedTurnipValue[3], expectedTurnipValue[4], expectedTurnipValue[5]
                                        , expectedTurnipValue[6], expectedTurnipValue[7], expectedTurnipValue[8], expectedTurnipValue[9]
                                        , expectedTurnipValue[10], expectedTurnipValue[11]);
                            } else if (i<=63) {
                                addItem("3기", Integer.toString(turnipValues[0]), expectedTurnipValue[0], expectedTurnipValue[1]
                                        , expectedTurnipValue[2], expectedTurnipValue[3], expectedTurnipValue[4], expectedTurnipValue[5]
                                        , expectedTurnipValue[6], expectedTurnipValue[7], expectedTurnipValue[8], expectedTurnipValue[9]
                                        , expectedTurnipValue[10], expectedTurnipValue[11]);
                            } else {
                                addItem("4기", Integer.toString(turnipValues[0]), expectedTurnipValue[0], expectedTurnipValue[1]
                                        , expectedTurnipValue[2], expectedTurnipValue[3], expectedTurnipValue[4], expectedTurnipValue[5]
                                        , expectedTurnipValue[6], expectedTurnipValue[7], expectedTurnipValue[8], expectedTurnipValue[9]
                                        , expectedTurnipValue[10], expectedTurnipValue[11]);
                            }
                        } else {
                            //default 영어
                            if (i<=55) {
                                addItem("Fluct.", Integer.toString(turnipValues[0]), expectedTurnipValue[0], expectedTurnipValue[1]
                                        , expectedTurnipValue[2], expectedTurnipValue[3], expectedTurnipValue[4], expectedTurnipValue[5]
                                        , expectedTurnipValue[6], expectedTurnipValue[7], expectedTurnipValue[8], expectedTurnipValue[9]
                                        , expectedTurnipValue[10], expectedTurnipValue[11]);
                            } else if (i==56) {
                                addItem("Decre.", Integer.toString(turnipValues[0]), expectedTurnipValue[0], expectedTurnipValue[1]
                                        , expectedTurnipValue[2], expectedTurnipValue[3], expectedTurnipValue[4], expectedTurnipValue[5]
                                        , expectedTurnipValue[6], expectedTurnipValue[7], expectedTurnipValue[8], expectedTurnipValue[9]
                                        , expectedTurnipValue[10], expectedTurnipValue[11]);
                            } else if (i<=63) {
                                addItem("Large\nSpike", Integer.toString(turnipValues[0]), expectedTurnipValue[0], expectedTurnipValue[1]
                                        , expectedTurnipValue[2], expectedTurnipValue[3], expectedTurnipValue[4], expectedTurnipValue[5]
                                        , expectedTurnipValue[6], expectedTurnipValue[7], expectedTurnipValue[8], expectedTurnipValue[9]
                                        , expectedTurnipValue[10], expectedTurnipValue[11]);
                            } else {
                                addItem("Small\nSpike", Integer.toString(turnipValues[0]), expectedTurnipValue[0], expectedTurnipValue[1]
                                        , expectedTurnipValue[2], expectedTurnipValue[3], expectedTurnipValue[4], expectedTurnipValue[5]
                                        , expectedTurnipValue[6], expectedTurnipValue[7], expectedTurnipValue[8], expectedTurnipValue[9]
                                        , expectedTurnipValue[10], expectedTurnipValue[11]);
                            }
                        }
                    }
                }
            }
        }

        if (mAdapterTa.getItemCount() == 0) {
            Snackbar.make(findViewById(android.R.id.content), "탐지 실패.", Snackbar.LENGTH_LONG).show();
        }
    }


    public void addItem(String form, String sun, String monAM, String monPM, String tueAM, String tuePM, String wedAM, String wedPM,
                        String thuAM, String thuPM, String friAM, String friPM, String satAM, String satPM) {
        AnalysisRecyclerItem item = new AnalysisRecyclerItem();

        item.setForm(form);
        item.setSun(sun);
        item.setMonAM(monAM);
        item.setMonPM(monPM);
        item.setTueAM(tueAM);
        item.setTuePM(tuePM);
        item.setWedAM(wedAM);
        item.setWedPM(wedPM);
        item.setThuAM(thuAM);
        item.setThuPM(thuPM);
        item.setFriAM(friAM);
        item.setFriPM(friPM);
        item.setSatAM(satAM);
        item.setSatPM(satPM);

        mListTa.add(item);
    }
}
