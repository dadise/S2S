package com.exempel.student2student.student2student;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MyActivity extends Activity {

    private SharedPreferences sp;
    private Boolean DBCreated;
    private Boolean update;
    private BL bl;

//    DBColumns db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        sp = getPreferences(MODE_PRIVATE);
        DBCreated = sp.getBoolean("created", false);
//        update = sp.getBoolean("update" , false);
        bl = new BL(this);

        initDB();
    }

    @Override
    public void onPause()
    {
        super.onPause();
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("created", DBCreated);
        editor.commit();
    }

    public void new_user(View v)
    {

        Intent intent = new Intent(this,new_user_activity.class);
        startActivity(intent);
    }

    public void exist_user(View v)
    {
        Intent intent = new Intent(this,exist_student.class);
        startActivity(intent);
    }

    public void newUser(View v)
    {
//        Intent intent = new Intent(this,new_user_activity.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
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

    private void initDB()
    {
        Log.i("TAG","1");
        if(!DBCreated) {
            Log.i("TAG","2");
            initTables intables = new initTables(this);
            intables.initAllTables();
            DBCreated = true;
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean("created", DBCreated);
            editor.commit();
        }

    }
}
