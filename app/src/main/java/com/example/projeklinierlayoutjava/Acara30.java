package com.example.projeklinierlayoutjava;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.prefs.PreferencesFactory;

public  class Acara30 {
    static final String KEY_USER_TEREGISTER ="user", KEY_PASS_TEREGISTER = "pass";
    static final String KEY_USERNAME_SEDANG_LOGIN = "username_logged_in";
    static final String KEY_STATUS_SEDANG_LOGIN = "status_logged_in";

    private static SharedPreferences getSharedPrefarence(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static String getRegisteredUser(Context context){
        return getSharedPrefarence(context).getString(KEY_USER_TEREGISTER,"");
    }

    public static void setRegisterPass(Context context, String password){
        SharedPreferences.Editor editor = getSharedPrefarence(context).edit();
        editor.putString(KEY_PASS_TEREGISTER, password);
        editor.apply();
    }

    public static String getRegisterPass(Context context){
        return getSharedPrefarence(context).getString(KEY_PASS_TEREGISTER,"");
    }

    
}
