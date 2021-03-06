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
            //?????????
            for (int i=0; i<numResident_sh; i++) {
                switch (ResidentList_sh[i]) {
                    case 1:
                        addItem2(getDrawable(R.drawable.agent_s), "1", "2???");
                        break;
                    case 2:
                        addItem2(getDrawable(R.drawable.agnes), "2", "????????????");
                        break;
                    case 3:
                        addItem2(getDrawable(R.drawable.alfonso), "3", "????????????");
                        break;
                    case 4:
                        addItem2(getDrawable(R.drawable.alli), "4", "?????????");
                        break;
                    case 5:
                        addItem2(getDrawable(R.drawable.amelia), "5", "?????????");
                        break;
                    case 6:
                        addItem2(getDrawable(R.drawable.angus), "6", "?????????");
                        break;
                    case 7:
                        addItem2(getDrawable(R.drawable.antonio), "7", "?????????");
                        break;
                    case 8:
                        addItem2(getDrawable(R.drawable.apollo), "8", "?????????");
                        break;
                    case 9:
                        addItem2(getDrawable(R.drawable.apple), "9", "??????");
                        break;
                    case 10:
                        addItem2(getDrawable(R.drawable.aurora), "10", "?????????");
                        break;
                    case 11:
                        addItem2(getDrawable(R.drawable.avery), "11", "????????????");
                        break;
                    case 12:
                        addItem2(getDrawable(R.drawable.baabara), "12", "?????????");
                        break;
                    case 13:
                        addItem2(getDrawable(R.drawable.bangle), "13", "??????");
                        break;
                    case 14:
                        addItem2(getDrawable(R.drawable.beau), "14", "??????");
                        break;
                    case 15:
                        addItem2(getDrawable(R.drawable.bella), "15", "?????????");
                        break;
                    case 16:
                        addItem2(getDrawable(R.drawable.bertha), "16", "??????");
                        break;
                    case 17:
                        addItem2(getDrawable(R.drawable.bettina), "17", "?????????");
                        break;
                    case 18:
                        addItem2(getDrawable(R.drawable.bianca), "18", "??????");
                        break;
                    case 19:
                        addItem2(getDrawable(R.drawable.bill), "19", "?????????");
                        break;
                    case 20:
                        addItem2(getDrawable(R.drawable.blaire), "20", "?????????");
                        break;
                    case 21:
                        addItem2(getDrawable(R.drawable.blanche), "21", "??????");
                        break;
                    case 22:
                        addItem2(getDrawable(R.drawable.bob), "22", "??????");
                        break;
                    case 23:
                        addItem2(getDrawable(R.drawable.bonbon), "23", "??????");
                        break;
                    case 24:
                        addItem2(getDrawable(R.drawable.bree), "24", "??????");
                        break;
                    case 25:
                        addItem2(getDrawable(R.drawable.buck), "25", "???????????????");
                        break;
                    case 26:
                        addItem2(getDrawable(R.drawable.bud), "26", "??????");
                        break;
                    case 27:
                        addItem2(getDrawable(R.drawable.bunnie), "27", "?????????");
                        break;
                    case 28:
                        addItem2(getDrawable(R.drawable.butch), "28", "???");
                        break;
                    case 29:
                        addItem2(getDrawable(R.drawable.buzz), "29", "??????");
                        break;
                    case 30:
                        addItem2(getDrawable(R.drawable.cally), "30", "?????????");
                        break;
                    case 31:
                        addItem2(getDrawable(R.drawable.canberra), "31", "?????????");
                        break;
                    case 32:
                        addItem2(getDrawable(R.drawable.carmen), "32", "??????");
                        break;
                    case 33:
                        addItem2(getDrawable(R.drawable.caroline), "33", "????????????");
                        break;
                    case 34:
                        addItem2(getDrawable(R.drawable.carrie), "34", "??????");
                        break;
                    case 35:
                        addItem2(getDrawable(R.drawable.cashmere), "35", "????????????");
                        break;
                    case 36:
                        addItem2(getDrawable(R.drawable.celia), "36", "?????????");
                        break;
                    case 37:
                        addItem2(getDrawable(R.drawable.cesar), "37", "??????");
                        break;
                    case 38:
                        addItem2(getDrawable(R.drawable.chadder), "38", "??????");
                        break;
                    case 39:
                        addItem2(getDrawable(R.drawable.charlise), "39", "??????");
                        break;
                    case 40:
                        addItem2(getDrawable(R.drawable.cherry), "40", "??????");
                        break;
                    case 41:
                        addItem2(getDrawable(R.drawable.chevre), "41", "??????");
                        break;
                    case 42:
                        addItem2(getDrawable(R.drawable.chief), "42", "??????");
                        break;
                    case 43:
                        addItem2(getDrawable(R.drawable.chops), "43", "?????????");
                        break;
                    case 44:
                        addItem2(getDrawable(R.drawable.chrissy), "44", "????????????");
                        break;
                    case 45:
                        addItem2(getDrawable(R.drawable.claude), "45", "?????????");
                        break;
                    case 46:
                        addItem2(getDrawable(R.drawable.claudia), "46", "??????");
                        break;
                    case 47:
                        addItem2(getDrawable(R.drawable.coco), "47", "??????");
                        break;
                    case 48:
                        addItem2(getDrawable(R.drawable.cole), "48", "?????????");
                        break;
                    case 49:
                        addItem2(getDrawable(R.drawable.colton), "49", "?????????");
                        break;
                    case 50:
                        addItem2(getDrawable(R.drawable.cranston), "50", "??????");
                        break;
                    case 51:
                        addItem2(getDrawable(R.drawable.cube), "51", "??????");
                        break;
                    case 52:
                        addItem2(getDrawable(R.drawable.curlos), "52", "????????????");
                        break;
                    case 53:
                        addItem2(getDrawable(R.drawable.curt), "53", "??????");
                        break;
                    case 54:
                        addItem2(getDrawable(R.drawable.deirdre), "54", "?????????");
                        break;
                    case 55:
                        addItem2(getDrawable(R.drawable.diana), "55", "?????????");
                        break;
                    case 56:
                        addItem2(getDrawable(R.drawable.dizzy), "56", "??????");
                        break;
                    case 57:
                        addItem2(getDrawable(R.drawable.dobie), "57", "???");
                        break;
                    case 58:
                        addItem2(getDrawable(R.drawable.doc), "58", "??????");
                        break;
                    case 59:
                        addItem2(getDrawable(R.drawable.dotty), "59", "??????");
                        break;
                    case 60:
                        addItem2(getDrawable(R.drawable.drift), "60", "???");
                        break;
                    case 61:
                        addItem2(getDrawable(R.drawable.egbert), "61", "??????");
                        break;
                    case 62:
                        addItem2(getDrawable(R.drawable.eloise), "62", "?????????");
                        break;
                    case 63:
                        addItem2(getDrawable(R.drawable.erik), "63", "??????");
                        break;
                    case 64:
                        addItem2(getDrawable(R.drawable.eunice), "64", "?????????");
                        break;
                    case 65:
                        addItem2(getDrawable(R.drawable.fang), "65", "????????????");
                        break;
                    case 66:
                        addItem2(getDrawable(R.drawable.fauna), "66", "??????");
                        break;
                    case 67:
                        addItem2(getDrawable(R.drawable.filbert), "67", "??????");
                        break;
                    case 68:
                        addItem2(getDrawable(R.drawable.flip), "68", "??????");
                        break;
                    case 69:
                        addItem2(getDrawable(R.drawable.flora), "69", "?????????");
                        break;
                    case 70:
                        addItem2(getDrawable(R.drawable.flurry), "70", "?????????");
                        break;
                    case 71:
                        addItem2(getDrawable(R.drawable.francine), "71", "????????????");
                        break;
                    case 72:
                        addItem2(getDrawable(R.drawable.frank), "72", "??????");
                        break;
                    case 73:
                        addItem2(getDrawable(R.drawable.freya), "73", "?????????");
                        break;
                    case 74:
                        addItem2(getDrawable(R.drawable.friga), "74", "????????????");
                        break;
                    case 75:
                        addItem2(getDrawable(R.drawable.frita), "75", "??????");
                        break;
                    case 76:
                        addItem2(getDrawable(R.drawable.fuchsia), "76", "?????????");
                        break;
                    case 77:
                        addItem2(getDrawable(R.drawable.gabi), "77", "?????????");
                        break;
                    case 78:
                        addItem2(getDrawable(R.drawable.gaston), "78", "??????");
                        break;
                    case 79:
                        addItem2(getDrawable(R.drawable.genji), "79", "??????");
                        break;
                    case 80:
                        addItem2(getDrawable(R.drawable.gladys), "80", "????????????");
                        break;
                    case 81:
                        addItem2(getDrawable(R.drawable.goldie), "81", "?????????");
                        break;
                    case 82:
                        addItem2(getDrawable(R.drawable.goose), "82", "??????");
                        break;
                    case 83:
                        addItem2(getDrawable(R.drawable.greta), "83", "??????");
                        break;
                    case 84:
                        addItem2(getDrawable(R.drawable.hamlet), "84", "?????????");
                        break;
                    case 85:
                        addItem2(getDrawable(R.drawable.hans), "85", "?????????");
                        break;
                    case 86:
                        addItem2(getDrawable(R.drawable.hazel), "86", "????????????");
                        break;
                    case 87:
                        addItem2(getDrawable(R.drawable.hopkins), "87", "?????????");
                        break;
                    case 88:
                        addItem2(getDrawable(R.drawable.hopper), "88", "?????????");
                        break;
                    case 89:
                        addItem2(getDrawable(R.drawable.hornsby), "89", "??????");
                        break;
                    case 90:
                        addItem2(getDrawable(R.drawable.iggly), "90", "?????????");
                        break;
                    case 91:
                        addItem2(getDrawable(R.drawable.jay), "91", "?????????");
                        break;
                    case 92:
                        addItem2(getDrawable(R.drawable.jitters), "92", "??????");
                        break;
                    case 93:
                        addItem2(getDrawable(R.drawable.julia), "93", "?????????");
                        break;
                    case 94:
                        addItem2(getDrawable(R.drawable.julian), "94", "?????????");
                        break;
                    case 95:
                        addItem2(getDrawable(R.drawable.katt), "95", "??????");
                        break;
                    case 96:
                        addItem2(getDrawable(R.drawable.keaton), "96", "?????????");
                        break;
                    case 97:
                        addItem2(getDrawable(R.drawable.kevin), "97", "??????");
                        break;
                    case 98:
                        addItem2(getDrawable(R.drawable.kid_cat), "98", "1???");
                        break;
                    case 99:
                        addItem2(getDrawable(R.drawable.kiki), "99", "?????????");
                        break;
                    case 100:
                        addItem2(getDrawable(R.drawable.kitt), "100", "????????????");
                        break;
                    case 101:
                        addItem2(getDrawable(R.drawable.klaus), "101", "????????????");
                        break;
                    case 102:
                        addItem2(getDrawable(R.drawable.kyle), "102", "????????????");
                        break;
                    case 103:
                        addItem2(getDrawable(R.drawable.leonardo), "103", "??????");
                        break;
                    case 104:
                        addItem2(getDrawable(R.drawable.lily), "104", "?????????");
                        break;
                    case 105:
                        addItem2(getDrawable(R.drawable.lobo), "105", "??????");
                        break;
                    case 106:
                        addItem2(getDrawable(R.drawable.lolly), "106", "?????????");
                        break;
                    case 107:
                        addItem2(getDrawable(R.drawable.lopez), "107", "??????");
                        break;
                    case 108:
                        addItem2(getDrawable(R.drawable.mallary), "108", "?????????");
                        break;
                    case 109:
                        addItem2(getDrawable(R.drawable.margie), "109", "??????");
                        break;
                    case 110:
                        addItem2(getDrawable(R.drawable.marina), "110", "?????????");
                        break;
                    case 111:
                        addItem2(getDrawable(R.drawable.marshal), "111", "??????");
                        break;
                    case 112:
                        addItem2(getDrawable(R.drawable.melba), "112", "???????????????");
                        break;
                    case 113:
                        addItem2(getDrawable(R.drawable.merengue), "113", "???????????????");
                        break;
                    case 114:
                        addItem2(getDrawable(R.drawable.merry), "114", "?????????");
                        break;
                    case 115:
                        addItem2(getDrawable(R.drawable.mint), "115", "??????");
                        break;
                    case 116:
                        addItem2(getDrawable(R.drawable.mira), "116", "??????");
                        break;
                    case 117:
                        addItem2(getDrawable(R.drawable.molly), "117", "?????????");
                        break;
                    case 118:
                        addItem2(getDrawable(R.drawable.muffy), "118", "??????");
                        break;
                    case 119:
                        addItem2(getDrawable(R.drawable.nibbles), "119", "?????????");
                        break;
                    case 120:
                        addItem2(getDrawable(R.drawable.octavian), "120", "??????");
                        break;
                    case 121:
                        addItem2(getDrawable(R.drawable.o_hare), "121", "?????????");
                        break;
                    case 122:
                        addItem2(getDrawable(R.drawable.olivia), "122", "????????????");
                        break;
                    case 123:
                        addItem2(getDrawable(R.drawable.ozzie), "123", "?????????");
                        break;
                    case 124:
                        addItem2(getDrawable(R.drawable.pancetti), "124", "????????????");
                        break;
                    case 125:
                        addItem2(getDrawable(R.drawable.patty), "125", "??????");
                        break;
                    case 126:
                        addItem2(getDrawable(R.drawable.peaches), "126", "??????");
                        break;
                    case 127:
                        addItem2(getDrawable(R.drawable.peanut), "127", "??????");
                        break;
                    case 128:
                        addItem2(getDrawable(R.drawable.pecan), "128", "?????????");
                        break;
                    case 129:
                        addItem2(getDrawable(R.drawable.peewee), "129", "??????");
                        break;
                    case 130:
                        addItem2(getDrawable(R.drawable.pekoe), "130", "?????????");
                        break;
                    case 131:
                        addItem2(getDrawable(R.drawable.penelope), "131", "?????????");
                        break;
                    case 132:
                        addItem2(getDrawable(R.drawable.phil), "132", "??????");
                        break;
                    case 133:
                        addItem2(getDrawable(R.drawable.phoebe), "133", "??????");
                        break;
                    case 134:
                        addItem2(getDrawable(R.drawable.pierce), "134", "????????????");
                        break;
                    case 135:
                        addItem2(getDrawable(R.drawable.pietro), "135", "??????");
                        break;
                    case 136:
                        addItem2(getDrawable(R.drawable.pinky), "136", "??????");
                        break;
                    case 137:
                        addItem2(getDrawable(R.drawable.piper), "137", "?????????");
                        break;
                    case 138:
                        addItem2(getDrawable(R.drawable.pippy), "138", "??????");
                        break;
                    case 139:
                        addItem2(getDrawable(R.drawable.poncho), "139", "??????");
                        break;
                    case 140:
                        addItem2(getDrawable(R.drawable.poppy), "140", "??????");
                        break;
                    case 141:
                        addItem2(getDrawable(R.drawable.punchy), "141", "??????");
                        break;
                    case 142:
                        addItem2(getDrawable(R.drawable.purrl), "142", "??????");
                        break;
                    case 143:
                        addItem2(getDrawable(R.drawable.queenie), "143", "??????");
                        break;
                    case 144:
                        addItem2(getDrawable(R.drawable.renee), "144", "?????????");
                        break;
                    case 145:
                        addItem2(getDrawable(R.drawable.rhonda), "145", "??????");
                        break;
                    case 146:
                        addItem2(getDrawable(R.drawable.ricky), "146", "?????????");
                        break;
                    case 147:
                        addItem2(getDrawable(R.drawable.roald), "147", "??????");
                        break;
                    case 148:
                        addItem2(getDrawable(R.drawable.rocco), "148", "????????????");
                        break;
                    case 149:
                        addItem2(getDrawable(R.drawable.rod), "149", "???");
                        break;
                    case 150:
                        addItem2(getDrawable(R.drawable.rodney), "150", "??????");
                        break;
                    case 151:
                        addItem2(getDrawable(R.drawable.rolf), "151", "?????????");
                        break;
                    case 152:
                        addItem2(getDrawable(R.drawable.roscoe), "152", "????????????");
                        break;
                    case 153:
                        addItem2(getDrawable(R.drawable.rosie), "153", "??????");
                        break;
                    case 154:
                        addItem2(getDrawable(R.drawable.rowan), "154", "?????????");
                        break;
                    case 155:
                        addItem2(getDrawable(R.drawable.ruby), "155", "??????");
                        break;
                    case 156:
                        addItem2(getDrawable(R.drawable.sally), "156", "?????????");
                        break;
                    case 157:
                        addItem2(getDrawable(R.drawable.sandy), "157", "??????");
                        break;
                    case 158:
                        addItem2(getDrawable(R.drawable.shari), "158", "??????");
                        break;
                    case 159:
                        addItem2(getDrawable(R.drawable.sheldon), "159", "?????????");
                        break;
                    case 160:
                        addItem2(getDrawable(R.drawable.skye), "160", "??????");
                        break;
                    case 161:
                        addItem2(getDrawable(R.drawable.sly), "161", "?????????");
                        break;
                    case 162:
                        addItem2(getDrawable(R.drawable.snake), "162", "??????");
                        break;
                    case 163:
                        addItem2(getDrawable(R.drawable.spike), "163", "?????????");
                        break;
                    case 164:
                        addItem2(getDrawable(R.drawable.sprocket), "164", "?????????");
                        break;
                    case 165:
                        addItem2(getDrawable(R.drawable.static_), "165", "?????????");
                        break;
                    case 166:
                        addItem2(getDrawable(R.drawable.stella), "166", "?????????");
                        break;
                    case 167:
                        addItem2(getDrawable(R.drawable.sterling), "167", "?????????");
                        break;
                    case 168:
                        addItem2(getDrawable(R.drawable.stitches), "168", "??????");
                        break;
                    case 169:
                        addItem2(getDrawable(R.drawable.sylvana), "169", "?????????");
                        break;
                    case 170:
                        addItem2(getDrawable(R.drawable.tammy), "170", "?????????");
                        break;
                    case 171:
                        addItem2(getDrawable(R.drawable.tank), "171", "??????");
                        break;
                    case 172:
                        addItem2(getDrawable(R.drawable.t_bone), "172", "??????");
                        break;
                    case 173:
                        addItem2(getDrawable(R.drawable.tasha), "173", "?????????");
                        break;
                    case 174:
                        addItem2(getDrawable(R.drawable.teddy), "174", "??????");
                        break;
                    case 175:
                        addItem2(getDrawable(R.drawable.tiffany), "175", "?????????");
                        break;
                    case 176:
                        addItem2(getDrawable(R.drawable.timbra), "176", "??????");
                        break;
                    case 177:
                        addItem2(getDrawable(R.drawable.truffles), "177", "??????");
                        break;
                    case 178:
                        addItem2(getDrawable(R.drawable.tutu), "178", "??????");
                        break;
                    case 179:
                        addItem2(getDrawable(R.drawable.tybalt), "179", "?????????");
                        break;
                    case 180:
                        addItem2(getDrawable(R.drawable.vesta), "180", "????????????");
                        break;
                    case 181:
                        addItem2(getDrawable(R.drawable.victoria), "181", "????????????");
                        break;
                    case 182:
                        addItem2(getDrawable(R.drawable.violet), "182", "??????");
                        break;
                    case 183:
                        addItem2(getDrawable(R.drawable.vivian), "183", "?????????");
                        break;
                    case 184:
                        addItem2(getDrawable(R.drawable.vladimir), "184", "??????");
                        break;
                    case 185:
                        addItem2(getDrawable(R.drawable.wendy), "185", "?????????");
                        break;
                    case 186:
                        addItem2(getDrawable(R.drawable.whitney), "186", "?????????");
                        break;
                    case 187:
                        addItem2(getDrawable(R.drawable.willow), "187", "??????");
                        break;
                    case 188:
                        addItem2(getDrawable(R.drawable.wolfgang), "188", "??????");
                        break;
                    case 189:
                        addItem2(getDrawable(R.drawable.zucher), "189", "??????");
                        break;

                    case 190:
                        addItem2(getDrawable(R.drawable.admiral), "190", "??????");
                        break;
                    case 191:
                        addItem2(getDrawable(R.drawable.al), "191", "??????");
                        break;
                    case 192:
                        addItem2(getDrawable(R.drawable.alice), "192", "?????????");
                        break;
                    case 193:
                        addItem2(getDrawable(R.drawable.anabelle), "193", "?????????");
                        break;
                    case 194:
                        addItem2(getDrawable(R.drawable.anchovy), "194", "?????????");
                        break;
                    case 195:
                        addItem2(getDrawable(R.drawable.anicotti), "195", "?????????");
                        break;
                    case 196:
                        addItem2(getDrawable(R.drawable.ankha), "196", "?????????");
                        break;
                    case 197:
                        addItem2(getDrawable(R.drawable.annalisa), "197", "??????");
                        break;
                    case 198:
                        addItem2(getDrawable(R.drawable.annalise), "198", "????????????");
                        break;
                    case 199:
                        addItem2(getDrawable(R.drawable.astrid), "199", "?????????");
                        break;
                    case 200:
                        addItem2(getDrawable(R.drawable.audie), "200", "?????????");
                        break;
                    case 201:
                        addItem2(getDrawable(R.drawable.ava), "201", "??????");
                        break;
                    case 202:
                        addItem2(getDrawable(R.drawable.axel), "202", "????????????");
                        break;
                    case 203:
                        addItem2(getDrawable(R.drawable.bam), "203", "??????");
                        break;
                    case 204:
                        addItem2(getDrawable(R.drawable.barold), "204", "??????");
                        break;
                    case 205:
                        addItem2(getDrawable(R.drawable.bea), "205", "?????????");
                        break;
                    case 206:
                        addItem2(getDrawable(R.drawable.beardo), "206", "?????????");
                        break;
                    case 207:
                        addItem2(getDrawable(R.drawable.becky), "207", "?????????");
                        break;
                    case 208:
                        addItem2(getDrawable(R.drawable.benedict), "208", "????????????");
                        break;
                    case 209:
                        addItem2(getDrawable(R.drawable.benjamin), "209", "?????????");
                        break;
                    case 210:
                        addItem2(getDrawable(R.drawable.biff), "210", "????????????");
                        break;
                    case 211:
                        addItem2(getDrawable(R.drawable.big_top), "211", "3???");
                        break;
                    case 212:
                        addItem2(getDrawable(R.drawable.billy), "212", "?????????");
                        break;
                    case 213:
                        addItem2(getDrawable(R.drawable.biskit), "213", "??????");
                        break;
                    case 214:
                        addItem2(getDrawable(R.drawable.bitty), "214", "??????");
                        break;
                    case 215:
                        addItem2(getDrawable(R.drawable.bluebear), "215", "?????????");
                        break;
                    case 216:
                        addItem2(getDrawable(R.drawable.bones), "216", "??????");
                        break;
                    case 217:
                        addItem2(getDrawable(R.drawable.boomer), "217", "??????");
                        break;
                    case 218:
                        addItem2(getDrawable(R.drawable.boone), "218", "?????????");
                        break;
                    case 219:
                        addItem2(getDrawable(R.drawable.boots), "219", "??????");
                        break;
                    case 220:
                        addItem2(getDrawable(R.drawable.boris), "220", "??????");
                        break;
                    case 221:
                        addItem2(getDrawable(R.drawable.boyd), "221", "?????????");
                        break;
                    case 222:
                        addItem2(getDrawable(R.drawable.broccolo), "222", "????????????");
                        break;
                    case 223:
                        addItem2(getDrawable(R.drawable.broffina), "223", "??????");
                        break;
                    case 224:
                        addItem2(getDrawable(R.drawable.bruce), "224", "?????????");
                        break;
                    case 225:
                        addItem2(getDrawable(R.drawable.bubbles), "225", "??????");
                        break;
                    case 226:
                        addItem2(getDrawable(R.drawable.camofrog), "226", "??????");
                        break;
                    case 227:
                        addItem2(getDrawable(R.drawable.candi), "227", "??????");
                        break;
                    case 228:
                        addItem2(getDrawable(R.drawable.chai), "228", "??????");
                        break;
                    case 229:
                        addItem2(getDrawable(R.drawable.chelsea), "229", "??????");
                        break;
                    case 230:
                        addItem2(getDrawable(R.drawable.cheri), "230", "????????????");
                        break;
                    case 231:
                        addItem2(getDrawable(R.drawable.chester), "231", "??????");
                        break;
                    case 232:
                        addItem2(getDrawable(R.drawable.chow), "232", "??????");
                        break;
                    case 233:
                        addItem2(getDrawable(R.drawable.clay), "233", "??????");
                        break;
                    case 234:
                        addItem2(getDrawable(R.drawable.cleo), "234", "???????????????");
                        break;
                    case 235:
                        addItem2(getDrawable(R.drawable.clyde), "235", "?????????");
                        break;
                    case 236:
                        addItem2(getDrawable(R.drawable.coach), "236", "??????");
                        break;
                    case 237:
                        addItem2(getDrawable(R.drawable.cobb), "237", "??????");
                        break;
                    case 238:
                        addItem2(getDrawable(R.drawable.cookie), "238", "??????");
                        break;
                    case 239:
                        addItem2(getDrawable(R.drawable.cousteau), "239", "?????????");
                        break;
                    case 240:
                        addItem2(getDrawable(R.drawable.croque), "240", "??????");
                        break;
                    case 241:
                        addItem2(getDrawable(R.drawable.curly), "241", "?????????");
                        break;
                    case 242:
                        addItem2(getDrawable(R.drawable.cyd), "242", "?????????");
                        break;
                    case 243:
                        addItem2(getDrawable(R.drawable.cyrano), "243", "?????????");
                        break;
                    case 244:
                        addItem2(getDrawable(R.drawable.daisy), "244", "?????????");
                        break;
                    case 245:
                        addItem2(getDrawable(R.drawable.deena), "245", "?????????");
                        break;
                    case 246:
                        addItem2(getDrawable(R.drawable.del), "246", "?????????");
                        break;
                    case 247:
                        addItem2(getDrawable(R.drawable.deli), "247", "??????");
                        break;
                    case 248:
                        addItem2(getDrawable(R.drawable.derwin), "248", "???");
                        break;
                    case 249:
                        addItem2(getDrawable(R.drawable.diva), "249", "?????????");
                        break;
                    case 250:
                        addItem2(getDrawable(R.drawable.dom), "250", "??????");
                        break;
                    case 251:
                        addItem2(getDrawable(R.drawable.dora), "251", "??????");
                        break;
                    case 252:
                        addItem2(getDrawable(R.drawable.drago), "252", "?????????");
                        break;
                    case 253:
                        addItem2(getDrawable(R.drawable.drake), "253", "????????????");
                        break;
                    case 254:
                        addItem2(getDrawable(R.drawable.ed), "254", "??????");
                        break;
                    case 255:
                        addItem2(getDrawable(R.drawable.elise), "255", "??????");
                        break;
                    case 256:
                        addItem2(getDrawable(R.drawable.ellie), "256", "????????????");
                        break;
                    case 257:
                        addItem2(getDrawable(R.drawable.elmer), "257", "?????????");
                        break;
                    case 258:
                        addItem2(getDrawable(R.drawable.elvis), "258", "???");
                        break;
                    case 259:
                        addItem2(getDrawable(R.drawable.etoile), "259", "????????????");
                        break;
                    case 260:
                        addItem2(getDrawable(R.drawable.eugene), "260", "??????");
                        break;
                    case 261:
                        addItem2(getDrawable(R.drawable.felicity), "261", "??????");
                        break;
                    case 262:
                        addItem2(getDrawable(R.drawable.flo), "262", "?????????");
                        break;
                    case 263:
                        addItem2(getDrawable(R.drawable.freckles), "263", "?????????");
                        break;
                    case 264:
                        addItem2(getDrawable(R.drawable.frobert), "264", "????????????");
                        break;
                    case 265:
                        addItem2(getDrawable(R.drawable.gala), "265", "??????");
                        break;
                    case 266:
                        addItem2(getDrawable(R.drawable.gayle), "266", "??????");
                        break;
                    case 267:
                        addItem2(getDrawable(R.drawable.gigi), "267", "??????");
                        break;
                    case 268:
                        addItem2(getDrawable(R.drawable.gloria), "268", "?????????");
                        break;
                    case 269:
                        addItem2(getDrawable(R.drawable.gonzo), "269", "??????");
                        break;
                    case 270:
                        addItem2(getDrawable(R.drawable.graham), "270", "?????????");
                        break;
                    case 271:
                        addItem2(getDrawable(R.drawable.grizzly), "271", "??????");
                        break;
                    case 272:
                        addItem2(getDrawable(R.drawable.groucho), "272", "?????????");
                        break;
                    case 273:
                        addItem2(getDrawable(R.drawable.gruff), "273", "??????");
                        break;
                    case 274:
                        addItem2(getDrawable(R.drawable.gwen), "274", "??????");
                        break;
                    case 275:
                        addItem2(getDrawable(R.drawable.hamphrey), "275", "??????");
                        break;
                    case 276:
                        addItem2(getDrawable(R.drawable.harry), "276", "?????????");
                        break;
                    case 277:
                        addItem2(getDrawable(R.drawable.henry), "277", "??????");
                        break;
                    case 278:
                        addItem2(getDrawable(R.drawable.hippeux), "278", "?????????");
                        break;
                    case 279:
                        addItem2(getDrawable(R.drawable.huck), "279", "?????????");
                        break;
                    case 280:
                        addItem2(getDrawable(R.drawable.hugh), "280", "?????????");
                        break;
                    case 281:
                        addItem2(getDrawable(R.drawable.ike), "281", "??????");
                        break;
                    case 282:
                        addItem2(getDrawable(R.drawable.jacob), "282", "??????");
                        break;
                    case 283:
                        addItem2(getDrawable(R.drawable.jacques), "283", "??????");
                        break;
                    case 284:
                        addItem2(getDrawable(R.drawable.jambette), "284", "???????????????");
                        break;
                    case 285:
                        addItem2(getDrawable(R.drawable.jeremiah), "285", "?????????");
                        break;
                    case 286:
                        addItem2(getDrawable(R.drawable.joey), "286", "?????????");
                        break;
                    case 287:
                        addItem2(getDrawable(R.drawable.judy), "287", "??????");
                        break;
                    case 288:
                        addItem2(getDrawable(R.drawable.june), "288", "??????");
                        break;
                    case 289:
                        addItem2(getDrawable(R.drawable.kabuki), "289", "?????????");
                        break;
                    case 290:
                        addItem2(getDrawable(R.drawable.ken), "290", "??????");
                        break;
                    case 291:
                        addItem2(getDrawable(R.drawable.ketchup), "291", "??????");
                        break;
                    case 292:
                        addItem2(getDrawable(R.drawable.kidd), "292", "?????????");
                        break;
                    case 293:
                        addItem2(getDrawable(R.drawable.kitty), "293", "?????????");
                        break;
                    case 294:
                        addItem2(getDrawable(R.drawable.knox), "294", "?????????");
                        break;
                    case 295:
                        addItem2(getDrawable(R.drawable.kody), "295", "????????????");
                        break;
                    case 296:
                        addItem2(getDrawable(R.drawable.limberg), "296", "?????????");
                        break;
                    case 297:
                        addItem2(getDrawable(R.drawable.lionel), "297", "????????????");
                        break;
                    case 298:
                        addItem2(getDrawable(R.drawable.louie), "298", "??????");
                        break;
                    case 299:
                        addItem2(getDrawable(R.drawable.lucha), "299", "???????????????");
                        break;
                    case 300:
                        addItem2(getDrawable(R.drawable.lucky), "300", "??????");
                        break;
                    case 301:
                        addItem2(getDrawable(R.drawable.lucy), "301", "??????");
                        break;
                    case 302:
                        addItem2(getDrawable(R.drawable.lyman), "302", "????????????");
                        break;
                    case 303:
                        addItem2(getDrawable(R.drawable.mac), "303", "??????");
                        break;
                    case 304:
                        addItem2(getDrawable(R.drawable.maddie), "304", "??????");
                        break;
                    case 305:
                        addItem2(getDrawable(R.drawable.maelle), "305", "???");
                        break;
                    case 306:
                        addItem2(getDrawable(R.drawable.maggie), "306", "?????????");
                        break;
                    case 307:
                        addItem2(getDrawable(R.drawable.maple), "307", "?????????");
                        break;
                    case 308:
                        addItem2(getDrawable(R.drawable.marcel), "308", "????????????");
                        break;
                    case 309:
                        addItem2(getDrawable(R.drawable.marcie), "309", "?????????");
                        break;
                    case 310:
                        addItem2(getDrawable(R.drawable.mathilda), "310", "?????????");
                        break;
                    case 311:
                        addItem2(getDrawable(R.drawable.megan), "311", "??????");
                        break;
                    case 312:
                        addItem2(getDrawable(R.drawable.midge), "312", "?????????");
                        break;
                    case 313:
                        addItem2(getDrawable(R.drawable.miranda), "313", "?????????");
                        break;
                    case 314:
                        addItem2(getDrawable(R.drawable.mitzi), "314", "??????");
                        break;
                    case 315:
                        addItem2(getDrawable(R.drawable.moe), "315", "??????");
                        break;
                    case 316:
                        addItem2(getDrawable(R.drawable.monique), "316", "??????");
                        break;
                    case 317:
                        addItem2(getDrawable(R.drawable.monty), "317", "??????");
                        break;
                    case 318:
                        addItem2(getDrawable(R.drawable.moose), "318", "???");
                        break;
                    case 319:
                        addItem2(getDrawable(R.drawable.mott), "319", "???");
                        break;
                    case 320:
                        addItem2(getDrawable(R.drawable.murphy), "320", "??????");
                        break;
                    case 321:
                        addItem2(getDrawable(R.drawable.nan), "321", "??????");
                        break;
                    case 322:
                        addItem2(getDrawable(R.drawable.nana), "322", "??????");
                        break;
                    case 323:
                        addItem2(getDrawable(R.drawable.naomi), "323", "??????");
                        break;
                    case 324:
                        addItem2(getDrawable(R.drawable.nate), "324", "?????????");
                        break;
                    case 325:
                        addItem2(getDrawable(R.drawable.norma), "325", "??????");
                        break;
                    case 326:
                        addItem2(getDrawable(R.drawable.olaf), "326", "????????????");
                        break;
                    case 327:
                        addItem2(getDrawable(R.drawable.olive), "327", "?????????");
                        break;
                    case 328:
                        addItem2(getDrawable(R.drawable.opal), "328", "??????");
                        break;
                    case 329:
                        addItem2(getDrawable(R.drawable.pango), "329", "?????????");
                        break;
                    case 330:
                        addItem2(getDrawable(R.drawable.paolo), "330", "?????????");
                        break;
                    case 331:
                        addItem2(getDrawable(R.drawable.papi), "331", "?????????");
                        break;
                    case 332:
                        addItem2(getDrawable(R.drawable.pashmina), "332", "?????????");
                        break;
                    case 333:
                        addItem2(getDrawable(R.drawable.pate), "333", "??????");
                        break;
                    case 334:
                        addItem2(getDrawable(R.drawable.paula), "334", "?????????");
                        break;
                    case 335:
                        addItem2(getDrawable(R.drawable.peck), "335", "??????");
                        break;
                    case 336:
                        addItem2(getDrawable(R.drawable.peggy), "336", "??????");
                        break;
                    case 337:
                        addItem2(getDrawable(R.drawable.plucky), "337", "?????????");
                        break;
                    case 338:
                        addItem2(getDrawable(R.drawable.pompom), "338", "??????");
                        break;
                    case 339:
                        addItem2(getDrawable(R.drawable.portia), "339", "?????????");
                        break;
                    case 340:
                        addItem2(getDrawable(R.drawable.prince), "340", "??????");
                        break;
                    case 341:
                        addItem2(getDrawable(R.drawable.puck), "341", "??????");
                        break;
                    case 342:
                        addItem2(getDrawable(R.drawable.puddles), "342", "??????");
                        break;
                    case 343:
                        addItem2(getDrawable(R.drawable.pudge), "343", "??????");
                        break;
                    case 344:
                        addItem2(getDrawable(R.drawable.quillson), "344", "??????");
                        break;
                    case 345:
                        addItem2(getDrawable(R.drawable.raddle), "345", "??????");
                        break;
                    case 346:
                        addItem2(getDrawable(R.drawable.rasher), "346", "?????????");
                        break;
                    case 347:
                        addItem2(getDrawable(R.drawable.raymond), "347", "??????");
                        break;
                    case 348:
                        addItem2(getDrawable(R.drawable.reneigh), "348", "?????????");
                        break;
                    case 349:
                        addItem2(getDrawable(R.drawable.rex), "349", "??????");
                        break;
                    case 350:
                        addItem2(getDrawable(R.drawable.ribbot), "350", "??????");
                        break;
                    case 351:
                        addItem2(getDrawable(R.drawable.rilla), "351", "??????");
                        break;
                    case 352:
                        addItem2(getDrawable(R.drawable.rizzo), "352", "?????????");
                        break;
                    case 353:
                        addItem2(getDrawable(R.drawable.robin), "353", "??????");
                        break;
                    case 354:
                        addItem2(getDrawable(R.drawable.rocket), "354", "4???");
                        break;
                    case 355:
                        addItem2(getDrawable(R.drawable.rodeo), "355", "?????????");
                        break;
                    case 356:
                        addItem2(getDrawable(R.drawable.rooney), "356", "?????????");
                        break;
                    case 357:
                        addItem2(getDrawable(R.drawable.rory), "357", "??????");
                        break;
                    case 358:
                        addItem2(getDrawable(R.drawable.rudy), "358", "??????");
                        break;
                    case 359:
                        addItem2(getDrawable(R.drawable.samson), "359", "??????");
                        break;
                    case 360:
                        addItem2(getDrawable(R.drawable.savannah), "360", "?????????");
                        break;
                    case 361:
                        addItem2(getDrawable(R.drawable.scoot), "361", "?????????");
                        break;
                    case 362:
                        addItem2(getDrawable(R.drawable.shep), "362", "???");
                        break;
                    case 363:
                        addItem2(getDrawable(R.drawable.sherb), "363", "??????");
                        break;
                    case 364:
                        addItem2(getDrawable(R.drawable.simon), "364", "??????");
                        break;
                    case 365:
                        addItem2(getDrawable(R.drawable.snooty), "365", "?????????");
                        break;
                    case 366:
                        addItem2(getDrawable(R.drawable.soleil), "366", "??????");
                        break;
                    case 367:
                        addItem2(getDrawable(R.drawable.sparro), "367", "??????");
                        break;
                    case 368:
                        addItem2(getDrawable(R.drawable.spork), "368", "??????");
                        break;
                    case 369:
                        addItem2(getDrawable(R.drawable.sprinkle), "369", "?????????");
                        break;
                    case 370:
                        addItem2(getDrawable(R.drawable.stinky), "370", "??????");
                        break;
                    case 371:
                        addItem2(getDrawable(R.drawable.stu), "371", "?????????");
                        break;
                    case 372:
                        addItem2(getDrawable(R.drawable.sydney), "372", "?????????");
                        break;
                    case 373:
                        addItem2(getDrawable(R.drawable.sylvia), "373", "?????????");
                        break;
                    case 374:
                        addItem2(getDrawable(R.drawable.tabby), "374", "?????????");
                        break;
                    case 375:
                        addItem2(getDrawable(R.drawable.tad), "375", "??????");
                        break;
                    case 376:
                        addItem2(getDrawable(R.drawable.tammi), "376", "????????????");
                        break;
                    case 377:
                        addItem2(getDrawable(R.drawable.tangy), "377", "?????????");
                        break;
                    case 378:
                        addItem2(getDrawable(R.drawable.tex), "378", "??????");
                        break;
                    case 379:
                        addItem2(getDrawable(R.drawable.tia), "379", "??????");
                        break;
                    case 380:
                        addItem2(getDrawable(R.drawable.tipper), "380", "?????????");
                        break;
                    case 381:
                        addItem2(getDrawable(R.drawable.toby), "381", "??????");
                        break;
                    case 382:
                        addItem2(getDrawable(R.drawable.tom), "382", "??????");
                        break;
                    case 383:
                        addItem2(getDrawable(R.drawable.tucker), "383", "??????");
                        break;
                    case 384:
                        addItem2(getDrawable(R.drawable.twiggy), "384", "??????");
                        break;
                    case 385:
                        addItem2(getDrawable(R.drawable.ursala), "385", "?????????");
                        break;
                    case 386:
                        addItem2(getDrawable(R.drawable.velma), "386", "??????");
                        break;
                    case 387:
                        addItem2(getDrawable(R.drawable.vic), "387", "?????????");
                        break;
                    case 388:
                        addItem2(getDrawable(R.drawable.wade), "388", "??????");
                        break;
                    case 389:
                        addItem2(getDrawable(R.drawable.walker), "389", "???");
                        break;
                    case 390:
                        addItem2(getDrawable(R.drawable.walt), "390", "??????");
                        break;
                    case 391:
                        addItem2(getDrawable(R.drawable.wart_jr), "391", "???");
                        break;
                    case 392:
                        addItem2(getDrawable(R.drawable.weber), "392", "?????????");
                        break;
                    case 393:
                        addItem2(getDrawable(R.drawable.winnie), "393", "?????????");
                        break;
                    case 394:
                        addItem2(getDrawable(R.drawable.yuka), "394", "?????????");
                        break;
                    case 395:
                        addItem2(getDrawable(R.drawable.zell), "395", "??????");
                        break;
                    default:
                        break;
                }
            }
        } else {
            //default ??????
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
                        addItem2(getDrawable(R.drawable.renee), "144", "Ren??e");
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
                        addItem2(getDrawable(R.drawable.etoile), "259", "??toile");
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
