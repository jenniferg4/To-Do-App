package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    static class Demo{
        private String name;
        private float grade;
        Demo(){

        }
        Demo(String name, float grade){
            this.name = name;
            this.grade = grade;
        }
    }

}