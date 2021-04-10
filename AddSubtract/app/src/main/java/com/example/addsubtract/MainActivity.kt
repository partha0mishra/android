package com.example.addsubtract

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // First thing first, find the button
        val nextButton: Button=findViewById(R.id.buttonNext)
        nextButton.setOnClickListener { populate() }
        // Populate numbers on the screen for the first time
        populate()
    }
    fun populate(){
        // starting with 3 random numbers
        val a=(1..10).random() // looks better to start from 1
        val b=(0..10).random()
        val c=(0..10).random()
        // Getting the TextView elements
        val num01: TextView = findViewById(R.id.textView1)
        val num02: TextView = findViewById(R.id.textView2)
        val num03: TextView = findViewById(R.id.textView3)
        val ops01: TextView = findViewById(R.id.textViewOps1)
        val ops02: TextView = findViewById(R.id.textViewOps2)
        // Assignation
        // numbers are straight-forward
        // if a > b, do a - b else a + b. This value is in tmp
        // if tmp > c, do tmp - c else tmp + c
        num01.setText(a.toString())
        num02.setText(b.toString())
        num03.setText(c.toString())
        var tmp=a-b
        if(tmp < 0){
            ops01.setText("+")
            tmp=a+b
        }else{
            ops01.setText("-")
        }
        var result=tmp - c
        if(result < 0){
            ops02.setText("+")
            result=tmp + c
        }else{
            ops02.setText("-")
        }
    }
}