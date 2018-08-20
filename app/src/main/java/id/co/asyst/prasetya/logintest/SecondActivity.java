package id.co.asyst.prasetya.logintest;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.asyst.prasetya.logintest.Adapter.TaskAdapter;
import id.co.asyst.prasetya.logintest.Model.Task;
import id.co.asyst.prasetya.logintest.Model.TaskRequest;
import id.co.asyst.prasetya.logintest.Model.TaskResponse;
import id.co.asyst.prasetya.logintest.Model.TaskUser;
import id.co.asyst.prasetya.logintest.Retrofit.ApiClient;
import id.co.asyst.prasetya.logintest.Retrofit.ApiServices;
import id.co.asyst.prasetya.logintest.Utility.SessionUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        taskAdapter = new TaskAdapter(this, list_task, new TaskAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Task task) {
                Toast.makeText(getApplicationContext(), "Nama Customer : " + task.getCustomer_name(), Toast.LENGTH_SHORT).show();
            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(taskAdapter);

        getTaskWithRetrofit();
    }

    private void getTaskWithRetrofit() {
        TaskRequest taskRequest = new TaskRequest();
        TaskUser taskUser = new TaskUser();
        final Task task = new Task();
        taskRequest.setMethod("getAllTask");
        taskUser.setUsername(sessionUtil.loadUserName());
        taskRequest.setTaskUser(taskUser);

        ApiServices apiServices = ApiClient.newInstance(getApplicationContext()).create(ApiServices.class);
        Call<TaskResponse> call = apiServices.reqTask(taskRequest);

        call.enqueue(new Callback<TaskResponse>() {
            @Override
            public void onResponse(Call<TaskResponse> call, Response<TaskResponse> response) {

                if (response.body() != null) {
                    list_task.addAll(response.body().getGetAllTask());
                    taskAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<TaskResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failed to get data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.logout:
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                alertDialog.setTitle("Confirmation")
                        .setCancelable(false)
                        .setMessage("Apakah anda yakin ingin Logout ?").setPositiveButton("No", null)
                        .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                sessionUtil.saveName("", "");
                                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }).show();

                break;
        }

        return super.onOptionsItemSelected(item);
    }
}

