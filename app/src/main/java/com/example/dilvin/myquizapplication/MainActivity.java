package com.example.dilvin.myquizapplication;
/*Dilvin Şeyma ARVAS
14011607
Prg: Bu activityde kullanıcı bilgileri alınıp shredPreferences dosyası olusturuluyor ve startTest ile soruların oldugu activity e geçis saglanıyor
*/
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText surname;
   private  EditText birthdate;
   Intent intent;
   String userName="";
    String  userSurname="";
    String userBirtdate="";


//start quiz butonuna bastıktan sonra yapılacak islemler
    public void startTest(View view){
        //edit text içindeki degerleri alıp sharedPreferences'a kayıt edecek
      userName=userName+name.getText().toString()+"\n";
        SavePreferences("userNames",userName);
        userSurname=userSurname+surname.getText().toString()+"\n";
        SavePreferences("userSurnames",userSurname);
        userBirtdate=userBirtdate+birthdate.getText().toString()+"\n";
      // kayır isleminden sonra test sorularına geçecek
       intent=new Intent(this,QuizActivity.class);
        startActivity(intent);

    }
    //kaydedilen kullanıcı bilgilerini gösterecek
    public void showResults(View view){

        intent=new Intent(this,ResultActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


String str=LoadPreferences("userNames");
userName=userName+str;

        name=(EditText)findViewById(R.id.et_name);
        surname=(EditText)findViewById(R.id.et_surname);
    birthdate=(EditText)findViewById(R.id.et_birthdate);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    private void SavePreferences(String key, String value) {
        // shared preferences ile mydocs adı altında bir tane xml dosya açacak
        SharedPreferences sharedPreferences = getSharedPreferences("mydocs",
                MODE_PRIVATE);
        // dosyaya yazmaya yardımcı olacak editor
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // editör aracılığı ile key value değerleri yazılacak

        editor.putString(key, value);

        //bilgileri kaydedecek
        editor.commit();
    }
    private String LoadPreferences(String key) {
        //oluşturulan sharedPreferences çagırılacak
        SharedPreferences sharedPreferences = getSharedPreferences("mydocs",
                MODE_PRIVATE);

        String str = sharedPreferences.getString(key, "");
        return str;
    }
}
