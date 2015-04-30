package com.exempel.student2student.student2student;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by דדי on 13/01/2015.
 */
public class BL
{
    DBDal dal;

    public BL(Context con)
    {
        dal = new DBDal(con);
    }

    public List<String> readFromStudentDB()
    {
        List<String> studentsList = new ArrayList<>();
        Cursor cursor = dal.readFromStudentDB();

        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {
            String s = cursor.getString(0)+" "+cursor.getString(1)+" "+cursor.getString(2)+" "+cursor.getString(3)+" "+cursor.getString(4)+" "+cursor.getString(5);
            studentsList.add(s);
            cursor.moveToNext();
        }
        cursor.close();
        return studentsList;
    }

    public List<String> whichCourseByLineOfBusiness(String lob)
    {
        List<String> cousreList = new ArrayList<>();
        Cursor cursor = dal.whichCourseByLineOfBusiness(lob);
        cursor.moveToFirst();

        while (!cursor.isAfterLast())
        {
            String s = cursor.getString(0);
            cousreList.add(s);
            cursor.moveToNext();
        }
        cursor.close();
        return cousreList;
    }

    public void addCorseToDB(String courseName , int courseNumber , String occupation)
    {
        dal.addCorseToDB(courseName, courseNumber, occupation);
    }

    public List<String> readCourseTable()
    {
        List<String> courseList = new ArrayList<>();
        Cursor cursor = dal.readCourseTable();
        cursor.moveToFirst();

        while(!cursor.isAfterLast())
        {
            String s = cursor.getString(0)+" "+cursor.getString(1);
            courseList.add(s);
            cursor.moveToNext();
            Log.i("TAG",s);
        }
        cursor.close();
        return courseList;
    }

    public void addStudentToDB(String first,String last,String user,int id,String mail,String occ)
    {
        dal.addStudentToDB(first, last, user, id, mail, occ);
    }

    public boolean checkIfUserNameExist( String id)
    {
       return dal.checkIfUserExist(id);
    }
}
