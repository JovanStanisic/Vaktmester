package cubes.vaktmester.stanisic.data;

import android.content.Context;
import android.content.SharedPreferences;

import cubes.vaktmester.stanisic.R;
import cubes.vaktmester.stanisic.data.model.Token;

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

    //LOGIN TOKEN

    public static void saveToken(Context context, Token token) {

        getInstance(context).prefs.edit().putString("api_token", token.api_token).apply();
        getInstance(context).prefs.edit().putString("refresh_token",token.refresh_token).apply();
    }

    public static Token getToken(Context context){

        Token token = new Token();

        token.api_token = getInstance(context).prefs.getString("api_token", null);
        token.refresh_token = getInstance(context).prefs.getString("refresh_token", null);

        return token;
    }

    public static void deleteToken(Context context){

        getInstance(context).prefs.edit().putString("api_token", null).apply();
        getInstance(context).prefs.edit().putString("refresh_token",null).apply();
    }
}
