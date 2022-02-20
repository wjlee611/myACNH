package com.gmail.com.wjlee611.acnh;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Locale;

public class ShActivity extends Activity {

    RecyclerView mRecyclerViewSh = null;
    VillRecyclerImageTextAdapter mAdapterSh = null;
    ArrayList<RecyclerVillItem> mListSh = new ArrayList<RecyclerVillItem>();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.screenshot_vill);

        ImageView sh_image = (ImageView) findViewById(R.id.sh_image);
        TextView sh_tv_name = (TextView) findViewById(R.id.sh_tv_name);
        TextView sh_tv_address = (TextView) findViewById(R.id.sh_tv_address);
        TextView sh_tv_fruit = (TextView) findViewById(R.id.sh_tv_fruit);
        TextView sh_tv_resident = (TextView) findViewById(R.id.sh_tv_resident);
        TextView sh_isN = (TextView) findViewById(R.id.sh_isN);
        TextView sh_isS = (TextView) findViewById(R.id.sh_isS);


        Intent intent = getIntent();
        int curIsland = intent.getIntExtra("curIsland", 1);
        sh_tv_name.setText(intent.getStringExtra("iName"));
        sh_tv_address.setText(intent.getStringExtra("iAddress"));
        sh_tv_fruit.setText(intent.getStringExtra("iFruit"));
        sh_tv_resident.setText(intent.getStringExtra("iResident"));
        if (intent.getIntExtra("hemisphere", -1) == 0) {
            sh_isN.setVisibility(View.VISIBLE);
        } else if (intent.getIntExtra("hemisphere", -1) == 1) {
            sh_isS.setVisibility(View.VISIBLE);
        }

        try {
            Bitmap bm = BitmapFactory.decodeFile("data/data/com.gmail.com.wjlee611.acnh/files/canh_title" + curIsland + ".png");
            sh_image.setImageBitmap(bm);

            bm = null;
        } catch (Exception e) {
            e.printStackTrace();
            Snackbar.make(findViewById(android.R.id.content), e.getMessage(), Snackbar.LENGTH_SHORT).show();
        }


        int numResident_sh = intent.getIntExtra("numResident", 0);
        int[] ResidentList_sh = intent.getIntArrayExtra("ResidentList");

        mRecyclerViewSh = findViewById(R.id.sh_recyclerView);

        mAdapterSh = new VillRecyclerImageTextAdapter(mListSh);
        mRecyclerViewSh.setAdapter(mAdapterSh);

        mRecyclerViewSh.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        if (Locale.getDefault().getLanguage().equals("ko")) {
            //한국어
            for (int i=0; i<numResident_sh; i++) {
                switch (ResidentList_sh[i]) {
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
            for (int i=0; i<numResident_sh; i++) {
                switch (ResidentList_sh[i]) {
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
        mAdapterSh.notifyDataSetChanged();

    }


    @Override
    public void onBackPressed() {
        mListSh.clear();

        mRecyclerViewSh = null;
        mAdapterSh = null;
        mListSh = null;

        finish();
        super.onDestroy();
        //super.onBackPressed();
    }


    public void addItem2(Drawable icon, String title, String desc) {
        RecyclerVillItem item = new RecyclerVillItem();

        item.setIcon(icon);
        item.setTitle(title);
        item.setDesc(desc);

        mListSh.add(item);
    }
}
