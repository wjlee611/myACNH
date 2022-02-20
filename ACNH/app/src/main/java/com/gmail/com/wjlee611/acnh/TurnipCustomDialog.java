package com.gmail.com.wjlee611.acnh;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class TurnipCustomDialog{

    private Context context;

    public TurnipCustomDialog(Context context) {
        this.context = context;
    }

    EditText turnipValue;
    TextView turnipLengthWarn;

    public void callFunction(final TextView mainTv) {
        final Dialog dlg = new Dialog(context);
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dlg.setContentView(R.layout.turnip_popup);
        dlg.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dlg.setCancelable(false);
        dlg.show();


        turnipValue = (EditText) dlg.findViewById(R.id.edtTurnipValue);
        Button btnTurnipOk = (Button) dlg.findViewById(R.id.btnTurnipOk);
        Button btnTurnipCancel = (Button) dlg.findViewById(R.id.btnTurnipCancel);
        turnipLengthWarn = (TextView) dlg.findViewById(R.id.turnipLengthWarn);
        turnipLengthWarn.setVisibility(View.GONE);

        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            switch (mainTv.getId()) {
                case R.id.tvturSUN: turnipValue.setHint("일요일 매입가 입력"); break;
                case R.id.tvturMONam: turnipValue.setHint("월요일 AM 매매가 입력"); break;
                case R.id.tvturMONpm: turnipValue.setHint("월요일 PM 매매가 입력"); break;
                case R.id.tvturTUEam: turnipValue.setHint("화요일 AM 매매가 입력"); break;
                case R.id.tvturTUEpm: turnipValue.setHint("화요일 PM 매매가 입력"); break;
                case R.id.tvturWEDam: turnipValue.setHint("수요일 AM 매매가 입력"); break;
                case R.id.tvturWEDpm: turnipValue.setHint("수요일 PM 매매가 입력"); break;
                case R.id.tvturTHUam: turnipValue.setHint("목요일 AM 매매가 입력"); break;
                case R.id.tvturTHUpm: turnipValue.setHint("목요일 PM 매매가 입력"); break;
                case R.id.tvturFRIam: turnipValue.setHint("금요일 AM 매매가 입력"); break;
                case R.id.tvturFRIpm: turnipValue.setHint("금요일 PM 매매가 입력"); break;
                case R.id.tvturSATam: turnipValue.setHint("토요일 AM 매매가 입력"); break;
                case R.id.tvturSATpm: turnipValue.setHint("토요일 PM 매매가 입력"); break;
                default: break;
            }
        } else {
            //default 영어
            switch (mainTv.getId()) {
                case R.id.tvturSUN: turnipValue.setHint("Original Price"); break;
                case R.id.tvturMONam: turnipValue.setHint("Mon AM Price"); break;
                case R.id.tvturMONpm: turnipValue.setHint("Mon PM Price"); break;
                case R.id.tvturTUEam: turnipValue.setHint("Tue AM Price"); break;
                case R.id.tvturTUEpm: turnipValue.setHint("Tue PM Price"); break;
                case R.id.tvturWEDam: turnipValue.setHint("Wed AM Price"); break;
                case R.id.tvturWEDpm: turnipValue.setHint("Wed PM Price"); break;
                case R.id.tvturTHUam: turnipValue.setHint("Thu AM Price"); break;
                case R.id.tvturTHUpm: turnipValue.setHint("Thu PM Price"); break;
                case R.id.tvturFRIam: turnipValue.setHint("Fri AM Price"); break;
                case R.id.tvturFRIpm: turnipValue.setHint("Fri PM Price"); break;
                case R.id.tvturSATam: turnipValue.setHint("Sat AM Price"); break;
                case R.id.tvturSATpm: turnipValue.setHint("Sat PM Price"); break;
                default: break;
            }
        }
        turnipValue.setText(mainTv.getText().toString());

        btnTurnipOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (turnipValue.getText().toString().length() > 3) {
                    turnipLengthWarn.setVisibility(View.VISIBLE);
                } else {
                    int tmp;
                    turnipValue.setText(turnipValue.getText().toString().replace("`","\'"));
                    turnipValue.setText(turnipValue.getText().toString().replace("\n"," "));
                    if (turnipValue.getText().toString().equals("")) {
                        mainTv.setText("");
                    } else {
                        tmp = Integer.parseInt(turnipValue.getText().toString());
                        mainTv.setText(Integer.toString(tmp));
                    }
                    dlg.dismiss();
                }
            }
        });

        btnTurnipCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dlg.dismiss();
            }
        });
    }
}
