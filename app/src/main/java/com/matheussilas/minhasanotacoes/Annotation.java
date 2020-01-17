package com.matheussilas.minhasanotacoes;

import android.content.Context;
import android.content.SharedPreferences;

public class Annotation {

    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private final String ARCHIVE_NAME = "Annotation";
    private final String KEY_NAME = "name";

    public Annotation(Context c) {
        this.context=c;
        preferences = context.getSharedPreferences(ARCHIVE_NAME, 0);
        editor = preferences.edit();
    }

    public void saveAnnotation(String annotation){

        editor.putString(KEY_NAME, annotation);
        editor.commit();

    }

    public String recoverAnnotation(){

        return preferences.getString(KEY_NAME, "");
    }
}
