package id.co.asyst.prasetya.logintest.Model;

public class Task {

    String customer_name;
    String customer_address;
    String taskActivity_id;
    String startDate;
    String finishDate;

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getTaskActivity_id() {
        return taskActivity_id;
    }

    public void setTaskActivity_id(String taskActivity_id) {
        this.taskActivity_id = taskActivity_id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

}
