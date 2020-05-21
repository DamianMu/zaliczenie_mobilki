package com.example.projekt;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.projekt.R;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddTaskFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddTaskFragment extends Fragment {

    private AppDatabase db;
    private TaskDao taskDao;
    private EditText taskDescription;
    private EditText taskTitle;
    private Button addTask;
    private EditText taskStatus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_task, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = AppDatabase.getInstance(getContext());
        taskDao = db.taskDao();

        taskDescription = view.findViewById(R.id.task_description);
        taskTitle = view.findViewById(R.id.task_title);
        addTask = view.findViewById(R.id.add_task_button);
        taskStatus = view.findViewById(R.id.task_status);

        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String titleValue = taskTitle.getText().toString();
                String descriptionValue = taskDescription.getText().toString();
                String statusValue = taskStatus.getText().toString();

                if (titleValue.isEmpty() && descriptionValue.isEmpty() && statusValue.isEmpty()){
                    return;
                }

                taskDao.insertAll(new Task(titleValue, descriptionValue, statusValue));
                taskTitle.setText("Title");
                taskDescription.setText("Description...");
                taskStatus.setText("Status");
            }
        });

    }
}
