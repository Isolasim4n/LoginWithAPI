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

import id.co.asyst.prasetya.logintest.Model.Task;
import id.co.asyst.prasetya.logintest.R;
import id.co.asyst.prasetya.logintest.Utility.DateUtil;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<Task> mListTask;
    OnItemClickListener itemClick;

    public TaskAdapter(Context mContext, ArrayList<Task> mListTask, OnItemClickListener itemClick) {
        this.mContext = mContext;
        this.mListTask = mListTask;
        this.itemClick = itemClick;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new TaskAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Task task = mListTask.get(position);
        holder.customer_id_textView.setText(task.getCustomer_id());
        holder.name_textView.setText(task.getCustomer_name());
        holder.alamat_textView.setText(task.getCustomer_address());
        holder.id_textView.setText("#" + task.getTask_id());
        holder.tanggal_textView.setText(DateUtil.formatDate("yyyy-MM-dd", "dd MMMM yyyy", task.getStartDate()));
        if (task.getFinishDate() != null) {
            holder.tanggal_selesai_textView.setVisibility(View.VISIBLE);
            holder.tanggal_selesai_textView.setText(DateUtil.formatDate("yyyy-MM-dd", "dd MMMM yyyy", task.getFinishDate()));
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.onItemClick(task);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mListTask.size();
    }

    public interface OnItemClickListener {
        void onItemClick(Task task);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name_textView;
        TextView alamat_textView;
        TextView id_textView;
        TextView customer_id_textView;
        TextView tanggal_textView;
        TextView tanggal_selesai_textView;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            name_textView = itemView.findViewById(R.id.name_client_textView);
            alamat_textView = itemView.findViewById(R.id.alamat_client_textView);
            id_textView = itemView.findViewById(R.id.id_client_textView);
            customer_id_textView = itemView.findViewById(R.id.client_id_textView);
            tanggal_textView = itemView.findViewById(R.id.tanggal_mulai_client_textView);
            tanggal_selesai_textView = itemView.findViewById(R.id.tanggal_selesai_client_textView);

            cardView = itemView.findViewById(R.id.card_view);

        }
    }

}
