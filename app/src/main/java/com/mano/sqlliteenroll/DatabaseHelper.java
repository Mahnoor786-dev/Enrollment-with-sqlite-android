package com.mano.sqlliteenroll;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    //removed last 3 parameters from constructor of type1.. and hardcoded those last 3 parameters for super() call as we are here working with only 1 db
    public DatabaseHelper(@Nullable Context context) {
        super(context, "students.db", null, 1);
    }

    //It's automaically called whwn app reqests or inputs new data. --> we need to create a new table inside this method
    //this is called the first time a database is accessed. There should be code in here to create a new database
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableQuery = "CREATE TABLE STUDENT_TABLE (ID INTEGER PRIMARY KEY AUTOINCREMENT,  STUDENT_NAME TEXT, STUDENT_CLASS TEXT, REGULAR_STUDENT BOOL)";
        sqLiteDatabase.execSQL(createTableQuery);
    }


    /* Eg v1 of ur app, its out to the world and u got 5M users... then u want new feature ond would like to add a new table.. then instead of crashing
    the app bcz it does not line up with.. so we use onUpgrade that triggers automatically and modifies the schema for DB whenever needs to be done.
    Hence provides a forward compatibility and a backward compat */

    //this is called if the database version number changes. It prevents previous users apps from breaking when you change the DB design.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
