package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

/**
 * This activity allows us to roll dice and view activity on screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        val dice=Dice(6)// instantiating the dice here instead of instantiating inside fn
        rollButton.setOnClickListener { rollDice(dice) }
    }

    /**
     * Roll the dice and update the screen with result
     */
    private fun rollDice(dice: Dice) {
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = dice.roll().toString()
    }
}

/**
 * This is the dice class encapsulating an abstract Dice
 */
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random();
    }
}