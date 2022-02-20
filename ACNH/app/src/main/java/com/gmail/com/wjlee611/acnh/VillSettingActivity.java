package com.gmail.com.wjlee611.acnh;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Locale;

public class VillSettingActivity extends Activity{

    RecyclerView mRecyclerView1 = null;
    VillRecyclerImageTextAdapter mAdapter1 = null;
    ArrayList<RecyclerVillItem> mList1 = new ArrayList<RecyclerVillItem>();

    RecyclerView mRecyclerView2 = null;
    VillRecyclerImageTextAdapter mAdapter2 = null;
    ArrayList<RecyclerVillItem> mList2 = new ArrayList<RecyclerVillItem>();

    TextView _numTotResi;
    ScrollView set_scroll;

    EditText etMIN, etMIA, etMIF, etMIR;
    TextView numCelResi, numTotResi;
    Switch swHemisphere;

    RadioGroup rdoGroup1, rdoGroup2;
    NestedScrollView rvNestedScrollView;

    /*라디오 버튼 리스너*/
    RadioGroup.OnCheckedChangeListener listener1 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            rdoGroup2.setOnCheckedChangeListener(null);
            rdoGroup2.clearCheck();
            rdoGroup2.setOnCheckedChangeListener(listener2);
            mList1.clear();
            //mAdapter1.notifyDataSetChanged();

            switch (i) {
                case R.id.rdo_alligator:
                    loadAlligator(); break;
                case R.id.rdo_anteater:
                    loadAnteater(); break;
                case R.id.rdo_bear:
                    loadBear(); break;
                case R.id.rdo_bird:
                    loadBird(); break;
                case R.id.rdo_cat:
                    loadCat(); break;
                case R.id.rdo_chicken:
                    loadChicken(); break;
                case R.id.rdo_cow:
                    loadCow(); break;
                case R.id.rdo_cub:
                    loadCub(); break;
                case R.id.rdo_deer:
                    loadDeer(); break;
                case R.id.rdo_dog:
                    loadDog(); break;
                case R.id.rdo_duck:
                    loadDuck(); break;
                case R.id.rdo_eagle:
                    loadEagle(); break;
                case R.id.rdo_elephant:
                    loadElephant(); break;
                case R.id.rdo_frog:
                    loadFrog(); break;
                case R.id.rdo_goat:
                    loadGoat(); break;
                case R.id.rdo_gorilla:
                    loadGorilla(); break;
                case R.id.rdo_hamster:
                    loadHamster(); break;
                default:
                    break;
            }

            if (Locale.getDefault().getLanguage().equals("ko")) {
                //한국어
                mAdapter1.notifyDataSetChanged();
                _numTotResi.setText(mAdapter1.getItemCount() + " / 395명 검색됨");
            } else {
                //default 영어
                mAdapter1.notifyDataSetChanged();
                _numTotResi.setText(mAdapter1.getItemCount() + " / 395 Searched");
            }

