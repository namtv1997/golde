package com.app.goldenhealth.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.model.Token;
import com.app.goldenhealth.model.User;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PrefUtil {

    private static final String TAG = "SHAREPREF";
    private static PrefUtil sInstance;

    public static PrefUtil getInstance() {
        if (sInstance == null) {
            sInstance = new PrefUtil();
        }
        return sInstance;
    }

    public static void saveBoolean(Context context, String key, boolean value) {
        SharedPreferences preferences = context.getSharedPreferences(Key.APP_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static boolean getBoolean(Context context, String key, boolean defaultValue) {
        SharedPreferences preferences = context.getSharedPreferences(Key.APP_PREFERENCE, Context.MODE_PRIVATE);
        return preferences.getBoolean(key, defaultValue);
    }



    public static void saveString(Context context, String key, String value) {
        SharedPreferences preferences = context.getSharedPreferences(Key.APP_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getString(Context context, String key, String defaultValue) {
        SharedPreferences preferences = context.getSharedPreferences(Key.APP_PREFERENCE, Context.MODE_PRIVATE);
        return preferences.getString(key, defaultValue);
    }

    public static void saveInt(Context context, String key, int value) {
        SharedPreferences preferences = context.getSharedPreferences(Key.APP_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static int getInt(Context context, String key, int defaultValue) {
        SharedPreferences preferences = context.getSharedPreferences(Key.APP_PREFERENCE, Context.MODE_PRIVATE);
        return preferences.getInt(key, defaultValue);
    }

    public static void saveBoolean(Context context, String key, boolean value, String name) {
        if (name == null || name.equals("")) {
            name = Key.APP_PREFERENCE;
        }
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static void delete(Context context, String name) {
        if (name == null || name.equals("")) {
            name = Key.APP_PREFERENCE;
        }
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
    }

    public static boolean getBoolean(Context context, String key, boolean defaultValue, String name) {
        if (name == null || name.equals("")) {
            name = Key.APP_PREFERENCE;
        }
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return preferences.getBoolean(key, defaultValue);
    }

    public static long[] getAllkey(Context context, String name) {
        String TAG = "FILTERS";
        long[] res;

        Map<String, ?> keys = context.getSharedPreferences(name, Context.MODE_PRIVATE).getAll();
        Log.d(TAG, "getAllkey size:" + keys.toString());
        res = new long[keys.size()];
        int i = 0;
        for (Map.Entry<String, ?> entry : keys.entrySet()) {
            res[i] = Integer.parseInt(entry.getValue().toString());
            Log.d(TAG, "getAllkey: " + res[i] + "       " + entry.getValue());
            i = i + 1;
        }
        return res;
    }

    public static void saveLong(Context context, String key, long value, String name) {
        if (name == null || name.isEmpty()) {
            name = Key.APP_PREFERENCE;
        }
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public static long getLong(Context context, String key, long defaultValue, String name) {
        if (name == null || name.isEmpty()) {
            name = Key.APP_PREFERENCE;
        }
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return preferences.getLong(key, defaultValue);
    }

    public static void saveDataUser(User user, Context context) {
        SharedPreferences preferences = context.getSharedPreferences(Key.APP_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = preferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(user);
        prefsEditor.putString(Key.DATA_USER, json);
        prefsEditor.commit();
    }

    public static User getDataUser(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(Key.APP_PREFERENCE, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = preferences.getString(Key.DATA_USER, "");
        User obj = gson.fromJson(json, User.class);
        return obj;
    }

    public static void saveToken(Token token, Context context) {
        SharedPreferences preferences = context.getSharedPreferences(Key.APP_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = preferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(token);
        prefsEditor.putString(Key.TOKEN, json);
        prefsEditor.commit();
    }

    public static Token getToken(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(Key.APP_PREFERENCE, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = preferences.getString(Key.TOKEN, "");
        Token obj = gson.fromJson(json, Token.class);
        return obj;
    }


    public SharedPreferences get(Context context) {
        return context.getSharedPreferences(Key.APP_PREFERENCE, Context.MODE_PRIVATE);
    }

    public static void saveSearcHistory(List<String> history, Context context) {
        SharedPreferences preferences = context.getSharedPreferences(Key.APP_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = preferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(history);
        prefsEditor.putString(Key.SEARCH_HISTORY, json);
        prefsEditor.apply();
    }

    public static List<String> getSearchHistory(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(Key.APP_PREFERENCE, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = preferences.getString(Key.SEARCH_HISTORY, "");
        if (!json.isEmpty()){
            List<String> textList = Arrays.asList(gson.fromJson(json, String[].class));
            return textList;
        }else {
            return new ArrayList<>();
        }
    }
}
