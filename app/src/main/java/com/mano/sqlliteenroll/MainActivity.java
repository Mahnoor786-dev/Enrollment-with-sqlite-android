package com.mano.sqlliteenroll;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText name, s_Class, stu_Id;
    Switch regular;
    Button enroll, viewAll;
    ListView list;
    DatabaseHelper db;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        stu_Id = findViewById(R.id.stu_id);
        s_Class=findViewById(R.id.grade);
        regular=findViewById(R.id.regular);
        list=findViewById(R.id.stu_list);
        enroll=findViewById(R.id.enroll);
        viewAll=findViewById(R.id.viewAll);
        db = new DatabaseHelper(MainActivity.this);

        enroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student stu;
                try {
                    stu = new Student(Integer.parseInt(stu_Id.getText().toString()) ,name.getText().toString(), s_Class.getText().toString(), regular.isChecked());
                    Toast.makeText(MainActivity.this, stu.toString(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    stu = new Student(-1,"error", "error", false);
                    Toast.makeText(getApplicationContext(), "error creating student", Toast.LENGTH_SHORT).show();
                }
                boolean success = db.addStudent(stu);
                Toast.makeText(MainActivity.this, "sucessfully added: " + success, Toast.LENGTH_LONG).show();
            }
        });

        viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = new DatabaseHelper(MainActivity.this);
                ShowStudentsOnListView(db);
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parentView, View view, int position, long l) {
                // identify and delete clicked student
                Student clickedStu = (Student) parentView.getItemAtPosition(position);
                db.deleteOne(clickedStu);
                // Print updated list
                ShowStudentsOnListView(db);
                Toast.makeText(MainActivity.this, "Deleted " + clickedStu, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void ShowStudentsOnListView(DatabaseHelper database)
    {
        adapter = new ArrayAdapter<Student>(MainActivity.this, android.R.layout.simple_list_item_1, db.getStudents());
        Toast.makeText(MainActivity.this, "Deleted " + db.getStudents(), Toast.LENGTH_SHORT).show();
        list.setAdapter(adapter);
    }

}