            rvNestedScrollView.scrollTo(0,0);
        }
    };

    RadioGroup.OnCheckedChangeListener listener2 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            rdoGroup1.setOnCheckedChangeListener(null);
            rdoGroup1.clearCheck();
            rdoGroup1.setOnCheckedChangeListener(listener1);
            mList1.clear();
            //mAdapter1.notifyDataSetChanged();

            switch (i) {
                case R.id.rdo_hippo:
                    loadHippo(); break;
                case R.id.rdo_horse:
                    loadHorse(); break;
                case R.id.rdo_kangaroo:
                    loadKangaroo(); break;
                case R.id.rdo_Koala:
                    loadKoala(); break;
                case R.id.rdo_lion:
                    loadLion(); break;
                case R.id.rdo_monkey:
                    loadMonkey(); break;
                case R.id.rdo_mouse:
                    loadMouse(); break;
                case R.id.rdo_octopus:
                    loadOctopus(); break;
                case R.id.rdo_ostrich:
                    loadOstrich(); break;
                case R.id.rdo_penguin:
                    loadPenguin(); break;
                case R.id.rdo_pig:
                    loadPig(); break;
                case R.id.rdo_rabbit:
                    loadRabbit(); break;
                case R.id.rdo_rhino:
                    loadRhino(); break;
                case R.id.rdo_sheep:
                    loadSheep(); break;
                case R.id.rdo_squirrel:
                    loadSquirrel(); break;
                case R.id.rdo_tiger:
                    loadTiger(); break;
                case R.id.rdo_wolf:
                    loadWolf(); break;
                default:
                    break;
            }

            if (Locale.getDefault().getLanguage().equals("ko")) {
                //한국어
                mAdapter1.notifyDataSetChanged();
                _numTotResi.setText(mAdapter1.getItemCount() + " / 395명 검색됨");
            } else {
                //default 영어
                mAdapter1.notifyDataSetChanged();
                _numTotResi.setText(mAdapter1.getItemCount() + " / 395 Searched");
            }

            rvNestedScrollView.scrollTo(0,0);
        }
    };


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vill_setting);

        etMIN = (EditText) findViewById(R.id.etMIN);
        etMIA = (EditText) findViewById(R.id.etMIA);
        etMIF = (EditText) findViewById(R.id.etMIF);
        etMIR = (EditText) findViewById(R.id.etMIR);
        swHemisphere = (Switch) findViewById(R.id.swHemisphere);
        numCelResi = (TextView) findViewById(R.id.numCelResident);
        numTotResi = (TextView) findViewById(R.id.numTotResident);
        set_scroll = (ScrollView) findViewById(R.id.setting_scroll);

        Button dlgBtnOK = (Button) findViewById(R.id.btnDlgOK);
        Button dlgBtnCancel = (Button) findViewById(R.id.btnDlgCancel);

        rdoGroup1 = (RadioGroup) findViewById(R.id.rdo_group1);
        rdoGroup2 = (RadioGroup) findViewById(R.id.rdo_group2);
        rvNestedScrollView = (NestedScrollView) findViewById(R.id.rvNestedScrollView);


        /*주민 데이터 리사이클러 뷰: 1, 선택 주민 리사이클러 뷰: 2 세팅*/
        mRecyclerView1 = findViewById(R.id.rvResiData);
        mRecyclerView2 = findViewById(R.id.rvChouResi);

        mAdapter1 = new VillRecyclerImageTextAdapter(mList1);
        mRecyclerView1.setAdapter(mAdapter1);
        mAdapter2 = new VillRecyclerImageTextAdapter(mList2);
        mRecyclerView2.setAdapter(mAdapter2);

        mRecyclerView1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        mRecyclerView1.setNestedScrollingEnabled(true);
        mRecyclerView2.setNestedScrollingEnabled(true);

        /*데이터 받기*/
        Intent intent = getIntent();
        etMIN.setText(intent.getStringExtra("iName"));
        etMIA.setText(intent.getStringExtra("iAddress"));
        etMIF.setText(intent.getStringExtra("iFruit"));
        etMIR.setText(intent.getStringExtra("iResident"));
        if (intent.getIntExtra("hemisphere", 0) == 1) {
            swHemisphere.setChecked(true);
        } else {
            swHemisphere.setChecked(false);
        }

        int numResident = intent.getIntExtra("numResident", 0);
        int[] ResidentList = intent.getIntArrayExtra("ResidentList");

        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            for (int i=0; i<numResident; i++) {
                switch (ResidentList[i]) {
                    case 1:
                        addItem2(getDrawable(R.drawable.agent_s), "1", "2호");
                        break;
                    case 2:
                        addItem2(getDrawable(R.drawable.agnes), "2", "아그네스");
                        break;
                    case 3:
                        addItem2(getDrawable(R.drawable.alfonso), "3", "알베르트");
                        break;
                    case 4:
                        addItem2(getDrawable(R.drawable.alli), "4", "크로코");
                        break;
                    case 5:
                        addItem2(getDrawable(R.drawable.amelia), "5", "안데스");
                        break;
                    case 6:
                        addItem2(getDrawable(R.drawable.angus), "6", "반데스");
                        break;
                    case 7:
                        addItem2(getDrawable(R.drawable.antonio), "7", "퍼머거");
                        break;
                    case 8:
                        addItem2(getDrawable(R.drawable.apollo), "8", "아폴로");
                        break;
                    case 9:
                        addItem2(getDrawable(R.drawable.apple), "9", "애플");
                        break;
                    case 10:
                        addItem2(getDrawable(R.drawable.aurora), "10", "오로라");
                        break;
                    case 11:
                        addItem2(getDrawable(R.drawable.avery), "11", "쿠스케처");
                        break;
                    case 12:
                        addItem2(getDrawable(R.drawable.baabara), "12", "트로와");
                        break;
                    case 13:
                        addItem2(getDrawable(R.drawable.bangle), "13", "루주");
                        break;
                    case 14:
                        addItem2(getDrawable(R.drawable.beau), "14", "피터");
                        break;
                    case 15:
                        addItem2(getDrawable(R.drawable.bella), "15", "이자벨");
                        break;
                    case 16:
                        addItem2(getDrawable(R.drawable.bertha), "16", "베티");
                        break;
                    case 17:
                        addItem2(getDrawable(R.drawable.bettina), "17", "마르카");
                        break;
                    case 18:
                        addItem2(getDrawable(R.drawable.bianca), "18", "백희");
                        break;
                    case 19:
                        addItem2(getDrawable(R.drawable.bill), "19", "코코아");
                        break;
                    case 20:
                        addItem2(getDrawable(R.drawable.blaire), "20", "실루엣");
                        break;
                    case 21:
                        addItem2(getDrawable(R.drawable.blanche), "21", "신옥");
                        break;
                    case 22:
                        addItem2(getDrawable(R.drawable.bob), "22", "히죽");
                        break;
                    case 23:
                        addItem2(getDrawable(R.drawable.bonbon), "23", "미미");
                        break;
                    case 24:
                        addItem2(getDrawable(R.drawable.bree), "24", "사라");
                        break;
                    case 25:
                        addItem2(getDrawable(R.drawable.buck), "25", "바야시코프");
                        break;
                    case 26:
                        addItem2(getDrawable(R.drawable.bud), "26", "선글");
                        break;
                    case 27:
                        addItem2(getDrawable(R.drawable.bunnie), "27", "릴리안");
                        break;
                    case 28:
                        addItem2(getDrawable(R.drawable.butch), "28", "존");
                        break;
                    case 29:
                        addItem2(getDrawable(R.drawable.buzz), "29", "근엄");
                        break;
                    case 30:
                        addItem2(getDrawable(R.drawable.cally), "30", "파슬리");
                        break;
                    case 31:
                        addItem2(getDrawable(R.drawable.canberra), "31", "캔버라");
                        break;
                    case 32:
                        addItem2(getDrawable(R.drawable.carmen), "32", "초코");
                        break;
                    case 33:
                        addItem2(getDrawable(R.drawable.caroline), "33", "캐롤라인");
                        break;
                    case 34:
                        addItem2(getDrawable(R.drawable.carrie), "34", "마미");
                        break;
                    case 35:
                        addItem2(getDrawable(R.drawable.cashmere), "35", "캐시미어");
                        break;
                    case 36:
                        addItem2(getDrawable(R.drawable.celia), "36", "티파니");
                        break;
                    case 37:
                        addItem2(getDrawable(R.drawable.cesar), "37", "앨런");
                        break;
                    case 38:
                        addItem2(getDrawable(R.drawable.chadder), "38", "치즈");
                        break;
                    case 39:
                        addItem2(getDrawable(R.drawable.charlise), "39", "챠미");
                        break;
                    case 40:
                        addItem2(getDrawable(R.drawable.cherry), "40", "한나");
                        break;
                    case 41:
                        addItem2(getDrawable(R.drawable.chevre), "41", "윤이");
                        break;
                    case 42:
                        addItem2(getDrawable(R.drawable.chief), "42", "대장");
                        break;
                    case 43:
                        addItem2(getDrawable(R.drawable.chops), "43", "돈후앙");
                        break;
                    case 44:
                        addItem2(getDrawable(R.drawable.chrissy), "44", "크리스틴");
                        break;
                    case 45:
                        addItem2(getDrawable(R.drawable.claude), "45", "비니거");
                        break;
                    case 46:
                        addItem2(getDrawable(R.drawable.claudia), "46", "신디");
                        break;
                    case 47:
                        addItem2(getDrawable(R.drawable.coco), "47", "이요");
                        break;
                    case 48:
                        addItem2(getDrawable(R.drawable.cole), "48", "아마민");
                        break;
                    case 49:
                        addItem2(getDrawable(R.drawable.colton), "49", "안소니");
                        break;
                    case 50:
                        addItem2(getDrawable(R.drawable.cranston), "50", "타키");
                        break;
                    case 51:
                        addItem2(getDrawable(R.drawable.cube), "51", "빙수");
                        break;
                    case 52:
                        addItem2(getDrawable(R.drawable.curlos), "52", "카를로스");
                        break;
                    case 53:
                        addItem2(getDrawable(R.drawable.curt), "53", "뚝심");
                        break;
                    case 54:
                        addItem2(getDrawable(R.drawable.deirdre), "54", "나디아");
                        break;
                    case 55:
                        addItem2(getDrawable(R.drawable.diana), "55", "나탈리");
                        break;
                    case 56:
                        addItem2(getDrawable(R.drawable.dizzy), "56", "휴지");
                        break;
                    case 57:
                        addItem2(getDrawable(R.drawable.dobie), "57", "켄");
                        break;
                    case 58:
                        addItem2(getDrawable(R.drawable.doc), "58", "토니");
                        break;
                    case 59:
                        addItem2(getDrawable(R.drawable.dotty), "59", "서머");
                        break;
                    case 60:
                        addItem2(getDrawable(R.drawable.drift), "60", "덕");
                        break;
                    case 61:
                        addItem2(getDrawable(R.drawable.egbert), "61", "김희");
                        break;
                    case 62:
                        addItem2(getDrawable(R.drawable.eloise), "62", "엘레핀");
                        break;
                    case 63:
                        addItem2(getDrawable(R.drawable.erik), "63", "자끄");
                        break;
                    case 64:
                        addItem2(getDrawable(R.drawable.eunice), "64", "곱슬이");
                        break;
                    case 65:
                        addItem2(getDrawable(R.drawable.fang), "65", "시베리아");
                        break;
                    case 66:
                        addItem2(getDrawable(R.drawable.fauna), "66", "솔미");
                        break;
                    case 67:
                        addItem2(getDrawable(R.drawable.filbert), "67", "리키");
                        break;
                    case 68:
                        addItem2(getDrawable(R.drawable.flip), "68", "원승");
                        break;
                    case 69:
                        addItem2(getDrawable(R.drawable.flora), "69", "플라라");
                        break;
                    case 70:
                        addItem2(getDrawable(R.drawable.flurry), "70", "뽀야미");
                        break;
                    case 71:
                        addItem2(getDrawable(R.drawable.francine), "71", "프랑소와");
                        break;
                    case 72:
                        addItem2(getDrawable(R.drawable.frank), "72", "헐크");
                        break;
                    case 73:
                        addItem2(getDrawable(R.drawable.freya), "73", "신드라");
                        break;
                    case 74:
                        addItem2(getDrawable(R.drawable.friga), "74", "사브리나");
                        break;
                    case 75:
                        addItem2(getDrawable(R.drawable.frita), "75", "웬디");
                        break;
                    case 76:
                        addItem2(getDrawable(R.drawable.fuchsia), "76", "제시카");
                        break;
                    case 77:
                        addItem2(getDrawable(R.drawable.gabi), "77", "패티카");
                        break;
                    case 78:
                        addItem2(getDrawable(R.drawable.gaston), "78", "대길");
                        break;
                    case 79:
                        addItem2(getDrawable(R.drawable.genji), "79", "토시");
                        break;
                    case 80:
                        addItem2(getDrawable(R.drawable.gladys), "80", "빅토리아");
                        break;
                    case 81:
                        addItem2(getDrawable(R.drawable.goldie), "81", "카라멜");
                        break;
                    case 82:
                        addItem2(getDrawable(R.drawable.goose), "82", "건태");
                        break;
                    case 83:
                        addItem2(getDrawable(R.drawable.greta), "83", "복자");
                        break;
                    case 84:
                        addItem2(getDrawable(R.drawable.hamlet), "84", "햄스틴");
                        break;
                    case 85:
                        addItem2(getDrawable(R.drawable.hans), "85", "스나일");
                        break;
                    case 86:
                        addItem2(getDrawable(R.drawable.hazel), "86", "아이리스");
                        break;
                    case 87:
                        addItem2(getDrawable(R.drawable.hopkins), "87", "홉킨스");
                        break;
                    case 88:
                        addItem2(getDrawable(R.drawable.hopper), "88", "달만이");
                        break;
                    case 89:
                        addItem2(getDrawable(R.drawable.hornsby), "89", "뿌람");
                        break;
                    case 90:
                        addItem2(getDrawable(R.drawable.iggly), "90", "김말이");
                        break;
                    case 91:
                        addItem2(getDrawable(R.drawable.jay), "91", "참돌이");
                        break;
                    case 92:
                        addItem2(getDrawable(R.drawable.jitters), "92", "딩요");
                        break;
                    case 93:
                        addItem2(getDrawable(R.drawable.julia), "93", "줄리아");
                        break;
                    case 94:
                        addItem2(getDrawable(R.drawable.julian), "94", "유니오");
                        break;
                    case 95:
                        addItem2(getDrawable(R.drawable.katt), "95", "쵸이");
                        break;
                    case 96:
                        addItem2(getDrawable(R.drawable.keaton), "96", "프랭크");
                        break;
                    case 97:
                        addItem2(getDrawable(R.drawable.kevin), "97", "멧지");
                        break;
                    case 98:
                        addItem2(getDrawable(R.drawable.kid_cat), "98", "1호");
                        break;
                    case 99:
                        addItem2(getDrawable(R.drawable.kiki), "99", "캐비어");
                        break;
                    case 100:
                        addItem2(getDrawable(R.drawable.kitt), "100", "애플리케");
                        break;
                    case 101:
                        addItem2(getDrawable(R.drawable.klaus), "101", "곰도로스");
                        break;
                    case 102:
                        addItem2(getDrawable(R.drawable.kyle), "102", "리카르도");
                        break;
                    case 103:
                        addItem2(getDrawable(R.drawable.leonardo), "103", "범호");
                        break;
                    case 104:
                        addItem2(getDrawable(R.drawable.lily), "104", "레이니");
                        break;
                    case 105:
                        addItem2(getDrawable(R.drawable.lobo), "105", "늑태");
                        break;
                    case 106:
                        addItem2(getDrawable(R.drawable.lolly), "106", "사이다");
                        break;
                    case 107:
                        addItem2(getDrawable(R.drawable.lopez), "107", "톰슨");
                        break;
                    case 108:
                        addItem2(getDrawable(R.drawable.mallary), "108", "스미모");
                        break;
                    case 109:
                        addItem2(getDrawable(R.drawable.margie), "109", "샐리");
                        break;
                    case 110:
                        addItem2(getDrawable(R.drawable.marina), "110", "문리나");
                        break;
                    case 111:
                        addItem2(getDrawable(R.drawable.marshal), "111", "쭈니");
                        break;
                    case 112:
                        addItem2(getDrawable(R.drawable.melba), "112", "아델레이드");
                        break;
                    case 113:
                        addItem2(getDrawable(R.drawable.merengue), "113", "스트로베리");
                        break;
                    case 114:
                        addItem2(getDrawable(R.drawable.merry), "114", "유네찌");
                        break;
                    case 115:
                        addItem2(getDrawable(R.drawable.mint), "115", "민트");
                        break;
                    case 116:
                        addItem2(getDrawable(R.drawable.mira), "116", "미랑");
                        break;
                    case 117:
                        addItem2(getDrawable(R.drawable.molly), "117", "귀오미");
                        break;
                    case 118:
                        addItem2(getDrawable(R.drawable.muffy), "118", "프릴");
                        break;
                    case 119:
                        addItem2(getDrawable(R.drawable.nibbles), "119", "그리미");
                        break;
                    case 120:
                        addItem2(getDrawable(R.drawable.octavian), "120", "문복");
                        break;
                    case 121:
                        addItem2(getDrawable(R.drawable.o_hare), "121", "산토스");
                        break;
                    case 122:
                        addItem2(getDrawable(R.drawable.olivia), "122", "올리비아");
                        break;
                    case 123:
                        addItem2(getDrawable(R.drawable.ozzie), "123", "동동이");
                        break;
                    case 124:
                        addItem2(getDrawable(R.drawable.pancetti), "124", "브리트니");
                        break;
                    case 125:
                        addItem2(getDrawable(R.drawable.patty), "125", "밀크");
                        break;
                    case 126:
                        addItem2(getDrawable(R.drawable.peaches), "126", "말자");
                        break;
                    case 127:
                        addItem2(getDrawable(R.drawable.peanut), "127", "핑키");
                        break;
                    case 128:
                        addItem2(getDrawable(R.drawable.pecan), "128", "레베카");
                        break;
                    case 129:
                        addItem2(getDrawable(R.drawable.peewee), "129", "덤벨");
                        break;
                    case 130:
                        addItem2(getDrawable(R.drawable.pekoe), "130", "재스민");
                        break;
                    case 131:
                        addItem2(getDrawable(R.drawable.penelope), "131", "찍순이");
                        break;
                    case 132:
                        addItem2(getDrawable(R.drawable.phil), "132", "케인");
                        break;
                    case 133:
                        addItem2(getDrawable(R.drawable.phoebe), "133", "휘니");
                        break;
                    case 134:
                        addItem2(getDrawable(R.drawable.pierce), "134", "세바스찬");
                        break;
                    case 135:
                        addItem2(getDrawable(R.drawable.pietro), "135", "피엘");
                        break;
                    case 136:
                        addItem2(getDrawable(R.drawable.pinky), "136", "링링");
                        break;
                    case 137:
                        addItem2(getDrawable(R.drawable.piper), "137", "파이프");
                        break;
                    case 138:
                        addItem2(getDrawable(R.drawable.pippy), "138", "로타");
                        break;
                    case 139:
                        addItem2(getDrawable(R.drawable.poncho), "139", "봉추");
                        break;
                    case 140:
                        addItem2(getDrawable(R.drawable.poppy), "140", "다람");
                        break;
                    case 141:
                        addItem2(getDrawable(R.drawable.punchy), "141", "빙티");
                        break;
                    case 142:
                        addItem2(getDrawable(R.drawable.purrl), "142", "타마");
                        break;
                    case 143:
                        addItem2(getDrawable(R.drawable.queenie), "143", "택주");
                        break;
                    case 144:
                        addItem2(getDrawable(R.drawable.renee), "144", "뿔님이");
                        break;
                    case 145:
                        addItem2(getDrawable(R.drawable.rhonda), "145", "론다");
                        break;
                    case 146:
                        addItem2(getDrawable(R.drawable.ricky), "146", "갈가리");
                        break;
                    case 147:
                        addItem2(getDrawable(R.drawable.roald), "147", "펭수");
                        break;
                    case 148:
                        addItem2(getDrawable(R.drawable.rocco), "148", "곤잘레스");
                        break;
                    case 149:
                        addItem2(getDrawable(R.drawable.rod), "149", "쟝");
                        break;
                    case 150:
                        addItem2(getDrawable(R.drawable.rodney), "150", "지미");
                        break;
                    case 151:
                        addItem2(getDrawable(R.drawable.rolf), "151", "호랭이");
                        break;
                    case 152:
                        addItem2(getDrawable(R.drawable.roscoe), "152", "슈베르트");
                        break;
                    case 153:
                        addItem2(getDrawable(R.drawable.rosie), "153", "부케");
                        break;
                    case 154:
                        addItem2(getDrawable(R.drawable.rowan), "154", "고메스");
                        break;
                    case 155:
                        addItem2(getDrawable(R.drawable.ruby), "155", "루나");
                        break;
                    case 156:
                        addItem2(getDrawable(R.drawable.sally), "156", "라라미");
                        break;
                    case 157:
                        addItem2(getDrawable(R.drawable.sandy), "157", "샌디");
                        break;
                    case 158:
                        addItem2(getDrawable(R.drawable.shari), "158", "젤리");
                        break;
                    case 159:
                        addItem2(getDrawable(R.drawable.sheldon), "159", "크리스");
                        break;
                    case 160:
                        addItem2(getDrawable(R.drawable.skye), "160", "릴리");
                        break;
                    case 161:
                        addItem2(getDrawable(R.drawable.sly), "161", "하이드");
                        break;
                    case 162:
                        addItem2(getDrawable(R.drawable.snake), "162", "닌토");
                        break;
                    case 163:
                        addItem2(getDrawable(R.drawable.spike), "163", "스쿼트");
                        break;
                    case 164:
                        addItem2(getDrawable(R.drawable.sprocket), "164", "헤르츠");
                        break;
                    case 165:
                        addItem2(getDrawable(R.drawable.static_), "165", "스파크");
                        break;
                    case 166:
                        addItem2(getDrawable(R.drawable.stella), "166", "아크릴");
                        break;
                    case 167:
                        addItem2(getDrawable(R.drawable.sterling), "167", "은수리");
                        break;
                    case 168:
                        addItem2(getDrawable(R.drawable.stitches), "168", "패치");
                        break;
                    case 169:
                        addItem2(getDrawable(R.drawable.sylvana), "169", "실바나");
                        break;
                    case 170:
                        addItem2(getDrawable(R.drawable.tammy), "170", "아네사");
                        break;
                    case 171:
                        addItem2(getDrawable(R.drawable.tank), "171", "탱크");
                        break;
                    case 172:
                        addItem2(getDrawable(R.drawable.t_bone), "172", "티본");
                        break;
                    case 173:
                        addItem2(getDrawable(R.drawable.tasha), "173", "나타샤");
                        break;
                    case 174:
                        addItem2(getDrawable(R.drawable.teddy), "174", "병태");
                        break;
                    case 175:
                        addItem2(getDrawable(R.drawable.tiffany), "175", "바슬레");
                        break;
                    case 176:
                        addItem2(getDrawable(R.drawable.timbra), "176", "잔디");
                        break;
                    case 177:
                        addItem2(getDrawable(R.drawable.truffles), "177", "탱고");
                        break;
                    case 178:
                        addItem2(getDrawable(R.drawable.tutu), "178", "연유");
                        break;
                    case 179:
                        addItem2(getDrawable(R.drawable.tybalt), "179", "티볼트");
                        break;
                    case 180:
                        addItem2(getDrawable(R.drawable.vesta), "180", "메리어스");
                        break;
                    case 181:
                        addItem2(getDrawable(R.drawable.victoria), "181", "센트엘로");
                        break;
                    case 182:
                        addItem2(getDrawable(R.drawable.violet), "182", "줌마");
                        break;
                    case 183:
                        addItem2(getDrawable(R.drawable.vivian), "183", "바네사");
                        break;
                    case 184:
                        addItem2(getDrawable(R.drawable.vladimir), "184", "곰비");
                        break;
                    case 185:
                        addItem2(getDrawable(R.drawable.wendy), "185", "눈송이");
                        break;
                    case 186:
                        addItem2(getDrawable(R.drawable.whitney), "186", "비앙카");
                        break;
                    case 187:
                        addItem2(getDrawable(R.drawable.willow), "187", "마리");
                        break;
                    case 188:
                        addItem2(getDrawable(R.drawable.wolfgang), "188", "로보");
                        break;
                    case 189:
                        addItem2(getDrawable(R.drawable.zucher), "189", "탁호");
                        break;

                    case 190:
                        addItem2(getDrawable(R.drawable.admiral), "190", "일섭");
                        break;
                    case 191:
                        addItem2(getDrawable(R.drawable.al), "191", "우락");
                        break;
                    case 192:
                        addItem2(getDrawable(R.drawable.alice), "192", "멜버른");
                        break;
                    case 193:
                        addItem2(getDrawable(R.drawable.anabelle), "193", "아롱이");
                        break;
                    case 194:
                        addItem2(getDrawable(R.drawable.anchovy), "194", "안쵸비");
                        break;
                    case 195:
                        addItem2(getDrawable(R.drawable.anicotti), "195", "리자냐");
                        break;
                    case 196:
                        addItem2(getDrawable(R.drawable.ankha), "196", "클레오");
                        break;
                    case 197:
                        addItem2(getDrawable(R.drawable.annalisa), "197", "설백");
                        break;
                    case 198:
                        addItem2(getDrawable(R.drawable.annalise), "198", "실부플레");
                        break;
                    case 199:
                        addItem2(getDrawable(R.drawable.astrid), "199", "펑키맘");
                        break;
                    case 200:
                        addItem2(getDrawable(R.drawable.audie), "200", "모니카");
                        break;
                    case 201:
                        addItem2(getDrawable(R.drawable.ava), "201", "에바");
                        break;
                    case 202:
                        addItem2(getDrawable(R.drawable.axel), "202", "엑스엘리");
                        break;
                    case 203:
                        addItem2(getDrawable(R.drawable.bam), "203", "록키");
                        break;
                    case 204:
                        addItem2(getDrawable(R.drawable.barold), "204", "곰시");
                        break;
                    case 205:
                        addItem2(getDrawable(R.drawable.bea), "205", "베이글");
                        break;
                    case 206:
                        addItem2(getDrawable(R.drawable.beardo), "206", "베어드");
                        break;
                    case 207:
                        addItem2(getDrawable(R.drawable.becky), "207", "아리아");
                        break;
                    case 208:
                        addItem2(getDrawable(R.drawable.benedict), "208", "페니실린");
                        break;
                    case 209:
                        addItem2(getDrawable(R.drawable.benjamin), "209", "땡칠이");
                        break;
                    case 210:
                        addItem2(getDrawable(R.drawable.biff), "210", "가브리엘");
                        break;
                    case 211:
                        addItem2(getDrawable(R.drawable.big_top), "211", "3호");
                        break;
                    case 212:
                        addItem2(getDrawable(R.drawable.billy), "212", "힘드러");
                        break;
                    case 213:
                        addItem2(getDrawable(R.drawable.biskit), "213", "로빈");
                        break;
                    case 214:
                        addItem2(getDrawable(R.drawable.bitty), "214", "비티");
                        break;
                    case 215:
                        addItem2(getDrawable(R.drawable.bluebear), "215", "글루민");
                        break;
                    case 216:
                        addItem2(getDrawable(R.drawable.bones), "216", "토미");
                        break;
                    case 217:
                        addItem2(getDrawable(R.drawable.boomer), "217", "팽기");
                        break;
                    case 218:
                        addItem2(getDrawable(R.drawable.boone), "218", "만복이");
                        break;
                    case 219:
                        addItem2(getDrawable(R.drawable.boots), "219", "풍작");
                        break;
                    case 220:
                        addItem2(getDrawable(R.drawable.boris), "220", "보리");
                        break;
                    case 221:
                        addItem2(getDrawable(R.drawable.boyd), "221", "보이드");
                        break;
                    case 222:
                        addItem2(getDrawable(R.drawable.broccolo), "222", "브로콜리");
                        break;
                    case 223:
                        addItem2(getDrawable(R.drawable.broffina), "223", "히킨");
                        break;
                    case 224:
                        addItem2(getDrawable(R.drawable.bruce), "224", "브루스");
                        break;
                    case 225:
                        addItem2(getDrawable(R.drawable.bubbles), "225", "차코");
                        break;
                    case 226:
                        addItem2(getDrawable(R.drawable.camofrog), "226", "충성");
                        break;
                    case 227:
                        addItem2(getDrawable(R.drawable.candi), "227", "사탕");
                        break;
                    case 228:
                        addItem2(getDrawable(R.drawable.chai), "228", "피카");
                        break;
                    case 229:
                        addItem2(getDrawable(R.drawable.chelsea), "229", "첼시");
                        break;
                    case 230:
                        addItem2(getDrawable(R.drawable.cheri), "230", "아세로라");
                        break;
                    case 231:
                        addItem2(getDrawable(R.drawable.chester), "231", "팬타");
                        break;
                    case 232:
                        addItem2(getDrawable(R.drawable.chow), "232", "츄앙");
                        break;
                    case 233:
                        addItem2(getDrawable(R.drawable.clay), "233", "햄둥");
                        break;
                    case 234:
                        addItem2(getDrawable(R.drawable.cleo), "234", "아이소토프");
                        break;
                    case 235:
                        addItem2(getDrawable(R.drawable.clyde), "235", "마철이");
                        break;
                    case 236:
                        addItem2(getDrawable(R.drawable.coach), "236", "철소");
                        break;
                    case 237:
                        addItem2(getDrawable(R.drawable.cobb), "237", "박사");
                        break;
                    case 238:
                        addItem2(getDrawable(R.drawable.cookie), "238", "베리");
                        break;
                    case 239:
                        addItem2(getDrawable(R.drawable.cousteau), "239", "왕서방");
                        break;
                    case 240:
                        addItem2(getDrawable(R.drawable.croque), "240", "투투");
                        break;
                    case 241:
                        addItem2(getDrawable(R.drawable.curly), "241", "햄까스");
                        break;
                    case 242:
                        addItem2(getDrawable(R.drawable.cyd), "242", "펑크스");
                        break;
                    case 243:
                        addItem2(getDrawable(R.drawable.cyrano), "243", "사지마");
                        break;
                    case 244:
                        addItem2(getDrawable(R.drawable.daisy), "244", "바닐라");
                        break;
                    case 245:
                        addItem2(getDrawable(R.drawable.deena), "245", "마리모");
                        break;
                    case 246:
                        addItem2(getDrawable(R.drawable.del), "246", "파도맨");
                        break;
                    case 247:
                        addItem2(getDrawable(R.drawable.deli), "247", "델리");
                        break;
                    case 248:
                        addItem2(getDrawable(R.drawable.derwin), "248", "봉");
                        break;
                    case 249:
                        addItem2(getDrawable(R.drawable.diva), "249", "아이다");
                        break;
                    case 250:
                        addItem2(getDrawable(R.drawable.dom), "250", "차둘");
                        break;
                    case 251:
                        addItem2(getDrawable(R.drawable.dora), "251", "티미");
                        break;
                    case 252:
                        addItem2(getDrawable(R.drawable.drago), "252", "용남이");
                        break;
                    case 253:
                        addItem2(getDrawable(R.drawable.drake), "253", "푸아그라");
                        break;
                    case 254:
                        addItem2(getDrawable(R.drawable.ed), "254", "꺼벙");
                        break;
                    case 255:
                        addItem2(getDrawable(R.drawable.elise), "255", "몽자");
                        break;
                    case 256:
                        addItem2(getDrawable(R.drawable.ellie), "256", "에끌레르");
                        break;
                    case 257:
                        addItem2(getDrawable(R.drawable.elmer), "257", "샤브렌");
                        break;
                    case 258:
                        addItem2(getDrawable(R.drawable.elvis), "258", "킹");
                        break;
                    case 259:
                        addItem2(getDrawable(R.drawable.etoile), "259", "에뜨와르");
                        break;
                    case 260:
                        addItem2(getDrawable(R.drawable.eugene), "260", "코알");
                        break;
                    case 261:
                        addItem2(getDrawable(R.drawable.felicity), "261", "예링");
                        break;
                    case 262:
                        addItem2(getDrawable(R.drawable.flo), "262", "레이라");
                        break;
                    case 263:
                        addItem2(getDrawable(R.drawable.freckles), "263", "다랑어");
                        break;
                    case 264:
                        addItem2(getDrawable(R.drawable.frobert), "264", "구리구리");
                        break;
                    case 265:
                        addItem2(getDrawable(R.drawable.gala), "265", "꽃지");
                        break;
                    case 266:
                        addItem2(getDrawable(R.drawable.gayle), "266", "앨리");
                        break;
                    case 267:
                        addItem2(getDrawable(R.drawable.gigi), "267", "린다");
                        break;
                    case 268:
                        addItem2(getDrawable(R.drawable.gloria), "268", "마릴린");
                        break;
                    case 269:
                        addItem2(getDrawable(R.drawable.gonzo), "269", "근성");
                        break;
                    case 270:
                        addItem2(getDrawable(R.drawable.graham), "270", "글라햄");
                        break;
                    case 271:
                        addItem2(getDrawable(R.drawable.grizzly), "271", "무뚝");
                        break;
                    case 272:
                        addItem2(getDrawable(R.drawable.groucho), "272", "거무틱");
                        break;
                    case 273:
                        addItem2(getDrawable(R.drawable.gruff), "273", "빌리");
                        break;
                    case 274:
                        addItem2(getDrawable(R.drawable.gwen), "274", "폴라");
                        break;
                    case 275:
                        addItem2(getDrawable(R.drawable.hamphrey), "275", "햄쥐");
                        break;
                    case 276:
                        addItem2(getDrawable(R.drawable.harry), "276", "올리버");
                        break;
                    case 277:
                        addItem2(getDrawable(R.drawable.henry), "277", "헨리");
                        break;
                    case 278:
                        addItem2(getDrawable(R.drawable.hippeux), "278", "데이빗");
                        break;
                    case 279:
                        addItem2(getDrawable(R.drawable.huck), "279", "스트로");
                        break;
                    case 280:
                        addItem2(getDrawable(R.drawable.hugh), "280", "먹고파");
                        break;
                    case 281:
                        addItem2(getDrawable(R.drawable.ike), "281", "대공");
                        break;
                    case 282:
                        addItem2(getDrawable(R.drawable.jacob), "282", "야곱");
                        break;
                    case 283:
                        addItem2(getDrawable(R.drawable.jacques), "283", "쪼끼");
                        break;
                    case 284:
                        addItem2(getDrawable(R.drawable.jambette), "284", "에스메랄다");
                        break;
                    case 285:
                        addItem2(getDrawable(R.drawable.jeremiah), "285", "드리미");
                        break;
                    case 286:
                        addItem2(getDrawable(R.drawable.joey), "286", "리처드");
                        break;
                    case 287:
                        addItem2(getDrawable(R.drawable.judy), "287", "미애");
                        break;
                    case 288:
                        addItem2(getDrawable(R.drawable.june), "288", "메이");
                        break;
                    case 289:
                        addItem2(getDrawable(R.drawable.kabuki), "289", "가북희");
                        break;
                    case 290:
                        addItem2(getDrawable(R.drawable.ken), "290", "오골");
                        break;
                    case 291:
                        addItem2(getDrawable(R.drawable.ketchup), "291", "케첩");
                        break;
                    case 292:
                        addItem2(getDrawable(R.drawable.kidd), "292", "염두리");
                        break;
                    case 293:
                        addItem2(getDrawable(R.drawable.kitty), "293", "쇼콜라");
                        break;
                    case 294:
                        addItem2(getDrawable(R.drawable.knox), "294", "금끼오");
                        break;
                    case 295:
                        addItem2(getDrawable(R.drawable.kody), "295", "아이다호");
                        break;
                    case 296:
                        addItem2(getDrawable(R.drawable.limberg), "296", "단무지");
                        break;
                    case 297:
                        addItem2(getDrawable(R.drawable.lionel), "297", "라이오넬");
                        break;
                    case 298:
                        addItem2(getDrawable(R.drawable.louie), "298", "머슬");
                        break;
                    case 299:
                        addItem2(getDrawable(R.drawable.lucha), "299", "마스카라스");
                        break;
                    case 300:
                        addItem2(getDrawable(R.drawable.lucky), "300", "럭키");
                        break;
                    case 301:
                        addItem2(getDrawable(R.drawable.lucy), "301", "루시");
                        break;
                    case 302:
                        addItem2(getDrawable(R.drawable.lyman), "302", "오즈먼드");
                        break;
                    case 303:
                        addItem2(getDrawable(R.drawable.mac), "303", "챔프");
                        break;
                    case 304:
                        addItem2(getDrawable(R.drawable.maddie), "304", "마롱");
                        break;
                    case 305:
                        addItem2(getDrawable(R.drawable.maelle), "305", "앤");
                        break;
                    case 306:
                        addItem2(getDrawable(R.drawable.maggie), "306", "마가렛");
                        break;
                    case 307:
                        addItem2(getDrawable(R.drawable.maple), "307", "메이첼");
                        break;
                    case 308:
                        addItem2(getDrawable(R.drawable.marcel), "308", "에드워드");
                        break;
                    case 309:
                        addItem2(getDrawable(R.drawable.marcie), "309", "마리아");
                        break;
                    case 310:
                        addItem2(getDrawable(R.drawable.mathilda), "310", "안젤라");
                        break;
                    case 311:
                        addItem2(getDrawable(R.drawable.megan), "311", "캔디");
                        break;
                    case 312:
                        addItem2(getDrawable(R.drawable.midge), "312", "핑글이");
                        break;
                    case 313:
                        addItem2(getDrawable(R.drawable.miranda), "313", "미란다");
                        break;
                    case 314:
                        addItem2(getDrawable(R.drawable.mitzi), "314", "마르");
                        break;
                    case 315:
                        addItem2(getDrawable(R.drawable.moe), "315", "진상");
                        break;
                    case 316:
                        addItem2(getDrawable(R.drawable.monique), "316", "제인");
                        break;
                    case 317:
                        addItem2(getDrawable(R.drawable.monty), "317", "몽티");
                        break;
                    case 318:
                        addItem2(getDrawable(R.drawable.moose), "318", "핑");
                        break;
                    case 319:
                        addItem2(getDrawable(R.drawable.mott), "319", "릭");
                        break;
                    case 320:
                        addItem2(getDrawable(R.drawable.murphy), "320", "머피");
                        break;
                    case 321:
                        addItem2(getDrawable(R.drawable.nan), "321", "순이");
                        break;
                    case 322:
                        addItem2(getDrawable(R.drawable.nana), "322", "키키");
                        break;
                    case 323:
                        addItem2(getDrawable(R.drawable.naomi), "323", "화자");
                        break;
                    case 324:
                        addItem2(getDrawable(R.drawable.nate), "324", "박하스");
                        break;
                    case 325:
                        addItem2(getDrawable(R.drawable.norma), "325", "미자");
                        break;
                    case 326:
                        addItem2(getDrawable(R.drawable.olaf), "326", "안토니오");
                        break;
                    case 327:
                        addItem2(getDrawable(R.drawable.olive), "327", "올리브");
                        break;
                    case 328:
                        addItem2(getDrawable(R.drawable.opal), "328", "오팔");
                        break;
                    case 329:
                        addItem2(getDrawable(R.drawable.pango), "329", "패트라");
                        break;
                    case 330:
                        addItem2(getDrawable(R.drawable.paolo), "330", "파올로");
                        break;
                    case 331:
                        addItem2(getDrawable(R.drawable.papi), "331", "마사마");
                        break;
                    case 332:
                        addItem2(getDrawable(R.drawable.pashmina), "332", "바바라");
                        break;
                    case 333:
                        addItem2(getDrawable(R.drawable.pate), "333", "나키");
                        break;
                    case 334:
                        addItem2(getDrawable(R.drawable.paula), "334", "레이첼");
                        break;
                    case 335:
                        addItem2(getDrawable(R.drawable.peck), "335", "문대");
                        break;
                    case 336:
                        addItem2(getDrawable(R.drawable.peggy), "336", "체리");
                        break;
                    case 337:
                        addItem2(getDrawable(R.drawable.plucky), "337", "파타야");
                        break;
                    case 338:
                        addItem2(getDrawable(R.drawable.pompom), "338", "주디");
                        break;
                    case 339:
                        addItem2(getDrawable(R.drawable.portia), "339", "블랜더");
                        break;
                    case 340:
                        addItem2(getDrawable(R.drawable.prince), "340", "카일");
                        break;
                    case 341:
                        addItem2(getDrawable(R.drawable.puck), "341", "하키");
                        break;
                    case 342:
                        addItem2(getDrawable(R.drawable.puddles), "342", "가위");
                        break;
                    case 343:
                        addItem2(getDrawable(R.drawable.pudge), "343", "우띠");
                        break;
                    case 344:
                        addItem2(getDrawable(R.drawable.quillson), "344", "덕근");
                        break;
                    case 345:
                        addItem2(getDrawable(R.drawable.raddle), "345", "개군");
                        break;
                    case 346:
                        addItem2(getDrawable(R.drawable.rasher), "346", "글레이");
                        break;
                    case 347:
                        addItem2(getDrawable(R.drawable.raymond), "347", "잭슨");
                        break;
                    case 348:
                        addItem2(getDrawable(R.drawable.reneigh), "348", "리아나");
                        break;
                    case 349:
                        addItem2(getDrawable(R.drawable.rex), "349", "렉스");
                        break;
                    case 350:
                        addItem2(getDrawable(R.drawable.ribbot), "350", "철컥");
                        break;
                    case 351:
                        addItem2(getDrawable(R.drawable.rilla), "351", "릴라");
                        break;
                    case 352:
                        addItem2(getDrawable(R.drawable.rizzo), "352", "조르직");
                        break;
                    case 353:
                        addItem2(getDrawable(R.drawable.robin), "353", "파틱");
                        break;
                    case 354:
                        addItem2(getDrawable(R.drawable.rocket), "354", "4호");
                        break;
                    case 355:
                        addItem2(getDrawable(R.drawable.rodeo), "355", "로데오");
                        break;
                    case 356:
                        addItem2(getDrawable(R.drawable.rooney), "356", "마이크");
                        break;
                    case 357:
                        addItem2(getDrawable(R.drawable.rory), "357", "아더");
                        break;
                    case 358:
                        addItem2(getDrawable(R.drawable.rudy), "358", "찰스");
                        break;
                    case 359:
                        addItem2(getDrawable(R.drawable.samson), "359", "피스");
                        break;
                    case 360:
                        addItem2(getDrawable(R.drawable.savannah), "360", "사반나");
                        break;
                    case 361:
                        addItem2(getDrawable(R.drawable.scoot), "361", "지키미");
                        break;
                    case 362:
                        addItem2(getDrawable(R.drawable.shep), "362", "밥");
                        break;
                    case 363:
                        addItem2(getDrawable(R.drawable.sherb), "363", "래미");
                        break;
                    case 364:
                        addItem2(getDrawable(R.drawable.simon), "364", "시몬");
                        break;
                    case 365:
                        addItem2(getDrawable(R.drawable.snooty), "365", "스누티");
                        break;
                    case 366:
                        addItem2(getDrawable(R.drawable.soleil), "366", "샨티");
                        break;
                    case 367:
                        addItem2(getDrawable(R.drawable.sparro), "367", "춘섭");
                        break;
                    case 368:
                        addItem2(getDrawable(R.drawable.spork), "368", "포크");
                        break;
                    case 369:
                        addItem2(getDrawable(R.drawable.sprinkle), "369", "크리미");
                        break;
                    case 370:
                        addItem2(getDrawable(R.drawable.stinky), "370", "땀띠");
                        break;
                    case 371:
                        addItem2(getDrawable(R.drawable.stu), "371", "모리스");
                        break;
                    case 372:
                        addItem2(getDrawable(R.drawable.sydney), "372", "시드니");
                        break;
                    case 373:
                        addItem2(getDrawable(R.drawable.sylvia), "373", "실비아");
                        break;
                    case 374:
                        addItem2(getDrawable(R.drawable.tabby), "374", "호냥이");
                        break;
                    case 375:
                        addItem2(getDrawable(R.drawable.tad), "375", "텀보");
                        break;
                    case 376:
                        addItem2(getDrawable(R.drawable.tammi), "376", "에이프릴");
                        break;
                    case 377:
                        addItem2(getDrawable(R.drawable.tangy), "377", "백프로");
                        break;
                    case 378:
                        addItem2(getDrawable(R.drawable.tex), "378", "볼트");
                        break;
                    case 379:
                        addItem2(getDrawable(R.drawable.tia), "379", "티나");
                        break;
                    case 380:
                        addItem2(getDrawable(R.drawable.tipper), "380", "마틸다");
                        break;
                    case 381:
                        addItem2(getDrawable(R.drawable.toby), "381", "토비");
                        break;
                    case 382:
                        addItem2(getDrawable(R.drawable.tom), "382", "밴덤");
                        break;
                    case 383:
                        addItem2(getDrawable(R.drawable.tucker), "383", "맘모");
                        break;
                    case 384:
                        addItem2(getDrawable(R.drawable.twiggy), "384", "핀틱");
                        break;
                    case 385:
                        addItem2(getDrawable(R.drawable.ursala), "385", "네이아");
                        break;
                    case 386:
                        addItem2(getDrawable(R.drawable.velma), "386", "벨마");
                        break;
                    case 387:
                        addItem2(getDrawable(R.drawable.vic), "387", "노르망");
                        break;
                    case 388:
                        addItem2(getDrawable(R.drawable.wade), "388", "호떡");
                        break;
                    case 389:
                        addItem2(getDrawable(R.drawable.walker), "389", "벤");
                        break;
                    case 390:
                        addItem2(getDrawable(R.drawable.walt), "390", "관록");
                        break;
                    case 391:
                        addItem2(getDrawable(R.drawable.wart_jr), "391", "샘");
                        break;
                    case 392:
                        addItem2(getDrawable(R.drawable.weber), "392", "아잠만");
                        break;
                    case 393:
                        addItem2(getDrawable(R.drawable.winnie), "393", "카로틴");
                        break;
                    case 394:
                        addItem2(getDrawable(R.drawable.yuka), "394", "유카리");
                        break;
                    case 395:
                        addItem2(getDrawable(R.drawable.zell), "395", "넬슨");
                        break;
                    default:
                        break;
                }
            }
        } else {
            //default 영어
            for (int i=0; i<numResident; i++) {
                switch (ResidentList[i]) {
                    case 1:
                        addItem2(getDrawable(R.drawable.agent_s), "1", "Agent S");
                        break;
                    case 2:
                        addItem2(getDrawable(R.drawable.agnes), "2", "Agnes");
                        break;
                    case 3:
                        addItem2(getDrawable(R.drawable.alfonso), "3", "Alfonso");
                        break;
                    case 4:
                        addItem2(getDrawable(R.drawable.alli), "4", "Alli");
                        break;
                    case 5:
                        addItem2(getDrawable(R.drawable.amelia), "5", "Amelia");
                        break;
                    case 6:
                        addItem2(getDrawable(R.drawable.angus), "6", "Angus");
                        break;
                    case 7:
                        addItem2(getDrawable(R.drawable.antonio), "7", "Antonio");
                        break;
                    case 8:
                        addItem2(getDrawable(R.drawable.apollo), "8", "Apollo");
                        break;
                    case 9:
                        addItem2(getDrawable(R.drawable.apple), "9", "Apple");
                        break;
                    case 10:
                        addItem2(getDrawable(R.drawable.aurora), "10", "Aurora");
                        break;
                    case 11:
                        addItem2(getDrawable(R.drawable.avery), "11", "Avery");
                        break;
                    case 12:
                        addItem2(getDrawable(R.drawable.baabara), "12", "Baabara");
                        break;
                    case 13:
                        addItem2(getDrawable(R.drawable.bangle), "13", "Bangle");
                        break;
                    case 14:
                        addItem2(getDrawable(R.drawable.beau), "14", "Beau");
                        break;
                    case 15:
                        addItem2(getDrawable(R.drawable.bella), "15", "Bella");
                        break;
                    case 16:
                        addItem2(getDrawable(R.drawable.bertha), "16", "Bertha");
                        break;
                    case 17:
                        addItem2(getDrawable(R.drawable.bettina), "17", "Bettina");
                        break;
                    case 18:
                        addItem2(getDrawable(R.drawable.bianca), "18", "Bianca");
                        break;
                    case 19:
                        addItem2(getDrawable(R.drawable.bill), "19", "Bill");
                        break;
                    case 20:
                        addItem2(getDrawable(R.drawable.blaire), "20", "Blaire");
                        break;
                    case 21:
                        addItem2(getDrawable(R.drawable.blanche), "21", "Blanche");
                        break;
                    case 22:
                        addItem2(getDrawable(R.drawable.bob), "22", "Bob");
                        break;
                    case 23:
                        addItem2(getDrawable(R.drawable.bonbon), "23", "Bonbon");
                        break;
                    case 24:
                        addItem2(getDrawable(R.drawable.bree), "24", "Bree");
                        break;
                    case 25:
                        addItem2(getDrawable(R.drawable.buck), "25", "Buck");
                        break;
                    case 26:
                        addItem2(getDrawable(R.drawable.bud), "26", "Bud");
                        break;
                    case 27:
                        addItem2(getDrawable(R.drawable.bunnie), "27", "Bunnie");
                        break;
                    case 28:
                        addItem2(getDrawable(R.drawable.butch), "28", "Butch");
                        break;
                    case 29:
                        addItem2(getDrawable(R.drawable.buzz), "29", "Buzz");
                        break;
                    case 30:
                        addItem2(getDrawable(R.drawable.cally), "30", "Cally");
                        break;
                    case 31:
                        addItem2(getDrawable(R.drawable.canberra), "31", "Canberra");
                        break;
                    case 32:
                        addItem2(getDrawable(R.drawable.carmen), "32", "Carmen");
                        break;
                    case 33:
                        addItem2(getDrawable(R.drawable.caroline), "33", "Caroline");
                        break;
                    case 34:
                        addItem2(getDrawable(R.drawable.carrie), "34", "Carrie");
                        break;
                    case 35:
                        addItem2(getDrawable(R.drawable.cashmere), "35", "Cashmere");
                        break;
                    case 36:
                        addItem2(getDrawable(R.drawable.celia), "36", "Celia");
                        break;
                    case 37:
                        addItem2(getDrawable(R.drawable.cesar), "37", "Cesar");
                        break;
                    case 38:
                        addItem2(getDrawable(R.drawable.chadder), "38", "Chadder");
                        break;
                    case 39:
                        addItem2(getDrawable(R.drawable.charlise), "39", "Charlise");
                        break;
                    case 40:
                        addItem2(getDrawable(R.drawable.cherry), "40", "Cherry");
                        break;
                    case 41:
                        addItem2(getDrawable(R.drawable.chevre), "41", "Chevre");
                        break;
                    case 42:
                        addItem2(getDrawable(R.drawable.chief), "42", "Chief");
                        break;
                    case 43:
                        addItem2(getDrawable(R.drawable.chops), "43", "Chops");
                        break;
                    case 44:
                        addItem2(getDrawable(R.drawable.chrissy), "44", "Chrissy");
                        break;
                    case 45:
                        addItem2(getDrawable(R.drawable.claude), "45", "Claude");
                        break;
                    case 46:
                        addItem2(getDrawable(R.drawable.claudia), "46", "Claudia");
                        break;
                    case 47:
                        addItem2(getDrawable(R.drawable.coco), "47", "Coco");
                        break;
                    case 48:
                        addItem2(getDrawable(R.drawable.cole), "48", "Cole");
                        break;
                    case 49:
                        addItem2(getDrawable(R.drawable.colton), "49", "Colton");
                        break;
                    case 50:
                        addItem2(getDrawable(R.drawable.cranston), "50", "Cranston");
                        break;
                    case 51:
                        addItem2(getDrawable(R.drawable.cube), "51", "Cube");
                        break;
                    case 52:
                        addItem2(getDrawable(R.drawable.curlos), "52", "Curlos");
                        break;
                    case 53:
                        addItem2(getDrawable(R.drawable.curt), "53", "Curt");
                        break;
                    case 54:
                        addItem2(getDrawable(R.drawable.deirdre), "54", "Deirdre");
                        break;
                    case 55:
                        addItem2(getDrawable(R.drawable.diana), "55", "Diana");
                        break;
                    case 56:
                        addItem2(getDrawable(R.drawable.dizzy), "56", "Dizzy");
                        break;
                    case 57:
                        addItem2(getDrawable(R.drawable.dobie), "57", "Dobie");
                        break;
                    case 58:
                        addItem2(getDrawable(R.drawable.doc), "58", "Doc");
                        break;
                    case 59:
                        addItem2(getDrawable(R.drawable.dotty), "59", "Dotty");
                        break;
                    case 60:
                        addItem2(getDrawable(R.drawable.drift), "60", "Drift");
                        break;
                    case 61:
                        addItem2(getDrawable(R.drawable.egbert), "61", "Egbert");
                        break;
                    case 62:
                        addItem2(getDrawable(R.drawable.eloise), "62", "Eloise");
                        break;
                    case 63:
                        addItem2(getDrawable(R.drawable.erik), "63", "Erik");
                        break;
                    case 64:
                        addItem2(getDrawable(R.drawable.eunice), "64", "Eunice");
                        break;
                    case 65:
                        addItem2(getDrawable(R.drawable.fang), "65", "Fang");
                        break;
                    case 66:
                        addItem2(getDrawable(R.drawable.fauna), "66", "Fauna");
                        break;
                    case 67:
                        addItem2(getDrawable(R.drawable.filbert), "67", "Filbert");
                        break;
                    case 68:
                        addItem2(getDrawable(R.drawable.flip), "68", "Flip");
                        break;
                    case 69:
                        addItem2(getDrawable(R.drawable.flora), "69", "Flora");
                        break;
                    case 70:
                        addItem2(getDrawable(R.drawable.flurry), "70", "Flurry");
                        break;
                    case 71:
                        addItem2(getDrawable(R.drawable.francine), "71", "Francine");
                        break;
                    case 72:
                        addItem2(getDrawable(R.drawable.frank), "72", "Frank");
                        break;
                    case 73:
                        addItem2(getDrawable(R.drawable.freya), "73", "Freya");
                        break;
                    case 74:
                        addItem2(getDrawable(R.drawable.friga), "74", "Friga");
                        break;
                    case 75:
                        addItem2(getDrawable(R.drawable.frita), "75", "Frita");
                        break;
                    case 76:
                        addItem2(getDrawable(R.drawable.fuchsia), "76", "Fuchsia");
                        break;
                    case 77:
                        addItem2(getDrawable(R.drawable.gabi), "77", "Gabi");
                        break;
                    case 78:
                        addItem2(getDrawable(R.drawable.gaston), "78", "Gaston");
                        break;
                    case 79:
                        addItem2(getDrawable(R.drawable.genji), "79", "Genji");
                        break;
                    case 80:
                        addItem2(getDrawable(R.drawable.gladys), "80", "Gladys");
                        break;
                    case 81:
                        addItem2(getDrawable(R.drawable.goldie), "81", "Goldie");
                        break;
                    case 82:
                        addItem2(getDrawable(R.drawable.goose), "82", "Goose");
                        break;
                    case 83:
                        addItem2(getDrawable(R.drawable.greta), "83", "Greta");
                        break;
                    case 84:
                        addItem2(getDrawable(R.drawable.hamlet), "84", "Hamlet");
                        break;
                    case 85:
                        addItem2(getDrawable(R.drawable.hans), "85", "Hans");
                        break;
                    case 86:
                        addItem2(getDrawable(R.drawable.hazel), "86", "Hazel");
                        break;
                    case 87:
                        addItem2(getDrawable(R.drawable.hopkins), "87", "Hopkins");
                        break;
                    case 88:
                        addItem2(getDrawable(R.drawable.hopper), "88", "Hopper");
                        break;
                    case 89:
                        addItem2(getDrawable(R.drawable.hornsby), "89", "Hornsby");
                        break;
                    case 90:
                        addItem2(getDrawable(R.drawable.iggly), "90", "Iggly");
                        break;
                    case 91:
                        addItem2(getDrawable(R.drawable.jay), "91", "Jay");
                        break;
                    case 92:
                        addItem2(getDrawable(R.drawable.jitters), "92", "Jitters");
                        break;
                    case 93:
                        addItem2(getDrawable(R.drawable.julia), "93", "Julia");
                        break;
                    case 94:
                        addItem2(getDrawable(R.drawable.julian), "94", "Julian");
                        break;
                    case 95:
                        addItem2(getDrawable(R.drawable.katt), "95", "Katt");
                        break;
                    case 96:
                        addItem2(getDrawable(R.drawable.keaton), "96", "Keaton");
                        break;
                    case 97:
                        addItem2(getDrawable(R.drawable.kevin), "97", "Kevin");
                        break;
                    case 98:
                        addItem2(getDrawable(R.drawable.kid_cat), "98", "Kid Cat");
                        break;
                    case 99:
                        addItem2(getDrawable(R.drawable.kiki), "99", "Kiki");
                        break;
                    case 100:
                        addItem2(getDrawable(R.drawable.kitt), "100", "Kitt");
                        break;
                    case 101:
                        addItem2(getDrawable(R.drawable.klaus), "101", "Klaus");
                        break;
                    case 102:
                        addItem2(getDrawable(R.drawable.kyle), "102", "Kyle");
                        break;
                    case 103:
                        addItem2(getDrawable(R.drawable.leonardo), "103", "Leonardo");
                        break;
                    case 104:
                        addItem2(getDrawable(R.drawable.lily), "104", "Lily");
                        break;
                    case 105:
                        addItem2(getDrawable(R.drawable.lobo), "105", "Lobo");
                        break;
                    case 106:
                        addItem2(getDrawable(R.drawable.lolly), "106", "Lolly");
                        break;
                    case 107:
                        addItem2(getDrawable(R.drawable.lopez), "107", "Lopez");
                        break;
                    case 108:
                        addItem2(getDrawable(R.drawable.mallary), "108", "Mallary");
                        break;
                    case 109:
                        addItem2(getDrawable(R.drawable.margie), "109", "Margie");
                        break;
                    case 110:
                        addItem2(getDrawable(R.drawable.marina), "110", "Marina");
                        break;
                    case 111:
                        addItem2(getDrawable(R.drawable.marshal), "111", "Marshal");
                        break;
                    case 112:
                        addItem2(getDrawable(R.drawable.melba), "112", "Melba");
                        break;
                    case 113:
                        addItem2(getDrawable(R.drawable.merengue), "113", "Merengue");
                        break;
                    case 114:
                        addItem2(getDrawable(R.drawable.merry), "114", "Merry");
                        break;
                    case 115:
                        addItem2(getDrawable(R.drawable.mint), "115", "Mint");
                        break;
                    case 116:
                        addItem2(getDrawable(R.drawable.mira), "116", "Mira");
                        break;
                    case 117:
                        addItem2(getDrawable(R.drawable.molly), "117", "Molly");
                        break;
                    case 118:
                        addItem2(getDrawable(R.drawable.muffy), "118", "Muffy");
                        break;
                    case 119:
                        addItem2(getDrawable(R.drawable.nibbles), "119", "Nibbles");
                        break;
                    case 120:
                        addItem2(getDrawable(R.drawable.octavian), "120", "Octavian");
                        break;
                    case 121:
                        addItem2(getDrawable(R.drawable.o_hare), "121", "O'Hare");
                        break;
                    case 122:
                        addItem2(getDrawable(R.drawable.olivia), "122", "Olivia");
                        break;
                    case 123:
                        addItem2(getDrawable(R.drawable.ozzie), "123", "Ozzie");
                        break;
                    case 124:
                        addItem2(getDrawable(R.drawable.pancetti), "124", "Pancetti");
                        break;
                    case 125:
                        addItem2(getDrawable(R.drawable.patty), "125", "Patty");
                        break;
                    case 126:
                        addItem2(getDrawable(R.drawable.peaches), "126", "Peaches");
                        break;
                    case 127:
                        addItem2(getDrawable(R.drawable.peanut), "127", "Peanut");
                        break;
                    case 128:
                        addItem2(getDrawable(R.drawable.pecan), "128", "Pecan");
                        break;
                    case 129:
                        addItem2(getDrawable(R.drawable.peewee), "129", "Peewee");
                        break;
                    case 130:
                        addItem2(getDrawable(R.drawable.pekoe), "130", "Pekoe");
                        break;
                    case 131:
                        addItem2(getDrawable(R.drawable.penelope), "131", "Penelope");
                        break;
                    case 132:
                        addItem2(getDrawable(R.drawable.phil), "132", "Phil");
                        break;
                    case 133:
                        addItem2(getDrawable(R.drawable.phoebe), "133", "Phoebe");
                        break;
                    case 134:
                        addItem2(getDrawable(R.drawable.pierce), "134", "Pierce");
                        break;
                    case 135:
                        addItem2(getDrawable(R.drawable.pietro), "135", "Pietro");
                        break;
                    case 136:
                        addItem2(getDrawable(R.drawable.pinky), "136", "Pinky");
                        break;
                    case 137:
                        addItem2(getDrawable(R.drawable.piper), "137", "Piper");
                        break;
                    case 138:
                        addItem2(getDrawable(R.drawable.pippy), "138", "Pippy");
                        break;
                    case 139:
                        addItem2(getDrawable(R.drawable.poncho), "139", "Poncho");
                        break;
                    case 140:
                        addItem2(getDrawable(R.drawable.poppy), "140", "Poppy");
                        break;
                    case 141:
                        addItem2(getDrawable(R.drawable.punchy), "141", "Punchy");
                        break;
                    case 142:
                        addItem2(getDrawable(R.drawable.purrl), "142", "Purrl");
                        break;
                    case 143:
                        addItem2(getDrawable(R.drawable.queenie), "143", "Queenie");
                        break;
                    case 144:
                        addItem2(getDrawable(R.drawable.renee), "144", "Renée");
                        break;
                    case 145:
                        addItem2(getDrawable(R.drawable.rhonda), "145", "Rhonda");
                        break;
                    case 146:
                        addItem2(getDrawable(R.drawable.ricky), "146", "Ricky");
                        break;
                    case 147:
                        addItem2(getDrawable(R.drawable.roald), "147", "Roald");
                        break;
                    case 148:
                        addItem2(getDrawable(R.drawable.rocco), "148", "Rocco");
                        break;
                    case 149:
                        addItem2(getDrawable(R.drawable.rod), "149", "Rod");
                        break;
                    case 150:
                        addItem2(getDrawable(R.drawable.rodney), "150", "Rodney");
                        break;
                    case 151:
                        addItem2(getDrawable(R.drawable.rolf), "151", "Rolf");
                        break;
                    case 152:
                        addItem2(getDrawable(R.drawable.roscoe), "152", "Roscoe");
                        break;
                    case 153:
                        addItem2(getDrawable(R.drawable.rosie), "153", "Rosie");
                        break;
                    case 154:
                        addItem2(getDrawable(R.drawable.rowan), "154", "Rowan");
                        break;
                    case 155:
                        addItem2(getDrawable(R.drawable.ruby), "155", "Ruby");
                        break;
                    case 156:
                        addItem2(getDrawable(R.drawable.sally), "156", "Sally");
                        break;
                    case 157:
                        addItem2(getDrawable(R.drawable.sandy), "157", "Sandy");
                        break;
                    case 158:
                        addItem2(getDrawable(R.drawable.shari), "158", "Shari");
                        break;
                    case 159:
                        addItem2(getDrawable(R.drawable.sheldon), "159", "Sheldon");
                        break;
                    case 160:
                        addItem2(getDrawable(R.drawable.skye), "160", "Skye");
                        break;
                    case 161:
                        addItem2(getDrawable(R.drawable.sly), "161", "Sly");
                        break;
                    case 162:
                        addItem2(getDrawable(R.drawable.snake), "162", "Snake");
                        break;
                    case 163:
                        addItem2(getDrawable(R.drawable.spike), "163", "Spike");
                        break;
                    case 164:
                        addItem2(getDrawable(R.drawable.sprocket), "164", "Sprocket");
                        break;
                    case 165:
                        addItem2(getDrawable(R.drawable.static_), "165", "Static");
                        break;
                    case 166:
                        addItem2(getDrawable(R.drawable.stella), "166", "Stella");
                        break;
                    case 167:
                        addItem2(getDrawable(R.drawable.sterling), "167", "Sterling");
                        break;
                    case 168:
                        addItem2(getDrawable(R.drawable.stitches), "168", "Stitches");
                        break;
                    case 169:
                        addItem2(getDrawable(R.drawable.sylvana), "169", "Sylvana");
                        break;
                    case 170:
                        addItem2(getDrawable(R.drawable.tammy), "170", "Tammy");
                        break;
                    case 171:
                        addItem2(getDrawable(R.drawable.tank), "171", "Tank");
                        break;
                    case 172:
                        addItem2(getDrawable(R.drawable.t_bone), "172", "T-Bone");
                        break;
                    case 173:
                        addItem2(getDrawable(R.drawable.tasha), "173", "Tasha");
                        break;
                    case 174:
                        addItem2(getDrawable(R.drawable.teddy), "174", "Teddy");
                        break;
                    case 175:
                        addItem2(getDrawable(R.drawable.tiffany), "175", "Tiffany");
                        break;
                    case 176:
                        addItem2(getDrawable(R.drawable.timbra), "176", "Timbra");
                        break;
                    case 177:
                        addItem2(getDrawable(R.drawable.truffles), "177", "Truffles");
                        break;
                    case 178:
                        addItem2(getDrawable(R.drawable.tutu), "178", "Tutu");
                        break;
                    case 179:
                        addItem2(getDrawable(R.drawable.tybalt), "179", "Tybalt");
                        break;
                    case 180:
                        addItem2(getDrawable(R.drawable.vesta), "180", "Vesta");
                        break;
                    case 181:
                        addItem2(getDrawable(R.drawable.victoria), "181", "Victoria");
                        break;
                    case 182:
                        addItem2(getDrawable(R.drawable.violet), "182", "Violet");
                        break;
                    case 183:
                        addItem2(getDrawable(R.drawable.vivian), "183", "Vivian");
                        break;
                    case 184:
                        addItem2(getDrawable(R.drawable.vladimir), "184", "Vladimir");
                        break;
                    case 185:
                        addItem2(getDrawable(R.drawable.wendy), "185", "Wendy");
                        break;
                    case 186:
                        addItem2(getDrawable(R.drawable.whitney), "186", "Whitney");
                        break;
                    case 187:
                        addItem2(getDrawable(R.drawable.willow), "187", "Willow");
                        break;
                    case 188:
                        addItem2(getDrawable(R.drawable.wolfgang), "188", "Wolfgang");
                        break;
                    case 189:
                        addItem2(getDrawable(R.drawable.zucher), "189", "Zucher");
                        break;

                    case 190:
                        addItem2(getDrawable(R.drawable.admiral), "190", "Admiral");
                        break;
                    case 191:
                        addItem2(getDrawable(R.drawable.al), "191", "Al");
                        break;
                    case 192:
                        addItem2(getDrawable(R.drawable.alice), "192", "Alice");
                        break;
                    case 193:
                        addItem2(getDrawable(R.drawable.anabelle), "193", "Anabelle");
                        break;
                    case 194:
                        addItem2(getDrawable(R.drawable.anchovy), "194", "Anchovy");
                        break;
                    case 195:
                        addItem2(getDrawable(R.drawable.anicotti), "195", "Anicotti");
                        break;
                    case 196:
                        addItem2(getDrawable(R.drawable.ankha), "196", "Ankha");
                        break;
                    case 197:
                        addItem2(getDrawable(R.drawable.annalisa), "197", "Annalisa");
                        break;
                    case 198:
                        addItem2(getDrawable(R.drawable.annalise), "198", "Annalise");
                        break;
                    case 199:
                        addItem2(getDrawable(R.drawable.astrid), "199", "Astrid");
                        break;
                    case 200:
                        addItem2(getDrawable(R.drawable.audie), "200", "Audie");
                        break;
                    case 201:
                        addItem2(getDrawable(R.drawable.ava), "201", "Ava");
                        break;
                    case 202:
                        addItem2(getDrawable(R.drawable.axel), "202", "Axel");
                        break;
                    case 203:
                        addItem2(getDrawable(R.drawable.bam), "203", "Bam");
                        break;
                    case 204:
                        addItem2(getDrawable(R.drawable.barold), "204", "Barold");
                        break;
                    case 205:
                        addItem2(getDrawable(R.drawable.bea), "205", "Bea");
                        break;
                    case 206:
                        addItem2(getDrawable(R.drawable.beardo), "206", "Beardo");
                        break;
                    case 207:
                        addItem2(getDrawable(R.drawable.becky), "207", "Becky");
                        break;
                    case 208:
                        addItem2(getDrawable(R.drawable.benedict), "208", "Benedict");
                        break;
                    case 209:
                        addItem2(getDrawable(R.drawable.benjamin), "209", "Benjamin");
                        break;
                    case 210:
                        addItem2(getDrawable(R.drawable.biff), "210", "Biff");
                        break;
                    case 211:
                        addItem2(getDrawable(R.drawable.big_top), "211", "Big Top");
                        break;
                    case 212:
                        addItem2(getDrawable(R.drawable.billy), "212", "Billy");
                        break;
                    case 213:
                        addItem2(getDrawable(R.drawable.biskit), "213", "Biskit");
                        break;
                    case 214:
                        addItem2(getDrawable(R.drawable.bitty), "214", "Bitty");
                        break;
                    case 215:
                        addItem2(getDrawable(R.drawable.bluebear), "215", "Bluebear");
                        break;
                    case 216:
                        addItem2(getDrawable(R.drawable.bones), "216", "Bones");
                        break;
                    case 217:
                        addItem2(getDrawable(R.drawable.boomer), "217", "Boomer");
                        break;
                    case 218:
                        addItem2(getDrawable(R.drawable.boone), "218", "Boone");
                        break;
                    case 219:
                        addItem2(getDrawable(R.drawable.boots), "219", "Boots");
                        break;
                    case 220:
                        addItem2(getDrawable(R.drawable.boris), "220", "Boris");
                        break;
                    case 221:
                        addItem2(getDrawable(R.drawable.boyd), "221", "Boyd");
                        break;
                    case 222:
                        addItem2(getDrawable(R.drawable.broccolo), "222", "Broccolo");
                        break;
                    case 223:
                        addItem2(getDrawable(R.drawable.broffina), "223", "Broffina");
                        break;
                    case 224:
                        addItem2(getDrawable(R.drawable.bruce), "224", "Bruce");
                        break;
                    case 225:
                        addItem2(getDrawable(R.drawable.bubbles), "225", "Bubbles");
                        break;
                    case 226:
                        addItem2(getDrawable(R.drawable.camofrog), "226", "Camofrog");
                        break;
                    case 227:
                        addItem2(getDrawable(R.drawable.candi), "227", "Candi");
                        break;
                    case 228:
                        addItem2(getDrawable(R.drawable.chai), "228", "Chai");
                        break;
                    case 229:
                        addItem2(getDrawable(R.drawable.chelsea), "229", "Chelsea");
                        break;
                    case 230:
                        addItem2(getDrawable(R.drawable.cheri), "230", "Cheri");
                        break;
                    case 231:
                        addItem2(getDrawable(R.drawable.chester), "231", "Chester");
                        break;
                    case 232:
                        addItem2(getDrawable(R.drawable.chow), "232", "Chow");
                        break;
                    case 233:
                        addItem2(getDrawable(R.drawable.clay), "233", "Clay");
                        break;
                    case 234:
                        addItem2(getDrawable(R.drawable.cleo), "234", "Cleo");
                        break;
                    case 235:
                        addItem2(getDrawable(R.drawable.clyde), "235", "Clyde");
                        break;
                    case 236:
                        addItem2(getDrawable(R.drawable.coach), "236", "Coach");
                        break;
                    case 237:
                        addItem2(getDrawable(R.drawable.cobb), "237", "Cobb");
                        break;
                    case 238:
                        addItem2(getDrawable(R.drawable.cookie), "238", "Cookie");
                        break;
                    case 239:
                        addItem2(getDrawable(R.drawable.cousteau), "239", "Cousteau");
                        break;
                    case 240:
                        addItem2(getDrawable(R.drawable.croque), "240", "Croque");
                        break;
                    case 241:
                        addItem2(getDrawable(R.drawable.curly), "241", "Curly");
                        break;
                    case 242:
                        addItem2(getDrawable(R.drawable.cyd), "242", "Cyd");
                        break;
                    case 243:
                        addItem2(getDrawable(R.drawable.cyrano), "243", "Cyrano");
                        break;
                    case 244:
                        addItem2(getDrawable(R.drawable.daisy), "244", "Daisy");
                        break;
                    case 245:
                        addItem2(getDrawable(R.drawable.deena), "245", "Deena");
                        break;
                    case 246:
                        addItem2(getDrawable(R.drawable.del), "246", "Del");
                        break;
                    case 247:
                        addItem2(getDrawable(R.drawable.deli), "247", "Deli");
                        break;
                    case 248:
                        addItem2(getDrawable(R.drawable.derwin), "248", "Derwin");
                        break;
                    case 249:
                        addItem2(getDrawable(R.drawable.diva), "249", "Diva");
                        break;
                    case 250:
                        addItem2(getDrawable(R.drawable.dom), "250", "Dom");
                        break;
                    case 251:
                        addItem2(getDrawable(R.drawable.dora), "251", "Dora");
                        break;
                    case 252:
                        addItem2(getDrawable(R.drawable.drago), "252", "Drago");
                        break;
                    case 253:
                        addItem2(getDrawable(R.drawable.drake), "253", "Drake");
                        break;
                    case 254:
                        addItem2(getDrawable(R.drawable.ed), "254", "Ed");
                        break;
                    case 255:
                        addItem2(getDrawable(R.drawable.elise), "255", "Elise");
                        break;
                    case 256:
                        addItem2(getDrawable(R.drawable.ellie), "256", "Ellie");
                        break;
                    case 257:
                        addItem2(getDrawable(R.drawable.elmer), "257", "Elmer");
                        break;
                    case 258:
                        addItem2(getDrawable(R.drawable.elvis), "258", "Elvis");
                        break;
                    case 259:
                        addItem2(getDrawable(R.drawable.etoile), "259", "Étoile");
                        break;
                    case 260:
                        addItem2(getDrawable(R.drawable.eugene), "260", "Eugene");
                        break;
                    case 261:
                        addItem2(getDrawable(R.drawable.felicity), "261", "Felicity");
                        break;
                    case 262:
                        addItem2(getDrawable(R.drawable.flo), "262", "Flo");
                        break;
                    case 263:
                        addItem2(getDrawable(R.drawable.freckles), "263", "Freckles");
                        break;
                    case 264:
                        addItem2(getDrawable(R.drawable.frobert), "264", "Frobert");
                        break;
                    case 265:
                        addItem2(getDrawable(R.drawable.gala), "265", "Gala");
                        break;
                    case 266:
                        addItem2(getDrawable(R.drawable.gayle), "266", "Gayle");
                        break;
                    case 267:
                        addItem2(getDrawable(R.drawable.gigi), "267", "Gigi");
                        break;
                    case 268:
                        addItem2(getDrawable(R.drawable.gloria), "268", "Gloria");
                        break;
                    case 269:
                        addItem2(getDrawable(R.drawable.gonzo), "269", "Gonzo");
                        break;
                    case 270:
                        addItem2(getDrawable(R.drawable.graham), "270", "Graham");
                        break;
                    case 271:
                        addItem2(getDrawable(R.drawable.grizzly), "271", "Grizzly");
                        break;
                    case 272:
                        addItem2(getDrawable(R.drawable.groucho), "272", "Groucho");
                        break;
                    case 273:
                        addItem2(getDrawable(R.drawable.gruff), "273", "Gruff");
                        break;
                    case 274:
                        addItem2(getDrawable(R.drawable.gwen), "274", "Gwen");
                        break;
                    case 275:
                        addItem2(getDrawable(R.drawable.hamphrey), "275", "Hamphrey");
                        break;
                    case 276:
                        addItem2(getDrawable(R.drawable.harry), "276", "Harry");
                        break;
                    case 277:
                        addItem2(getDrawable(R.drawable.henry), "277", "Henry");
                        break;
                    case 278:
                        addItem2(getDrawable(R.drawable.hippeux), "278", "Hippeux");
                        break;
                    case 279:
                        addItem2(getDrawable(R.drawable.huck), "279", "Huck");
                        break;
                    case 280:
                        addItem2(getDrawable(R.drawable.hugh), "280", "Hugh");
                        break;
                    case 281:
                        addItem2(getDrawable(R.drawable.ike), "281", "Ike");
                        break;
                    case 282:
                        addItem2(getDrawable(R.drawable.jacob), "282", "Jacob");
                        break;
                    case 283:
                        addItem2(getDrawable(R.drawable.jacques), "283", "Jacques");
                        break;
                    case 284:
                        addItem2(getDrawable(R.drawable.jambette), "284", "Jambette");
                        break;
                    case 285:
                        addItem2(getDrawable(R.drawable.jeremiah), "285", "Jeremiah");
                        break;
                    case 286:
                        addItem2(getDrawable(R.drawable.joey), "286", "Joey");
                        break;
                    case 287:
                        addItem2(getDrawable(R.drawable.judy), "287", "Judy");
                        break;
                    case 288:
                        addItem2(getDrawable(R.drawable.june), "288", "June");
                        break;
                    case 289:
                        addItem2(getDrawable(R.drawable.kabuki), "289", "Kabuki");
                        break;
                    case 290:
                        addItem2(getDrawable(R.drawable.ken), "290", "Ken");
                        break;
                    case 291:
                        addItem2(getDrawable(R.drawable.ketchup), "291", "Ketchup");
                        break;
                    case 292:
                        addItem2(getDrawable(R.drawable.kidd), "292", "Kidd");
                        break;
                    case 293:
                        addItem2(getDrawable(R.drawable.kitty), "293", "Kitty");
                        break;
                    case 294:
                        addItem2(getDrawable(R.drawable.knox), "294", "Knox");
                        break;
                    case 295:
                        addItem2(getDrawable(R.drawable.kody), "295", "Kody");
                        break;
                    case 296:
                        addItem2(getDrawable(R.drawable.limberg), "296", "Limberg");
                        break;
                    case 297:
                        addItem2(getDrawable(R.drawable.lionel), "297", "Lionel");
                        break;
                    case 298:
                        addItem2(getDrawable(R.drawable.louie), "298", "Louie");
                        break;
                    case 299:
                        addItem2(getDrawable(R.drawable.lucha), "299", "Lucha");
                        break;
                    case 300:
                        addItem2(getDrawable(R.drawable.lucky), "300", "Lucky");
                        break;
                    case 301:
                        addItem2(getDrawable(R.drawable.lucy), "301", "Lucy");
                        break;
                    case 302:
                        addItem2(getDrawable(R.drawable.lyman), "302", "Lyman");
                        break;
                    case 303:
                        addItem2(getDrawable(R.drawable.mac), "303", "Mac");
                        break;
                    case 304:
                        addItem2(getDrawable(R.drawable.maddie), "304", "Maddie");
                        break;
                    case 305:
                        addItem2(getDrawable(R.drawable.maelle), "305", "Maelle");
                        break;
                    case 306:
                        addItem2(getDrawable(R.drawable.maggie), "306", "Maggie");
                        break;
                    case 307:
                        addItem2(getDrawable(R.drawable.maple), "307", "Maple");
                        break;
                    case 308:
                        addItem2(getDrawable(R.drawable.marcel), "308", "Marcel");
                        break;
                    case 309:
                        addItem2(getDrawable(R.drawable.marcie), "309", "Marcie");
                        break;
                    case 310:
                        addItem2(getDrawable(R.drawable.mathilda), "310", "Mathilda");
                        break;
                    case 311:
                        addItem2(getDrawable(R.drawable.megan), "311", "Megan");
                        break;
                    case 312:
                        addItem2(getDrawable(R.drawable.midge), "312", "Midge");
                        break;
                    case 313:
                        addItem2(getDrawable(R.drawable.miranda), "313", "Miranda");
                        break;
                    case 314:
                        addItem2(getDrawable(R.drawable.mitzi), "314", "Mitzi");
                        break;
                    case 315:
                        addItem2(getDrawable(R.drawable.moe), "315", "Moe");
                        break;
                    case 316:
                        addItem2(getDrawable(R.drawable.monique), "316", "Monique");
                        break;
                    case 317:
                        addItem2(getDrawable(R.drawable.monty), "317", "Monty");
                        break;
                    case 318:
                        addItem2(getDrawable(R.drawable.moose), "318", "Moose");
                        break;
                    case 319:
                        addItem2(getDrawable(R.drawable.mott), "319", "Mott");
                        break;
                    case 320:
                        addItem2(getDrawable(R.drawable.murphy), "320", "Murphy");
                        break;
                    case 321:
                        addItem2(getDrawable(R.drawable.nan), "321", "Nan");
                        break;
                    case 322:
                        addItem2(getDrawable(R.drawable.nana), "322", "Nana");
                        break;
                    case 323:
                        addItem2(getDrawable(R.drawable.naomi), "323", "Naomi");
                        break;
                    case 324:
                        addItem2(getDrawable(R.drawable.nate), "324", "Nate");
                        break;
                    case 325:
                        addItem2(getDrawable(R.drawable.norma), "325", "Norma");
                        break;
                    case 326:
                        addItem2(getDrawable(R.drawable.olaf), "326", "Olaf");
                        break;
                    case 327:
                        addItem2(getDrawable(R.drawable.olive), "327", "Olive");
                        break;
                    case 328:
                        addItem2(getDrawable(R.drawable.opal), "328", "Opal");
                        break;
                    case 329:
                        addItem2(getDrawable(R.drawable.pango), "329", "Pango");
                        break;
                    case 330:
                        addItem2(getDrawable(R.drawable.paolo), "330", "Paolo");
                        break;
                    case 331:
                        addItem2(getDrawable(R.drawable.papi), "331", "Papi");
                        break;
                    case 332:
                        addItem2(getDrawable(R.drawable.pashmina), "332", "Pashmina");
                        break;
                    case 333:
                        addItem2(getDrawable(R.drawable.pate), "333", "Pate");
                        break;
                    case 334:
                        addItem2(getDrawable(R.drawable.paula), "334", "Paula");
                        break;
                    case 335:
                        addItem2(getDrawable(R.drawable.peck), "335", "Peck");
                        break;
                    case 336:
                        addItem2(getDrawable(R.drawable.peggy), "336", "Peggy");
                        break;
                    case 337:
                        addItem2(getDrawable(R.drawable.plucky), "337", "Plucky");
                        break;
                    case 338:
                        addItem2(getDrawable(R.drawable.pompom), "338", "Pompom");
                        break;
                    case 339:
                        addItem2(getDrawable(R.drawable.portia), "339", "Portia");
                        break;
                    case 340:
                        addItem2(getDrawable(R.drawable.prince), "340", "Prince");
                        break;
                    case 341:
                        addItem2(getDrawable(R.drawable.puck), "341", "Puck");
                        break;
                    case 342:
                        addItem2(getDrawable(R.drawable.puddles), "342", "Puddles");
                        break;
                    case 343:
                        addItem2(getDrawable(R.drawable.pudge), "343", "Pudge");
                        break;
                    case 344:
                        addItem2(getDrawable(R.drawable.quillson), "344", "Quillson");
                        break;
                    case 345:
                        addItem2(getDrawable(R.drawable.raddle), "345", "Raddle");
                        break;
                    case 346:
                        addItem2(getDrawable(R.drawable.rasher), "346", "Rasher");
                        break;
                    case 347:
                        addItem2(getDrawable(R.drawable.raymond), "347", "Raymond");
                        break;
                    case 348:
                        addItem2(getDrawable(R.drawable.reneigh), "348", "Reneigh");
                        break;
                    case 349:
                        addItem2(getDrawable(R.drawable.rex), "349", "Rex");
                        break;
                    case 350:
                        addItem2(getDrawable(R.drawable.ribbot), "350", "Ribbot");
                        break;
                    case 351:
                        addItem2(getDrawable(R.drawable.rilla), "351", "Rilla");
                        break;
                    case 352:
                        addItem2(getDrawable(R.drawable.rizzo), "352", "Rizzo");
                        break;
                    case 353:
                        addItem2(getDrawable(R.drawable.robin), "353", "Robin");
                        break;
                    case 354:
                        addItem2(getDrawable(R.drawable.rocket), "354", "Rocket");
                        break;
                    case 355:
                        addItem2(getDrawable(R.drawable.rodeo), "355", "Rodeo");
                        break;
                    case 356:
                        addItem2(getDrawable(R.drawable.rooney), "356", "Rooney");
                        break;
                    case 357:
                        addItem2(getDrawable(R.drawable.rory), "357", "Rory");
                        break;
                    case 358:
                        addItem2(getDrawable(R.drawable.rudy), "358", "Rudy");
                        break;
                    case 359:
                        addItem2(getDrawable(R.drawable.samson), "359", "Samson");
                        break;
                    case 360:
                        addItem2(getDrawable(R.drawable.savannah), "360", "Savannah");
                        break;
                    case 361:
                        addItem2(getDrawable(R.drawable.scoot), "361", "Scoot");
                        break;
                    case 362:
                        addItem2(getDrawable(R.drawable.shep), "362", "Shep");
                        break;
                    case 363:
                        addItem2(getDrawable(R.drawable.sherb), "363", "Sherb");
                        break;
                    case 364:
                        addItem2(getDrawable(R.drawable.simon), "364", "Simon");
                        break;
                    case 365:
                        addItem2(getDrawable(R.drawable.snooty), "365", "Snooty");
                        break;
                    case 366:
                        addItem2(getDrawable(R.drawable.soleil), "366", "Soleil");
                        break;
                    case 367:
                        addItem2(getDrawable(R.drawable.sparro), "367", "Sparro");
                        break;
                    case 368:
                        addItem2(getDrawable(R.drawable.spork), "368", "Spork");
                        break;
                    case 369:
                        addItem2(getDrawable(R.drawable.sprinkle), "369", "Sprinkle");
                        break;
                    case 370:
                        addItem2(getDrawable(R.drawable.stinky), "370", "Stinky");
                        break;
                    case 371:
                        addItem2(getDrawable(R.drawable.stu), "371", "Stu");
                        break;
                    case 372:
                        addItem2(getDrawable(R.drawable.sydney), "372", "Sydney");
                        break;
                    case 373:
                        addItem2(getDrawable(R.drawable.sylvia), "373", "Sylvia");
                        break;
                    case 374:
                        addItem2(getDrawable(R.drawable.tabby), "374", "Tabby");
                        break;
                    case 375:
                        addItem2(getDrawable(R.drawable.tad), "375", "Tad");
                        break;
                    case 376:
                        addItem2(getDrawable(R.drawable.tammi), "376", "Tammi");
                        break;
                    case 377:
                        addItem2(getDrawable(R.drawable.tangy), "377", "Tangy");
                        break;
                    case 378:
                        addItem2(getDrawable(R.drawable.tex), "378", "Tex");
                        break;
                    case 379:
                        addItem2(getDrawable(R.drawable.tia), "379", "Tia");
                        break;
                    case 380:
                        addItem2(getDrawable(R.drawable.tipper), "380", "Tipper");
                        break;
                    case 381:
                        addItem2(getDrawable(R.drawable.toby), "381", "Toby");
                        break;
                    case 382:
                        addItem2(getDrawable(R.drawable.tom), "382", "Tom");
                        break;
                    case 383:
                        addItem2(getDrawable(R.drawable.tucker), "383", "Tucker");
                        break;
                    case 384:
                        addItem2(getDrawable(R.drawable.twiggy), "384", "Twiggy");
                        break;
                    case 385:
                        addItem2(getDrawable(R.drawable.ursala), "385", "Ursala");
                        break;
                    case 386:
                        addItem2(getDrawable(R.drawable.velma), "386", "Velma");
                        break;
                    case 387:
                        addItem2(getDrawable(R.drawable.vic), "387", "Vic");
                        break;
                    case 388:
                        addItem2(getDrawable(R.drawable.wade), "388", "Wade");
                        break;
                    case 389:
                        addItem2(getDrawable(R.drawable.walker), "389", "Walker");
                        break;
                    case 390:
                        addItem2(getDrawable(R.drawable.walt), "390", "Walt");
                        break;
                    case 391:
                        addItem2(getDrawable(R.drawable.wart_jr), "391", "Wart Jr.");
                        break;
                    case 392:
                        addItem2(getDrawable(R.drawable.weber), "392", "Weber");
                        break;
                    case 393:
                        addItem2(getDrawable(R.drawable.winnie), "393", "Winnie");
                        break;
                    case 394:
                        addItem2(getDrawable(R.drawable.yuka), "394", "Yuka");
                        break;
                    case 395:
                        addItem2(getDrawable(R.drawable.zell), "395", "Zell");
                        break;
                    default:
                        break;
                }
            }
        }
        mAdapter2.notifyDataSetChanged();
        numCelResi.setText(mAdapter2.getItemCount() + " / 10");


        /*에디트 텍스트 맨 끝으로*/
        Editable etext = etMIN.getText();
        Selection.setSelection(etext, etext.length());
        etext = etMIA.getText();
        Selection.setSelection(etext, etext.length());
        etext = etMIF.getText();
        Selection.setSelection(etext, etext.length());
        etext = etMIR.getText();
        Selection.setSelection(etext, etext.length());


        //데이더 추가 - 라디오 그룹에서
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            numTotResi.setText("395명 검색됨");
        } else {
            //default 영어
            numTotResi.setText("395 Searched");
        }
        _numTotResi = numTotResi;


        /*라디오 그룹*/
        rdoGroup1.setOnCheckedChangeListener(listener1);

        rdoGroup2.setOnCheckedChangeListener(listener2);


        /*주민 데이터 리사이클러 뷰: 1, 선택 주민 리사이클러 뷰: 2 기능*/
        mAdapter1.setOnItemClickListener(new VillRecyclerImageTextAdapter.OnItemClickListener() {
           @Override
           public void onItemClick(View view, int position) {
               int chackPos = 0;
               if (mAdapter2.getItemCount() < 10) {
                   Boolean chackContain = false;
                   for (int i=0; i<mAdapter2.getItemCount(); i++) {
                       if (mList2.get(i).getTitle() == mList1.get(position).getTitle()) {
                           chackContain = true;
                           chackPos = i;
                       }
                   }
                   if (chackContain) {
                       if (Locale.getDefault().getLanguage().equals("ko")) {
                           //한국어
                           Snackbar.make(view, "이미 그 주민이 살고있어요.", Snackbar.LENGTH_SHORT).show();
                       } else {
                           //default 영어
                           Snackbar.make(view, "He or She is already got a resident.", Snackbar.LENGTH_SHORT).show();
                       }
                       mRecyclerView2.scrollToPosition(chackPos);
                   } else {
                       addItem2(mList1.get(position).getIcon(), mList1.get(position).getTitle(), mList1.get(position).getDesc());

                       mAdapter2.notifyDataSetChanged();
                       numCelResi.setText(mAdapter2.getItemCount() + " / 10");

                       mRecyclerView2.scrollToPosition(mAdapter2.getItemCount() - 1);
                   }
               } else {
                   if (Locale.getDefault().getLanguage().equals("ko")) {
                       //한국어
                       Snackbar.make(view, "그맘 알지만... 최대 10명까지 같이 지낼 수 있어요.", Snackbar.LENGTH_SHORT).show();
                   } else {
                       //default 영어
                       Snackbar.make(view, "Sorry... You can stay with up to 10 people.", Snackbar.LENGTH_SHORT).show();
                   }
               }
           }
        });

        mAdapter2.setOnItemLongClickListener(new VillRecyclerImageTextAdapter.OnItemLongClickListener() {
            @Override
            public void onItemLongClick(View view, int position) {
                mList2.remove(position);

                mAdapter2.notifyDataSetChanged();
                numCelResi.setText(mAdapter2.getItemCount() + " / 10");
            }
        });


        /*액티비티 종료*/
        dlgBtnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etMIN.getText().toString().replace(" ","").equals("")) {
                    if (Locale.getDefault().getLanguage().equals("ko")) {
                        //한국어
                        Snackbar.make(view, "섬 이름이 궁금해요!", Snackbar.LENGTH_SHORT).setTextColor(Color.rgb(255,186,190)).show();
                    } else {
                        //default 영어
                        Snackbar.make(view, "Please tell me your island name!", Snackbar.LENGTH_SHORT).setTextColor(Color.rgb(255,186,190)).show();
                    }
                } else if (etMIA.getText().toString().replace(" ","").equals("")) {
                    if (Locale.getDefault().getLanguage().equals("ko")) {
                        //한국어
                        Snackbar.make(view, "섬 주소를 알려주세요!", Snackbar.LENGTH_SHORT).setTextColor(Color.rgb(255,186,190)).show();
                    } else {
                        //default 영어
                        Snackbar.make(view, "Please tell me your island address!", Snackbar.LENGTH_SHORT).setTextColor(Color.rgb(255,186,190)).show();
                    }
                } else if (etMIF.getText().toString().replace(" ","").equals("")) {
                    if (Locale.getDefault().getLanguage().equals("ko")) {
                        //한국어
                        Snackbar.make(view, "섬 대표 과일이 무엇인가요?", Snackbar.LENGTH_SHORT).setTextColor(Color.rgb(255,186,190)).show();
                    } else {
                        //default 영어
                        Snackbar.make(view, "What is your island's main fruit?", Snackbar.LENGTH_SHORT).setTextColor(Color.rgb(255,186,190)).show();
                    }
                } else if (etMIR.getText().toString().replace(" ","").equals("")) {
                    if (Locale.getDefault().getLanguage().equals("ko")) {
                        //한국어
                        Snackbar.make(view, "대표적으로 누가 살고 있나요?", Snackbar.LENGTH_SHORT).setTextColor(Color.rgb(255,186,190)).show();
                    } else {
                        //default 영어
                        Snackbar.make(view, "Who is representing the island?", Snackbar.LENGTH_SHORT).setTextColor(Color.rgb(255,186,190)).show();
                    }
                } else {
                    int numResiData = mAdapter2.getItemCount();

                    etMIN.setText(etMIN.getText().toString().replace("`","\'"));
                    etMIN.setText(etMIN.getText().toString().replace("\n"," "));
                    etMIA.setText(etMIA.getText().toString().replace("`","\'"));
                    etMIA.setText(etMIA.getText().toString().replace("\n"," "));
                    etMIF.setText(etMIF.getText().toString().replace("`","\'"));
                    etMIF.setText(etMIF.getText().toString().replace("\n"," "));
                    etMIR.setText(etMIR.getText().toString().replace("`","\'"));
                    etMIR.setText(etMIR.getText().toString().replace("\n"," "));

                    Intent data = new Intent();
                    data.putExtra("iName", etMIN.getText().toString());
                    data.putExtra("iAddress", etMIA.getText().toString());
                    data.putExtra("iFruit", etMIF.getText().toString());
                    data.putExtra("iResident", etMIR.getText().toString());
                    if (swHemisphere.isChecked()) {
                        data.putExtra("hemisphere", 1);
                    } else {
                        data.putExtra("hemisphere", 0);
                    }

                    data.putExtra("numResident", numResiData);
                    for (int i=0; i<numResiData; i++) {
                        data.putExtra(Integer.toString(i), Integer.parseInt(mList2.get(i).getTitle()));
                    }
                    setResult(RESULT_OK, data);
                    stop_activity();
                }
            }
        });

        dlgBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Locale.getDefault().getLanguage().equals("ko")) {
                    //한국어
                    Snackbar.make(view, "저장하지 않고 나가시겠습니까?", Snackbar.LENGTH_LONG)
                            .setAction("나갈래요", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    setResult(RESULT_CANCELED);
                                    stop_activity();
                                }
                            }).setActionTextColor(Color.rgb(255,186,190))
                            .show();
                } else {
                    //default 영어
                    Snackbar.make(view, "Do you want to leave without saving?", Snackbar.LENGTH_LONG)
                            .setAction("Yes", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    setResult(RESULT_CANCELED);
                                    stop_activity();
                                }
                            }).setActionTextColor(Color.rgb(255,186,190))
                            .show();
                }
            }
        });
    }


    @Override
    public void onBackPressed() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            Snackbar.make(findViewById(android.R.id.content), "저장하지 않고 나가시겠습니까?", Snackbar.LENGTH_LONG)
                    .setAction("나갈래요", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            setResult(RESULT_CANCELED);
                            stop_activity();
                        }
                    }).setActionTextColor(Color.rgb(255,186,190))
                    .show();
        } else {
            //default 영어
            Snackbar.make(findViewById(android.R.id.content), "Do you want to leave without saving?", Snackbar.LENGTH_LONG)
                    .setAction("Yes", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            setResult(RESULT_CANCELED);
                            stop_activity();
                        }
                    }).setActionTextColor(Color.rgb(255,186,190))
                    .show();
        }
        //super.onBackPressed();
    }


    public void stop_activity() {
        mList1.clear();
        mAdapter1.notifyDataSetChanged();
        mList2.clear();
        mAdapter2.notifyDataSetChanged();

        finish();
        super.onDestroy();
    }


    public void addItem1(Drawable icon, String title, String desc) {
        RecyclerVillItem item = new RecyclerVillItem();

        item.setIcon(icon);
        item.setTitle(title);
        item.setDesc(desc);

        mList1.add(item);
    }

    public void addItem2(Drawable icon, String title, String desc) {
        RecyclerVillItem item = new RecyclerVillItem();

        item.setIcon(icon);
        item.setTitle(title);
        item.setDesc(desc);

        mList2.add(item);
    }


    /*Alligator 데이터 추가*/
    public void loadAlligator() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.alfonso), "3", "알베르트");
            addItem1(getDrawable(R.drawable.alli), "4", "크로코");
            addItem1(getDrawable(R.drawable.sly), "161", "하이드");

            addItem1(getDrawable(R.drawable.boots), "219", "풍작");
            addItem1(getDrawable(R.drawable.del), "246", "파도맨");
            addItem1(getDrawable(R.drawable.drago), "252", "용남이");
            addItem1(getDrawable(R.drawable.gayle), "266", "앨리");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.alfonso), "3", "Alfonso");
            addItem1(getDrawable(R.drawable.alli), "4", "Alli");
            addItem1(getDrawable(R.drawable.sly), "161", "Sly");

            addItem1(getDrawable(R.drawable.boots), "219", "Boots");
            addItem1(getDrawable(R.drawable.del), "246", "Del");
            addItem1(getDrawable(R.drawable.drago), "252", "Drago");
            addItem1(getDrawable(R.drawable.gayle), "266", "Gayle");
        }
    }

    /*Anteater 데이터 추가*/
    public void loadAnteater() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.antonio), "7", "퍼머거");

            addItem1(getDrawable(R.drawable.anabelle), "193", "아롱이");
            addItem1(getDrawable(R.drawable.annalisa), "197", "설백");
            addItem1(getDrawable(R.drawable.cyrano), "243", "사지마");
            addItem1(getDrawable(R.drawable.olaf), "326", "안토니오");
            addItem1(getDrawable(R.drawable.pango), "329", "패트라");
            addItem1(getDrawable(R.drawable.snooty), "365", "스누티");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.antonio), "7", "Antonio");

            addItem1(getDrawable(R.drawable.anabelle), "193", "Anabelle");
            addItem1(getDrawable(R.drawable.annalisa), "197", "Annalisa");
            addItem1(getDrawable(R.drawable.cyrano), "243", "Cyrano");
            addItem1(getDrawable(R.drawable.olaf), "326", "Olaf");
            addItem1(getDrawable(R.drawable.pango), "329", "Pango");
            addItem1(getDrawable(R.drawable.snooty), "365", "Snooty");
        }
    }

    /*Bear 데이터 추가*/
    public void loadBear() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.charlise), "39", "챠미");
            addItem1(getDrawable(R.drawable.curt), "53", "뚝심");
            addItem1(getDrawable(R.drawable.klaus), "101", "곰도로스");
            addItem1(getDrawable(R.drawable.pinky), "136", "링링");
            addItem1(getDrawable(R.drawable.teddy), "174", "병태");
            addItem1(getDrawable(R.drawable.tutu), "178", "연유");

            addItem1(getDrawable(R.drawable.beardo), "206", "베어드");
            addItem1(getDrawable(R.drawable.chow), "232", "츄앙");
            addItem1(getDrawable(R.drawable.grizzly), "271", "무뚝");
            addItem1(getDrawable(R.drawable.groucho), "272", "거무틱");
            addItem1(getDrawable(R.drawable.megan), "311", "캔디");
            addItem1(getDrawable(R.drawable.nate), "324", "박하스");
            addItem1(getDrawable(R.drawable.paula), "334", "레이첼");
            addItem1(getDrawable(R.drawable.ursala), "385", "네이아");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.charlise), "39", "Charlise");
            addItem1(getDrawable(R.drawable.curt), "53", "Curt");
            addItem1(getDrawable(R.drawable.klaus), "101", "Klaus");
            addItem1(getDrawable(R.drawable.pinky), "136", "Pinky");
            addItem1(getDrawable(R.drawable.teddy), "174", "Teddy");
            addItem1(getDrawable(R.drawable.tutu), "178", "Tutu");

            addItem1(getDrawable(R.drawable.beardo), "206", "Beardo");
            addItem1(getDrawable(R.drawable.chow), "232", "Chow");
            addItem1(getDrawable(R.drawable.grizzly), "271", "Grizzly");
            addItem1(getDrawable(R.drawable.groucho), "272", "Groucho");
            addItem1(getDrawable(R.drawable.megan), "311", "Megan");
            addItem1(getDrawable(R.drawable.nate), "324", "Nate");
            addItem1(getDrawable(R.drawable.paula), "334", "Paula");
            addItem1(getDrawable(R.drawable.ursala), "385", "Ursala");
        }
    }

    /*Bird 데이터 추가*/
    public void loadBird() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.jay), "91", "참돌이");
            addItem1(getDrawable(R.drawable.jitters), "92", "딩요");
            addItem1(getDrawable(R.drawable.piper), "137", "파이프");

            addItem1(getDrawable(R.drawable.admiral), "190", "일섭");
            addItem1(getDrawable(R.drawable.anchovy), "194", "안쵸비");
            addItem1(getDrawable(R.drawable.jacob), "282", "야곱");
            addItem1(getDrawable(R.drawable.jacques), "283", "쪼끼");
            addItem1(getDrawable(R.drawable.lucha), "299", "마스카라스");
            addItem1(getDrawable(R.drawable.midge), "312", "핑글이");
            addItem1(getDrawable(R.drawable.peck), "335", "문대");
            addItem1(getDrawable(R.drawable.robin), "353", "파틱");
            addItem1(getDrawable(R.drawable.sparro), "367", "춘섭");
            addItem1(getDrawable(R.drawable.twiggy), "384", "핀틱");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.jay), "91", "Jay");
            addItem1(getDrawable(R.drawable.jitters), "92", "Jitters");
            addItem1(getDrawable(R.drawable.piper), "137", "Piper");

            addItem1(getDrawable(R.drawable.admiral), "190", "Admiral");
            addItem1(getDrawable(R.drawable.anchovy), "194", "Anchovy");
            addItem1(getDrawable(R.drawable.jacob), "282", "Jacob");
            addItem1(getDrawable(R.drawable.jacques), "283", "Jacques");
            addItem1(getDrawable(R.drawable.lucha), "299", "Lucha");
            addItem1(getDrawable(R.drawable.midge), "312", "Midge");
            addItem1(getDrawable(R.drawable.peck), "335", "Peck");
            addItem1(getDrawable(R.drawable.robin), "353", "Robin");
            addItem1(getDrawable(R.drawable.sparro), "367", "Sparro");
            addItem1(getDrawable(R.drawable.twiggy), "384", "Twiggy");
        }
    }

    /*Cat 데이터 추가*/
    public void loadCat() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.bob), "22", "히죽");
            addItem1(getDrawable(R.drawable.katt), "95", "쵸이");
            addItem1(getDrawable(R.drawable.kid_cat), "98", "1호");
            addItem1(getDrawable(R.drawable.kiki), "99", "캐비어");
            addItem1(getDrawable(R.drawable.lolly), "106", "사이다");
            addItem1(getDrawable(R.drawable.merry), "114", "유네찌");
            addItem1(getDrawable(R.drawable.olivia), "122", "올리비아");
            addItem1(getDrawable(R.drawable.punchy), "141", "빙티");
            addItem1(getDrawable(R.drawable.purrl), "142", "타마");
            addItem1(getDrawable(R.drawable.rosie), "153", "부케");

            addItem1(getDrawable(R.drawable.ankha), "196", "클레오");
            addItem1(getDrawable(R.drawable.felicity), "261", "예링");
            addItem1(getDrawable(R.drawable.kabuki), "289", "가북희");
            addItem1(getDrawable(R.drawable.kitty), "293", "쇼콜라");
            addItem1(getDrawable(R.drawable.mitzi), "314", "마르");
            addItem1(getDrawable(R.drawable.moe), "315", "진상");
            addItem1(getDrawable(R.drawable.monique), "316", "제인");
            addItem1(getDrawable(R.drawable.raymond), "347", "잭슨");
            addItem1(getDrawable(R.drawable.rudy), "358", "찰스");
            addItem1(getDrawable(R.drawable.stinky), "370", "땀띠");
            addItem1(getDrawable(R.drawable.tabby), "374", "호냥이");
            addItem1(getDrawable(R.drawable.tangy), "377", "백프로");
            addItem1(getDrawable(R.drawable.tom), "382", "밴덤");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.bob), "22", "Bob");
            addItem1(getDrawable(R.drawable.katt), "95", "Katt");
            addItem1(getDrawable(R.drawable.kid_cat), "98", "Kid Cat");
            addItem1(getDrawable(R.drawable.kiki), "99", "Kiki");
            addItem1(getDrawable(R.drawable.lolly), "106", "Lolly");
            addItem1(getDrawable(R.drawable.merry), "114", "Merry");
            addItem1(getDrawable(R.drawable.olivia), "122", "Olivia");
            addItem1(getDrawable(R.drawable.punchy), "141", "Punchy");
            addItem1(getDrawable(R.drawable.purrl), "142", "Purrl");
            addItem1(getDrawable(R.drawable.rosie), "153", "Rosie");

            addItem1(getDrawable(R.drawable.ankha), "196", "Ankha");
            addItem1(getDrawable(R.drawable.felicity), "261", "Felicity");
            addItem1(getDrawable(R.drawable.kabuki), "289", "Kabuki");
            addItem1(getDrawable(R.drawable.kitty), "293", "Kitty");
            addItem1(getDrawable(R.drawable.mitzi), "314", "Mitzi");
            addItem1(getDrawable(R.drawable.moe), "315", "Moe");
            addItem1(getDrawable(R.drawable.monique), "316", "Monique");
            addItem1(getDrawable(R.drawable.raymond), "347", "Raymond");
            addItem1(getDrawable(R.drawable.rudy), "358", "Rudy");
            addItem1(getDrawable(R.drawable.stinky), "370", "Stinky");
            addItem1(getDrawable(R.drawable.tabby), "374", "Tabby");
            addItem1(getDrawable(R.drawable.tangy), "377", "Tangy");
            addItem1(getDrawable(R.drawable.tom), "382", "Tom");
        }
    }

    /*Chicken 데이터 추가*/
    public void loadChicken() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.egbert), "61", "김희");
            addItem1(getDrawable(R.drawable.goose), "82", "건태");

            addItem1(getDrawable(R.drawable.ava), "201", "에바");
            addItem1(getDrawable(R.drawable.becky), "207", "아리아");
            addItem1(getDrawable(R.drawable.benedict), "208", "페니실린");
            addItem1(getDrawable(R.drawable.broffina), "223", "히킨");
            addItem1(getDrawable(R.drawable.ken), "290", "오골");
            addItem1(getDrawable(R.drawable.knox), "294", "금끼오");
            addItem1(getDrawable(R.drawable.plucky), "337", "파타야");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.egbert), "61", "Egbert");
            addItem1(getDrawable(R.drawable.goose), "82", "Goose");

            addItem1(getDrawable(R.drawable.ava), "201", "Ava");
            addItem1(getDrawable(R.drawable.becky), "207", "Becky");
            addItem1(getDrawable(R.drawable.benedict), "208", "Benedict");
            addItem1(getDrawable(R.drawable.broffina), "223", "Broffina");
            addItem1(getDrawable(R.drawable.ken), "290", "Ken");
            addItem1(getDrawable(R.drawable.knox), "294", "Knox");
            addItem1(getDrawable(R.drawable.plucky), "337", "Plucky");
        }
    }

    /*Cow 데이터 추가*/
    public void loadCow() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.angus), "6", "반데스");
            addItem1(getDrawable(R.drawable.patty), "125", "밀크");
            addItem1(getDrawable(R.drawable.t_bone), "172", "티본");

            addItem1(getDrawable(R.drawable.coach), "236", "철소");
            addItem1(getDrawable(R.drawable.naomi), "323", "화자");
            addItem1(getDrawable(R.drawable.norma), "325", "미자");
            addItem1(getDrawable(R.drawable.rodeo), "355", "로데오");
            addItem1(getDrawable(R.drawable.stu), "371", "모리스");
            addItem1(getDrawable(R.drawable.tipper), "380", "마틸다");
            addItem1(getDrawable(R.drawable.vic), "387", "노르망");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.angus), "6", "Angus");
            addItem1(getDrawable(R.drawable.patty), "125", "Patty");
            addItem1(getDrawable(R.drawable.t_bone), "172", "T-Bone");

            addItem1(getDrawable(R.drawable.coach), "236", "Coach");
            addItem1(getDrawable(R.drawable.naomi), "323", "Naomi");
            addItem1(getDrawable(R.drawable.norma), "325", "Norma");
            addItem1(getDrawable(R.drawable.rodeo), "355", "Rodeo");
            addItem1(getDrawable(R.drawable.stu), "371", "Stu");
            addItem1(getDrawable(R.drawable.tipper), "380", "Tipper");
            addItem1(getDrawable(R.drawable.vic), "387", "Vic");
        }
    }

    /*Cub 데이터 추가*/
    public void loadCub() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.pekoe), "130", "재스민");
            addItem1(getDrawable(R.drawable.poncho), "139", "봉추");
            addItem1(getDrawable(R.drawable.stitches), "168", "패치");
            addItem1(getDrawable(R.drawable.tammy), "170", "아네사");
            addItem1(getDrawable(R.drawable.vladimir), "184", "곰비");

            addItem1(getDrawable(R.drawable.barold), "204", "곰시");
            addItem1(getDrawable(R.drawable.bluebear), "215", "글루민");
            addItem1(getDrawable(R.drawable.cheri), "230", "아세로라");
            addItem1(getDrawable(R.drawable.chester), "231", "팬타");
            addItem1(getDrawable(R.drawable.judy), "287", "미애");
            addItem1(getDrawable(R.drawable.june), "288", "메이");
            addItem1(getDrawable(R.drawable.kody), "295", "아이다호");
            addItem1(getDrawable(R.drawable.maple), "307", "메이첼");
            addItem1(getDrawable(R.drawable.murphy), "320", "머피");
            addItem1(getDrawable(R.drawable.olive), "327", "올리브");
            addItem1(getDrawable(R.drawable.pudge), "343", "우띠");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.pekoe), "130", "Pekoe");
            addItem1(getDrawable(R.drawable.poncho), "139", "Poncho");
            addItem1(getDrawable(R.drawable.stitches), "168", "Stitches");
            addItem1(getDrawable(R.drawable.tammy), "170", "Tammy");
            addItem1(getDrawable(R.drawable.vladimir), "184", "Vladimir");

            addItem1(getDrawable(R.drawable.barold), "204", "Barold");
            addItem1(getDrawable(R.drawable.bluebear), "215", "Bluebear");
            addItem1(getDrawable(R.drawable.cheri), "230", "Cheri");
            addItem1(getDrawable(R.drawable.chester), "231", "Chester");
            addItem1(getDrawable(R.drawable.judy), "287", "Judy");
            addItem1(getDrawable(R.drawable.june), "288", "June");
            addItem1(getDrawable(R.drawable.kody), "295", "Kody");
            addItem1(getDrawable(R.drawable.maple), "307", "Maple");
            addItem1(getDrawable(R.drawable.murphy), "320", "Murphy");
            addItem1(getDrawable(R.drawable.olive), "327", "Olive");
            addItem1(getDrawable(R.drawable.pudge), "343", "Pudge");
        }
    }

    /*Deer 데이터 추가*/
    public void loadDeer() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.beau), "14", "피터");
            addItem1(getDrawable(R.drawable.deirdre), "54", "나디아");
            addItem1(getDrawable(R.drawable.diana), "55", "나탈리");
            addItem1(getDrawable(R.drawable.erik), "63", "자끄");
            addItem1(getDrawable(R.drawable.fauna), "66", "솔미");
            addItem1(getDrawable(R.drawable.fuchsia), "76", "제시카");
            addItem1(getDrawable(R.drawable.lopez), "107", "톰슨");

            addItem1(getDrawable(R.drawable.bam), "203", "록키");
            addItem1(getDrawable(R.drawable.bruce), "224", "브루스");
            addItem1(getDrawable(R.drawable.chelsea), "229", "첼시");
            addItem1(getDrawable(R.drawable.zell), "395", "넬슨");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.beau), "14", "Beau");
            addItem1(getDrawable(R.drawable.deirdre), "54", "Deirdre");
            addItem1(getDrawable(R.drawable.diana), "55", "Diana");
            addItem1(getDrawable(R.drawable.erik), "63", "Erik");
            addItem1(getDrawable(R.drawable.fauna), "66", "Fauna");
            addItem1(getDrawable(R.drawable.fuchsia), "76", "Fuchsia");
            addItem1(getDrawable(R.drawable.lopez), "107", "Lopez");

            addItem1(getDrawable(R.drawable.bam), "203", "Bam");
            addItem1(getDrawable(R.drawable.bruce), "224", "Bruce");
            addItem1(getDrawable(R.drawable.chelsea), "229", "Chelsea");
            addItem1(getDrawable(R.drawable.zell), "395", "Zell");
        }
    }

    /*Dog 데이터 추가*/
    public void loadDog() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.butch), "28", "존");
            addItem1(getDrawable(R.drawable.cherry), "40", "한나");
            addItem1(getDrawable(R.drawable.goldie), "81", "카라멜");

            addItem1(getDrawable(R.drawable.bea), "205", "베이글");
            addItem1(getDrawable(R.drawable.benjamin), "209", "땡칠이");
            addItem1(getDrawable(R.drawable.biskit), "213", "로빈");
            addItem1(getDrawable(R.drawable.bones), "216", "토미");
            addItem1(getDrawable(R.drawable.cookie), "238", "베리");
            addItem1(getDrawable(R.drawable.daisy), "244", "바닐라");
            addItem1(getDrawable(R.drawable.lucky), "300", "럭키");
            addItem1(getDrawable(R.drawable.mac), "303", "챔프");
            addItem1(getDrawable(R.drawable.maddie), "304", "마롱");
            addItem1(getDrawable(R.drawable.marcel), "308", "에드워드");
            addItem1(getDrawable(R.drawable.portia), "339", "블랜더");
            addItem1(getDrawable(R.drawable.shep), "362", "밥");
            addItem1(getDrawable(R.drawable.walker), "389", "벤");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.butch), "28", "Butch");
            addItem1(getDrawable(R.drawable.cherry), "40", "Cherry");
            addItem1(getDrawable(R.drawable.goldie), "81", "Goldie");

            addItem1(getDrawable(R.drawable.bea), "205", "Bea");
            addItem1(getDrawable(R.drawable.benjamin), "209", "Benjamin");
            addItem1(getDrawable(R.drawable.biskit), "213", "Biskit");
            addItem1(getDrawable(R.drawable.bones), "216", "Bones");
            addItem1(getDrawable(R.drawable.cookie), "238", "Cookie");
            addItem1(getDrawable(R.drawable.daisy), "244", "Daisy");
            addItem1(getDrawable(R.drawable.lucky), "300", "Lucky");
            addItem1(getDrawable(R.drawable.mac), "303", "Mac");
            addItem1(getDrawable(R.drawable.maddie), "304", "Maddie");
            addItem1(getDrawable(R.drawable.marcel), "308", "Marcel");
            addItem1(getDrawable(R.drawable.portia), "339", "Portia");
            addItem1(getDrawable(R.drawable.shep), "362", "Shep");
            addItem1(getDrawable(R.drawable.walker), "389", "Walker");
        }
    }

    /*Duck 데이터 추가*/
    public void loadDuck() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.bill), "19", "코코아");
            addItem1(getDrawable(R.drawable.mallary), "108", "스미모");
            addItem1(getDrawable(R.drawable.molly), "117", "귀오미");

            addItem1(getDrawable(R.drawable.deena), "245", "마리모");
            addItem1(getDrawable(R.drawable.derwin), "248", "봉");
            addItem1(getDrawable(R.drawable.drake), "253", "푸아그라");
            addItem1(getDrawable(R.drawable.freckles), "263", "다랑어");
            addItem1(getDrawable(R.drawable.gloria), "268", "마릴린");
            addItem1(getDrawable(R.drawable.joey), "286", "리처드");
            addItem1(getDrawable(R.drawable.ketchup), "291", "케첩");
            addItem1(getDrawable(R.drawable.maelle), "305", "앤");
            addItem1(getDrawable(R.drawable.miranda), "313", "미란다");
            addItem1(getDrawable(R.drawable.pate), "333", "나키");
            addItem1(getDrawable(R.drawable.pompom), "338", "주디");
            addItem1(getDrawable(R.drawable.quillson), "344", "덕근");
            addItem1(getDrawable(R.drawable.scoot), "361", "지키미");
            addItem1(getDrawable(R.drawable.weber), "392", "아잠만");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.bill), "19", "Bill");
            addItem1(getDrawable(R.drawable.mallary), "108", "Mallary");
            addItem1(getDrawable(R.drawable.molly), "117", "Molly");

            addItem1(getDrawable(R.drawable.deena), "245", "Deena");
            addItem1(getDrawable(R.drawable.derwin), "248", "Derwin");
            addItem1(getDrawable(R.drawable.drake), "253", "Drake");
            addItem1(getDrawable(R.drawable.freckles), "263", "Freckles");
            addItem1(getDrawable(R.drawable.gloria), "268", "Gloria");
            addItem1(getDrawable(R.drawable.joey), "286", "Joey");
            addItem1(getDrawable(R.drawable.ketchup), "291", "Ketchup");
            addItem1(getDrawable(R.drawable.maelle), "305", "Maelle");
            addItem1(getDrawable(R.drawable.miranda), "313", "Miranda");
            addItem1(getDrawable(R.drawable.pate), "333", "Pate");
            addItem1(getDrawable(R.drawable.pompom), "338", "Pompom");
            addItem1(getDrawable(R.drawable.quillson), "344", "Quillson");
            addItem1(getDrawable(R.drawable.scoot), "361", "Scoot");
            addItem1(getDrawable(R.drawable.weber), "392", "Weber");
        }
    }

    /*Eagle 데이터 추가*/
    public void loadEagle() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.amelia), "5", "안데스");
            addItem1(getDrawable(R.drawable.apollo), "8", "아폴로");
            addItem1(getDrawable(R.drawable.avery), "11", "쿠스케처");
            addItem1(getDrawable(R.drawable.buzz), "29", "근엄");
            addItem1(getDrawable(R.drawable.celia), "36", "티파니");
            addItem1(getDrawable(R.drawable.frank), "72", "헐크");
            addItem1(getDrawable(R.drawable.keaton), "96", "프랭크");
            addItem1(getDrawable(R.drawable.pierce), "134", "세바스찬");
            addItem1(getDrawable(R.drawable.sterling), "167", "은수리");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.amelia), "5", "Amelia");
            addItem1(getDrawable(R.drawable.apollo), "8", "Apollo");
            addItem1(getDrawable(R.drawable.avery), "11", "Avery");
            addItem1(getDrawable(R.drawable.buzz), "29", "Buzz");
            addItem1(getDrawable(R.drawable.celia), "36", "Celia");
            addItem1(getDrawable(R.drawable.frank), "72", "Frank");
            addItem1(getDrawable(R.drawable.keaton), "96", "Keaton");
            addItem1(getDrawable(R.drawable.pierce), "134", "Pierce");
            addItem1(getDrawable(R.drawable.sterling), "167", "Sterling");
        }
    }

    /*Elephant 데이터 추가*/
    public void loadElephant() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.dizzy), "56", "휴지");
            addItem1(getDrawable(R.drawable.eloise), "62", "엘레핀");
            addItem1(getDrawable(R.drawable.margie), "109", "샐리");

            addItem1(getDrawable(R.drawable.axel), "202", "엑스엘리");
            addItem1(getDrawable(R.drawable.big_top), "211", "3호");
            addItem1(getDrawable(R.drawable.chai), "228", "피카");
            addItem1(getDrawable(R.drawable.cyd), "242", "펑크스");
            addItem1(getDrawable(R.drawable.ellie), "256", "에끌레르");
            addItem1(getDrawable(R.drawable.opal), "328", "오팔");
            addItem1(getDrawable(R.drawable.paolo), "330", "파올로");
            addItem1(getDrawable(R.drawable.tia), "379", "티나");
            addItem1(getDrawable(R.drawable.tucker), "383", "맘모");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.dizzy), "56", "Dizzy");
            addItem1(getDrawable(R.drawable.eloise), "62", "Eloise");
            addItem1(getDrawable(R.drawable.margie), "109", "Margie");

            addItem1(getDrawable(R.drawable.axel), "202", "Axel");
            addItem1(getDrawable(R.drawable.big_top), "211", "Big Top");
            addItem1(getDrawable(R.drawable.chai), "228", "Chai");
            addItem1(getDrawable(R.drawable.cyd), "242", "Cyd");
            addItem1(getDrawable(R.drawable.ellie), "256", "Ellie");
            addItem1(getDrawable(R.drawable.opal), "328", "Opal");
            addItem1(getDrawable(R.drawable.paolo), "330", "Paolo");
            addItem1(getDrawable(R.drawable.tia), "379", "Tia");
            addItem1(getDrawable(R.drawable.tucker), "383", "Tucker");
        }
    }

    /*Frog 데이터 추가*/
    public void loadFrog() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.drift), "60", "덕");
            addItem1(getDrawable(R.drawable.lily), "104", "레이니");

            addItem1(getDrawable(R.drawable.camofrog), "226", "충성");
            addItem1(getDrawable(R.drawable.cousteau), "239", "왕서방");
            addItem1(getDrawable(R.drawable.croque), "240", "투투");
            addItem1(getDrawable(R.drawable.diva), "249", "아이다");
            addItem1(getDrawable(R.drawable.frobert), "264", "구리구리");
            addItem1(getDrawable(R.drawable.gigi), "267", "린다");
            addItem1(getDrawable(R.drawable.henry), "277", "헨리");
            addItem1(getDrawable(R.drawable.huck), "279", "스트로");
            addItem1(getDrawable(R.drawable.jambette), "284", "에스메랄다");
            addItem1(getDrawable(R.drawable.jeremiah), "285", "드리미");
            addItem1(getDrawable(R.drawable.prince), "340", "카일");
            addItem1(getDrawable(R.drawable.puddles), "342", "가위");
            addItem1(getDrawable(R.drawable.raddle), "345", "개군");
            addItem1(getDrawable(R.drawable.ribbot), "350", "철컥");
            addItem1(getDrawable(R.drawable.tad), "375", "텀보");
            addItem1(getDrawable(R.drawable.wart_jr), "391", "샘");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.drift), "60", "Drift");
            addItem1(getDrawable(R.drawable.lily), "104", "Lily");

            addItem1(getDrawable(R.drawable.camofrog), "226", "Camofrog");
            addItem1(getDrawable(R.drawable.cousteau), "239", "Cousteau");
            addItem1(getDrawable(R.drawable.croque), "240", "Croque");
            addItem1(getDrawable(R.drawable.diva), "249", "Diva");
            addItem1(getDrawable(R.drawable.frobert), "264", "Frobert");
            addItem1(getDrawable(R.drawable.gigi), "267", "Gigi");
            addItem1(getDrawable(R.drawable.henry), "277", "Henry");
            addItem1(getDrawable(R.drawable.huck), "279", "Huck");
            addItem1(getDrawable(R.drawable.jambette), "284", "Jambette");
            addItem1(getDrawable(R.drawable.jeremiah), "285", "Jeremiah");
            addItem1(getDrawable(R.drawable.prince), "340", "Prince");
            addItem1(getDrawable(R.drawable.puddles), "342", "Puddles");
            addItem1(getDrawable(R.drawable.raddle), "345", "Raddle");
            addItem1(getDrawable(R.drawable.ribbot), "350", "Ribbot");
            addItem1(getDrawable(R.drawable.tad), "375", "Tad");
            addItem1(getDrawable(R.drawable.wart_jr), "391", "Wart Jr.");
        }
    }

    /*Goat 데이터 추가*/
    public void loadGoat() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.chevre), "41", "윤이");

            addItem1(getDrawable(R.drawable.billy), "212", "힘드러");
            addItem1(getDrawable(R.drawable.gruff), "273", "빌리");
            addItem1(getDrawable(R.drawable.kidd), "292", "염두리");
            addItem1(getDrawable(R.drawable.nan), "321", "순이");
            addItem1(getDrawable(R.drawable.pashmina), "332", "바바라");
            addItem1(getDrawable(R.drawable.sherb), "363", "래미");
            addItem1(getDrawable(R.drawable.velma), "386", "벨마");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.chevre), "41", "Chevre");

            addItem1(getDrawable(R.drawable.billy), "212", "Billy");
            addItem1(getDrawable(R.drawable.gruff), "273", "Gruff");
            addItem1(getDrawable(R.drawable.kidd), "292", "Kidd");
            addItem1(getDrawable(R.drawable.nan), "321", "Nan");
            addItem1(getDrawable(R.drawable.pashmina), "332", "Pashmina");
            addItem1(getDrawable(R.drawable.sherb), "363", "Sherb");
            addItem1(getDrawable(R.drawable.velma), "386", "Velma");
        }
    }

    /*Gorilla 데이터 추가*/
    public void loadGorilla() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.cesar), "37", "앨런");
            addItem1(getDrawable(R.drawable.hans), "85", "스나일");
            addItem1(getDrawable(R.drawable.peewee), "129", "덤벨");
            addItem1(getDrawable(R.drawable.violet), "182", "줌마");

            addItem1(getDrawable(R.drawable.al), "191", "우락");
            addItem1(getDrawable(R.drawable.boone), "218", "만복이");
            addItem1(getDrawable(R.drawable.boyd), "221", "보이드");
            addItem1(getDrawable(R.drawable.louie), "298", "머슬");
            addItem1(getDrawable(R.drawable.rilla), "351", "릴라");
            addItem1(getDrawable(R.drawable.rocket), "354", "4호");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.cesar), "37", "Cesar");
            addItem1(getDrawable(R.drawable.hans), "85", "Hans");
            addItem1(getDrawable(R.drawable.peewee), "129", "Peewee");
            addItem1(getDrawable(R.drawable.violet), "182", "Violet");

            addItem1(getDrawable(R.drawable.al), "191", "Al");
            addItem1(getDrawable(R.drawable.boone), "218", "Boone");
            addItem1(getDrawable(R.drawable.boyd), "221", "Boyd");
            addItem1(getDrawable(R.drawable.louie), "298", "Louie");
            addItem1(getDrawable(R.drawable.rilla), "351", "Rilla");
            addItem1(getDrawable(R.drawable.rocket), "354", "Rocket");
        }
    }

    /*Hamster 데이터 추가*/
    public void loadHamster() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.apple), "9", "애플");
            addItem1(getDrawable(R.drawable.flurry), "70", "뽀야미");
            addItem1(getDrawable(R.drawable.hamlet), "84", "햄스틴");
            addItem1(getDrawable(R.drawable.rodney), "150", "지미");

            addItem1(getDrawable(R.drawable.clay), "233", "햄둥");
            addItem1(getDrawable(R.drawable.graham), "270", "글라햄");
            addItem1(getDrawable(R.drawable.hamphrey), "275", "햄쥐");
            addItem1(getDrawable(R.drawable.soleil), "366", "샨티");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.apple), "9", "Apple");
            addItem1(getDrawable(R.drawable.flurry), "70", "Flurry");
            addItem1(getDrawable(R.drawable.hamlet), "84", "Hamlet");
            addItem1(getDrawable(R.drawable.rodney), "150", "Rodney");

            addItem1(getDrawable(R.drawable.clay), "233", "Clay");
            addItem1(getDrawable(R.drawable.graham), "270", "Graham");
            addItem1(getDrawable(R.drawable.hamphrey), "275", "Hamphrey");
            addItem1(getDrawable(R.drawable.soleil), "366", "Soleil");
        }
    }

    /*Hippo 데이터 추가*/
    public void loadHippo() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.bertha), "16", "베티");
            addItem1(getDrawable(R.drawable.rocco), "148", "곤잘레스");

            addItem1(getDrawable(R.drawable.biff), "210", "가브리엘");
            addItem1(getDrawable(R.drawable.bitty), "214", "비티");
            addItem1(getDrawable(R.drawable.bubbles), "225", "차코");
            addItem1(getDrawable(R.drawable.harry), "276", "올리버");
            addItem1(getDrawable(R.drawable.hippeux), "278", "데이빗");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.bertha), "16", "Bertha");
            addItem1(getDrawable(R.drawable.rocco), "148", "Rocco");

            addItem1(getDrawable(R.drawable.biff), "210", "Biff");
            addItem1(getDrawable(R.drawable.bitty), "214", "Bitty");
            addItem1(getDrawable(R.drawable.bubbles), "225", "Bubbles");
            addItem1(getDrawable(R.drawable.harry), "276", "Harry");
            addItem1(getDrawable(R.drawable.hippeux), "278", "Hippeux");
        }
    }

    /*Horse 데이터 추가*/
    public void loadHorse() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.buck), "25", "바야시코프");
            addItem1(getDrawable(R.drawable.colton), "49", "안소니");
            addItem1(getDrawable(R.drawable.julian), "94", "유니오");
            addItem1(getDrawable(R.drawable.peaches), "126", "말자");
            addItem1(getDrawable(R.drawable.roscoe), "152", "슈베르트");
            addItem1(getDrawable(R.drawable.victoria), "181", "센트엘로");

            addItem1(getDrawable(R.drawable.annalise), "198", "실부플레");
            addItem1(getDrawable(R.drawable.cleo), "234", "아이소토프");
            addItem1(getDrawable(R.drawable.clyde), "235", "마철이");
            addItem1(getDrawable(R.drawable.ed), "254", "꺼벙");
            addItem1(getDrawable(R.drawable.elmer), "257", "샤브렌");
            addItem1(getDrawable(R.drawable.papi), "331", "마사마");
            addItem1(getDrawable(R.drawable.reneigh), "348", "리아나");
            addItem1(getDrawable(R.drawable.savannah), "360", "사반나");
            addItem1(getDrawable(R.drawable.winnie), "393", "카로틴");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.buck), "25", "Buck");
            addItem1(getDrawable(R.drawable.colton), "49", "Colton");
            addItem1(getDrawable(R.drawable.julian), "94", "Julian");
            addItem1(getDrawable(R.drawable.peaches), "126", "Peaches");
            addItem1(getDrawable(R.drawable.roscoe), "152", "Roscoe");
            addItem1(getDrawable(R.drawable.victoria), "181", "Victoria");

            addItem1(getDrawable(R.drawable.annalise), "198", "Annalise");
            addItem1(getDrawable(R.drawable.cleo), "234", "Cleo");
            addItem1(getDrawable(R.drawable.clyde), "235", "Clyde");
            addItem1(getDrawable(R.drawable.ed), "254", "Ed");
            addItem1(getDrawable(R.drawable.elmer), "257", "Elmer");
            addItem1(getDrawable(R.drawable.papi), "331", "Papi");
            addItem1(getDrawable(R.drawable.reneigh), "348", "Reneigh");
            addItem1(getDrawable(R.drawable.savannah), "360", "Savannah");
            addItem1(getDrawable(R.drawable.winnie), "393", "Winnie");
        }
    }

    /*Kangaroo 데이터 추가*/
    public void loadKangaroo() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.carrie), "34", "마미");
            addItem1(getDrawable(R.drawable.kitt), "100", "애플리케");

            addItem1(getDrawable(R.drawable.astrid), "199", "펑키맘");
            addItem1(getDrawable(R.drawable.marcie), "309", "마리아");
            addItem1(getDrawable(R.drawable.mathilda), "310", "안젤라");
            addItem1(getDrawable(R.drawable.rooney), "356", "마이크");
            addItem1(getDrawable(R.drawable.sylvia), "373", "실비아");
            addItem1(getDrawable(R.drawable.walt), "390", "관록");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.carrie), "34", "Carrie");
            addItem1(getDrawable(R.drawable.kitt), "100", "Kitt");

            addItem1(getDrawable(R.drawable.astrid), "199", "Astrid");
            addItem1(getDrawable(R.drawable.marcie), "309", "Marcie");
            addItem1(getDrawable(R.drawable.mathilda), "310", "Mathilda");
            addItem1(getDrawable(R.drawable.rooney), "356", "Rooney");
            addItem1(getDrawable(R.drawable.sylvia), "373", "Sylvia");
            addItem1(getDrawable(R.drawable.walt), "390", "Walt");
        }
    }

    /*Koala 데이터 추가*/
    public void loadKoala() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.canberra), "31", "캔버라");
            addItem1(getDrawable(R.drawable.melba), "112", "아델레이드");
            addItem1(getDrawable(R.drawable.ozzie), "123", "동동이");

            addItem1(getDrawable(R.drawable.alice), "192", "멜버른");
            addItem1(getDrawable(R.drawable.eugene), "260", "코알");
            addItem1(getDrawable(R.drawable.gonzo), "269", "근성");
            addItem1(getDrawable(R.drawable.lyman), "302", "오즈먼드");
            addItem1(getDrawable(R.drawable.sydney), "372", "시드니");
            addItem1(getDrawable(R.drawable.yuka), "394", "유카리");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.canberra), "31", "Canberra");
            addItem1(getDrawable(R.drawable.melba), "112", "Melba");
            addItem1(getDrawable(R.drawable.ozzie), "123", "Ozzie");

            addItem1(getDrawable(R.drawable.alice), "192", "Alice");
            addItem1(getDrawable(R.drawable.eugene), "260", "Eugene");
            addItem1(getDrawable(R.drawable.gonzo), "269", "Gonzo");
            addItem1(getDrawable(R.drawable.lyman), "302", "Lyman");
            addItem1(getDrawable(R.drawable.sydney), "372", "Sydney");
            addItem1(getDrawable(R.drawable.yuka), "394", "Yuka");
        }
    }

    /*Lion 데이터 추가*/
    public void loadLion() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.bud), "26", "선글");

            addItem1(getDrawable(R.drawable.elvis), "258", "킹");
            addItem1(getDrawable(R.drawable.lionel), "297", "라이오넬");
            addItem1(getDrawable(R.drawable.mott), "319", "릭");
            addItem1(getDrawable(R.drawable.rex), "349", "렉스");
            addItem1(getDrawable(R.drawable.rory), "357", "아더");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.bud), "26", "Bud");

            addItem1(getDrawable(R.drawable.elvis), "258", "Elvis");
            addItem1(getDrawable(R.drawable.lionel), "297", "Lionel");
            addItem1(getDrawable(R.drawable.mott), "319", "Mott");
            addItem1(getDrawable(R.drawable.rex), "349", "Rex");
            addItem1(getDrawable(R.drawable.rory), "357", "Rory");
        }
    }

    /*Monkey 데이터 추가*/
    public void loadMonkey() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.flip), "68", "원승");
            addItem1(getDrawable(R.drawable.shari), "158", "젤리");

            addItem1(getDrawable(R.drawable.deli), "247", "델리");
            addItem1(getDrawable(R.drawable.elise), "255", "몽자");
            addItem1(getDrawable(R.drawable.monty), "317", "몽티");
            addItem1(getDrawable(R.drawable.nana), "322", "키키");
            addItem1(getDrawable(R.drawable.simon), "364", "시몬");
            addItem1(getDrawable(R.drawable.tammi), "376", "에이프릴");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.flip), "68", "Flip");
            addItem1(getDrawable(R.drawable.shari), "158", "Shari");

            addItem1(getDrawable(R.drawable.deli), "247", "Deli");
            addItem1(getDrawable(R.drawable.elise), "255", "Elise");
            addItem1(getDrawable(R.drawable.monty), "317", "Monty");
            addItem1(getDrawable(R.drawable.nana), "322", "Nana");
            addItem1(getDrawable(R.drawable.simon), "364", "Simon");
            addItem1(getDrawable(R.drawable.tammi), "376", "Tammi");
        }
    }

    /*Mouse 데이터 추가*/
    public void loadMouse() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.bella), "15", "이자벨");
            addItem1(getDrawable(R.drawable.bettina), "17", "마르카");
            addItem1(getDrawable(R.drawable.bree), "24", "사라");
            addItem1(getDrawable(R.drawable.chadder), "38", "치즈");
            addItem1(getDrawable(R.drawable.greta), "83", "복자");
            addItem1(getDrawable(R.drawable.penelope), "131", "찍순이");
            addItem1(getDrawable(R.drawable.rod), "149", "쟝");

            addItem1(getDrawable(R.drawable.anicotti), "195", "리자냐");
            addItem1(getDrawable(R.drawable.broccolo), "222", "브로콜리");
            addItem1(getDrawable(R.drawable.candi), "227", "사탕");
            addItem1(getDrawable(R.drawable.dora), "251", "티미");
            addItem1(getDrawable(R.drawable.limberg), "296", "단무지");
            addItem1(getDrawable(R.drawable.moose), "318", "핑");
            addItem1(getDrawable(R.drawable.rizzo), "352", "조르직");
            addItem1(getDrawable(R.drawable.samson), "359", "피스");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.bella), "15", "Bella");
            addItem1(getDrawable(R.drawable.bettina), "17", "Bettina");
            addItem1(getDrawable(R.drawable.bree), "24", "Bree");
            addItem1(getDrawable(R.drawable.chadder), "38", "Chadder");
            addItem1(getDrawable(R.drawable.greta), "83", "Greta");
            addItem1(getDrawable(R.drawable.penelope), "131", "Penelope");
            addItem1(getDrawable(R.drawable.rod), "149", "Rod");

            addItem1(getDrawable(R.drawable.anicotti), "195", "Anicotti");
            addItem1(getDrawable(R.drawable.broccolo), "222", "Broccolo");
            addItem1(getDrawable(R.drawable.candi), "227", "Candi");
            addItem1(getDrawable(R.drawable.dora), "251", "Dora");
            addItem1(getDrawable(R.drawable.limberg), "296", "Limberg");
            addItem1(getDrawable(R.drawable.moose), "318", "Moose");
            addItem1(getDrawable(R.drawable.rizzo), "352", "Rizzo");
            addItem1(getDrawable(R.drawable.samson), "359", "Samson");
        }
    }

    /*Octopus 데이터 추가*/
    public void loadOctopus() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.marina), "110", "문리나");
            addItem1(getDrawable(R.drawable.octavian), "120", "문복");
            addItem1(getDrawable(R.drawable.zucher), "189", "탁호");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.marina), "110", "Marina");
            addItem1(getDrawable(R.drawable.octavian), "120", "Octavian");
            addItem1(getDrawable(R.drawable.zucher), "189", "Zucher");
        }
    }

    /*Ostrich 데이터 추가*/
    public void loadOstrich() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.blanche), "21", "신옥");
            addItem1(getDrawable(R.drawable.cranston), "50", "타키");
            addItem1(getDrawable(R.drawable.flora), "69", "플라라");
            addItem1(getDrawable(R.drawable.gladys), "80", "빅토리아");
            addItem1(getDrawable(R.drawable.julia), "93", "줄리아");
            addItem1(getDrawable(R.drawable.phil), "132", "케인");
            addItem1(getDrawable(R.drawable.phoebe), "133", "휘니");
            addItem1(getDrawable(R.drawable.queenie), "143", "택주");
            addItem1(getDrawable(R.drawable.sandy), "157", "샌디");
            addItem1(getDrawable(R.drawable.sprocket), "164", "헤르츠");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.blanche), "21", "Blanche");
            addItem1(getDrawable(R.drawable.cranston), "50", "Cranston");
            addItem1(getDrawable(R.drawable.flora), "69", "Flora");
            addItem1(getDrawable(R.drawable.gladys), "80", "Gladys");
            addItem1(getDrawable(R.drawable.julia), "93", "Julia");
            addItem1(getDrawable(R.drawable.phil), "132", "Phil");
            addItem1(getDrawable(R.drawable.phoebe), "133", "Phoebe");
            addItem1(getDrawable(R.drawable.queenie), "143", "Queenie");
            addItem1(getDrawable(R.drawable.sandy), "157", "Sandy");
            addItem1(getDrawable(R.drawable.sprocket), "164", "Sprocket");
        }
    }

    /*Penguin 데이터 추가*/
    public void loadPenguin() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.aurora), "10", "오로라");
            addItem1(getDrawable(R.drawable.cube), "51", "빙수");
            addItem1(getDrawable(R.drawable.friga), "74", "사브리나");
            addItem1(getDrawable(R.drawable.hopper), "88", "달만이");
            addItem1(getDrawable(R.drawable.iggly), "90", "김말이");
            addItem1(getDrawable(R.drawable.roald), "147", "펭수");

            addItem1(getDrawable(R.drawable.boomer), "217", "팽기");
            addItem1(getDrawable(R.drawable.flo), "262", "레이라");
            addItem1(getDrawable(R.drawable.gwen), "274", "폴라");
            addItem1(getDrawable(R.drawable.puck), "341", "하키");
            addItem1(getDrawable(R.drawable.sprinkle), "369", "크리미");
            addItem1(getDrawable(R.drawable.tex), "378", "볼트");
            addItem1(getDrawable(R.drawable.wade), "388", "호떡");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.aurora), "10", "Aurora");
            addItem1(getDrawable(R.drawable.cube), "51", "Cube");
            addItem1(getDrawable(R.drawable.friga), "74", "Friga");
            addItem1(getDrawable(R.drawable.hopper), "88", "Hopper");
            addItem1(getDrawable(R.drawable.iggly), "90", "Iggly");
            addItem1(getDrawable(R.drawable.roald), "147", "Roald");

            addItem1(getDrawable(R.drawable.boomer), "217", "Boomer");
            addItem1(getDrawable(R.drawable.flo), "262", "Flo");
            addItem1(getDrawable(R.drawable.gwen), "274", "Gwen");
            addItem1(getDrawable(R.drawable.puck), "341", "Puck");
            addItem1(getDrawable(R.drawable.sprinkle), "369", "Sprinkle");
            addItem1(getDrawable(R.drawable.tex), "378", "Tex");
            addItem1(getDrawable(R.drawable.wade), "388", "Wade");
        }
    }

    /*Pig 데이터 추가*/
    public void loadPig() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.agnes), "2", "아그네스");
            addItem1(getDrawable(R.drawable.chops), "43", "돈후앙");
            addItem1(getDrawable(R.drawable.kevin), "97", "멧지");
            addItem1(getDrawable(R.drawable.pancetti), "124", "브리트니");
            addItem1(getDrawable(R.drawable.truffles), "177", "탱고");

            addItem1(getDrawable(R.drawable.boris), "220", "보리");
            addItem1(getDrawable(R.drawable.cobb), "237", "박사");
            addItem1(getDrawable(R.drawable.curly), "241", "햄까스");
            addItem1(getDrawable(R.drawable.gala), "265", "꽃지");
            addItem1(getDrawable(R.drawable.hugh), "280", "먹고파");
            addItem1(getDrawable(R.drawable.lucy), "301", "루시");
            addItem1(getDrawable(R.drawable.maggie), "306", "마가렛");
            addItem1(getDrawable(R.drawable.peggy), "336", "체리");
            addItem1(getDrawable(R.drawable.rasher), "346", "글레이");
            addItem1(getDrawable(R.drawable.spork), "368", "포크");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.agnes), "2", "Agnes");
            addItem1(getDrawable(R.drawable.chops), "43", "Chops");
            addItem1(getDrawable(R.drawable.kevin), "97", "Kevin");
            addItem1(getDrawable(R.drawable.pancetti), "124", "Pancetti");
            addItem1(getDrawable(R.drawable.truffles), "177", "Truffles");

            addItem1(getDrawable(R.drawable.boris), "220", "Boris");
            addItem1(getDrawable(R.drawable.cobb), "237", "Cobb");
            addItem1(getDrawable(R.drawable.curly), "241", "Curly");
            addItem1(getDrawable(R.drawable.gala), "265", "Gala");
            addItem1(getDrawable(R.drawable.hugh), "280", "Hugh");
            addItem1(getDrawable(R.drawable.lucy), "301", "Lucy");
            addItem1(getDrawable(R.drawable.maggie), "306", "Maggie");
            addItem1(getDrawable(R.drawable.peggy), "336", "Peggy");
            addItem1(getDrawable(R.drawable.rasher), "346", "Rasher");
            addItem1(getDrawable(R.drawable.spork), "368", "Spork");
        }
    }

    /*Rabbit 데이터 추가*/
    public void loadRabbit() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.bonbon), "23", "미미");
            addItem1(getDrawable(R.drawable.bunnie), "27", "릴리안");
            addItem1(getDrawable(R.drawable.carmen), "32", "초코");
            addItem1(getDrawable(R.drawable.chrissy), "44", "크리스틴");
            addItem1(getDrawable(R.drawable.claude), "45", "비니거");
            addItem1(getDrawable(R.drawable.coco), "47", "이요");
            addItem1(getDrawable(R.drawable.cole), "48", "아마민");
            addItem1(getDrawable(R.drawable.doc), "58", "토니");
            addItem1(getDrawable(R.drawable.dotty), "59", "서머");
            addItem1(getDrawable(R.drawable.francine), "71", "프랑소와");
            addItem1(getDrawable(R.drawable.gabi), "77", "패티카");
            addItem1(getDrawable(R.drawable.gaston), "78", "대길");
            addItem1(getDrawable(R.drawable.genji), "79", "토시");
            addItem1(getDrawable(R.drawable.hopkins), "87", "홉킨스");
            addItem1(getDrawable(R.drawable.mira), "116", "미랑");
            addItem1(getDrawable(R.drawable.o_hare), "121", "산토스");
            addItem1(getDrawable(R.drawable.pippy), "138", "로타");
            addItem1(getDrawable(R.drawable.ruby), "155", "루나");
            addItem1(getDrawable(R.drawable.snake), "162", "닌토");
            addItem1(getDrawable(R.drawable.tiffany), "175", "바슬레");

            addItem1(getDrawable(R.drawable.toby), "381", "토비");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.bonbon), "23", "Bonbon");
            addItem1(getDrawable(R.drawable.bunnie), "27", "Bunnie");
            addItem1(getDrawable(R.drawable.carmen), "32", "Carmen");
            addItem1(getDrawable(R.drawable.chrissy), "44", "Chrissy");
            addItem1(getDrawable(R.drawable.claude), "45", "Claude");
            addItem1(getDrawable(R.drawable.coco), "47", "Coco");
            addItem1(getDrawable(R.drawable.cole), "48", "Cole");
            addItem1(getDrawable(R.drawable.doc), "58", "Doc");
            addItem1(getDrawable(R.drawable.dotty), "59", "Dotty");
            addItem1(getDrawable(R.drawable.francine), "71", "Francine");
            addItem1(getDrawable(R.drawable.gabi), "77", "Gabi");
            addItem1(getDrawable(R.drawable.gaston), "78", "Gaston");
            addItem1(getDrawable(R.drawable.genji), "79", "Genji");
            addItem1(getDrawable(R.drawable.hopkins), "87", "Hopkins");
            addItem1(getDrawable(R.drawable.mira), "116", "Mira");
            addItem1(getDrawable(R.drawable.o_hare), "121", "O'Hare");
            addItem1(getDrawable(R.drawable.pippy), "138", "Pippy");
            addItem1(getDrawable(R.drawable.ruby), "155", "Ruby");
            addItem1(getDrawable(R.drawable.snake), "162", "Snake");
            addItem1(getDrawable(R.drawable.tiffany), "175", "Tiffany");

            addItem1(getDrawable(R.drawable.toby), "381", "Toby");
        }
    }

    /*Rhino 데이터 추가*/
    public void loadRhino() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.hornsby), "89", "뿌람");
            addItem1(getDrawable(R.drawable.merengue), "113", "스트로베리");
            addItem1(getDrawable(R.drawable.renee), "144", "뿔님이");
            addItem1(getDrawable(R.drawable.rhonda), "145", "론다");
            addItem1(getDrawable(R.drawable.spike), "163", "스쿼트");
            addItem1(getDrawable(R.drawable.tank), "171", "탱크");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.hornsby), "89", "Hornsby");
            addItem1(getDrawable(R.drawable.merengue), "113", "Merengue");
            addItem1(getDrawable(R.drawable.renee), "144", "Renée");
            addItem1(getDrawable(R.drawable.rhonda), "145", "Rhonda");
            addItem1(getDrawable(R.drawable.spike), "163", "Spike");
            addItem1(getDrawable(R.drawable.tank), "171", "Tank");
        }
    }

    /*Sheep 데이터 추가*/
    public void loadSheep() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.baabara), "12", "트로와");
            addItem1(getDrawable(R.drawable.cashmere), "35", "캐시미어");
            addItem1(getDrawable(R.drawable.curlos), "52", "카를로스");
            addItem1(getDrawable(R.drawable.eunice), "64", "곱슬이");
            addItem1(getDrawable(R.drawable.frita), "75", "웬디");
            addItem1(getDrawable(R.drawable.muffy), "118", "프릴");
            addItem1(getDrawable(R.drawable.pietro), "135", "피엘");
            addItem1(getDrawable(R.drawable.stella), "166", "아크릴");
            addItem1(getDrawable(R.drawable.timbra), "176", "잔디");
            addItem1(getDrawable(R.drawable.vesta), "180", "메리어스");
            addItem1(getDrawable(R.drawable.wendy), "185", "눈송이");
            addItem1(getDrawable(R.drawable.willow), "187", "마리");

            addItem1(getDrawable(R.drawable.dom), "250", "차둘");
            addItem1(getDrawable(R.drawable.etoile), "259", "에뜨와르");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.baabara), "12", "Baabara");
            addItem1(getDrawable(R.drawable.cashmere), "35", "Cashmere");
            addItem1(getDrawable(R.drawable.curlos), "52", "Curlos");
            addItem1(getDrawable(R.drawable.eunice), "64", "Eunice");
            addItem1(getDrawable(R.drawable.frita), "75", "Frita");
            addItem1(getDrawable(R.drawable.muffy), "118", "Muffy");
            addItem1(getDrawable(R.drawable.pietro), "135", "Pietro");
            addItem1(getDrawable(R.drawable.stella), "166", "Stella");
            addItem1(getDrawable(R.drawable.timbra), "176", "Timbra");
            addItem1(getDrawable(R.drawable.vesta), "180", "Vesta");
            addItem1(getDrawable(R.drawable.wendy), "185", "Wendy");
            addItem1(getDrawable(R.drawable.willow), "187", "Willow");

            addItem1(getDrawable(R.drawable.dom), "250", "Dom");
            addItem1(getDrawable(R.drawable.etoile), "259", "Étoile");
        }
    }

    /*Squirrel 데이터 추가*/
    public void loadSquirrel() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.agent_s), "1", "2호");
            addItem1(getDrawable(R.drawable.blaire), "20", "실루엣");
            addItem1(getDrawable(R.drawable.cally), "30", "파슬리");
            addItem1(getDrawable(R.drawable.caroline), "33", "캐롤라인");
            addItem1(getDrawable(R.drawable.filbert), "67", "리키");
            addItem1(getDrawable(R.drawable.hazel), "86", "아이리스");
            addItem1(getDrawable(R.drawable.marshal), "111", "쭈니");
            addItem1(getDrawable(R.drawable.mint), "115", "민트");
            addItem1(getDrawable(R.drawable.nibbles), "119", "그리미");
            addItem1(getDrawable(R.drawable.peanut), "127", "핑키");
            addItem1(getDrawable(R.drawable.pecan), "128", "레베카");
            addItem1(getDrawable(R.drawable.poppy), "140", "다람");
            addItem1(getDrawable(R.drawable.ricky), "146", "갈가리");
            addItem1(getDrawable(R.drawable.sally), "156", "라라미");
            addItem1(getDrawable(R.drawable.sheldon), "159", "크리스");
            addItem1(getDrawable(R.drawable.static_), "165", "스파크");
            addItem1(getDrawable(R.drawable.sylvana), "169", "실바나");
            addItem1(getDrawable(R.drawable.tasha), "173", "나타샤");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.agent_s), "1", "Agent S");
            addItem1(getDrawable(R.drawable.blaire), "20", "Blaire");
            addItem1(getDrawable(R.drawable.cally), "30", "Cally");
            addItem1(getDrawable(R.drawable.caroline), "33", "Caroline");
            addItem1(getDrawable(R.drawable.filbert), "67", "Filbert");
            addItem1(getDrawable(R.drawable.hazel), "86", "Hazel");
            addItem1(getDrawable(R.drawable.marshal), "111", "Marshal");
            addItem1(getDrawable(R.drawable.mint), "115", "Mint");
            addItem1(getDrawable(R.drawable.nibbles), "119", "Nibbles");
            addItem1(getDrawable(R.drawable.peanut), "127", "Peanut");
            addItem1(getDrawable(R.drawable.pecan), "128", "Pecan");
            addItem1(getDrawable(R.drawable.poppy), "140", "Poppy");
            addItem1(getDrawable(R.drawable.ricky), "146", "Ricky");
            addItem1(getDrawable(R.drawable.sally), "156", "Sally");
            addItem1(getDrawable(R.drawable.sheldon), "159", "Sheldon");
            addItem1(getDrawable(R.drawable.static_), "165", "Static");
            addItem1(getDrawable(R.drawable.sylvana), "169", "Sylvana");
            addItem1(getDrawable(R.drawable.tasha), "173", "Tasha");
        }
    }

    /*Tiger 데이터 추가*/
    public void loadTiger() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.bangle), "13", "루주");
            addItem1(getDrawable(R.drawable.bianca), "18", "백희");
            addItem1(getDrawable(R.drawable.claudia), "46", "신디");
            addItem1(getDrawable(R.drawable.leonardo), "103", "범호");
            addItem1(getDrawable(R.drawable.rolf), "151", "호랭이");
            addItem1(getDrawable(R.drawable.rowan), "154", "고메스");
            addItem1(getDrawable(R.drawable.tybalt), "179", "티볼트");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.bangle), "13", "Bangle");
            addItem1(getDrawable(R.drawable.bianca), "18", "Bianca");
            addItem1(getDrawable(R.drawable.claudia), "46", "Claudia");
            addItem1(getDrawable(R.drawable.leonardo), "103", "Leonardo");
            addItem1(getDrawable(R.drawable.rolf), "151", "Rolf");
            addItem1(getDrawable(R.drawable.rowan), "154", "Rowan");
            addItem1(getDrawable(R.drawable.tybalt), "179", "Tybalt");
        }
    }

    /*Wolf 데이터 추가*/
    public void loadWolf() {
        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            addItem1(getDrawable(R.drawable.chief), "42", "대장");
            addItem1(getDrawable(R.drawable.dobie), "57", "켄");
            addItem1(getDrawable(R.drawable.fang), "65", "시베리아");
            addItem1(getDrawable(R.drawable.freya), "73", "신드라");
            addItem1(getDrawable(R.drawable.kyle), "102", "리카르도");
            addItem1(getDrawable(R.drawable.lobo), "105", "늑태");
            addItem1(getDrawable(R.drawable.skye), "160", "릴리");
            addItem1(getDrawable(R.drawable.vivian), "183", "바네사");
            addItem1(getDrawable(R.drawable.whitney), "186", "비앙카");
            addItem1(getDrawable(R.drawable.wolfgang), "188", "로보");

            addItem1(getDrawable(R.drawable.audie), "200", "모니카");
        } else {
            //default 영어
            addItem1(getDrawable(R.drawable.chief), "42", "Chief");
            addItem1(getDrawable(R.drawable.dobie), "57", "Dobie");
            addItem1(getDrawable(R.drawable.fang), "65", "Fang");
            addItem1(getDrawable(R.drawable.freya), "73", "Freya");
            addItem1(getDrawable(R.drawable.kyle), "102", "Kyle");
            addItem1(getDrawable(R.drawable.lobo), "105", "Lobo");
            addItem1(getDrawable(R.drawable.skye), "160", "Skye");
            addItem1(getDrawable(R.drawable.vivian), "183", "Vivian");
            addItem1(getDrawable(R.drawable.whitney), "186", "Whitney");
            addItem1(getDrawable(R.drawable.wolfgang), "188", "Wolfgang");

            addItem1(getDrawable(R.drawable.audie), "200", "Audie");
        }
    }
}
