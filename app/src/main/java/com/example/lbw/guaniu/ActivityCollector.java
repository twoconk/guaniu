package com.example.lbw.guaniu;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lbw on 2017/8/4.
 */

public class ActivityCollector {
    public static List<Activity> activityList = new ArrayList<>();
    public static void AddActivity(Activity activity){
        activityList.add(activity);
    }
    public static void remoreActivity(Activity activity){
        activityList.remove(activity);
    }

    public static void finishAll(){
        for (Activity activity : activityList){
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
        activityList.clear();
    }
}
