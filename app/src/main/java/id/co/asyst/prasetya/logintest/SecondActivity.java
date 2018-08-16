package id.co.asyst.prasetya.logintest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.asyst.prasetya.logintest.Adapter.TaskAdapter;
import id.co.asyst.prasetya.logintest.Model.Task;
import id.co.asyst.prasetya.logintest.Model.UserRequest;
import id.co.asyst.prasetya.logintest.Retrofit.ApiClient;
import id.co.asyst.prasetya.logintest.Retrofit.ApiServices;
import id.co.asyst.prasetya.logintest.Utility.SessionUtil;

public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    TaskAdapter taskAdapter;
    SessionUtil sessionUtil;
    ArrayList<Task> list_task = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ButterKnife.bind(this);
        sessionUtil = new SessionUtil(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(taskAdapter);

        getTaskWithRetrofit();
    }

    private void getTaskWithRetrofit() {
        UserRequest userRequest = new UserRequest();
        userRequest.setMethod("getAllTask");

        ApiServices apiServices = ApiClient.newInstance(getApplicationContext()).create(ApiServices.class);

    }
}
