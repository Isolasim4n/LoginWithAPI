package id.co.asyst.prasetya.logintest.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TaskResponse {
    String status;
    String message;
    @SerializedName("data")
    ArrayList<Task> getAllTask;

    public ArrayList<Task> getGetAllTask() {
        return getAllTask;
    }

    public void setGetAllTask(ArrayList<Task> getAllTask) {
        this.getAllTask = getAllTask;
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
