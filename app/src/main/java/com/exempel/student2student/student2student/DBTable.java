package com.exempel.student2student.student2student;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by דדי on 13/01/2015.
 */
public class DBTable extends SQLiteOpenHelper
{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_FILE = "file.db";

    public DBTable(Context con)
    {
        super(con,DATABASE_FILE,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE "+DBColumns.TABLE_NAME+ "(" +DBColumns._ID+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
        + DBColumns.FIRST_NAME+" TEXT_TYPE,"
        + DBColumns.LAST_NAME+" TEXT_TYPE,"
        + DBColumns.ID+ " INTEGER,"
        + DBColumns.E_MAIL+" TEXT_TYPE,"
        + DBColumns.OCCUPATION+ " TEXT_TYPE);" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {
        db.execSQL("DROP TABLE IF EXIST "+DBColumns.TABLE_NAME);
    }
}
