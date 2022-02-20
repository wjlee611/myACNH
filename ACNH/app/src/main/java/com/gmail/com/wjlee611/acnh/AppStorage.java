package com.gmail.com.wjlee611.acnh;

import android.content.Context;
import android.content.SharedPreferences;

public class AppStorage {
    private Context context;
    private SharedPreferences pref;
    private String PURCHASED_DONATE = "donate1000";

    public AppStorage(Context context) {
        pref = context.getSharedPreferences("app_storage", Context.MODE_PRIVATE);
        this.context = context;
    }

    public boolean purchasedDonate() {
        return pref.getBoolean(PURCHASED_DONATE, false);
    }

    public void setPurchasedDonate(boolean flag) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(PURCHASED_DONATE, flag);
        editor.apply();
    }
}
