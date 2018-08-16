package id.co.asyst.prasetya.logintest.Utility;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionUtil {

    public static final String USERNAME = "username";
    Context mContext;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public SessionUtil(Context mContext) {
        this.mContext = mContext;

        sharedPreferences = mContext.getSharedPreferences("username", 0);
        editor = sharedPreferences.edit();
    }

    public void saveName(String username) {
        editor.putString(USERNAME, username);
        editor.commit();
    }

    public String loadName() {
        String username = sharedPreferences.getString(USERNAME, "");
        return username;
    }

}
