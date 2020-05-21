package com.example.zaliczenienotatki;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddNoteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddNoteFragment extends Fragment {

    private AppDatabase db;
    private NoteDao noteDao;
    private EditText noteText;
    private EditText noteTitle;
    private Button addNote;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = AppDatabase.getInstance(getContext());
        noteDao = db.noteDao();

        noteText = view.findViewById(R.id.et_note_text);
        noteTitle = view.findViewById(R.id.et_note_title);
        addNote = view.findViewById(R.id.bt_add_note);

        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String titleValue = noteTitle.getText().toString();
                String textValue = noteText.getText().toString();

                if (titleValue.isEmpty() && textValue.isEmpty()){
                    return;
                }

                noteDao.insertAll(new Note(titleValue, textValue));
                List<Note> noteList = noteDao.getAll();
                noteTitle.setText("");
                noteText.setText("");
            }
        });

    }
}
