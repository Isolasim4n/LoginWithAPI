package id.co.asyst.prasetya.logintest.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UserRequest {
    String method;
    @SerializedName("param")
    ArrayList<User> userAndPass;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public ArrayList<User> getUserAndPass() {
        return userAndPass;
    }

    public void setUserAndPass(ArrayList<User> userAndPass) {
        this.userAndPass = userAndPass;
    }


}
