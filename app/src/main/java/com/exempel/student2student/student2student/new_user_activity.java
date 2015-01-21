package com.exempel.student2student.student2student;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;


public class new_user_activity extends Activity {

    private EditText firstName;
    private EditText lastName;
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
        ID = (EditText) findViewById(R.id.IDEditText);
        e_mail = (EditText) findViewById(R.id.mailEditText);
        occupation = (Spinner) findViewById(R.id.occupation_spinner);
        teach = (CheckBox) findViewById(R.id.teachBox);
        bl = new BL(this);
    }

    public void create_new_user(View v)
    {
//        if(teach.isChecked())
//        {
//
//        }
//        else
//        {
//
//        }
        bl.writeToDB(firstName.getText().toString(),lastName.getText().toString(),Integer.parseInt(ID.getText().toString()),e_mail.getText().toString(),occupation.getSelectedItem().toString());
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
