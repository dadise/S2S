package com.exempel.student2student.student2student;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by דדי on 13/01/2015.
 */
public class DBDal
{
        //when i want to read and display somthing from DB i need to use Curser
    studentsTable db;

    public DBDal(Context con)
    {
        db = new studentsTable(con);
    }
    public void writeToDB(String first,String last,int id,String mail,String occ)
    {
        SQLiteDatabase dbw = db.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(DBColumns.FIRST_NAME,first);
        values.put(DBColumns.LAST_NAME,last);
        values.put(DBColumns.ID,id);
        values.put(DBColumns.E_MAIL,mail);
        values.put(DBColumns.OCCUPATION,occ);

        dbw.insertOrThrow(DBColumns.STUDENTS_TABLE_NAME,null,values);
        dbw.close();
    }

    public Cursor readFromDB()
    {
        SQLiteDatabase dbr = db.getReadableDatabase();

        String str = "";
        String [] columns = {DBColumns.FIRST_NAME,DBColumns.LAST_NAME};
        Cursor c = dbr.query(DBColumns.STUDENTS_TABLE_NAME,columns,null,null,null,null,null,null);
        while(c.moveToNext())
        {
            str += c.getString(1) + " "+ c.getString(2);
        }
        dbr.close();

        return c;
    }

}
