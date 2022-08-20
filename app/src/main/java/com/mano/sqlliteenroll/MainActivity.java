package com.mano.sqlliteenroll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, Registration, s_Class;
    Switch regular;
    Button enroll, viewAll;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        Registration=findViewById(R.id.regId);
        s_Class=findViewById(R.id.grade);
        regular=findViewById(R.id.regular);
        list=findViewById(R.id.stu_list);
        enroll=findViewById(R.id.enroll);
        viewAll=findViewById(R.id.viewAll);

        enroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student stu;
                try {
                    stu = new Student(name.getText().toString(), s_Class.getText().toString(), regular.isChecked());
                    Toast.makeText(MainActivity.this, stu.toString(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    stu = new Student("error", "error", false);
                    Toast.makeText(getApplicationContext(), "error creating student", Toast.LENGTH_SHORT).show();
                }
                DatabaseHelper db = new DatabaseHelper(MainActivity.this);
                boolean success = db.addStudent(stu);
                Toast.makeText(MainActivity.this, "sucessfully added: " + success, Toast.LENGTH_LONG).show();
            }
        });

        viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "show students", Toast.LENGTH_SHORT).show();
            }
        });







    }
}