package com.exempel.student2student.student2student;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by דדי on 13/01/2015.
 */
public class dataBaseHandler extends SQLiteOpenHelper
{
    public static final String COLUMN_ID = "_id";

    public static final int DATABASE_VERSION = 5;
    public static final String DATABASE_FILE = "file.db";
    public Cursor query;


    public dataBaseHandler(Context con)
    {
        super(con,DATABASE_FILE,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE "+DBColumns.STUDENTS_TABLE_NAME+ "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
        + DBColumns.FIRST_NAME+" TEXT_TYPE,"
        + DBColumns.LAST_NAME+" TEXT_TYPE,"
        + DBColumns.USER_NAME+" TEXT_TYPE,"
        + DBColumns.ID+ " INTEGER ,"
        + DBColumns.E_MAIL+" TEXT_TYPE,"
        + DBColumns.LINE_OF_BUSINESS+ " TEXT_TYPE);" );

        db.execSQL("CREATE TABLE "+DBColumns.COURSES_TABLE_NAME+ "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
        +DBColumns.COURSE_NUMBER+" INTEGER,"
        +DBColumns.COURSE_NAME+" TEXT_TYPE,"
        +DBColumns.COURSE_OCCUPATION+ " TEXT_TYPE );" );

        db.execSQL("CREATE TABLE "+DBColumns.TEACHERS_TABLE_NAME+ "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
        +DBColumns.TEACHER_ID+" INTEGER,"
        +DBColumns.COURSE_NUMBER+" INTEGER);");

        db.execSQL("CREATE TABLE "+DBColumns.SEEKERS_TABLE_NAME+ "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
        +DBColumns.SEEKER_ID+" INTEGER,"
        +DBColumns.COURSE_NUMBER+" INTEGER);");

        db.execSQL("CREATE TABLE "+DBColumns.MATCHING_TABLE_NAME+"("+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
        +DBColumns.COURSE_NUMBER+ " INTEGER,"
        +DBColumns.TEACHER_ID+ " INTEGER,"
        +DBColumns.SEEKER_ID+ " INTEGER,"
        +DBColumns.STATUS+ " TEXT_TYPE);" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + DBColumns.STUDENTS_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + DBColumns.COURSES_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + DBColumns.TEACHERS_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + DBColumns.SEEKERS_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + DBColumns.MATCHING_TABLE_NAME);
        onCreate(db);
    }
}
