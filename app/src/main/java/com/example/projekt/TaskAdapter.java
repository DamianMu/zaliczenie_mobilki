package com.example.projekt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TaskAdapter extends BaseAdapter {
    private Context context;
    private AppDatabase db;
    private TaskDao taskDao;

    public TaskAdapter(Context context) {
        this.context = context;
        db = AppDatabase.getInstance(context);
        taskDao = db.taskDao();
    }

    @Override
    public int getCount() {
        return taskDao.count();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.tasks, parent, false);

        Task task = taskDao.findById(position + 1);

        TextView title = rowView.findViewById(R.id.show_title);
        TextView description = rowView.findViewById(R.id.show_description);
        TextView status = rowView.findViewById(R.id.show_status);

        if (task == null){
            return rowView;
        }

        title.setText(task.title);
        description.setText(task.description);
        status.setText(task.status);
        return rowView;
    }
}
