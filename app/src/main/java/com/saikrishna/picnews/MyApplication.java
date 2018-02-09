package com.saikrishna.picnews;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saikrishna on 8/14/16.
 */
public class MyApplication extends Application {

    List<String> all = new ArrayList<String>();
    List<String> entertainment = new ArrayList<String>();
    List<String> sports = new ArrayList<String>();
    List<String> money = new ArrayList<String>();
    List<String> lifestyle = new ArrayList<String>();
    List<String> health = new ArrayList<String>();
    List<String> travel = new ArrayList<String>();
    List<String> food = new ArrayList<String>();
    List<String> autos = new ArrayList<String>();
    List<String> videos = new ArrayList<String>();

    public void setArray(List<String> heads, Integer i) {
        if (i==1) {
            all = heads;
        } else if (i==2) {
            entertainment = heads;
        } else if (i==3) {
            sports = heads;
        } else if (i==4) {
            money = heads;
        } else if (i==5) {
            lifestyle = heads;
        } else if (i==6) {
            health = heads;
        } else if (i==7) {
            travel = heads;
        } else if (i==8) {
            food = heads;
        } else if (i==9) {
            autos = heads;
        } else {
            videos = heads;
        }
    }

    public List<String> getArray(Integer i) {
        if (i==1) {
            return all;
        } else if (i==2) {
            return entertainment;
        } else if (i==3) {
            return sports;
        } else if (i==4) {
            return money;
        } else if (i==5) {
            return lifestyle;
        } else if (i==6) {
            return health;
        } else if (i==7) {
            return travel;
        } else if (i==8) {
            return food;
        } else if (i==9) {
            return autos;
        } else {
            return videos;
        }
    }

    private static MyApplication singleton;

    public static MyApplication getInstance() {
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
    }
}
