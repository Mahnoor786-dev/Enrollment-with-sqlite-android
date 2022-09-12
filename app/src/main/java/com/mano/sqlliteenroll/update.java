package com.mano.sqlliteenroll;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class update extends AppCompatActivity {

    EditText id, name, stuClass;
    Switch isRegular;
    Button updateBtn;
    Student stu;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        updateBtn = findViewById(R.id.updateBtn);

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = new DatabaseHelper(update.this);
                id=findViewById(R.id.stuId);
                name=findViewById(R.id.name);
                stuClass=findViewById(R.id.classs);
                isRegular=findViewById(R.id.regular);
                stu = new Student(Integer.parseInt(id.getText().toString()) ,name.getText().toString(), stuClass.getText().toString(), isRegular.isChecked());
                db.updateStudent(stu);
                Toast.makeText(update.this, "sucessfully Updated", Toast.LENGTH_LONG).show();
            }
        });
    }
}