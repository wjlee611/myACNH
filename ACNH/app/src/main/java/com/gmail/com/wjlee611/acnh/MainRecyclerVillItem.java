package com.gmail.com.wjlee611.acnh;

import android.graphics.drawable.Drawable;

public class MainRecyclerVillItem {
    private Drawable iconDrawable;
    private String nameStr;
    private String genderStr;
    private String birthStr;
    private String personStr;
    private String coffeeStr;

    public void setIcon(Drawable icon) {
        iconDrawable = icon;
    }

    public void setName(String name) {
        nameStr = name;
    }

    public void setGender(String gender) {
        genderStr = gender;
    }

    public void setBirth(String birth) {
        birthStr = birth;
    }

    public void setPerson(String person) {
        personStr = person;
    }

    public void setCoffee(String coffee) {
        coffeeStr = coffee;
    }


    public Drawable getIcon() {
        return this.iconDrawable;
    }

    public String getName() {
        return this.nameStr;
    }

    public String getGender() {
        return this.genderStr;
    }

    public String getBirth() {
        return this.birthStr;
    }

    public String getPerson() {
        return this.personStr;
    }

    public String getCoffee() {
        return this.coffeeStr;
    }
}
