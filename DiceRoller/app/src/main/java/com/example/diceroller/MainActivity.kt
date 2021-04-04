package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

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
            rollDice(dice0, R.id.imageView01)
            rollDice(dice1, R.id.imageView02)
        }
        // Initial roll so that we don't start with a blank screen
        rollDice(dice0, R.id.imageView01)
        rollDice(dice1, R.id.imageView02)
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice(dice: Dice, imageView: Int) {
        // Create new Dice object with 6 sides and roll the dice
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(imageView)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
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