package com.exempel.student2student.student2student;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;


/**
 * Created by דדי on 13/01/2015.
 */
public class DBDal
{
        //when i want to read and display somthing from DB i need to use Curser
    dataBaseHandler db;

    public DBDal(Context con)
    {
        db = new dataBaseHandler(con);
    }

    public void addStudentToDB(String first,String last,String user,int id,String mail,String lob)
    {
//        Toast.makeText(,"ok",Toast.LENGTH_LONG).show();
        SQLiteDatabase dbw = db.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(DBColumns.FIRST_NAME,first);
        values.put(DBColumns.LAST_NAME,last);
        values.put(DBColumns.USER_NAME,user);
        values.put(DBColumns.ID,id);
        values.put(DBColumns.E_MAIL,mail);
        values.put(DBColumns.LINE_OF_BUSINESS, lob);

        dbw.insertOrThrow(DBColumns.STUDENTS_TABLE_NAME, null, values);
        dbw.close();
    }

    public void addCorseToDB(String courseName,int courseNumber ,String occupation)
    {
        SQLiteDatabase dbw = db.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DBColumns.COURSE_NAME,courseName);
        values.put(DBColumns.COURSE_NUMBER, courseNumber);
        values.put(DBColumns.COURSE_OCCUPATION,occupation);

        dbw.insertOrThrow(DBColumns.COURSES_TABLE_NAME, null, values);
        Log.i("TAG", courseName + " " + courseNumber + " " + occupation + " asdsadsadasdasas");
        dbw.close();

    }

    public Cursor readFromStudentDB() {
        try {
            SQLiteDatabase dbr = db.getReadableDatabase();


            String[] columns = {DBColumns.FIRST_NAME, DBColumns.LAST_NAME, DBColumns.USER_NAME, DBColumns.ID, DBColumns.E_MAIL, DBColumns.LINE_OF_BUSINESS};
            Cursor c = dbr.query(DBColumns.STUDENTS_TABLE_NAME, columns, null, null, null, null, null, null);
            if (c != null) {
                c.moveToFirst();
            }
            dbr.close();
            return c;

        } catch (Exception e)
        {
            Log.e("ERROR", String.valueOf(e.getStackTrace()));
            return null;
        }

    }


    public Cursor readCourseTable()
    {
        SQLiteDatabase dbr = db.getReadableDatabase();

        String str = "";
        String [] columns = {DBColumns.COURSE_NUMBER,DBColumns.COURSE_NAME};
        Cursor c = dbr.query(DBColumns.COURSES_TABLE_NAME, columns, null, null, null, null, null, null);
        Log.i("TAG"," dsfdsf "+c.getCount());
        if(c != null)
        {
            c.moveToFirst();
        }
        dbr.close();
        return c;
    }


    public boolean checkIfUserNameAndIDExist(String username, String id)
    {
        SQLiteDatabase dbr = db.getReadableDatabase();
        Cursor cursor = dbr.rawQuery("select "+ DBColumns.ID+ " from "+DBColumns.STUDENTS_TABLE_NAME + " where "+DBColumns.USER_NAME + " = ? and "+DBColumns.ID + " = ? ",new String[]{username,id});
        Log.i("it's ok", cursor.getColumnName(0));
        if(cursor.getCount() == 0)
            return false;
        return true;
    }

    public boolean checkIfUserExist( String id)
    {
        SQLiteDatabase dbr = db.getReadableDatabase();
        Log.i("error","error");
        Cursor cursor = dbr.rawQuery("select " + DBColumns.ID + " from " + DBColumns.STUDENTS_TABLE_NAME + " where " + DBColumns.ID + " = ?", new String[]{id});
        if(cursor.getCount()==0)
            return false;
        return true;

    }

    public Cursor whichCourseByLineOfBusiness(String lob) {
        SQLiteDatabase dbr = db.getReadableDatabase();
        Cursor cursor = dbr.rawQuery("select " + DBColumns.COURSE_NAME + "," + DBColumns.COURSE_NUMBER + "from " + DBColumns.COURSES_TABLE_NAME + " where " + DBColumns.COURSE_OCCUPATION + "= ?", new String[]{lob});

        if (cursor.getCount() == 0)
        {
            System.out.println("wrong input line of business");
            return null;
        }
        else
        {
            return cursor;
        }

    }

    public String getFirstNameByID(String id)
    {
        String tmp = "";
        SQLiteDatabase dbr = db.getReadableDatabase();

        Cursor cursor = dbr.rawQuery("select " + DBColumns.FIRST_NAME + " from " + DBColumns.STUDENTS_TABLE_NAME + " where " + DBColumns.ID + " = ?", new String[]{id});
        if(!cursor.moveToFirst())
        {
            tmp = "wrong id!!";
            System.exit(1);
        }
        else
        {
            Log.i("FirstName",cursor.getString(cursor.getColumnIndex(DBColumns.FIRST_NAME )));
            tmp = cursor.getString(cursor.getColumnIndex(DBColumns.FIRST_NAME));
        }
        return tmp;
    }

    public String getLastNameByID(String id)
    {
        String tmp = "";
        SQLiteDatabase dbr = db.getReadableDatabase();

        Cursor cursor = dbr.rawQuery("select " + DBColumns.LAST_NAME + " from " + DBColumns.STUDENTS_TABLE_NAME + " where " + DBColumns.ID + " = ?", new String[]{id});
        if(!cursor.moveToFirst())
        {
            tmp = "wrong id!!";
            System.exit(1);
        }
        else
        {
            Log.i("LastName",cursor.getString(cursor.getColumnIndex(DBColumns.LAST_NAME )));
            tmp = cursor.getString(cursor.getColumnIndex(DBColumns.LAST_NAME));
        }
        return tmp;
    }

    public String getEmaleByID(String id)
    {
        String tmp = "";
        SQLiteDatabase dbr = db.getReadableDatabase();

        Cursor cursor = dbr.rawQuery("select " + DBColumns.E_MAIL+ " from " + DBColumns.STUDENTS_TABLE_NAME + " where " + DBColumns.ID + " = ?", new String[]{id});
        if(!cursor.moveToFirst())
        {
            tmp = "wrong id!!";
            System.exit(1);
        }
        else
        {
            Log.i("email",cursor.getString(cursor.getColumnIndex(DBColumns.E_MAIL )));
            tmp = cursor.getString(cursor.getColumnIndex(DBColumns.E_MAIL));
        }
        return tmp;
    }

    public String getOccupationNameByID(String id)
    {
        String tmp = "";
        SQLiteDatabase dbr = db.getReadableDatabase();

        Cursor cursor = dbr.rawQuery("select " + DBColumns.LINE_OF_BUSINESS+ " from " + DBColumns.STUDENTS_TABLE_NAME + " where " + DBColumns.ID + " = ?", new String[]{id});
        if(!cursor.moveToFirst())
        {
            tmp = "wrong id!!";
            System.exit(1);
        }
        else
        {
            Log.i("lineOfBusiness",cursor.getString(cursor.getColumnIndex(DBColumns.LINE_OF_BUSINESS )));
            tmp = cursor.getString(cursor.getColumnIndex(DBColumns.LINE_OF_BUSINESS));
        }
        return tmp;
    }

    public void updateStudentDetails(String first, String last, String user, String id, String email, Boolean teach)
    {
            
    }
}

