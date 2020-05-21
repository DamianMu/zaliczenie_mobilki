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
        View rowView = inflater.inflate(R.layout.task_item, parent, false);

        Task task = taskDao.findById(position + 1);

        TextView firstLine = rowView.findViewById(R.id.firstLine);
        TextView secondLine = rowView.findViewById(R.id.secondLine);

        if (task == null){
            return rowView;
        }

        firstLine.setText(task.title);
        secondLine.setText(task.text);
        return rowView;
    }
}
