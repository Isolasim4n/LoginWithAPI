package id.co.asyst.prasetya.logintest.Model;

import com.google.gson.annotations.SerializedName;

public class TaskRequest {

    String method;
    @SerializedName("param")
    TaskUser taskUser;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public TaskUser getTaskUser() {
        return taskUser;
    }

    public void setTaskUser(TaskUser taskUser) {
        this.taskUser = taskUser;
    }
}
