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
        // instantiating the dice here instead of instantiating inside fn
        val dice0=Dice(6)
        val dice1=Dice(6)
        rollButton.setOnClickListener {
            rollDice(dice0, R.id.textView0)
            rollDice(dice1, R.id.textView)
        }
    }

    /**
     * Roll the dice and update the screen with result
     */
    private fun rollDice(dice: Dice, elementId: Int) {
        val resultTextView: TextView= findViewById(elementId)
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