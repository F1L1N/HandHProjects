package com.example.user.app1;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Comparator;
import java.util.TreeSet;

public class Activity1 extends AppCompatActivity {

    TreeSet<String> dictionary = new TreeSet<>(new Comparator<String>() {
        @Override
        public int compare(String s, String t1) {
            return s.compareTo(t1);
        }
    });

    Button button1;
    Button button2;
    EditText edit;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button1.setOnClickListener(oncBtnOk1);
        button2.setOnClickListener(oncBtnOk2);
        text = findViewById(R.id.textView);
        edit = findViewById(R.id.editText);
    }

    public void showToast(View view) {
        @SuppressLint("ShowToast") Toast toast = Toast.makeText(getApplicationContext(), "Запись произведена.", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    View.OnClickListener oncBtnOk1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dictionary.add(String.valueOf(edit.getText()));
            edit.setText("");
            showToast(view);
        }
    };

    View.OnClickListener oncBtnOk2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            StringBuilder texts = new StringBuilder();
            for (String aDictionary : dictionary) texts.append(aDictionary).append("\n");
            text.setText(String.valueOf(texts));
        }
    };
}
