package id.co.asyst.prasetya.logintest.Model;

import com.google.gson.annotations.SerializedName;

public class TaskResponse {
    String status;
    String message;
    @SerializedName("data")
    Task task;

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

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
