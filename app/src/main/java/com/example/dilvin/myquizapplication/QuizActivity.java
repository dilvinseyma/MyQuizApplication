package com.example.dilvin.myquizapplication;
/*Dilvin Şeyma ARVAS
14011607
Prg: Bu activityde sorular gösteriliyor ve cevapların dogrulugu karsılastırılıp score degeri artırılıyor
*/
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity {

    TextView tvQuestion;
    RadioButton rb_a, rb_b, rb_c,rb_d;
    Button btnNext;
    RadioGroup grp;
    RadioButton answer;
    String currentAnswer,ans,strScore="";
int score=0;
int mCurrentIndex=0; //QuestionBank tan cekilecek soru indexi
    int count=-1;// cevaplar karsılastırılırken kullanılacak sayac
     private Question[] mQuestionBank = new Question[]{
            new Question (R.string.q1,R.string.q1A,R.string.q1B,R.string.q1C,R.string.q1D,R.string.ansQ1),
             new Question (R.string.q2,R.string.q2A,R.string.q2B,R.string.q2C,R.string.q2D,R.string.ansQ2),
             new Question (R.string.q3,R.string.q3A,R.string.q3B,R.string.q3C,R.string.q3D,R.string.ansQ3),
             new Question (R.string.q4,R.string.q4A,R.string.q4B,R.string.q4C,R.string.q4D,R.string.ansQ4),
             new Question (R.string.q5,R.string.q5A,R.string.q5B,R.string.q5C,R.string.q5D,R.string.ansQ5),
             new Question (R.string.q6,R.string.q6A,R.string.q6B,R.string.q6C,R.string.q6D,R.string.ansQ6),
             new Question (R.string.q7,R.string.q7A,R.string.q7B,R.string.q7C,R.string.q7D,R.string.ansQ7),
             new Question (R.string.q8,R.string.q8A,R.string.q8B,R.string.q8C,R.string.q8D,R.string.ansQ8),
             new Question (R.string.q9,R.string.q9A,R.string.q9B,R.string.q9C,R.string.q9D,R.string.ansQ9),
             new Question (R.string.q10,R.string.q10A,R.string.q10B,R.string.q10C,R.string.q10D,R.string.ansQ10)

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        //activity ilk açıldıgında ilk soru gosterilecek
        tvQuestion=(TextView)findViewById(R.id.tv_question);
        rb_a=(RadioButton)findViewById(R.id.radioA);
        rb_b=(RadioButton)findViewById(R.id.radioB);
        rb_c=(RadioButton)findViewById(R.id.radioC);
        rb_d=(RadioButton)findViewById(R.id.radioD);
        btnNext=(Button)findViewById(R.id.btn_Next);

        tvQuestion.setText( mQuestionBank[0].getQuestion());
        rb_a.setText(mQuestionBank[0].getOptA());
        rb_b.setText(mQuestionBank[0].getOptB());
        rb_c.setText(mQuestionBank[0].getOptC());
        rb_d.setText(mQuestionBank[0].getOptD());
//next butonu ile sorular sırasıyla goruntulenecek
       btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grp=(RadioGroup)findViewById(R.id.rg_options);
                answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
                //seçilen şık içerigi
                ans=answer.getText().toString();
                count++;
                mCurrentIndex++;
                if(mCurrentIndex<10){

                //count = (count + 1) % mQuestionBank.length;

                //mCurrentIndex   = (mCurrentIndex+1)%mQuestionBank.length;
                currentAnswer = getResources().getString(mQuestionBank[count].getAnswer());
                // secilen şık olması gereken şık ile aynı mı konrolu yapılacak
                   if (ans.equals(currentAnswer)) {
                       // secilen şık dogru ise mesaj gosterilecek ve score arttırılacak
                       score++;
                       Toast toast = Toast.makeText(getApplicationContext(), " CORRECT ANSWER ! ", Toast.LENGTH_SHORT);
                       toast.show();
                   }
                   else {
                       Toast toast = Toast.makeText(getApplicationContext(), " WRONG ANSWER ", Toast.LENGTH_SHORT);
                       toast.show();
                   }

                       int question = mQuestionBank[mCurrentIndex].getQuestion();
                       tvQuestion.setText(question);
                       rb_a.setText(mQuestionBank[mCurrentIndex].getOptA());
                       rb_b.setText(mQuestionBank[mCurrentIndex].getOptB());
                       rb_c.setText(mQuestionBank[mCurrentIndex].getOptC());
                       rb_d.setText(mQuestionBank[mCurrentIndex].getOptD());

                   }
                else{
                    SharedPreferences sharedPreferences = getSharedPreferences("mydocs",
                            MODE_PRIVATE);
                    // dosyaya yazmaya yardımcı olacak editor
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    // editör aracılığı ile key value değerleri yazılacak
strScore=strScore+Integer.toString(score)+"\n";
                    editor.putString("usersScores",strScore);

                    //bilgileri kaydedecek
                    editor.commit();
                    Toast toast = Toast.makeText(getApplicationContext(), "YOUR SCORE IS "+score, Toast.LENGTH_SHORT);
                    toast.show();
                    Intent intent=new Intent(QuizActivity.this,ResultActivity.class);
                    startActivity(intent);



                   }

               }

        });

    }
    public void restartTest(View view){
        Intent intent=new Intent(QuizActivity.this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
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
