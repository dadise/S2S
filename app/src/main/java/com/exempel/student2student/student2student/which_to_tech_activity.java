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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;


public class which_to_tech_activity extends Activity
{
    private ListView teachList;
    private BL bl;
    private Cursor c;
    dalServer ds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_which_to_tech_activity);

        teachList = (ListView) findViewById(R.id.teachListView);
        bl = new BL(this);
        List<String> courseList = bl.readCourseTable();
        List<String> studentList=bl.student();

        ds = new dalServer(this,this,getTaskId());
        ds.execute();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,courseList);
        teachList.setAdapter(adapter);


//        teachList.setOnItemClickListener(new onItemClickListener()
//        {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,int position,long id)
//            {
//                String item = ((TextView)view).getText().toString();
//                Toast.makeText(getBaseContext(),item,Toast.LENGTH_LONG).show();
//
//            }
//        });

//        if(courseList != null)
//        {
//            myAdapter myAd = new myAdapter(this,courseList);
//            teachList.setAdapter(myAd);
//        }
    }

//    public void moveToWhichToTeach(View view)
//    {
//        String
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.which_to_tech_activity, menu);
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

    public void toLearnActivity(View view)
    {

            Intent intent = new Intent(this, which_to_learn_activity.class);
            startActivity(intent);
        

    }

    public void toNewUserActivity(View view)
    {
        Intent intent = new Intent(this,new_user_activity.class);
        startActivity(intent);
    }
}
