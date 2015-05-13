package com.exempel.student2student.student2student;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class exist_student extends Activity
{
    private EditText userName;
    private EditText ID;
    private CheckBox updateCheckBox;
    private BL bl;
    private boolean update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exist_student);

        update = false;
        userName = (EditText) findViewById(R.id.nameEditText);
        ID = (EditText) findViewById(R.id.idEditText);
        updateCheckBox = (CheckBox)findViewById(R.id.update_checkBox);

        bl = new BL(this);
        Log.i("123","123");
    }

    public void go_to_courses_page(View v)
    {
        Log.i("existActivity", "123");
        SharedPreferences sp = getSharedPreferences("myData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("firstName", bl.getFirstNameByID(ID.getText().toString()));
        editor.putString("lastName", bl.getLastNameByID(ID.getText().toString()));
        editor.putString("userName", userName.getText().toString());
        editor.putString("ID", ID.getText().toString());
        editor.putString("email", bl.getEmaleByID(ID.getText().toString()));
        editor.putString("occupation", bl.getOccupationNameByID(ID.getText().toString()));
        editor.putBoolean("update", update);

        editor.commit();

        if(bl.checkIfUserNameAndIDExist(userName.getText().toString(),ID.getText().toString()))
            Toast.makeText(this,"what",Toast.LENGTH_LONG).show();

        if (updateCheckBox.isChecked())
        {
            if(bl.checkIfUserNameAndIDExist(userName.getText().toString(),ID.getText().toString()))
            {
                editor.putBoolean("update", true);
                editor.commit();

                Intent intent = new Intent(this, new_user_activity.class);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(this,"user name or id are not correct!!",Toast.LENGTH_LONG).show();
            }
        }
        else
        {
           Intent intent = new Intent(this, courses_page.class);
           startActivity(intent);
        }

    }

    public void back_to_main_activity(View v)
    {
        Intent intent = new Intent(this,MyActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.exist_student, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
