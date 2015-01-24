package com.exempel.student2student.student2student;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by דדי on 13/01/2015.
 */
public class studentsTable extends SQLiteOpenHelper
{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_FILE = "file.db";

    public studentsTable(Context con)
    {
        super(con,DATABASE_FILE,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE "+DBColumns.STUDENTS_TABLE_NAME+ "(" +DBColumns._ID+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
        + DBColumns.FIRST_NAME+" TEXT_TYPE,"
        + DBColumns.LAST_NAME+" TEXT_TYPE,"
        + DBColumns.ID+ " INTEGER,"
        + DBColumns.E_MAIL+" TEXT_TYPE,"
        + DBColumns.OCCUPATION+ " TEXT_TYPE);" );

        db.execSQL("CREATE TABLE "+DBColumns.COURSES_TABLE_NAME+ "(" +DBColumns._ID+ "  INTEGER AUTOINCREMENT,"
        +DBColumns.COURSE_NUMBER+" INTEGER,"
        +DBColumns.COURSE_NAME+" TEXT_TYPE,"
        +"PRIMARY KEY ("+DBColumns.COURSE_NUMBER+");" );

        db.execSQL("CREATE TABLE "+DBColumns.TEACHERS_TABLE_NAME+ "(" +DBColumns._ID+ " INTEGER AUTOINCREMENT,"
        +DBColumns.TEACHER_ID+" INTEGER,"
        +DBColumns.COURSE_NUMBER+" INTEGER,"
        +"PRIMARY KEY ("+DBColumns.TEACHER_ID+","+DBColumns.COURSE_NUMBER+");");

        db.execSQL("CREATE TABLE "+DBColumns.SEEKERS_TABLE_NAME+ "(" +DBColumns._ID+ " INTEGER AUTOINCREMENT,"
        +DBColumns.SEEKER_ID+" INTEGER,"
        +DBColumns.COURSE_NUMBER+" INTEGER,"
        +"PRIMARY KEY ("+DBColumns.SEEKER_ID+","+DBColumns.COURSE_NUMBER+");");

        db.execSQL("CREATE TABLE "+DBColumns.MATCHING_TABLE_NAME+"("+DBColumns._ID+ " INTEGER AUTOINCREMENT,"
        +DBColumns.COURSE_NUMBER+ " INTEGER,"
        +DBColumns.TEACHER_ID+ " INTEGER,"
        +DBColumns.SEEKER_ID+ " INTEGER,"
        +"PRIMARY KEY ("+DBColumns.COURSE_NUMBER+","+DBColumns.TEACHER_ID+","+DBColumns.SEEKER_ID+");" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {
        db.execSQL("DROP TABLE IF EXIST "+DBColumns.STUDENTS_TABLE_NAME);

    }
}
