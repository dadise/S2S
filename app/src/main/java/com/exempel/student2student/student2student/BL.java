package com.exempel.student2student.student2student;

import android.content.Context;
import android.database.Cursor;

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

    public Cursor readFromDB()
    {
        return dal.readFromDB();
    }

    public void writeToDB(String first,String last,int id,String mail,String occ)
    {
        dal.writeToDB(first,last,id,mail,occ);
    }
}
