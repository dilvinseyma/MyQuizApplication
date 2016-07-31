package com.example.dilvin.myquizapplication;

import android.app.Activity;

/**
 * Created by Dilvin on 17.11.2015.
 */
public class Question extends Activity {
  private int question,optA,optB,optC,optD,answer;

    public Question(int question, int optA, int optB, int optC, int optD, int answer) {
        this.question = question;
        this.optA = optA;
        this.optB = optB;
        this.optC = optC;
        this.optD = optD;
        this.answer = answer;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public int getOptA() {
        return optA;
    }

    public void setOptA(int optA) {
        this.optA = optA;
    }

    public int getOptB() {
        return optB;
    }

    public void setOptB(int optB) {
        this.optB = optB;
    }

    public int getOptC() {
        return optC;
    }

    public void setOptC(int optC) {
        this.optC = optC;
    }

    public int getOptD() {
        return optD;
    }

    public void setOptD(int optD) {
        this.optD = optD;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
