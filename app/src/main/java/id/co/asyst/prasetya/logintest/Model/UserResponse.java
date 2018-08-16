package id.co.asyst.prasetya.logintest.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UserResponse {

    String status;
    String message;
    @SerializedName("data")
    ArrayList<UserData> data_user;

    public ArrayList<UserData> getData_user() {
        return data_user;
    }

    public void setData_user(ArrayList<UserData> data_user) {
        this.data_user = data_user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
