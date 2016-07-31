package com.example.dilvin.myquizapplication;
/*Dilvin Şeyma ARVAS
14011607
Prg: Bu activityde sharedpreferences dosyasından keyler çekilip text viewlarda gosterilecek

*/
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {


    private TextView usersName;
    private TextView usersSurname;
    private TextView usersScore;
    String strName,strSurname,strScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

       Intent intent=getIntent();
        usersName = (TextView) findViewById(R.id.usersName);
        usersSurname=(TextView)findViewById(R.id.usersSurname);
        usersScore=(TextView)findViewById(R.id.usersScore);
        SharedPreferences sharedPreferences = getSharedPreferences("mydocs",
                MODE_PRIVATE);
        //key değerini vererek value değerini alacak
       strName= sharedPreferences.getString("userNames"," ");
        strSurname=sharedPreferences.getString("userSurnames"," ");
        strScore=sharedPreferences.getString("userScores"," ");

        usersName.setText(strName);
        usersSurname.setText(strSurname);
        usersScore.setText(strScore);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
