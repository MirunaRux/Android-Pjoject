package com.example.mirunabudoias.myfirstapplication.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceManager {
    public static void saveApproval(Context context, boolean accepted) {
        SharedPreferences pref = context.getSharedPreferences(Constants.PREFS, Context.MODE_PRIVATE);
        pref.edit().putBoolean(Constants.PREFS_TERMS_ACCEPT, accepted).commit();
    }

    public static void saveRememberMe(Context context, boolean remember) {
        SharedPreferences pref = context.getSharedPreferences(Constants.PREFS, Context.MODE_PRIVATE);
        pref.edit().putBoolean(Constants.PREFS_REMEMBER, remember).commit();
    }

    public static void saveUsername(Context context, String user){
        SharedPreferences pref = context.getSharedPreferences(Constants.PREFS, Context.MODE_PRIVATE);
        pref.edit().putString(Constants.PREFS_USER, user).commit();
    }

    public static boolean loadRemember(Context context){
        SharedPreferences pref = context.getSharedPreferences(Constants.PREFS, Context.MODE_PRIVATE);
        return pref.getBoolean(Constants.PREFS_REMEMBER, false);
    }

    public static boolean loadTermsApproval(Context context){
        SharedPreferences pref = context.getSharedPreferences(Constants.PREFS, Context.MODE_PRIVATE);
        return pref.getBoolean(Constants.PREFS_TERMS_ACCEPT, false);
    }

    public static String loadUsername(Context context){
        SharedPreferences pref = context.getSharedPreferences(Constants.PREFS, Context.MODE_PRIVATE);
        return pref.getString(Constants.PREFS_USER, "");
    }
}
