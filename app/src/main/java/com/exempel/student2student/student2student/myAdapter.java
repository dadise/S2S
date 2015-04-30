package com.exempel.student2student.student2student;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;

public class myAdapter extends CursorAdapter
{
    LayoutInflater inflater;

    public myAdapter(Context context, Cursor cursor)
    {
        super(context,cursor);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void bindView(View view,Context context,Cursor cursor)
    {
        TextView courseName = (TextView)view.findViewById(R.id.courseName);
        TextView courseID = (TextView)view.findViewById(R.id.courseID);

        courseName.setText(cursor.getString(1));
        courseID.setText(cursor.getString(0));

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent)
    {
        return inflater.inflate(R.layout.activity_line,parent,false);
    }
}
