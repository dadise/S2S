package com.exempel.student2student.student2student;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Time;

import static java.lang.String.*;


/**
 * Created by ��� on 05/05/2015.
 */
public class dalServer extends AsyncTask<String,String,String>
{
    private final Activity activity;
    private final Context context;
    private int branchId;

    String firstName;
    String lastName;

    String DB_URL = "jdbc:mysql://daec1757-1a01-4d0a-8591-a486012c04b6.mysql.sequelizer.com:3306/dbdaec17571a014d0a8591a486012c04b6";
    String USER = "dgvvjhbylkbkshvw";
    String PASS = "PDbbVM3Q8qCqqLwgnVcYCm5rabBu55YnzvJKdwvCuh2eXVQWb6m6pbwCHSaUkFUd";

    public dalServer(Activity activity, Context context, int branchId)
    {
        this.activity = activity;
        this.context=context;
        this.branchId=branchId;
        firstName = "";
        lastName = "";
//        currentQueueDisplay = (TextView) activity.findViewById(R.id.currenQueueDisplay);
//        averageTextView = (TextView) activity.findViewById(R.id.timeTextView);
    }

    @Override
    protected String doInBackground(String... params)
    {
        String occ = "תוכנה";
        String response ="";
        try {
            boolean running = true;
            Class.forName("com.mysql.jdbc.Driver");
//            .newInstance();
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            String result = "\nDatabase connection success\n";

            Statement st = con.createStatement();
            if(st != null)
            {
                Log.i("good"," statement "+con);
                Log.i("good"," statement "+st);
            }
            String query = "SELECT id FROM  c ";
//            ResultSet rs = st.executeQuery("SELECT courseName FROM courseTable");

            ResultSet rs = st.executeQuery(query);
            Log.i("TAG"," Problem "+rs.next());
            while (rs.next())
            {
//                Log.i("TAG"," Problem "+rs.isFirst());
//                Log.i("rs.get"," "+rs.getString(1));
                System.out.println(rs.getString(1) + " asdadsasdasda");
//                Log.i("sss","asas");
            }
            con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return response;
    }




    protected void onProgressUpdate(Integer... progress) {
        Log.d("TAG6","its fine!!");
//        currentQueueDisplay.setText(Integer.toString(progress[0]));
        //averageTextView.setText(progress[1]);
    }


}
