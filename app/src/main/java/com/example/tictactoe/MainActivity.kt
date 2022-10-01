package com.example.tictactoe

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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
        val buttonList: List<ImageButton> = listOf(b11,b12,b13,b21,b22,b23,b31,b32,b33)
        val clearBoardButton = findViewById<Button>(R.id.clear_board_button)
        val noImage = R.drawable.default_button_image
        val xImage = R.drawable.x
        val oImage = R.drawable.o
        var firstPlayer = true

        fun clearBoard() {
            for(b in buttonList){
                b.setImageResource(noImage)
                b.contentDescription = "unclicked"
            }
        }

        fun isEmpty(b:ImageButton):Boolean {
            if (b.contentDescription == "unclicked") return true
            return false
        }


        fun setLetter(b: ImageButton){
            if(isEmpty(b)) {
                if (firstPlayer) b.setImageResource(xImage)
                else b.setImageResource(oImage)
                firstPlayer = !firstPlayer
                b.contentDescription = "clicked"
            }
        }

        b11.setOnClickListener {
            setLetter(b11)
        }
        b12.setOnClickListener {
            setLetter(b12)
        }
        b13.setOnClickListener {
            setLetter(b13)
        }
        b21.setOnClickListener {
            setLetter(b21)
        }
        b22.setOnClickListener{
            setLetter(b22)
        }
        b23.setOnClickListener{
            setLetter(b23)
        }
        b31.setOnClickListener{
            setLetter(b31)
        }
        b32.setOnClickListener{
            setLetter(b32)
        }
        b33.setOnClickListener{
            setLetter(b33)
        }
        clearBoardButton.setOnClickListener{
            clearBoard()
        }



    }

}