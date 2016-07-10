package com.example.administrator.touch;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;

/**
 * Created by Administrator on 10/07/2016.
 */
public class TouchApplication extends Application{
    private ArrayList<Activity> activityList=new ArrayList<Activity>();
    public static TouchApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
    }
    public static TouchApplication getInstance(){
        return instance;
    }
    public void addActivity(Activity activity){
        activityList.add(activity);
    }
    public void exitApp(){
        for(Activity activity:activityList){
            activity.finish();
        }
    }
}
