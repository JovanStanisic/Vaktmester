package cubes.vaktmester.stanisic.data;

import android.content.Context;
import android.content.SharedPreferences;

import cubes.vaktmester.stanisic.R;

public class SharedPrefs {

    private SharedPreferences prefs;

    private static SharedPrefs instance;

    private SharedPrefs(Context context){
        prefs = context.getSharedPreferences(context.getString(R.string.app_name),Context.MODE_PRIVATE);
    }

    public static SharedPrefs getInstance(Context context){
        if(instance == null){
            instance = new SharedPrefs(context);
        }
        return instance;
    }

    // IS FIRST TIME STARTED
    public static void setFirstTime(Context context){
        getInstance(context).prefs.edit().putBoolean("is_first_time",false).apply();
    }

    // AFTER FIRST TIME STARTED
    public static boolean isFirstTime(Context context){
        return getInstance(context).prefs.getBoolean("is_first_time",true);
    }
}
