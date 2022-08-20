package com.mano.sqlliteenroll;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String table = "STUDENT_TABLE";
    public static final String StudentId = "ID";
    public static final String StudentName = "STUDENT_NAME";
    public static final String StudentClass = "STUDENT_CLASS";
    public static final String isRegular = "IS_REGULAR";

    //removed last 3 parameters from constructor of type1.. and hardcoded those last 3 parameters for super() call as we are here working with only 1 db
    public DatabaseHelper(@Nullable Context context) {
        super(context, "students.db", null, 1);
    }

    //It's automatically called when app requests or inputs new data. --> we need to create a new table inside this method
    //this is called the first time a database is accessed. There should be code in here to create a new database
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableQuery = "CREATE TABLE " + table + " (" + StudentId + " INTEGER PRIMARY KEY AUTOINCREMENT,  " + StudentName + " TEXT, " + StudentClass + " TEXT, " + isRegular + " BOOL)";
        sqLiteDatabase.execSQL(createTableQuery);
    }

    /* Eg v1 of ur app, its out to the world and u got 5M users... then u want new feature ond would like to add a new table.. then instead of crashing
    the app bcz it does not line up with.. so we use onUpgrade that triggers automatically and modifies the schema for DB whenever needs to be done.
    Hence provides a forward compatibility and a backward compat */

    //this is called if the database version number changes. It prevents previous users apps from breaking when you change the DB design.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public boolean addStudent(Student stu) {
        //getWritableDatabase for insert actions , getReadableDatabase for select (read) actions.
       SQLiteDatabase db = this.getWritableDatabase();
        // ContentValues stores data in pairs. works like hashmap...
        ContentValues cv = new ContentValues();
        cv.put(StudentName, stu.getName());
        cv.put(StudentClass, stu.getStuClass());
        cv.put(isRegular, stu.isRegular());

        // db.insert(table, null, cv); Instead of just calling insert function, return its result in a local variable. if it returns -ve number, unsucessful. if it returns +ve number, sucessful
        long insert = db.insert(table, null, cv); //
        return insert != -1; //if -1, return false else true
    }

    public List<Student> getStudents(){
        List<Student> studentsList = new ArrayList<>();
        String queryString = "SELECT * FROM " + table;
        // using getReadable database, you can access db from multiple places
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);  // Cursor is the result set from a SQL statement.
        //check if we got some result from db
        if(cursor.moveToFirst())
        {
            //loop through the cursor (result set) and create new student objects. put them into return list
            do {
                String name  = cursor.getString(1);
                String stuClass  = cursor.getString(2);
                boolean regularStudent = cursor.getInt(3) == 1? true: false;
                Student stu = new Student(name, stuClass, regularStudent);
                studentsList.add(stu);

            }while (cursor.moveToNext());
        }
        else {
                // failure, do not add anything to list
        }
        cursor.close();
        db.close();
        return studentsList;
    }

}
