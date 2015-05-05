package com.exempel.student2student.student2student;

import android.content.Context;

public class initTables
{
    private BL bl;

    public initTables(Context context)
    {
        bl = new BL(context);
    }

    public void initAllTables()
    {
        initCourseTable();
    }

    private void initCourseTable()
    {
        bl.addCorseToDB("אלגוריתמיקה",123,"תוכנה");
        bl.addCorseToDB("פיסיקה",6577,"אלקטרוניקה");
        bl.addCorseToDB("חדוא",9876,"תוכנה");

    }
}
