package com.exempel.student2student.student2student;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;


public class new_user_activity extends Activity {


    private EditText firstName;
    private EditText lastName;
    private EditText userName;
    private EditText ID;
    private EditText e_mail;
    private Spinner occupation;
    private CheckBox teach;

    private BL bl;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_activity);

        firstName = (EditText) findViewById(R.id.nameEditText);
        lastName = (EditText) findViewById(R.id.lastEditText);
        userName = (EditText) findViewById(R.id.userNameEdText);
        ID = (EditText) findViewById(R.id.IDEditText);
        e_mail = (EditText) findViewById(R.id.mailEditText);
        occupation = (Spinner) findViewById(R.id.line_of_business_spinner);
        teach = (CheckBox) findViewById(R.id.teachBox);

        bl = new BL(this);
    }

    public void create_new_user(View v)
    {
        SharedPreferences sp = getSharedPreferences("myData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("firstName",firstName.getText().toString());
        editor.putString("lastName",lastName.getText().toString());
        editor.putString("userName",userName.getText().toString());
        editor.putString("ID",ID.getText().toString());
        editor.putString("email",e_mail.getText().toString());
        editor.putString("occupation",occupation.toString());
//        editor.putBoolean("isTeach",false);
        editor.commit();
        if(bl.checkIfUserNameExist(ID.getText().toString()))
        {
             Toast.makeText(this,"user allready exist in the system!",Toast.LENGTH_LONG).show();
        }
        else
        {
            if (teach.isChecked())
            {
                editor.putBoolean("techCheck",true);
                editor.commit();
//
                bl.addStudentToDB(firstName.getText().toString(), lastName.getText().toString(), userName.getText().toString(), Integer.parseInt(ID.getText().toString()), e_mail.getText().toString(), occupation.getSelectedItem().toString());
//                List<String> c = bl.whichCourseByLineOfBusiness(occupation.toString());
//                while(c != null)
//                {
//                    Toast.makeText(this,c.get(0).toString()+" hruhfruhfruhfurhfruhfru",Toast.LENGTH_LONG).show();
//                }
                Intent intent = new Intent(this, which_to_tech_activity.class);
                startActivity(intent);
            } else
            {
                editor.putBoolean("techCheck",false);
                editor.commit();

                Intent intent = new Intent(this, which_to_learn_activity.class);
                startActivity(intent);
            }

        }
    }

    public void back_to_main_activity(View v)
    {

        Intent intent = new Intent(this,MyActivity.class);
        startActivity(intent);
    }

    public void go_to_policy(View v)
    {
        Intent intent = new Intent(this,policy.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.new_user_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
