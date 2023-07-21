package com.favric.legal.Clases;


import android.content.Context;
import android.content.SharedPreferences;

public class Shared {
    public static String preferenceName="shared" ;
    public static void setValuesPreference (Context context, String nameField, String value){
        SharedPreferences sharedPref = context.getSharedPreferences(preferenceName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(nameField, value);
        editor.commit();
    }

    public static String getValuesPreference (Context context, String nameField){
        SharedPreferences sharedPref = context.getSharedPreferences(preferenceName,Context.MODE_PRIVATE);
        String highScore = sharedPref.getString(nameField, "");
        if(highScore == null){
            highScore = "";
        }
        return highScore;
    }
}

