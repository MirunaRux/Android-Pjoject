package com.example.mirunabudoias.myfirstapplication.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class Constants {

    public static  final String PREFS = "myPrefs";
    public static  final String PREFS_TERMS_ACCEPT = "myPrefs_Terms";
    public static  final String PREFS_REMEMBER = "myPrefs_Remember";
    public static final String PREFS_USER = "myPrefs_User";
    public static final int REQUEST_CODE_CREATE_ACCOUNT = 1997;
    public static final String EXTRA_KEY_CREATE_ACCOUNT_USER = "key_create_account_user";
    public static void showKeyboard(Context context){
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
    }

    public static void hideKeyboard(Context context, View currentView){
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(currentView.getWindowToken(),0);
    }
}
