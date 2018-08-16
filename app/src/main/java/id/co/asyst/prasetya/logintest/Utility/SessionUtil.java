package id.co.asyst.prasetya.logintest.Utility;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionUtil {

    public static final String USERNAME = "username";
    public static final String NAME = "name";
    Context mContext;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public SessionUtil(Context mContext) {
        this.mContext = mContext;

        sharedPreferences = mContext.getSharedPreferences("username", 0);
        editor = sharedPreferences.edit();
    }

    public void saveName(String username, String name) {
        editor.putString(USERNAME, username);
        editor.putString(NAME, name);
        editor.commit();
    }

    public String loadUserName() {
        String username = sharedPreferences.getString(USERNAME, "");
        return username;
    }

    public String loadName() {
        String name = sharedPreferences.getString(NAME, "");
        return name;
    }
}
