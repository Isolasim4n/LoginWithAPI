package id.co.asyst.prasetya.logintest.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.asyst.prasetya.logintest.Model.Task;
import id.co.asyst.prasetya.logintest.R;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<Task> mListTask;

    public TaskAdapter(Context mContext, ArrayList<Task> mListTask) {
        this.mContext = mContext;
        this.mListTask = mListTask;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new TaskAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Task task = mListTask.get(position);
        holder.name_textView.setText(task.getCustomer_name());
        holder.alamat_textView.setText(task.getCustomer_address());
        holder.id_textView.setText(task.getTaskActivity_id());
        holder.tanggal_textView.setText(task.getStartDate());

    }

    @Override
    public int getItemCount() {
        return mListTask.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.name_client_textView)
        TextView name_textView;
        @BindView(R.id.alamat_client_textView)
        TextView alamat_textView;
        @BindView(R.id.id_client_textView)
        TextView id_textView;
        @BindView(R.id.tanggal_mulai_client_textView)
        TextView tanggal_textView;
        @BindView(R.id.card_view)
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this.itemView);

        }
    }

}
