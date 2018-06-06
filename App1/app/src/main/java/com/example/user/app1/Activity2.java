package com.example.user.app1;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class Activity2 extends AppCompatActivity {

    @SuppressLint("UseSparseArrays")
    HashMap<Long, Student> students = new HashMap<>();
    Button button;
    EditText edit;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        button = findViewById(R.id.button);
        button.setOnClickListener(oncBtnOk);
        text = findViewById(R.id.textView);
        edit = findViewById(R.id.editText);

        edit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                    addStudent();
                    return true;
                }
                return false;
            }
        });
    }

    View.OnClickListener oncBtnOk = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            StringBuilder texts = new StringBuilder();
            for (Map.Entry<Long, Student> entry : students.entrySet())
                texts.append(entry.getValue().toString());
            text.setText(String.valueOf(texts));
        }
    };

    public void addStudent() {
        String split[] = String.valueOf(edit.getText()).split(" ");
        long ID = System.currentTimeMillis();
        Student student = new Student(ID, split[0], split[1], split[2], Integer.valueOf(split[3]));
        students.put(student.getID(), student);
        edit.setText("");
    }
}
