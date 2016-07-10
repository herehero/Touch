package com.example.administrator.touch.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.administrator.touch.TouchApplication;

/**
 * Created by Administrator on 10/07/2016.
 */
public class SPUtil {
    private static SPUtil instance;
    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mEditor;

    private SPUtil() {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(TouchApplication.instance);
        mEditor = mPrefs.edit();
    }

    public static SPUtil getInstance() {
        if (instance == null) {
            synchronized (SPUtil.class) {
                if (instance == null) {
                    instance = new SPUtil();
                }
            }
        }
        return instance;
    }

    public boolean getPrefBoolean(String key, boolean defValue) {
        boolean value = mPrefs.getBoolean(key, defValue);
        return value;
    }
    public void putPrefBoolean(String key,boolean value){
        mEditor.putBoolean(key,value);
        mEditor.commit();
    }

    public String getPrefString(String key,String defValue){
        String value=mPrefs.getString(key,defValue);
        return value;
    }
    public void putPrefString(String key,String value){
        mEditor.putString(key,value);
        mEditor.commit();
    }
}
