package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val b11 = findViewById<ImageButton>(R.id.button_1_1)
        val b12 = findViewById<ImageButton>(R.id.button_1_2)
        val b13 = findViewById<ImageButton>(R.id.button_1_3)
        val b21 = findViewById<ImageButton>(R.id.button_2_1)
        val b22 = findViewById<ImageButton>(R.id.button_2_2)
        val b23 = findViewById<ImageButton>(R.id.button_2_3)
        val b31 = findViewById<ImageButton>(R.id.button_3_1)
        val b32 = findViewById<ImageButton>(R.id.button_3_2)
        val b33 = findViewById<ImageButton>(R.id.button_3_3)
        val xImage = R.drawable.x
        val oImage = R.drawable.o
        var firstPlayer = true

        fun setLetter(b: ImageButton){
            if(firstPlayer) b.setImageResource(xImage)
            else b.setImageResource(oImage)
            firstPlayer = !firstPlayer
        }
        b11.setOnClickListener(){
            setLetter(b11)
        }

    }

}